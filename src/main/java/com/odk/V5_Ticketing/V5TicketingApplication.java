package com.odk.V5_Ticketing;

import com.odk.V5_Ticketing.entity.Admin;
import com.odk.V5_Ticketing.entity.Utilisateur;
import com.odk.V5_Ticketing.repository.UtilisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class V5TicketingApplication {

	public static void main(String[] args) {
		SpringApplication.run(V5TicketingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UtilisateurRepository utilisateurRepository, PasswordEncoder passwordEncoder	) {
		return args -> {
			Optional<Utilisateur> utilisateurs = utilisateurRepository.findByEmail("Admin@admin.ml");
			if (utilisateurs.isEmpty()) {
				Admin admin = new Admin();
				admin.setEmail("Admin@admin.ml");
				admin.setPrenom("Admin@admin.ml");
				admin.setNom("Admin");
				admin.setRole("ADMIN");
				admin.setMotDePasse(passwordEncoder.encode("Admin@admin.ml"));
				utilisateurRepository.save(admin);
			}
		};
	}
}
