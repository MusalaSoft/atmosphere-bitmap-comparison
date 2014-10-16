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
    public boolean containsMatrix(int[][] bigMatrix, int[][] smallMatrix) {

        if (!HashingUtils.checkBounds(bigMatrix, smallMatrix)) {
            return false;
        }
        int bigMatrixRows = bigMatrix.length;
        int bigMatrixColumns = bigMatrix[0].length;
        int smallMatrixRows = smallMatrix.length;
        int smallMatrixColumns = smallMatrix[0].length;
        boolean isContainingMatrix = false;

        for (int bigI = 0; bigI <= bigMatrixRows - smallMatrixRows; bigI++) {
            for (int bigJ = 0; bigJ <= bigMatrixColumns - smallMatrixColumns; bigJ++) {
                isContainingMatrix = true;
                for (int smallI = 0; smallI < smallMatrixRows; smallI++) {
                    for (int smallJ = 0; smallJ < smallMatrixColumns && isContainingMatrix; smallJ++) {
                        if (bigMatrix[bigI + smallI][bigJ + smallJ] != smallMatrix[smallI][smallJ]) {
                            isContainingMatrix = false;
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
