package info.nemoworks.fease.controller.dto;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;


public class Document extends BaseEntity {
    public final static String HISTORY_SUFFIX = "_his";

    private String uniqueId;

    private String schemaUniqueCode;

    private JSONObject content;

    private Status status;

    private Long version;

    private String commitId;

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public JSONObject getContent() {
        return Util.convertJson(content);
    }

    public void setContent(JSONObject content) {
        this.content = Util.convertJson(content);
    }




    public String getSchemaUniqueCode() {
        return schemaUniqueCode;
    }

    public void setSchemaUniqueCode(String schemaUniqueCode) {
        this.schemaUniqueCode = schemaUniqueCode;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format(
                "Document[id=%s, schemaUniqueCode='%s', content='%s']",
                this.getId(), schemaUniqueCode, content);
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getCommitId() {
        return commitId;
    }

    public void setCommitId(String commitId) {
        this.commitId = commitId;
    }

    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }
}
