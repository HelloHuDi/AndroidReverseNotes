package com.b.a.a;

import android.location.Location;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class s {
    private long bGc;
    float bGd;
    private ArrayList<String> bGe = new ArrayList();
    private ArrayList<float[]> bGf = new ArrayList();
    private ArrayList<double[]> bGg = new ArrayList();
    final d bGh;
    Handler bGi;

    class a implements Runnable {
        final int bFn;
        final float bGj;
        final float bGk;
        final String bGl;
        final float x;
        final float y;

        private a(float f, float f2, float f3, float f4, int i, String str) {
            this.x = f;
            this.y = f2;
            this.bGj = f3;
            this.bGk = f4;
            this.bFn = i;
            this.bGl = str;
        }

        /* synthetic */ a(s sVar, float f, float f2, float f3, float f4, int i, String str, byte b) {
            this(f, f2, f3, f4, i, str);
        }

        public final void run() {
            AppMethodBeat.i(55654);
            s.this.a(this.x, this.y, this.bGj, this.bGk, this.bFn, this.bGl);
            AppMethodBeat.o(55654);
        }
    }

    class b implements Runnable {
        final double bGn;
        final double bGo;
        final double bGp;
        final double bGq;
        final double bGr;
        final double bGs;
        final double lat;
        final double lng;

        private b(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
            this.lat = d;
            this.lng = d2;
            this.bGn = d3;
            this.bGo = d4;
            this.bGp = d5;
            this.bGq = d6;
            this.bGr = d7;
            this.bGs = d8;
        }

        /* synthetic */ b(s sVar, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, byte b) {
            this(d, d2, d3, d4, d5, d6, d7, d8);
        }

        public final void run() {
            AppMethodBeat.i(55655);
            s.this.a(this.lat, this.lng, this.bGn, this.bGo, this.bGp, this.bGq, this.bGr, this.bGs);
            AppMethodBeat.o(55655);
        }
    }

    class c implements Runnable {
        private c() {
        }

        /* synthetic */ c(s sVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(55656);
            s.this.wp();
            AppMethodBeat.o(55656);
        }
    }

    class f implements Runnable {
        private f() {
        }

        /* synthetic */ f(s sVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(55658);
            s.this.reset();
            AppMethodBeat.o(55658);
        }
    }

    class d implements Runnable {
        private final p bCK;

        private d(p pVar) {
            this.bCK = pVar;
        }

        /* synthetic */ d(s sVar, p pVar, byte b) {
            this(pVar);
        }

        public final void run() {
            AppMethodBeat.i(55657);
            s.this.bGh.c(this.bCK);
            AppMethodBeat.o(55657);
        }
    }

    static class e extends p {
        final int bGt;

        e(int i) {
            super(8901);
            this.bGt = i;
        }
    }

    static class g extends p {
        final boolean bGu;

        g(boolean z) {
            super(8902);
            this.bGu = z;
        }
    }

    public s(d dVar) {
        AppMethodBeat.i(55659);
        this.bGh = dVar;
        AppMethodBeat.o(55659);
    }

    private void d(p pVar) {
        AppMethodBeat.i(55660);
        if (this.bGi != null) {
            this.bGi.post(new d(this, pVar, (byte) 0));
        }
        AppMethodBeat.o(55660);
    }

    private static void writeLog(String str) {
        AppMethodBeat.i(55661);
        o.s("post_processing_log_" + y.bIT, str);
        AppMethodBeat.o(55661);
    }

    /* Access modifiers changed, original: final */
    public final void wo() {
        AppMethodBeat.i(55662);
        z.b(null).execute(new c(this, (byte) 0));
        AppMethodBeat.o(55662);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void wp() {
        AppMethodBeat.i(55663);
        try {
            aY(true);
            AppMethodBeat.o(55663);
        } catch (Exception e) {
            AppMethodBeat.o(55663);
        }
        return;
    }

    /* Access modifiers changed, original: final */
    public final void wq() {
        AppMethodBeat.i(55664);
        this.bGc = 0;
        this.bGd = 0.0f;
        z.b(null).execute(new f(this, (byte) 0));
        AppMethodBeat.o(55664);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void reset() {
        AppMethodBeat.i(55665);
        wr();
        ws();
        AppMethodBeat.o(55665);
    }

    private synchronized void wr() {
        AppMethodBeat.i(55666);
        this.bGg.clear();
        AppMethodBeat.o(55666);
    }

    private synchronized void ws() {
        AppMethodBeat.i(55667);
        this.bGe.clear();
        this.bGf.clear();
        AppMethodBeat.o(55667);
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x026a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void aY(boolean z) {
        AppMethodBeat.i(55668);
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
                    if (sqrt < ((double) (1.0f / y.bIW)) || sqrt > ((double) y.bIW)) {
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
                        if (y.bIM) {
                            writeLog("ref_point," + dArr[0] + ',' + dArr[1] + ',' + dArr[2] + ',' + dArr[8]);
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
                            if (y.bIM) {
                                writeLog("scan_point," + dArr6[0] + ',' + dArr6[1] + ',' + fArr2[3]);
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
                                    if (v.e(d8, d9)) {
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
                        if (y.bIM) {
                            writeLog("ref_point," + dArr2[0] + ',' + dArr2[1] + ',' + dArr2[2] + ',' + dArr2[8]);
                        }
                        if (((float) i6) <= y.bIU) {
                            float f5 = f2 - f3;
                            float f6 = f - f4;
                            if (f5 > 0.0f && (((double) f6) * sqrt) / ((double) f5) <= ((double) y.bIV)) {
                                r.wg().bp(stringBuilder.toString());
                                z2 = true;
                                if (y.bIM) {
                                    writeLog(z2 ? "buffered" : "discarded");
                                }
                                d(new g(z2));
                                i3 = i5;
                            }
                        }
                        z2 = false;
                        if (y.bIM) {
                        }
                        d(new g(z2));
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
        AppMethodBeat.o(55668);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void a(float f, float f2, float f3, float f4, int i, String str) {
        AppMethodBeat.i(55669);
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
        AppMethodBeat.o(55669);
    }

    /* Access modifiers changed, original: final */
    public final boolean a(double d, double d2, double d3, float f, double d4, double d5, double d6, long j) {
        AppMethodBeat.i(55670);
        if (f < y.bIX) {
            AppMethodBeat.o(55670);
            return false;
        } else if (j - this.bGc >= 1000 || f > this.bGd) {
            z b = z.b(null);
            b.execute(new b(this, d, d2, d3, (double) f, d4, d5, d6, (double) j, (byte) 0));
            this.bGc = j;
            this.bGd = f;
            AppMethodBeat.o(55670);
            return true;
        } else {
            AppMethodBeat.o(55670);
            return false;
        }
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        Object obj;
        AppMethodBeat.i(55671);
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
                        aY(false);
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
            d(new e(size3));
            if (size3 == 1) {
                ws();
            }
        }
        AppMethodBeat.o(55671);
    }
}
