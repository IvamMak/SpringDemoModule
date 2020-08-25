package ru.makarovie.jarSoftDemo.repository;

import org.springframework.data.repository.CrudRepository;
import ru.makarovie.jarSoftDemo.model.Request;

public interface RequestRepository extends CrudRepository<Request, Long> {
}
