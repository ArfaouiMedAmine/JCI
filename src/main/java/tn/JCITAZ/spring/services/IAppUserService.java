package tn.JCITAZ.spring.services;

import java.util.List;

import tn.JCITAZ.spring.entities.AppUser;



public interface IAppUserService {

	public List<AppUser> getAllusers();
	public Long ajouterUser(AppUser user);
	public void deleteUser(Long id);
	public AppUser updateUser(AppUser user);

}
