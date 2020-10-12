package org.move02.repository;

import org.move02.domain.Project;
import org.move02.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, String> {
}
