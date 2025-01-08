package tech.sanroque.todo_list_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "tech.sanroque.todo_list_api")
public class TodoListAPIApplication {


	public static void main(String[] args) {
		SpringApplication.run(TodoListAPIApplication.class, args);
	}

}
