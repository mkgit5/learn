package com.learn.hibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FOUR_WHEELER_VEHICLE")
// @DiscriminatorValue("FOUR WHEELER")
public class FourWheelerVehicle extends Vehicle {

	private String steeringWheel;

	@Column(name = "STEERING_WHEEL")
	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}

}
