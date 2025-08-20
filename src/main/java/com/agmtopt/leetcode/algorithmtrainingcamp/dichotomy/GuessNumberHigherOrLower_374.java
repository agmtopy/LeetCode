package com.agmtopt.leetcode.algorithmtrainingcamp.dichotomy;

public class GuessNumberHigherOrLower_374 {

  public static void main(String[] args) {
    GuessNumberHigherOrLower_374_Solution solution = new GuessNumberHigherOrLower_374_Solution();
    int result = solution.guessNumber(2126753390);
    System.out.println("result:" + result);
  }
}

class GuessNumberHigherOrLower_374_Solution extends GuessNumberHigherOrLower_374_GuessGame {

  public int guessNumber(int n) {

    if(guess(n) == 0) return n;

    int guess;
    long result = 0;

    long left = 0;
    long right = n;

    do {
      long x = (left + right) / 2;
      System.out.println("x:"+x);
      guess = guess(x);

      if (guess == 0) {
        result = x;
        break;
      }

      if (guess > 0) {
        left = x;
      }

      if (guess < 0) {
        right = x;
      }
    } while (guess != 0);

    return (int) result;
  }
}


class GuessNumberHigherOrLower_374_GuessGame {
  int pick = 1702766719;

  public int guess(long num) {
    if (num == pick) {
      return 0;
    }
    if (num > pick) {
      return -1;
    }
    return 1;
  }
}

