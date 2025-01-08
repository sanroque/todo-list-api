package tech.sanroque.todo_list_api.models.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
public class TaskDTO {

    private Long id;
    private String title;
    private String description;
}
