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

package com.musala.atmosphere.bitmap.comparison.bruteforce;

import com.musala.atmosphere.bitmap.comparison.IMatrixComparator;
import com.musala.atmosphere.bitmap.comparison.utils.HashingUtils;

/**
 * Class that uses brute force method for finding a submatrix in matrix. Mainly used to check if the test cases are
 * correct.
 * 
 * @author denis.bialev
 * 
 */
public class BruteForceAlgorithmMatrix implements IMatrixComparator {

    @Override
    public boolean containsMatrix(int[][] matrix, int[][] subMatrix) {

        if (!HashingUtils.checkBounds(matrix, subMatrix)) {
            return false;
        }
        int matrixRows = matrix.length;
        int matrixColumns = matrix[0].length;
        int subMatrixRows = subMatrix.length;
        int subMatrixColumns = subMatrix[0].length;

        boolean isContainingMatrix = false;

        for (int currentMatrixRow = 0; currentMatrixRow <= matrixRows - subMatrixRows; currentMatrixRow++) {
            for (int currentMatrixColumn = 0; currentMatrixColumn <= matrixColumns - subMatrixColumns; currentMatrixColumn++) {
                isContainingMatrix = true;
                matrixComparator: for (int currentSubmatrixRow = 0; currentSubmatrixRow < subMatrixRows; currentSubmatrixRow++) {
                    for (int currentSubmatrixColumn = 0; currentSubmatrixColumn < subMatrixColumns
                            && isContainingMatrix; currentSubmatrixColumn++) {
                        if (matrix[currentMatrixRow + currentSubmatrixRow][currentMatrixColumn + currentSubmatrixColumn] != subMatrix[currentSubmatrixRow][currentSubmatrixColumn]) {
                            isContainingMatrix = false;
                            break matrixComparator;
                        }
                    }
                }

                if (isContainingMatrix) {
                    return true;
                }

            }
        }

        return false;
    }
}
