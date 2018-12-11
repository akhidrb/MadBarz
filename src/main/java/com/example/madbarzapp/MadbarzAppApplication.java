package com.example.madbarzapp;

import com.example.madbarzapp.data.MusclegroupRep;
import com.example.madbarzapp.models.Musclegroup;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MadbarzAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MadbarzAppApplication.class, args);
	}


	@Bean
	public CommandLineRunner dataLoader(MusclegroupRep repo) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				repo.save(new Musclegroup("chest"));
				repo.save(new Musclegroup("shoulders"));
				repo.save(new Musclegroup("back"));
				repo.save(new Musclegroup("legs"));
				repo.save(new Musclegroup("core"));
			}
		};
	}

}
