package tech.sanroque.todo_list_api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.sanroque.todo_list_api.models.dto.TaskDTO;
import tech.sanroque.todo_list_api.services.TaskServices;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
public class TaskController {

    private final TaskServices taskServices;

    /**
     * Creates a new task.
     *
     * @param data the task data to add
     * @return ResponseEntity with the created task
     */
    @PostMapping
    public ResponseEntity<?> create(@RequestBody final TaskDTO data) {
        return taskServices.create(data);
    }

    /**
     * Retrieves a task by its ID.
     *
     * @param id the ID of the task to retrieve
     * @return ResponseEntity with the task data
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable final Long id) {
        return taskServices.getById(id);
    }

    /**
     * Retrieves all tasks.
     *
     * @return ResponseEntity with the list of all tasks
     */
    @GetMapping
    public ResponseEntity<?> getAll() {
        return taskServices.getAll();
    }

    /**
     * Updates a task by its ID.
     *
     * @param id   the ID of the task to update
     * @param data the new task data
     * @return ResponseEntity with the updated task
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable final Long id, @RequestBody final TaskDTO data) {
        return taskServices.update(id, data);
    }

    /**
     * Deletes a task by its ID.
     *
     * @param id the ID of the task to delete
     * @return ResponseEntity indicating the result of the operation
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable final Long id) {
        return taskServices.delete(id);
    }
}
