package fr.inria.kata.smartfridge;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Random;

import fr.inria.kata.smartfridge.protocol.SmartFridgeProtocol;
import fr.inria.kata.smartfridge.protocol.SmartRecognitionServer;
import fr.inria.kata.smartfridge.protocol.SmartRecognitionServer.ProductInformations;;

public class SmartFridge extends SmartFridgeProtocol {

    // we had some troubles with the update for meat
    // so we've added this to keep track of number of days elapsed
    Map<Product, Integer> memory = new HashMap<>();

    @Override
    public void updateFreshness(Product p) {
        int freshness = p.getFreshness();

        p.setFreshness(freshness - 5);

        if (p.getType() != "yogourt")
            p.setFreshness(p.getFreshness() - (int) (Math.random() * 10));

        int newfreshness = 0;
        if (p.getType() == "vegetable") {
            newfreshness = (int) (Math.random() * 5 + 15);
        } else if (p.getType() == "meat") {
            newfreshness = 10;
            Integer tmp = memory.get(p);
            if (tmp == null) {
                memory.put(p, 0);
            } else if (tmp < 3) {
                newfreshness *= 2;
            }
        } else if (p.getType() == "mushroom") {
            if (p.getFreshness() > 50) {
                p.setFreshness(p.getFreshness() - 5);
            }
            return;
        } else if (p.getType() == "yogourt") {
            return;
        }

        p.setFreshness(p.getType() == "eternal" ? freshness : freshness - newfreshness);
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
                if (check >= tags.size()) {
                    list.add(p);
                }
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
        // update meat memory during scan
        memory.forEach((k, v) -> memory.replace(k, v + 1));
        // Contact server
        List<Product> products = new ArrayList<>();
        List<ProductInformations> news = SmartRecognitionServer.scanNewProducts();
        for (ProductInformations infos : news) {
            products.add(new Product(infos.getName(), infos.getType(), infos.getTags()));
        }
        return products;
    }

}
