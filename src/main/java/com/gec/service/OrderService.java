package com.gec.service;

import com.gec.pojo.Shopcars;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    List<Shopcars> findshopcarByUserIdAndId(Integer userId,int[] ids);
}
