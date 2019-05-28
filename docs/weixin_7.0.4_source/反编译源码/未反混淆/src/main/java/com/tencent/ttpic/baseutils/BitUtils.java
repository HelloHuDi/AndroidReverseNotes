package com.tencent.ttpic.baseutils;

public class BitUtils {
    public static final int BIT_TURN_ZERO_1 = 65534;
    public static final int BIT_TURN_ZERO_2 = 65533;
    public static final int BIT_TURN_ZERO_3 = 65531;
    public static final int BIT_TURN_ZERO_4 = 65527;

    public static boolean checkBit(int i, int i2) {
        return (i & i2) == i2;
    }

    public static int turnBitTo0(int i, int i2) {
        return i & i2;
    }

    public static int turnBitTo1(int i, int i2) {
        return i | i2;
    }
}
