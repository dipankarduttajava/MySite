package com.tekdtel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekdtel.entity.Blog;
import com.tekdtel.entity.User;
import com.tekdtel.repositories.BlogRepository;
import com.tekdtel.repositories.UserRepository;

@Service
public class BlogService {
	@Autowired
	private BlogRepository blogRepository;
	@Autowired
	private UserRepository userRepository;

	public void save(Blog blog, String name) {
		User user = userRepository.findByName(name);	
		blog.setUser(user);
		
		blogRepository.save(blog);
	}

}
