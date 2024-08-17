package com.student_database.manage.repository;

import com.student_database.manage.dto.StudentEntityRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntityRequest, Long> {

}
