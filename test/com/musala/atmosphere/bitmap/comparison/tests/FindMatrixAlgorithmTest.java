package com.musala.atmosphere.bitmap.comparison.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.musala.atmosphere.bitmap.comparison.IMatrixComparator;

import static com.musala.atmosphere.bitmap.comparison.tests.MatrixAlgorithmConstants.*;

/**
 * Class that contains all test cases that check if the algorithm for finding a submatrix in matrix works correctly.
 * 
 * @author denis.bialev
 * 
 */
public abstract class FindMatrixAlgorithmTest {

    protected IMatrixComparator matrixComparator;

    private static int[][] bigMatrix;

    @Before
    public void setUp() throws IOException {
        bigMatrix = loadMatrix(BIG_MATRIX);
        initializeComparator();

    }

    @Test
    public void testContainsMatrixCornerMatrixes() {

        int[][] matrixUpLeftCorner = loadMatrix(MATRIX_UPPER_LEFT_CORNER);
        assertTrue("Matrix not found at the upper left corner when present.",
                   matrixComparator.containsMatrix(bigMatrix, matrixUpLeftCorner));

        int[][] matrixLeftWall = loadMatrix(MATRIX_LEFT_WALL);
        assertTrue("Matrix not found at the left wall when present.",
                   matrixComparator.containsMatrix(bigMatrix, matrixLeftWall));

        int[][] matrixLowerLeftCorner = loadMatrix(MATRIX_LOWER_LEFT_CORNER);
        assertTrue("Matrix not found at the lower left corner when present.",
                   matrixComparator.containsMatrix(bigMatrix, matrixLowerLeftCorner));

        int[][] matrixBottomWall = loadMatrix(MATRIX_BOTTOM_WALL);
        assertTrue("Matrix not found at the bottom wall when present.",
                   matrixComparator.containsMatrix(bigMatrix, matrixBottomWall));

        int[][] matrixLowerRightCorner = loadMatrix(MATRIX_LOWER_RIGHT_CORNER);
        assertTrue("Matrix not found at the lower right corner when present.",
                   matrixComparator.containsMatrix(bigMatrix, matrixLowerRightCorner));

        int[][] matrixRightWall = loadMatrix(MATRIX_RIGHT_WALL);
        assertTrue("Matrix not found at the right wall when present.",
                   matrixComparator.containsMatrix(bigMatrix, matrixRightWall));

        int[][] matrixUpperRightCorner = loadMatrix(MATRIX_UPPER_RIGHT_CORNER);
        assertTrue("Matrix not found at the upper right corner when present.",
                   matrixComparator.containsMatrix(bigMatrix, matrixUpperRightCorner));

        int[][] matrixUpperWall = loadMatrix(MATRIX_UPPER_WALL);
        assertTrue("Matrix not found at the upper wall when present.",
                   matrixComparator.containsMatrix(bigMatrix, matrixUpperWall));
    }

    @Test
    public void testContainsMatrixOutOfBoundsMatrixes() {
        int[][] matrixOutOfBoundsRowsAndColumns = loadMatrix(MATRIX_OUT_OF_BOUNDS_ROWS_AND_COLUMNS);
        assertFalse("Found Matrix when searched in matrix with less rows and columns.",
                    matrixComparator.containsMatrix(bigMatrix, matrixOutOfBoundsRowsAndColumns));

        int[][] matrixOutOfBoundsRows = loadMatrix(MATRIX_OUT_OF_BOUNDS_ROWS);
        assertFalse("Found Matrix when searched in matrix with less rows.",
                    matrixComparator.containsMatrix(bigMatrix, matrixOutOfBoundsRows));

        int[][] matrixOutOfBoundsColumns = loadMatrix(MATRIX_OUT_OF_BOUNDS_COLUMNS);
        assertFalse("Found Matrix when searched in matrix with less columns.",
                    matrixComparator.containsMatrix(bigMatrix, matrixOutOfBoundsColumns));
    }

    @Test
    public void testContainsMatrixWithTwoPatterns() {
        int[][] matrixTwoPatternsBothRight = loadMatrix(MATRIX_TWO_PATTERNS_BOTH_RIGHT);
        assertTrue("Matrix not found when present.",
                   matrixComparator.containsMatrix(bigMatrix, matrixTwoPatternsBothRight));
    }

    @Test
    public void testContainsMatrixWithNoPatterns() {
        int[][] matrixNoPattern = loadMatrix(MATRIX_NO_PATTERN);
        assertFalse("Matrix was found when not present.", matrixComparator.containsMatrix(bigMatrix, matrixNoPattern));
    }

    @Test
    public void testContainsMatrixWithTwoPatternsOneWrong() {
        int[][] matrixTwoPatternsOneWrong = loadMatrix(MATRIX_TWO_PATTERNS_ONE_WRONG);
        assertTrue("Matrix not found when present.",
                   matrixComparator.containsMatrix(bigMatrix, matrixTwoPatternsOneWrong));
    }

    @Test
    public void testContainsMatrixManyPossiblePatternsLastIsRight() {
        int[][] bigMatrixManyPossiblePatterns = loadMatrix(BIG_MATRIX_MANY_POSSIBLE_PATTERNS);
        int[][] smallMatrixManyPossiblePatterns = loadMatrix(MATRIX_MANY_POSSIBLE_PATTERNS);
        assertTrue("Matrix not found when present,",
                   matrixComparator.containsMatrix(bigMatrixManyPossiblePatterns, smallMatrixManyPossiblePatterns));
    }

    @Test
    public void testContainsMatrixWhenLastCellsOutOfBounds() {

        int[][] matrixMatchPatternWithoutLastRow = loadMatrix(MATRIX_MATCH_PATTERN_WITHOUT_LAST_ROW);
        assertFalse("Matrix was found when no existing pattern is present",
                    matrixComparator.containsMatrix(bigMatrix, matrixMatchPatternWithoutLastRow));

        int[][] matrixMatchPatternWithoutLastColumn = loadMatrix(MATRIX_MATCH_PATTERN_WITHOUT_LAST_COLUMN);
        assertFalse("Matrix was found when no existing pattern is present",
                    matrixComparator.containsMatrix(bigMatrix, matrixMatchPatternWithoutLastColumn));

        int[][] matrixMatchPatternWithoutLastColumnAndRow = loadMatrix(MATRIX_MATCH_PATTERN_WITHOUT_LAST_COLUMN_AND_ROW);
        assertFalse("Matrix was found when no existing pattern is present",
                    matrixComparator.containsMatrix(bigMatrix, matrixMatchPatternWithoutLastColumnAndRow));
    }

    @Test
    public void testContainsMatrixFindCellInMatrix() {

        int[][] existingCell = loadMatrix(EXISTING_CELL);
        assertTrue("Cell not found within the big matrix when present.",
                   matrixComparator.containsMatrix(bigMatrix, existingCell));

        int[][] nonExistingCell = loadMatrix(NON_EXISTING_CELL);
        assertFalse("Cell found within the big matrix when not present.",
                    matrixComparator.containsMatrix(bigMatrix, nonExistingCell));
    }

    @Test
    public void testContainsMatrixFindRowAndColumnInMatrix() {

        int[][] existingRow = loadMatrix(EXISTING_ROW);
        assertTrue("Row not found within the big matrix when present.",
                   matrixComparator.containsMatrix(bigMatrix, existingRow));

        int[][] nonExistingRow = loadMatrix(NON_EXISTING_ROW);
        assertFalse("Row found within the big matrix when not present.",
                    matrixComparator.containsMatrix(bigMatrix, nonExistingRow));

        int[][] existingColumn = loadMatrix(EXISTING_COLUMN);
        assertTrue("Column not found within the big matrix when present.",
                   matrixComparator.containsMatrix(bigMatrix, existingColumn));

        int[][] nonExistingColumn = loadMatrix(NON_EXISTING_COLUMN);
        assertFalse("Column found within the big matrix when not present.",
                    matrixComparator.containsMatrix(bigMatrix, nonExistingColumn));
    }

    //
    // protected static int[][] matrixGen(int rows, int columns) {
    // int[][] matrix = new int[rows][columns];
    // Random random = new Random();
    // for (int i = 0; i < matrix.length; i++) {
    // for (int j = 0; j < matrix[i].length; j++) {
    // matrix[i][j] = random.nextInt(255);
    // }
    // }
    // return matrix;
    // }

    private static String readFile(String path, String encoding) {
        byte[] fileBytes;
        try {
            fileBytes = Files.readAllBytes(Paths.get(path));

            return new String(fileBytes, encoding);
        } catch (IOException e) {
            // Nothing to do here
        }
        return null;
    }

    private int[][] loadMatrix(String matrixName) {

        String pathFile = String.format(PATH_FILE_FORMAT, matrixName);// "resources/" + matrixName +
                                                                      // ".txt";

        String matrixFile = readFile(pathFile, TEST_MATRIX_ENCODING);

        String[] matrixSize = matrixFile.split(MATRIX_SIZE_REGEX);
        String[] matrixValues = matrixSize[MATRIX_VALUES_INDEX].split(VALUES_REGEX);

        int rows = Integer.parseInt(matrixSize[ROWS_VALUE_IN_STRING_INDEX]);
        int columns = Integer.parseInt(matrixSize[COLUMNS_VALUE_IN_STRING_INDEX]);
        int[][] matrix = new int[rows][columns];

        int currentCell = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                matrix[i][j] = Integer.parseInt(matrixValues[currentCell]);
                currentCell++;
            }
        }
        return matrix;
    }

    protected abstract void initializeComparator();
}
