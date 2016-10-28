package com.musala.atmosphere.bitmap.comparison.kmp;

/**
 * Implements an algorithm that determines whether the small array is a subarray of the big array.
 * 
 * @author denis.bialev
 * 
 */
public class ArrayComparator {
    /**
     * Pre processes the pattern array based on proper prefixes and proper suffixes at every position of the array.
     * 
     * @param pattern
     *        - array that will be pre-processed
     * @return partial match array which indicates the next possible position for the algorithm to start searching.
     */
    public static int[] preProcessPattern(long[] pattern) {
        int patternLength = pattern.length;
        int[] preprocessedArray = new int[patternLength + 1];
        preprocessedArray[0] = -1;

        int j = -1;
        for (int i = 1; i < patternLength; i++) {
            while (j >= 0 && pattern[i - 1] != pattern[j]) {
                // if there is mismatch consider next widest border
                j = preprocessedArray[j];
            }
            j++;
            preprocessedArray[i] = j;
        }

        return preprocessedArray;

    }

    /**
     * 
     * It determines whether the small array is a subarray of the big array.
     * 
     * @param bigArray
     *        - array over which search happens
     * @param smallArray
     *        - pattern that is to be searched
     * @param preprocessedArray
     *        - preprocessedArray of the smallArray
     * @return <code>true</code> if the smallArray is found in the bigArray and <code>false</code> otherwise.
     */
    public static boolean searchSubArray(long[] bigArray, long[] smallArray, int[] preprocessedArray) {
        // pattern and text lengths
        int patternLength = smallArray.length;
        int bigArrayLength = bigArray.length;

        // initialize new array and preprocess the pattern
        int[] preprocessedPattern = preprocessedArray;

        int j = 0;
        for (int i = 0; i < bigArrayLength; i++) {
            while (j >= 0 && bigArray[i] != smallArray[j]) {
                j = preprocessedPattern[j];
            }

            j++;
            // a match is found
            if (j == patternLength) {
                return true;
            }

        }

        return false;
    }

    /**
     * 
     * It determines whether the small array is a subarray of the big array.
     * 
     * @param bigArray
     *        -array over which search happens
     * @param smallArray
     *        -pattern that is to be searched
     * @return <code>true</code> if the smallArray is found in the bigArray and <code>false</code> otherwise.
     */
    public static boolean searchSubArray(long[] bigArray, long[] smallArray) {
        // initialize new array and preprocess the pattern
        int[] preProcessedArray = preProcessPattern(smallArray);
        return searchSubArray(bigArray, smallArray, preProcessedArray);
    }
}
