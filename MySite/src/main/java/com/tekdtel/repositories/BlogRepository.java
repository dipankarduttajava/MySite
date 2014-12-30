package com.tekdtel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tekdtel.entity.Blog;
import com.tekdtel.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer>{
	List<Blog> findByUser(User user);
}
