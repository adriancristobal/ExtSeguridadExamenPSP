package dao.auth;

import jakarta.inject.Singleton;
import lombok.Data;

@Data
@Singleton
public class CacheAuthorization {
    private String username;
    private String pass;
    private String jwt;
}
