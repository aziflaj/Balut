package com.aziflaj.balut.utils;

import com.aziflaj.balut.model.Dice;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * A helper class for scoring points after each roll
 */
public class ScoreHelper {

    /**
     * This method calculates the points of the roll of 5 dices
     *
     * @param dice The List of rolled dice
     * @return The points of the roll
     */
    public static int calculatePoints(List<Dice> dice) {
        int[] points = getPointArray(dice);
        Arrays.sort(points);

        if (isFullHouse(points)) {
            return 25;
        } else if (isFiveOfAKind(points)) {
            return 50;
        } else if (isThreeOfAKind(points) || isFourOfAKind(points)) {
            return sumOfPoints(points);
        } else if (isFiveStair(points)) {
            return 40;
        } else if (isFourStair(points)) {
            return 30;
        }

        return 0;
    }

    /**
     * Checks if the roll is Full House (three similar + two similar)
     *
     * @param points The array of points
     * @return True if the roll is full house, otherwise false
     */
    private static boolean isFullHouse(int[] points) {

        return points[0] == points[1] && points[1] == points[2]
                && points[3] == points[4] && points[0] != points[4]
                || points[0] == points[1] && points[2] == points[3]
                && points[3] == points[4] && points[0] != points[4];
    }

    /**
     * Checks if the roll is Three of a Kind
     *
     * @param points The array of points
     * @return True if the roll is Three of a Kind, otherwise false
     */
    private static boolean isThreeOfAKind(int[] points) {
        return points[0] == points[1] && points[1] == points[2]
                || points[1] == points[2] && points[2] == points[3]
                || points[2] == points[3] && points[3] == points[4];

    }

    /**
     * Checks if the roll is Four of a Kind
     *
     * @param points The array of points
     * @return True if the roll is Four of a Kind, otherwise false
     */
    private static boolean isFourOfAKind(int[] points) {
        return points[0] == points[1] && points[1] == points[2] && points[2] == points[3]
                || points[1] == points[2] && points[2] == points[3] && points[3] == points[4];
    }

    /**
     * Checks if the roll is a Stair of four dice
     *
     * @param points The array of points
     * @return True if the roll is a Stair of four dice, otherwise false
     */
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

    /**
     * Checks if the roll is a Stair of five dice
     *
     * @param points The array of points
     * @return True if the roll is a Stair of five dice, otherwise false
     */
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

    /**
     * Checks if the roll is Five of a Kind
     *
     * @param points The array of points
     * @return True if the roll is Five of a Kind, otherwise false
     */
    private static boolean isFiveOfAKind(int[] points) {
        return points[0] == points[1] && points[1] == points[2] && points[2] == points[3]
                && points[3] == points[4];
    }

    /**
     * Converts the {@code List<Dice>} in an array of integer points
     *
     * @param dice The {@code List<Dice>} of the rolled dice
     * @return The int array equivalent of the {@code List<Dice>}
     */
    private static int[] getPointArray(List<Dice> dice) {
        int[] points = new int[dice.size()];
        for (int i = 0; i < dice.size(); i++) {
            points[i] = dice.get(i).getValue();
        }
        return points;
    }

    /**
     * Calculates the sum of all points in the dice
     *
     * @param points The array of points
     * @return The sum of points
     */
    private static int sumOfPoints(int[] points) {
        int sum = 0;

        for (int i : points) {
            sum += i;
        }

        return sum;
    }

    /**
     * Removes all duplicates from the points array, as required
     * from some score cases
     *
     * @param points The points array
     * @return A normalized points array without the duplicates
     */
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
