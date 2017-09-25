package com.java.spring.service.impl;

import com.java.spring.aop.dto.Square;
import com.java.spring.dto.Circle;
import com.java.spring.service.LearnSpringService;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class LearnSpringServiceImpl implements LearnSpringService {

	@Autowired
	private Circle circle;

	@Autowired
	private Square squareAOP;

	@Autowired
	private MessageSource messageSource;

	@Override
	public void drawCircle(int circleId) {
		System.out.println(messageSource.getMessage("localization", null, Locale.UK));
		System.out.println("Circle ID:Name - " + circle.getId() + ":" + circle.getName());
		throw new RuntimeException();
	}

	public Square getSquareAOP() {
		return squareAOP;
	}

	public void setSquareAOP(Square squareAOP) {
		this.squareAOP = squareAOP;
	}

}
