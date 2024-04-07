package fr.inria.kata.smartfridge.protocol;

import java.util.List;
import java.util.Set;

import fr.inria.kata.smartfridge.Product;

import java.util.LinkedList;

public abstract class SmartFridgeProtocol {

    protected List<Product> products = new LinkedList<>();

    public final void dailyUpdate() {
        products.addAll(getNewProducts());

        for (Product p : products) {
            updateFreshness(p);
        }

        products.removeAll(getExpiringProducts());
    };

    public abstract List<Product> getNewProducts();

    public abstract void updateFreshness(Product p);

    public abstract List<Product> getExpiringProducts();

    public abstract List<Product> getProductsWith(Set<String> tags);
}
