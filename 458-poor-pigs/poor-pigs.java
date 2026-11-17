class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int statesPerPig = minutesToTest / minutesToDie + 1;
        int pigs = 0;
        long distinguishableBuckets = 1;

        while (distinguishableBuckets < buckets) {
            distinguishableBuckets *= statesPerPig;
            pigs++;
        }

        return pigs;
    }
}