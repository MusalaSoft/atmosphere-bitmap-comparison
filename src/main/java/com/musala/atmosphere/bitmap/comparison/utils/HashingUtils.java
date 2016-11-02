package com.musala.atmosphere.bitmap.comparison.utils;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Random;

/**
 * Class that contains hashing methods.
 * 
 * @author denis.bialev
 * 
 */
public class HashingUtils {

    private static final long LARGE_PRIME_NUMBER = 104729;

    private static final long MOD_NUMBER = longRandomPrime();

    private final static HashMap<Integer, Long> cachePow = new HashMap<Integer, Long>();

    /**
     * Used to precomputes the given column in the matrix by hashing a new with the given range.
     * 
     * @param hashedMatrix
     *        - hashed matrix that contains the column we want to precompute
     * @param columnNumber
     *        - position of the column
	 * @param rangeSize
	 *        - the range size			
     * @return column with precomputed hash values.
     */
    public static long[] getRangeColumnHash(long[][] hashedMatrix, int columnNumber, int rangeSize) {
        int matrixRows = hashedMatrix.length;
        long[] hashedColumn = new long[matrixRows];
        for (int i = 0; i < matrixRows; i++) {
            hashedColumn[i] = getHashValue(hashedMatrix, columnNumber - rangeSize, columnNumber, i);
        }

        return hashedColumn;
    }

    /**
     * Computes the hash value of the given range.
     * 
     * @param hashedMatrix
     *        - matrix with hashed values of the matrix we use
     * @param start
     *        - first cell of the wanted range
     * @param end
     *        - last cell of the wanted range
     * @param rowNumber
     *        - number from which we will get the hash value
     * @return number containing the value of the precomputed hash.
     */
    private static long getHashValue(long[][] hashedMatrix, int start, int end, int rowNumber) {
        if (start < 0) {
            return hashedMatrix[rowNumber][end];
        }

        long powNumberForHashing = getPowHashingNumber(end - start);
        long precomputedHashValue = (hashedMatrix[rowNumber][end] - (hashedMatrix[rowNumber][start] * powNumberForHashing)
                % MOD_NUMBER)
                % MOD_NUMBER;

        if (precomputedHashValue < 0) {
            return MOD_NUMBER + precomputedHashValue;
        } else {
            return precomputedHashValue;
        }
    }

    /**
     * Computes the power value of the hashing number so we can get a hash value of a given range.
     * 
     * @param exponent
     *        - the exponent
     * @return the value of the large prime number raised to the power of the exponent.
     */
    private static long getPowHashingNumber(int exponent) {
        if (cachePow.containsKey(exponent)) {
            return cachePow.get(exponent);
        }

        if (exponent < 0) {
            return 0;
        }

        long value;
        if (exponent == 0) {
            value = 1;
        } else if (exponent == 1) {
            value = LARGE_PRIME_NUMBER;
        } else {
            value = getPowHashingNumber(exponent / 2);
            value = (value * value) % MOD_NUMBER;
            if (exponent % 2 == 1) {
                value = (value * LARGE_PRIME_NUMBER) % MOD_NUMBER;
            }
        }

        cachePow.put(exponent, value);
        return value;

    }

    /**
     * Hashes the matrix.
     * 
     * @param matrix
     *        - for hashing
     * @return matrix with hashed values.
     */
    public static long[][] hashMatrix(int[][] matrix) {
        int matrixRows = matrix.length;
        int matrixColumns = matrix[0].length;
        long[][] hashedMatrix = new long[matrixRows][matrixColumns];
        for (int i = 0; i < matrixRows; i++) {
            for (int j = 0; j < matrixColumns; j++) {
                if (j == 0) {
                    hashedMatrix[i][j] = matrix[i][j] % MOD_NUMBER;
                } else {
                    hashedMatrix[i][j] = ((hashedMatrix[i][j - 1] * LARGE_PRIME_NUMBER) % MOD_NUMBER + matrix[i][j])
                            % MOD_NUMBER;
                }
            }
        }

        return hashedMatrix;
    }

    /**
     * Hashes the matrix and gives us the last column of the matrix.
     * 
     * @param matrix
     *        - matrix for hashing
     * @return last column of the hashed matrix.
     */
    public static long[] getLastHashedColumnOfMatrix(int[][] matrix) {
        int matrixRows = matrix.length;
        int matrixColumns = matrix[0].length;
        long[] matrixLastColumn = new long[matrixRows];
        long[][] hashedMatrix = hashMatrix(matrix);

        for (int i = 0; i < matrixRows; i++) {
            matrixLastColumn[i] = hashedMatrix[i][matrixColumns - 1];
        }

        return matrixLastColumn;
    }

    /** generate a random 31 bit prime **/
    private static long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }

    /**
     * Checks if the second matrix can be fit in the find matrix.
     * 
     * @param firstMatrix
     *        - matrix
     * @param secondMatrix
     *        - matrix
     * @return <code>true</code> if first matrix is bigger than second matrix and <code>false</code> otherwise.
     */
    public static boolean checkBounds(int[][] firstMatrix, int[][] secondMatrix) {
        int secondMatrixRows = secondMatrix.length;
        int secondMatrixColumns = secondMatrix[0].length;
        int firstMatrixRows = firstMatrix.length;
        int firstMatrixColumns = firstMatrix[0].length;
        return (firstMatrixRows >= secondMatrixRows) && (firstMatrixColumns >= secondMatrixColumns);
    }
}
