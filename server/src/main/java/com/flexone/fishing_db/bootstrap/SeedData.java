package com.flexone.fishing_db.bootstrap;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flexone.fishing_db.domain.Fish;
import com.flexone.fishing_db.domain.Lake;
import com.flexone.fishing_db.services.FishService;
import com.flexone.fishing_db.services.LakeService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {

    final FishService fishService;
    final LakeService lakeService;

    public SeedData(FishService fishService, LakeService lakeService) {
        this.fishService = fishService;
        this.lakeService = lakeService;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            FileReader fr = new FileReader("src/main/resources/fishData.json");
            JsonNode rootNode = mapper.readTree(fr);
            for (JsonNode fish : rootNode) {
                Fish newFish = new Fish();
                newFish.setName(fish.get("name").asText());
                newFish.setDescription(fish.get("description").asText());
                newFish.setImageUrl(fish.get("imageUrl").asText());
                fishService.save(newFish);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            FileReader fr = new FileReader("src/main/resources/lakeData.json");
            JsonNode rootNode = mapper.readTree(fr);
            for (JsonNode lake : rootNode) {
                Lake newLake = new Lake();
                newLake.setName(lake.hasNonNull("name") ? lake.get("name").asText() : "");

                newLake.setLakeId(lake.hasNonNull("id") ? lake.get("id").asLong() : 0);
                newLake.setCounty(lake.hasNonNull("county") ? lake.get("county").asText() : "");
                newLake.setCountyId(lake.hasNonNull("county_id") ? lake.get("county_id").asInt() : 0);
                lakeService.save(newLake);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
