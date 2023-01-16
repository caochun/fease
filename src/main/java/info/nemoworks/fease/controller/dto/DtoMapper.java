package info.nemoworks.fease.controller.dto;

import com.alibaba.fastjson.JSONObject;
import info.nemoworks.fease.model.Contract;

public class DtoMapper {

    public static DtoMapper INSTANCE = new DtoMapper();

    public Contract jsonObjectToContract(JSONObject jsonObject) {
        Contract contract = Contract.builder()
                .code(jsonObject.getJSONObject("content").getJSONObject("formData").getString("ContractCode"))
                .build();
        return contract;
    }

    public JSONObject contractToJSONObject(Contract contract) {
        return Util.convertJson(contract);
    }

    public Document jsonObjectToDocument(JSONObject jsonObject) {
        //TODO
        return null;
    }

    public Document contractToDocument(Contract contract) {
        return jsonObjectToDocument(contractToJSONObject(contract));
    }

}
