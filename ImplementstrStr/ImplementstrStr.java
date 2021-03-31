//https://leetcode-cn.com/problems/implement-strstr/
public class ImplementstrStr {
    private void buildMatch(String needle, int[] match) {
        int m = needle.length();
        int i;
        match[0] = -1;

        for (int j = 1; j < m; j++) {
            i = match[j - 1];

            while (i >= 0 && needle.charAt(i + 1) != needle.charAt(j))
                i = match[i];

            if (needle.charAt(i + 1) == needle.charAt(j))
                match[j] = i + 1;
            else
                match[j] = -1;
        }
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;

        if (needle.length() > haystack.length())
            return -1;

        int n = haystack.length();
        int m = needle.length();

        int[] match = new int[m];
        buildMatch(needle, match);

        int s = 0;
        int p = 0;

        while (s < n && p < m) {
            char c1 = haystack.charAt(s);
            char c2 = needle.charAt(p);

            if (c1 == c2) {
                s++;
                p++;
            } else if (p > 0)
                p = match[p - 1] + 1;
            else
                s++;
        }

        return p == m ? s - m : -1;
    }
}