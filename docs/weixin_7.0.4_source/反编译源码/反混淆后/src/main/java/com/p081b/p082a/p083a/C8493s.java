package com.p081b.p082a.p083a;

import android.location.Location;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

/* renamed from: com.b.a.a.s */
final class C8493s {
    private long bGc;
    float bGd;
    private ArrayList<String> bGe = new ArrayList();
    private ArrayList<float[]> bGf = new ArrayList();
    private ArrayList<double[]> bGg = new ArrayList();
    final C8482d bGh;
    Handler bGi;

    /* renamed from: com.b.a.a.s$a */
    class C8492a implements Runnable {
        final int bFn;
        final float bGj;
        final float bGk;
        final String bGl;
        /* renamed from: x */
        final float f2421x;
        /* renamed from: y */
        final float f2422y;

        private C8492a(float f, float f2, float f3, float f4, int i, String str) {
            this.f2421x = f;
            this.f2422y = f2;
            this.bGj = f3;
            this.bGk = f4;
            this.bFn = i;
            this.bGl = str;
        }

        /* synthetic */ C8492a(C8493s c8493s, float f, float f2, float f3, float f4, int i, String str, byte b) {
            this(f, f2, f3, f4, i, str);
        }

        public final void run() {
            AppMethodBeat.m2504i(55654);
            C8493s.this.mo18580a(this.f2421x, this.f2422y, this.bGj, this.bGk, this.bFn, this.bGl);
            AppMethodBeat.m2505o(55654);
        }
    }

    /* renamed from: com.b.a.a.s$b */
    class C8494b implements Runnable {
        final double bGn;
        final double bGo;
        final double bGp;
        final double bGq;
        final double bGr;
        final double bGs;
        final double lat;
        final double lng;

        private C8494b(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
            this.lat = d;
            this.lng = d2;
            this.bGn = d3;
            this.bGo = d4;
            this.bGp = d5;
            this.bGq = d6;
            this.bGr = d7;
            this.bGs = d8;
        }

        /* synthetic */ C8494b(C8493s c8493s, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, byte b) {
            this(d, d2, d3, d4, d5, d6, d7, d8);
        }

        public final void run() {
            AppMethodBeat.m2504i(55655);
            C8493s.this.mo18579a(this.lat, this.lng, this.bGn, this.bGo, this.bGp, this.bGq, this.bGr, this.bGs);
            AppMethodBeat.m2505o(55655);
        }
    }

    /* renamed from: com.b.a.a.s$c */
    class C8495c implements Runnable {
        private C8495c() {
        }

        /* synthetic */ C8495c(C8493s c8493s, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(55656);
            C8493s.this.mo18584wp();
            AppMethodBeat.m2505o(55656);
        }
    }

    /* renamed from: com.b.a.a.s$f */
    class C8496f implements Runnable {
        private C8496f() {
        }

        /* synthetic */ C8496f(C8493s c8493s, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(55658);
            C8493s.this.reset();
            AppMethodBeat.m2505o(55658);
        }
    }

    /* renamed from: com.b.a.a.s$d */
    class C8497d implements Runnable {
        private final C31914p bCK;

        private C8497d(C31914p c31914p) {
            this.bCK = c31914p;
        }

        /* synthetic */ C8497d(C8493s c8493s, C31914p c31914p, byte b) {
            this(c31914p);
        }

        public final void run() {
            AppMethodBeat.m2504i(55657);
            C8493s.this.bGh.mo18562c(this.bCK);
            AppMethodBeat.m2505o(55657);
        }
    }

    /* renamed from: com.b.a.a.s$e */
    static class C8498e extends C31914p {
        final int bGt;

        C8498e(int i) {
            super(8901);
            this.bGt = i;
        }
    }

    /* renamed from: com.b.a.a.s$g */
    static class C8499g extends C31914p {
        final boolean bGu;

        C8499g(boolean z) {
            super(8902);
            this.bGu = z;
        }
    }

    public C8493s(C8482d c8482d) {
        AppMethodBeat.m2504i(55659);
        this.bGh = c8482d;
        AppMethodBeat.m2505o(55659);
    }

    /* renamed from: d */
    private void m15093d(C31914p c31914p) {
        AppMethodBeat.m2504i(55660);
        if (this.bGi != null) {
            this.bGi.post(new C8497d(this, c31914p, (byte) 0));
        }
        AppMethodBeat.m2505o(55660);
    }

    private static void writeLog(String str) {
        AppMethodBeat.m2504i(55661);
        C31913o.m51802s("post_processing_log_" + C44978y.bIT, str);
        AppMethodBeat.m2505o(55661);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: wo */
    public final void mo18583wo() {
        AppMethodBeat.m2504i(55662);
        C37158z.m62269b(null).execute(new C8495c(this, (byte) 0));
        AppMethodBeat.m2505o(55662);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* renamed from: wp */
    public final synchronized void mo18584wp() {
        AppMethodBeat.m2504i(55663);
        try {
            m15092aY(true);
            AppMethodBeat.m2505o(55663);
        } catch (Exception e) {
            AppMethodBeat.m2505o(55663);
        }
        return;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: wq */
    public final void mo18585wq() {
        AppMethodBeat.m2504i(55664);
        this.bGc = 0;
        this.bGd = 0.0f;
        C37158z.m62269b(null).execute(new C8496f(this, (byte) 0));
        AppMethodBeat.m2505o(55664);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void reset() {
        AppMethodBeat.m2504i(55665);
        m15094wr();
        m15095ws();
        AppMethodBeat.m2505o(55665);
    }

    /* renamed from: wr */
    private synchronized void m15094wr() {
        AppMethodBeat.m2504i(55666);
        this.bGg.clear();
        AppMethodBeat.m2505o(55666);
    }

    /* renamed from: ws */
    private synchronized void m15095ws() {
        AppMethodBeat.m2504i(55667);
        this.bGe.clear();
        this.bGf.clear();
        AppMethodBeat.m2505o(55667);
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x026a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: aY */
    private synchronized void m15092aY(boolean z) {
        AppMethodBeat.m2504i(55668);
        if (!(this.bGf.isEmpty() || this.bGg.isEmpty())) {
            int size = z ? this.bGg.size() : this.bGg.size() - 1;
            int size2 = this.bGf.size();
            if (size > 1) {
                int i = 0;
                int i2 = 1;
                while (i2 < size) {
                    int i3;
                    double[] dArr = (double[]) this.bGg.get(i2 - 1);
                    double[] dArr2 = (double[]) this.bGg.get(i2);
                    float[] fArr = new float[1];
                    Location.distanceBetween(dArr[0], dArr[1], dArr[0], (dArr[1] <= 179.0d ? 1.0E-5d : -1.0E-5d) + dArr[1], fArr);
                    double d = (double) fArr[0];
                    Location.distanceBetween(dArr[0], dArr[1], (dArr[0] <= 89.0d ? 1.0E-5d : -1.0E-5d) + dArr[0], dArr[1], fArr);
                    double d2 = (double) fArr[0];
                    double d3 = dArr2[0] - dArr[0];
                    double d4 = dArr2[1] - dArr[1];
                    if (d4 > 180.0d) {
                        d4 -= 360.0d;
                    } else if (d4 < -180.0d) {
                        d4 += 360.0d;
                    }
                    d4 = (d4 / 1.0E-5d) * d;
                    d3 = (d3 / 1.0E-5d) * d2;
                    double d5 = dArr2[4] - dArr[4];
                    double d6 = dArr2[5] - dArr[5];
                    double sqrt = Math.sqrt(((d4 * d4) + (d3 * d3)) / ((d5 * d5) + (d6 * d6)));
                    if (sqrt < ((double) (1.0f / C44978y.bIW)) || sqrt > ((double) C44978y.bIW)) {
                        int i4 = i;
                        while (i4 < size2 && ((double) ((float[]) this.bGf.get(i4))[2]) <= dArr2[6]) {
                            i4++;
                        }
                        i3 = i4;
                    } else {
                        float f;
                        float f2;
                        int i5;
                        boolean z2;
                        d4 = Math.atan2(d3, d4) - Math.atan2(d6, d5);
                        d3 = Math.cos(d4);
                        double[] dArr3 = new double[]{d3, -Math.sin(d4), d5, d3};
                        if (sqrt < 1.0d) {
                            d4 = sqrt;
                        } else {
                            d4 = 1.0d / sqrt;
                        }
                        double d7 = d4 * 10.0d;
                        double abs = 1.0d + Math.abs(d5);
                        StringBuilder stringBuilder = new StringBuilder();
                        int i6 = 0;
                        float f3 = 0.0f;
                        float f4 = 0.0f;
                        Object obj = 1;
                        if (C44978y.bIM) {
                            C8493s.writeLog("ref_point," + dArr[0] + ',' + dArr[1] + ',' + dArr[2] + ',' + dArr[8]);
                            f = 0.0f;
                            f2 = 0.0f;
                            i5 = i;
                        } else {
                            f = 0.0f;
                            f2 = 0.0f;
                            i5 = i;
                        }
                        while (i5 < size2) {
                            float[] fArr2 = (float[]) this.bGf.get(i5);
                            if (((double) fArr2[2]) > dArr2[6]) {
                                break;
                            }
                            Object obj2;
                            fArr2[3] = Double.valueOf(Math.max(6.0d, Math.min((Math.abs((((double) fArr2[2]) - dArr[6]) / d7) * abs) + dArr[2], (Math.abs((((double) fArr2[2]) - dArr2[6]) / d7) * abs) + dArr2[2]))).floatValue();
                            double[] dArr4 = new double[]{((double) fArr2[0]) - dArr[4], ((double) fArr2[1]) - dArr[5]};
                            double[] dArr5 = new double[]{dArr4[0] * sqrt, dArr4[1] * sqrt};
                            dArr4 = new double[]{(dArr5[0] * dArr3[0]) + (dArr5[1] * dArr3[1]), (dArr5[0] * dArr3[2]) + (dArr5[1] * dArr3[3])};
                            dArr5 = new double[]{dArr4[0] + 0.0d, dArr4[1] + 0.0d};
                            double[] dArr6 = new double[]{((1.0E-5d * dArr5[1]) / d2) + dArr[0], ((1.0E-5d * dArr5[0]) / d) + dArr[1]};
                            if (dArr6[0] > 90.0d) {
                                dArr6[0] = 180.0d - dArr6[0];
                            } else if (dArr6[0] < -90.0d) {
                                dArr6[0] = -180.0d - dArr6[0];
                            }
                            if (dArr6[1] > 180.0d) {
                                dArr6[1] = dArr6[1] - 360.0d;
                            } else if (dArr6[1] < -180.0d) {
                                dArr6[1] = dArr6[1] + 360.0d;
                            }
                            if (C44978y.bIM) {
                                C8493s.writeLog("scan_point," + dArr6[0] + ',' + dArr6[1] + ',' + fArr2[3]);
                            }
                            String str = (String) this.bGe.get(i5);
                            int round = Math.round(fArr2[3]);
                            if (round > i6) {
                                i6 = round;
                            }
                            i = Math.round(fArr2[4]);
                            if (str != null) {
                                try {
                                    stringBuilder.append(str);
                                    double d8 = dArr6[0];
                                    double d9 = dArr6[1];
                                    str = "";
                                    if (C17508v.m27335e(d8, d9)) {
                                        str = "|MD," + d8 + ',' + d9 + ',' + round + ',' + i + ',' + str;
                                    } else {
                                        str = "";
                                    }
                                    stringBuilder.append(str);
                                } catch (Error e) {
                                }
                            }
                            if (obj != null) {
                                f3 = fArr2[5];
                                obj2 = null;
                                f4 = fArr2[2];
                            } else {
                                obj2 = obj;
                            }
                            f2 = fArr2[5];
                            obj = obj2;
                            f = fArr2[2];
                            i5++;
                        }
                        if (C44978y.bIM) {
                            C8493s.writeLog("ref_point," + dArr2[0] + ',' + dArr2[1] + ',' + dArr2[2] + ',' + dArr2[8]);
                        }
                        if (((float) i6) <= C44978y.bIU) {
                            float f5 = f2 - f3;
                            float f6 = f - f4;
                            if (f5 > 0.0f && (((double) f6) * sqrt) / ((double) f5) <= ((double) C44978y.bIV)) {
                                C37155r.m62256wg().mo59234bp(stringBuilder.toString());
                                z2 = true;
                                if (C44978y.bIM) {
                                    C8493s.writeLog(z2 ? "buffered" : "discarded");
                                }
                                m15093d(new C8499g(z2));
                                i3 = i5;
                            }
                        }
                        z2 = false;
                        if (C44978y.bIM) {
                        }
                        m15093d(new C8499g(z2));
                        i3 = i5;
                    }
                    i2++;
                    i = i3;
                }
                this.bGe.subList(0, i).clear();
                this.bGe.trimToSize();
                this.bGf.subList(0, i).clear();
                this.bGf.trimToSize();
                this.bGg.subList(0, size - 1).clear();
                this.bGg.trimToSize();
            }
        }
        AppMethodBeat.m2505o(55668);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* renamed from: a */
    public final synchronized void mo18580a(float f, float f2, float f3, float f4, int i, String str) {
        AppMethodBeat.m2504i(55669);
        this.bGe.add(str);
        this.bGf.add(new float[]{f, f2, f3, 0.0f, (float) i, f4});
        if (this.bGe.size() > 256) {
            this.bGe.subList(0, 1).clear();
            this.bGe.trimToSize();
            if (this.bGf.size() > 256) {
                this.bGf.subList(0, 1).clear();
                this.bGf.trimToSize();
            }
        }
        AppMethodBeat.m2505o(55669);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final boolean mo18581a(double d, double d2, double d3, float f, double d4, double d5, double d6, long j) {
        AppMethodBeat.m2504i(55670);
        if (f < C44978y.bIX) {
            AppMethodBeat.m2505o(55670);
            return false;
        } else if (j - this.bGc >= 1000 || f > this.bGd) {
            C37158z b = C37158z.m62269b(null);
            b.execute(new C8494b(this, d, d2, d3, (double) f, d4, d5, d6, (double) j, (byte) 0));
            this.bGc = j;
            this.bGd = f;
            AppMethodBeat.m2505o(55670);
            return true;
        } else {
            AppMethodBeat.m2505o(55670);
            return false;
        }
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* renamed from: a */
    public final synchronized void mo18579a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        Object obj;
        AppMethodBeat.m2504i(55671);
        int size = this.bGg.size();
        int size2 = this.bGe.size();
        if (size <= 0) {
            this.bGg.add(new double[]{d, d2, d3, d4, d5, d6, d7, (double) size2, d8});
            obj = 1;
        } else {
            Object obj2 = (double[]) this.bGg.get(size - 1);
            float[] fArr;
            if (d8 - obj2[8] >= 30000.0d) {
                fArr = new float[1];
                Location.distanceBetween(obj2[0], obj2[1], d, d2, fArr);
                if (fArr[0] >= 30.0f) {
                    this.bGg.add(new double[]{d, d2, d3, d4, d5, d6, d7, (double) size2, d8});
                    obj = 1;
                    if (size >= 8) {
                        this.bGg.subList(0, 1).clear();
                        this.bGg.trimToSize();
                    }
                    try {
                        m15092aY(false);
                    } catch (Exception e) {
                    }
                }
            } else if (d4 >= obj2[3]) {
                fArr = new float[]{30.0f};
                if (size > 1) {
                    double[] dArr = (double[]) this.bGg.get(size - 2);
                    Location.distanceBetween(dArr[0], dArr[1], d, d2, fArr);
                }
                if (fArr[0] >= 30.0f) {
                    System.arraycopy(new double[]{d, d2, d3, d4, d5, d6, d7, (double) size2, d8}, 0, obj2, 0, obj2.length);
                    obj = 1;
                }
            }
            obj = null;
        }
        if (obj != null) {
            int size3 = this.bGg.size();
            m15093d(new C8498e(size3));
            if (size3 == 1) {
                m15095ws();
            }
        }
        AppMethodBeat.m2505o(55671);
    }
}
