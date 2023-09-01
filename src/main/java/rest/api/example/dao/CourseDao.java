package rest.api.example.dao;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import rest.api.example.entities.Courses;

public  interface CourseDao extends JpaRepository<Courses,Long> {


}
