package com.tencent.ttpic.util;

public class Maths {
    public static final double NINETY_DEGREES = 1.5707963267948966d;
    public static final double ONE_EIGHTY_DEGREES = 3.141592653589793d;
    public static final double ONE_TWENTY_DEGREES = 2.0943951023931953d;
    private static final long POWER_CLAMP = 4294967295L;
    public static final double THREE_SIXTY_DEGREES = 6.283185307179586d;

    private Maths() {
    }

    public static int power(int i, int i2) {
        long j = POWER_CLAMP & ((long) i2);
        long j2 = (long) i;
        int i3 = 1;
        while (j != 0) {
            if ((1 & j) != 0) {
                i3 = (int) (((long) i3) * j2);
            }
            j >>>= 1;
            j2 *= j2;
        }
        return i3;
    }
}
