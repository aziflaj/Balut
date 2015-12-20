package com.aziflaj.balut.utils;

import java.net.URL;

public final class ResourceHelper {

    public static URL getResourceURL(String resourceName) {
        return ClassLoader.getSystemClassLoader().getResource(
                "" + resourceName);
    }

    public static URL getSelectedDice(int dice) {
        String resourceUrl = String.format("dices/selected/%d.png", dice);
        return ResourceHelper.getResourceURL(resourceUrl);
    }

    public static URL getUnselectedDice(int dice) {
        String resourceUrl = String.format("dices/unselected/%d.png", dice);
        return ResourceHelper.getResourceURL(resourceUrl);
    }
}
