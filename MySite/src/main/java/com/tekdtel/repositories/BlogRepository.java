package com.tekdtel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tekdtel.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer>{

}
