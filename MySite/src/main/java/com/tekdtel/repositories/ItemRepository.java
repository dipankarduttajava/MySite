package com.tekdtel.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tekdtel.entity.Blog;
import com.tekdtel.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{
	List<Item> findByBlog(Blog blog,Pageable pageable);
}
