package com.mtcoding.codingTest;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] numbers = {1,2,3,4,5,6,7,8,9,10};
        s.solution(numbers);
    }

    public double solution(int[] numbers) {


        double sum = 0;

        sum = sum + numbers[0];
        sum = sum + numbers[1];
        sum = sum + numbers[2];
        sum = sum + numbers[3];
        sum = sum + numbers[4];
        sum = sum + numbers[5];
        sum = sum + numbers[6];
        sum = sum + numbers[7];
        sum = sum + numbers[8];
        sum = sum + numbers[9];

        System.out.println(sum);

        return sum;
    }

}

