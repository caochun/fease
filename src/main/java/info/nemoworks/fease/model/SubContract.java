package info.nemoworks.fease.model;

class SubContract extends Entity {

    public static enum Type{
        PURCHASE,
        GUARANTEE,
        MORTGAGE
    }

    private String code;
    private String name;
    private String subject;
  

}
