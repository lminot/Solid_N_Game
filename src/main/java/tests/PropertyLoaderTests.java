package tests;

import org.junit.Test;
import utils.PropertyLoader;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lucien.Minot on 8/26/2015.
 */
public class PropertyLoaderTests {

    private static String fileName = "messages.properties";
    String newProperty = null;

    @Test
    public void itCatGetValuesFromThePropertiesFile() throws Exception {

        PropertyLoader propLoader = new PropertyLoader();
        newProperty = propLoader.getPropertyValue(fileName, "movesMade");
        assertEquals(newProperty,"Moves made: ");

    }
}
