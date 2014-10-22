package com.musala.atmosphere.bitmap.comparison.tests.kmp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.BeforeClass;
import org.junit.Test;

import com.musala.atmosphere.bitmap.comparison.kmp.ArrayComparator;
import com.musala.atmosphere.bitmap.comparison.tests.MatrixAlgorithmConstants;

/**
 * 
 * @author denis.bialev
 * 
 */
public class ArrayComparatorTest {

    private long[] bigArray;

    @BeforeClass
    public void setUp() throws FileNotFoundException {
        bigArray = loadArray(MatrixAlgorithmConstants.BIG_ARRAY);
    }

    @Test
    public void testSearchSubArrayAtTheBeginning() throws FileNotFoundException {
        long[] arrayAtTheBeginning = loadArray(MatrixAlgorithmConstants.ARRAY_BEGINNING);
        assertTrue("Array not found when present.", ArrayComparator.searchSubArray(bigArray, arrayAtTheBeginning));
    }

    @Test
    public void testSearchSubArrayAtTheEnd() throws FileNotFoundException {
        long[] arrayAtTheEnd = loadArray(MatrixAlgorithmConstants.ARRAY_END);
        assertTrue("Array not found when present.", ArrayComparator.searchSubArray(bigArray, arrayAtTheEnd));
    }

    @Test
    public void testSearchSubArrayAtTheMiddle() throws FileNotFoundException {
        long[] arrayAtTheMiddle = loadArray(MatrixAlgorithmConstants.ARRAY_MIDDLE);
        assertTrue("Array not found when present.", ArrayComparator.searchSubArray(bigArray, arrayAtTheMiddle));
    }

    @Test
    public void testSearchSubArrayExistingCell() throws FileNotFoundException {
        long[] existingCell = loadArray(MatrixAlgorithmConstants.ARRAY_EXISTING_CELL);
        assertTrue("Array not found when present.", ArrayComparator.searchSubArray(bigArray, existingCell));
        long[] nonExistentCell = loadArray(MatrixAlgorithmConstants.ARRAY_NON_EXISTING_CELL);
        assertFalse("Array found when not present.", ArrayComparator.searchSubArray(bigArray, nonExistentCell));
    }

    @Test
    public void testSearchSubArraySameLenght() {
        assertTrue("Array not found when present.", ArrayComparator.searchSubArray(bigArray, bigArray));

    }

    @Test
    public void testSearchSubArrayNonExistentArray() throws FileNotFoundException {
        long[] nonExistentArray = loadArray(MatrixAlgorithmConstants.NON_EXISTING_ARRAY);
        assertFalse("Array found when not present.", ArrayComparator.searchSubArray(bigArray, nonExistentArray));
    }

    private long[] loadArray(String arrayName) throws FileNotFoundException {
        String pathFile = String.format(MatrixAlgorithmConstants.ARRAYS_PATH_FILE_FORMAT, arrayName);// "resources/Arrays/"
                                                                                                     // +
        File arrayFile = new File(pathFile);
        Scanner scannerNoDelimiter = new Scanner(arrayFile);
        Scanner scanner = scannerNoDelimiter.useDelimiter(", ");

        ArrayList<Long> arrayList = new ArrayList<Long>();
        while (scanner.hasNext()) {
            arrayList.add(scanner.nextLong());
        }

        scanner.close();
        int arraySize = arrayList.size();
        Long[] arrayLongValues = arrayList.toArray(new Long[arraySize]);
        long[] arrayImage = new long[arraySize];

        for (int i = 0; i < arraySize; i++) {
            arrayImage[i] = arrayLongValues[i];
        }

        return arrayImage;
    }

}
