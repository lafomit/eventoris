package com.eventoris.web.auth;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.eventoris.service.UserManager;

import eventoris.datatypes.UserInfo;

public class DbUserDetailService implements UserDetailsService {

	protected final Log logger = LogFactory.getLog(getClass());
	private UserManager userManager;

	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		logger.info("DbUserDetailService: getting userSession for:" + userName);
		UserInfo userInfo = userManager.findUser(userName);

		if (userInfo == null) {
			throw new UsernameNotFoundException("Could not find user name");
		}
		logger.info("DbUserDetailService: found user:" + userInfo);
		List grantedAuths = new ArrayList();
		grantedAuths.add(new GrantedAuthorityImpl("ROLE_USER"));
		UserSessionInfo userSession = new UserSessionInfo(userName, "password",
				true, true, true, true, grantedAuths);
		userSession.setFamilyName(userInfo.getFamilyName());
		userSession.setId(userInfo.getId());
		userSession.setMainName(userInfo.getName());
		userSession.setEmail(userInfo.getEmail());
		
		return userSession;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

}
