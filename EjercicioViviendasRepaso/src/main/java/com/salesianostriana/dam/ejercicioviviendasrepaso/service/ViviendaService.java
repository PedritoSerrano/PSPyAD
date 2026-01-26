package com.salesianostriana.dam.ejercicioviviendasrepaso.service;

import com.salesianostriana.dam.ejercicioviviendasrepaso.dto.FilterDto;
import com.salesianostriana.dam.ejercicioviviendasrepaso.model.EstadoVivienda;
import com.salesianostriana.dam.ejercicioviviendasrepaso.model.TipoVivienda;
import com.salesianostriana.dam.ejercicioviviendasrepaso.model.Vivienda;
import com.salesianostriana.dam.ejercicioviviendasrepaso.repository.ViviendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class ViviendaService {

    private final ViviendaRepository viviendaRepository;

    public Page<Vivienda> getAll (Pageable pageable, FilterDto filterDto){
        PredicateSpecification<Vivienda> specs = PredicateSpecification.allOf(
                SpecificationViviendas.hasCiudad(filterDto.ciudad()),
                SpecificationViviendas.hasProvincia(filterDto.provincia()),
                SpecificationViviendas.greaterThanPrecioMin(filterDto.precioMin()),
                SpecificationViviendas.lesserThanPrecioMax(filterDto.precioMax()),
                SpecificationViviendas.greaterThanMetrosMin(filterDto.metrosMin()),
                SpecificationViviendas.lesserThanMetrosMax(filterDto.metrosMax()),
                SpecificationViviendas.greaterThanHabitacionesMin(filterDto.habitacionMin()),
                SpecificationViviendas.greaterThanBanosMin(filterDto.banosMin()),
                SpecificationViviendas.hasTipo(filterDto.tipo()),
                SpecificationViviendas.hasEstado(filterDto.estado()),
                SpecificationViviendas.isAscensor(filterDto.ascensor()),
                SpecificationViviendas.isTerraza(filterDto.terraza()),
                SpecificationViviendas.isGaraje(filterDto.garaje()),
                SpecificationViviendas.isDisponible(filterDto.soloDisponibles())
        );
        return viviendaRepository.findBy(specs, q -> q.page(pageable));
    }

    public class SpecificationViviendas {

        public static PredicateSpecification<Vivienda> hasCiudad (String ciudad){
            return (from, cb) ->
                    ciudad == null
                        ? cb.and()
                        : cb.like(cb.lower(from.get("ciudad")), "%" + ciudad + "%");
        }

        public static PredicateSpecification<Vivienda> hasProvincia (String provincia) {
            return (from, cb) ->
                    provincia == null
                        ? cb.and()
                        : cb.equal(cb.lower(from.get("provincia")), provincia.toLowerCase());
        }

        public static PredicateSpecification<Vivienda> greaterThanPrecioMin (Integer precioMin) {
            return (from, cb) ->
                    precioMin == null
                        ? cb.and()
                        : cb.greaterThanOrEqualTo(from.get("precioMin"), precioMin);
        }

        public static PredicateSpecification<Vivienda>  lesserThanPrecioMax (Integer precioMax) {
            return (from, cb) ->
                    precioMax == null
                        ? cb.and()
                        : cb.lessThanOrEqualTo(from.get("precioMax"), precioMax);
        }

        public static PredicateSpecification<Vivienda> greaterThanMetrosMin (Integer metrosMin) {
            return (from, cb) ->
                    metrosMin == null
                         ? cb.and()
                         : cb.greaterThanOrEqualTo(from.get("metrosMin"), metrosMin);
        }

        public static PredicateSpecification<Vivienda>  lesserThanMetrosMax (Integer metrosMax) {
            return (from, cb) ->
                    metrosMax == null
                         ? cb.and()
                         : cb.lessThanOrEqualTo(from.get("metrosMax"), metrosMax);
        }

        public static PredicateSpecification<Vivienda> greaterThanHabitacionesMin (Integer habitacionesMin) {
            return (from, cb) ->
                    habitacionesMin == null
                         ? cb.and()
                         : cb.greaterThanOrEqualTo(from.get("habitacionesMin"), habitacionesMin);
        }

        public static PredicateSpecification<Vivienda> greaterThanBanosMin (Integer banosMin) {
            return (from, cb) ->
                    banosMin == null
                        ? cb.and()
                        : cb.greaterThanOrEqualTo(from.get("banosMin"), banosMin);
        }

        public static PredicateSpecification<Vivienda> hasTipo (TipoVivienda tipo) {
            return (from, cb) ->
                    tipo == null
                        ? cb.and()
                        : cb.equal(from.get("tipo"), tipo);
        }

        public static PredicateSpecification<Vivienda> hasEstado (EstadoVivienda estado) {
            return (from, cb) ->
                    estado == null
                        ? cb.and()
                        : cb.equal(from.get("estado"), estado);
        }

        public static PredicateSpecification<Vivienda> isAscensor (Boolean ascensor) {
            return (from, cb) ->
                    ascensor == null
                        ? cb.and()
                        : cb.equal(from.get("ascensor"), ascensor);
        }

        public static PredicateSpecification<Vivienda> isTerraza (Boolean terraza) {
            return (from, cb) ->
                    terraza == null
                        ? cb.and()
                        : cb.equal(from.get("terraza"), terraza);
        }

        public static PredicateSpecification<Vivienda> isGaraje (Boolean garaje) {
            return (from, cb) ->
                    garaje == null
                        ? cb.and()
                        : cb.equal(from.get("garaje"), garaje);
        }

        public static PredicateSpecification<Vivienda> isDisponible (Boolean soloDisponible) {
            return (from, cb) ->
                    soloDisponible == null
                        ? cb.and()
                        : cb.equal(from.get("disponible"), soloDisponible);
        }

    }

}
