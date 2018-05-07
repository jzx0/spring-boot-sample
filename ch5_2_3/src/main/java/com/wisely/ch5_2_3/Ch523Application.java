package com.wisely.ch5_2_3;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Ch523Application {

	public static void main(String[] args) {
		SpringApplication.run(Ch523Application.class, args);

		//关闭Banner
		/*SpringApplication app = new SpringApplication(Ch523Application.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);*/

		//关闭Banner
		/*new SpringApplicationBuilder(Ch523Application.class)
				.bannerMode(Banner.Mode.OFF)
				.run(args);*/
	}
}
