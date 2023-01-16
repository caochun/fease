package info.nemoworks.fease.controller.dto;

import com.alibaba.fastjson.JSONObject;
import info.nemoworks.fease.model.Contract;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DtoMapperTests {

    private JSONObject jsonObject;

    @BeforeEach
    public void init() throws Exception {
        jsonObject = JSONObject.parseObject(new String(getClass().getClassLoader().getResourceAsStream("contract_main.json").readAllBytes()));
    }


    @Test
    public void testJSONObjectValid() {
        assertNotNull(jsonObject);
    }

    @Test
    public void testContractJSONToContractObject() {
        Contract contract = DtoMapper.INSTANCE.jsonObjectToContract(jsonObject);
        assertEquals(contract.getCode(), "TDjZ-2019-HZ-1015");
    }
}
