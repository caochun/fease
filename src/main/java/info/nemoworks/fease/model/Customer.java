package info.nemoworks.fease.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
public class Customer extends Entity {

    private String name;


}
