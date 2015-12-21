package com.aziflaj.balut.utils;

import com.aziflaj.balut.model.Dice;

import java.util.Arrays;
import java.util.List;

public class ResultHelper {

    public static int calculatePoints(List<Dice> dices) {

        if (isFullHouse(dices)) {
            return 25;
        }

        return 0;
    }

    private static boolean isFullHouse(List<Dice> dices) {
        int[] points = getPointArray(dices);
        Arrays.sort(points);

        return points[0] == points[1] && points[1] == points[2]
                && points[3] == points[4] && points[0] != points[4];
    }

    private static int[] getPointArray(List<Dice> dices) {
        int[] points = new int[dices.size()];
        for (int i = 0; i < dices.size(); i++) {
            points[i] = dices.get(i).getValue();
        }
        return points;
    }
}
