package com.tekdtel.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tekdtel.entity.Blog;
import com.tekdtel.entity.Item;
import com.tekdtel.entity.Role;
import com.tekdtel.entity.User;
import com.tekdtel.repositories.BlogRepository;
import com.tekdtel.repositories.ItemRepository;
import com.tekdtel.repositories.RoleRepository;
import com.tekdtel.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BlogRepository blogRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findOne(Integer id){
		return userRepository.findOne(id);
	}
	
	
	@Transactional
	public User findOneWithBlogs(Integer id){
		User user = findOne(id);
		List<Blog> blogs = blogRepository.findByUser(user);
		
		for(Blog blog : blogs){
			List<Item> items = itemRepository.findByBlog(blog,new PageRequest(0, 10,Direction.DESC, "publishedDate"));
			blog.setItems(items);
		}
		
		user.setBlogs(blogs);
		return user;
	}

	@Transactional
	public void save(User user) {
		user.setEnable(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		
		
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleRepository.findByName("ROLE_USER"));
		user.setRoles(roles);
		
		userRepository.save(user);
		
		
		
		
	}
}
