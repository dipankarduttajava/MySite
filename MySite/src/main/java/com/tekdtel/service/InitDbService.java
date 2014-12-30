package com.tekdtel.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekdtel.entity.Blog;
import com.tekdtel.entity.Item;
import com.tekdtel.entity.Role;
import com.tekdtel.entity.User;
import com.tekdtel.repositories.BlogRepository;
import com.tekdtel.repositories.ItemRepository;
import com.tekdtel.repositories.RoleRepository;
import com.tekdtel.repositories.UserRepository;
@Transactional
@Service
public class InitDbService {
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	BlogRepository blogRepository;
	@Autowired
	UserRepository userRepository;
	
	@PostConstruct
	public void init(){
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleUser.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		
		User userAdmin = new User();
		userAdmin.setName("admin");
		userAdmin.setRoles(roles);
		
		userRepository.save(userAdmin);
		
		Blog blog = new Blog();
		blog.setName("TekDtel");
		blog.setUrl("http://tekdtel.com");
		blog.setUser(userAdmin);
		blogRepository.save(blog);
		
		Item item1 = new Item();
		item1.setBlog(blog);
		item1.setTitle("First");
		item1.setLink("http://tekdtel.com");
		item1.setPublishedDate(new Date());
		
		itemRepository.save(item1);
		
		Item item2 = new Item();
		item2.setBlog(blog);
		item2.setTitle("Second");
		item2.setLink("http://tekdtel.com");
		item2.setPublishedDate(new Date());
		
		itemRepository.save(item2);
	}
	
	
}
