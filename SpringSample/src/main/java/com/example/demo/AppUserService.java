package com.example.demo;

import java.util.List;
import java.util.Optional;

public interface AppUserService {

	Optional<AppUser> findAppUser(Long id);

	List<AppUser> getAppUsers();

	AppUser createAppUser(AppUser appUser);

	AppUser updateUser(AppUser user, Long id);
	AppUser deleteUser(Long id);
	
	// Delete -> AppUser based on ID.
	
	// Update -> AppUser Details based on the ID
	
}
