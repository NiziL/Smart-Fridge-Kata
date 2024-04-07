package fr.inria.kata.smartfridge.protocol;

import java.nio.channels.NotYetConnectedException;
import java.util.List;

public class SmartRecognitionServer {

    public static List<ProductInformations> scanNewProducts() throws NotYetConnectedException {
        /*
         * Do not use the server during test ;)
         */
        throw new NotYetConnectedException();
    }

}
