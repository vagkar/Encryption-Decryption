import java.util.*;

class AsciiCharSequence implements CharSequence {

    byte[] matrix;

    AsciiCharSequence(byte[] matrix) {
        this.matrix = matrix.clone();
    }

    @Override
    public int length() {
        return matrix.length;
    }

    @Override
    public char charAt(int index) {
        return (char) matrix[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] b = Arrays.copyOfRange(matrix, start, end);
        return new AsciiCharSequence(b);
    }

    @Override
    public String toString() {
        return new String(matrix);
    }
}
