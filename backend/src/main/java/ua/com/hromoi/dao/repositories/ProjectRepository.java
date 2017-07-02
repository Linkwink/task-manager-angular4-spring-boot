package ua.com.hromoi.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.hromoi.infrastructure.models.Project;

/**
 * Created by Viacheslav_Khromoi on 02.07.2017.
 */
public interface ProjectRepository extends JpaRepository<Project, Integer>{

}
