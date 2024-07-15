package com.vignesh.week1Introduction.IntroductionToSpringBoot;

import org.springframework.stereotype.Component;

@Component
public class ProdDb implements DB {

    public String getData() {
        return "Production Data";
    }

}
