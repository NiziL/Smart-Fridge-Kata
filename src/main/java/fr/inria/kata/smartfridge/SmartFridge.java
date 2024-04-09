package fr.inria.kata.smartfridge;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

import fr.inria.kata.smartfridge.protocol.SmartFridgeProtocol;
import fr.inria.kata.smartfridge.protocol.SmartRecognitionEngine;
import fr.inria.kata.smartfridge.protocol.SmartRecognitionEngine.ProductInformations;;

public class SmartFridge extends SmartFridgeProtocol {

    Map<Product, Integer> memory = new HashMap<>();

    @Override
    public void updateFreshness(Product p) {
        int freshness = p.getFreshness();

        p.setFreshness(freshness - 5);

        if (p.getType() != "yogourt"
                && p.getType() != "meat"
                && p.getType() != "vegetable"
                && p.getType() != "mushroom"
                && p.getType() != "eternal") {
            p.setFreshness(p.getFreshness() - (int) (Math.random() * 11));
            return;
        }

        int newfreshness = 0;
        if (p.getType() == "vegetable") {
            newfreshness = (int) (Math.random() * 6 + 15);
        } else if (p.getType() == "meat") {
            newfreshness = 5;
            Integer tmp = memory.get(p);
            if (tmp == null) {
                memory.put(p, (int) (Math.random() * 3 + 2));
            } else if (tmp == 0) {
                newfreshness += 10;
            } else {
                memory.put(p, tmp - 1);
            }
        } else if (p.getType() == "mushroom") {
            if (p.getFreshness() > 50) {
                p.setFreshness(p.getFreshness() - 5);
            }
            return;
        }

        p.setFreshness(p.getType() == "eternal" ? freshness : p.getFreshness() - newfreshness);
    }

    @Override
    public List<Product> getProductsWith(Set<String> tags) {
        List<Product> list = new ArrayList<>();
        for (Product p : this.getProducts()) {
            int check = 0;
            for (String tag : p.getTags()) {
                for (String tagSearched : tags) {
                    if (tag.equals(tagSearched))
                        check++;
                }
            }
            if (check == tags.size()) {
                list.add(p);
            }
        }
        return list;
    }

    @Override
    public List<Product> getExpiringProducts() {
        List<Product> list = new ArrayList<>();
        for (Product p : this.getProducts()) {
            if (p.getFreshness() <= 0)
                list.add(p);
        }
        return list;
    }

    @Override
    public List<Product> getNewProducts() {
        List<Product> products = new ArrayList<>();
        List<ProductInformations> news = SmartRecognitionEngine.scanNewProducts();
        for (ProductInformations infos : news) {
            products.add(new Product(infos.getName(), infos.getType(), infos.getTags()));
        }
        return products;
    }

}
