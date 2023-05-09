package com.flexone.lakeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LakeRequest {

    private Long id;
    private String name;
    private String notes;
    private String county;

}
