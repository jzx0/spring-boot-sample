package com.wisely.ch7_4;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Ch74Application {

	@Value("${http.port}")
	private Integer httpPort;

	@Value("${server.port}")
	private Integer httpsPort;

	public static void main(String[] args) {
		SpringApplication.run(Ch74Application.class, args);
	}

	@Bean
	public TomcatServletWebServerFactory servletWebServerFactory() {
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
			@Override
			protected void postProcessContext(Context context) {
				SecurityConstraint constraint = new SecurityConstraint();
				constraint.setUserConstraint("CONFIDENTIAL");
				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/*");
				constraint.addCollection(collection);
				context.addConstraint(constraint);
			}
		};
		tomcat.addAdditionalTomcatConnectors(httpConnector());
		return tomcat;
	}

	@Bean
	public Connector httpConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");
		connector.setPort(httpPort);
		connector.setSecure(false);
		connector.setRedirectPort(httpsPort);
		return connector;
	}
}
