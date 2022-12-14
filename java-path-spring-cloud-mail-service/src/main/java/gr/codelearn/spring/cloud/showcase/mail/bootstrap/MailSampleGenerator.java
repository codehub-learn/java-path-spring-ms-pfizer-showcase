package gr.codelearn.spring.cloud.showcase.mail.bootstrap;

import gr.codelearn.spring.cloud.showcase.core.base.BaseComponent;
import gr.codelearn.spring.cloud.showcase.mail.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("generate-mail")
@Component
@RequiredArgsConstructor
public class MailSampleGenerator extends BaseComponent implements CommandLineRunner {
	private final MailService mailService;

	@Override
	public void run(String... args) throws Exception {
		mailService.sendEmail("costas.giannacoulis@gmail.com", "First sample subject",
							  "Hello from a sample <b>Spring Boot</b>.");

		mailService.sendEmail("costas.giannacoulis@gmail.com", "Second sample subject",
							  "<p>Hello from a sample <b>Spring Boot</b>.</p><p>Thank you</p>");
	}
}
