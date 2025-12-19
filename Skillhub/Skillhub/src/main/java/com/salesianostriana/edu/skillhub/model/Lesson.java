package com.salesianostriana.edu.skillhub.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"course"})
@Entity
public class Lesson {

    @Id
    @GeneratedValue
    private Long id;

    private String titulo;

    @Column(length = 2000)
    private String contenido;

    private Integer duracionMinutos;

    private Integer orderIndex;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;
}
