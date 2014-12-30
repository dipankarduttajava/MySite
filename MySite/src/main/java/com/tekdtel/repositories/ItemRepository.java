package com.tekdtel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tekdtel.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
