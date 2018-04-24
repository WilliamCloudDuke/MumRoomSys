package edu.mum.roomsys.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import edu.mum.roomsys.domain.Account;
import edu.mum.roomsys.dto.AccountDto;

@Configuration
@ImportResource({ "classpath:webFlowConfig.xml" })
@ComponentScan(basePackages = "edu.mum.roomsys")
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder;
	}
	
	@Bean
	@Scope("prototype")
	public ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();
		
		// temporary workaround for development mode/liveload
		try {
			mapper.createTypeMap(AccountDto.class,  Account.class).addMappings(new PropertyMap<AccountDto, Account>() {
				@Override
				protected void configure() {
					map().setRole(null);
					map().setStudent(null);
				}
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	
		
		return mapper;
	}	

}
