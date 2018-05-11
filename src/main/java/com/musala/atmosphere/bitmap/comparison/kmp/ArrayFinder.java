// This file is part of the ATMOSPHERE mobile testing framework.
// Copyright (C) 2016 MusalaSoft
//
// ATMOSPHERE is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// ATMOSPHERE is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with ATMOSPHERE.  If not, see <http://www.gnu.org/licenses/>.

package com.musala.atmosphere.bitmap.comparison.kmp;

import java.util.HashMap;

import com.musala.atmosphere.bitmap.comparison.IMatchFoundListener;

/**
 * Implements an algorithm that determines whether an array is a subarray of another array.
 * 
 * @author denis.bialev
 * 
 */
public class ArrayFinder {

    private final static HashMap<long[], int[]> cachePreProcessedPatterns = new HashMap<long[], int[]>();

    /**
     * Pre processes the pattern array based on proper prefixes and proper suffixes at every position of the array.
     * 
     * @param pattern
     *        - array that will be pre-processed
     * @return partial match array which indicates the next possible position for the algorithm to start searching.
     */
    private static int[] preProcessPattern(long[] pattern) {
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
     * It determines whether the sought array is a subarray of the array.
     * 
     * @param array
     *        - array over which search happens
     * @param soughtArray
     *        - pattern that is to be searched
     * @param matchFoundListener
     *        - listens for found match and invokes a method that validates the found match
     * @return <code>true</code> if the sought array is found in the array and <code>false</code> otherwise.
     */
    public boolean findSubArray(long[] array, long[] soughtArray, IMatchFoundListener matchFoundListener) {
        // pattern and text lengths
        int[] preprocessedPattern;
        if (cachePreProcessedPatterns.containsKey(soughtArray)) {
            preprocessedPattern = cachePreProcessedPatterns.get(soughtArray);
        } else {
            preprocessedPattern = preProcessPattern(soughtArray);
            cachePreProcessedPatterns.put(soughtArray, preprocessedPattern);
        }
        int patternLength = soughtArray.length;
        int bigArrayLength = array.length;

        // initialize new array and preprocess the pattern

        int j = 0;
        for (int i = 0; i < bigArrayLength; i++) {
            while (j >= 0 && array[i] != soughtArray[j]) {
                j = preprocessedPattern[j];
            }

            j++;
            // a match is found

            if (j == patternLength && matchFoundListener.isMatchFound(i - patternLength)) {
                return true;
            }
        }

        return false;
    }

    /**
     * It determines whether the sought array is a subarray of the array.
     * 
     * @param array
     *        - array over which search happens
     * @param soughtArray
     *        - pattern that is to be searched
     * @return <code>true</code> if the sought array is found in the array and <code>false</code> otherwise.
     */
    public boolean findSubArray(long[] array, long[] soughtArray) {
        return findSubArray(array, soughtArray, new IMatchFoundListener() {
            @Override
            public boolean isMatchFound(int index) {
                return true;
            }
        });
    }
}
