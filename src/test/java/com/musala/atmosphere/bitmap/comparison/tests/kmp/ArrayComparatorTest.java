package com.musala.atmosphere.bitmap.comparison.tests.kmp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.BeforeClass;
import org.junit.Test;

import com.musala.atmosphere.bitmap.comparison.kmp.ArrayFinder;
import com.musala.atmosphere.bitmap.comparison.tests.MatrixComparatorTestConstant;

/**
 * 
 * @author denis.bialev
 * 
 */
public class ArrayComparatorTest {

    private static long[] bigArray;

    private static ArrayFinder arrayFinder;

    @BeforeClass
    public static void setUp() throws FileNotFoundException {
        bigArray = loadArray(MatrixComparatorTestConstant.BIG_ARRAY);
        arrayFinder = new ArrayFinder();

    }

    @Test
    public void testSearchSubArrayAtTheBeginning() throws FileNotFoundException {
        long[] arrayAtTheBeginning = loadArray(MatrixComparatorTestConstant.ARRAY_BEGINNING);
        assertTrue("Array not found when present.", arrayFinder.findSubArray(bigArray, arrayAtTheBeginning));
    }

    @Test
    public void testSearchSubArrayAtTheEnd() throws FileNotFoundException {
        long[] arrayAtTheEnd = loadArray(MatrixComparatorTestConstant.ARRAY_END);
        assertTrue("Array not found when present.", arrayFinder.findSubArray(bigArray, arrayAtTheEnd));
    }

    @Test
    public void testSearchSubArrayAtTheMiddle() throws FileNotFoundException {
        long[] arrayAtTheMiddle = loadArray(MatrixComparatorTestConstant.ARRAY_MIDDLE);
        assertTrue("Array not found when present.", arrayFinder.findSubArray(bigArray, arrayAtTheMiddle));
    }

    @Test
    public void testSearchSubArrayExistingCell() throws FileNotFoundException {
        long[] existingCell = loadArray(MatrixComparatorTestConstant.ARRAY_EXISTING_CELL);
        assertTrue("Array not found when present.", arrayFinder.findSubArray(bigArray, existingCell));
        long[] nonExistentCell = loadArray(MatrixComparatorTestConstant.ARRAY_NON_EXISTING_CELL);
        assertFalse("Array found when not present.", arrayFinder.findSubArray(bigArray, nonExistentCell));
    }

    @Test
    public void testSearchSubArraySameLenght() {
        assertTrue("Array not found when present.", arrayFinder.findSubArray(bigArray, bigArray));

    }

    @Test
    public void testSearchSubArrayNonExistentArray() throws FileNotFoundException {
        long[] nonExistentArray = loadArray(MatrixComparatorTestConstant.NON_EXISTING_ARRAY);
        assertFalse("Array found when not present.", arrayFinder.findSubArray(bigArray, nonExistentArray));
    }

    private static long[] loadArray(String arrayName) throws FileNotFoundException {
        String pathFile = String.format(MatrixComparatorTestConstant.ARRAYS_PATH_FILE_FORMAT, arrayName);// "resources/Arrays/"
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
