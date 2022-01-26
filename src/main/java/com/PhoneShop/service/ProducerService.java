package com.PhoneShop.service;

import com.PhoneShop.entity.ProducerEntity;
import com.PhoneShop.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.PhoneShop.model.Producer;
import com.PhoneShop.repository.ProducerRepository;

import java.util.List;

@Service
public class ProducerService {

    @Autowired
    private  ProducerRepository producerRepository;

    public List<ProducerEntity> findAll(){
        List<ProducerEntity> producerEntities = producerRepository.findAll();
        return new ModelMapper().map(producerEntities, new TypeToken<List<Producer>>() {}.getType());
    }
}
