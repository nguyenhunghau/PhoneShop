package com.PhoneShop.repository;

import com.PhoneShop.entity.ProducerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducerRepository  extends JpaRepository<ProducerEntity, Integer> {
}
