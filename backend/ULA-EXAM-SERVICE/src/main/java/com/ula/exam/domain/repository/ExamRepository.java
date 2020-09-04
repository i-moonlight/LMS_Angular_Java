package com.ula.exam.domain.repository;

import com.ula.exam.domain.model.Exam;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

@Repository
public interface ExamRepository extends CrudRepository<Exam, Long>
{

}
