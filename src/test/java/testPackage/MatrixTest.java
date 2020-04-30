package testPackage;

import basePackage.Matrix;
import basePackage.WrongMatrixMultiplicationException;
import basePackage.WrongMatrixSizeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.apache.commons.io.IOUtils;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;


public class MatrixTest {

    @Test
    public void additionOfTwoRightMatrixShouldReturnRightResult() throws WrongMatrixSizeException {
        double[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] expectedResult = {{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}};

        Assertions.assertArrayEquals(expectedResult, Matrix.add(matrix1, matrix2));
    }

    @Test
    public void additionOfTwoRightMatrixShouldReturnRightResult2() throws WrongMatrixSizeException {
        double[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] expectedResult = {{1.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}};

        Assertions.assertNotEquals(expectedResult, Matrix.add(matrix1, matrix2));
    }

    @Test
    public void additionOfTwoWrongMatrixShouldThrow() throws WrongMatrixSizeException {
        double[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        double[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        Assertions.assertThrows(WrongMatrixSizeException.class, () -> Matrix.add(matrix1, matrix2));
    }

    @Test
    public void additionOfTwoWrongMatrixShouldThrow2() throws WrongMatrixSizeException {
        double[][] matrix1 = {{1, 2, 3}, {4, 5, 6, 6, 6, 6}, {7, 8, 9}};
        double[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        Assertions.assertThrows(WrongMatrixSizeException.class, () -> Matrix.add(matrix1, matrix2));
    }

    @Test
    public void subtractionOfTwoRightMatrixShouldReturnRightResult() throws WrongMatrixSizeException {
        double[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] expectedResult = {{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}};

        Assertions.assertArrayEquals(expectedResult, Matrix.subtract(matrix1, matrix2));
    }

    @Test
    public void subtractionOfTwoRightMatrixShouldReturnRightResult2() throws WrongMatrixSizeException {
        double[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] expectedResult = {{1.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}};

        Assertions.assertNotEquals(expectedResult, Matrix.subtract(matrix1, matrix2));
    }

    @Test
    public void subtractionOfTwoWrongMatrixShouldThrow() throws WrongMatrixSizeException {
        double[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        double[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        Assertions.assertThrows(WrongMatrixSizeException.class, () -> Matrix.subtract(matrix1, matrix2));
    }

    @Test
    public void subtractionOfTwoWrongMatrixShouldThrow2() throws WrongMatrixSizeException {
        double[][] matrix1 = {{1, 2, 3}, {4, 5, 6, 6, 6, 6}, {7, 8, 9}};
        double[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        Assertions.assertThrows(WrongMatrixSizeException.class, () -> Matrix.subtract(matrix1, matrix2));
    }

    @Test
    public void multiplicationByNumberShouldReturnRightResult() {
        double[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double number = 10.0;
        double[][] expectedResult = {{10.0, 20.0, 30.0}, {40.0, 50.0, 60.0}, {70.0, 80.0, 90.0}};

        Assertions.assertArrayEquals(expectedResult, Matrix.multiplyByNumber(matrix, number));
    }

    @Test
    public void multiplicationByNumberShouldReturnRightResult2()  {
        double[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double number = -10;
        double[][] expectedResult = {{-10.0, -20.0, -30.0}, {-40.0, -50.0, -60.0}, {-70.0, -80.0, -90.0}};

        Assertions.assertArrayEquals(expectedResult, Matrix.multiplyByNumber(matrix, number));
    }

    @Test
    public void multiplicationOfTwoRightMatrixShouldReturnRightResult() throws WrongMatrixMultiplicationException {
        double[][] matrix1 = {{1, 3}, {1, 2}};
        double[][] matrix2 = {{1, 2, 1}, {3, 1, 0}};
        double[][] expectedResult = {{10.0, 5.0, 1.0}, {7.0, 4.0, 1.0}};

        Assertions.assertArrayEquals(expectedResult, Matrix.multiply(matrix1, matrix2));
    }

    @Test
    public void miltiplicationOfTwoRightMatrixShouldReturnRightResult2() throws WrongMatrixMultiplicationException {
        double[][] matrix1 = {{1, 2, 3}, {4, 5, 6}};
        double[][] matrix2 = {{7, 8}, {9, 1}, {2, 3}};
        double[][] expectedResult = {{31.0, 19.0}, {85.0, 55.0}};

        Assertions.assertArrayEquals(expectedResult, Matrix.multiply(matrix1, matrix2));
    }

    @Test
    public void miltiplicationOfTwoWrongMatrixShouldThrow() throws WrongMatrixSizeException {
        double[][] matrix1 = {{1, 2, 1}, {3, 1, 0}};
        double[][] matrix2 = {{1, 3}, {1, 2}};

        Assertions.assertThrows(WrongMatrixMultiplicationException.class, () -> Matrix.multiply(matrix1, matrix2));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15})
    public void multiplicationByNumberShouldReturnRightResultParameterized(int number)  {
        double[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        double[][] expectedResult = {{1 * number, 2 * number, 3 * number}, {4 * number, 5 * number, 6 * number}, {7 * number, 8 * number, 9 * number}};

        Assertions.assertArrayEquals(expectedResult, Matrix.multiplyByNumber(matrix, number));
    }

    @Test
    void additionMatrixFromFileShouldBeCorrect() throws FileNotFoundException, WrongMatrixSizeException {
        double[][] matrixA = readFile("matrixA.txt");
        double[][] matrixB = readFile("matrixB.txt");
        double[][] matrixC = readFile("matrixC.txt");

        Assertions.assertArrayEquals(matrixC, Matrix.add(matrixA, matrixB));
    }

    private double[][] readFile(String fileName) {
        try {
            List<String> fileLines = Files.readAllLines(Paths.get(fileName), Charset.defaultCharset());

            int row = Integer.parseInt(fileLines.get(0));
            int col = Integer.parseInt(fileLines.get(1));

            double[][] result = new double[row][col];

            for (int i = 0; i < row; i ++) {
                for (int j = 0; j < col; j++) {
                    String[] line = fileLines.get(i + 2).split(" ");
                    result[i][j] = Double.parseDouble(line[j]);
                }
            }

            return result;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
