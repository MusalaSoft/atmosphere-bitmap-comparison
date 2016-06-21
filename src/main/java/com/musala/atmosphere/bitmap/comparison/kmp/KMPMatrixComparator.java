package com.musala.atmosphere.bitmap.comparison.kmp;

import com.musala.atmosphere.bitmap.comparison.IMatchFoundListener;
import com.musala.atmosphere.bitmap.comparison.IMatrixComparator;
import com.musala.atmosphere.bitmap.comparison.utils.HashingUtils;

/**
 * Contains algorithm for finding a submatrix in matrix using {@link ArrayFinder} with hashed matrixes.
 * 
 * @author denis.bialev
 * 
 */
public class KMPMatrixComparator implements IMatrixComparator, IMatchFoundListener {

    // private final ArrayFinder arrayComaparator;

    private int[][] matrix;

    private int[][] soughtForMatrix;

    private int currentSearchColumn;

    private final ArrayFinder arrayFinder = new ArrayFinder();

    @Override
    public boolean containsMatrix(int[][] matrix, int[][] soughtForMatrix) {
        // Check is the small matrix can fit in the BigMatrix
        if (!HashingUtils.checkBounds(matrix, soughtForMatrix)) {
            return false;
        }
        this.matrix = new int[matrix.length][matrix[0].length];
        this.soughtForMatrix = new int[soughtForMatrix.length][soughtForMatrix[0].length];
        this.matrix = matrix;
        this.soughtForMatrix = soughtForMatrix;
        int matrixColumns = matrix[0].length;
        int soughtForMatrixColumns = soughtForMatrix[0].length;

        // Hashing the matrixes and getting the needed value for the algorithm
        // The matrixes are hashed by rows because it's faster than by columns
        long[] subHashedMatrixLastColumn = HashingUtils.getLastHashedColumnOfMatrix(soughtForMatrix);
        long[][] hashedMatrix = HashingUtils.hashMatrix(matrix);

        // Searching by Columns
        for (int j = soughtForMatrixColumns - 1; j < matrixColumns; j++) {

            // PreHashing the current column of the bigMatrix
            long[] matrixHashedColumn = HashingUtils.getRangeColumnHash(hashedMatrix, j, soughtForMatrixColumns);

            // Run the Original KMP Algorithm with smallMatrix Hashed Last Column and bigMatrix preHashed current Column

            // int firstColumnOfSearch = j - subMatrixColumns + 1;
            currentSearchColumn = j - soughtForMatrixColumns + 1;
            boolean isFound = arrayFinder.findSubArray(matrixHashedColumn, subHashedMatrixLastColumn, this);

            if (isFound) {
                return true;
            }
        }

        return false;
    }

    /**
     * Performs cell by cell check to validate the found match.
     * 
     * @param row
     *        - number of row where the match occurs
     * @param column
     *        - number of column where the match occurs
     * @return <code>true</code> if the found match is valid and <code>false</code> otherwise.
     */
    private boolean isMatchValid(int row, int column) {
        int soughtForMatrixRows = soughtForMatrix.length;
        int soughtForMatrixColumns = soughtForMatrix[0].length;

        for (int i = 0; i < soughtForMatrixRows; i++) {
            for (int j = 0; j < soughtForMatrixColumns; j++) {
                if (matrix[row + i][currentSearchColumn + j] != soughtForMatrix[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public boolean isMatchFound(int row) {
        return isMatchValid(row + 1, currentSearchColumn);
    }

}
