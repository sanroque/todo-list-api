package tech.sanroque.todo_list_api.mappers;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import tech.sanroque.todo_list_api.mappers.mapper.TaskMapper;

@Configuration
@ComponentScan(basePackages = "tech/sanroque/todo_list_api/mappers")
public class MapperConfig {
    @Bean
    public TaskMapper taskMapper(){
        return Mappers.getMapper(TaskMapper.class);
    }
}
