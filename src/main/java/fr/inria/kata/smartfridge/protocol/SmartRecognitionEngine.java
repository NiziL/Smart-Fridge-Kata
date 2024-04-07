package fr.inria.kata.smartfridge.protocol;

import java.nio.channels.NotYetConnectedException;
import java.util.List;
import java.util.Set;

public class SmartRecognitionEngine {

    public static class ProductInformations {
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

    public static List<ProductInformations> scanNewProducts() throws NotYetConnectedException {
        /*
         * Do not use the server during test ;)
         */
        throw new NotYetConnectedException();
    }

}
