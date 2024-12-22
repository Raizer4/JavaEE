package com.dmdev.spring.mapper;

import org.springframework.stereotype.Component;

@Component
public interface Mapper<F, T>{
    T map(F object);

    default T map(F fromObject, T toObject){
        return toObject;
    }

}
