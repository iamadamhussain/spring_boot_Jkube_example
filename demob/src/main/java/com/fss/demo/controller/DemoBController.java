package com.fss.demo.controller;



import static io.cloudevents.core.CloudEventUtils.mapData;

import java.net.URI;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cloudevents.CloudEvent;
import io.cloudevents.core.builder.CloudEventBuilder;
import io.cloudevents.core.data.PojoCloudEventData;
import io.cloudevents.jackson.PojoCloudEventDataMapper;

//@RestController
//@RequestMapping("/")
@Slf4j
@Path("/")
public class DemoBController {
	  @Autowired
	    private RestTemplate restTemplate;
	  public static final String FSS_EVENT_TYPE = "fss.myapplication";

	    @Autowired
	    ObjectMapper objectMapper;
	    
	    @GET
	    @Path("greetmessage")
	    public String greetMessage2() {
	    	return "Hi";
	    }
	 @GetMapping("/greetmessage")
	    public String greetMessage() {
	       log.info("Inside greetMessage method of DemoBController");
	      String msg="Hello Welcome to DemoB";
	    //  ResponseTemplateVO vo = new ResponseTemplateVO();

	      String message =
	              restTemplate.getForObject("http://localhost:8200/demoA/message" ,String.class);

	        return msg+"----"+message;
	    }
	 
	

	    @POST
	    @Path("send_user")
	    public Response sendUserEnvent(@RequestBody CloudEvent inputEvent) {
	        if (!inputEvent.getType().equals(FSS_EVENT_TYPE)) {
	            return Response.status(Response.Status.BAD_REQUEST)
	                .type(MediaType.TEXT_PLAIN)
	                .entity("Event type should be \"" + FSS_EVENT_TYPE + "\" but is \"" + inputEvent.getType() + "\"")
	                .build();
	        }
	        PojoCloudEventData<User> cloudEventData = mapData(inputEvent, PojoCloudEventDataMapper.from(objectMapper, User.class));

	        if (cloudEventData == null) {
	            return Response.status(Response.Status.BAD_REQUEST)
	                .type(MediaType.TEXT_PLAIN)
	                .entity("Event should contain the user")
	                .build();
	        }

	        User user = cloudEventData.getValue();
	        user.setAge(user.getAge() + 1);

	        CloudEvent outputEvent = CloudEventBuilder.from(inputEvent)
	            .withData(PojoCloudEventData.wrap(user, objectMapper::writeValueAsBytes))
	            .build();

       
	        
	        return Response.ok(outputEvent).build();
	    }
	    @POST
	    @Path("send_user1")
	    public Response handleHappyBirthdayEvent(@RequestBody CloudEvent inputEvent) {
	       
	        PojoCloudEventData<User> cloudEventData = mapData(inputEvent, PojoCloudEventDataMapper.from(objectMapper, User.class));

	        if (cloudEventData == null) {
	            return Response.status(Response.Status.BAD_REQUEST)
	                .type(MediaType.TEXT_PLAIN)
	                .entity("Event should contain the user")
	                .build();
	        }

	        User user = cloudEventData.getValue();
	        user.setAge(user.getAge() + 1);

	        CloudEvent outputEvent = CloudEventBuilder.from(inputEvent)
	            .withData(PojoCloudEventData.wrap(user, objectMapper::writeValueAsBytes))
	            .build();

       
	        
	        return Response.ok(outputEvent).build();
	    }

}
