package com.revashare.theatmbackend.Util;

import com.revashare.theatmbackend.models.User;
import com.revashare.theatmbackend.services.AuthService;
import com.revashare.theatmbackend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class AuthFilter extends OncePerRequestFilter {
    private final AuthService authService;
    @Lazy
    private final UserService userService;

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");
        String token = null;
        String email = null;

        if(authorizationHeader != null){
            token = authorizationHeader.substring(7);
            // figure out who the user is that is requesting access to a resource
            email = authService.extractEmail(token);
        }

        if(email != null && SecurityContextHolder.getContext().getAuthentication() == null){
            // load the user from the database
            User user = (User) userService.loadUserByEmail(email);

            // if the token is valid
            if(authService.validateToken(token, user)){
                // update the current security context (which only exists for this request) so that they can move forward
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(
                                user,
                                null,
                                user.getAuthorities()
                        );
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}
