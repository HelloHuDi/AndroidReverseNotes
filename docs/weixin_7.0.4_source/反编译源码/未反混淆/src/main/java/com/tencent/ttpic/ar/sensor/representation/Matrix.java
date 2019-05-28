package com.tencent.ttpic.ar.sensor.representation;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Matrix {
    private static final float[] TEMP_MATRIX_ARRAY = new float[32];

    public static void multiplyMM(float[] fArr, int i, float[] fArr2, int i2, float[] fArr3, int i3) {
        fArr[i + 0] = (((fArr2[i2 + 0] * fArr3[i3 + 0]) + (fArr2[i2 + 4] * fArr3[i3 + 1])) + (fArr2[i2 + 8] * fArr3[i3 + 2])) + (fArr2[i2 + 12] * fArr3[i3 + 3]);
        fArr[i + 1] = (((fArr2[i2 + 1] * fArr3[i3 + 0]) + (fArr2[i2 + 5] * fArr3[i3 + 1])) + (fArr2[i2 + 9] * fArr3[i3 + 2])) + (fArr2[i2 + 13] * fArr3[i3 + 3]);
        fArr[i + 2] = (((fArr2[i2 + 2] * fArr3[i3 + 0]) + (fArr2[i2 + 6] * fArr3[i3 + 1])) + (fArr2[i2 + 10] * fArr3[i3 + 2])) + (fArr2[i2 + 14] * fArr3[i3 + 3]);
        fArr[i + 3] = (((fArr2[i2 + 3] * fArr3[i3 + 0]) + (fArr2[i2 + 7] * fArr3[i3 + 1])) + (fArr2[i2 + 11] * fArr3[i3 + 2])) + (fArr2[i2 + 15] * fArr3[i3 + 3]);
        fArr[i + 4] = (((fArr2[i2 + 0] * fArr3[i3 + 4]) + (fArr2[i2 + 4] * fArr3[i3 + 5])) + (fArr2[i2 + 8] * fArr3[i3 + 6])) + (fArr2[i2 + 12] * fArr3[i3 + 7]);
        fArr[i + 5] = (((fArr2[i2 + 1] * fArr3[i3 + 4]) + (fArr2[i2 + 5] * fArr3[i3 + 5])) + (fArr2[i2 + 9] * fArr3[i3 + 6])) + (fArr2[i2 + 13] * fArr3[i3 + 7]);
        fArr[i + 6] = (((fArr2[i2 + 2] * fArr3[i3 + 4]) + (fArr2[i2 + 6] * fArr3[i3 + 5])) + (fArr2[i2 + 10] * fArr3[i3 + 6])) + (fArr2[i2 + 14] * fArr3[i3 + 7]);
        fArr[i + 7] = (((fArr2[i2 + 3] * fArr3[i3 + 4]) + (fArr2[i2 + 7] * fArr3[i3 + 5])) + (fArr2[i2 + 11] * fArr3[i3 + 6])) + (fArr2[i2 + 15] * fArr3[i3 + 7]);
        fArr[i + 8] = (((fArr2[i2 + 0] * fArr3[i3 + 8]) + (fArr2[i2 + 4] * fArr3[i3 + 9])) + (fArr2[i2 + 8] * fArr3[i3 + 10])) + (fArr2[i2 + 12] * fArr3[i3 + 11]);
        fArr[i + 9] = (((fArr2[i2 + 1] * fArr3[i3 + 8]) + (fArr2[i2 + 5] * fArr3[i3 + 9])) + (fArr2[i2 + 9] * fArr3[i3 + 10])) + (fArr2[i2 + 13] * fArr3[i3 + 11]);
        fArr[i + 10] = (((fArr2[i2 + 2] * fArr3[i3 + 8]) + (fArr2[i2 + 6] * fArr3[i3 + 9])) + (fArr2[i2 + 10] * fArr3[i3 + 10])) + (fArr2[i2 + 14] * fArr3[i3 + 11]);
        fArr[i + 11] = (((fArr2[i2 + 3] * fArr3[i3 + 8]) + (fArr2[i2 + 7] * fArr3[i3 + 9])) + (fArr2[i2 + 11] * fArr3[i3 + 10])) + (fArr2[i2 + 15] * fArr3[i3 + 11]);
        fArr[i + 12] = (((fArr2[i2 + 0] * fArr3[i3 + 12]) + (fArr2[i2 + 4] * fArr3[i3 + 13])) + (fArr2[i2 + 8] * fArr3[i3 + 14])) + (fArr2[i2 + 12] * fArr3[i3 + 15]);
        fArr[i + 13] = (((fArr2[i2 + 1] * fArr3[i3 + 12]) + (fArr2[i2 + 5] * fArr3[i3 + 13])) + (fArr2[i2 + 9] * fArr3[i3 + 14])) + (fArr2[i2 + 13] * fArr3[i3 + 15]);
        fArr[i + 14] = (((fArr2[i2 + 2] * fArr3[i3 + 12]) + (fArr2[i2 + 6] * fArr3[i3 + 13])) + (fArr2[i2 + 10] * fArr3[i3 + 14])) + (fArr2[i2 + 14] * fArr3[i3 + 15]);
        fArr[i + 15] = (((fArr2[i2 + 3] * fArr3[i3 + 12]) + (fArr2[i2 + 7] * fArr3[i3 + 13])) + (fArr2[i2 + 11] * fArr3[i3 + 14])) + (fArr2[i2 + 15] * fArr3[i3 + 15]);
    }

    public static void multiplyMM(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = (((fArr2[0] * fArr3[0]) + (fArr2[4] * fArr3[1])) + (fArr2[8] * fArr3[2])) + (fArr2[12] * fArr3[3]);
        fArr[1] = (((fArr2[1] * fArr3[0]) + (fArr2[5] * fArr3[1])) + (fArr2[9] * fArr3[2])) + (fArr2[13] * fArr3[3]);
        fArr[2] = (((fArr2[2] * fArr3[0]) + (fArr2[6] * fArr3[1])) + (fArr2[10] * fArr3[2])) + (fArr2[14] * fArr3[3]);
        fArr[3] = (((fArr2[3] * fArr3[0]) + (fArr2[7] * fArr3[1])) + (fArr2[11] * fArr3[2])) + (fArr2[15] * fArr3[3]);
        fArr[4] = (((fArr2[0] * fArr3[4]) + (fArr2[4] * fArr3[5])) + (fArr2[8] * fArr3[6])) + (fArr2[12] * fArr3[7]);
        fArr[5] = (((fArr2[1] * fArr3[4]) + (fArr2[5] * fArr3[5])) + (fArr2[9] * fArr3[6])) + (fArr2[13] * fArr3[7]);
        fArr[6] = (((fArr2[2] * fArr3[4]) + (fArr2[6] * fArr3[5])) + (fArr2[10] * fArr3[6])) + (fArr2[14] * fArr3[7]);
        fArr[7] = (((fArr2[3] * fArr3[4]) + (fArr2[7] * fArr3[5])) + (fArr2[11] * fArr3[6])) + (fArr2[15] * fArr3[7]);
        fArr[8] = (((fArr2[0] * fArr3[8]) + (fArr2[4] * fArr3[9])) + (fArr2[8] * fArr3[10])) + (fArr2[12] * fArr3[11]);
        fArr[9] = (((fArr2[1] * fArr3[8]) + (fArr2[5] * fArr3[9])) + (fArr2[9] * fArr3[10])) + (fArr2[13] * fArr3[11]);
        fArr[10] = (((fArr2[2] * fArr3[8]) + (fArr2[6] * fArr3[9])) + (fArr2[10] * fArr3[10])) + (fArr2[14] * fArr3[11]);
        fArr[11] = (((fArr2[3] * fArr3[8]) + (fArr2[7] * fArr3[9])) + (fArr2[11] * fArr3[10])) + (fArr2[15] * fArr3[11]);
        fArr[12] = (((fArr2[0] * fArr3[12]) + (fArr2[4] * fArr3[13])) + (fArr2[8] * fArr3[14])) + (fArr2[12] * fArr3[15]);
        fArr[13] = (((fArr2[1] * fArr3[12]) + (fArr2[5] * fArr3[13])) + (fArr2[9] * fArr3[14])) + (fArr2[13] * fArr3[15]);
        fArr[14] = (((fArr2[2] * fArr3[12]) + (fArr2[6] * fArr3[13])) + (fArr2[10] * fArr3[14])) + (fArr2[14] * fArr3[15]);
        fArr[15] = (((fArr2[3] * fArr3[12]) + (fArr2[7] * fArr3[13])) + (fArr2[11] * fArr3[14])) + (fArr2[15] * fArr3[15]);
    }

    public static void multiplyMV(float[] fArr, int i, float[] fArr2, int i2, float[] fArr3, int i3) {
        fArr[i + 0] = (((fArr2[i2 + 0] * fArr3[i3 + 0]) + (fArr2[i2 + 4] * fArr3[i3 + 1])) + (fArr2[i2 + 8] * fArr3[i3 + 2])) + (fArr2[i2 + 12] * fArr3[i3 + 3]);
        fArr[i + 1] = (((fArr2[i2 + 1] * fArr3[i3 + 0]) + (fArr2[i2 + 5] * fArr3[i3 + 1])) + (fArr2[i2 + 9] * fArr3[i3 + 2])) + (fArr2[i2 + 13] * fArr3[i3 + 3]);
        fArr[i + 2] = (((fArr2[i2 + 2] * fArr3[i3 + 0]) + (fArr2[i2 + 6] * fArr3[i3 + 1])) + (fArr2[i2 + 10] * fArr3[i3 + 2])) + (fArr2[i2 + 14] * fArr3[i3 + 3]);
        fArr[i + 3] = (((fArr2[i2 + 3] * fArr3[i3 + 0]) + (fArr2[i2 + 7] * fArr3[i3 + 1])) + (fArr2[i2 + 11] * fArr3[i3 + 2])) + (fArr2[i2 + 15] * fArr3[i3 + 3]);
    }

    public static void multiplyMV(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = (((fArr2[0] * fArr3[0]) + (fArr2[4] * fArr3[1])) + (fArr2[8] * fArr3[2])) + (fArr2[12] * fArr3[3]);
        fArr[1] = (((fArr2[1] * fArr3[0]) + (fArr2[5] * fArr3[1])) + (fArr2[9] * fArr3[2])) + (fArr2[13] * fArr3[3]);
        fArr[2] = (((fArr2[2] * fArr3[0]) + (fArr2[6] * fArr3[1])) + (fArr2[10] * fArr3[2])) + (fArr2[14] * fArr3[3]);
        fArr[3] = (((fArr2[3] * fArr3[0]) + (fArr2[7] * fArr3[1])) + (fArr2[11] * fArr3[2])) + (fArr2[15] * fArr3[3]);
    }

    public static void multiplyMV3(float[] fArr, float[] fArr2, float[] fArr3, float f) {
        fArr[0] = (((fArr2[0] * fArr3[0]) + (fArr2[4] * fArr3[1])) + (fArr2[8] * fArr3[2])) + (fArr2[12] * f);
        fArr[1] = (((fArr2[1] * fArr3[0]) + (fArr2[5] * fArr3[1])) + (fArr2[9] * fArr3[2])) + (fArr2[13] * f);
        fArr[2] = (((fArr2[2] * fArr3[0]) + (fArr2[6] * fArr3[1])) + (fArr2[10] * fArr3[2])) + (fArr2[14] * f);
    }

    public static void transposeM(float[] fArr, int i, float[] fArr2, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            int i4 = (i3 * 4) + i2;
            fArr[i3 + i] = fArr2[i4];
            fArr[(i3 + 4) + i] = fArr2[i4 + 1];
            fArr[(i3 + 8) + i] = fArr2[i4 + 2];
            fArr[(i3 + 12) + i] = fArr2[i4 + 3];
        }
    }

    public static boolean invertM(float[] fArr, int i, float[] fArr2, int i2) {
        float f = fArr2[i2 + 0];
        float f2 = fArr2[i2 + 1];
        float f3 = fArr2[i2 + 2];
        float f4 = fArr2[i2 + 3];
        float f5 = fArr2[i2 + 4];
        float f6 = fArr2[i2 + 5];
        float f7 = fArr2[i2 + 6];
        float f8 = fArr2[i2 + 7];
        float f9 = fArr2[i2 + 8];
        float f10 = fArr2[i2 + 9];
        float f11 = fArr2[i2 + 10];
        float f12 = fArr2[i2 + 11];
        float f13 = fArr2[i2 + 12];
        float f14 = fArr2[i2 + 13];
        float f15 = fArr2[i2 + 14];
        float f16 = fArr2[i2 + 15];
        float f17 = f11 * f16;
        float f18 = f15 * f12;
        float f19 = f7 * f16;
        float f20 = f15 * f8;
        float f21 = f7 * f12;
        float f22 = f11 * f8;
        float f23 = f3 * f16;
        float f24 = f15 * f4;
        float f25 = f3 * f12;
        float f26 = f11 * f4;
        float f27 = f3 * f8;
        float f28 = f7 * f4;
        float f29 = (((f17 * f6) + (f20 * f10)) + (f21 * f14)) - (((f18 * f6) + (f19 * f10)) + (f22 * f14));
        float f30 = (((f18 * f2) + (f23 * f10)) + (f26 * f14)) - (((f17 * f2) + (f24 * f10)) + (f25 * f14));
        float f31 = (((f19 * f2) + (f24 * f6)) + (f27 * f14)) - (((f20 * f2) + (f23 * f6)) + (f28 * f14));
        float f32 = (((f22 * f2) + (f25 * f6)) + (f28 * f10)) - (((f21 * f2) + (f26 * f6)) + (f27 * f10));
        float f33 = (((f18 * f5) + (f19 * f9)) + (f22 * f13)) - (((f17 * f5) + (f20 * f9)) + (f21 * f13));
        f17 = (((f17 * f) + (f24 * f9)) + (f25 * f13)) - (((f18 * f) + (f23 * f9)) + (f26 * f13));
        f18 = (((f20 * f) + (f23 * f5)) + (f28 * f13)) - (((f19 * f) + (f24 * f5)) + (f27 * f13));
        f19 = (((f21 * f) + (f26 * f5)) + (f27 * f9)) - (((f22 * f) + (f25 * f5)) + (f28 * f9));
        f20 = f9 * f14;
        f21 = f13 * f10;
        f22 = f5 * f14;
        f23 = f13 * f6;
        f24 = f5 * f10;
        f25 = f9 * f6;
        f14 *= f;
        f26 = f13 * f2;
        f10 *= f;
        f27 = f9 * f2;
        f6 *= f;
        f2 *= f5;
        f28 = (((f20 * f8) + (f23 * f12)) + (f24 * f16)) - (((f21 * f8) + (f22 * f12)) + (f25 * f16));
        float f34 = (((f21 * f4) + (f14 * f12)) + (f27 * f16)) - (((f20 * f4) + (f26 * f12)) + (f10 * f16));
        f16 = (((f22 * f4) + (f26 * f8)) + (f6 * f16)) - ((f16 * f2) + ((f23 * f4) + (f14 * f8)));
        f4 = (((f25 * f4) + (f10 * f8)) + (f2 * f12)) - (((f4 * f24) + (f8 * f27)) + (f6 * f12));
        f8 = (((f22 * f11) + (f25 * f15)) + (f21 * f7)) - (((f24 * f15) + (f20 * f7)) + (f23 * f11));
        f12 = (((f10 * f15) + (f20 * f3)) + (f26 * f11)) - (((f14 * f11) + (f27 * f15)) + (f21 * f3));
        f14 = (((f14 * f7) + (f2 * f15)) + (f23 * f3)) - (((f15 * f6) + (f22 * f3)) + (f26 * f7));
        f2 = (((f6 * f11) + (f24 * f3)) + (f27 * f7)) - (((f2 * f11) + (f7 * f10)) + (f3 * f25));
        f = (((f * f29) + (f5 * f30)) + (f9 * f31)) + (f13 * f32);
        if (f == 0.0f) {
            return false;
        }
        f = 1.0f / f;
        fArr[i] = f29 * f;
        fArr[i + 1] = f30 * f;
        fArr[i + 2] = f31 * f;
        fArr[i + 3] = f32 * f;
        fArr[i + 4] = f33 * f;
        fArr[i + 5] = f17 * f;
        fArr[i + 6] = f18 * f;
        fArr[i + 7] = f19 * f;
        fArr[i + 8] = f28 * f;
        fArr[i + 9] = f34 * f;
        fArr[i + 10] = f16 * f;
        fArr[i + 11] = f4 * f;
        fArr[i + 12] = f8 * f;
        fArr[i + 13] = f12 * f;
        fArr[i + 14] = f14 * f;
        fArr[i + 15] = f * f2;
        return true;
    }

    public static void orthoM(float[] fArr, int i, float f, float f2, float f3, float f4, float f5, float f6) {
        AppMethodBeat.i(81683);
        IllegalArgumentException illegalArgumentException;
        if (f == f2) {
            illegalArgumentException = new IllegalArgumentException("left == right");
            AppMethodBeat.o(81683);
            throw illegalArgumentException;
        } else if (f3 == f4) {
            illegalArgumentException = new IllegalArgumentException("bottom == top");
            AppMethodBeat.o(81683);
            throw illegalArgumentException;
        } else if (f5 == f6) {
            illegalArgumentException = new IllegalArgumentException("near == far");
            AppMethodBeat.o(81683);
            throw illegalArgumentException;
        } else {
            float f7 = 1.0f / (f2 - f);
            float f8 = 1.0f / (f4 - f3);
            float f9 = 1.0f / (f6 - f5);
            float f10 = 2.0f * f7;
            float f11 = 2.0f * f8;
            float f12 = -2.0f * f9;
            f7 *= -(f2 + f);
            f8 *= -(f4 + f3);
            f9 *= -(f6 + f5);
            fArr[i + 0] = f10;
            fArr[i + 5] = f11;
            fArr[i + 10] = f12;
            fArr[i + 12] = f7;
            fArr[i + 13] = f8;
            fArr[i + 14] = f9;
            fArr[i + 15] = 1.0f;
            fArr[i + 1] = 0.0f;
            fArr[i + 2] = 0.0f;
            fArr[i + 3] = 0.0f;
            fArr[i + 4] = 0.0f;
            fArr[i + 6] = 0.0f;
            fArr[i + 7] = 0.0f;
            fArr[i + 8] = 0.0f;
            fArr[i + 9] = 0.0f;
            fArr[i + 11] = 0.0f;
            AppMethodBeat.o(81683);
        }
    }

    public static void frustumM(float[] fArr, int i, float f, float f2, float f3, float f4, float f5, float f6) {
        AppMethodBeat.i(81684);
        IllegalArgumentException illegalArgumentException;
        if (f == f2) {
            illegalArgumentException = new IllegalArgumentException("left == right");
            AppMethodBeat.o(81684);
            throw illegalArgumentException;
        } else if (f4 == f3) {
            illegalArgumentException = new IllegalArgumentException("top == bottom");
            AppMethodBeat.o(81684);
            throw illegalArgumentException;
        } else if (f5 == f6) {
            illegalArgumentException = new IllegalArgumentException("near == far");
            AppMethodBeat.o(81684);
            throw illegalArgumentException;
        } else if (f5 <= 0.0f) {
            illegalArgumentException = new IllegalArgumentException("near <= 0.0f");
            AppMethodBeat.o(81684);
            throw illegalArgumentException;
        } else if (f6 <= 0.0f) {
            illegalArgumentException = new IllegalArgumentException("far <= 0.0f");
            AppMethodBeat.o(81684);
            throw illegalArgumentException;
        } else {
            float f7 = 1.0f / (f2 - f);
            float f8 = 1.0f / (f4 - f3);
            float f9 = 1.0f / (f5 - f6);
            float f10 = 2.0f * (f5 * f7);
            float f11 = 2.0f * (f5 * f8);
            f7 = (f7 * (f2 + f)) * 2.0f;
            f8 *= f4 + f3;
            float f12 = (f6 + f5) * f9;
            f9 = (f9 * (f6 * f5)) * 2.0f;
            fArr[i + 0] = f10;
            fArr[i + 5] = f11;
            fArr[i + 8] = f7;
            fArr[i + 9] = f8;
            fArr[i + 10] = f12;
            fArr[i + 14] = f9;
            fArr[i + 11] = -1.0f;
            fArr[i + 1] = 0.0f;
            fArr[i + 2] = 0.0f;
            fArr[i + 3] = 0.0f;
            fArr[i + 4] = 0.0f;
            fArr[i + 6] = 0.0f;
            fArr[i + 7] = 0.0f;
            fArr[i + 12] = 0.0f;
            fArr[i + 13] = 0.0f;
            fArr[i + 15] = 0.0f;
            AppMethodBeat.o(81684);
        }
    }

    public static void perspectiveM(float[] fArr, int i, float f, float f2, float f3, float f4) {
        AppMethodBeat.i(81685);
        float tan = 1.0f / ((float) Math.tan(((double) f) * 0.008726646259971648d));
        float f5 = 1.0f / (f3 - f4);
        fArr[i + 0] = tan / f2;
        fArr[i + 1] = 0.0f;
        fArr[i + 2] = 0.0f;
        fArr[i + 3] = 0.0f;
        fArr[i + 4] = 0.0f;
        fArr[i + 5] = tan;
        fArr[i + 6] = 0.0f;
        fArr[i + 7] = 0.0f;
        fArr[i + 8] = 0.0f;
        fArr[i + 9] = 0.0f;
        fArr[i + 10] = (f4 + f3) * f5;
        fArr[i + 11] = -1.0f;
        fArr[i + 12] = 0.0f;
        fArr[i + 13] = 0.0f;
        fArr[i + 14] = f5 * ((2.0f * f4) * f3);
        fArr[i + 15] = 0.0f;
        AppMethodBeat.o(81685);
    }

    public static float length(float f, float f2, float f3) {
        AppMethodBeat.i(81686);
        float sqrt = (float) Math.sqrt((double) (((f * f) + (f2 * f2)) + (f3 * f3)));
        AppMethodBeat.o(81686);
        return sqrt;
    }

    public static void setIdentityM(float[] fArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < 16; i3++) {
            fArr[i + i3] = 0.0f;
        }
        while (i2 < 16) {
            fArr[i + i2] = 1.0f;
            i2 += 5;
        }
    }

    public static void scaleM(float[] fArr, int i, float[] fArr2, int i2, float f, float f2, float f3) {
        for (int i3 = 0; i3 < 4; i3++) {
            int i4 = i + i3;
            int i5 = i2 + i3;
            fArr[i4] = fArr2[i5] * f;
            fArr[i4 + 4] = fArr2[i5 + 4] * f2;
            fArr[i4 + 8] = fArr2[i5 + 8] * f3;
            fArr[i4 + 12] = fArr2[i5 + 12];
        }
    }

    public static void scaleM(float[] fArr, int i, float f, float f2, float f3) {
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = i + i2;
            fArr[i3] = fArr[i3] * f;
            int i4 = i3 + 4;
            fArr[i4] = fArr[i4] * f2;
            i3 += 8;
            fArr[i3] = fArr[i3] * f3;
        }
    }

    public static void translateM(float[] fArr, int i, float[] fArr2, int i2, float f, float f2, float f3) {
        int i3 = 0;
        for (int i4 = 0; i4 < 12; i4++) {
            fArr[i + i4] = fArr2[i2 + i4];
        }
        while (i3 < 4) {
            int i5 = i2 + i3;
            fArr[(i + i3) + 12] = fArr2[i5 + 12] + (((fArr2[i5] * f) + (fArr2[i5 + 4] * f2)) + (fArr2[i5 + 8] * f3));
            i3++;
        }
    }

    public static void translateM(float[] fArr, int i, float f, float f2, float f3) {
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = i + i2;
            int i4 = i3 + 12;
            fArr[i4] = ((fArr[i3 + 8] * f3) + ((fArr[i3] * f) + (fArr[i3 + 4] * f2))) + fArr[i4];
        }
    }

    public static void rotateM(float[] fArr, int i, float[] fArr2, int i2, float f, float f2, float f3, float f4) {
        AppMethodBeat.i(81687);
        synchronized (TEMP_MATRIX_ARRAY) {
            try {
                setRotateM(TEMP_MATRIX_ARRAY, 0, f, f2, f3, f4);
                multiplyMM(fArr, i, fArr2, i2, TEMP_MATRIX_ARRAY, 0);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(81687);
            }
        }
    }

    public static void rotateM(float[] fArr, int i, float f, float f2, float f3, float f4) {
        AppMethodBeat.i(81688);
        synchronized (TEMP_MATRIX_ARRAY) {
            try {
                setRotateM(TEMP_MATRIX_ARRAY, 0, f, f2, f3, f4);
                multiplyMM(TEMP_MATRIX_ARRAY, 16, fArr, i, TEMP_MATRIX_ARRAY, 0);
                System.arraycopy(TEMP_MATRIX_ARRAY, 16, fArr, i, 16);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(81688);
            }
        }
    }

    public static void setRotateM(float[] fArr, int i, float f, float f2, float f3, float f4) {
        AppMethodBeat.i(81689);
        fArr[i + 3] = 0.0f;
        fArr[i + 7] = 0.0f;
        fArr[i + 11] = 0.0f;
        fArr[i + 12] = 0.0f;
        fArr[i + 13] = 0.0f;
        fArr[i + 14] = 0.0f;
        fArr[i + 15] = 1.0f;
        float f5 = 0.017453292f * f;
        float sin = (float) Math.sin((double) f5);
        f5 = (float) Math.cos((double) f5);
        if (1.0f == f2 && 0.0f == f3 && 0.0f == f4) {
            fArr[i + 5] = f5;
            fArr[i + 10] = f5;
            fArr[i + 6] = sin;
            fArr[i + 9] = -sin;
            fArr[i + 1] = 0.0f;
            fArr[i + 2] = 0.0f;
            fArr[i + 4] = 0.0f;
            fArr[i + 8] = 0.0f;
            fArr[i + 0] = 1.0f;
            AppMethodBeat.o(81689);
        } else if (0.0f == f2 && 1.0f == f3 && 0.0f == f4) {
            fArr[i + 0] = f5;
            fArr[i + 10] = f5;
            fArr[i + 8] = sin;
            fArr[i + 2] = -sin;
            fArr[i + 1] = 0.0f;
            fArr[i + 4] = 0.0f;
            fArr[i + 6] = 0.0f;
            fArr[i + 9] = 0.0f;
            fArr[i + 5] = 1.0f;
            AppMethodBeat.o(81689);
        } else if (0.0f == f2 && 0.0f == f3 && 1.0f == f4) {
            fArr[i + 0] = f5;
            fArr[i + 5] = f5;
            fArr[i + 1] = sin;
            fArr[i + 4] = -sin;
            fArr[i + 2] = 0.0f;
            fArr[i + 6] = 0.0f;
            fArr[i + 8] = 0.0f;
            fArr[i + 9] = 0.0f;
            fArr[i + 10] = 1.0f;
            AppMethodBeat.o(81689);
        } else {
            float length = length(f2, f3, f4);
            if (1.0f != length) {
                length = 1.0f / length;
                f2 *= length;
                f3 *= length;
                f4 *= length;
            }
            length = 1.0f - f5;
            float f6 = f2 * f3;
            float f7 = f3 * f4;
            float f8 = f4 * f2;
            float f9 = f2 * sin;
            float f10 = f3 * sin;
            sin *= f4;
            fArr[i + 0] = ((f2 * f2) * length) + f5;
            fArr[i + 4] = (f6 * length) - sin;
            fArr[i + 8] = (f8 * length) + f10;
            fArr[i + 1] = sin + (f6 * length);
            fArr[i + 5] = ((f3 * f3) * length) + f5;
            fArr[i + 9] = (f7 * length) - f9;
            fArr[i + 2] = (f8 * length) - f10;
            fArr[i + 6] = (f7 * length) + f9;
            fArr[i + 10] = f5 + (length * (f4 * f4));
            AppMethodBeat.o(81689);
        }
    }

    public static void setRotateEulerM(float[] fArr, int i, float f, float f2, float f3) {
        AppMethodBeat.i(81690);
        float f4 = 0.017453292f * f;
        float f5 = 0.017453292f * f2;
        float f6 = 0.017453292f * f3;
        float cos = (float) Math.cos((double) f4);
        f4 = (float) Math.sin((double) f4);
        float cos2 = (float) Math.cos((double) f5);
        f5 = (float) Math.sin((double) f5);
        float cos3 = (float) Math.cos((double) f6);
        f6 = (float) Math.sin((double) f6);
        float f7 = cos * f5;
        float f8 = f4 * f5;
        fArr[i + 0] = cos2 * cos3;
        fArr[i + 1] = (-cos2) * f6;
        fArr[i + 2] = f5;
        fArr[i + 3] = 0.0f;
        fArr[i + 4] = (f7 * cos3) + (cos * f6);
        fArr[i + 5] = ((-f7) * f6) + (cos * cos3);
        fArr[i + 6] = (-f4) * cos2;
        fArr[i + 7] = 0.0f;
        fArr[i + 8] = ((-f8) * cos3) + (f4 * f6);
        fArr[i + 9] = (f4 * cos3) + (f6 * f8);
        fArr[i + 10] = cos * cos2;
        fArr[i + 11] = 0.0f;
        fArr[i + 12] = 0.0f;
        fArr[i + 13] = 0.0f;
        fArr[i + 14] = 0.0f;
        fArr[i + 15] = 1.0f;
        AppMethodBeat.o(81690);
    }

    public static void setLookAtM(float[] fArr, int i, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        AppMethodBeat.i(81691);
        float f10 = f4 - f;
        float f11 = f5 - f2;
        float f12 = f6 - f3;
        float length = 1.0f / length(f10, f11, f12);
        f10 *= length;
        f11 *= length;
        f12 *= length;
        length = (f11 * f9) - (f12 * f8);
        float f13 = (f12 * f7) - (f10 * f9);
        float f14 = (f10 * f8) - (f11 * f7);
        float length2 = 1.0f / length(length, f13, f14);
        length *= length2;
        f13 *= length2;
        f14 *= length2;
        length2 = (f13 * f12) - (f14 * f11);
        float f15 = (f14 * f10) - (length * f12);
        float f16 = (length * f11) - (f13 * f10);
        fArr[i + 0] = length;
        fArr[i + 1] = length2;
        fArr[i + 2] = -f10;
        fArr[i + 3] = 0.0f;
        fArr[i + 4] = f13;
        fArr[i + 5] = f15;
        fArr[i + 6] = -f11;
        fArr[i + 7] = 0.0f;
        fArr[i + 8] = f14;
        fArr[i + 9] = f16;
        fArr[i + 10] = -f12;
        fArr[i + 11] = 0.0f;
        fArr[i + 12] = 0.0f;
        fArr[i + 13] = 0.0f;
        fArr[i + 14] = 0.0f;
        fArr[i + 15] = 1.0f;
        translateM(fArr, i, -f, -f2, -f3);
        AppMethodBeat.o(81691);
    }
}
