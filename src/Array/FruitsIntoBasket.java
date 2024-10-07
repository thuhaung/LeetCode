package Array;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {
    public static int getFruitToBeRemoved(int prevFruit, Map<Integer, Integer> map) {
        int fruit = 0;

        for (int i : map.keySet()) {
            if (i != prevFruit) {
                return i;
            }
        }

        return fruit;
    }

    public static int totalFruit(int[] fruits) {
        if (fruits.length < 3) return fruits.length;

        int max = 0;
        Map<Integer, Integer> fruitFrequency = new HashMap<>();

        int left = 0;
        int right = 0;

        while (right < fruits.length) {
            int currFruit = fruits[right];

            if (fruitFrequency.size() == 2) {
                if (!fruitFrequency.containsKey(currFruit)) {
                    int typeToRemove = getFruitToBeRemoved(fruits[right - 1], fruitFrequency);

                    while (fruitFrequency.containsKey(typeToRemove)) {
                        int fruit = fruits[left];
                        fruitFrequency.put(fruit, fruitFrequency.get(fruit) - 1);

                        if (fruitFrequency.get(fruit) == 0) fruitFrequency.remove(fruit);

                        left++;
                    }
                }
            }

            fruitFrequency.put(currFruit, fruitFrequency.getOrDefault(currFruit, 0) + 1);
            max = Math.max(max, right - left + 1);

            right++;
        }

        System.out.println("max = " + max);

        return max;
    }

    public static void main(String[] args) {
        totalFruit(new int[] {1,0,1,4,1,4,1,2,3});
    }
}
