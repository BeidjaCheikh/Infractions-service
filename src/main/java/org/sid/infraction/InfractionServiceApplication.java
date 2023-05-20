package org.sid.infraction;
import lombok.AllArgsConstructor;
import org.sid.infraction.entites.Infraction;
import org.sid.infraction.repository.InfractionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@AllArgsConstructor
public class InfractionServiceApplication implements CommandLineRunner {
	private InfractionRepository infractionRepository;


	public static void main(String[] args) {
		SpringApplication.run(InfractionServiceApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// Add some infractions
		for(int i = 0; i < 5; i++) {
			Infraction infraction = Infraction.builder()
					.id(null)
					.date("2021-01-01")
					.vehicleSpeed(110.0 + i*10)
					.radarMaxSpeed(100.0 + i*10)
					.amount(100.0 + i*10)
					.radarId(null)
					.vehicleId(null)
					.build();
			infractionRepository.save(infraction);
			System.out.println(infraction);
		}
	}
}
