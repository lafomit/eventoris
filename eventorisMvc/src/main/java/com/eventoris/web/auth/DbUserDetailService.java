package com.eventoris.web.auth;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.eventoris.service.UserManager;

import eventoris.datatypes.UserInfo;

public class DbUserDetailService implements UserDetailsService {

	protected final Log logger = LogFactory.getLog(getClass());
	private UserManager userManager;

	@SuppressWarnings("deprecation")
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		logger.info("DbUserDetailService: getting userSession for:" + userName);
		UserInfo userInfo = userManager.findUser(userName);

		if (userInfo == null) {
			logger.info("DbUserDetailService: could not found user:" + userName);
			
			throw new UsernameNotFoundException("Could not find user name");
		}
		
		String password = userManager.getSubscriberPassword(userName);
		logger.info("DbUserDetailService: found user:" + userInfo);
		List<String> roles = userManager.getUserRoles(userName);
		logger.info("DbUserDetailService: user has " + roles.size() + " roles");
		List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
		for(String item :roles){
			logger.info("DbUserDetailService: found role="+ item);
			grantedAuths.add(new GrantedAuthorityImpl(item));
		}
		UserSessionInfo userSession = new UserSessionInfo(userName, password,
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
