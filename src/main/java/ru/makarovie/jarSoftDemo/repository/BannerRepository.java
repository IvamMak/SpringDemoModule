package ru.makarovie.jarSoftDemo.repository;

import org.springframework.data.repository.CrudRepository;
import ru.makarovie.jarSoftDemo.model.Banner;

import java.util.List;

public interface BannerRepository extends CrudRepository<Banner, Long> {
    List<Banner> findAll();
}
