package fr.inria.kata.smartfridge.protocol;

import java.util.Set;

public class ProductInformations {
    private String name;
    private String type;
    private Set<String> tags;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Set<String> getTags() {
        return tags;
    }
}
