package com.learn.hibernate.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "HOTEL")
public class Hotel {

	private long id;
	private String roomNumber;
	private Set<UserDetail> userDetails;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "HOTEL_ID")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "ROOM_NUMBER")
	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	@ManyToMany(mappedBy = "userHotels")
	// @ManyToMany
	public Set<UserDetail> getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(Set<UserDetail> userDetail) {
		this.userDetails = userDetail;
	}

}
