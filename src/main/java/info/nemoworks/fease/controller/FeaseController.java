package info.nemoworks.fease.controller;

import com.alibaba.fastjson.JSONObject;
import info.nemoworks.fease.controller.dto.Document;
import info.nemoworks.fease.controller.dto.DtoMapper;
import info.nemoworks.fease.service.FeaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/archive")
public class FeaseController {
    @Autowired
    FeaseService feaseService;

//    @Autowired
//    SchemaService schemaService;

    private static final Logger logger = LoggerFactory.getLogger(FeaseController.class);

    @PostMapping("/document")
    public Document createLastDocument(@RequestBody JSONObject content,
                                       @RequestParam(required = true) String schemaUniqueCode,
                                       @RequestParam(required = true) String collectionName) {
        logger.info("create new document.");
//        Class<?> modelClass = Register.getRegister().getModel(collectionName);
//        if (modelClass != null) {
//
//
//        }
        switch (collectionName) {
            case "contract":
                return DtoMapper.INSTANCE.contractToDocument(feaseService.saveContract(DtoMapper.INSTANCE.jsonObjectToContract(content)));
        }
        return null;

    }
}
