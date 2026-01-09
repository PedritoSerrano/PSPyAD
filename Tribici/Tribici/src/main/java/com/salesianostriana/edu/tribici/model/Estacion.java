package com.salesianostriana.edu.tribici.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "estacion")
public class Estacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "estacion_id")
    private Long id;

    @Column(name = "numero")
    private int numero;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "coordenadas")
    private String coordenadas;
    @Column(name = "capacidad")
    private int capacidad;

    @Builder.Default
    @OneToMany(mappedBy = "estacion")
    private List<Bicicleta> bicicletas = new ArrayList<>();

    public void addBicicleta(Bicicleta b) {
        bicicletas.add(b);
        b.setEstacion(this);
    }

    public void removeBicicleta(Bicicleta b) {
        bicicletas.remove(b);
        b.setEstacion(null);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Estacion estacion = (Estacion) o;
        return getId() != null && Objects.equals(getId(), estacion.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}

