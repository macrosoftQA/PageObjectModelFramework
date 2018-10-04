package utilities;

import java.util.Random;

public class RandomValueGenerator {
	
	/*
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

    /*
     * Generate a random integer in the range 0 - 99999.
     */
    public static int generateRandomInteger() {
    	int min = 0;
    	int max = 99999;
    		
    		Random random = new Random();
    		return random.nextInt((max - min) + 1) + min;   
    }
    
    /*
     * Generate a random integer in the range 0 - 9
     */
    public static int generateRandomNumber() {
    	int min = 0;
    	int max = 9;
    		
    		Random random = new Random();
    		return random.nextInt((max - min) + 1) + min;   
    }

}
