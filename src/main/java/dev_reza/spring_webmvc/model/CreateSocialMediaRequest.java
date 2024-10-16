package dev_reza.spring_webmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Reza Regata
 * @created 16/10/2024 - 21:46
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSocialMediaRequest {
    private String name;
    private String location;

}
