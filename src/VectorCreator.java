public class VectorCreator {

    public static Vector createFromArray(int[] array) {
        if (!checkVector(array))
            return null;

        Vector ret = new Vector(getLength(array));
        for (int index = 0; index < getLength(array); index++) {
            ret.setElement(index, array[index]);
        }
        return ret;
    }

    private static boolean checkVector(int[] array) {
        return array != null;
    }

    private static int getLength(int[] array) {
        return array.length;
    }


}
