/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smalllab;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hoang
 */
public class SmallLab {

    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int[] factors(int n) {
        int[] result = new int[100];
        int number = n, i = 2, index = 0;
        while (number != 1) {
            if (isPrime(i)) {
                if (number % i == 0) {
                    result[index] = i;
                    number /= i;
                    index++;
                } else {
                    i++;
                }
            } else {
                i++;
            }
            if (number <= i) {
                result[index] = number;
                break;
            }
        }
        List<Integer> ls = new ArrayList<>();
        for (int j = 0; j < result.length; j++) {
            if (result[j] != 0) {
                ls.add(result[j]);
            }
        }
        result = new int[ls.size()];
        for (int j = 0; j < ls.size(); j++) {
            result[j] = ls.get(j);
        }
        return result;
    }

    public int getnumber(int n) {
        int result = 1;
        int[] factor = factors(n);
        for (int i = factor.length - 1; i >= 0; i--) {
            if (i == 0) {
                System.out.println(result + "  " + factor[0]);
                result *= factor[0];
                return result;
            }
            if (factor[i] != factor[i - 1]) {
                result *= factor[i];
            } else {
                i--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] n = new SmallLab().factors(5);
        for (int i = 0; i < n.length; i++) {
            System.out.println(n[i] + " ,");
        }
        System.out.println(new SmallLab().getnumber(124));
    }

}
