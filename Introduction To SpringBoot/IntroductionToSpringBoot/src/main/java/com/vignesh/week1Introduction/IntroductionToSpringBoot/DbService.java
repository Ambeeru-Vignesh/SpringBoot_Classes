package com.vignesh.week1Introduction.IntroductionToSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class DbService {

    final DB Db;

    public DbService(DB Db) {
        this.Db = Db;
    }

    String getData() {
        return Db.getData();
    }
}
