package info.nemoworks.fease.controller.dto;

public enum Status {
    //最新状态和修改状态的数据存储表相同
    NEW("new", ""), // 最新状态，即创建后未生效过
    RELEASE("release", "_res"), // 生效状态
    MODIFIED("modified", ""); // 修改状态，即生效后又做修改

    /**
     * 状态
     */
    private String code;
    /**
     * 表后缀
     */
    private String suffix;

    private Status(String code, String suffix) {
        this.setCode(code);
        this.setSuffix(suffix);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
