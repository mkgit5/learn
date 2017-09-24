package com.learn.hibernate.domain;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "USER_DETAIL")
// @NamedQuery(name = "UserDetail.byID", query = "from UserDetail where id = ?")
// @NamedQuery(name = "UserDetail.byID", query = "from UserDetail where id = :userId")
// @NamedQueries(value = { @NamedQuery(name = "UserDetail.byID", query = "from UserDetail where id = :userId") })
@NamedNativeQuery(name = "UserDetail.byID", query = "select * from USER_DETAIL where USER_ID = ?", resultClass = UserDetail.class)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
// @SequenceGenerator(name = "LOCAL_ALIAS_NAME", sequenceName = "DB_SEQ_NAME", allocationSize = 1)
public class UserDetail {

	private long id;
	private String firstName;
	private String lastName;
	private Date lastLoginDate;
	private String description;
	private Set<Qualification> qualifications;
	private Collection<Qualification> qualificationsWithPK;
	private PhoneDetail phoneDetail;
	private PhoneDetail officePhoneDetail;
	private AddressDetail addressDetail;
	private Set<VehicleDetail> vehicleDetails;
	private Collection<Hotel> userHotels;

	@Id
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOCAL_ALIAS_NAME")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Basic
	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// @Transient
	@Column(name = "LAST_NAME")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "LAST_LOGIN_DATE")
	@Temporal(TemporalType.DATE)
	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	@Lob
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ElementCollection
	@JoinTable(name = "USER_QUALIFICATION", joinColumns = @JoinColumn(name = "USER_ID"))
	public Set<Qualification> getQualifications() {
		return qualifications;
	}

	public void setQualifications(Set<Qualification> qualifications) {
		this.qualifications = qualifications;
	}

	@ElementCollection
	@JoinTable(name = "USER_QUALIFICATION_WITHPK", joinColumns = @JoinColumn(name = "USER_ID"))
	@GenericGenerator(name = "hilo-gen", strategy = "hilo")
	@CollectionId(columns = @Column(name = "QUAL_ID"), generator = "hilo-gen", type = @Type(type = "long"))
	@AttributeOverride(name = "name", column = @Column(name = "QUAL_NAME"))
	public Collection<Qualification> getQualificationsWithPK() {
		return qualificationsWithPK;
	}

	public void setQualificationsWithPK(Collection<Qualification> qualificationsWithPK) {
		this.qualificationsWithPK = qualificationsWithPK;
	}

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "phoneCountryCode", column = @Column(name = "PHONE_COUNTRY_CODE")), @AttributeOverride(name = "phoneAreaCode", column = @Column(name = "PHONE_AREA_CODE")), @AttributeOverride(name = "phoneNumber", column = @Column(name = "PHONE_NUMBER")) })
	public PhoneDetail getPhoneDetail() {
		return phoneDetail;
	}

	public void setPhoneDetail(PhoneDetail phoneDetail) {
		this.phoneDetail = phoneDetail;
	}

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "phoneCountryCode", column = @Column(name = "O_PHONE_COUNTRY_CODE")), @AttributeOverride(name = "phoneAreaCode", column = @Column(name = "O_PHONE_AREA_CODE")), @AttributeOverride(name = "phoneNumber", column = @Column(name = "O_PHONE_NUMBER")) })
	public PhoneDetail getOfficePhoneDetail() {
		return officePhoneDetail;
	}

	public void setOfficePhoneDetail(PhoneDetail officePhoneDetail) {
		this.officePhoneDetail = officePhoneDetail;
	}

	@OneToOne(mappedBy = "userDetail", cascade = CascadeType.ALL)
	// @OneToOne
	@JoinColumn(name = "USER_ID")
	public AddressDetail getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(AddressDetail addressDetail) {
		this.addressDetail = addressDetail;
	}

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	// @OneToMany
	// @JoinColumn(name = "VEHICLE_ID")
	// @JoinTable(name = "USER_VEHICLE", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID"))
	public Set<VehicleDetail> getVehicleDetails() {
		return vehicleDetails;
	}

	public void setVehicleDetails(Set<VehicleDetail> vehicleDetails) {
		this.vehicleDetails = vehicleDetails;
	}

	@ManyToMany
	@JoinTable(name = "USER_HOTEL", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "HOTEL_ID"))
	@GenericGenerator(name = "hilo-gen", strategy = "hilo")
	@CollectionId(columns = @Column(name = "USER_HOTEL_ID"), generator = "hilo-gen", type = @Type(type = "long"))
	public Collection<Hotel> getUserHotels() {
		return userHotels;
	}

	public void setUserHotels(Collection<Hotel> userHotels) {
		this.userHotels = userHotels;
	}

}
