package ru.novotelecom.java_training.soap;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeoIpServiceTests {

    @Test
    public void testMyIp() {
        GeoIP geoIP=new GeoIPService().getGeoIPServiceSoap12().getGeoIP("192.168.144.34");
        assertEquals(geoIP.getCountryCode(),"RUS");

    }
}
