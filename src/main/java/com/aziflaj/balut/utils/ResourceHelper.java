package com.aziflaj.balut.utils;

import java.net.URL;

/**
 * A helper class for accessing the resources in the {@code resources} directory
 */
public final class ResourceHelper {

    /**
     * Gets a generic resource by its path
     * @param resourcePath The path of the resource to find
     * @return The URL of the resource found
     */
    public static URL getResourceURL(String resourcePath) {
        return ClassLoader.getSystemClassLoader().getResource(
                "" + resourcePath);
    }

    /**
     * Gets a selected dice face from the specified directory
     * @param dice The value of the dice
     * @return The URL of the selected dice
     */
    public static URL getSelectedDice(int dice) {
        String resourceUrl = String.format("dices/selected/%d.png", dice);
        return ResourceHelper.getResourceURL(resourceUrl);
    }

    /**
     * Gets a selected dice face from the specified directory
     * @param dice The value of the dice
     * @return The URL of the unselected dice
     */
    public static URL getUnselectedDice(int dice) {
        String resourceUrl = String.format("dices/unselected/%d.png", dice);
        return ResourceHelper.getResourceURL(resourceUrl);
    }
}
