package com.flexone.fishing_db.controllers;

import com.flexone.fishing_db.domain.Lake;
import com.flexone.fishing_db.services.LakeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/lake")
public class LakeRest {

    final LakeService lakeService;

    public LakeRest(LakeService lakeService) {
        this.lakeService = lakeService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Lake>> index() {
        return ResponseEntity.ok(lakeService.findAll());
    }


}
