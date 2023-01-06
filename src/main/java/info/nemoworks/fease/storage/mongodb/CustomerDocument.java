package info.nemoworks.fease.storage.mongodb;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class CustomerDocument {

    @Id
    private String id;

    protected String name;

//    @DBRef
//    protected ContractDocument contract;

}
