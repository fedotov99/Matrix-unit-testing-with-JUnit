package basePackage;

public class WrongMatrixSizeException extends Exception {
    @Override
    public String getMessage() {
        return "You can add and subtract only matrix with equal size";
    }
}
