package info.nemoworks.fease.repository.mongodb.model;

import info.nemoworks.fease.model.Contract;
import info.nemoworks.fease.model.Customer;
import lombok.Data;
import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;


@Document
@Data
public class ContractDocument {

    @Id
    private String id;

    private LocalDateTime date;

    @DBRef
    private Customer customer;

    @DBRef
    private List<Contract> subContracts;

    private JSONObject contents;

}
