package com.musala.atmosphere.bitmap.comparison.kmp;

import com.musala.atmosphere.bitmap.comparison.IMatrixComparator;
import com.musala.atmosphere.bitmap.comparison.utils.HashingUtils;

/**
 * Contains algorithm for finding a submatrix in matrix using {@link KMPAlgorithm} with hashed matrixes.
 * 
 * @author denis.bialev
 * 
 */
public class KMPWithHashingMatrixComparator implements IMatrixComparator {

    @Override
    public boolean containsMatrix(int[][] bigMatrix, int[][] smallMatrix) {
        // Check is the small matrix can fit in the BigMatrix
        if (!HashingUtils.checkBounds(bigMatrix, smallMatrix)) {
            return false;
        }

        int bigMatrixColumns = bigMatrix[0].length;
        int smallMatrixColumns = smallMatrix[0].length;

        // Hashing the matrixes and getting the needed value for the algorithm
        // The matrixes are hashed by rows because it's faster than by columns
        long[] smallHashedMatrixLastColumn = HashingUtils.getLastHashedColumnOfMatrix(smallMatrix);
        long[][] bigHashedMatrix = HashingUtils.hashMatrix(bigMatrix);

        // Precomputes smallMatrix Columns so it can be used for KMP algorithm
        int[] preprocessedLastColumn = ArrayComparator.preProcessPattern(smallHashedMatrixLastColumn);

        // Searching by Columns
        for (int j = smallMatrixColumns - 1; j < bigMatrixColumns; j++) {

            // PreHashing the current column of the bigMatrix
            long[] bigMatrixHashedColumn = HashingUtils.getRangeColumnHash(bigHashedMatrix, j, smallMatrixColumns);

            // Run the Original KMP Algorithm with smallMatrix Hashed Last Column and bigMatrix preHashed current Column
            boolean isFound = ArrayComparator.searchSubArray(bigMatrixHashedColumn,
                                                             smallHashedMatrixLastColumn,
                                                             preprocessedLastColumn);

            if (isFound) {
                return true;
            }
        }

        return false;
    }

}
