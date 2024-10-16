package dev_reza.spring_webmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Reza Regata
 * @created 16/10/2024 - 21:15
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePersonRequest {

    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private CreateAddressRequest address;
    private List<String> hobbies;
    private List<CreateSocialMediaRequest> socialMedias;


}
