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

package com.musala.atmosphere.bitmap.comparison.tests.bruteforce;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import com.musala.atmosphere.bitmap.comparison.bruteforce.BruteForceAlgorithmMatrix;
import com.musala.atmosphere.bitmap.comparison.tests.MatrixComparatorTestConstant;
import com.musala.atmosphere.bitmap.comparison.tests.MatrixComparatorTest;

/**
 * Extends {@link FindMatrixAlgorithmTest} that contains all test needed for the algorithm to work correctly. It test
 * BruteForce algorithm.
 * 
 * @author denis.bialev
 * 
 */
public class BruteForceAlgorithmTest extends MatrixComparatorTest {

    private static final int SMALL_MATRIX_ROWS = 50;

    private static final int SMALL_MATRIX_COLUMNS = 200;

    @Override
    protected void initializeComparator() {
        this.matrixComparator = new BruteForceAlgorithmMatrix();
    }

    @Test
    public void testContainsMatrixPerformanceTest() {
        int[][] smallMatrixPerformance = new int[SMALL_MATRIX_ROWS][SMALL_MATRIX_COLUMNS];
        int[][] bigMatrixPerformance = new int[MatrixComparatorTestConstant.BIG_MATRIX_DEFAULT_SIZE][MatrixComparatorTestConstant.BIG_MATRIX_DEFAULT_SIZE];

        for (int i = 0; i < SMALL_MATRIX_ROWS; i++) {
            for (int j = 0; j < SMALL_MATRIX_COLUMNS; j++) {
                smallMatrixPerformance[i][j] = 1;
            }
        }

        for (int i = 0; i < MatrixComparatorTestConstant.BIG_MATRIX_DEFAULT_SIZE; i++) {
            for (int j = 0; j < MatrixComparatorTestConstant.BIG_MATRIX_DEFAULT_SIZE; j++) {
                bigMatrixPerformance[i][j] = 1;
            }
        }

        smallMatrixPerformance[SMALL_MATRIX_ROWS - 1][SMALL_MATRIX_COLUMNS - 1] = 7;
        bigMatrixPerformance[MatrixComparatorTestConstant.BIG_MATRIX_DEFAULT_SIZE - 1][MatrixComparatorTestConstant.BIG_MATRIX_DEFAULT_SIZE - 1] = 7;

        assertTrue("Matrix not found, when it was contained. ",
                   matrixComparator.containsMatrix(bigMatrixPerformance, smallMatrixPerformance));

        smallMatrixPerformance[SMALL_MATRIX_ROWS - 1][SMALL_MATRIX_COLUMNS - 1] = smallMatrixPerformance[SMALL_MATRIX_ROWS - 1][SMALL_MATRIX_COLUMNS - 1] + 1;

        assertFalse("Matrix found, when it was not contained. ",
                    matrixComparator.containsMatrix(bigMatrixPerformance, smallMatrixPerformance));

    }

    @Test
    public void testContainsMatrixImagesPerformanceTest() throws IOException {
        int[][] smallPictureTabletImageMatrix = getImage(MatrixComparatorTestConstant.BRUTE_FORCE_CORNER_CASE_IMAGE);
        int[][] bigMatrixTablet = getImage(MatrixComparatorTestConstant.TABLET_SCREENSHOT_IMAGE);
        assertTrue("Can't find image when present",
                   matrixComparator.containsMatrix(bigMatrixTablet, smallPictureTabletImageMatrix));
    }

}
