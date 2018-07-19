package com.java.spring.envers.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.java.spring.envers.domain.UserDetails;
import com.java.spring.envers.domain.UserDetailsAudit;
import com.java.spring.envers.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	/**
	 * Returns user details.
	 * 
	 * @param id
	 *            Long
	 * @return UserDetails
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody UserDetails fetchUser(@PathVariable final Long id) {
		log.info("Fetching user...");
		return userService.fetchUser(id);
	}

	/**
	 * Creates user.
	 * 
	 * @param user
	 *            UserDetails
	 * @return UserDetails
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody UserDetails createUser(final @RequestBody UserDetails user) {
		return userService.createUser(user);
	}

	/**
	 * Updates user.
	 * 
	 * @param id
	 *            Long
	 * @param user
	 *            UserDetails
	 * @return UserDetails
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody UserDetails updateUser(@PathVariable final Long id, final @RequestBody UserDetails user) {
		user.setId(id);
		return userService.updateUser(user);
	}

	/**
	 * Deletes user.
	 * 
	 * @param id
	 *            Long
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable final Long id) {
		// userService.deleteUser(id);
		userService.softDeleteUser(id);
	}

	/**
	 * Returns audit history.
	 * 
	 * @param id
	 *            Long
	 * @return List<UserDetailsAudit>
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@RequestMapping(value = "/{id}/history")
	public @ResponseBody List<UserDetailsAudit> fetchAuditHistory(@PathVariable final Long id) {
		return userService.fetchAuditHistory(id);
	}
}
