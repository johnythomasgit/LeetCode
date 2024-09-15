public class TwoSumAlternative {
    public static void main(String[] args) {
        TwoSumAlternative twoSumAlternative = new TwoSumAlternative();
        int[] result = twoSumAlternative.twoSum(new int[]{-5, -3, 0, 2, 4, 6, 8}, 5);
        System.out.println(result);
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] resultArray = new int[2];
        for (int i = 0, j = 1; i < numbers.length; ) {
            if (numbers[i] + numbers[j] == target) {
                resultArray[0] = i + 1;
                resultArray[1] = j + 1;
                return resultArray;
            }
            if ((j<numbers.length-1)&&(target - numbers[i]) > numbers[j]) {
                j++;
            } else {
                i++;
                j = i + 1;
            }
        }
        return resultArray;
    }
}
