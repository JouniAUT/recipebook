package hh.sof03.recipebook.webcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hh.sof03.recipebook.domain.User;
import hh.sof03.recipebook.domain.UserRepository;

@Service
public class UserDetailImpl implements UserDetailsService {
	private final UserRepository userRepository;
	
	@Autowired
	public UserDetailImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User currentuser = userRepository.findByUsername(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(username, currentuser.getPasswordHash(),
				AuthorityUtils.createAuthorityList(currentuser.getRole()));
		return user;
	}
}
