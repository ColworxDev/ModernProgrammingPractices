import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Problem4 {

    public static void main(String[] args) {
        Matrix obj = new Matrix<>(3, 5, "aaa");
        obj.set(0,0, "dd");
        System.out.println(obj.get(0, 0));

    }

    public static class Matrix<T> {
        private T [][]values;
        private int rows;
        //private List[][]values; private int rows;
        private int cols;
        public Matrix(int r, int c, T t) {
            rows= r;
            cols= c;
            //values = new T[rows] [cols]; // * THIS WILL NOT COMLEIP

            values = (T[][]) Array.newInstance(t.getClass(), rows, cols);
        }
        public void set (int r, int c, T v) {
            values [r] [c] = v;
        }
        public T get (int r, int c)  {
            return values [r] [c];
        }
    }

}
