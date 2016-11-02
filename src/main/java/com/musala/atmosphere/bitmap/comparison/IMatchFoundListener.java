package com.musala.atmosphere.bitmap.comparison;

/**
 * Contains a listener for found match in {@link com.musala.atmosphere.bitmap.comparison.kmp.ArrayFinder} search.
 * 
 * @author denis.bialev
 * 
 */
public interface IMatchFoundListener {
    /**
     * Method that listens for found match in the KMP search algorithm. After found match it checks cell by cell if the
     * found match is valid.
     * 
     * @param row
     *        - number of row where the match occurs
     * @return <code>true</code> if the found match is valid and <code>false</code> otherwise.
     */
    public boolean isMatchFound(int row);
}
