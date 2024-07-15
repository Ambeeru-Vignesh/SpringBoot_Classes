package com.vignesh.week1Introduction.IntroductionToSpringBoot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@ConditionalOnProperty(name = "deploy.env", havingValue = "Development")
public class DevDb implements DB {

    public String getData() {
        return "Development Data";
    }
}
