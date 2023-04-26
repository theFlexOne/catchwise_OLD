package com.flexone.fishing_db.bootstrap;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flexone.fishing_db.domain.Fish;
import com.flexone.fishing_db.domain.Image;
import com.flexone.fishing_db.domain.Lake;
import com.flexone.fishing_db.domain.Rod;
import com.flexone.fishing_db.services.FishService;
import com.flexone.fishing_db.services.LakeService;
import com.flexone.fishing_db.services.RodService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {

    final FishService fishService;
    final LakeService lakeService;
    final RodService rodService;

    public SeedData(FishService fishService, LakeService lakeService, RodService rodService) {
        this.fishService = fishService;
        this.lakeService = lakeService;
        this.rodService = rodService;
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
                newFish.setIdentification(fish.hasNonNull("identification") ? fish.get("identification").asText() : "");
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

        try {
            FileReader fr = new FileReader("src/main/resources/rodData.json");
            JsonNode rootNode = mapper.readTree(fr);
            for (JsonNode rod : rootNode) {
                Rod newRod = new Rod();
                newRod.setName(rod.hasNonNull("name") ? rod.get("name").asText() : "");
                newRod.setDescription(rod.hasNonNull("description") ? rod.get("description").asText() : "");
                List<Image> images = new ArrayList<>();
                for (JsonNode image : rod.get("images")) {
                    Image newImage = new Image();
                    newImage.setUrl(image.hasNonNull("url") ? image.get("url").asText() : "");
                    images.add(newImage);
                }
                newRod.setImages(images);
                rodService.save(newRod);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            FileReader fr = new FileReader("src/main/resources/lakeData.json");
            JsonNode rootNode = mapper.readTree(fr);
            List<Fish> fishList = fishService.findAll();
            for (Fish fish : fishList) {
                String name = fish.getName().toLowerCase();
                for (JsonNode lake : rootNode) {
                    if (lake.hasNonNull("fishSpecies")) {
                        for (JsonNode fishNode : lake.get("fishSpecies")) {
                            if (fishNode.asText().toLowerCase().contains(name)) {
                                Lake newLake = lakeService.findByLakeId(lake.get("id").asLong());
                                newLake.addFish(fish);
                                lakeService.save(newLake);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
