package tech.sanroque.todo_list_api.mappers.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tech.sanroque.todo_list_api.models.dto.TaskDTO;
import tech.sanroque.todo_list_api.models.entities.Task;


@Mapper(componentModel = "spring")
public interface TaskMapper {

    Task mapToEntity(TaskDTO dto);
    TaskDTO mapToDTO(Task task);
}
