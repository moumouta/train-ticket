package edu.cuhksz.swaggergenerator.entity.vo;

import lombok.Builder;
import lombok.Data;

/**
 * address.
 *
 * @author pdai
 */
@Data
@Builder
public class AddressVo {

    private String city;

    private String zipcode;
}
