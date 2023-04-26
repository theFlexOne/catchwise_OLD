package com.flexone.fishing_db.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bait {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String type;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String imageUrl;

    @ManyToMany(mappedBy = "baitList", fetch = FetchType.EAGER)
    private Set<Fish> fish = new HashSet<>();

}
