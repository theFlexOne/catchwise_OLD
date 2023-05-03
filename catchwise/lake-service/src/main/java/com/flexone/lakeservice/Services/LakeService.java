package com.flexone.lakeservice.Services;

import com.flexone.lakeservice.domain.Lake;

import java.util.List;

public interface LakeService {

    List<Lake> getAllLakes();

    Lake createLake(Lake lake);
    Lake addFishToLake(Long lakeId, Long fishId);
}
