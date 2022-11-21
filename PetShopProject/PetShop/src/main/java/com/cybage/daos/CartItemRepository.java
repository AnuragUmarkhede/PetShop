package com.cybage.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.entities.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

}
