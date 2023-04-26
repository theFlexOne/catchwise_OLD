package com.flexone.fishing_db.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"id"})
public class Fish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String imageUrl;

    @Column(columnDefinition = "TEXT")
    private String identification;

    @ManyToMany(mappedBy = "fish", fetch = FetchType.EAGER)
    private Set<Lake> lakes = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "fish_bait",
            joinColumns = @JoinColumn(name = "fish_id"),
            inverseJoinColumns = @JoinColumn(name = "bait_id")
    )
    private Set<Bait> baitList = new HashSet<>();


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

    public Fish assignToLake(Lake lake) {
        this.lakes.add(lake);
        return this;
    }

}
