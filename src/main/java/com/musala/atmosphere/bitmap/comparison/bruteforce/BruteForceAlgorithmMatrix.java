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
