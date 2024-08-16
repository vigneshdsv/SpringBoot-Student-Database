package StudentDatabase.studentDB.repository;

import StudentDatabase.studentDB.dto.StudentEntityRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntityRequest, Long> {

}
