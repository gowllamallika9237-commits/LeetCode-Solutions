class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder next = new StringBuilder();

            for (int start = 0; start < s.length(); start += k) {
                int sum = 0;
                int end = Math.min(start + k, s.length());

                for (int i = start; i < end; i++) {
                    sum += s.charAt(i) - '0';
                }

                next.append(sum);
            }

            s = next.toString();
        }

        return s;
    }
}