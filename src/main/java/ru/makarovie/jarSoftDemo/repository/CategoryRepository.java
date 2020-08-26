package ru.makarovie.jarSoftDemo.repository;

import org.springframework.data.repository.CrudRepository;
import ru.makarovie.jarSoftDemo.model.Banner;
import ru.makarovie.jarSoftDemo.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll ();
    Optional<Category> findAllByName(String name);
}
