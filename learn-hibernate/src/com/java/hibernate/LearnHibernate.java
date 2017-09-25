package com.java.hibernate;

import com.java.hibernate.domain.AddressDetail;
import com.java.hibernate.domain.FourWheelerVehicle;
import com.java.hibernate.domain.Hotel;
import com.java.hibernate.domain.PhoneDetail;
import com.java.hibernate.domain.Qualification;
import com.java.hibernate.domain.TwoWheelerVehicle;
import com.java.hibernate.domain.UserDetail;
import com.java.hibernate.domain.Vehicle;
import com.java.hibernate.domain.VehicleDetail;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

public class LearnHibernate {

	private static SessionFactory SESSION_FACTORY = new Configuration().configure("hibernate-cfg.xml").buildSessionFactory();

	public static void main(String[] args) {
		// insert();
		// insertGeneratedPrimaryKey();
		// insertEmbedded();
		// insertElementCollections();
		// fetchByGet();
		// fetchByLoad();
		saveOneToOneMapping();
		// saveOneToManyMapping();
		// saveManyToManyMapping();
		// inheritanceSingleTableStrategy();
		// inheritanceTablePerClassStrategy();
		// inheritanceJoinStrategy();
		// saveOrPersist();
		// fetchByHql();
		// fetchByNamedQuery();
		// fetchByCriteria();
		// fetchFromEhCache();
		// fetchFromQueryCache();
		SESSION_FACTORY.close();
		System.exit(0);
	}

	private static void insert() {
		final UserDetail userDetail = new UserDetail();
		userDetail.setId(1);
		userDetail.setFirstName("Manju");
		userDetail.setLastName("Kogunde");
		userDetail.setLastLoginDate(new Date());
		userDetail.setDescription("My description goes here.....");

		final Session session = SESSION_FACTORY.openSession();
		session.beginTransaction();
		session.save(userDetail);
		session.getTransaction().commit();
		session.close();
	}

	private static void insertGeneratedPrimaryKey() {
		final UserDetail userDetail = new UserDetail();
		userDetail.setFirstName("Manju");
		userDetail.setLastName("Kogunde");
		userDetail.setLastLoginDate(new Date());
		userDetail.setDescription("My description goes here.....");

		final UserDetail userDetail2 = new UserDetail();
		userDetail2.setFirstName("Manju 2");
		userDetail2.setLastName("Kogunde 2");
		userDetail2.setLastLoginDate(new Date());
		userDetail2.setDescription("My description goes here.....");

		final Session session = SESSION_FACTORY.openSession();
		session.beginTransaction();
		session.save(userDetail);
		session.save(userDetail2);
		session.getTransaction().commit();
		session.close();
		System.exit(0);
	}

	private static void insertEmbedded() {
		final UserDetail userDetail = new UserDetail();
		userDetail.setId(1);
		userDetail.setFirstName("Manju");
		userDetail.setLastName("Kogunde");
		userDetail.setLastLoginDate(new Date());

		final PhoneDetail phoneDetail = new PhoneDetail();
		phoneDetail.setPhoneCountryCode("+1");
		phoneDetail.setPhoneAreaCode("650");
		phoneDetail.setPhoneNumber("283-3967");

		userDetail.setPhoneDetail(phoneDetail);

		final PhoneDetail officePhoneDetail = new PhoneDetail();
		officePhoneDetail.setPhoneCountryCode("+1");
		officePhoneDetail.setPhoneAreaCode("650");
		officePhoneDetail.setPhoneNumber("283-3967");

		userDetail.setOfficePhoneDetail(officePhoneDetail);

		final Session session = SESSION_FACTORY.openSession();
		session.beginTransaction();
		session.save(userDetail);
		session.getTransaction().commit();
		session.close();
	}

	private static void insertEmbeddedWithId() {
		final UserDetail userDetail = new UserDetail();
		userDetail.setId(1);
		userDetail.setFirstName("Manju");
		userDetail.setLastName("Kogunde");

		final PhoneDetail phoneDetail = new PhoneDetail();
		phoneDetail.setPhoneCountryCode("+1");
		phoneDetail.setPhoneAreaCode("650");
		phoneDetail.setPhoneNumber("283-3967");

		userDetail.setPhoneDetail(phoneDetail);

		final PhoneDetail officePhoneDetail = new PhoneDetail();
		officePhoneDetail.setPhoneCountryCode("+1");
		officePhoneDetail.setPhoneAreaCode("650");
		officePhoneDetail.setPhoneNumber("283-3967");

		userDetail.setOfficePhoneDetail(officePhoneDetail);

		final Session session = SESSION_FACTORY.openSession();
		session.beginTransaction();
		session.save(userDetail);
		session.getTransaction().commit();
		session.close();

	}

	private static void insertElementCollections() {
		final UserDetail userDetail = new UserDetail();
		userDetail.setId(1);
		userDetail.setFirstName("Manju");
		userDetail.setLastName("Kogunde");

		Qualification qualification1 = new Qualification();
		qualification1.setName("B.A");

		Qualification qualification2 = new Qualification();
		qualification2.setName("B.Ed");

		Set<Qualification> qualifications = new HashSet<Qualification>();
		qualifications.add(qualification1);
		qualifications.add(qualification2);

		userDetail.setQualifications(qualifications);
		userDetail.setQualificationsWithPK(qualifications);

		final Session session = SESSION_FACTORY.openSession();
		session.beginTransaction();
		session.save(userDetail);
		session.getTransaction().commit();
		session.close();
	}

	private static void fetchByGet() {
		final Session session = SESSION_FACTORY.openSession();
		session.beginTransaction();
		UserDetail detail = (UserDetail) session.get(UserDetail.class, 1L);
		System.out.println(detail.getFirstName());
		session.getTransaction().commit();
		session.close();
	}

	private static void fetchByLoad() {
		final Session session = SESSION_FACTORY.openSession();
		session.beginTransaction();
		UserDetail detail = (UserDetail) session.load(UserDetail.class, 1L);
		System.out.println(detail.getFirstName());
		session.getTransaction().commit();
		session.close();
	}

	private static void saveOneToOneMapping() {
		final UserDetail userDetail = new UserDetail();
		userDetail.setFirstName("Manju");
		userDetail.setLastName("Kogunde");

		final AddressDetail addressDetail = new AddressDetail();
		addressDetail.setCity("DVG");
		addressDetail.setState("KAR");
		addressDetail.setCountry("INDIA");
		addressDetail.setUserDetail(userDetail);

		userDetail.setAddressDetail(addressDetail);

		final Session session = SESSION_FACTORY.openSession();
		session.beginTransaction();
		session.save(userDetail);
		// session.save(addressDetail);
		session.getTransaction().commit();
		session.close();
	}

	private static void saveOneToManyMapping() {
		final UserDetail userDetail = new UserDetail();
		// userDetail.setId(1);
		userDetail.setFirstName("Manju");
		userDetail.setLastName("Kogunde");

		final VehicleDetail vehicleDetail = new VehicleDetail();
		vehicleDetail.setName("BMW");
		vehicleDetail.setUser(userDetail);

		final VehicleDetail vehicleDetail2 = new VehicleDetail();
		vehicleDetail2.setName("Audi");
		vehicleDetail2.setUser(userDetail);

		Set<VehicleDetail> vehicleDetails = new HashSet<VehicleDetail>();
		vehicleDetails.add(vehicleDetail);
		vehicleDetails.add(vehicleDetail2);

		userDetail.setVehicleDetails(vehicleDetails);

		final Session session = SESSION_FACTORY.openSession();
		session.beginTransaction();
		session.save(userDetail);
		// session.save(vehicleDetail);
		// session.save(vehicleDetail2);
		session.getTransaction().commit();
		session.close();
	}

	private static void saveManyToManyMapping() {
		final UserDetail userDetail = new UserDetail();
		userDetail.setId(1);
		userDetail.setFirstName("Manju");
		userDetail.setLastName("Kogunde");
		final Set<UserDetail> userSet = new HashSet<UserDetail>();
		userSet.add(userDetail);

		final Hotel userHotel = new Hotel();
		userHotel.setRoomNumber("101");
		userHotel.setUserDetails(userSet);

		final Hotel userHotel2 = new Hotel();
		userHotel2.setRoomNumber("102");
		userHotel2.setUserDetails(userSet);

		Set<Hotel> userHotels = new HashSet<Hotel>();
		userHotels.add(userHotel);
		userHotels.add(userHotel2);

		userDetail.setUserHotels(userHotels);

		final Session session = SESSION_FACTORY.openSession();
		session.beginTransaction();
		session.save(userDetail);
		session.save(userHotel);
		session.save(userHotel2);
		session.getTransaction().commit();
		session.close();
	}

	private static void inheritanceSingleTableStrategy() {
		Vehicle vehicle = new Vehicle();
		vehicle.setName("Car");

		TwoWheelerVehicle bike = new TwoWheelerVehicle();
		bike.setName("Honda");
		bike.setSteeringHandle("Handle");

		FourWheelerVehicle jeep = new FourWheelerVehicle();
		jeep.setName("Jeep");
		jeep.setSteeringWheel("Wheel");

		final Session session = SESSION_FACTORY.openSession();
		session.beginTransaction();
		session.save(vehicle);
		session.save(bike);
		session.save(jeep);
		session.getTransaction().commit();
		session.close();

	}

	private static void inheritanceTablePerClassStrategy() {
		Vehicle vehicle = new Vehicle();
		vehicle.setName("Car");

		TwoWheelerVehicle bike = new TwoWheelerVehicle();
		bike.setName("Honda");
		bike.setSteeringHandle("Handle");

		FourWheelerVehicle jeep = new FourWheelerVehicle();
		jeep.setName("Jeep");
		jeep.setSteeringWheel("Wheel");

		final Session session = SESSION_FACTORY.openSession();
		session.beginTransaction();
		session.save(vehicle);
		session.save(bike);
		session.save(jeep);
		session.getTransaction().commit();
		session.close();

	}

	private static void inheritanceJoinStrategy() {
		Vehicle vehicle = new Vehicle();
		vehicle.setName("Car");

		TwoWheelerVehicle bike = new TwoWheelerVehicle();
		bike.setName("Honda");
		bike.setSteeringHandle("Handle");

		FourWheelerVehicle jeep = new FourWheelerVehicle();
		jeep.setName("Jeep");
		jeep.setSteeringWheel("Wheel");

		final Session session = SESSION_FACTORY.openSession();
		session.beginTransaction();
		session.save(vehicle);
		session.save(bike);
		session.save(jeep);
		session.getTransaction().commit();
		session.close();

	}

	private static void saveOrPersist() {
		Vehicle vehicle = new Vehicle();
		vehicle.setName("Car");

		final Session session = SESSION_FACTORY.openSession();
		session.beginTransaction();
		// Serializable serializable = session.save(vehicle);
		// System.out.println("After save");
		session.persist(vehicle);
		System.out.println("After persist");
		session.getTransaction().commit();
		session.close();
	}

	private static void fetchByHql() {
		UserDetail userDetail = new UserDetail();
		userDetail.setFirstName("Manju");
		userDetail.setLastName("Kogunde");
		userDetail.setLastLoginDate(new Date());

		AddressDetail addressDetail = new AddressDetail();
		addressDetail.setCity("DVG");
		addressDetail.setState("KAR");
		addressDetail.setCountry("INDIA");
		userDetail.setAddressDetail(addressDetail);

		Session session = SESSION_FACTORY.openSession();
		session.beginTransaction();
		final Serializable userID = session.save(userDetail);
		session.save(addressDetail);
		session.getTransaction().commit();

		// session = SESSION_FACTORY.openSession();
		// final Query hqlQuery = session.createQuery("from UserDetail");
		//
		// System.out.println("Fetch list of users");
		// List<UserDetail> userDetails = hqlQuery.list();
		// for (UserDetail tempUser : userDetails) {
		// System.out.println(tempUser.getFirstName());
		// }

		// session = SESSION_FACTORY.openSession();
		// final Query hqlQuery = session.createQuery("from UserDetail where id = ?");
		// hqlQuery.setLong(0, Long.valueOf(userID.toString()));
		// userDetail = null;
		// userDetail = (UserDetail) hqlQuery.uniqueResult();
		// System.out.println(userDetail.getFirstName());

		// // Named parameter
		// session = SESSION_FACTORY.openSession();
		// final Query hqlQuery2 = session.createQuery("from UserDetail where id = :userId");
		// hqlQuery2.setParameter("userId", userID);
		// // hqlQuery2.setLong("userId", Long.parseLong(userID.toString()));
		// userDetail = null;
		// userDetail = (UserDetail) hqlQuery2.uniqueResult();
		// System.out.println(userDetail.getFirstName());

		// Join table
		session = SESSION_FACTORY.openSession();
		final Query hqlQuery2 = session.createQuery("from UserDetail where id = :userId");
		hqlQuery2.setParameter("userId", userID);
		// hqlQuery2.setLong("userId", Long.parseLong(userID.toString()));
		userDetail = null;
		userDetail = (UserDetail) hqlQuery2.uniqueResult();
		System.out.println(userDetail.getAddressDetail().getCity());

		session.close();
	}

	private static void fetchByNamedQuery() {
		UserDetail userDetail = new UserDetail();
		userDetail.setFirstName("Manju");
		userDetail.setLastName("Kogunde");
		userDetail.setLastLoginDate(new Date());

		Session session = SESSION_FACTORY.openSession();
		session.beginTransaction();
		final Serializable userID = session.save(userDetail);
		session.getTransaction().commit();

		session = SESSION_FACTORY.openSession();
		session.beginTransaction();
		Query namedQuery = session.getNamedQuery("UserDetail.byID");
		namedQuery.setLong(0, Long.parseLong(userID.toString()));
		// namedQuery.setLong("userId", Long.parseLong(userID.toString()));
		userDetail = (UserDetail) namedQuery.uniqueResult();
		System.out.println(userDetail.getFirstName());
		session.getTransaction().commit();

		session.close();
	}

	private static void fetchByCriteria() {
		UserDetail userDetail = new UserDetail();
		userDetail.setFirstName("Manju");
		userDetail.setLastName("Kogunde");
		userDetail.setLastLoginDate(new Date());

		UserDetail userDetail2 = new UserDetail();
		userDetail2.setFirstName("Rakesh");
		userDetail2.setLastName("Baliga");
		userDetail2.setLastLoginDate(new Date());

		Session session = SESSION_FACTORY.openSession();
		session.beginTransaction();
		final Serializable userID = session.save(userDetail);
		final Serializable userID2 = session.save(userDetail2);
		session.getTransaction().commit();

		session = SESSION_FACTORY.openSession();
		session.beginTransaction();
		Criteria createCriteria = session.createCriteria(UserDetail.class);
		createCriteria.add(Restrictions.eq("id", Long.parseLong(userID.toString())));

		/*
		 * Disjunction or = Restrictions.disjunction(); or.add(Restrictions.like("firstName", "%an%")); or.add(Restrictions.like("lastName", "%ko%")); createCriteria.add(or);
		 */

		/*
		 * Conjunction and = Restrictions.conjunction(); and.add(Restrictions.like("firstName", "%an%")).add(Restrictions.like("lastName", "%ko%")); createCriteria.add(and);
		 */

		userDetail2 = (UserDetail) createCriteria.uniqueResult();
		System.out.println(userDetail2.getFirstName());
		session.getTransaction().commit();

		session.close();
	}

	private static void fetchFromEhCache() {
		UserDetail userDetail = new UserDetail();
		userDetail.setFirstName("Manju");
		userDetail.setLastName("Kogunde");
		userDetail.setLastLoginDate(new Date());

		Session session = SESSION_FACTORY.openSession();
		session.beginTransaction();
		final Serializable userID = session.save(userDetail);
		session.getTransaction().commit();
		session.close();

		session = SESSION_FACTORY.openSession();
		session.beginTransaction();
		UserDetail userDetail1 = (UserDetail) session.get(UserDetail.class, Long.parseLong(userID.toString()));
		System.out.println(userDetail1.getFirstName());
		session.getTransaction().commit();
		session.close();

		session = SESSION_FACTORY.openSession();
		session.beginTransaction();
		UserDetail userDetail2 = (UserDetail) session.get(UserDetail.class, Long.parseLong(userID.toString()));
		System.out.println(userDetail2.getFirstName());
		session.getTransaction().commit();
		session.close();

	}

	private static void fetchFromQueryCache() {
		UserDetail userDetail = new UserDetail();
		userDetail.setFirstName("Manju");
		userDetail.setLastName("Kogunde");
		userDetail.setLastLoginDate(new Date());

		Session session = SESSION_FACTORY.openSession();
		session.beginTransaction();
		final Serializable userID = session.save(userDetail);
		session.getTransaction().commit();
		session.close();

		session = SESSION_FACTORY.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from UserDetail ud where ud.id = ?");
		query.setCacheable(true);
		query.setLong(0, Long.parseLong(userID.toString()));
		userDetail = (UserDetail) query.uniqueResult();
		System.out.println(userDetail.getFirstName());
		session.getTransaction().commit();
		session.close();

		session = SESSION_FACTORY.openSession();
		session.beginTransaction();
		Query query2 = session.createQuery("from UserDetail ud where ud.id = ?");
		query2.setCacheable(true);
		query2.setLong(0, Long.parseLong(userID.toString()));
		userDetail = (UserDetail) query2.uniqueResult();
		System.out.println(userDetail.getLastName());
		session.getTransaction().commit();
		session.close();
	}

}
