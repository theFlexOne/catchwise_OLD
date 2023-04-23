package com.flexone.fishing_db.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lake {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, name = "lake_id")
    private Long lakeId;

    private String county;

    @Column(name = "county_id")
    private Integer countyId;

    private String notes;

    @ManyToMany(mappedBy = "lakes", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Fish> fishes = new ArrayList<>();
}
