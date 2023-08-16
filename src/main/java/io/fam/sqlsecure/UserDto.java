package io.fam.sqlsecure;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    @NotEmpty(message = "Please enter a valid name.")
    private String name;

    @NotEmpty(message = "Please enter a valid email.")
    @Email
    private String email;

    @NotEmpty(message = "Please enter a valid password.")
    private String password;
    
}
