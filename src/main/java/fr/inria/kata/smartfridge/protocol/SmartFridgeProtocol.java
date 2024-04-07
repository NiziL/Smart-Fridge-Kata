package fr.inria.kata.smartfridge.protocol;

import java.util.List;
import java.util.Set;

import fr.inria.kata.smartfridge.Product;

import java.util.LinkedList;

public abstract class SmartFridgeProtocol {

    protected List<Product> products = new LinkedList<>();

    public final void dailyUpdate() {
        // scan and add new items
        products.addAll(getNewProducts());
        // update freshness
        products.parallelStream().forEach(updateFreshness(p));
        // remove expired products
        products.removeAll(getExpiringProducts());
    };

    public abstract List<Product> getNewProducts();

    public abstract void updateFreshness(Product p);

    public abstract List<Product> getExpiringProducts();

    public abstract List<Product> getProductsWith(Set<String> tags);
}
