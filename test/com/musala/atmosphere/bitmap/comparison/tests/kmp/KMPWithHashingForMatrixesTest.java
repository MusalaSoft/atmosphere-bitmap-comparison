package com.musala.atmosphere.bitmap.comparison.tests.kmp;

import static com.musala.atmosphere.bitmap.comparison.tests.MatrixAlgorithmConstants.BIG_MATRIX_DEFAULT_SIZE;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.musala.atmosphere.bitmap.comparison.kmp.KMPWithHashingAlgorithmForMatrix;
import com.musala.atmosphere.bitmap.comparison.tests.FindMatrixAlgorithmTest;

/**
 * Unit test class for the comparator implemented using the KMP string matching algorithm and hashing.
 * 
 * @author denis.bialev
 * 
 */
public class KMPWithHashingForMatrixesTest extends FindMatrixAlgorithmTest {

    private static final int MATRIX_VALUE = 7;

    @Override
    protected void initializeComparator() {
        this.matrixComparator = new KMPWithHashingAlgorithmForMatrix();
    }

    @Test
    public void testContainsMatrixPerformanceTest() {
        int[][] smallMatrixPerformance = new int[BIG_MATRIX_DEFAULT_SIZE][BIG_MATRIX_DEFAULT_SIZE];
        int[][] bigMatrixPerformance = new int[BIG_MATRIX_DEFAULT_SIZE][BIG_MATRIX_DEFAULT_SIZE];
        for (int i = 0; i < BIG_MATRIX_DEFAULT_SIZE; i++) {
            for (int j = 0; j < BIG_MATRIX_DEFAULT_SIZE; j++) {
                bigMatrixPerformance[i][j] = (i + j) * MATRIX_VALUE;
                smallMatrixPerformance[i][j] = bigMatrixPerformance[i][j];
            }
        }

        assertTrue("Matrix not found, when it was contained. ",
                   matrixComparator.containsMatrix(bigMatrixPerformance, smallMatrixPerformance));

        smallMatrixPerformance[BIG_MATRIX_DEFAULT_SIZE - 1][BIG_MATRIX_DEFAULT_SIZE - 1] = smallMatrixPerformance[BIG_MATRIX_DEFAULT_SIZE - 1][BIG_MATRIX_DEFAULT_SIZE - 1] + 1;

        assertFalse("Matrix found, when it was not contained. ",
                    matrixComparator.containsMatrix(bigMatrixPerformance, smallMatrixPerformance));

    }
}
