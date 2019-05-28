package com.p081b.p082a.p083a;

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
import com.p081b.p082a.p083a.C8482d.C8483a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.b.a.a.u */
final class C25394u extends C8482d implements SensorEventListener {
    private static final int bGB;
    private static final int bGC;
    private static C25394u bGU;
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
    private C25397c bGW;
    private boolean[] bGX = new boolean[6];
    private int[] bGY = new int[6];
    private float[] bGZ = new float[6];
    private float[] bHa = new float[6];
    private float[] bHb = new float[]{Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN};
    private float[][] bHc = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 20}));
    private final C25398d bHd = new C25398d();
    private final C8506f bHe = new C8506f(this, (byte) 0);
    private final C25395a bHf = new C25395a();

    /* renamed from: com.b.a.a.u$e */
    static class C0738e extends C31914p {
        final float bHZ;
        final float bIa;
        final int bIb;
        final float speed;
        /* renamed from: x */
        final float f1027x;
        /* renamed from: y */
        final float f1028y;

        /* synthetic */ C0738e(float f, float f2, int i, float f3, float f4, float f5, byte b) {
            this(f, f2, i, f3, f4, f5);
        }

        private C0738e(float f, float f2, int i, float f3, float f4, float f5) {
            super(301);
            this.f1027x = f;
            this.f1028y = f2;
            this.bIb = i;
            this.bHZ = f3;
            this.bIa = f4;
            this.speed = f5;
        }
    }

    /* renamed from: com.b.a.a.u$f */
    class C8506f {
        private ArrayList<C25396b> bIc;
        private C8507a[] bId;
        private int bIe;
        private float[][] bIf;
        private float[][] bIg;
        private float[][] bIh;
        private int[] bIi;
        private int bIj;
        private int bIk;
        private int bIl;

        /* renamed from: com.b.a.a.u$f$a */
        class C8507a {
            int bIm;
            float bIn;
            float bIo;
            float bIp;
            long bIq;
            /* renamed from: x */
            float f2423x;
            /* renamed from: y */
            float f2424y;
            /* renamed from: z */
            float f2425z;

            /* Access modifiers changed, original: protected|final|synthetic */
            public final /* synthetic */ Object clone() {
                AppMethodBeat.m2504i(55633);
                C8507a wB = mo18598wB();
                AppMethodBeat.m2505o(55633);
                return wB;
            }

            private C8507a() {
                this.f2423x = 0.0f;
                this.f2424y = 0.0f;
                this.f2425z = 0.0f;
                this.bIm = 0;
                this.bIn = 0.0f;
                this.bIo = 0.0f;
                this.bIp = 0.0f;
                this.bIq = 0;
            }

            /* synthetic */ C8507a(C8506f c8506f, byte b) {
                this();
            }

            /* Access modifiers changed, original: protected|final */
            /* renamed from: wB */
            public final C8507a mo18598wB() {
                AppMethodBeat.m2504i(55632);
                C8507a c8507a = new C8507a();
                c8507a.f2423x = this.f2423x;
                c8507a.f2424y = this.f2424y;
                c8507a.f2425z = this.f2425z;
                c8507a.bIm = this.bIm;
                c8507a.bIn = this.bIn;
                c8507a.bIo = this.bIo;
                c8507a.bIq = this.bIq;
                c8507a.bIp = this.bIp;
                AppMethodBeat.m2505o(55632);
                return c8507a;
            }
        }

        private C8506f() {
            AppMethodBeat.m2504i(55634);
            this.bIc = new ArrayList();
            this.bId = new C8507a[5];
            this.bIe = 0;
            this.bIf = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
            this.bIg = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
            this.bIh = (float[][]) Array.newInstance(Float.TYPE, new int[]{3, 3});
            this.bIi = new int[6];
            this.bIj = 5;
            this.bIk = -1;
            this.bIl = 0;
            AppMethodBeat.m2505o(55634);
        }

        /* synthetic */ C8506f(C25394u c25394u, byte b) {
            this();
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized void reset() {
            AppMethodBeat.m2504i(55635);
            this.bIc.clear();
            this.bId = new C8507a[5];
            this.bIe = 0;
            this.bIf = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
            this.bIg = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
            this.bIh = (float[][]) Array.newInstance(Float.TYPE, new int[]{3, 3});
            this.bIi = new int[6];
            this.bIj = 5;
            AppMethodBeat.m2505o(55635);
        }

        /* renamed from: wy */
        private synchronized boolean m15110wy() {
            boolean z;
            AppMethodBeat.m2504i(55636);
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
                m15109a(m15111wz());
                this.bIe = 0;
                this.bIf = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
                this.bIg = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
                if (this.bIc.size() >= 100) {
                    this.bIc.subList(0, 20).clear();
                    this.bIc.trimToSize();
                }
                z = true;
                AppMethodBeat.m2505o(55636);
            } else {
                z = false;
                AppMethodBeat.m2505o(55636);
            }
            return z;
        }

        /* renamed from: wz */
        private synchronized C8507a m15111wz() {
            C8507a c8507a;
            Object obj;
            float abs;
            float abs2;
            float abs3;
            float f;
            int i;
            int i2;
            AppMethodBeat.m2504i(55637);
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
            c8507a = new C8507a(this, (byte) 0);
            c8507a = new C8507a(this, (byte) 0);
            if (this.bId[0] != null) {
                c8507a.bIq = this.bId[0].bIq;
                c8507a.bIn = this.bId[0].bIn;
            }
            if (this.bId[4] != null) {
                c8507a.bIq = this.bId[4].bIq;
                c8507a.bIn = this.bId[4].bIn;
            }
            if (!this.bIc.isEmpty()) {
                C25396b c25396b;
                i2 = this.bIc.size();
                float[] fArr = new float[6];
                float[] fArr2 = new float[6];
                Iterator it = this.bIc.iterator();
                abs3 = 0.0f;
                float f2 = 0.0f;
                while (it.hasNext()) {
                    c25396b = (C25396b) it.next();
                    if (obj == null) {
                        abs2 = c25396b.bHB;
                    } else {
                        abs2 = c25396b.bHE;
                    }
                    f2 += abs2;
                    if (obj == null) {
                        abs2 = c25396b.bHJ;
                    } else {
                        abs2 = (float) Math.sqrt((double) (((c25396b.bHC * c25396b.bHC) + (c25396b.bHD * c25396b.bHD)) + (c25396b.bHE * c25396b.bHE)));
                        c25396b.bHI = abs2;
                    }
                    abs3 += abs2;
                    for (i = 0; i <= 5; i++) {
                        fArr[i] = fArr[i] + c25396b.bHN[i];
                        fArr2[i] = fArr2[i] + c25396b.bHO[i];
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
                    c25396b = (C25396b) it2.next();
                    if (obj == null) {
                        f11 = c25396b.bHB;
                    } else {
                        f11 = c25396b.bHI;
                    }
                    if (obj == null) {
                        abs3 = c25396b.bHJ;
                    } else {
                        abs3 = c25396b.bHI;
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
                                if (c8507a.bIq != 0 && c25396b.time - c8507a.bIq < 250) {
                                    obj4 = null;
                                }
                                if (obj4 != null && f - f4 < 0.3f) {
                                    obj4 = null;
                                }
                                if (obj4 != null) {
                                    c8507a.bIm++;
                                    abs2 += f6;
                                    f2 = (float) Math.atan2((double) (c25396b.bHN[this.bIj] + f10), (double) (c25396b.bHO[this.bIj] + f9));
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
                                    c8507a.f2423x += f7;
                                    c8507a.f2424y += abs3;
                                    if (c25396b.time - c8507a.bIq > 250) {
                                        c8507a.f2423x -= f7;
                                        c8507a.f2424y -= abs3;
                                        c8507a.bIm++;
                                    }
                                }
                                c8507a.bIq = c25396b.time;
                            }
                            abs3 = c25396b.bHN[this.bIj];
                            f7 = f13;
                            f2 = f;
                            f9 = c25396b.bHO[this.bIj];
                            f10 = abs3;
                            i6 = 0;
                        }
                    } else if (f11 <= f12) {
                        abs3 = c25396b.bHN[this.bIj];
                        f9 = c25396b.bHO[this.bIj];
                        f10 = abs3;
                    } else if (f11 - f12 >= f7) {
                        f2 = abs3;
                        f6 = f11;
                        i6 = 1;
                    }
                }
                if (c8507a.bIm > 0) {
                    if (obj == null) {
                        abs = 0.0f;
                    } else {
                        abs = 0.08f;
                    }
                    abs2 /= (float) c8507a.bIm;
                    abs3 = c8507a.bIn;
                    abs += ((abs2 - f5) / 15.0f) + 0.537f;
                    if (abs3 != 0.0f) {
                        abs = (abs * 0.67f) + (0.33f * abs3);
                    }
                    c8507a.bIn = abs;
                    c8507a.f2423x *= c8507a.bIn;
                    c8507a.f2424y *= c8507a.bIn;
                    c8507a.bIo = ((float) c8507a.bIm) * c8507a.bIn;
                }
            }
            c8507a.bIp = c8507a.bIo / ((float) (this.bIc.size() / 20));
            if (this.bId[0] != null) {
                c8507a.f2423x += this.bId[0].f2423x;
                c8507a.f2424y += this.bId[0].f2424y;
                c8507a.f2425z += this.bId[0].f2425z;
                c8507a.bIm += this.bId[0].bIm;
                c8507a.bIo += this.bId[0].bIo;
            }
            if (this.bId[4] != null && c8507a.bIm > 0) {
                this.bId[4].f2423x = ((this.bId[4].f2423x + c8507a.f2423x) + (c8507a.f2423x * c8507a.bIn)) / 2.0f;
                this.bId[4].f2424y = ((this.bId[4].f2424y + c8507a.f2424y) + (c8507a.f2424y * c8507a.bIn)) / 2.0f;
            }
            AppMethodBeat.m2505o(55637);
            return c8507a;
        }

        /* renamed from: a */
        private synchronized void m15109a(C8507a c8507a) {
            AppMethodBeat.m2504i(55638);
            System.arraycopy(this.bId, 1, this.bId, 0, 4);
            if (this.bId[4] == null || SystemClock.elapsedRealtime() - c8507a.bIq <= 1000) {
                this.bId[4] = c8507a;
                AppMethodBeat.m2505o(55638);
            } else {
                C8507a c8507a2 = this.bId[4];
                c8507a2.f2423x = (c8507a2.f2423x + c8507a.f2423x) / 2.0f;
                c8507a2.f2424y = (c8507a2.f2424y + c8507a.f2424y) / 2.0f;
                c8507a2.f2425z = (c8507a2.f2425z + c8507a.f2425z) / 2.0f;
                c8507a2.bIm = Math.round(((float) (c8507a2.bIm + c8507a.bIm)) / 2.0f);
                c8507a2.bIn = (c8507a2.bIn + c8507a.bIn) / 2.0f;
                c8507a2.bIo = (c8507a2.bIo + c8507a.bIo) / 2.0f;
                c8507a2.bIq = c8507a.bIq;
                c8507a2.bIp = c8507a.bIp;
                AppMethodBeat.m2505o(55638);
            }
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        /* renamed from: a */
        public final synchronized void mo18594a(C25396b c25396b) {
            AppMethodBeat.m2504i(55639);
            if (this.bIl > 0 && this.bIl < 101) {
                this.bIl--;
            }
            this.bIc.add(c25396b);
            this.bIe++;
            if (c25396b.bHC > this.bIf[0][0]) {
                this.bIf[0][0] = c25396b.bHC;
            }
            if (c25396b.bHC < this.bIf[0][1]) {
                this.bIf[0][1] = c25396b.bHC;
            }
            float[] fArr = this.bIf[0];
            fArr[2] = fArr[2] + c25396b.bHC;
            if (c25396b.bHD > this.bIf[1][0]) {
                this.bIf[1][0] = c25396b.bHD;
            }
            if (c25396b.bHD < this.bIf[1][1]) {
                this.bIf[1][1] = c25396b.bHD;
            }
            fArr = this.bIf[1];
            fArr[2] = fArr[2] + c25396b.bHD;
            if (c25396b.bHE > this.bIf[2][0]) {
                this.bIf[2][0] = c25396b.bHE;
            }
            if (c25396b.bHE < this.bIf[2][1]) {
                this.bIf[2][1] = c25396b.bHE;
            }
            fArr = this.bIf[2];
            fArr[2] = fArr[2] + c25396b.bHE;
            if (c25396b.bHF > this.bIg[0][0]) {
                this.bIg[0][0] = c25396b.bHF;
            }
            if (c25396b.bHF < this.bIg[0][1]) {
                this.bIg[0][1] = c25396b.bHF;
            }
            fArr = this.bIg[0];
            fArr[2] = fArr[2] + c25396b.bHF;
            if (c25396b.bHG > this.bIg[1][0]) {
                this.bIg[1][0] = c25396b.bHG;
            }
            if (c25396b.bHG < this.bIg[1][1]) {
                this.bIg[1][1] = c25396b.bHG;
            }
            fArr = this.bIg[1];
            fArr[2] = fArr[2] + c25396b.bHG;
            if (c25396b.bHH > this.bIg[2][0]) {
                this.bIg[2][0] = c25396b.bHH;
            }
            if (c25396b.bHH < this.bIg[2][1]) {
                this.bIg[2][1] = c25396b.bHH;
            }
            fArr = this.bIg[2];
            fArr[2] = fArr[2] + c25396b.bHH;
            if (m15110wy()) {
                C25394u.m40116b(C25394u.this);
            }
            AppMethodBeat.m2505o(55639);
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        /* renamed from: wA */
        public final synchronized C8507a mo18596wA() {
            C8507a wB;
            AppMethodBeat.m2504i(55640);
            if (this.bId[4] != null) {
                wB = this.bId[4].mo18598wB();
                AppMethodBeat.m2505o(55640);
            } else {
                wB = null;
                AppMethodBeat.m2505o(55640);
            }
            return wB;
        }
    }

    /* renamed from: com.b.a.a.u$a */
    static class C25395a {
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

        private C25395a() {
            AppMethodBeat.m2504i(55628);
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
            AppMethodBeat.m2505o(55628);
        }

        /* synthetic */ C25395a(byte b) {
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

    /* renamed from: com.b.a.a.u$b */
    static class C25396b {
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

        private C25396b() {
            AppMethodBeat.m2504i(55629);
            this.bHK = new float[6];
            this.bHL = new float[6];
            this.bHM = new float[6];
            this.bHN = new float[6];
            this.bHO = new float[6];
            AppMethodBeat.m2505o(55629);
        }

        /* synthetic */ C25396b(byte b) {
            this();
        }
    }

    /* renamed from: com.b.a.a.u$c */
    class C25397c extends C25393e {
        C25397c(Handler handler) {
            super(handler);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: vZ */
        public final void mo42422vZ() {
            AppMethodBeat.m2504i(55630);
            C25394u.m40112a(C25394u.this);
            AppMethodBeat.m2505o(55630);
        }
    }

    /* renamed from: com.b.a.a.u$d */
    static class C25398d {
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

        private C25398d() {
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

        /* synthetic */ C25398d(byte b) {
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
        /* renamed from: a */
        public final synchronized void mo42427a(float[] fArr, float[] fArr2, float[] fArr3) {
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
        /* renamed from: a */
        public final synchronized C25396b mo42426a(float[][] fArr) {
            C25396b c25396b;
            synchronized (this) {
                AppMethodBeat.m2504i(55631);
                if (this.count <= 0 || fArr.length < 3) {
                    c25396b = null;
                    AppMethodBeat.m2505o(55631);
                } else {
                    c25396b = new C25396b();
                    c25396b.time = SystemClock.elapsedRealtime();
                    for (int i = 0; i <= 5; i++) {
                        c25396b.bHK[i] = fArr[i][0];
                        c25396b.bHL[i] = fArr[i][1];
                        c25396b.bHM[i] = fArr[i][2];
                        c25396b.bHN[i] = (float) Math.sin((double) c25396b.bHK[i]);
                        c25396b.bHO[i] = (float) Math.cos((double) c25396b.bHK[i]);
                    }
                    c25396b.bHz = this.bHQ / ((float) this.count);
                    c25396b.bHA = this.bHR / ((float) this.count);
                    c25396b.bHB = this.bHS / ((float) this.count);
                    c25396b.bHC = this.bHT / ((float) this.count);
                    c25396b.bHD = this.bHU / ((float) this.count);
                    c25396b.bHE = this.bHV / ((float) this.count);
                    c25396b.bHF = this.bHW / ((float) this.count);
                    c25396b.bHG = this.bHX / ((float) this.count);
                    c25396b.bHH = this.bHY / ((float) this.count);
                    c25396b.bHJ = (float) Math.sqrt((double) ((c25396b.bHz * c25396b.bHz) + (c25396b.bHA * c25396b.bHA)));
                    reset();
                    AppMethodBeat.m2505o(55631);
                }
            }
            return c25396b;
        }
    }

    static {
        AppMethodBeat.m2504i(55641);
        int round = Math.round(50000.0f);
        bGB = round;
        bGC = round;
        AppMethodBeat.m2505o(55641);
    }

    /* renamed from: wx */
    static C25394u m40118wx() {
        AppMethodBeat.m2504i(55642);
        if (bGU == null) {
            bGU = new C25394u();
        }
        C25394u c25394u = bGU;
        AppMethodBeat.m2505o(55642);
        return c25394u;
    }

    private C25394u() {
        AppMethodBeat.m2504i(55643);
        AppMethodBeat.m2505o(55643);
    }

    /* renamed from: a */
    private static void m40114a(float[][] fArr, float[][] fArr2) {
        AppMethodBeat.m2504i(55644);
        for (int i = 0; i <= 5; i++) {
            SensorManager.getOrientation(fArr[i], fArr2[i]);
        }
        AppMethodBeat.m2505o(55644);
    }

    /* renamed from: b */
    private static float[] m40117b(float[] fArr, float[] fArr2) {
        return new float[]{((fArr[0] * fArr2[0]) + (fArr[1] * fArr2[3])) + (fArr[2] * fArr2[6]), ((fArr[0] * fArr2[1]) + (fArr[1] * fArr2[4])) + (fArr[2] * fArr2[7]), ((fArr[0] * fArr2[2]) + (fArr[1] * fArr2[5])) + (fArr[2] * fArr2[8]), ((fArr[3] * fArr2[0]) + (fArr[4] * fArr2[3])) + (fArr[5] * fArr2[6]), ((fArr[3] * fArr2[1]) + (fArr[4] * fArr2[4])) + (fArr[5] * fArr2[7]), ((fArr[3] * fArr2[2]) + (fArr[4] * fArr2[5])) + (fArr[5] * fArr2[8]), ((fArr[6] * fArr2[0]) + (fArr[7] * fArr2[3])) + (fArr[8] * fArr2[6]), ((fArr[6] * fArr2[1]) + (fArr[7] * fArr2[4])) + (fArr[8] * fArr2[7]), ((fArr[6] * fArr2[2]) + (fArr[7] * fArr2[5])) + (fArr[8] * fArr2[8])};
    }

    /* Access modifiers changed, original: final */
    /* renamed from: at */
    public final void mo18560at(Context context) {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: vV */
    public final void mo18564vV() {
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* renamed from: a */
    public final synchronized void mo18559a(Handler handler, C8483a c8483a) {
        AppMethodBeat.m2504i(55647);
        super.mo18559a(handler, c8483a);
        AppMethodBeat.m2505o(55647);
    }

    @TargetApi(19)
    /* renamed from: a */
    private static boolean m40115a(SensorManager sensorManager, SensorEventListener sensorEventListener, int i, int i2, Handler handler, Sensor... sensorArr) {
        AppMethodBeat.m2504i(55648);
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
                    AppMethodBeat.m2505o(55648);
                    return false;
                }
            }
            AppMethodBeat.m2505o(55648);
            return true;
        } catch (Error e) {
            AppMethodBeat.m2505o(55648);
            return false;
        } catch (Exception e2) {
            AppMethodBeat.m2505o(55648);
            return false;
        }
    }

    /* renamed from: a */
    private static void m40113a(float[] fArr, float[][] fArr2) {
        AppMethodBeat.m2504i(55649);
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
        AppMethodBeat.m2505o(55649);
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        int i = 0;
        AppMethodBeat.m2504i(55650);
        float[] fArr;
        int i2;
        float[][] fArr2;
        float[][] fArr3;
        float[][] fArr4;
        switch (sensorEvent.sensor.getType()) {
            case 2:
                C25394u.m40113a(sensorEvent.values, this.bGS);
                C25395a c25395a = this.bHf;
                fArr = sensorEvent.values;
                if (fArr.length >= 3) {
                    c25395a.bHg++;
                    c25395a.bHh = (float) (Math.sqrt((double) (((fArr[0] * fArr[0]) + (fArr[1] * fArr[1])) + (fArr[2] * fArr[2]))) + ((double) c25395a.bHh));
                    break;
                }
                break;
            case 4:
                if (!(this.bGM[2][0] == 0.0f && this.bGM[2][1] == 0.0f && this.bGM[2][2] == 0.0f)) {
                    if (this.bGI) {
                        for (i2 = 0; i2 <= 5; i2++) {
                            fArr = this.bGJ[i2];
                            fArr2 = this.bGK;
                            fArr2[i2] = C25394u.m40117b(fArr2[i2], fArr);
                        }
                        this.bGI = false;
                    }
                    fArr3 = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 4});
                    if (this.bGH != 0) {
                        float f = 1.0E-9f * ((float) (sensorEvent.timestamp - this.bGH));
                        C25394u.m40113a(sensorEvent.values, this.bGR);
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
                        fArr4[i] = C25394u.m40117b(fArr4[i], fArr);
                        i++;
                    }
                    C25394u.m40114a(this.bGK, this.bGN);
                }
                AppMethodBeat.m2505o(55650);
                return;
            case 9:
                C25394u.m40113a(sensorEvent.values, this.bGT);
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
                        C25394u.m40114a(this.bGJ, this.bGM);
                        if (this.bGN[2][0] == 0.0f && this.bGN[2][1] == 0.0f && this.bGN[2][2] == 0.0f) {
                            fArr8 = this.bGM;
                            fArr4 = this.bGN;
                            for (i2 = 0; i2 <= 5; i2++) {
                                System.arraycopy(fArr8[i2], 0, fArr4[i2], 0, 3);
                            }
                        }
                    }
                    AppMethodBeat.m2505o(55650);
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
                this.bHd.mo42427a(this.bGQ, sensorEvent.values, this.bGT[2]);
                AppMethodBeat.m2505o(55650);
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
                AppMethodBeat.m2505o(55650);
                return;
        }
        AppMethodBeat.m2505o(55650);
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0078 A:{Catch:{ Exception -> 0x0018 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo18557a(Context context, Handler handler, C8483a c8483a) {
        AppMethodBeat.m2504i(55645);
        if (context == null) {
            try {
                Exception exception = new Exception("SensorModule: register with null context");
                AppMethodBeat.m2505o(55645);
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
                    a = C25394u.m40115a(this.bCW, this, bGB, bGC, handler, this.accelerometer, this.bGF, this.bGG);
                } else {
                    this.bGD = this.bCW.getDefaultSensor(4);
                    this.bGE = this.bCW.getDefaultSensor(2);
                    if (!(this.bGD == null || this.bGE == null)) {
                        a = C25394u.m40115a(this.bCW, this, bGB, bGC, handler, this.accelerometer, this.bGF, this.bGD, this.bGE);
                    }
                }
                if (a) {
                    this.bGV = true;
                    this.bGW = new C25397c(handler);
                    if (this.bGW != null) {
                        this.bGW.mo42420n((long) Math.round(50.0f), 1000);
                    }
                    AppMethodBeat.m2505o(55645);
                    return;
                }
                AppMethodBeat.m2505o(55645);
            }
            a = false;
            if (a) {
            }
            AppMethodBeat.m2505o(55645);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: au */
    public final void mo18561au(Context context) {
        AppMethodBeat.m2504i(55646);
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
        AppMethodBeat.m2505o(55646);
    }

    /* renamed from: a */
    static /* synthetic */ void m40112a(C25394u c25394u) {
        float[][] fArr;
        AppMethodBeat.m2504i(55651);
        if (c25394u.accelerometer != null && c25394u.bGD != null && c25394u.bGE != null && c25394u.bGF != null) {
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
                if (Float.isNaN(c25394u.bHb[i2])) {
                    c25394u.bHb[i2] = c25394u.bGN[i2][0];
                } else {
                    f = c25394u.bGN[i2][0] - c25394u.bGO[i2][0];
                    if (f < -3.1415927f) {
                        f += 6.2831855f;
                    } else if (f > 3.1415927f) {
                        f -= 6.2831855f;
                    }
                    fArr2 = c25394u.bHc[i2];
                    int[] iArr = c25394u.bGY;
                    int i3 = iArr[i2];
                    iArr[i2] = i3 + 1;
                    fArr2[i3] = f;
                    if (c25394u.bGY[i2] == 20) {
                        c25394u.bGY[i2] = 0;
                        if (!c25394u.bGX[i2]) {
                            c25394u.bGX[i2] = true;
                        }
                    }
                    fArr2 = c25394u.bHa;
                    fArr2[i2] = fArr2[i2] + f;
                    fArr2 = c25394u.bGZ;
                    fArr2[i2] = f + fArr2[i2];
                    if (c25394u.bGX[i2]) {
                        Object obj2;
                        if (Math.abs(c25394u.bGZ[i2]) < 0.08726647f) {
                            if (Math.abs(c25394u.bHa[i2]) < 0.08726647f) {
                                f = c25394u.bGN[i2][0] - c25394u.bHb[i2];
                                if (f < -3.1415927f) {
                                    f += 6.2831855f;
                                } else if (f > 3.1415927f) {
                                    f -= 6.2831855f;
                                }
                                c25394u.bGN[i2][0] = (f / 2.0f) + c25394u.bHb[i2];
                                if (c25394u.bGN[i2][0] < -3.1415927f) {
                                    c25394u.bGN[i2][0] = 6.2831855f + c25394u.bGN[i2][0];
                                } else if (c25394u.bGN[i2][0] > 3.1415927f) {
                                    c25394u.bGN[i2][0] = c25394u.bGN[i2][0] - 6.2831855f;
                                }
                                c25394u.bHb[i2] = c25394u.bGN[i2][0];
                                obj2 = 1;
                                fArr3 = c25394u.bGZ;
                                fArr3[i2] = fArr3[i2] - c25394u.bHc[i2][c25394u.bGY[i2]];
                                obj = obj2;
                            } else {
                                f = c25394u.bHa[i2] % 1.5707964f;
                                float abs2 = Math.abs(f);
                                if (abs2 < 0.08726647f) {
                                    fArr2 = c25394u.bHa;
                                    fArr2[i2] = fArr2[i2] - f;
                                    fArr4 = c25394u.bHb;
                                    fArr4[i2] = (fArr4[i2] + c25394u.bHa[i2]) % 6.2831855f;
                                    if (c25394u.bHb[i2] < -3.1415927f) {
                                        c25394u.bHb[i2] = 6.2831855f + c25394u.bHb[i2];
                                    } else if (c25394u.bHb[i2] > 3.1415927f) {
                                        fArr4 = c25394u.bHb;
                                        fArr4[i2] = fArr4[i2] - 6.2831855f;
                                    }
                                } else if (abs2 > 1.4835299f) {
                                    if (c25394u.bHa[i2] > 0.0f) {
                                        fArr2 = c25394u.bHa;
                                        fArr2[i2] = (fArr2[i2] - f) + 1.5707964f;
                                    } else {
                                        fArr2 = c25394u.bHa;
                                        fArr2[i2] = (fArr2[i2] - f) - 1.5707964f;
                                    }
                                    fArr4 = c25394u.bHb;
                                    fArr4[i2] = (fArr4[i2] + c25394u.bHa[i2]) % 6.2831855f;
                                    if (c25394u.bHb[i2] < -3.1415927f) {
                                        c25394u.bHb[i2] = 6.2831855f + c25394u.bHb[i2];
                                    } else if (c25394u.bHb[i2] > 3.1415927f) {
                                        fArr4 = c25394u.bHb;
                                        fArr4[i2] = fArr4[i2] - 6.2831855f;
                                    }
                                } else {
                                    c25394u.bHb[i2] = c25394u.bGN[i2][0];
                                }
                                c25394u.bHa[i2] = 0.0f;
                            }
                        }
                        obj2 = null;
                        fArr3 = c25394u.bGZ;
                        fArr3[i2] = fArr3[i2] - c25394u.bHc[i2][c25394u.bGY[i2]];
                        obj = obj2;
                    }
                }
                C25395a c25395a = c25394u.bHf;
                float[] fArr5 = c25394u.bGN[i2];
                float[] fArr6 = c25394u.bGM[i2];
                float[] fArr7 = c25394u.bGO[i2];
                if (i2 == 0 && c25395a.bHg != 0) {
                    c25395a.bHi++;
                    c25395a.bHv = c25395a.bHh / ((float) c25395a.bHg);
                    f2 = c25395a.bHv - c25395a.bHj;
                    f = Math.abs(f2);
                    f3 = c25395a.bHj;
                    f = (c25395a.bHj == 0.0f || c25395a.bHi <= 20 || f <= 1.25f) ? 1.0f : 1.25f / f;
                    c25395a.bHj = (f * (f2 / ((float) c25395a.bHi))) + f3;
                    c25395a.bHk = Math.abs(c25395a.bHv - c25395a.bHj) >= 1.25f;
                    if (c25395a.bHk) {
                        if (c25395a.bHl < 1200) {
                            c25395a.bHl++;
                        }
                    } else if (c25395a.bHl > 0) {
                        c25395a.bHl--;
                    }
                    c25395a.bHg = 0;
                    c25395a.bHh = 0.0f;
                    if (c25395a.bHv < c25395a.bHx) {
                        c25395a.bHx = c25395a.bHv;
                    }
                    if (c25395a.bHv > c25395a.bHw) {
                        c25395a.bHw = c25395a.bHv;
                    }
                    if (c25395a.bHi == 20 && Math.max(c25395a.bHw - c25395a.bHj, c25395a.bHj - c25395a.bHx) > 5.0f) {
                        c25395a.reset();
                    }
                }
                if (c25395a.bHi <= 20) {
                    fArr4 = c25395a.bHs;
                    fArr3 = c25395a.bHt;
                    c25395a.bHu[i2] = 1.0f;
                    fArr3[i2] = 1.0f;
                    fArr4[i2] = 1.0f;
                    fArr4 = c25395a.bHp;
                    fArr3 = c25395a.bHq;
                    c25395a.bHr[i2] = 0.0f;
                    fArr3[i2] = 0.0f;
                    fArr4[i2] = 0.0f;
                } else if (c25395a.bHk || c25395a.bHy || obj != null) {
                    fArr4 = c25395a.bHp;
                    fArr3 = c25395a.bHq;
                    c25395a.bHr[i2] = 1.0f;
                    fArr3[i2] = 1.0f;
                    fArr4[i2] = 1.0f;
                    fArr4 = c25395a.bHs;
                    fArr3 = c25395a.bHt;
                    c25395a.bHu[i2] = 0.0f;
                    fArr3[i2] = 0.0f;
                    fArr4[i2] = 0.0f;
                } else {
                    if (c25395a.bHl > 0) {
                        c25395a.bHm[i2] = fArr7[0];
                        c25395a.bHn[i2] = fArr7[1];
                        c25395a.bHo[i2] = fArr7[2];
                    }
                    f = Math.abs(fArr7[0] - fArr5[0]);
                    if (f > 3.1415927f) {
                        f = 6.2831855f - f;
                    }
                    abs = Math.abs(c25395a.bHm[i2] - fArr6[0]);
                    if (abs > 3.1415927f) {
                        abs = 6.2831855f - abs;
                    }
                    f2 = Math.max(abs, f);
                    f = f2 != 0.0f ? (((abs - f) / f2) + 1.0f) * 0.5f : 1.0f;
                    fArr3 = c25395a.bHp;
                    fArr3[i2] = (f + fArr3[i2]) / 2.0f;
                    c25395a.bHs[i2] = 1.0f - c25395a.bHp[i2];
                    f = Math.abs(fArr7[1] - fArr5[1]);
                    if (f > 3.1415927f) {
                        f = 6.2831855f - f;
                    }
                    abs = Math.abs(c25395a.bHn[i2] - fArr6[1]);
                    if (abs > 3.1415927f) {
                        abs = 6.2831855f - abs;
                    }
                    f2 = Math.max(abs, f);
                    f = f2 != 0.0f ? (((abs - f) / f2) + 1.0f) * 0.5f : 1.0f;
                    fArr3 = c25395a.bHq;
                    fArr3[i2] = (f + fArr3[i2]) / 2.0f;
                    c25395a.bHt[i2] = 1.0f - c25395a.bHq[i2];
                    f = Math.abs(fArr7[2] - fArr5[2]);
                    if (f > 3.1415927f) {
                        f = 6.2831855f - f;
                    }
                    abs = Math.abs(c25395a.bHo[i2] - fArr6[2]);
                    if (abs > 3.1415927f) {
                        abs = 6.2831855f - abs;
                    }
                    float max = Math.max(abs, f);
                    f = max != 0.0f ? (((abs - f) / max) + 1.0f) * 0.5f : 1.0f;
                    fArr3 = c25395a.bHr;
                    fArr3[i2] = (f + fArr3[i2]) / 2.0f;
                    c25395a.bHu[i2] = 1.0f - c25395a.bHr[i2];
                }
                c25395a.bHm[i2] = fArr6[0];
                c25395a.bHn[i2] = fArr6[1];
                c25395a.bHo[i2] = fArr6[2];
                f = c25394u.bGM[i2][0] - c25394u.bGN[i2][0];
                if (f < -3.1415927f) {
                    f += 6.2831855f;
                } else if (f > 3.1415927f) {
                    f -= 6.2831855f;
                }
                f = (f * c25394u.bHf.bHs[i2]) + c25394u.bGN[i2][0];
                if (f < -3.1415927f) {
                    f += 6.2831855f;
                } else if (f > 3.1415927f) {
                    f -= 6.2831855f;
                }
                c25394u.bGO[i2][0] = f;
                f = c25394u.bGM[i2][1] - c25394u.bGN[i2][1];
                if (f < -3.1415927f) {
                    f += 6.2831855f;
                } else if (f > 3.1415927f) {
                    f -= 6.2831855f;
                }
                f = (f * c25394u.bHf.bHt[i2]) + c25394u.bGN[i2][1];
                if (f < -3.1415927f) {
                    f += 6.2831855f;
                } else if (f > 3.1415927f) {
                    f -= 6.2831855f;
                }
                c25394u.bGO[i2][1] = f;
                f = c25394u.bGM[i2][2] - c25394u.bGN[i2][2];
                if (f < -3.1415927f) {
                    f += 6.2831855f;
                } else if (f > 3.1415927f) {
                    f -= 6.2831855f;
                }
                f = (f * c25394u.bHf.bHu[i2]) + c25394u.bGN[i2][2];
                if (f < -3.1415927f) {
                    f += 6.2831855f;
                } else if (f > 3.1415927f) {
                    f -= 6.2831855f;
                }
                c25394u.bGO[i2][2] = f;
                fArr = c25394u.bGK;
                fArr3 = c25394u.bGO[i2];
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
                fArr[i2] = C25394u.m40117b(fArr6, C25394u.m40117b(fArr2, fArr5));
                System.arraycopy(c25394u.bGO[i2], 0, c25394u.bGN[i2], 0, 3);
                i = i2 + 1;
            }
        }
        C25398d c25398d = c25394u.bHd;
        if (c25394u.bGG != null) {
            fArr = c25394u.bGP;
        } else {
            fArr = c25394u.bGO;
        }
        C25396b a = c25398d.mo42426a(fArr);
        if (a != null) {
            c25394u.bHe.mo18594a(a);
        }
        AppMethodBeat.m2505o(55651);
    }

    /* renamed from: b */
    static /* synthetic */ void m40116b(C25394u c25394u) {
        AppMethodBeat.m2504i(55652);
        C8507a wA = c25394u.bHe.mo18596wA();
        if (wA != null) {
            c25394u.mo18562c(new C0738e(wA.f2423x, wA.f2424y, wA.bIm, wA.bIn, wA.bIo, wA.bIp, (byte) 0));
        }
        AppMethodBeat.m2505o(55652);
    }
}
