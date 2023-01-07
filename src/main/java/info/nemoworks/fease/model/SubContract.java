package info.nemoworks.fease.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SubContract extends Entity {

    public static enum Type{
        PURCHASE,
        GUARANTEE,
        MORTGAGE
    }

    private String code;
    private String name;
    private String subject;
  

}
