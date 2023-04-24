package com.flexone.fishing_db.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.Text;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @ManyToMany(mappedBy = "fish")
    private List<Lake> lakes;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "fish_bait",
            joinColumns = @JoinColumn(name = "fish_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "bait_id", referencedColumnName = "id"))
    private List<Bait> bait;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "fish_habitat",
            joinColumns = @JoinColumn(name = "fish_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "habitat_id", referencedColumnName = "id"))
    private List<Habitat> habitat;


}
