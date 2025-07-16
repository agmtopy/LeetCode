package com.agmtopt.leetcode.algorithmtrainingcamp.prefix;

import java.util.HashMap;
import java.util.Map;

public class CorporateFlightBookings_1109 {

    public static void main(String[] args) {
        CorporateFlightBookings_1109_Solution solution = new CorporateFlightBookings_1109_Solution();

        int[][] bookings = new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int[] result = solution.corpFlightBookings(bookings, 5);
        System.out.println(result);
    }

}

class CorporateFlightBookings_1109_Solution {


    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            result[bookings[i][0] - 1] += bookings[i][2];

            if (bookings[i][1] < n) {
                result[bookings[i][1]] -= bookings[i][2];
            }
        }


        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] + result[i];
        }

        return result;

    }


    public int[] corpFlightBookings1(int[][] bookings, int n) {
        Map<Integer, Integer> temp = new HashMap<>();

        for (int k = 0; k < bookings.length; k++) {
            int[] item = bookings[k];

            int first = item[0];
            int end = item[1];
            int rs = item[2];

            for (int i = first - 1; i < end; i++) {
                temp.put(i, temp.getOrDefault(i, 0) + rs);
            }
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = temp.getOrDefault(i, 0);
        }

        return result;
    }
}
