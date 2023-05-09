package main.java.com.flexone.fishservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FishRequest {

    private String name;
    private String description;
    private String identification;

}
