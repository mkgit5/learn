package com.java.spring.envers.services;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.java.spring.envers.dao.UserDetailsAudDao;
import com.java.spring.envers.dao.UserDetailsDao;
import com.java.spring.envers.domain.UserDetails;
import com.java.spring.envers.domain.UserDetailsAudit;

@Service
public class UserService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserDetailsDao userDao;

	@Autowired
	private UserDetailsAudDao userAuditDao;

	@Transactional(readOnly = true, rollbackFor = RuntimeException.class)
	public UserDetails fetchUser(final Long userId) {
		log.info("Fetching user...");
		UserDetails userDetails = userDao.findById(userId);
		if (userDetails == null) {
			userDetails = new UserDetails();
		}
		return userDetails;
	}

	@Transactional(readOnly = false, rollbackFor = RuntimeException.class)
	public UserDetails createUser(final @RequestBody UserDetails user) {
		log.info("Creating user...");
		final Date currentTime = Calendar.getInstance().getTime();
		user.setCreatedBy("Manju");
		user.setCreatedDate(new Timestamp(currentTime.getTime()));
		user.setUpdatedBy("Manju");
		user.setUpdateDate(new Timestamp(currentTime.getTime()));
		user.setRetired('N');
		return userDao.insert(user);
	}

	@Transactional(readOnly = false, rollbackFor = RuntimeException.class)
	public UserDetails updateUser(final @RequestBody UserDetails user) {
		log.info("Updating user...");
		UserDetails userDetails = userDao.findById(user.getId());
		userDetails.setFirstName(user.getFirstName());
		userDetails.setLastName(user.getLastName());
		userDetails.setEmailId(user.getEmailId());
		final Date currentTime = Calendar.getInstance().getTime();
		userDetails.setUpdatedBy("Manju");
		userDetails.setUpdateDate(new Timestamp(currentTime.getTime()));
		return userDao.update(userDetails);
	}

	@Transactional(readOnly = false, rollbackFor = RuntimeException.class)
	public void deleteUser(final Long userId) {
		log.info("Deleting user...");
		UserDetails userDetail = userDao.findById(userId);
		userDao.delete(userDetail);
	}

	@Transactional(readOnly = false, rollbackFor = RuntimeException.class)
	public void softDeleteUser(final Long userId) {
		log.info("Deleting user...");
		UserDetails userDetail = userDao.findById(userId);
		userDetail.setRetired('Y');
		final Date currentTime = Calendar.getInstance().getTime();
		userDetail.setUpdatedBy("Manju");
		userDetail.setUpdateDate(new Timestamp(currentTime.getTime()));
		userDao.update(userDetail);
	}

	@Transactional(readOnly = true)
	public List<UserDetailsAudit> fetchAuditHistory(Long id) {
		return userAuditDao.fetchAuditsById(id);
	}

}
