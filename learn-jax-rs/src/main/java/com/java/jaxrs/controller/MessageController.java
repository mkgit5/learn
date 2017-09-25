package com.java.jaxrs.controller;

import com.java.jaxrs.dto.MessageDTO;
import com.java.jaxrs.service.MessageService;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/messages")
public class MessageController {

	private MessageService messageService = new MessageService();

	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getMessage(@PathParam("messageId") Integer messageId, @HeaderParam("Content-Type") String contentType) {
		System.out.println("Inovked get message - " + messageId);
		System.out.println("Content Type - " + contentType);
		return "Invoked get message";
	}

	@GET
	// @Produces(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public List<MessageDTO> getAllMessages() {
		return messageService.getAllMessages();
	}

}
