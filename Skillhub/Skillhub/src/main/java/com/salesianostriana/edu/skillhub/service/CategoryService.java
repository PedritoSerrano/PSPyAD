package com.salesianostriana.edu.skillhub.service;

import com.salesianostriana.edu.skillhub.model.Category;
import com.salesianostriana.edu.skillhub.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {
        if (categoryRepository.findAll().isEmpty()){
            throw new RuntimeException("La lista de categorías está vacia");
        }else{
            return categoryRepository.findAll();
        }

    }

    public Optional<Category> findById(Long id) {
        if (categoryRepository.findById(id).isEmpty()){
            throw new RuntimeException("No hay categorías con ese id");
        }else {
            return categoryRepository.findById(id);
        }
    }

    @Transactional
    public Category save(Category category) {
        if (category == null){
            throw new RuntimeException("No se puede guardar, la categoría está vacía");
        }else {
            return categoryRepository.save(category);
        }
    }

    @Transactional
    public Category update(Long id, Category updatedCategory) {
        return categoryRepository.findById(id)
                .map(category -> {
                    category.setNombre(updatedCategory.getNombre());
                    category.setDescripcion(updatedCategory.getDescripcion());
                    return categoryRepository.save(category);
                })
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con ID: " + id));
    }

    @Transactional
    public void delete(Long id) {
        if (categoryRepository.findById(id).isEmpty()){
            throw new RuntimeException("No hay categorías con ese id");
        }else{
            categoryRepository.deleteById(id);
        }
    }
}
