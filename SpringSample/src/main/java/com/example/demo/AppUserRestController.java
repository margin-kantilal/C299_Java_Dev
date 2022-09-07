package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppUserRestController {

	@Autowired
	private AppUserServiceImpl appUserServiceImpl;

	@GetMapping("/helloWorld")
	public String helloWorld() {
		return "helloWorld";
	}

	@GetMapping("/allAppUser")
	public String getAllAppUser() {
		return "helloWorld";
	}

	@GetMapping("/createAppUsers")
	public String createAppUsers(@RequestParam(value = "count", defaultValue = "1") Long count) {

		return appUserServiceImpl.getAppUsers().toString();
	}
	
	
	  @PostMapping(path="/createUser") 
	  public @ResponseBody String createUser (@RequestBody AppUser user) {
		  appUserServiceImpl.createAppUser(user);
	    return "Saved";
	  }
	  
	  @PutMapping(value="updateUser", produces = MediaType.APPLICATION_JSON_VALUE)
	  @ResponseStatus(HttpStatus.OK)
	  public ResponseEntity<AppUser>  updateUser (@RequestParam Long id, 
			  @RequestBody AppUser user) {
		  
		  return new ResponseEntity<>(
				  appUserServiceImpl.updateUser(user, id), HttpStatus.OK);
	  }
	  
	  

		@DeleteMapping("/deleteAppUser")
		@ResponseStatus(HttpStatus.OK)
		public String deleteAppUser(@RequestParam Long id) {
			// Logic to delete the AppUser based on the ID.
			 appUserServiceImpl.deleteById(id);
			return "Deleted";
		}
	 
		@GetMapping("/getAppUserById")
		@ResponseStatus(HttpStatus.OK)
		public AppUser getAppUserById(@RequestParam Long id) {
			// Logic to delete the AppUser based on the ID.
			 return  appUserServiceImpl.findUserById(id);
		}
		
	 
}
