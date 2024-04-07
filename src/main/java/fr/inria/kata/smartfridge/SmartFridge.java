package fr.inria.kata.smartfridge;

import java.util.List;
import java.util.Set;

import fr.inria.kata.smartfridge.protocol.SmartFridgeProtocol;

public class SmartFridge extends SmartFridgeProtocol {

    @Override
    public void updateFreshness(Product p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateFreshness'");
    }

    @Override
    public List<Product> getProductsWith(Set<String> tags) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductsWith'");
    }

    @Override
    public List<Product> getExpiringProducts() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getExpiringProducts'");
    }

    @Override
    public List<Product> getNewProducts() {
        throw new UnsupportedOperationException("Unimplemented method 'getNewProducts'");
    }

}
