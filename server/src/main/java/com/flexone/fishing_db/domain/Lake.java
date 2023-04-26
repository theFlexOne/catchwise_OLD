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

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "lake_fish",
            joinColumns = @JoinColumn(name = "lake_id"),
            inverseJoinColumns = @JoinColumn(name = "fish_id")
    )
    private Set<Fish> fish = new HashSet<>();

    // region -> createdAt & modifiedAt
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date modifiedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new java.util.Date();
    }

    @PreUpdate
    protected void onUpdate() {
        modifiedAt = new java.util.Date();
    }
    // endregion

    public Lake addFish(Fish fish) {
        this.fish.add(fish);
        return this;
    }

}
