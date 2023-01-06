package info.nemoworks.fease.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends Entity {

    private String name;

//    protected Contract contract;

}
