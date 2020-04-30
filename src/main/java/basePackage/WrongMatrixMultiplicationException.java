package basePackage;

public class WrongMatrixMultiplicationException extends Exception {
    @Override
    public String getMessage() {
        return "You can multiply two matrix only if number of cols of first matrix is equal to number of rows of second matrix";
    }
}
