package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum FaceItemCal {
    FACE_WIDTH(1.1f, 0.9f),
    EYE_DIST_X(0.9f, 1.1f),
    EYE_WIDTH(1.2f, 0.8f),
    EYE_HEIGHT(1.2f, 0.8f),
    EYE_ANGLE(0.2617994f, -0.2617994f),
    BROW_DIST_X(0.8f, 1.2f),
    BROW_DIST_Y(0.8f, 1.2f),
    BROW_DIST_Y2(8.0f, -8.0f),
    BROW_ANGLE(0.2617994f, -0.2617994f),
    NOSE_DIST_Y(1.2f, 0.8f),
    NOSE_DIST_Y2(8.0f, -8.0f),
    NOSE_WIDTH(0.88f, 1.12f),
    MOUTH_DIST_Y(0.8f, 1.2f),
    MOUTH_DIST_Y2(-8.0f, 8.0f),
    MOUTH_WIDTH(1.2f, 0.8f),
    MOUTH_HEIGHT(1.2f, 0.8f),
    FACE_V(1.2f, 0.8f),
    FACE_JAW(-8.0f, 8.0f);
    
    private final int easeCurve;
    private final float end;
    private final float endProgress;
    private final float start;
    private final float startProgress;

    static {
        AppMethodBeat.o(83879);
    }

    private FaceItemCal(float f, float f2) {
        this(r9, r10, 100.0f, f, -100.0f, f2, 0);
    }

    private FaceItemCal(float f, float f2, float f3, float f4, int i) {
        this.start = f;
        this.startProgress = f2;
        this.end = f3;
        this.endProgress = f4;
        this.easeCurve = i;
    }

    public final float getAdjustValue(float f) {
        AppMethodBeat.i(83877);
        float value = (float) getValue(this.easeCurve, (double) this.start, (double) this.startProgress, (double) this.end, (double) this.endProgress, (double) f);
        AppMethodBeat.o(83877);
        return value;
    }

    private static double getValue(int i, double d, double d2, double d3, double d4, double d5) {
        AppMethodBeat.i(83878);
        double d6 = (d5 - d2) / (d4 - d2);
        switch (i) {
            case 1:
                d6 = (Math.cos(d6 * 1.5707963267948966d) * (-(d3 - d))) + d3;
                break;
            case 2:
                d6 = (Math.sin(d6 * 1.5707963267948966d) * (d3 - d)) + d;
                break;
            case 3:
                d6 = ((Math.cos(d6 * 3.141592653589793d) - 1.0d) * ((-(d3 - d)) / 2.0d)) + d;
                break;
            default:
                d6 = (d6 * (d3 - d)) + d;
                break;
        }
        AppMethodBeat.o(83878);
        return d6;
    }
}
