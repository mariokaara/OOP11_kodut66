

public class Võrdleja <T extends Comparable<T>>{

    private T x;


    public T leiaSuurem(T y) {
    T max = x;
    if (y.compareTo((max)) > 0) max = y;
    return max;
    }

    public T leiaSuurem(T x, T y) {
        T max = x;
        if (y.compareTo((max)) > 0) max = y;
        return max;
    }
}
