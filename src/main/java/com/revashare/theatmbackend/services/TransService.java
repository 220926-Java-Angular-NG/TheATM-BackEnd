package com.revashare.theatmbackend.services;

import com.revashare.theatmbackend.repositories.TransRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransService {
    private final TransRepo transRepo;
}
