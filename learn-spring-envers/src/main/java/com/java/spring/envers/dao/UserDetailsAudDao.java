package com.java.spring.envers.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.spring.envers.domain.UserDetailsAudit;

@Repository
public class UserDetailsAudDao extends BaseDao<UserDetailsAudit> {

	@SuppressWarnings("unchecked")
	public List<UserDetailsAudit> fetchAuditsById(final Long id) {
		return createNamedQuery("UserDetailsAudit.findById").setParameter("id", id).getResultList();
	}

}
