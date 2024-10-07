package BinarySearch;

public class Test {
    public static void main(String[] args) {
        TimeMap map = new TimeMap();

        map.set("foo", "bar", 1);
        map.set("foo", "bar", 2);
        map.set("foo", "bar2", 4);

        map.get("foo", 3);
    }
}
