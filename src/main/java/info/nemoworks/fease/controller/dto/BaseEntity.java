package info.nemoworks.fease.controller.dto;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.List;

public class BaseEntity implements Serializable {
    private static final long serialVersionUID = -7334806723394863536L;

    private String id;

    private String createdTime;//创建时间

    private String createdUserId;//创建用户ID

    private String alteredTime;//修改时间


    private String alteredUserId;//修改用户ID

    private String createdOrgId;//创建组织机构ID


    private String alteredOgrId;//修改组织机构ID

    private List<String> currentOrgIds;//封装当前登陆人的组织机构id

    public String getAlteredOgrId() {
        return alteredOgrId;
    }

    public void setAlteredOgrId(String alteredOgrId) {
        this.alteredOgrId = alteredOgrId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedOrgId() {
        return createdOrgId;
    }

    public void setCreatedOrgId(String createdOrgId) {
        this.createdOrgId = createdOrgId;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId;
    }

    public String getAlteredTime() {
        return alteredTime;
    }

    public void setAlteredTime(String alteredTime) {
        this.alteredTime = alteredTime;
    }

    public String getAlteredUserId() {
        return alteredUserId;
    }

    public void setAlteredUserId(String alteredUserId) {
        this.alteredUserId = alteredUserId;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || (obj.getClass() != this.getClass())) {
            return false;
        }

        try {
            return ((BaseEntity) obj).getId().equals(this.getId());
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.getId().hashCode();
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public List<String> getCurrentOrgIds() {
        return currentOrgIds;
    }

    public void setCurrentOrgIds(List<String> currentOrgIds) {
        this.currentOrgIds = currentOrgIds;
    }
}
