package com.salesianostriana.edu.skillhub.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"coursesAsInstructor", "enrollments", "reviews"})
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private String email;

    @OneToMany(mappedBy = "instructor")
    private List<Course> coursesAsInstructor = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Enrollment> enrollments = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Review> reviews = new ArrayList<>();

}
