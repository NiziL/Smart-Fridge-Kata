package fr.inria.kata.smartfridge.protocol;

import java.util.List;
import java.util.Set;

import fr.inria.kata.smartfridge.Product;

import java.util.LinkedList;

public abstract class SmartFridgeProtocol {

    private List<Product> products = new LinkedList<>();

    public List<Product> getProducts() {
        return products;
    }

    public final void dailyUpdate() {
        // scan and add new items
        getProducts().addAll(getNewProducts());
        // update freshness
        getProducts().parallelStream().forEach(p -> updateFreshness(p));
        // remove expired products
        getProducts().removeAll(getExpiringProducts());
    };

    public abstract List<Product> getNewProducts();

    public abstract void updateFreshness(Product p);

    public abstract List<Product> getExpiringProducts();

    public abstract List<Product> getProductsWith(Set<String> tags);

}
