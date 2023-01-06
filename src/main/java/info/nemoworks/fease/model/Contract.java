package info.nemoworks.fease.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Contract extends Entity {

    private String code;

    private LocalDateTime date;

    private Customer customer;

    private List<SubContract> subContracts;

    private Map<String, Object> contents;

    private List<Project> projects;

}
