package tn.JCITAZ.spring.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.JCITAZ.spring.entities.AppUser;
import tn.JCITAZ.spring.services.IAppUserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/SpringMVC/servlet")
public class AppUserRestController {
	private Logger logger = LoggerFactory.getLogger(AppUserRestController.class);

	@Autowired
	IAppUserService iUsersService;

	@GetMapping("/getAllusers")
	@ResponseBody
	public List<AppUser> getAllusers() {
		return iUsersService.getAllusers();
	}

	@PostMapping("/ajouterUser")
	@ResponseBody
	public AppUser ajouterUser(@RequestBody AppUser User) {
		iUsersService.ajouterUser(User);
		return User;

	}

	@DeleteMapping("/deleteUser/{id}")
	@ResponseBody
	public void deleteUser(@PathVariable("id") Long id) {
		iUsersService.deleteUser(id);
	}

	@PutMapping("/updateUser")
	@ResponseBody
	public AppUser updateUser(@RequestBody AppUser user) {
		return iUsersService.updateUser(user);
	}
}
