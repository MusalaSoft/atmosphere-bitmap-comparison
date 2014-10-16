package com.musala.atmosphere.bitmap.comparison.tests;

/**
 * Contains all the constants needed for the {@link bitMapComparisonPrototypeTest.FindMatrixAlgorithm} tests. Filenames
 * of the matrixes and some key indexes.
 * 
 * @author denis.bialev
 * 
 */
public final class MatrixAlgorithmConstants {
    public static final int BIG_MATRIX_DEFAULT_SIZE = 500;

    public static final String BIG_MATRIX = "bigMatrix";

    public static final String MATRIX_UPPER_LEFT_CORNER = "smallMatrixUpLeftCorner";

    public static final String MATRIX_LEFT_WALL = "smallMatrixLeftWall";

    public static final String MATRIX_LOWER_LEFT_CORNER = "smallMatrixDownLeftCorner";

    public static final String MATRIX_BOTTOM_WALL = "smallMatrixBottomWall";

    public static final String MATRIX_LOWER_RIGHT_CORNER = "smallMatrixDownRightCorner";

    public static final String MATRIX_RIGHT_WALL = "smallMatrixRightWall";

    public static final String MATRIX_UPPER_RIGHT_CORNER = "smallMatrixUpRightCorner";

    public static final String MATRIX_UPPER_WALL = "smallMatrixTopWall";

    public static final String MATRIX_TWO_PATTERNS_BOTH_RIGHT = "smallMatrixTwoPatternsBothRight";

    public static final String MATRIX_TWO_PATTERNS_ONE_WRONG = "smallMatrixTwoPatternsOneWrong";

    public static final String MATRIX_NO_PATTERN = "smallMatrixNoPattern";

    public static final String MATRIX_OUT_OF_BOUNDS_ROWS = "smallMatrixOutOfBoundsRows";

    public static final String MATRIX_OUT_OF_BOUNDS_COLUMNS = "smallMatrixOutOfBoundsColumns";

    public static final String MATRIX_OUT_OF_BOUNDS_ROWS_AND_COLUMNS = "smallMatrixOutOfBoundsRowsAndColumns";

    public static final String BIG_MATRIX_MANY_POSSIBLE_PATTERNS = "bigMatrixManyPossiblePatterns";

    public static final String MATRIX_MANY_POSSIBLE_PATTERNS = "smallMatrixManyPossiblePatterns";

    public static final String MATRIX_MATCH_PATTERN_WITHOUT_LAST_ROW = "smallMatrixMatchPatternWithoutLastRow";

    public static final String MATRIX_MATCH_PATTERN_WITHOUT_LAST_COLUMN = "smallMatrixMatchPatternWithoutLastColumn";

    public static final String MATRIX_MATCH_PATTERN_WITHOUT_LAST_COLUMN_AND_ROW = "smallMatrixMatchPatternWithoutLastColumnAndRow";

    public static final String EXISTING_CELL = "existingCell";

    public static final String NON_EXISTING_CELL = "nonExistingCell";

    public static final String EXISTING_ROW = "existingRow";

    public static final String NON_EXISTING_ROW = "nonExistingRow";

    public static final String EXISTING_COLUMN = "existingColumn";

    public static final String NON_EXISTING_COLUMN = "nonExistingColumn";

    public static final String MATRIX_SIZE_REGEX = "/";

    public static final String VALUES_REGEX = ", ";

    public static final String TEST_MATRIXES_PATH = "resources/Matrixes";

    public static final String TEST_ARRAYS_PATH = "resources/Arrays";

    public static final String PATH_FILE_FORMAT = TEST_MATRIXES_PATH + "/%s.txt";

    public static final String ARRAYS_PATH_FILE_FORMAT = TEST_ARRAYS_PATH + "/%s.txt";

    public static final String TEST_MATRIX_ENCODING = "UTF-8";

    public static final int ROWS_VALUE_IN_STRING_INDEX = 0;

    public static final int COLUMNS_VALUE_IN_STRING_INDEX = 1;

    public static final int MATRIX_VALUES_INDEX = 2;
}
