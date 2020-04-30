package basePackage;

public class Matrix {

    public static double[][] multiply(double[][] firstMatrix, double[][] secondMatrix) throws WrongMatrixMultiplicationException {
        for (int i = 0; i < firstMatrix.length; i++) {
            if (firstMatrix[i].length != secondMatrix.length)
                throw new WrongMatrixMultiplicationException();
        }
        double[][] result = new double[firstMatrix.length][secondMatrix[0].length];

        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = multiplyMatricesCell(firstMatrix, secondMatrix, row, col);
            }
        }
        return result;
    }

    private static double multiplyMatricesCell(double[][] firstMatrix, double[][] secondMatrix, int row, int col) {
        double cell = 0;
        for (int i = 0; i < secondMatrix.length; i++) {
            cell += firstMatrix[row][i] * secondMatrix[i][col];
        }
        return cell;
    }

    public static double[][] add(double[][] firstMatrix, double[][] secondMatrix) throws WrongMatrixSizeException {
        if (firstMatrix.length != secondMatrix.length)
            throw new WrongMatrixSizeException();
        for (int i = 0; i < firstMatrix.length; i++)
            if (firstMatrix[i].length != secondMatrix[i].length)
                throw new WrongMatrixSizeException();

        double[][] result = new double[firstMatrix.length][firstMatrix[0].length];

        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = firstMatrix[row][col] + secondMatrix[row][col];
            }
        }
        return result;
    }

    public static double[][] subtract(double[][] firstMatrix, double[][] secondMatrix) throws WrongMatrixSizeException {
        if (firstMatrix.length != secondMatrix.length)
            throw new WrongMatrixSizeException();
        for (int i = 0; i < firstMatrix.length; i++)
            if (firstMatrix[i].length != secondMatrix[i].length)
                throw new WrongMatrixSizeException();

        double[][] result = new double[firstMatrix.length][firstMatrix[0].length];

        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = firstMatrix[row][col] - secondMatrix[row][col];
            }
        }
        return result;
    }

    public static double[][] multiplyByNumber(double[][] matrix, double number) {
        double[][] result = new double[matrix.length][matrix[0].length];

        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = matrix[row][col] * number;
            }
        }
        return result;
    }

    public static void print(double[][] matrix) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++)
                System.out.print(matrix[i][j]+" ");
            System.out.println();
        }
    }
}