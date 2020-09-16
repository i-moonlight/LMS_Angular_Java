package com.ula.faculty.domain.repository;

import com.ula.faculty.domain.model.TeachingMaterialAuthor;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

@Repository
public interface TeachingMaterialAuthorRepository extends CrudRepository<TeachingMaterialAuthor, Long>
{

}
