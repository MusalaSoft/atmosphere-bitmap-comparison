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
     * @param matrix
     *        - matrix to search in
     * @param soughtForMatrix
     *        - matrix to look for
     * @return <code>true</code> if bigMatrix contains the smallMatrix in it and <code>false</code> otherwise.
     */
    public boolean containsMatrix(int[][] matrix, int[][] soughtForMatrix);
}
