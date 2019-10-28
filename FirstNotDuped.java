import java.util.Arrays;

/**
 * Show first char at str, which has no duplicates
 * Oct 2019 EvgenyT
 */

public class FirstNotDuped {

    public static void main(String[] args) {
        String testString = "test string";
        // Char count array with first position storing
        int[][] charCounts = new int[256][2]; // [char][first position]
        // Fill char count array
        for (int idx = 0; idx < testString.length(); idx++) {
            char letter = testString.charAt(idx);
            charCounts[letter][0]++;
            // First-timer? remember position in string
            if (charCounts[letter][1] == 0)
                charCounts[letter][1] = idx;
        }
        // Find one-timer with lowest position
        int firstIdx = Integer.MAX_VALUE;
        for (int idx = 0; idx < charCounts.length; idx++) {
            if(charCounts[idx][0] == 1 && charCounts[idx][1] < firstIdx)
                firstIdx = charCounts[idx][1];
        }
        // Print results
        if (firstIdx < Integer.MAX_VALUE)
            System.out.println("First not dupped char: " +
                    testString.charAt(firstIdx)); // e
        else
            System.out.println("All dupes in str");
    }
}
