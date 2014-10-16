package com.musala.atmosphere.bitmap.comparison.tests.bruteforce;

import static com.musala.atmosphere.bitmap.comparison.tests.MatrixAlgorithmConstants.BIG_MATRIX_DEFAULT_SIZE;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.musala.atmosphere.bitmap.comparison.bruteforce.BruteForceAlgorithmMatrix;
import com.musala.atmosphere.bitmap.comparison.tests.FindMatrixAlgorithmTest;

/**
 * Extends {@link FindMatrixAlgorithmTest} that contains all test needed for the algorithm to work correctly. It test
 * BruteForce algorithm.
 * 
 * @author denis.bialev
 * 
 */
public class BruteForceAlgorithmTest extends FindMatrixAlgorithmTest {

    private static final int SMALL_MATRIX_ROWS = 50;

    private static final int SMALL_MATRIX_COLUMNS = 200;

    @Override
    protected void initializeComparator() {
        this.matrixComparator = new BruteForceAlgorithmMatrix();
    }

    @Test
    public void testContainsMatrixPerformanceTest() {
        int[][] smallMatrixPerformance = new int[SMALL_MATRIX_ROWS][SMALL_MATRIX_COLUMNS];
        int[][] bigMatrixPerformance = new int[BIG_MATRIX_DEFAULT_SIZE][BIG_MATRIX_DEFAULT_SIZE];

        for (int i = 0; i < SMALL_MATRIX_ROWS; i++) {
            for (int j = 0; j < SMALL_MATRIX_COLUMNS; j++) {
                smallMatrixPerformance[i][j] = 1;
            }
        }

        for (int i = 0; i < BIG_MATRIX_DEFAULT_SIZE; i++) {
            for (int j = 0; j < BIG_MATRIX_DEFAULT_SIZE; j++) {
                bigMatrixPerformance[i][j] = 1;
            }
        }

        smallMatrixPerformance[SMALL_MATRIX_ROWS - 1][SMALL_MATRIX_COLUMNS - 1] = 7;
        bigMatrixPerformance[BIG_MATRIX_DEFAULT_SIZE - 1][BIG_MATRIX_DEFAULT_SIZE - 1] = 7;

        assertTrue("Matrix not found, when it was contained. ",
                   matrixComparator.containsMatrix(bigMatrixPerformance, smallMatrixPerformance));

        smallMatrixPerformance[SMALL_MATRIX_ROWS - 1][SMALL_MATRIX_COLUMNS - 1] = smallMatrixPerformance[SMALL_MATRIX_ROWS - 1][SMALL_MATRIX_COLUMNS - 1] + 1;

        assertFalse("Matrix found, when it was not contained. ",
                    matrixComparator.containsMatrix(bigMatrixPerformance, smallMatrixPerformance));

    }
}