package tn.JCITAZ.spring.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import tn.JCITAZ.spring.entities.AppUser;


import tn.JCITAZ.spring.repository.UserRepository;

@Service
@Transactional
public class AppUserServiceImpl implements IAppUserService {

	@Autowired
	UserRepository usersRepository;

	@Override
	public List<AppUser> getAllusers() {
		Iterable<AppUser> allusers = usersRepository.findAll();
		List<AppUser> result = new ArrayList<AppUser>();
		allusers.forEach(result::add);
		return result;
	}

	@Override
	public Long ajouterUser(AppUser user) {
		usersRepository.save(user);
		return user.getId();
	}

	@Override
	public void deleteUser(Long id) {
		usersRepository.deleteById(id);
	}

	@Override
	public AppUser updateUser(AppUser user) {
		return usersRepository.save(user);

	}
}
