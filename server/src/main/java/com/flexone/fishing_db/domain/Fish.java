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

    @ManyToMany(mappedBy = "fish", fetch = FetchType.EAGER,  cascade = CascadeType.PERSIST)
    private Set<Lake> lakes = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "fish_bait",
            joinColumns = @JoinColumn(name = "fish_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "bait_id", referencedColumnName = "id"))
    private List<Bait> bait = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "fish_habitat",
            joinColumns = @JoinColumn(name = "fish_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "habitat_id", referencedColumnName = "id"))
    private List<Habitat> habitat = new ArrayList<>();

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


}
