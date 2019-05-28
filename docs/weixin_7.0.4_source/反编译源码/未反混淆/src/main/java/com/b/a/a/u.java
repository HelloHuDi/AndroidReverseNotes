package com.b.a.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

final class u extends d implements SensorEventListener {
    private static final int bGB;
    private static final int bGC;
    private static u bGU;
    private Sensor accelerometer;
    private SensorManager bCW = null;
    private Sensor bGD;
    private Sensor bGE;
    private Sensor bGF;
    private Sensor bGG = null;
    private long bGH = 0;
    private boolean bGI = true;
    private float[][] bGJ = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 9}));
    private float[][] bGK = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 9}));
    private float[][] bGL = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 9}));
    private float[][] bGM = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));
    private float[][] bGN = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));
    private float[][] bGO = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));
    private float[][] bGP = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));
    private float[] bGQ = new float[4];
    private float[][] bGR = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));
    private float[][] bGS = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));
    private float[][] bGT = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));
    boolean bGV;
    private c bGW;
    private boolean[] bGX = new boolean[6];
    private int[] bGY = new int[6];
    private float[] bGZ = new float[6];
    private float[] bHa = new float[6];
    private float[] bHb = new float[]{Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN};
    private float[][] bHc = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 20}));
    private final d bHd = new d();
    private final f bHe = new f(this, (byte) 0);
    private final a bHf = new a();

    static class e extends p {
        final float bHZ;
        final float bIa;
        final int bIb;
        final float speed;
        final float x;
        final float y;

        /* synthetic */ e(float f, float f2, int i, float f3, float f4, float f5, byte b) {
            this(f, f2, i, f3, f4, f5);
        }

        private e(float f, float f2, int i, float f3, float f4, float f5) {
            super(301);
            this.x = f;
            this.y = f2;
            this.bIb = i;
            this.bHZ = f3;
            this.bIa = f4;
            this.speed = f5;
        }
    }

    class f {
        private ArrayList<b> bIc;
        private a[] bId;
        private int bIe;
        private float[][] bIf;
        private float[][] bIg;
        private float[][] bIh;
        private int[] bIi;
        private int bIj;
        private int bIk;
        private int bIl;

        class a {
            int bIm;
            float bIn;
            float bIo;
            float bIp;
            long bIq;
            float x;
            float y;
            float z;

            /* Access modifiers changed, original: protected|final|synthetic */
            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(55633);
                a wB = wB();
                AppMethodBeat.o(55633);
                return wB;
            }

            private a() {
                this.x = 0.0f;
                this.y = 0.0f;
                this.z = 0.0f;
                this.bIm = 0;
                this.bIn = 0.0f;
                this.bIo = 0.0f;
                this.bIp = 0.0f;
                this.bIq = 0;
            }

            /* synthetic */ a(f fVar, byte b) {
                this();
            }

            /* Access modifiers changed, original: protected|final */
            public final a wB() {
                AppMethodBeat.i(55632);
                a aVar = new a();
                aVar.x = this.x;
                aVar.y = this.y;
                aVar.z = this.z;
                aVar.bIm = this.bIm;
                aVar.bIn = this.bIn;
                aVar.bIo = this.bIo;
                aVar.bIq = this.bIq;
                aVar.bIp = this.bIp;
                AppMethodBeat.o(55632);
                return aVar;
            }
        }

        private f() {
            AppMethodBeat.i(55634);
            this.bIc = new ArrayList();
            this.bId = new a[5];
            this.bIe = 0;
            this.bIf = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
            this.bIg = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
            this.bIh = (float[][]) Array.newInstance(Float.TYPE, new int[]{3, 3});
            this.bIi = new int[6];
            this.bIj = 5;
            this.bIk = -1;
            this.bIl = 0;
            AppMethodBeat.o(55634);
        }

        /* synthetic */ f(u uVar, byte b) {
            this();
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized void reset() {
            AppMethodBeat.i(55635);
            this.bIc.clear();
            this.bId = new a[5];
            this.bIe = 0;
            this.bIf = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
            this.bIg = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
            this.bIh = (float[][]) Array.newInstance(Float.TYPE, new int[]{3, 3});
            this.bIi = new int[6];
            this.bIj = 5;
            AppMethodBeat.o(55635);
        }

        private synchronized boolean wy() {
            boolean z;
            AppMethodBeat.i(55636);
            if (this.bIe >= 20) {
                float[] fArr = this.bIf[0];
                fArr[2] = fArr[2] / 20.0f;
                fArr = this.bIf[1];
                fArr[2] = fArr[2] / 20.0f;
                fArr = this.bIf[2];
                fArr[2] = fArr[2] / 20.0f;
                fArr = this.bIg[0];
                fArr[2] = fArr[2] / 20.0f;
                fArr = this.bIg[1];
                fArr[2] = fArr[2] / 20.0f;
                fArr = this.bIg[2];
                fArr[2] = fArr[2] / 20.0f;
                float f = this.bIg[0][2];
                float f2 = this.bIf[0][0] - this.bIf[0][2];
                float f3 = this.bIf[0][2] - this.bIf[0][1];
                float f4 = this.bIg[1][2];
                float f5 = this.bIf[1][0] - this.bIf[1][2];
                float f6 = this.bIf[1][2] - this.bIf[1][1];
                float f7 = this.bIg[2][2];
                float f8 = this.bIf[2][0] - this.bIf[2][2];
                float f9 = this.bIf[2][2] - this.bIf[2][1];
                this.bIh[0][0] = (f * 0.32999998f) + (0.67f * this.bIh[0][0]);
                this.bIh[0][1] = (f2 * 0.32999998f) + (0.67f * this.bIh[0][1]);
                this.bIh[0][2] = (f3 * 0.32999998f) + (0.67f * this.bIh[0][2]);
                this.bIh[1][0] = (0.67f * this.bIh[1][0]) + (f4 * 0.32999998f);
                this.bIh[1][1] = (0.67f * this.bIh[1][1]) + (0.32999998f * f5);
                this.bIh[1][2] = (0.67f * this.bIh[1][2]) + (0.32999998f * f6);
                this.bIh[2][0] = (0.67f * this.bIh[2][0]) + (0.32999998f * f7);
                this.bIh[2][1] = (0.67f * this.bIh[2][1]) + (0.32999998f * f8);
                this.bIh[2][2] = (0.67f * this.bIh[2][2]) + (0.32999998f * f9);
                a(wz());
                this.bIe = 0;
                this.bIf = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
                this.bIg = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
                if (this.bIc.size() >= 100) {
                    this.bIc.subList(0, 20).clear();
                    this.bIc.trimToSize();
                }
                z = true;
                AppMethodBeat.o(55636);
            } else {
                z = false;
                AppMethodBeat.o(55636);
            }
            return z;
        }

        private synchronized a wz() {
            a aVar;
            Object obj;
            float abs;
            float abs2;
            float abs3;
            float f;
            int i;
            int i2;
            AppMethodBeat.i(55637);
            Object obj2 = this.bIl == 0 ? 1 : null;
            if (obj2 != null) {
                this.bIj = ((double) Math.abs(this.bIh[2][0])) < 9.3d ? 5 : 2;
                this.bIi = new int[6];
                obj = null;
            } else {
                Object obj3 = (Math.abs(this.bIh[0][0]) < 7.0f || (this.bIh[1][1] < 2.3f && this.bIh[1][2] < 2.3f)) ? null : 1;
                if (obj3 != null) {
                    this.bIj = 2;
                    this.bIi = new int[6];
                    obj = obj3;
                } else {
                    int i3;
                    abs = Math.abs(this.bIh[0][0]);
                    abs2 = Math.abs(this.bIh[1][0]);
                    abs3 = Math.abs(this.bIh[2][0]);
                    if (abs > abs2) {
                        if (abs > abs3) {
                            i3 = 0;
                        } else {
                            i3 = 2;
                        }
                    } else if (abs2 > abs3) {
                        i3 = 1;
                    } else {
                        i3 = 2;
                    }
                    f = 0.0f;
                    int i4 = 0;
                    i = 0;
                    for (i2 = 0; i2 < 3; i2++) {
                        if (i2 != i3) {
                            for (int i5 = 1; i5 < 3; i5++) {
                                if (this.bIh[i2][i5] > f) {
                                    f = this.bIh[i2][i5];
                                    i = i5;
                                    i4 = i2;
                                }
                            }
                        }
                    }
                    i3 = ((i4 * 2) + i) - 1;
                    int[] iArr = this.bIi;
                    iArr[i3] = iArr[i3] + 1;
                    i3 = 0;
                    while (i3 <= 5) {
                        if (i3 != this.bIj && this.bIi[i3] > this.bIi[this.bIj]) {
                            this.bIj = i3;
                        }
                        i3++;
                    }
                    obj = obj3;
                }
            }
            if (this.bIk >= 0 && this.bIk <= 5) {
                this.bIj = this.bIk;
            }
            aVar = new a(this, (byte) 0);
            aVar = new a(this, (byte) 0);
            if (this.bId[0] != null) {
                aVar.bIq = this.bId[0].bIq;
                aVar.bIn = this.bId[0].bIn;
            }
            if (this.bId[4] != null) {
                aVar.bIq = this.bId[4].bIq;
                aVar.bIn = this.bId[4].bIn;
            }
            if (!this.bIc.isEmpty()) {
                b bVar;
                i2 = this.bIc.size();
                float[] fArr = new float[6];
                float[] fArr2 = new float[6];
                Iterator it = this.bIc.iterator();
                abs3 = 0.0f;
                float f2 = 0.0f;
                while (it.hasNext()) {
                    bVar = (b) it.next();
                    if (obj == null) {
                        abs2 = bVar.bHB;
                    } else {
                        abs2 = bVar.bHE;
                    }
                    f2 += abs2;
                    if (obj == null) {
                        abs2 = bVar.bHJ;
                    } else {
                        abs2 = (float) Math.sqrt((double) (((bVar.bHC * bVar.bHC) + (bVar.bHD * bVar.bHD)) + (bVar.bHE * bVar.bHE)));
                        bVar.bHI = abs2;
                    }
                    abs3 += abs2;
                    for (i = 0; i <= 5; i++) {
                        fArr[i] = fArr[i] + bVar.bHN[i];
                        fArr2[i] = fArr2[i] + bVar.bHO[i];
                    }
                }
                float f3 = f2 / ((float) i2);
                float f4 = abs3 / ((float) i2);
                float f5 = obj == null ? f3 : f4;
                float[] fArr3 = new float[]{(float) Math.atan2((double) fArr[0], (double) fArr2[0]), (float) Math.atan2((double) fArr[1], (double) fArr2[1]), (float) Math.atan2((double) fArr[2], (double) fArr2[2]), (float) Math.atan2((double) fArr[3], (double) fArr2[3]), (float) Math.atan2((double) fArr[4], (double) fArr2[4]), (float) Math.atan2((double) fArr[5], (double) fArr2[5])};
                float f6 = obj == null ? f3 : f4;
                abs2 = 0.0f;
                float f7 = obj == null ? 1.2f : 1.0f;
                float f8 = obj2 != null ? 0.08726647f : 0.2617994f;
                Iterator it2 = this.bIc.iterator();
                f2 = f4;
                float f9 = 0.0f;
                float f10 = 0.0f;
                int i6 = 0;
                while (it2.hasNext()) {
                    float f11;
                    bVar = (b) it2.next();
                    if (obj == null) {
                        f11 = bVar.bHB;
                    } else {
                        f11 = bVar.bHI;
                    }
                    if (obj == null) {
                        abs3 = bVar.bHJ;
                    } else {
                        abs3 = bVar.bHI;
                    }
                    float f12 = obj == null ? f3 : f4;
                    if (i6 > 0) {
                        float f13;
                        if (f6 < f11) {
                            if (obj2 == null) {
                                f = f11 - f12;
                                if (f > 2.0f * f7) {
                                    f13 = f / 2.0f;
                                    f6 = f11;
                                }
                            }
                            f13 = f7;
                            f6 = f11;
                        } else {
                            f13 = f7;
                        }
                        if (f2 < abs3) {
                            f = abs3;
                        } else {
                            f = f2;
                        }
                        if (f11 > f12) {
                            f7 = f13;
                            f2 = f;
                            i6++;
                        } else {
                            if (i6 <= 10) {
                                Object obj4 = 1;
                                if (aVar.bIq != 0 && bVar.time - aVar.bIq < 250) {
                                    obj4 = null;
                                }
                                if (obj4 != null && f - f4 < 0.3f) {
                                    obj4 = null;
                                }
                                if (obj4 != null) {
                                    aVar.bIm++;
                                    abs2 += f6;
                                    f2 = (float) Math.atan2((double) (bVar.bHN[this.bIj] + f10), (double) (bVar.bHO[this.bIj] + f9));
                                    abs3 = Math.abs(f2 - fArr3[this.bIj]);
                                    if (abs3 > 3.1415927f) {
                                        abs3 = 6.2831855f - abs3;
                                    }
                                    Object obj5 = abs3 >= f8 ? 1 : null;
                                    abs3 = 1.0f;
                                    if (obj5 != null) {
                                        abs3 = 0.93f;
                                    } else {
                                        f2 = fArr3[this.bIj];
                                    }
                                    f7 = (float) (Math.sin((double) f2) * ((double) abs3));
                                    abs3 = (float) (((double) abs3) * Math.cos((double) f2));
                                    aVar.x += f7;
                                    aVar.y += abs3;
                                    if (bVar.time - aVar.bIq > 250) {
                                        aVar.x -= f7;
                                        aVar.y -= abs3;
                                        aVar.bIm++;
                                    }
                                }
                                aVar.bIq = bVar.time;
                            }
                            abs3 = bVar.bHN[this.bIj];
                            f7 = f13;
                            f2 = f;
                            f9 = bVar.bHO[this.bIj];
                            f10 = abs3;
                            i6 = 0;
                        }
                    } else if (f11 <= f12) {
                        abs3 = bVar.bHN[this.bIj];
                        f9 = bVar.bHO[this.bIj];
                        f10 = abs3;
                    } else if (f11 - f12 >= f7) {
                        f2 = abs3;
                        f6 = f11;
                        i6 = 1;
                    }
                }
                if (aVar.bIm > 0) {
                    if (obj == null) {
                        abs = 0.0f;
                    } else {
                        abs = 0.08f;
                    }
                    abs2 /= (float) aVar.bIm;
                    abs3 = aVar.bIn;
                    abs += ((abs2 - f5) / 15.0f) + 0.537f;
                    if (abs3 != 0.0f) {
                        abs = (abs * 0.67f) + (0.33f * abs3);
                    }
                    aVar.bIn = abs;
                    aVar.x *= aVar.bIn;
                    aVar.y *= aVar.bIn;
                    aVar.bIo = ((float) aVar.bIm) * aVar.bIn;
                }
            }
            aVar.bIp = aVar.bIo / ((float) (this.bIc.size() / 20));
            if (this.bId[0] != null) {
                aVar.x += this.bId[0].x;
                aVar.y += this.bId[0].y;
                aVar.z += this.bId[0].z;
                aVar.bIm += this.bId[0].bIm;
                aVar.bIo += this.bId[0].bIo;
            }
            if (this.bId[4] != null && aVar.bIm > 0) {
                this.bId[4].x = ((this.bId[4].x + aVar.x) + (aVar.x * aVar.bIn)) / 2.0f;
                this.bId[4].y = ((this.bId[4].y + aVar.y) + (aVar.y * aVar.bIn)) / 2.0f;
            }
            AppMethodBeat.o(55637);
            return aVar;
        }

        private synchronized void a(a aVar) {
            AppMethodBeat.i(55638);
            System.arraycopy(this.bId, 1, this.bId, 0, 4);
            if (this.bId[4] == null || SystemClock.elapsedRealtime() - aVar.bIq <= 1000) {
                this.bId[4] = aVar;
                AppMethodBeat.o(55638);
            } else {
                a aVar2 = this.bId[4];
                aVar2.x = (aVar2.x + aVar.x) / 2.0f;
                aVar2.y = (aVar2.y + aVar.y) / 2.0f;
                aVar2.z = (aVar2.z + aVar.z) / 2.0f;
                aVar2.bIm = Math.round(((float) (aVar2.bIm + aVar.bIm)) / 2.0f);
                aVar2.bIn = (aVar2.bIn + aVar.bIn) / 2.0f;
                aVar2.bIo = (aVar2.bIo + aVar.bIo) / 2.0f;
                aVar2.bIq = aVar.bIq;
                aVar2.bIp = aVar.bIp;
                AppMethodBeat.o(55638);
            }
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized void a(b bVar) {
            AppMethodBeat.i(55639);
            if (this.bIl > 0 && this.bIl < 101) {
                this.bIl--;
            }
            this.bIc.add(bVar);
            this.bIe++;
            if (bVar.bHC > this.bIf[0][0]) {
                this.bIf[0][0] = bVar.bHC;
            }
            if (bVar.bHC < this.bIf[0][1]) {
                this.bIf[0][1] = bVar.bHC;
            }
            float[] fArr = this.bIf[0];
            fArr[2] = fArr[2] + bVar.bHC;
            if (bVar.bHD > this.bIf[1][0]) {
                this.bIf[1][0] = bVar.bHD;
            }
            if (bVar.bHD < this.bIf[1][1]) {
                this.bIf[1][1] = bVar.bHD;
            }
            fArr = this.bIf[1];
            fArr[2] = fArr[2] + bVar.bHD;
            if (bVar.bHE > this.bIf[2][0]) {
                this.bIf[2][0] = bVar.bHE;
            }
            if (bVar.bHE < this.bIf[2][1]) {
                this.bIf[2][1] = bVar.bHE;
            }
            fArr = this.bIf[2];
            fArr[2] = fArr[2] + bVar.bHE;
            if (bVar.bHF > this.bIg[0][0]) {
                this.bIg[0][0] = bVar.bHF;
            }
            if (bVar.bHF < this.bIg[0][1]) {
                this.bIg[0][1] = bVar.bHF;
            }
            fArr = this.bIg[0];
            fArr[2] = fArr[2] + bVar.bHF;
            if (bVar.bHG > this.bIg[1][0]) {
                this.bIg[1][0] = bVar.bHG;
            }
            if (bVar.bHG < this.bIg[1][1]) {
                this.bIg[1][1] = bVar.bHG;
            }
            fArr = this.bIg[1];
            fArr[2] = fArr[2] + bVar.bHG;
            if (bVar.bHH > this.bIg[2][0]) {
                this.bIg[2][0] = bVar.bHH;
            }
            if (bVar.bHH < this.bIg[2][1]) {
                this.bIg[2][1] = bVar.bHH;
            }
            fArr = this.bIg[2];
            fArr[2] = fArr[2] + bVar.bHH;
            if (wy()) {
                u.b(u.this);
            }
            AppMethodBeat.o(55639);
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized a wA() {
            a wB;
            AppMethodBeat.i(55640);
            if (this.bId[4] != null) {
                wB = this.bId[4].wB();
                AppMethodBeat.o(55640);
            } else {
                wB = null;
                AppMethodBeat.o(55640);
            }
            return wB;
        }
    }

    static class a {
        int bHg;
        float bHh;
        long bHi;
        float bHj;
        boolean bHk;
        long bHl;
        float[] bHm;
        float[] bHn;
        float[] bHo;
        float[] bHp;
        float[] bHq;
        float[] bHr;
        float[] bHs;
        float[] bHt;
        float[] bHu;
        float bHv;
        float bHw;
        float bHx;
        boolean bHy;

        private a() {
            AppMethodBeat.i(55628);
            this.bHg = 0;
            this.bHh = 0.0f;
            this.bHi = 0;
            this.bHj = 0.0f;
            this.bHk = false;
            this.bHl = 0;
            this.bHm = new float[6];
            this.bHn = new float[6];
            this.bHo = new float[6];
            this.bHp = new float[6];
            this.bHq = new float[6];
            this.bHr = new float[6];
            this.bHs = new float[6];
            this.bHt = new float[6];
            this.bHu = new float[6];
            this.bHv = 0.0f;
            this.bHw = Float.NEGATIVE_INFINITY;
            this.bHx = Float.POSITIVE_INFINITY;
            this.bHy = false;
            AppMethodBeat.o(55628);
        }

        /* synthetic */ a(byte b) {
            this();
        }

        /* Access modifiers changed, original: final */
        public final void reset() {
            this.bHg = 0;
            this.bHh = 0.0f;
            this.bHi = 0;
            this.bHj = 0.0f;
            this.bHk = false;
            this.bHl = 0;
            this.bHm = new float[6];
            this.bHn = new float[6];
            this.bHo = new float[6];
            this.bHv = 0.0f;
            this.bHw = Float.NEGATIVE_INFINITY;
            this.bHx = Float.POSITIVE_INFINITY;
        }
    }

    static class b {
        float bHA;
        float bHB;
        float bHC;
        float bHD;
        float bHE;
        float bHF;
        float bHG;
        float bHH;
        float bHI;
        float bHJ;
        float[] bHK;
        float[] bHL;
        float[] bHM;
        float[] bHN;
        float[] bHO;
        float bHz;
        long time;

        private b() {
            AppMethodBeat.i(55629);
            this.bHK = new float[6];
            this.bHL = new float[6];
            this.bHM = new float[6];
            this.bHN = new float[6];
            this.bHO = new float[6];
            AppMethodBeat.o(55629);
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    class c extends e {
        c(Handler handler) {
            super(handler);
        }

        /* Access modifiers changed, original: final */
        public final void vZ() {
            AppMethodBeat.i(55630);
            u.a(u.this);
            AppMethodBeat.o(55630);
        }
    }

    static class d {
        private float bHQ;
        private float bHR;
        private float bHS;
        private float bHT;
        private float bHU;
        private float bHV;
        private float bHW;
        private float bHX;
        private float bHY;
        private int count;

        private d() {
            this.count = 0;
            this.bHQ = 0.0f;
            this.bHR = 0.0f;
            this.bHS = 0.0f;
            this.bHT = 0.0f;
            this.bHU = 0.0f;
            this.bHV = 0.0f;
            this.bHW = 0.0f;
            this.bHX = 0.0f;
            this.bHY = 0.0f;
        }

        /* synthetic */ d(byte b) {
            this();
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized void reset() {
            this.count = 0;
            this.bHQ = 0.0f;
            this.bHR = 0.0f;
            this.bHS = 0.0f;
            this.bHT = 0.0f;
            this.bHU = 0.0f;
            this.bHV = 0.0f;
            this.bHW = 0.0f;
            this.bHX = 0.0f;
            this.bHY = 0.0f;
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized void a(float[] fArr, float[] fArr2, float[] fArr3) {
            if (fArr.length >= 3) {
                this.count++;
                this.bHQ += fArr[0];
                this.bHR += fArr[1];
                this.bHS += fArr[2];
                this.bHT += fArr2[0];
                this.bHU += fArr2[1];
                this.bHV += fArr2[2];
                this.bHW += fArr3[0];
                this.bHX += fArr3[1];
                this.bHY += fArr3[2];
            }
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized b a(float[][] fArr) {
            b bVar;
            synchronized (this) {
                AppMethodBeat.i(55631);
                if (this.count <= 0 || fArr.length < 3) {
                    bVar = null;
                    AppMethodBeat.o(55631);
                } else {
                    bVar = new b();
                    bVar.time = SystemClock.elapsedRealtime();
                    for (int i = 0; i <= 5; i++) {
                        bVar.bHK[i] = fArr[i][0];
                        bVar.bHL[i] = fArr[i][1];
                        bVar.bHM[i] = fArr[i][2];
                        bVar.bHN[i] = (float) Math.sin((double) bVar.bHK[i]);
                        bVar.bHO[i] = (float) Math.cos((double) bVar.bHK[i]);
                    }
                    bVar.bHz = this.bHQ / ((float) this.count);
                    bVar.bHA = this.bHR / ((float) this.count);
                    bVar.bHB = this.bHS / ((float) this.count);
                    bVar.bHC = this.bHT / ((float) this.count);
                    bVar.bHD = this.bHU / ((float) this.count);
                    bVar.bHE = this.bHV / ((float) this.count);
                    bVar.bHF = this.bHW / ((float) this.count);
                    bVar.bHG = this.bHX / ((float) this.count);
                    bVar.bHH = this.bHY / ((float) this.count);
                    bVar.bHJ = (float) Math.sqrt((double) ((bVar.bHz * bVar.bHz) + (bVar.bHA * bVar.bHA)));
                    reset();
                    AppMethodBeat.o(55631);
                }
            }
            return bVar;
        }
    }

    static {
        AppMethodBeat.i(55641);
        int round = Math.round(50000.0f);
        bGB = round;
        bGC = round;
        AppMethodBeat.o(55641);
    }

    static u wx() {
        AppMethodBeat.i(55642);
        if (bGU == null) {
            bGU = new u();
        }
        u uVar = bGU;
        AppMethodBeat.o(55642);
        return uVar;
    }

    private u() {
        AppMethodBeat.i(55643);
        AppMethodBeat.o(55643);
    }

    private static void a(float[][] fArr, float[][] fArr2) {
        AppMethodBeat.i(55644);
        for (int i = 0; i <= 5; i++) {
            SensorManager.getOrientation(fArr[i], fArr2[i]);
        }
        AppMethodBeat.o(55644);
    }

    private static float[] b(float[] fArr, float[] fArr2) {
        return new float[]{((fArr[0] * fArr2[0]) + (fArr[1] * fArr2[3])) + (fArr[2] * fArr2[6]), ((fArr[0] * fArr2[1]) + (fArr[1] * fArr2[4])) + (fArr[2] * fArr2[7]), ((fArr[0] * fArr2[2]) + (fArr[1] * fArr2[5])) + (fArr[2] * fArr2[8]), ((fArr[3] * fArr2[0]) + (fArr[4] * fArr2[3])) + (fArr[5] * fArr2[6]), ((fArr[3] * fArr2[1]) + (fArr[4] * fArr2[4])) + (fArr[5] * fArr2[7]), ((fArr[3] * fArr2[2]) + (fArr[4] * fArr2[5])) + (fArr[5] * fArr2[8]), ((fArr[6] * fArr2[0]) + (fArr[7] * fArr2[3])) + (fArr[8] * fArr2[6]), ((fArr[6] * fArr2[1]) + (fArr[7] * fArr2[4])) + (fArr[8] * fArr2[7]), ((fArr[6] * fArr2[2]) + (fArr[7] * fArr2[5])) + (fArr[8] * fArr2[8])};
    }

    /* Access modifiers changed, original: final */
    public final void at(Context context) {
    }

    /* Access modifiers changed, original: final */
    public final void vV() {
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void a(Handler handler, a aVar) {
        AppMethodBeat.i(55647);
        super.a(handler, aVar);
        AppMethodBeat.o(55647);
    }

    @TargetApi(19)
    private static boolean a(SensorManager sensorManager, SensorEventListener sensorEventListener, int i, int i2, Handler handler, Sensor... sensorArr) {
        AppMethodBeat.i(55648);
        try {
            Object obj = VERSION.SDK_INT >= 19 ? 1 : null;
            int length = sensorArr.length;
            int i3 = 0;
            while (i3 < length) {
                Sensor sensor = sensorArr[i3];
                if (obj != null ? sensorManager.registerListener(sensorEventListener, sensor, i, i2, handler) : sensorManager.registerListener(sensorEventListener, sensor, i, handler)) {
                    i3++;
                } else {
                    sensorManager.unregisterListener(sensorEventListener);
                    AppMethodBeat.o(55648);
                    return false;
                }
            }
            AppMethodBeat.o(55648);
            return true;
        } catch (Error e) {
            AppMethodBeat.o(55648);
            return false;
        } catch (Exception e2) {
            AppMethodBeat.o(55648);
            return false;
        }
    }

    private static void a(float[] fArr, float[][] fArr2) {
        AppMethodBeat.i(55649);
        fArr2[0][0] = -fArr[1];
        fArr2[0][1] = fArr[0];
        fArr2[0][2] = fArr[2];
        fArr2[1][0] = fArr[1];
        fArr2[1][1] = -fArr[0];
        fArr2[1][2] = fArr[2];
        System.arraycopy(fArr, 0, fArr2[2], 0, 3);
        fArr2[3][0] = -fArr[0];
        fArr2[3][1] = -fArr[1];
        fArr2[3][2] = fArr[2];
        fArr2[4][0] = fArr[0];
        fArr2[4][1] = fArr[2];
        fArr2[4][2] = -fArr[1];
        fArr2[5][0] = fArr[0];
        fArr2[5][1] = -fArr[2];
        fArr2[5][2] = fArr[1];
        AppMethodBeat.o(55649);
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        int i = 0;
        AppMethodBeat.i(55650);
        float[] fArr;
        int i2;
        float[][] fArr2;
        float[][] fArr3;
        float[][] fArr4;
        switch (sensorEvent.sensor.getType()) {
            case 2:
                a(sensorEvent.values, this.bGS);
                a aVar = this.bHf;
                fArr = sensorEvent.values;
                if (fArr.length >= 3) {
                    aVar.bHg++;
                    aVar.bHh = (float) (Math.sqrt((double) (((fArr[0] * fArr[0]) + (fArr[1] * fArr[1])) + (fArr[2] * fArr[2]))) + ((double) aVar.bHh));
                    break;
                }
                break;
            case 4:
                if (!(this.bGM[2][0] == 0.0f && this.bGM[2][1] == 0.0f && this.bGM[2][2] == 0.0f)) {
                    if (this.bGI) {
                        for (i2 = 0; i2 <= 5; i2++) {
                            fArr = this.bGJ[i2];
                            fArr2 = this.bGK;
                            fArr2[i2] = b(fArr2[i2], fArr);
                        }
                        this.bGI = false;
                    }
                    fArr3 = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 4});
                    if (this.bGH != 0) {
                        float f = 1.0E-9f * ((float) (sensorEvent.timestamp - this.bGH));
                        a(sensorEvent.values, this.bGR);
                        for (int i3 = 0; i3 <= 5; i3++) {
                            float[] fArr5 = this.bGR[i3];
                            float[] fArr6 = fArr3[i3];
                            float f2 = f / 2.0f;
                            float[] fArr7 = new float[3];
                            float sqrt = (float) Math.sqrt((double) (((fArr5[0] * fArr5[0]) + (fArr5[1] * fArr5[1])) + (fArr5[2] * fArr5[2])));
                            if (sqrt > 1.0E-9f) {
                                fArr7[0] = fArr5[0] / sqrt;
                                fArr7[1] = fArr5[1] / sqrt;
                                fArr7[2] = fArr5[2] / sqrt;
                            }
                            float f3 = sqrt * f2;
                            f2 = (float) Math.sin((double) f3);
                            f3 = (float) Math.cos((double) f3);
                            fArr6[0] = fArr7[0] * f2;
                            fArr6[1] = fArr7[1] * f2;
                            fArr6[2] = f2 * fArr7[2];
                            fArr6[3] = f3;
                        }
                    }
                    this.bGH = sensorEvent.timestamp;
                    while (i <= 5) {
                        fArr = new float[9];
                        try {
                            SensorManager.getRotationMatrixFromVector(fArr, fArr3[i]);
                        } catch (Exception e) {
                        }
                        fArr4 = this.bGK;
                        fArr4[i] = b(fArr4[i], fArr);
                        i++;
                    }
                    a(this.bGK, this.bGN);
                }
                AppMethodBeat.o(55650);
                return;
            case 9:
                a(sensorEvent.values, this.bGT);
                if (!(this.bGS[2][0] == 0.0f && this.bGS[2][1] == 0.0f && this.bGS[2][2] == 0.0f)) {
                    fArr3 = this.bGJ;
                    float[][] fArr8 = this.bGT;
                    fArr2 = this.bGS;
                    if (SensorManager.getRotationMatrix(fArr3[0], null, fArr8[0], fArr2[0]) && SensorManager.getRotationMatrix(fArr3[1], null, fArr8[1], fArr2[1]) && SensorManager.getRotationMatrix(fArr3[2], null, fArr8[2], fArr2[2]) && SensorManager.getRotationMatrix(fArr3[3], null, fArr8[3], fArr2[3]) && SensorManager.getRotationMatrix(fArr3[4], null, fArr8[4], fArr2[4]) && SensorManager.getRotationMatrix(fArr3[5], null, fArr8[5], fArr2[5])) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (i2 != 0) {
                        a(this.bGJ, this.bGM);
                        if (this.bGN[2][0] == 0.0f && this.bGN[2][1] == 0.0f && this.bGN[2][2] == 0.0f) {
                            fArr8 = this.bGM;
                            fArr4 = this.bGN;
                            for (i2 = 0; i2 <= 5; i2++) {
                                System.arraycopy(fArr8[i2], 0, fArr4[i2], 0, 3);
                            }
                        }
                    }
                    AppMethodBeat.o(55650);
                    return;
                }
                break;
            case 10:
                fArr = new float[16];
                if (this.bGG != null) {
                    fArr3 = this.bGL;
                } else {
                    fArr3 = this.bGK;
                }
                float[] fArr9 = fArr3[2];
                float[] fArr10 = new float[16];
                if (fArr9.length == 9) {
                    fArr10[0] = fArr9[0];
                    fArr10[1] = fArr9[1];
                    fArr10[2] = fArr9[2];
                    fArr10[3] = 0.0f;
                    fArr10[4] = fArr9[3];
                    fArr10[5] = fArr9[4];
                    fArr10[6] = fArr9[5];
                    fArr10[7] = 0.0f;
                    fArr10[8] = fArr9[6];
                    fArr10[9] = fArr9[7];
                    fArr10[10] = fArr9[8];
                    fArr10[11] = 0.0f;
                    fArr10[12] = 0.0f;
                    fArr10[13] = 0.0f;
                    fArr10[14] = 0.0f;
                    fArr10[15] = 1.0f;
                }
                Matrix.invertM(fArr, 0, fArr10, 0);
                Matrix.multiplyMV(this.bGQ, 0, fArr, 0, new float[]{sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2], 0.0f}, 0);
                this.bHd.a(this.bGQ, sensorEvent.values, this.bGT[2]);
                AppMethodBeat.o(55650);
                return;
            case 11:
                try {
                    SensorManager.getRotationMatrixFromVector(this.bGL[2], sensorEvent.values);
                } catch (IllegalArgumentException e2) {
                    if (sensorEvent.values.length > 3) {
                        SensorManager.getRotationMatrixFromVector(this.bGL[2], new float[]{sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2]});
                    }
                }
                SensorManager.remapCoordinateSystem(this.bGL[2], 2, GmsClientSupervisor.DEFAULT_BIND_FLAGS, this.bGL[0]);
                SensorManager.remapCoordinateSystem(this.bGL[2], 130, 1, this.bGL[1]);
                SensorManager.remapCoordinateSystem(this.bGL[2], GmsClientSupervisor.DEFAULT_BIND_FLAGS, 130, this.bGL[3]);
                SensorManager.remapCoordinateSystem(this.bGL[2], GmsClientSupervisor.DEFAULT_BIND_FLAGS, 3, this.bGL[4]);
                SensorManager.remapCoordinateSystem(this.bGL[2], 1, 3, this.bGL[5]);
                while (i <= 5) {
                    SensorManager.getOrientation(this.bGL[i], this.bGP[i]);
                    i++;
                }
                AppMethodBeat.o(55650);
                return;
        }
        AppMethodBeat.o(55650);
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0078 A:{Catch:{ Exception -> 0x0018 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(Context context, Handler handler, a aVar) {
        AppMethodBeat.i(55645);
        if (context == null) {
            try {
                Exception exception = new Exception("SensorModule: register with null context");
                AppMethodBeat.o(55645);
                throw exception;
            } catch (Exception e) {
                this.bGV = false;
            }
        } else {
            boolean a;
            for (int i = 0; i <= 5; i++) {
                this.bGK[i][0] = 1.0f;
                this.bGK[i][1] = 0.0f;
                this.bGK[i][2] = 0.0f;
                this.bGK[i][3] = 0.0f;
                this.bGK[i][4] = 1.0f;
                this.bGK[i][5] = 0.0f;
                this.bGK[i][6] = 0.0f;
                this.bGK[i][7] = 0.0f;
                this.bGK[i][8] = 1.0f;
            }
            this.bCW = (SensorManager) context.getSystemService("sensor");
            this.accelerometer = this.bCW.getDefaultSensor(10);
            this.bGF = this.bCW.getDefaultSensor(9);
            if (!(this.accelerometer == null || this.bGF == null)) {
                this.bGG = this.bCW.getDefaultSensor(11);
                if (this.bGG != null) {
                    a = a(this.bCW, this, bGB, bGC, handler, this.accelerometer, this.bGF, this.bGG);
                } else {
                    this.bGD = this.bCW.getDefaultSensor(4);
                    this.bGE = this.bCW.getDefaultSensor(2);
                    if (!(this.bGD == null || this.bGE == null)) {
                        a = a(this.bCW, this, bGB, bGC, handler, this.accelerometer, this.bGF, this.bGD, this.bGE);
                    }
                }
                if (a) {
                    this.bGV = true;
                    this.bGW = new c(handler);
                    if (this.bGW != null) {
                        this.bGW.n((long) Math.round(50.0f), 1000);
                    }
                    AppMethodBeat.o(55645);
                    return;
                }
                AppMethodBeat.o(55645);
            }
            a = false;
            if (a) {
            }
            AppMethodBeat.o(55645);
        }
    }

    /* Access modifiers changed, original: final */
    public final void au(Context context) {
        AppMethodBeat.i(55646);
        if (this.bGW != null) {
            this.bGW.stop();
        }
        if (this.bCW != null) {
            try {
                this.bCW.unregisterListener(this);
            } catch (Error | Exception e) {
            }
        }
        this.bCW = null;
        this.bGG = null;
        this.bGF = null;
        this.bGE = null;
        this.bGD = null;
        this.accelerometer = null;
        this.bGH = 0;
        this.bGI = true;
        this.bGJ = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 9});
        this.bGK = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 9});
        this.bGM = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3});
        this.bGN = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3});
        this.bGO = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3});
        this.bGX = new boolean[6];
        this.bGY = new int[6];
        this.bGZ = new float[6];
        this.bHa = new float[6];
        this.bHb = new float[]{Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN};
        this.bHc = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 20});
        this.bHf.reset();
        this.bHd.reset();
        this.bHe.reset();
        AppMethodBeat.o(55646);
    }

    static /* synthetic */ void a(u uVar) {
        float[][] fArr;
        AppMethodBeat.i(55651);
        if (uVar.accelerometer != null && uVar.bGD != null && uVar.bGE != null && uVar.bGF != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 > 5) {
                    break;
                }
                float f;
                float[] fArr2;
                float[] fArr3;
                float[] fArr4;
                float f2;
                float f3;
                float abs;
                Object obj = null;
                if (Float.isNaN(uVar.bHb[i2])) {
                    uVar.bHb[i2] = uVar.bGN[i2][0];
                } else {
                    f = uVar.bGN[i2][0] - uVar.bGO[i2][0];
                    if (f < -3.1415927f) {
                        f += 6.2831855f;
                    } else if (f > 3.1415927f) {
                        f -= 6.2831855f;
                    }
                    fArr2 = uVar.bHc[i2];
                    int[] iArr = uVar.bGY;
                    int i3 = iArr[i2];
                    iArr[i2] = i3 + 1;
                    fArr2[i3] = f;
                    if (uVar.bGY[i2] == 20) {
                        uVar.bGY[i2] = 0;
                        if (!uVar.bGX[i2]) {
                            uVar.bGX[i2] = true;
                        }
                    }
                    fArr2 = uVar.bHa;
                    fArr2[i2] = fArr2[i2] + f;
                    fArr2 = uVar.bGZ;
                    fArr2[i2] = f + fArr2[i2];
                    if (uVar.bGX[i2]) {
                        Object obj2;
                        if (Math.abs(uVar.bGZ[i2]) < 0.08726647f) {
                            if (Math.abs(uVar.bHa[i2]) < 0.08726647f) {
                                f = uVar.bGN[i2][0] - uVar.bHb[i2];
                                if (f < -3.1415927f) {
                                    f += 6.2831855f;
                                } else if (f > 3.1415927f) {
                                    f -= 6.2831855f;
                                }
                                uVar.bGN[i2][0] = (f / 2.0f) + uVar.bHb[i2];
                                if (uVar.bGN[i2][0] < -3.1415927f) {
                                    uVar.bGN[i2][0] = 6.2831855f + uVar.bGN[i2][0];
                                } else if (uVar.bGN[i2][0] > 3.1415927f) {
                                    uVar.bGN[i2][0] = uVar.bGN[i2][0] - 6.2831855f;
                                }
                                uVar.bHb[i2] = uVar.bGN[i2][0];
                                obj2 = 1;
                                fArr3 = uVar.bGZ;
                                fArr3[i2] = fArr3[i2] - uVar.bHc[i2][uVar.bGY[i2]];
                                obj = obj2;
                            } else {
                                f = uVar.bHa[i2] % 1.5707964f;
                                float abs2 = Math.abs(f);
                                if (abs2 < 0.08726647f) {
                                    fArr2 = uVar.bHa;
                                    fArr2[i2] = fArr2[i2] - f;
                                    fArr4 = uVar.bHb;
                                    fArr4[i2] = (fArr4[i2] + uVar.bHa[i2]) % 6.2831855f;
                                    if (uVar.bHb[i2] < -3.1415927f) {
                                        uVar.bHb[i2] = 6.2831855f + uVar.bHb[i2];
                                    } else if (uVar.bHb[i2] > 3.1415927f) {
                                        fArr4 = uVar.bHb;
                                        fArr4[i2] = fArr4[i2] - 6.2831855f;
                                    }
                                } else if (abs2 > 1.4835299f) {
                                    if (uVar.bHa[i2] > 0.0f) {
                                        fArr2 = uVar.bHa;
                                        fArr2[i2] = (fArr2[i2] - f) + 1.5707964f;
                                    } else {
                                        fArr2 = uVar.bHa;
                                        fArr2[i2] = (fArr2[i2] - f) - 1.5707964f;
                                    }
                                    fArr4 = uVar.bHb;
                                    fArr4[i2] = (fArr4[i2] + uVar.bHa[i2]) % 6.2831855f;
                                    if (uVar.bHb[i2] < -3.1415927f) {
                                        uVar.bHb[i2] = 6.2831855f + uVar.bHb[i2];
                                    } else if (uVar.bHb[i2] > 3.1415927f) {
                                        fArr4 = uVar.bHb;
                                        fArr4[i2] = fArr4[i2] - 6.2831855f;
                                    }
                                } else {
                                    uVar.bHb[i2] = uVar.bGN[i2][0];
                                }
                                uVar.bHa[i2] = 0.0f;
                            }
                        }
                        obj2 = null;
                        fArr3 = uVar.bGZ;
                        fArr3[i2] = fArr3[i2] - uVar.bHc[i2][uVar.bGY[i2]];
                        obj = obj2;
                    }
                }
                a aVar = uVar.bHf;
                float[] fArr5 = uVar.bGN[i2];
                float[] fArr6 = uVar.bGM[i2];
                float[] fArr7 = uVar.bGO[i2];
                if (i2 == 0 && aVar.bHg != 0) {
                    aVar.bHi++;
                    aVar.bHv = aVar.bHh / ((float) aVar.bHg);
                    f2 = aVar.bHv - aVar.bHj;
                    f = Math.abs(f2);
                    f3 = aVar.bHj;
                    f = (aVar.bHj == 0.0f || aVar.bHi <= 20 || f <= 1.25f) ? 1.0f : 1.25f / f;
                    aVar.bHj = (f * (f2 / ((float) aVar.bHi))) + f3;
                    aVar.bHk = Math.abs(aVar.bHv - aVar.bHj) >= 1.25f;
                    if (aVar.bHk) {
                        if (aVar.bHl < 1200) {
                            aVar.bHl++;
                        }
                    } else if (aVar.bHl > 0) {
                        aVar.bHl--;
                    }
                    aVar.bHg = 0;
                    aVar.bHh = 0.0f;
                    if (aVar.bHv < aVar.bHx) {
                        aVar.bHx = aVar.bHv;
                    }
                    if (aVar.bHv > aVar.bHw) {
                        aVar.bHw = aVar.bHv;
                    }
                    if (aVar.bHi == 20 && Math.max(aVar.bHw - aVar.bHj, aVar.bHj - aVar.bHx) > 5.0f) {
                        aVar.reset();
                    }
                }
                if (aVar.bHi <= 20) {
                    fArr4 = aVar.bHs;
                    fArr3 = aVar.bHt;
                    aVar.bHu[i2] = 1.0f;
                    fArr3[i2] = 1.0f;
                    fArr4[i2] = 1.0f;
                    fArr4 = aVar.bHp;
                    fArr3 = aVar.bHq;
                    aVar.bHr[i2] = 0.0f;
                    fArr3[i2] = 0.0f;
                    fArr4[i2] = 0.0f;
                } else if (aVar.bHk || aVar.bHy || obj != null) {
                    fArr4 = aVar.bHp;
                    fArr3 = aVar.bHq;
                    aVar.bHr[i2] = 1.0f;
                    fArr3[i2] = 1.0f;
                    fArr4[i2] = 1.0f;
                    fArr4 = aVar.bHs;
                    fArr3 = aVar.bHt;
                    aVar.bHu[i2] = 0.0f;
                    fArr3[i2] = 0.0f;
                    fArr4[i2] = 0.0f;
                } else {
                    if (aVar.bHl > 0) {
                        aVar.bHm[i2] = fArr7[0];
                        aVar.bHn[i2] = fArr7[1];
                        aVar.bHo[i2] = fArr7[2];
                    }
                    f = Math.abs(fArr7[0] - fArr5[0]);
                    if (f > 3.1415927f) {
                        f = 6.2831855f - f;
                    }
                    abs = Math.abs(aVar.bHm[i2] - fArr6[0]);
                    if (abs > 3.1415927f) {
                        abs = 6.2831855f - abs;
                    }
                    f2 = Math.max(abs, f);
                    f = f2 != 0.0f ? (((abs - f) / f2) + 1.0f) * 0.5f : 1.0f;
                    fArr3 = aVar.bHp;
                    fArr3[i2] = (f + fArr3[i2]) / 2.0f;
                    aVar.bHs[i2] = 1.0f - aVar.bHp[i2];
                    f = Math.abs(fArr7[1] - fArr5[1]);
                    if (f > 3.1415927f) {
                        f = 6.2831855f - f;
                    }
                    abs = Math.abs(aVar.bHn[i2] - fArr6[1]);
                    if (abs > 3.1415927f) {
                        abs = 6.2831855f - abs;
                    }
                    f2 = Math.max(abs, f);
                    f = f2 != 0.0f ? (((abs - f) / f2) + 1.0f) * 0.5f : 1.0f;
                    fArr3 = aVar.bHq;
                    fArr3[i2] = (f + fArr3[i2]) / 2.0f;
                    aVar.bHt[i2] = 1.0f - aVar.bHq[i2];
                    f = Math.abs(fArr7[2] - fArr5[2]);
                    if (f > 3.1415927f) {
                        f = 6.2831855f - f;
                    }
                    abs = Math.abs(aVar.bHo[i2] - fArr6[2]);
                    if (abs > 3.1415927f) {
                        abs = 6.2831855f - abs;
                    }
                    float max = Math.max(abs, f);
                    f = max != 0.0f ? (((abs - f) / max) + 1.0f) * 0.5f : 1.0f;
                    fArr3 = aVar.bHr;
                    fArr3[i2] = (f + fArr3[i2]) / 2.0f;
                    aVar.bHu[i2] = 1.0f - aVar.bHr[i2];
                }
                aVar.bHm[i2] = fArr6[0];
                aVar.bHn[i2] = fArr6[1];
                aVar.bHo[i2] = fArr6[2];
                f = uVar.bGM[i2][0] - uVar.bGN[i2][0];
                if (f < -3.1415927f) {
                    f += 6.2831855f;
                } else if (f > 3.1415927f) {
                    f -= 6.2831855f;
                }
                f = (f * uVar.bHf.bHs[i2]) + uVar.bGN[i2][0];
                if (f < -3.1415927f) {
                    f += 6.2831855f;
                } else if (f > 3.1415927f) {
                    f -= 6.2831855f;
                }
                uVar.bGO[i2][0] = f;
                f = uVar.bGM[i2][1] - uVar.bGN[i2][1];
                if (f < -3.1415927f) {
                    f += 6.2831855f;
                } else if (f > 3.1415927f) {
                    f -= 6.2831855f;
                }
                f = (f * uVar.bHf.bHt[i2]) + uVar.bGN[i2][1];
                if (f < -3.1415927f) {
                    f += 6.2831855f;
                } else if (f > 3.1415927f) {
                    f -= 6.2831855f;
                }
                uVar.bGO[i2][1] = f;
                f = uVar.bGM[i2][2] - uVar.bGN[i2][2];
                if (f < -3.1415927f) {
                    f += 6.2831855f;
                } else if (f > 3.1415927f) {
                    f -= 6.2831855f;
                }
                f = (f * uVar.bHf.bHu[i2]) + uVar.bGN[i2][2];
                if (f < -3.1415927f) {
                    f += 6.2831855f;
                } else if (f > 3.1415927f) {
                    f -= 6.2831855f;
                }
                uVar.bGO[i2][2] = f;
                fArr = uVar.bGK;
                fArr3 = uVar.bGO[i2];
                fArr2 = new float[9];
                fArr5 = new float[9];
                fArr6 = new float[9];
                float sin = (float) Math.sin((double) fArr3[1]);
                f2 = (float) Math.cos((double) fArr3[1]);
                f3 = (float) Math.sin((double) fArr3[2]);
                float cos = (float) Math.cos((double) fArr3[2]);
                float sin2 = (float) Math.sin((double) fArr3[0]);
                abs = (float) Math.cos((double) fArr3[0]);
                fArr2[0] = 1.0f;
                fArr2[1] = 0.0f;
                fArr2[2] = 0.0f;
                fArr2[3] = 0.0f;
                fArr2[4] = f2;
                fArr2[5] = sin;
                fArr2[6] = 0.0f;
                fArr2[7] = -sin;
                fArr2[8] = f2;
                fArr5[0] = cos;
                fArr5[1] = 0.0f;
                fArr5[2] = f3;
                fArr5[3] = 0.0f;
                fArr5[4] = 1.0f;
                fArr5[5] = 0.0f;
                fArr5[6] = -f3;
                fArr5[7] = 0.0f;
                fArr5[8] = cos;
                fArr6[0] = abs;
                fArr6[1] = sin2;
                fArr6[2] = 0.0f;
                fArr6[3] = -sin2;
                fArr6[4] = abs;
                fArr6[5] = 0.0f;
                fArr6[6] = 0.0f;
                fArr6[7] = 0.0f;
                fArr6[8] = 1.0f;
                fArr[i2] = b(fArr6, b(fArr2, fArr5));
                System.arraycopy(uVar.bGO[i2], 0, uVar.bGN[i2], 0, 3);
                i = i2 + 1;
            }
        }
        d dVar = uVar.bHd;
        if (uVar.bGG != null) {
            fArr = uVar.bGP;
        } else {
            fArr = uVar.bGO;
        }
        b a = dVar.a(fArr);
        if (a != null) {
            uVar.bHe.a(a);
        }
        AppMethodBeat.o(55651);
    }

    static /* synthetic */ void b(u uVar) {
        AppMethodBeat.i(55652);
        a wA = uVar.bHe.wA();
        if (wA != null) {
            uVar.c(new e(wA.x, wA.y, wA.bIm, wA.bIn, wA.bIo, wA.bIp, (byte) 0));
        }
        AppMethodBeat.o(55652);
    }
}
