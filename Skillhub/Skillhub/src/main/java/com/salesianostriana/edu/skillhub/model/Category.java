package com.salesianostriana.edu.skillhub.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"courses"})
@Entity
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private String descripcion;

    @ManyToMany(mappedBy = "categories")
    private List<Course> courses = new ArrayList<>();
}
