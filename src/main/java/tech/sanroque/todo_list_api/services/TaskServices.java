package tech.sanroque.todo_list_api.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tech.sanroque.todo_list_api.mappers.mapper.TaskMapper;
import tech.sanroque.todo_list_api.models.dto.TaskDTO;
import tech.sanroque.todo_list_api.models.entities.Task;
import tech.sanroque.todo_list_api.repositories.TaskRepository;

import java.net.URI;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
public class TaskServices {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    /**
     * Creates a new task on database.
     *
     * @param dto the task data to be added
     * @return ResponseEntity with the created task
     */
    public ResponseEntity<?> create(final TaskDTO dto) {
        if (dto == null) {
            return ResponseEntity.badRequest().body("Invalid request. Task data cannot be null.");
        }

        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());

        Task savedTask = taskRepository.save(task);
        TaskDTO savedTaskDTO = taskMapper.mapToDTO(savedTask);

        return ResponseEntity.created(URI.create("/tasks/" + savedTaskDTO.getId())).body(savedTaskDTO);
    }

    /**
     * Retrieves a task by its ID.
     *
     * @param id the ID of the task to retrieve
     * @return ResponseEntity with the task data or an error message
     */
    @Transactional
    public ResponseEntity<?> getById(final Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task with ID " + id + " not found"));

        TaskDTO taskDTO = taskMapper.mapToDTO(task);
        return ResponseEntity.ok(taskDTO);
    }

    /**
     * Retrieves all tasks in database.
     *
     * @return ResponseEntity with a list of all tasks or a message if no tasks are found
     */
    @Transactional
    public ResponseEntity<?> getAll() {
        List<Task> taskList = taskRepository.findAll();

        if (taskList.isEmpty()) {
            return ResponseEntity.ok("There are no tasks registered.");
        }

        List<TaskDTO> dtoList = taskList.stream().map(taskMapper::mapToDTO).toList();
        return ResponseEntity.ok(dtoList);
    }

    /**
     * Updates a task in database.
     *
     * @param id   the ID of the task to update
     * @param data the new data for the task
     * @return ResponseEntity with the updated task or an error message
     */
    @Transactional
    public ResponseEntity<?> update(final Long id, final TaskDTO data) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task with ID " + id + " not found"));

        task.setTitle(data.getTitle());
        task.setDescription(data.getDescription());

        Task updatedTask = taskRepository.save(task);
        TaskDTO updatedTaskDTO = taskMapper.mapToDTO(updatedTask);

        return ResponseEntity.accepted().body(updatedTaskDTO);
    }

    /**
     * Deletes a task from database
     *
     * @param id    the ID of the task to delete
     * @return   ResponseEntity with the success message
     */
    @Transactional
    public ResponseEntity<?> delete(final Long id){
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task with ID " + id + " not found"));
        taskRepository.delete(task);
        return ResponseEntity.accepted().body("Task deleted successfully.");
    }
}
