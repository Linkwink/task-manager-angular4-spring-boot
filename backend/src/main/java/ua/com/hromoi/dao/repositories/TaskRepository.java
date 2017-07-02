package ua.com.hromoi.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.hromoi.infrastructure.models.Task;

/**
 * Created by Viacheslav_Khromoi on 02.07.2017.
 */
public interface TaskRepository extends JpaRepository<Task, Integer> {
    Task findByName(String name);
    Task findByNameIgnoreCase(String name);
}
