package com.aziflaj.balut.utils;

import com.aziflaj.balut.model.Dice;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ScoreHelper {

    public static int calculatePoints(List<Dice> dice) {
        int[] points = getPointArray(dice);
        Arrays.sort(points);

        if (isFullHouse(points)) {
            return 25;
        } else if (isThreeOfAKind(points) || isFourOfAKind(points)) {
            return sumOfPoints(points);
        } else if (isFiveOfAKind(points)) {
            return 50;
        } else if (isFourStair(points)) {
            return 30;
        } else if (isFiveStair(points)) {
            return 40;
        }

        return 0;
    }

    private static boolean isFullHouse(int[] points) {

        return points[0] == points[1] && points[1] == points[2]
                && points[3] == points[4] && points[0] != points[4]
                || points[0] == points[1] && points[2] == points[3]
                && points[3] == points[4] && points[0] != points[4];
    }

    private static boolean isThreeOfAKind(int[] points) {
        return points[0] == points[1] && points[1] == points[2]
                || points[1] == points[2] && points[2] == points[3]
                || points[2] == points[3] && points[3] == points[4];

    }

    private static boolean isFourOfAKind(int[] points) {
        return points[0] == points[1] && points[1] == points[2] && points[2] == points[3]
                || points[1] == points[2] && points[2] == points[3] && points[3] == points[4];
    }

    private static boolean isFourStair(int[] points) {
        int[] normalized = removeDuplicates(points);

        int[][] winningPossibilities = {
                {1, 2, 3, 4},
                {2, 3, 4, 5},
                {3, 4, 5, 6}};

        for (int[] possibility : winningPossibilities) {
            if (Arrays.equals(Arrays.copyOf(normalized, 4), possibility)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isFiveStair(int[] points) {
        int[][] winningPossibilities = {
                {1, 2, 3, 4, 5},
                {2, 3, 4, 5, 6}};

        for (int[] possibility : winningPossibilities) {
            if (Arrays.equals(points, possibility)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isFiveOfAKind(int[] points) {
        return points[0] == points[1] && points[1] == points[2] && points[2] == points[3]
                && points[3] == points[4];
    }

    private static int[] getPointArray(List<Dice> dice) {
        int[] points = new int[dice.size()];
        for (int i = 0; i < dice.size(); i++) {
            points[i] = dice.get(i).getValue();
        }
        return points;
    }

    private static int sumOfPoints(int[] points) {
        int sum = 0;

        for (int i : points) {
            sum += i;
        }

        return sum;
    }

    private static int[] removeDuplicates(int[] points) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int p : points) {
            set.add(p);
        }

        int[] normalized = new int[set.size()];
        int index = 0;
        for (Integer point : set) {
            normalized[index] = point;
            index++;
        }

        return normalized;
    }
}
