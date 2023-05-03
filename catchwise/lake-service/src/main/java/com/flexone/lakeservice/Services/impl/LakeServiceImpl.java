package com.flexone.lakeservice.Services.impl;

import com.flexone.lakeservice.Services.LakeService;
import com.flexone.lakeservice.domain.Lake;
import com.flexone.lakeservice.repositories.LakeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LakeServiceImpl implements LakeService {

    final LakeRepository lakeRepository;
    final WebClient webClient;


    @Override
    public List<Lake> getAllLakes() {
        return (List<Lake>) lakeRepository.findAll();
    }

    @Override
    public Lake createLake(Lake lake) {
        return lakeRepository.save(lake);
    }

    @Override
    public Lake addFishToLake(Long lakeId, Long fishId) {
        Lake lake = lakeRepository.findById(lakeId).orElseThrow();
        String isValidFishId = webClient.get()
                .uri("http://localhost:8081/api/fish/" + fishId)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        if (isValidFishId != null) {
            lake.getFishIds().add(fishId);
            lakeRepository.save(lake);
        } else {
            throw new IllegalArgumentException("Invalid fish id");
        }

        return lake;
    }

}
