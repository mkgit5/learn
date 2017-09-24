package com.learn.hibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TWO_WHEELER_VEHICLE")
// @DiscriminatorValue("TWO WHEELER")
public class TwoWheelerVehicle extends Vehicle {

	private String steeringHandle;

	@Column(name = "STEERING_HANDLE")
	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}

}
