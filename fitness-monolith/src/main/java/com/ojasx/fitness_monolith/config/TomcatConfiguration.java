package com.ojasx.fitness_monolith.config;

import org.springframework.boot.tomcat.servlet.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatConfiguration {

    /**
     * Use Tomcat's asynchronous connector. On some Windows installations the
     * default NIO connector cannot create its internal loopback selector pipe.
     */
    @Bean
    WebServerFactoryCustomizer<TomcatServletWebServerFactory> tomcatConnectorCustomizer() {
        return factory -> factory.setProtocol("org.apache.coyote.http11.Http11Nio2Protocol");
    }
}
