package com.aziflaj.balut.utils;

import java.net.URL;

public final class ResourceHelper {

    public static URL getResourceURL(String resourceName) {
        return ClassLoader.getSystemClassLoader().getResource(
                "" + resourceName);
    }
}
