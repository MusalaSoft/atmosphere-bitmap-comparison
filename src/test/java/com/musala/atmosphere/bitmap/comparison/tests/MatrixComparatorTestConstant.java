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

package com.musala.atmosphere.bitmap.comparison.tests;

/**
 * Contains all the constants needed for the {@link bitMapComparisonPrototypeTest.FindMatrixAlgorithm} tests. Filenames
 * of the matrixes and some key indexes.
 *
 * @author denis.bialev
 *
 */
public final class MatrixComparatorTestConstant {
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

    public static final String TEST_MATRIXES_PATH = "src/test/resources/Matrixes";

    public static final String TEST_ARRAYS_PATH = "src/test/resources/Arrays";

    public static final String PATH_FILE_FORMAT = TEST_MATRIXES_PATH + "/%s.txt";

    public static final String ARRAYS_PATH_FILE_FORMAT = TEST_ARRAYS_PATH + "/%s.txt";

    public static final String TEST_MATRIX_ENCODING = "UTF-8";

    public static final int ROWS_VALUE_IN_STRING_INDEX = 0;

    public static final int COLUMNS_VALUE_IN_STRING_INDEX = 1;

    public static final int MATRIX_VALUES_INDEX = 2;

    public static int[][] bigMatrixTablet;

    public static final String CLOCK_IMAGE = "imageClockTablet";

    public static final String CLOCK_IMAGE_BRIGHTER = "imageClockTabletBrighter";

    public static final String CREATE_TASK_BUTTON_IMAGE_FROM_PHONE = "CreateTaskOtherDevice";

    public static final String PHONE_SCREENSHOT_IMAGE = "phoneScreenshot";

    public static final String HISTORY_BUTTON_IMAGE = "imageHistoryButton";

    public static final String TEXT_IMAGE = "imageTextTablet";

    public static final String WHITE_SPACE_IMAGE = "whitePixelsTablet";

    public static final String TABLET_SCREENSHOT_IMAGE = "tabletScreenshot";

    public static final String CREATE_TASK_BUTTON_TABLET = "CreateTaskButtonImageTablet";

    public static final String ANGLE_IMAGE = "angleTablet";

    public static final String IMAGE_PATH = "src/test/resources/Images/%s.bmp";

    public static final String BRUTE_FORCE_CORNER_CASE_IMAGE = "downCornerTablet";

    public static final String BIG_ARRAY = "bigArray";

    public static final String ARRAY_BEGINNING = "arrayAtTheBegining";

    public static final String ARRAY_END = "arrayAtTheEnd";

    public static final String ARRAY_MIDDLE = "arrayAtTheMiddle";

    public static final String ARRAY_EXISTING_CELL = "arrayExistingCell";

    public static final String ARRAY_NON_EXISTING_CELL = "arrayNonExistingCell";

    public static final String NON_EXISTING_ARRAY = "nonExistentArray";
}
