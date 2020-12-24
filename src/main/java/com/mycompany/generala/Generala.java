/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.generala;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 *
 * @author Marcelo
 */
public class Generala {

    protected int[] dice = new int[5];
    public Generala(int d1, int d2, int d3, int d4, int d5)
    {
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = d5;
    }

    public static int chance(int d1, int d2, int d3, int d4, int d5)
    {
        return d1 + d2 + d3 + d4 + d5;
    }

    public static int generala(int... dice)
    {
        int lastDie = dice.length-1;

        for (int i = 0; i < dice.length; i++) {
            if (i == lastDie) break;
            if (dice[i] != dice[i + 1]) {
                return 0;
            }
        }

        return 50;
    }

    public static int ones(int... dice) {
        int sum = IntStream.of(dice)
                .filter(n -> n == 1)
                .reduce(0, Integer::sum);

        return sum;
    }

    public static int twos(int... dice) {
        int sum = IntStream.of(dice)
                .filter(n -> n == 2)
                .reduce(0, Integer::sum);

        return sum;
    }

    public static int threes(int... dice) {
        int sum = IntStream.of(dice)
                .filter(n -> n == 3)
                .reduce(0, Integer::sum);

        return sum;
    }

    public int fours()
    {
        int sum = 0;

        for (int die : dice) {
            if (die == 4) sum += 4;
        }

        return sum;
    }

    public int fives()
    {
        int sum = 0;

        for (int die : dice) {
            if (die == 5) sum += 5;
        }

        return sum;
    }

    public int sixes()
    {
        int sum = 0;

        for (int die : dice) {
            if (die == 6) sum += 6;
        }

        return sum;
    }

    public static int score_pair(int... dice)
    {
        int[] counts = new int[6];

        for(int die : dice) {
            counts[die-1]++;
        }

        for (int i = 0; i < 6; i++)
            if (counts[6-i-1] >= 2)
                return (6-i)*2;
        return 0;
    }

    public static int two_pair(int... dice)
    {
        int[] counts = new int[6];

        for(int die : dice) {
            counts[die-1]++;
        }

        int pairs = 0, score = 0;

        for (int i = 0; i < 6; i += 1)
            if (counts[6-i-1] >= 2) {
                pairs++;
                score += (6-i);
            }

        return (pairs == 2) ? score * 2 : 0;
    }

    public static int three_of_a_kind(int... dice)
    {
        int[] counts = new int[6];

        for(int die : dice) {
            counts[die-1]++;
        }

        for (int i = 0; i < 6; i++)
            if (counts[i] >= 3)
                return (i+1) * 3;
        return 0;
    }

    public static int four_of_a_kind(int... dice)
    {
        int[] counts = new int[6];

        for(int die : dice) {
            counts[die-1]++;
        }

        for (int i = 0; i < 6; i++)
            if (counts[i] >= 4)
                return (i+1) * 4;
        return 0;
    }

    public static int smallStraight(int... dice)
    {
        int[] counts = new int[6];

        for(int die : dice) {
            counts[die-1]++;
        }

        if (counts[0] == 1 &&
            counts[1] == 1 &&
            counts[2] == 1 &&
            counts[3] == 1 &&
            counts[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int... dice)
    {
        int[] counts = new int[6];

        for(int die : dice) {
            counts[die-1]++;
        }

        if (counts[1] == 1 &&
                counts[2] == 1 &&
                counts[3] == 1 &&
                counts[4] == 1 &&
                counts[5] == 1)
            return 20;
        return 0;
    }

    public static int fullHouse(int... dice)
    {
        int[] counts = new int[6];

        boolean pairFounded = false;
        boolean trioFounded = false;
        int pairNumbers = 0;
        int trioNumbers = 0;

        for(int die : dice) {
            counts[die-1]++;
        }

        for (int i = 0; i < 6; i += 1)
            if (counts[i] == 2) {
                pairFounded = true;
                pairNumbers = i+1;
            }

        for (int i = 0; i < 6; i += 1)
            if (counts[i] == 3) {
                trioFounded = true;
                trioNumbers = i+1;
            }

        if (pairFounded && trioFounded)
            return pairNumbers * 2 + trioNumbers * 3;
        else
            return 0;
    }
}

