package com.musala.atmosphere.bitmap.comparison.tests.kmp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import com.musala.atmosphere.bitmap.comparison.kmp.KMPMatrixComparator;
import com.musala.atmosphere.bitmap.comparison.tests.MatrixComparatorTestConstant;
import com.musala.atmosphere.bitmap.comparison.tests.MatrixComparatorTest;

/**
 * Unit test class for the comparator implemented using the KMP string matching algorithm and hashing.
 * 
 * @author denis.bialev
 * 
 */
public class KMPWithHashingMatrixComparatorTest extends MatrixComparatorTest {

    private static final int MATRIX_VALUE = 7;

    @Override
    protected void initializeComparator() {
        this.matrixComparator = new KMPMatrixComparator();
    }

    @Test
    public void testContainsMatrixPerformanceTest() {
        int[][] smallMatrixPerformance = new int[MatrixComparatorTestConstant.BIG_MATRIX_DEFAULT_SIZE][MatrixComparatorTestConstant.BIG_MATRIX_DEFAULT_SIZE];
        int[][] bigMatrixPerformance = new int[MatrixComparatorTestConstant.BIG_MATRIX_DEFAULT_SIZE][MatrixComparatorTestConstant.BIG_MATRIX_DEFAULT_SIZE];
        for (int i = 0; i < MatrixComparatorTestConstant.BIG_MATRIX_DEFAULT_SIZE; i++) {
            for (int j = 0; j < MatrixComparatorTestConstant.BIG_MATRIX_DEFAULT_SIZE; j++) {
                bigMatrixPerformance[i][j] = (i + j) * MATRIX_VALUE;
                smallMatrixPerformance[i][j] = bigMatrixPerformance[i][j];
            }
        }

        assertTrue("Matrix not found, when it was contained. ",
                   matrixComparator.containsMatrix(bigMatrixPerformance, smallMatrixPerformance));

        smallMatrixPerformance[MatrixComparatorTestConstant.BIG_MATRIX_DEFAULT_SIZE - 1][MatrixComparatorTestConstant.BIG_MATRIX_DEFAULT_SIZE - 1] = smallMatrixPerformance[MatrixComparatorTestConstant.BIG_MATRIX_DEFAULT_SIZE - 1][MatrixComparatorTestConstant.BIG_MATRIX_DEFAULT_SIZE - 1] + 1;

        assertFalse("Matrix found, when it was not contained. ",
                    matrixComparator.containsMatrix(bigMatrixPerformance, smallMatrixPerformance));

    }

    @Test
    public void testContainsMatrixImagesPerformanceTest() throws IOException {
        int[][] bigMatrixTablet = getImage(MatrixComparatorTestConstant.TABLET_SCREENSHOT_IMAGE);
        assertTrue("Can't find image when present", matrixComparator.containsMatrix(bigMatrixTablet, bigMatrixTablet));

    }
}
