package com.flexone.fishing_db.controllers;

import com.flexone.fishing_db.domain.Fish;
import com.flexone.fishing_db.services.FishService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/fish")
public class FishRest {

    final FishService fishService;

    public FishRest(FishService fishService) {
        this.fishService = fishService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Fish>> index() {
        return ResponseEntity.ok(fishService.findAll());
    }

}
