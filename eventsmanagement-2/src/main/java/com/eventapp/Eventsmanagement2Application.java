package com.eventapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.eventapp.entity.User;
import com.eventapp.service.EventService;
import com.eventapp.service.UserService;

@SpringBootApplication
@Component
public class Eventsmanagement2Application implements CommandLineRunner {
	@Autowired
	private EventService eventService;
	private UserService userService;

	@Autowired
	public Eventsmanagement2Application(UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Eventsmanagement2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		 * Event e1=new Event("dancing", "hcl danceroom", 1500.00, 10.00, 10,
		 * LocalDate.of(2020, Month.DECEMBER, 31)); eventService.addEvent(e1);
		 */
		/*
		 * Event e2=new Event("singing", "hcl singersroom", 1000.00, 12.00, 12,
		 * LocalDate.of(2021, Month.JANUARY, 26)); Event e3=new Event("painting",
		 * "hcl artistroom", 2000.00, 15.00, 10, LocalDate.of(2021, Month.JANUARY, 25));
		 * Event e4=new Event("yoga", "hcl yogaroom", 2500.00, 20.00, 30,
		 * LocalDate.of(2021, Month.JANUARY, 27)); Event e5=new
		 * Event("springboot trainig", "hcl trainingroom", 3500.00, 25.00, 50,
		 * LocalDate.of(2021, Month.JANUARY, 27));
		 * 
		 * eventService.addEvent(e1); eventService.addEvent(e2);
		 * eventService.addEvent(e3); eventService.addEvent(e4);
		 * eventService.addEvent(e5);
		 */
		
		/*BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		

		User user1 = new User("dilip", encoder.encode("dilip123"), "ROLE_ADMIN");
		User user2 = new User("balu", encoder.encode("balu123"), "ROLE_CLERK");

		userService.addUser(user1);
		userService.addUser(user2);*/

	}

}
