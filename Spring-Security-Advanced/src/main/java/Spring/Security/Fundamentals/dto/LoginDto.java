package Spring.Security.Fundamentals.dto;

import lombok.Data;

@Data
public class LoginDto {
    String email;
    String password;
}