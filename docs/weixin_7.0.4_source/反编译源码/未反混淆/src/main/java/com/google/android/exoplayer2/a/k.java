package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.i.a;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class k {
    private final int aRA;
    final int aRB = (this.aRA * 2);
    private final short[] aRC = new short[this.aRB];
    private int aRD = this.aRB;
    short[] aRE;
    private int aRF;
    short[] aRG;
    private int aRH;
    private short[] aRI;
    private int aRJ;
    private int aRK;
    int aRL;
    int aRM;
    int aRN;
    int aRO;
    private int aRP;
    private int aRQ;
    private int aRR;
    private int aRS;
    final int aRy;
    private final int aRz;
    float pitch;
    private final int sampleRate;
    float speed;

    public k(int i, int i2) {
        AppMethodBeat.i(94722);
        this.sampleRate = i;
        this.aRy = i2;
        this.aRz = i / 400;
        this.aRA = i / 65;
        this.aRE = new short[(this.aRB * i2)];
        this.aRF = this.aRB;
        this.aRG = new short[(this.aRB * i2)];
        this.aRH = this.aRB;
        this.aRI = new short[(this.aRB * i2)];
        this.aRJ = 0;
        this.aRK = 0;
        this.aRP = 0;
        this.speed = 1.0f;
        this.pitch = 1.0f;
        AppMethodBeat.o(94722);
    }

    private void dz(int i) {
        AppMethodBeat.i(94723);
        if (this.aRM + i > this.aRF) {
            this.aRF += (this.aRF / 2) + i;
            this.aRG = Arrays.copyOf(this.aRG, this.aRF * this.aRy);
        }
        AppMethodBeat.o(94723);
    }

    /* Access modifiers changed, original: final */
    public final void dA(int i) {
        AppMethodBeat.i(94724);
        if (this.aRL + i > this.aRD) {
            this.aRD += (this.aRD / 2) + i;
            this.aRE = Arrays.copyOf(this.aRE, this.aRD * this.aRy);
        }
        AppMethodBeat.o(94724);
    }

    private void a(short[] sArr, int i, int i2) {
        AppMethodBeat.i(94725);
        dz(i2);
        System.arraycopy(sArr, this.aRy * i, this.aRG, this.aRM * this.aRy, this.aRy * i2);
        this.aRM += i2;
        AppMethodBeat.o(94725);
    }

    private void b(short[] sArr, int i, int i2) {
        int i3 = this.aRB / i2;
        int i4 = this.aRy * i2;
        int i5 = i * this.aRy;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                i7 += sArr[((i6 * i4) + i5) + i8];
            }
            this.aRC[i6] = (short) (i7 / i4);
        }
    }

    private int a(short[] sArr, int i, int i2, int i3) {
        AppMethodBeat.i(94726);
        int i4 = 0;
        int i5 = 255;
        int i6 = 1;
        int i7 = 0;
        int i8 = i * this.aRy;
        int i9 = i2;
        while (i9 <= i3) {
            int i10 = 0;
            for (int i11 = 0; i11 < i9; i11++) {
                i10 += Math.abs(sArr[i8 + i11] - sArr[(i8 + i9) + i11]);
            }
            if (i10 * i4 < i6 * i9) {
                i6 = i10;
                i4 = i9;
            }
            if (i10 * i5 > i7 * i9) {
                i5 = i9;
            } else {
                i10 = i7;
            }
            i9++;
            i7 = i10;
        }
        this.aRR = i6 / i4;
        this.aRS = i7 / i5;
        AppMethodBeat.o(94726);
        return i4;
    }

    /* Access modifiers changed, original: final */
    public final void qE() {
        int i;
        int min;
        int a;
        int i2;
        short[] sArr;
        AppMethodBeat.i(94727);
        int i3 = this.aRM;
        float f = this.speed / this.pitch;
        if (((double) f) <= 1.00001d && ((double) f) >= 0.99999d) {
            a(this.aRE, 0, this.aRL);
            this.aRL = 0;
        } else if (this.aRL >= this.aRB) {
            int i4 = this.aRL;
            i = 0;
            do {
                if (this.aRO > 0) {
                    min = Math.min(this.aRB, this.aRO);
                    a(this.aRE, i, min);
                    this.aRO -= min;
                    i += min;
                } else {
                    Object obj;
                    int i5;
                    short[] sArr2 = this.aRE;
                    min = this.sampleRate > WearableStatusCodes.TARGET_NODE_NOT_CONNECTED ? this.sampleRate / WearableStatusCodes.TARGET_NODE_NOT_CONNECTED : 1;
                    if (this.aRy == 1 && min == 1) {
                        min = a(sArr2, i, this.aRz, this.aRA);
                    } else {
                        b(sArr2, i, min);
                        a = a(this.aRC, 0, this.aRz / min, this.aRA / min);
                        if (min != 1) {
                            i2 = a * min;
                            a = i2 - (min * 4);
                            i2 += min * 4;
                            if (a < this.aRz) {
                                min = this.aRz;
                            } else {
                                min = a;
                            }
                            if (i2 > this.aRA) {
                                a = this.aRA;
                            } else {
                                a = i2;
                            }
                            if (this.aRy == 1) {
                                min = a(sArr2, i, min, a);
                            } else {
                                b(sArr2, i, 1);
                                min = a(this.aRC, 0, min, a);
                            }
                        } else {
                            min = a;
                        }
                    }
                    a = this.aRR;
                    i2 = this.aRS;
                    if (a == 0 || this.aRP == 0) {
                        obj = null;
                    } else if (i2 > a * 3) {
                        obj = null;
                    } else if (a * 2 <= this.aRQ * 3) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj != null) {
                        i5 = this.aRP;
                    } else {
                        i5 = min;
                    }
                    this.aRQ = this.aRR;
                    this.aRP = min;
                    if (((double) f) > 1.0d) {
                        sArr = this.aRE;
                        if (f >= 2.0f) {
                            min = (int) (((float) i5) / (f - 1.0f));
                        } else {
                            this.aRO = (int) ((((float) i5) * (2.0f - f)) / (f - 1.0f));
                            min = i5;
                        }
                        dz(min);
                        a(min, this.aRy, this.aRG, this.aRM, sArr, i, sArr, i + i5);
                        this.aRM += min;
                        i += min + i5;
                    } else {
                        int i6;
                        short[] sArr3 = this.aRE;
                        if (f < 0.5f) {
                            i6 = (int) ((((float) i5) * f) / (1.0f - f));
                        } else {
                            this.aRO = (int) ((((float) i5) * ((2.0f * f) - 1.0f)) / (1.0f - f));
                            i6 = i5;
                        }
                        dz(i5 + i6);
                        System.arraycopy(sArr3, this.aRy * i, this.aRG, this.aRM * this.aRy, this.aRy * i5);
                        a(i6, this.aRy, this.aRG, this.aRM + i5, sArr3, i + i5, sArr3, i);
                        this.aRM += i5 + i6;
                        i += i6;
                    }
                }
            } while (this.aRB + i <= i4);
            min = this.aRL - i;
            System.arraycopy(this.aRE, this.aRy * i, this.aRE, 0, this.aRy * min);
            this.aRL = min;
        }
        if (this.pitch != 1.0f) {
            float f2 = this.pitch;
            if (this.aRM != i3) {
                int i7;
                a = (int) (((float) this.sampleRate) / f2);
                min = this.sampleRate;
                while (true) {
                    i2 = min;
                    i7 = a;
                    if (i7 <= 16384 && i2 <= 16384) {
                        break;
                    }
                    a = i7 / 2;
                    min = i2 / 2;
                }
                min = this.aRM - i3;
                if (this.aRN + min > this.aRH) {
                    this.aRH += (this.aRH / 2) + min;
                    this.aRI = Arrays.copyOf(this.aRI, this.aRH * this.aRy);
                }
                System.arraycopy(this.aRG, this.aRy * i3, this.aRI, this.aRN * this.aRy, this.aRy * min);
                this.aRM = i3;
                this.aRN = min + this.aRN;
                min = 0;
                while (true) {
                    a = min;
                    if (a >= this.aRN - 1) {
                        break;
                    }
                    while ((this.aRJ + 1) * i7 > this.aRK * i2) {
                        dz(1);
                        for (min = 0; min < this.aRy; min++) {
                            sArr = this.aRG;
                            i = (this.aRM * this.aRy) + min;
                            short[] sArr4 = this.aRI;
                            int i8 = (this.aRy * a) + min;
                            short s = sArr4[i8];
                            short s2 = sArr4[i8 + this.aRy];
                            int i9 = (this.aRJ + 1) * i7;
                            i8 = i9 - (this.aRK * i2);
                            int i10 = i9 - (this.aRJ * i7);
                            sArr[i] = (short) (((s2 * (i10 - i8)) + (s * i8)) / i10);
                        }
                        this.aRK++;
                        this.aRM++;
                    }
                    this.aRJ++;
                    if (this.aRJ == i2) {
                        this.aRJ = 0;
                        a.checkState(this.aRK == i7);
                        this.aRK = 0;
                    }
                    min = a + 1;
                }
                min = this.aRN - 1;
                if (min != 0) {
                    System.arraycopy(this.aRI, this.aRy * min, this.aRI, 0, (this.aRN - min) * this.aRy);
                    this.aRN -= min;
                }
            }
        }
        AppMethodBeat.o(94727);
    }

    private static void a(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i3 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i4 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i7] = (short) (((sArr2[i9] * (i - i10)) + (sArr3[i8] * i10)) / i);
                i7 += i2;
                i9 += i2;
                i8 += i2;
            }
        }
    }
}
