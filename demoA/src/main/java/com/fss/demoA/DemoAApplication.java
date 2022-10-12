package com.fss.demoA;

import static io.cloudevents.core.CloudEventUtils.mapData;

import java.net.URI;
import java.util.Arrays;
import java.util.UUID;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.codec.CodecCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.CodecConfigurer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.cloudevents.CloudEvent;
import io.cloudevents.core.builder.CloudEventBuilder;
import io.cloudevents.core.data.PojoCloudEventData;
import io.cloudevents.jackson.PojoCloudEventDataMapper;
import io.cloudevents.spring.http.CloudEventHttpUtils;
import io.cloudevents.spring.webflux.CloudEventHttpMessageReader;
import io.cloudevents.spring.webflux.CloudEventHttpMessageWriter;
import reactor.core.publisher.Mono;
import static io.cloudevents.core.CloudEventUtils.mapData;

//@EnableEurekaClient
@SpringBootApplication
//@RestController
public class DemoAApplication {
	//@Autowired
  //  private RestTemplate restTemplate=new RestTemplate();

	public static void main(String[] args) {
		SpringApplication.run(DemoAApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

	/*@PostMapping("/foos")
	// Let Spring do the type conversion of request and response body
	public ResponseEntity<Foo> echo(@RequestBody Foo foo, @RequestHeader HttpHeaders headers) {
		CloudEvent attributes = CloudEventHttpUtils.fromHttp(headers) //
				.withId(UUID.randomUUID().toString()) //
				.withSource(URI.create("https://spring.io/foos")) //
				.withType("io.spring.event.Foo") //
				.build();
		HttpHeaders outgoing = CloudEventHttpUtils.toHttp(attributes);
		return ResponseEntity.ok().headers(outgoing).body(foo);
	}

	@PostMapping("/event")
	// Use CloudEvent API and manual type conversion of request and response body
	public Mono<CloudEvent> event(@RequestBody Mono<CloudEvent> body) {
		return body.map(event -> CloudEventBuilder.from(event) //
				.withId(UUID.randomUUID().toString()) //
				.withSource(URI.create("https://spring.io/foos")) //
				.withType("io.spring.event.Foo") //
				.withData(event.getData().toBytes()) //
				.build());
	}

	@Configuration
	public static class CloudEventHandlerConfiguration implements CodecCustomizer {

		@Override
		public void customize(CodecConfigurer configurer) {
			configurer.customCodecs().register(new CloudEventHttpMessageReader());
			configurer.customCodecs().register(new CloudEventHttpMessageWriter());
		}

	}*/
	static String H="-H";


	 
}
