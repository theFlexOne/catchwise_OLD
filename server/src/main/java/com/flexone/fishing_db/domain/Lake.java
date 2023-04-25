package com.flexone.fishing_db.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    private String name;

    @Column(name = "county_id")
    private Integer countyId;

    private String notes;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "fish_lakes",
            joinColumns = @JoinColumn(name = "lake_id", referencedColumnName = "id", nullable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "fish_id", referencedColumnName = "id", nullable = false, updatable = false))
    private Set<Fish> fish = new HashSet<>();

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "habitat_lakes",
            joinColumns = @JoinColumn(name = "lake_id", referencedColumnName = "id", nullable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "habitat_id", referencedColumnName = "id", nullable = false, updatable = false))
    private Set<Habitat> habitat = new HashSet<>();
}
