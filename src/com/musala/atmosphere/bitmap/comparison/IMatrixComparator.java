package com.musala.atmosphere.bitmap.comparison;

/**
 * Containing a method that every Algorithm for finding a submatrix in matrix should implement.
 * 
 * @author denis.bialev
 * 
 */
public interface IMatrixComparator {
    /**
     * Method that checks if the big matrix contains the small matrix in it.
     * 
     * @param bigMatrix
     *        - matrix to search in.
     * @param smallMatrix
     *        - matrix to look for.
     * @return <code>true</code> if bigMatrix contains the smallMatrix in it and <code>false</code> otherwise.
     */
    public boolean containsMatrix(int[][] bigMatrix, int[][] smallMatrix);
}
