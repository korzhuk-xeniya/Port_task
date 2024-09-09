package korzhuk.xeny;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Port {
    private final String[] indexes;

    private final List<List<Integer>> arrayOfNumbers = new ArrayList<>();

    public Port(String[] indexes) {

        this.indexes = indexes;
    }

    public int[] getArrayOfNumbers() {
        for (String item : indexes) {
            arrayOfNumbers.add(getNumbers(item));
        }
        return arrayOfNumbers.stream().flatMapToInt(i -> i.stream().mapToInt(n -> n)).toArray();
    }

    public Set<List<Integer>> getUniqueGroupsElements() {
        if (arrayOfNumbers.isEmpty()) {
            getArrayOfNumbers();
        }
        int length = arrayOfNumbers.size();
        Set<List<Integer>> result = new HashSet<>();
        if (length == 0) {
            return result;
        }
        recursia(0, new ArrayList<>(), length, result);
        return result;
    }


    private void recursia(int position, List<Integer> constructor, int length, Set<List<Integer>> result) {
        if (position == length) {
            result.add(constructor);
        } else {
            List<Integer> array = arrayOfNumbers.get(position);
            for (Integer number : array) {
                List<Integer> list = new ArrayList<>(constructor);
                list.add(number);
                recursia(position + 1, list, length, result);
            }
        }
    }

    private List<Integer> getNumbers(String numbers) {
        ArrayList<Integer> result = new ArrayList<>();
        if (numbers.contains(",")) {
            String[] split = numbers.split(",");
            for (String s : split) {
                if (s.contains("-")) {
                    result.addAll(getSequence(s));
                } else {
                    result.add(Integer.parseInt(s));
                }
            }
        } else if (numbers.contains("-")) {
            result.addAll(getSequence(numbers));
        } else {
            result.add(Integer.parseInt(numbers));
        }
        return result;
    }

    private List<Integer> getSequence(String numbers) {
        ArrayList<Integer> result = new ArrayList<>();
        String[] splitArray = numbers.split("-");
        int firstNumber = Integer.parseInt(splitArray[0]);
        int lastNumber = Integer.parseInt(splitArray[1]);

        for (; firstNumber <= lastNumber; firstNumber++) {
            result.add(firstNumber);
        }
        return result;
    }
}
