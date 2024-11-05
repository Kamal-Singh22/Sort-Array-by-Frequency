import java.util.*;

public class SortByFrequency {

    public static List<Integer> sortByFrequency(int[] nums) {
        // Step 1: Count frequencies of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Sort elements by frequency and original order
        List<Integer> sortedList = new ArrayList<>();
        for (int num : nums) {
            sortedList.add(num);
        }
        
        sortedList.sort((a, b) -> {
            int freqCompare = frequencyMap.get(b).compareTo(frequencyMap.get(a));
            if (freqCompare == 0) {
                return Integer.compare(Arrays.asList(nums).indexOf(a), Arrays.asList(nums).indexOf(b));
            }
            return freqCompare;
        });

        return sortedList;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 2, 2, 4, 3, 5, 1};
        System.out.println("Sorted by Frequency: " + sortByFrequency(nums1)); // Example Output: [1, 3, 2, 2, 3, 1, 4, 5]

        int[] nums2 = {5, 5, 4, 6, 4, 6, 6};
        System.out.println("Sorted by Frequency: " + sortByFrequency(nums2)); // Example Output: [6, 6, 6, 5, 5, 4, 4]
    }
}
