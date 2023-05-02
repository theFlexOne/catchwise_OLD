package com.flexone.lakeservice.Services.impl;

import com.flexone.lakeservice.Services.LakeService;
import com.flexone.lakeservice.domain.Lake;
import com.flexone.lakeservice.repositories.LakeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LakeServiceImpl implements LakeService {

    final LakeRepository lakeRepository;


    @Override
    public List<Lake> getAllLakes() {
        return (List<Lake>) lakeRepository.findAll();
    }

    @Override
    public Lake createLake(Lake lake) {
        return lakeRepository.save(lake);
    }

}
