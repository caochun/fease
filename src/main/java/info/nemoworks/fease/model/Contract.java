package info.nemoworks.fease.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.codehaus.jettison.json.JSONObject;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Contract extends Entity {

    private String code;

    private LocalDate date;

    private Customer customer;

    private List<SubContract> subContracts;

    private Map<String, Object> contents;

    private List<Project> projects;

}
