package com.flexone.lakeservice.repositories.controllers;

import com.flexone.lakeservice.Services.LakeService;
import com.flexone.lakeservice.domain.Lake;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lakes")
public class LakeController {

    final LakeService lakeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Lake> getAllLakes() {
        return lakeService.getAllLakes();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Lake createLake(@RequestBody Lake lake) {
        return lakeService.createLake(lake);
    }
}
