package com.learn.jaxrs.service;

import com.learn.jaxrs.dto.MessageDTO;

import java.util.ArrayList;
import java.util.List;

public class MessageService {

	public String getMessage(Integer messageId) {
		System.out.println("Inovked get message - " + messageId);
		return "Invoked get message";
	}

	public List<MessageDTO> getAllMessages() {
		MessageDTO message1 = new MessageDTO(1, "Hello JaxRS 1", "Manju");
		MessageDTO message2 = new MessageDTO(2, "Hello JaxRS 2", "Manju");
		List<MessageDTO> list = new ArrayList<MessageDTO>();
		list.add(message1);
		list.add(message2);
		return list;
	}
}
