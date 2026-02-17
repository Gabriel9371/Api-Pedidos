package br.com.PedidosAPI.ordering_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@Configuration
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class OrderingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderingSystemApplication.class, args);
	}

}
