package com.PhoneShop;

import com.PhoneShop.model.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class PhoneShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhoneShopApplication.class, args);
	}

}
