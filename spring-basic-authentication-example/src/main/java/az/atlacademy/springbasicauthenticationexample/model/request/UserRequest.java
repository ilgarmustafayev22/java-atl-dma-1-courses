package az.atlacademy.springbasicauthenticationexample.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private String name;
    private String surname;
    private String username;
    private String password;
    private Integer age;

}
