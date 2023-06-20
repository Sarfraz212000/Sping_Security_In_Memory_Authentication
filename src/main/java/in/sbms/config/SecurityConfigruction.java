package in.sbms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfigruction {
	
	@Bean
	public InMemoryUserDetailsManager config()
	{
		UserDetails adminUser=User.withDefaultPasswordEncoder()
				                  .username("sarfraz")
				                  .password("sarfraz@123")
				                  .authorities("ADMIN")
				                  .build();
		
		
		UserDetails normalUser=User.withDefaultPasswordEncoder()
				                    .username("user")
				                    .password("user@123")
				                    .authorities("USER")
				                    .build();
		
		return new InMemoryUserDetailsManager(adminUser,normalUser);
		
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((req) -> req
                        .antMatchers("/contact").permitAll()
                        .anyRequest()
                        .authenticated()


        ).formLogin(withDefaults());
		return http.build();
	}

}
