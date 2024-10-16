package dev_reza.spring_webmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Reza Regata
 * @created 16/10/2024 - 21:39
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAddressRequest {
    private String street;
    private String city;
    private String state;
    private String zipCode;
}
