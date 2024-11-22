package Testing.spring.boot.services.impl;

import Testing.spring.boot.services.DataService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("Dev")
public class DataServiceImplDev implements DataService {
    @Override
    public String getData() {
        return "Dev Data";
    }
}
