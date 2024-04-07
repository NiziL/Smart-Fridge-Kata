package fr.inria.kata.smartfridge;

import java.util.Set;

public class Product {
    private String name;
    private String type;
    private int freshness;
    private Set<String> tags;

    public Product(String name, String type, Set<String> tags) {
        this.name = name;
        this.type = type;
        this.freshness = 100;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFreshness() {
        return freshness;
    }

    public void setFreshness(int freshness) {
        this.freshness = freshness;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }
}
