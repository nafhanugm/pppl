package org.example.pertemuan2.util;

public class TestUtil {
    public static String generateRandomEmail() {
        return "testuser" + System.currentTimeMillis() + "@example.com";
    }

    public static class UserData {
        public static final String NAME = "Test User";
        public static final String PASSWORD = "password123";
        public static final String DAY = "15";
        public static final String MONTH = "6";
        public static final String YEAR = "1990";
        public static final String FIRST_NAME = "Test";
        public static final String LAST_NAME = "User";
        public static final String COMPANY = "Test Company";
        public static final String ADDRESS1 = "123 Test St";
        public static final String ADDRESS2 = "Apt 456";
        public static final String COUNTRY = "United States";
        public static final String STATE = "California";
        public static final String CITY = "Los Angeles";
        public static final String ZIPCODE = "90001";
        public static final String MOBILE_NUMBER = "1234567890";
    }
}