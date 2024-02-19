package com.dailydash;

import com.dailydash.login.dao.DashUserDao;
import com.dailydash.login.entity.DashUser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DailydashApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailydashApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(DashUserDao userDao) {
		return runner -> {
			addUsersDB(userDao);

		};
	}

		private void addUsersDB(DashUserDao userDao){
			System.out.println("creating new user");
			DashUser tempUser = new DashUser("eatgrass921", "FU963!", "LA");

			System.out.println("Saving the student");
			userDao.addUser(tempUser);

			System.out.println("Saved student. Generated id:" + tempUser.getId());
	}


}
