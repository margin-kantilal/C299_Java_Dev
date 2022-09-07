package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {

	@Autowired
	private AppUserRepository appUserRepository;

	@Override
	public Optional<AppUser> findAppUser(Long id) {

		return appUserRepository.findById(id);

	}

	@Override
	public AppUser createAppUser(AppUser tempAppUser) {
		System.out.println("createAppUser");
		return appUserRepository.save(tempAppUser);
	}

	@Override
	public List<AppUser> getAppUsers() {

		return (List<AppUser>) appUserRepository.findAll();

	}
	
	   @Override
	    public AppUser updateUser(AppUser user, Long id ) {

	        if (appUserRepository.findById(id).isPresent()){
	        	
	        	AppUser existingUser = appUserRepository.findById(id).get();

	        	existingUser.setName(user.getName());
	        	existingUser.setAddress(user.getAddress());
	        	existingUser.setPhoneNumber(user.getPhoneNumber());

	        	AppUser updatedUser= appUserRepository.save(existingUser);

	            return new AppUser(updatedUser.getId() , updatedUser.getName(),
	            		updatedUser.getAddress(), updatedUser.getPhoneNumber());
	        }else{
	            return null;
	        }
	    }

	public void deleteById(Long id) {
		
		appUserRepository.deleteById(id);
		}
		


	public void delete(AppUser entity) {
		
	}


	
	public AppUser findUserById(long id) {
		// TODO Auto-generated method stub
		AppUser existedUser = appUserRepository.findById(id);
		return existedUser;
	}

	
	public <S extends AppUser> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public <S extends AppUser> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<AppUser> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public AppUser deleteUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
