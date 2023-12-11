package com.example.springmongo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query ;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringmongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmongoApplication.class, args);
	}

	// @Bean
	// CommandLineRunner runner (StudentRepository repository,MongoTemplate mongoTemplate){
	// 	return args->{
	// 		Address address = new Address(
	// 			"India",
	// 			"123456",
	// 			"CBE"
	// 		);
	// 		String email = "testmail@gmail.com";
	// 		Student student = new Student(
	// 			"Sai",
	// 			"T",
	// 			email,
	// 			Gender.MALE,
	// 			address,
	// 			List.of("CS","Math"),
	// 			BigDecimal.TEN,
	// 			LocalDateTime.now()
	// 		);

	// 		// Using mongo template and query
	// 		// Query query = new Query();
	// 		// query.addCriteria(Criteria.where("email").is(email));
	// 		// List <Student> students = (List<Student>) mongoTemplate.find(query, student.getClass());
	// 		// if (students.size()>1){
	// 		// 	throw new IllegalStateException("many students with mail "+email);
	// 		// }
	// 		// if(students.isEmpty()){
	// 		// 	System.out.println("Inserting student "+ student);
	// 		// 	repository.insert(student);
	// 		// }
	// 		// else{
	// 		// 	System.out.println(student+" already exists");
	// 		// }

	// 		repository.findStudentByEmail(email).ifPresentOrElse(s->{System.out.println(s+" already exists");}, ()->{System.out.println("Inserting student "+ student);
	// 			repository.insert(student);});
		// };
	// }
}
