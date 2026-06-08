package com.PracticeRESTAPI.PracticeRESTAPI.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    //model mapper used to convert student to studentDto

    @Bean
    public ModelMapper modelMapper(){

        return new ModelMapper();
    }
}
