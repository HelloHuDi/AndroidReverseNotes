package com.b.a.a;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.SystemClock;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.sharp.jni.QLog;
import java.lang.reflect.Array;
import java.util.List;

class n extends b {
    private final e bET = new e(this, (byte) 0);
    final j bEU = new j();
    private final d bEV = new d();
    private final i bEW;
    final s bEX;
    private long bEY;
    private long bEZ;
    private long bFa;
    private int bFb;
    private long bFc;
    private boolean bFd;
    private Location bFe;
    private int bFf;
    private float bFg;
    private float bFh;
    private float bFi;
    private int bFj;
    private int bFk;
    private long bFl;

    static class a extends p {
        final int bFm;
        final int bFn;
        final long bFo;
        final double lat;
        final double lng;

        a(double d, double d2, int i, int i2, long j) {
            super(9901);
            this.lat = d;
            this.lng = d2;
            this.bFm = i;
            this.bFn = i2;
            this.bFo = j;
        }
    }

    static class d {
        private String bFr;
        private long bFs;
        private String bFt;
        private long bFu;

        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized String c(String str, long j, boolean z) {
            String str2;
            AppMethodBeat.i(55681);
            if (z) {
                if (this.bFr != null && o(j, this.bFs)) {
                    str = new StringBuilder(String.valueOf(str)).append(this.bFr).toString();
                    this.bFr = null;
                }
                str2 = str;
                if (this.bFt != null && o(j, this.bFu)) {
                    str2 = new StringBuilder(String.valueOf(str2)).append(this.bFt).toString();
                    this.bFt = null;
                }
            } else {
                if (this.bFr != null && o(j, this.bFs)) {
                    str = new StringBuilder(String.valueOf(str)).append(v.bu(this.bFr)).toString();
                    this.bFr = null;
                }
                str2 = str;
                if (this.bFt != null && o(j, this.bFu)) {
                    str2 = new StringBuilder(String.valueOf(str2)).append(v.bt(this.bFt)).toString();
                    this.bFt = null;
                }
            }
            AppMethodBeat.o(55681);
            return str2;
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized void d(String str, long j) {
            this.bFr = str;
            this.bFs = j;
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized void e(String str, long j) {
            this.bFt = str;
            this.bFu = j;
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized void reset() {
            this.bFr = null;
            this.bFt = null;
            this.bFs = 0;
            this.bFu = 0;
        }

        static boolean o(long j, long j2) {
            AppMethodBeat.i(55682);
            if (Math.abs(j - j2) <= 10000) {
                AppMethodBeat.o(55682);
                return true;
            }
            AppMethodBeat.o(55682);
            return false;
        }
    }

    static class b extends p {
        final boolean bFp;
        final int code;
        final String message;

        private b(int i, String str) {
            super(9902);
            this.code = i;
            this.message = str;
            this.bFp = false;
        }

        b(int i, String str, byte b) {
            this(i, str);
        }
    }

    static class c extends a {
        final long bFq;

        c(long j, long j2) {
            super(Math.max(j, 3000));
            AppMethodBeat.i(55680);
            this.bFq = j2;
            AppMethodBeat.o(55680);
        }
    }

    class e {
        long bFv;
        boolean bFw;

        private e() {
            this.bFw = y.bIR;
        }

        /* synthetic */ e(n nVar, byte b) {
            this();
        }

        /* Access modifiers changed, original: final */
        public final void aW(boolean z) {
            AppMethodBeat.i(55683);
            if ((this.bFw ^ z) != 0) {
                this.bFw = !this.bFw;
                n.this.bEX.wo();
                n.this.bEX.wq();
                n.this.bEU.aW(this.bFw);
                n.this.wd();
                if (y.bIM) {
                    String str = "vehicle mode: " + (this.bFw ? "enable" : "disable");
                    o.s("filter_input_log_" + y.bIT, str);
                    o.s("filter_output_log_" + y.bIT, str);
                }
            }
            AppMethodBeat.o(55683);
        }

        static /* synthetic */ void a(e eVar) {
            AppMethodBeat.i(55684);
            eVar.reset();
            AppMethodBeat.o(55684);
        }

        private void reset() {
            this.bFv = 0;
            this.bFw = y.bIR;
        }
    }

    n() {
        AppMethodBeat.i(55685);
        if (i.bDs == null) {
            i.bDs = new i();
        }
        this.bEW = i.bDs;
        this.bFd = true;
        this.bEX = new s(this);
        AppMethodBeat.o(55685);
    }

    private boolean a(long j, int i, double d, double d2, double d3, float f, int i2, float f2) {
        boolean z;
        AppMethodBeat.i(55686);
        long j2 = j / 1000;
        double toRadians = Math.toRadians(d);
        double toRadians2 = Math.toRadians(d2);
        if (this.bFd) {
            this.bEU.a(j2, toRadians, toRadians2, f, this.bET.bFw, y.bIS);
            this.bFd = false;
            z = true;
        } else {
            z = false;
        }
        a aVar = new a(i, (double) j2, toRadians, toRadians2, d3, (double) f, i2, (double) f2, 0, 0.0d, 0.0d);
        this.bEU.a(aVar);
        if (y.bIM) {
            o.s("filter_input_log_" + y.bIT, aVar.toString());
        }
        AppMethodBeat.o(55686);
        return z;
    }

    /* Access modifiers changed, original: final */
    public final void wd() {
        this.bFd = true;
        this.bFe = null;
        this.bFf = 0;
    }

    /* Access modifiers changed, original: final */
    public final void a(List<ScanResult> list, long j, long j2) {
        boolean z;
        AppMethodBeat.i(55687);
        long ay = aa.ay(j);
        if (this.bEZ == 0 || j2 - this.bEZ >= this.bEY) {
            z = true;
        } else {
            z = false;
        }
        String a = v.a(list, z);
        String c = this.bEV.c(a, j2, z);
        if (z) {
            r wg = r.wg();
            int i = this.bFk;
            if (c != null) {
                long currentTimeMillis;
                if (wg.isRunning) {
                    if (wg.wi()) {
                        currentTimeMillis = System.currentTimeMillis();
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (wg.bFK != null) {
                            wg.bFK.execute(new e(wg, c, currentTimeMillis, elapsedRealtime, i, (byte) 0));
                        }
                    } else {
                        wg.wh();
                    }
                }
                currentTimeMillis = aa.ay(System.currentTimeMillis());
                if (wg.bFK != null) {
                    wg.bFK.execute(new c(wg, c, currentTimeMillis, 0, (byte) 0));
                }
            }
        } else {
            r.wg().bp(v.b(c, ay, AppEventsConstants.EVENT_PARAM_VALUE_NO));
        }
        if (d.o(j2, this.bFa)) {
            String str;
            if (z) {
                str = null;
            } else {
                str = a;
            }
            if (str == null) {
                str = v.a(list, false);
            }
            String b = v.b(str, ay, "2");
            s sVar = this.bEX;
            float f = this.bFg;
            float f2 = this.bFh;
            float f3 = this.bFi;
            float f4 = (float) this.bFj;
            int i2 = this.bFb;
            if (sVar.bGd != 0.0f) {
                z.b(null).execute(new a(sVar, f, f2, f3, f4, i2, b, (byte) 0));
            }
        }
        AppMethodBeat.o(55687);
    }

    /* Access modifiers changed, original: final */
    public final void a(float f, float f2, int i, float f3, float f4, float f5, long j) {
        int i2;
        Object obj;
        AppMethodBeat.i(55689);
        e eVar = this.bET;
        if (j - eVar.bFv > 5000) {
            eVar.aW(false);
        }
        if (j - this.bFa > 5000) {
            we();
        }
        this.bFg = f;
        this.bFh = f2;
        this.bFi = f4;
        this.bFj = i;
        this.bFa = j;
        if (f5 > 0.0f) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        this.bFk = i2;
        if (this.bEZ != 0 || j - this.bFl >= 30000) {
            boolean z = i2 == 0;
            if (!(z && this.bET.bFw)) {
                ab.wD().aV(z);
                k.wc().aV(z);
            }
        }
        double[] dArr = new double[2];
        i iVar = this.bEW;
        double[] dArr2 = new double[]{(double) f, (double) f2};
        if (iVar.bDB) {
            dArr[0] = iVar.bDt;
            dArr[1] = iVar.bDu;
            dArr[0] = dArr[0] + ((1.0E-5d * (dArr2[1] - ((double) iVar.bDw))) / ((double) iVar.bDz));
            dArr[1] = dArr[1] + ((1.0E-5d * (dArr2[0] - ((double) iVar.bDv))) / ((double) iVar.bDA));
            if (dArr[0] > 90.0d) {
                dArr[0] = 180.0d - dArr[0];
            } else if (dArr[0] < -90.0d) {
                dArr[0] = -180.0d - dArr[0];
            }
            if (dArr[1] > 180.0d) {
                dArr[1] = dArr[1] - 360.0d;
            } else if (dArr[1] < -180.0d) {
                dArr[1] = dArr[1] + 360.0d;
            }
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            AppMethodBeat.o(55689);
            return;
        }
        String str;
        double d = dArr[0];
        double d2 = dArr[1];
        iVar = this.bEW;
        float f6 = ((f4 - iVar.bDx) / 10.0f) + iVar.bDy;
        float f7 = 0.0f;
        Location location = new Location("S");
        location.setLatitude(d);
        location.setLongitude(d2);
        if (this.bFe != null) {
            f7 = this.bFe.bearingTo(location);
        }
        this.bFe = location;
        int max = Math.max(0, i - this.bFf);
        this.bFf = i;
        a aVar = new a(3, (double) (j / 1000), Math.toRadians(d), Math.toRadians(d2), 0.0d, (double) f6, 0, (double) f5, max, (double) f3, Math.toRadians((double) f7));
        this.bEU.a(aVar);
        if (y.bIM) {
            o.s("filter_input_log_" + y.bIT, aVar.toString());
        }
        double[] dArr3 = new double[4];
        long j2 = j / 1000;
        double[] dArr4 = new double[2];
        double[] dArr5 = new double[2];
        double[] dArr6 = new double[2];
        double[][] dArr7 = (double[][]) Array.newInstance(Double.TYPE, new int[]{2, 2});
        double[][] dArr8 = (double[][]) Array.newInstance(Double.TYPE, new int[]{2, 2});
        j jVar = this.bEU;
        d = ((double) j2) - jVar.bDD.bDF;
        double d3 = d * d;
        double[] dArr9 = new double[2];
        dArr4[0] = jVar.bDD.bEo[0] + (jVar.bDD.bEo[2] * d);
        dArr4[1] = (d * jVar.bDD.bEo[3]) + jVar.bDD.bEo[1];
        dArr6[0] = jVar.bDD.bEo[2];
        dArr6[1] = jVar.bDD.bEo[3];
        if (jVar.bDD.bDW) {
            dArr9[0] = dArr4[0] - jVar.bDD.bDX[0];
            dArr9[1] = dArr4[1] - jVar.bDD.bDX[1];
            d = Math.sqrt((dArr9[0] * dArr9[0]) + (dArr9[1] * dArr9[1]));
            d = (d * d) * jVar.bDD.bEr;
        } else {
            d = 0.0d;
        }
        dArr7[0][0] = (jVar.bDD.bEp[0][0] + (jVar.bDD.bEp[2][2] * d3)) + d;
        dArr7[0][1] = jVar.bDD.bEp[0][1] + (jVar.bDD.bEp[2][3] * d3);
        dArr7[1][0] = jVar.bDD.bEp[1][0] + (jVar.bDD.bEp[3][2] * d3);
        dArr7[1][1] = d + ((d3 * jVar.bDD.bEp[3][3]) + jVar.bDD.bEp[1][1]);
        dArr8[0][0] = jVar.bDD.bEp[2][2];
        dArr8[0][1] = jVar.bDD.bEp[2][3];
        dArr8[1][0] = jVar.bDD.bEp[3][2];
        dArr8[1][1] = jVar.bDD.bEp[3][3];
        jVar.a(1, dArr4, dArr5);
        dArr3[0] = Math.toDegrees(dArr5[0]);
        dArr3[1] = Math.toDegrees(dArr5[1]);
        dArr3[2] = Math.sqrt((dArr7[0][0] + dArr7[1][1]) / 2.0d);
        dArr3[3] = Math.sqrt((dArr6[0] * dArr6[0]) + (dArr6[1] * dArr6[1]));
        if (y.bIM) {
            o.s("filter_output_log_" + y.bIT, String.valueOf(j2) + ',' + dArr3[0] + ',' + dArr3[1] + ',' + dArr3[2] + ',' + dArr3[3]);
        }
        d = dArr3[0];
        double d4 = dArr3[1];
        int intValue = Double.valueOf(dArr3[2]).intValue();
        i2 = Double.valueOf(dArr3[3]).intValue();
        int i3 = this.bFb;
        if (v.e(d, d4)) {
            str = "&SD=" + d + ',' + d4 + ',' + 0 + ',' + intValue + ',' + i3 + ',' + 0 + ',' + i2 + ',' + 0 + ',' + 0 + ',' + 0;
        } else {
            str = "";
        }
        this.bEV.e(str, j);
        c(new a(d, d4, intValue, this.bFb, this.bFc));
        AppMethodBeat.o(55689);
    }

    /* Access modifiers changed, original: final */
    public final void a(double d, double d2, int i, int i2, int i3, int i4, int i5, float f, long j, long j2) {
        AppMethodBeat.i(55690);
        if (i2 <= 0) {
            AppMethodBeat.o(55690);
            return;
        }
        String str;
        e eVar = this.bET;
        if (i3 >= 3) {
            if (j2 - eVar.bFv <= 5000) {
                eVar.aW(true);
            }
            eVar.bFv = j2;
        }
        int round = Math.round(f);
        if (v.e(d, d2)) {
            str = "&GD=" + d + ',' + d2 + ',' + i + ',' + i3 + ',' + i5 + ',' + i2 + ',' + round + ',' + j + ',';
        } else {
            str = "";
        }
        this.bEV.d(str, j2);
        if (a(j2, 1, d, d2, (double) i, (float) i2, i5, (float) i3)) {
            this.bEW.a(d, d2, (float) i2, this.bFg, this.bFh, this.bFi);
        }
        if (d.o(j2, this.bFa)) {
            this.bEX.a(d, d2, (double) i2, f, (double) this.bFg, (double) this.bFh, (double) this.bFi, j2);
        }
        if (y.bIM) {
            o.s("gps_log_" + y.bIT, String.valueOf(d) + ',' + d2 + ',' + i + ',' + i2 + ',' + i3 + ',' + i4 + ',' + i5 + ',' + f + ',' + j);
        }
        AppMethodBeat.o(55690);
    }

    /* Access modifiers changed, original: 0000 */
    public void a(int i, String str, long j, long j2) {
        AppMethodBeat.i(55691);
        c(new b(i, str, (byte) 0));
        if (i == -4 || i == -5) {
            stop();
        }
        AppMethodBeat.o(55691);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void stop() {
        AppMethodBeat.i(55693);
        this.bEX.wo();
        super.stop();
        AppMethodBeat.o(55693);
    }

    private void we() {
        AppMethodBeat.i(55694);
        this.bEW.bDB = false;
        this.bEX.wq();
        this.bEV.reset();
        e.a(this.bET);
        wd();
        this.bEZ = 0;
        this.bFa = SystemClock.elapsedRealtime();
        this.bFg = 0.0f;
        this.bFh = 0.0f;
        this.bFi = 0.0f;
        this.bFj = 0;
        this.bFk = 0;
        this.bFb = 0;
        AppMethodBeat.o(55694);
    }

    /* Access modifiers changed, original: final */
    public final a a(a aVar) {
        AppMethodBeat.i(55695);
        a aVar2 = new a(0);
        AppMethodBeat.o(55695);
        return aVar2;
    }

    /* Access modifiers changed, original: 0000 */
    public void a(x xVar, long j, long j2) {
        AppMethodBeat.i(55688);
        this.bEZ = xVar.bFX;
        this.bFb = xVar.level;
        this.bFc = xVar.bFo;
        if (xVar.bIy.equals(QLog.TAG_REPORTLEVEL_COLORUSER)) {
            if (a(j2, 2, xVar.latitude, xVar.longitude, xVar.altitude, xVar.bEJ, xVar.bID, xVar.speed)) {
                this.bEW.a(xVar.latitude, xVar.longitude, xVar.bEJ, this.bFg, this.bFh, this.bFi);
            }
        }
        if (!u.wx().bGV) {
            c(new a(xVar.latitude, xVar.longitude, Float.valueOf(xVar.bEJ).intValue(), this.bFb, this.bFc));
        }
        AppMethodBeat.o(55688);
    }

    /* Access modifiers changed, original: declared_synchronized */
    public synchronized void a(Handler handler, a aVar) {
        AppMethodBeat.i(55692);
        if (aVar instanceof c) {
            aVar = (c) aVar;
        } else {
            aVar = new c(aVar != null ? aVar.bCP : 5000, 9000);
        }
        this.bEY = aVar.bFq;
        we();
        this.bEX.bGi = handler;
        this.bFl = SystemClock.elapsedRealtime();
        super.a(handler, aVar);
        AppMethodBeat.o(55692);
    }
}
