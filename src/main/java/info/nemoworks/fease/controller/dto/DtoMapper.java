package info.nemoworks.fease.controller.dto;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.alibaba.fastjson.parser.Feature;
import info.nemoworks.fease.model.Contract;

import java.util.Map;

public class DtoMapper {

    public static DtoMapper INSTANCE = new DtoMapper();

    public Contract jsonObjectToContract(JSONObject jsonObject) {
        int disableDecimalFeature = JSON.DEFAULT_PARSER_FEATURE & ~Feature.UseBigDecimal.getMask() ;
        Contract contract = Contract.builder()
                .code(jsonObject.getJSONObject("content").getJSONObject("formData").getString("ContractCode"))
                .build();
        contract.setContents(JSON.parseObject(jsonObject.getJSONObject("content").getString("formData"), Map.class, disableDecimalFeature));
        contract.setId(jsonObject.getString("_id"));

        contract.getContents().remove("interestTaxRate");
        contract.getContents().remove("purchasePrice");
        contract.getContents().remove("marginList");
        contract.getContents().remove("leaseBasic");
        contract.getContents().remove("rateFloatValue");
        contract.getContents().remove("assetsAmount");
        contract.getContents().remove("ContractNum");
        contract.getContents().remove("grantPlan");
        contract.getContents().remove("CommonLessees");
        contract.getContents().remove("agreedRepayMent");
        contract.getContents().remove("baseRate");
        contract.getContents().remove("annualInterestRate");
        contract.getContents().remove("LeaInsType");
        contract.getContents().remove("principal");
        contract.getContents().remove("overDayIntRate");
        contract.getContents().remove("chargeList");
        contract.getContents().remove("zeroRent");
        contract.getContents().remove("_transfer");
        contract.getContents().remove("zeroRentRate");
        contract.getContents().remove("zeroRent");

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
