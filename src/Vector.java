/*
 * класс, реализующий вектор
 */
public class Vector {

    private int[] vector;

    public Vector(int length) {
        vector = new int[length];
    }

    private boolean checkVector() {
        return this != null && vector != null;
    }

    public int getElement(int index) {
        if (!checkVector()) {
            throw new IllegalArgumentException();
        }
        return vector[index];
    }

    public void setElement(int index, int element) {
        if (!checkVector()) {
            throw new IllegalArgumentException();
        }
        vector[index] = element;
    }

    public int multiply(Vector another) {
        int ret = 0;
        for (int index = 0; index < getLength(); index++) {
            ret += getElement(index) * another.getElement(index);
        }
        return ret;
    }

    private int getLength() {
        return vector.length;
    }
}
