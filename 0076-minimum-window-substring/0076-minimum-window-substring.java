class Solution {
    public String minWindow(String s, String t) {

        int[] freq = new int[128];

        for (char c : t.toCharArray())
            freq[c]++;

        int left = 0;
        int count = 0;

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            if (freq[ch] > 0)
                count++;

            freq[ch]--;

            while (count == t.length()) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                freq[leftChar]++;

                if (freq[leftChar] > 0)
                    count--;

                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE)
            return "";

        return s.substring(start, start + minLen);
    }
}