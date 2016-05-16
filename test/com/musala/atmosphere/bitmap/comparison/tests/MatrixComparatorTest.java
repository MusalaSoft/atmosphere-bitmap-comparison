package com.musala.atmosphere.bitmap.comparison.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.musala.atmosphere.bitmap.comparison.IMatrixComparator;

import com.musala.atmosphere.bitmap.comparison.tests.MatrixComparatorTestConstant;

/**
 * Class that contains all test cases that check if the algorithm for finding a submatrix in matrix works correctly.
 * 
 * @author denis.bialev
 * 
 */
public abstract class MatrixComparatorTest {

    protected IMatrixComparator matrixComparator;

    private static int[][] bigMatrix;

    private static int[][] bigMatrixTablet;

    @BeforeClass
    public static void setUp() throws IOException {
        bigMatrix = loadMatrix(MatrixComparatorTestConstant.BIG_MATRIX);
        bigMatrixTablet = getImage(MatrixComparatorTestConstant.TABLET_SCREENSHOT_IMAGE);
    }

    @Before
    public void initialization() {
        initializeComparator();
    }

    @Test
    public void testContainsMatrixCornerMatrixes() throws IOException {

        int[][] matrixUpLeftCorner = loadMatrix(MatrixComparatorTestConstant.MATRIX_UPPER_LEFT_CORNER);
        assertTrue("Matrix not found at the upper left corner when present.",
                   matrixComparator.containsMatrix(bigMatrix, matrixUpLeftCorner));

        int[][] matrixLeftWall = loadMatrix(MatrixComparatorTestConstant.MATRIX_LEFT_WALL);
        assertTrue("Matrix not found at the left wall when present.",
                   matrixComparator.containsMatrix(bigMatrix, matrixLeftWall));

        int[][] matrixLowerLeftCorner = loadMatrix(MatrixComparatorTestConstant.MATRIX_LOWER_LEFT_CORNER);
        assertTrue("Matrix not found at the lower left corner when present.",
                   matrixComparator.containsMatrix(bigMatrix, matrixLowerLeftCorner));

        int[][] matrixBottomWall = loadMatrix(MatrixComparatorTestConstant.MATRIX_BOTTOM_WALL);
        assertTrue("Matrix not found at the bottom wall when present.",
                   matrixComparator.containsMatrix(bigMatrix, matrixBottomWall));

        int[][] matrixLowerRightCorner = loadMatrix(MatrixComparatorTestConstant.MATRIX_LOWER_RIGHT_CORNER);
        assertTrue("Matrix not found at the lower right corner when present.",
                   matrixComparator.containsMatrix(bigMatrix, matrixLowerRightCorner));

        int[][] matrixRightWall = loadMatrix(MatrixComparatorTestConstant.MATRIX_RIGHT_WALL);
        assertTrue("Matrix not found at the right wall when present.",
                   matrixComparator.containsMatrix(bigMatrix, matrixRightWall));

        int[][] matrixUpperRightCorner = loadMatrix(MatrixComparatorTestConstant.MATRIX_UPPER_RIGHT_CORNER);
        assertTrue("Matrix not found at the upper right corner when present.",
                   matrixComparator.containsMatrix(bigMatrix, matrixUpperRightCorner));

        int[][] matrixUpperWall = loadMatrix(MatrixComparatorTestConstant.MATRIX_UPPER_WALL);
        assertTrue("Matrix not found at the upper wall when present.",
                   matrixComparator.containsMatrix(bigMatrix, matrixUpperWall));
    }

    @Test
    public void testContainsMatrixOutOfBoundsMatrixes() throws IOException {
        int[][] matrixOutOfBoundsRowsAndColumns = loadMatrix(MatrixComparatorTestConstant.MATRIX_OUT_OF_BOUNDS_ROWS_AND_COLUMNS);
        assertFalse("Found Matrix when searched in matrix with less rows and columns.",
                    matrixComparator.containsMatrix(bigMatrix, matrixOutOfBoundsRowsAndColumns));

        int[][] matrixOutOfBoundsRows = loadMatrix(MatrixComparatorTestConstant.MATRIX_OUT_OF_BOUNDS_ROWS);
        assertFalse("Found Matrix when searched in matrix with less rows.",
                    matrixComparator.containsMatrix(bigMatrix, matrixOutOfBoundsRows));

        int[][] matrixOutOfBoundsColumns = loadMatrix(MatrixComparatorTestConstant.MATRIX_OUT_OF_BOUNDS_COLUMNS);
        assertFalse("Found Matrix when searched in matrix with less columns.",
                    matrixComparator.containsMatrix(bigMatrix, matrixOutOfBoundsColumns));
    }

    @Test
    public void testContainsMatrixWithTwoPatterns() throws IOException {
        int[][] matrixTwoPatternsBothRight = loadMatrix(MatrixComparatorTestConstant.MATRIX_TWO_PATTERNS_BOTH_RIGHT);
        assertTrue("Matrix not found when present.",
                   matrixComparator.containsMatrix(bigMatrix, matrixTwoPatternsBothRight));
    }

    @Test
    public void testContainsMatrixWithNoPatterns() throws IOException {
        int[][] matrixNoPattern = loadMatrix(MatrixComparatorTestConstant.MATRIX_NO_PATTERN);
        assertFalse("Matrix was found when not present.", matrixComparator.containsMatrix(bigMatrix, matrixNoPattern));
    }

    @Test
    public void testContainsMatrixWithTwoPatternsOneWrong() throws IOException {
        int[][] matrixTwoPatternsOneWrong = loadMatrix(MatrixComparatorTestConstant.MATRIX_TWO_PATTERNS_ONE_WRONG);
        assertTrue("Matrix not found when present.",
                   matrixComparator.containsMatrix(bigMatrix, matrixTwoPatternsOneWrong));
    }

    @Test
    public void testContainsMatrixManyPossiblePatternsLastIsRight() throws IOException {
        int[][] bigMatrixManyPossiblePatterns = loadMatrix(MatrixComparatorTestConstant.BIG_MATRIX_MANY_POSSIBLE_PATTERNS);
        int[][] smallMatrixManyPossiblePatterns = loadMatrix(MatrixComparatorTestConstant.MATRIX_MANY_POSSIBLE_PATTERNS);
        assertTrue("Matrix not found when present.",
                   matrixComparator.containsMatrix(bigMatrixManyPossiblePatterns, smallMatrixManyPossiblePatterns));
    }

    @Test
    public void testContainsMatrixWhenLastCellsOutOfBounds() throws IOException {

        int[][] matrixMatchPatternWithoutLastRow = loadMatrix(MatrixComparatorTestConstant.MATRIX_MATCH_PATTERN_WITHOUT_LAST_ROW);
        assertFalse("Matrix was found when no existing pattern is present.",
                    matrixComparator.containsMatrix(bigMatrix, matrixMatchPatternWithoutLastRow));

        int[][] matrixMatchPatternWithoutLastColumn = loadMatrix(MatrixComparatorTestConstant.MATRIX_MATCH_PATTERN_WITHOUT_LAST_COLUMN);
        assertFalse("Matrix was found when no existing pattern is present.",
                    matrixComparator.containsMatrix(bigMatrix, matrixMatchPatternWithoutLastColumn));

        int[][] matrixMatchPatternWithoutLastColumnAndRow = loadMatrix(MatrixComparatorTestConstant.MATRIX_MATCH_PATTERN_WITHOUT_LAST_COLUMN_AND_ROW);
        assertFalse("Matrix was found when no existing pattern is present.",
                    matrixComparator.containsMatrix(bigMatrix, matrixMatchPatternWithoutLastColumnAndRow));
    }

    @Test
    public void testContainsMatrixFindCellInMatrix() throws IOException {

        int[][] existingCell = loadMatrix(MatrixComparatorTestConstant.EXISTING_CELL);
        assertTrue("Cell not found within the big matrix when present.",
                   matrixComparator.containsMatrix(bigMatrix, existingCell));

        int[][] nonExistingCell = loadMatrix(MatrixComparatorTestConstant.NON_EXISTING_CELL);
        assertFalse("Cell found within the big matrix when not present.",
                    matrixComparator.containsMatrix(bigMatrix, nonExistingCell));
    }

    @Test
    public void testContainsMatrixFindRowAndColumnInMatrix() throws IOException {

        int[][] existingRow = loadMatrix(MatrixComparatorTestConstant.EXISTING_ROW);
        assertTrue("Row not found within the big matrix when present.",
                   matrixComparator.containsMatrix(bigMatrix, existingRow));

        int[][] nonExistingRow = loadMatrix(MatrixComparatorTestConstant.NON_EXISTING_ROW);
        assertFalse("Row found within the big matrix when not present.",
                    matrixComparator.containsMatrix(bigMatrix, nonExistingRow));

        int[][] existingColumn = loadMatrix(MatrixComparatorTestConstant.EXISTING_COLUMN);
        assertTrue("Column not found within the big matrix when present.",
                   matrixComparator.containsMatrix(bigMatrix, existingColumn));

        int[][] nonExistingColumn = loadMatrix(MatrixComparatorTestConstant.NON_EXISTING_COLUMN);
        assertFalse("Column found within the big matrix when not present.",
                    matrixComparator.containsMatrix(bigMatrix, nonExistingColumn));
    }

    @Test
    public void testContainsMatrixWithImagesFromViews() throws IOException {

        int[][] clockImageMatrix = getImage(MatrixComparatorTestConstant.CLOCK_IMAGE);
        // bigMatrixTablet = getImage(MatrixAlgorithmConstants.TABLET_SCREENSHOT_IMAGE);
        assertTrue("Image not found when it was present.",
                   matrixComparator.containsMatrix(bigMatrixTablet, clockImageMatrix));

        int[][] historyButtonImageMatrix = getImage(MatrixComparatorTestConstant.HISTORY_BUTTON_IMAGE);
        // bigMatrixTablet = getImage(MatrixAlgorithmConstants.TABLET_SCREENSHOT_IMAGE);
        assertTrue("Image not found when it was present.",
                   matrixComparator.containsMatrix(bigMatrixTablet, historyButtonImageMatrix));

        int[][] createTaskButtonImageMatrix = getImage(MatrixComparatorTestConstant.CREATE_TASK_BUTTON_TABLET);
        // bigMatrixTablet = getImage(MatrixAlgorithmConstants.TABLET_SCREENSHOT_IMAGE);
        assertTrue("Image not found when it was present.",
                   matrixComparator.containsMatrix(bigMatrixTablet, createTaskButtonImageMatrix));
    }

    @Test
    public void testContainsMatrixWithImagesScreenObjects() throws IOException {

        int[][] textImageMatrix = getImage(MatrixComparatorTestConstant.TEXT_IMAGE);
        // bigMatrixTablet = getImage(MatrixAlgorithmConstants.TABLET_SCREENSHOT_IMAGE);
        assertTrue("Image not found when it was present.",
                   matrixComparator.containsMatrix(bigMatrixTablet, textImageMatrix));

        int[][] whiteSpaceImageMatrix = getImage(MatrixComparatorTestConstant.WHITE_SPACE_IMAGE);
        // bigMatrixTablet = getImage(MatrixAlgorithmConstants.TABLET_SCREENSHOT_IMAGE);
        assertTrue("Image not found when it was present.",
                   matrixComparator.containsMatrix(bigMatrixTablet, whiteSpaceImageMatrix));

        int[][] angleImageMatrix = getImage(MatrixComparatorTestConstant.ANGLE_IMAGE);
        // bigMatrixTablet = getImage(MatrixAlgorithmConstants.TABLET_SCREENSHOT_IMAGE);
        assertTrue("Image not found when it was present.",
                   matrixComparator.containsMatrix(bigMatrixTablet, angleImageMatrix));
    }

    @Test
    public void testContainsMatrixWithImagesFromDifferentDevices() throws IOException {

        int[][] clockImageBrighterMatrix = getImage(MatrixComparatorTestConstant.CLOCK_IMAGE_BRIGHTER);
        // bigMatrixTablet = getImage(MatrixAlgorithmConstants.TABLET_SCREENSHOT_IMAGE);
        assertFalse("Found image when not present.",
                    matrixComparator.containsMatrix(bigMatrixTablet, clockImageBrighterMatrix));

        int[][] createTaskButtonOtherDeviceImageMatrix = getImage(MatrixComparatorTestConstant.CREATE_TASK_BUTTON_IMAGE_FROM_PHONE);
        // bigMatrixTablet = getImage(MatrixAlgorithmConstants.TABLET_SCREENSHOT_IMAGE);
        assertFalse("Found image when not present",
                    matrixComparator.containsMatrix(bigMatrixTablet, createTaskButtonOtherDeviceImageMatrix));

        int[][] bigMatrixOtherDevice = getImage(MatrixComparatorTestConstant.PHONE_SCREENSHOT_IMAGE);
        // bigMatrixTablet = getImage(MatrixAlgorithmConstants.TABLET_SCREENSHOT_IMAGE);
        assertFalse("Found image when not present.",
                    matrixComparator.containsMatrix(bigMatrixTablet, bigMatrixOtherDevice));
    }

    protected static int[][] getImage(String imageName) throws IOException {
        String imagePath = String.format(MatrixComparatorTestConstant.IMAGE_PATH, imageName);
        File imageFile = new File(imagePath);
        BufferedImage bufferedImage = ImageIO.read(imageFile);
        int[][] imageMatrix = getImageMatrix(bufferedImage);
        bufferedImage.flush();
        return imageMatrix;
    }

    protected static int[][] getImageMatrix(BufferedImage image) {
        int rows = image.getHeight();
        int columns = image.getWidth();
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = Integer.MIN_VALUE + image.getRGB(j, i);
            }
        }

        return matrix;
    }

    private static String readFile(String path, String encoding) throws IOException {
        byte[] fileBytes = Files.readAllBytes(Paths.get(path));
        return new String(fileBytes, encoding);
    }

    private static int[][] loadMatrix(String matrixName) throws IOException {

        String pathFile = String.format(MatrixComparatorTestConstant.PATH_FILE_FORMAT, matrixName);

        String matrixFile = readFile(pathFile, MatrixComparatorTestConstant.TEST_MATRIX_ENCODING);

        String[] matrixSize = matrixFile.split(MatrixComparatorTestConstant.MATRIX_SIZE_REGEX);
        String[] matrixValues = matrixSize[MatrixComparatorTestConstant.MATRIX_VALUES_INDEX].split(MatrixComparatorTestConstant.VALUES_REGEX);

        int rows = Integer.parseInt(matrixSize[MatrixComparatorTestConstant.ROWS_VALUE_IN_STRING_INDEX]);
        int columns = Integer.parseInt(matrixSize[MatrixComparatorTestConstant.COLUMNS_VALUE_IN_STRING_INDEX]);
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
