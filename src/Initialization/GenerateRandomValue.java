package Initialization;

import java.util.Random;

public class GenerateRandomValue {

    /**
     * Generate a random string.
     */
    public static String generateRandomStringtest() {
    	  
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) 
              (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString;
    }

    public static int generateRandomInteger() {
    	int min = 0;
    	int max = 20;
    		
    		Random random = new Random();
    		return random.nextInt((max - min) + 1) + min;   
    }
}