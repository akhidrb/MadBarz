package com.example.madbarzapp;

import com.example.madbarzapp.data.MusclegroupRep;
import com.example.madbarzapp.data.UserRep;
import com.example.madbarzapp.models.Musclegroup;
import com.example.madbarzapp.models.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class MadbarzAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MadbarzAppApplication.class, args);
	}


	@Bean
	public CommandLineRunner dataLoader(MusclegroupRep repoMuscle,
										UserRep userRep,
										PasswordEncoder passwordEncoder) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				repoMuscle.save(new Musclegroup("chest"));
				repoMuscle.save(new Musclegroup("shoulders"));
				repoMuscle.save(new Musclegroup("back"));
				repoMuscle.save(new Musclegroup("legs"));
				repoMuscle.save(new Musclegroup("core"));

				userRep.save(new User("user", passwordEncoder.encode("user"), "User"));
			}
		};
	}

}
