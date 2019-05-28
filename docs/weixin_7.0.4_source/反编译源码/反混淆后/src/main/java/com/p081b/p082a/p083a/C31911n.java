package com.p081b.p082a.p083a;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.SystemClock;
import com.facebook.appevents.AppEventsConstants;
import com.p081b.p082a.p083a.C37155r.C17505c;
import com.p081b.p082a.p083a.C37155r.C17507e;
import com.p081b.p082a.p083a.C8482d.C8483a;
import com.p081b.p082a.p083a.C8484j.C8485a;
import com.p081b.p082a.p083a.C8487k.C8488a;
import com.p081b.p082a.p083a.C8493s.C8492a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.sharp.jni.QLog;
import java.lang.reflect.Array;
import java.util.List;

/* renamed from: com.b.a.a.n */
class C31911n extends C25390b {
    private final C31912e bET = new C31912e(this, (byte) 0);
    final C8484j bEU = new C8484j();
    private final C0737d bEV = new C0737d();
    private final C31910i bEW;
    final C8493s bEX;
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

    /* renamed from: com.b.a.a.n$a */
    static class C0736a extends C31914p {
        final int bFm;
        final int bFn;
        final long bFo;
        final double lat;
        final double lng;

        C0736a(double d, double d2, int i, int i2, long j) {
            super(9901);
            this.lat = d;
            this.lng = d2;
            this.bFm = i;
            this.bFn = i2;
            this.bFo = j;
        }
    }

    /* renamed from: com.b.a.a.n$d */
    static class C0737d {
        private String bFr;
        private long bFs;
        private String bFt;
        private long bFu;

        private C0737d() {
        }

        /* synthetic */ C0737d(byte b) {
            this();
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        /* renamed from: c */
        public final synchronized String mo2179c(String str, long j, boolean z) {
            String str2;
            AppMethodBeat.m2504i(55681);
            if (z) {
                if (this.bFr != null && C0737d.m1694o(j, this.bFs)) {
                    str = new StringBuilder(String.valueOf(str)).append(this.bFr).toString();
                    this.bFr = null;
                }
                str2 = str;
                if (this.bFt != null && C0737d.m1694o(j, this.bFu)) {
                    str2 = new StringBuilder(String.valueOf(str2)).append(this.bFt).toString();
                    this.bFt = null;
                }
            } else {
                if (this.bFr != null && C0737d.m1694o(j, this.bFs)) {
                    str = new StringBuilder(String.valueOf(str)).append(C17508v.m27334bu(this.bFr)).toString();
                    this.bFr = null;
                }
                str2 = str;
                if (this.bFt != null && C0737d.m1694o(j, this.bFu)) {
                    str2 = new StringBuilder(String.valueOf(str2)).append(C17508v.m27333bt(this.bFt)).toString();
                    this.bFt = null;
                }
            }
            AppMethodBeat.m2505o(55681);
            return str2;
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        /* renamed from: d */
        public final synchronized void mo2180d(String str, long j) {
            this.bFr = str;
            this.bFs = j;
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        /* renamed from: e */
        public final synchronized void mo2181e(String str, long j) {
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

        /* renamed from: o */
        static boolean m1694o(long j, long j2) {
            AppMethodBeat.m2504i(55682);
            if (Math.abs(j - j2) <= 10000) {
                AppMethodBeat.m2505o(55682);
                return true;
            }
            AppMethodBeat.m2505o(55682);
            return false;
        }
    }

    /* renamed from: com.b.a.a.n$b */
    static class C8490b extends C31914p {
        final boolean bFp;
        final int code;
        final String message;

        private C8490b(int i, String str) {
            super(9902);
            this.code = i;
            this.message = str;
            this.bFp = false;
        }

        C8490b(int i, String str, byte b) {
            this(i, str);
        }
    }

    /* renamed from: com.b.a.a.n$c */
    static class C8491c extends C8483a {
        final long bFq;

        C8491c(long j, long j2) {
            super(Math.max(j, 3000));
            AppMethodBeat.m2504i(55680);
            this.bFq = j2;
            AppMethodBeat.m2505o(55680);
        }
    }

    /* renamed from: com.b.a.a.n$e */
    class C31912e {
        long bFv;
        boolean bFw;

        private C31912e() {
            this.bFw = C44978y.bIR;
        }

        /* synthetic */ C31912e(C31911n c31911n, byte b) {
            this();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: aW */
        public final void mo52026aW(boolean z) {
            AppMethodBeat.m2504i(55683);
            if ((this.bFw ^ z) != 0) {
                this.bFw = !this.bFw;
                C31911n.this.bEX.mo18583wo();
                C31911n.this.bEX.mo18585wq();
                C31911n.this.bEU.mo18569aW(this.bFw);
                C31911n.this.mo52025wd();
                if (C44978y.bIM) {
                    String str = "vehicle mode: " + (this.bFw ? "enable" : "disable");
                    C31913o.m51802s("filter_input_log_" + C44978y.bIT, str);
                    C31913o.m51802s("filter_output_log_" + C44978y.bIT, str);
                }
            }
            AppMethodBeat.m2505o(55683);
        }

        /* renamed from: a */
        static /* synthetic */ void m51800a(C31912e c31912e) {
            AppMethodBeat.m2504i(55684);
            c31912e.reset();
            AppMethodBeat.m2505o(55684);
        }

        private void reset() {
            this.bFv = 0;
            this.bFw = C44978y.bIR;
        }
    }

    C31911n() {
        AppMethodBeat.m2504i(55685);
        if (C31910i.bDs == null) {
            C31910i.bDs = new C31910i();
        }
        this.bEW = C31910i.bDs;
        this.bFd = true;
        this.bEX = new C8493s(this);
        AppMethodBeat.m2505o(55685);
    }

    /* renamed from: a */
    private boolean m51790a(long j, int i, double d, double d2, double d3, float f, int i2, float f2) {
        boolean z;
        AppMethodBeat.m2504i(55686);
        long j2 = j / 1000;
        double toRadians = Math.toRadians(d);
        double toRadians2 = Math.toRadians(d2);
        if (this.bFd) {
            this.bEU.mo18567a(j2, toRadians, toRadians2, f, this.bET.bFw, C44978y.bIS);
            this.bFd = false;
            z = true;
        } else {
            z = false;
        }
        C8485a c8485a = new C8485a(i, (double) j2, toRadians, toRadians2, d3, (double) f, i2, (double) f2, 0, 0.0d, 0.0d);
        this.bEU.mo18568a(c8485a);
        if (C44978y.bIM) {
            C31913o.m51802s("filter_input_log_" + C44978y.bIT, c8485a.toString());
        }
        AppMethodBeat.m2505o(55686);
        return z;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: wd */
    public final void mo52025wd() {
        this.bFd = true;
        this.bFe = null;
        this.bFf = 0;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo42417a(List<ScanResult> list, long j, long j2) {
        boolean z;
        AppMethodBeat.m2504i(55687);
        long ay = C8481aa.m15061ay(j);
        if (this.bEZ == 0 || j2 - this.bEZ >= this.bEY) {
            z = true;
        } else {
            z = false;
        }
        String a = C17508v.m27330a(list, z);
        String c = this.bEV.mo2179c(a, j2, z);
        if (z) {
            C37155r wg = C37155r.m62256wg();
            int i = this.bFk;
            if (c != null) {
                long currentTimeMillis;
                if (wg.isRunning) {
                    if (wg.mo59236wi()) {
                        currentTimeMillis = System.currentTimeMillis();
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (wg.bFK != null) {
                            wg.bFK.execute(new C17507e(wg, c, currentTimeMillis, elapsedRealtime, i, (byte) 0));
                        }
                    } else {
                        wg.mo59235wh();
                    }
                }
                currentTimeMillis = C8481aa.m15061ay(System.currentTimeMillis());
                if (wg.bFK != null) {
                    wg.bFK.execute(new C17505c(wg, c, currentTimeMillis, 0, (byte) 0));
                }
            }
        } else {
            C37155r.m62256wg().mo59234bp(C17508v.m27331b(c, ay, AppEventsConstants.EVENT_PARAM_VALUE_NO));
        }
        if (C0737d.m1694o(j2, this.bFa)) {
            String str;
            if (z) {
                str = null;
            } else {
                str = a;
            }
            if (str == null) {
                str = C17508v.m27330a(list, false);
            }
            String b = C17508v.m27331b(str, ay, "2");
            C8493s c8493s = this.bEX;
            float f = this.bFg;
            float f2 = this.bFh;
            float f3 = this.bFi;
            float f4 = (float) this.bFj;
            int i2 = this.bFb;
            if (c8493s.bGd != 0.0f) {
                C37158z.m62269b(null).execute(new C8492a(c8493s, f, f2, f3, f4, i2, b, (byte) 0));
            }
        }
        AppMethodBeat.m2505o(55687);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo42412a(float f, float f2, int i, float f3, float f4, float f5, long j) {
        int i2;
        Object obj;
        AppMethodBeat.m2504i(55689);
        C31912e c31912e = this.bET;
        if (j - c31912e.bFv > 5000) {
            c31912e.mo52026aW(false);
        }
        if (j - this.bFa > 5000) {
            m51791we();
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
                C44975ab.m82345wD().mo42418aV(z);
                C8487k.m15084wc().mo42418aV(z);
            }
        }
        double[] dArr = new double[2];
        C31910i c31910i = this.bEW;
        double[] dArr2 = new double[]{(double) f, (double) f2};
        if (c31910i.bDB) {
            dArr[0] = c31910i.bDt;
            dArr[1] = c31910i.bDu;
            dArr[0] = dArr[0] + ((1.0E-5d * (dArr2[1] - ((double) c31910i.bDw))) / ((double) c31910i.bDz));
            dArr[1] = dArr[1] + ((1.0E-5d * (dArr2[0] - ((double) c31910i.bDv))) / ((double) c31910i.bDA));
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
            AppMethodBeat.m2505o(55689);
            return;
        }
        String str;
        double d = dArr[0];
        double d2 = dArr[1];
        c31910i = this.bEW;
        float f6 = ((f4 - c31910i.bDx) / 10.0f) + c31910i.bDy;
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
        C8485a c8485a = new C8485a(3, (double) (j / 1000), Math.toRadians(d), Math.toRadians(d2), 0.0d, (double) f6, 0, (double) f5, max, (double) f3, Math.toRadians((double) f7));
        this.bEU.mo18568a(c8485a);
        if (C44978y.bIM) {
            C31913o.m51802s("filter_input_log_" + C44978y.bIT, c8485a.toString());
        }
        double[] dArr3 = new double[4];
        long j2 = j / 1000;
        double[] dArr4 = new double[2];
        double[] dArr5 = new double[2];
        double[] dArr6 = new double[2];
        double[][] dArr7 = (double[][]) Array.newInstance(Double.TYPE, new int[]{2, 2});
        double[][] dArr8 = (double[][]) Array.newInstance(Double.TYPE, new int[]{2, 2});
        C8484j c8484j = this.bEU;
        d = ((double) j2) - c8484j.bDD.bDF;
        double d3 = d * d;
        double[] dArr9 = new double[2];
        dArr4[0] = c8484j.bDD.bEo[0] + (c8484j.bDD.bEo[2] * d);
        dArr4[1] = (d * c8484j.bDD.bEo[3]) + c8484j.bDD.bEo[1];
        dArr6[0] = c8484j.bDD.bEo[2];
        dArr6[1] = c8484j.bDD.bEo[3];
        if (c8484j.bDD.bDW) {
            dArr9[0] = dArr4[0] - c8484j.bDD.bDX[0];
            dArr9[1] = dArr4[1] - c8484j.bDD.bDX[1];
            d = Math.sqrt((dArr9[0] * dArr9[0]) + (dArr9[1] * dArr9[1]));
            d = (d * d) * c8484j.bDD.bEr;
        } else {
            d = 0.0d;
        }
        dArr7[0][0] = (c8484j.bDD.bEp[0][0] + (c8484j.bDD.bEp[2][2] * d3)) + d;
        dArr7[0][1] = c8484j.bDD.bEp[0][1] + (c8484j.bDD.bEp[2][3] * d3);
        dArr7[1][0] = c8484j.bDD.bEp[1][0] + (c8484j.bDD.bEp[3][2] * d3);
        dArr7[1][1] = d + ((d3 * c8484j.bDD.bEp[3][3]) + c8484j.bDD.bEp[1][1]);
        dArr8[0][0] = c8484j.bDD.bEp[2][2];
        dArr8[0][1] = c8484j.bDD.bEp[2][3];
        dArr8[1][0] = c8484j.bDD.bEp[3][2];
        dArr8[1][1] = c8484j.bDD.bEp[3][3];
        c8484j.mo18566a(1, dArr4, dArr5);
        dArr3[0] = Math.toDegrees(dArr5[0]);
        dArr3[1] = Math.toDegrees(dArr5[1]);
        dArr3[2] = Math.sqrt((dArr7[0][0] + dArr7[1][1]) / 2.0d);
        dArr3[3] = Math.sqrt((dArr6[0] * dArr6[0]) + (dArr6[1] * dArr6[1]));
        if (C44978y.bIM) {
            C31913o.m51802s("filter_output_log_" + C44978y.bIT, String.valueOf(j2) + ',' + dArr3[0] + ',' + dArr3[1] + ',' + dArr3[2] + ',' + dArr3[3]);
        }
        d = dArr3[0];
        double d4 = dArr3[1];
        int intValue = Double.valueOf(dArr3[2]).intValue();
        i2 = Double.valueOf(dArr3[3]).intValue();
        int i3 = this.bFb;
        if (C17508v.m27335e(d, d4)) {
            str = "&SD=" + d + ',' + d4 + ',' + 0 + ',' + intValue + ',' + i3 + ',' + 0 + ',' + i2 + ',' + 0 + ',' + 0 + ',' + 0;
        } else {
            str = "";
        }
        this.bEV.mo2181e(str, j);
        mo18562c(new C0736a(d, d4, intValue, this.bFb, this.bFc));
        AppMethodBeat.m2505o(55689);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo42411a(double d, double d2, int i, int i2, int i3, int i4, int i5, float f, long j, long j2) {
        AppMethodBeat.m2504i(55690);
        if (i2 <= 0) {
            AppMethodBeat.m2505o(55690);
            return;
        }
        String str;
        C31912e c31912e = this.bET;
        if (i3 >= 3) {
            if (j2 - c31912e.bFv <= 5000) {
                c31912e.mo52026aW(true);
            }
            c31912e.bFv = j2;
        }
        int round = Math.round(f);
        if (C17508v.m27335e(d, d2)) {
            str = "&GD=" + d + ',' + d2 + ',' + i + ',' + i3 + ',' + i5 + ',' + i2 + ',' + round + ',' + j + ',';
        } else {
            str = "";
        }
        this.bEV.mo2180d(str, j2);
        if (m51790a(j2, 1, d, d2, (double) i, (float) i2, i5, (float) i3)) {
            this.bEW.mo52024a(d, d2, (float) i2, this.bFg, this.bFh, this.bFi);
        }
        if (C0737d.m1694o(j2, this.bFa)) {
            this.bEX.mo18581a(d, d2, (double) i2, f, (double) this.bFg, (double) this.bFh, (double) this.bFi, j2);
        }
        if (C44978y.bIM) {
            C31913o.m51802s("gps_log_" + C44978y.bIT, String.valueOf(d) + ',' + d2 + ',' + i + ',' + i2 + ',' + i3 + ',' + i4 + ',' + i5 + ',' + f + ',' + j);
        }
        AppMethodBeat.m2505o(55690);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo42413a(int i, String str, long j, long j2) {
        AppMethodBeat.m2504i(55691);
        mo18562c(new C8490b(i, str, (byte) 0));
        if (i == -4 || i == -5) {
            stop();
        }
        AppMethodBeat.m2505o(55691);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void stop() {
        AppMethodBeat.m2504i(55693);
        this.bEX.mo18583wo();
        super.stop();
        AppMethodBeat.m2505o(55693);
    }

    /* renamed from: we */
    private void m51791we() {
        AppMethodBeat.m2504i(55694);
        this.bEW.bDB = false;
        this.bEX.mo18585wq();
        this.bEV.reset();
        C31912e.m51800a(this.bET);
        mo52025wd();
        this.bEZ = 0;
        this.bFa = SystemClock.elapsedRealtime();
        this.bFg = 0.0f;
        this.bFh = 0.0f;
        this.bFi = 0.0f;
        this.bFj = 0;
        this.bFk = 0;
        this.bFb = 0;
        AppMethodBeat.m2505o(55694);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final C8488a mo42410a(C8483a c8483a) {
        AppMethodBeat.m2504i(55695);
        C8488a c8488a = new C8488a(0);
        AppMethodBeat.m2505o(55695);
        return c8488a;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo42416a(C37157x c37157x, long j, long j2) {
        AppMethodBeat.m2504i(55688);
        this.bEZ = c37157x.bFX;
        this.bFb = c37157x.level;
        this.bFc = c37157x.bFo;
        if (c37157x.bIy.equals(QLog.TAG_REPORTLEVEL_COLORUSER)) {
            if (m51790a(j2, 2, c37157x.latitude, c37157x.longitude, c37157x.altitude, c37157x.bEJ, c37157x.bID, c37157x.speed)) {
                this.bEW.mo52024a(c37157x.latitude, c37157x.longitude, c37157x.bEJ, this.bFg, this.bFh, this.bFi);
            }
        }
        if (!C25394u.m40118wx().bGV) {
            mo18562c(new C0736a(c37157x.latitude, c37157x.longitude, Float.valueOf(c37157x.bEJ).intValue(), this.bFb, this.bFc));
        }
        AppMethodBeat.m2505o(55688);
    }

    /* Access modifiers changed, original: declared_synchronized */
    /* renamed from: a */
    public synchronized void mo18559a(Handler handler, C8483a c8483a) {
        AppMethodBeat.m2504i(55692);
        if (c8483a instanceof C8491c) {
            c8483a = (C8491c) c8483a;
        } else {
            c8483a = new C8491c(c8483a != null ? c8483a.bCP : 5000, 9000);
        }
        this.bEY = c8483a.bFq;
        m51791we();
        this.bEX.bGi = handler;
        this.bFl = SystemClock.elapsedRealtime();
        super.mo18559a(handler, c8483a);
        AppMethodBeat.m2505o(55692);
    }
}
