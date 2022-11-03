package com.revashare.theatmbackend.controllers;

import com.revashare.theatmbackend.services.TransService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransController {
    private final TransService transService;
}
