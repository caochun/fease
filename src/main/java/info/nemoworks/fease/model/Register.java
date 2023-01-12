package info.nemoworks.fease.model;

import java.util.HashMap;
import java.util.Map;

public class Register {

    private Map<String, Class<?>> modelMap;


    private Register() {
        this.modelMap = new HashMap<>();
    }

    public void register(String name, Class<?> clazz) {
        this.modelMap.put(name, clazz);
    }

    public void unregister(String name) {
        this.modelMap.remove(name);
    }


    public Class<?> getModel(String name) {
        return this.modelMap.get(name);
    }

    private static Register register;

    public static Register getRegister() {
        if (register == null) {
            register = new Register();
        }
        return register;
    }
}
