package com.tencent.p177mm.modelstat;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1179i;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p836be.C45183b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C40618o;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.modelstat.e */
public class C18686e {
    private static C18686e fSf;
    private int fSg = -1;
    private int fSh = C1625i.sHCENCODEVIDEOTIMEOUT;
    private int fSi = AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS;
    private int fSj = 1000;
    private int fSk = 20;
    private ArrayList<Pair<Float, Float>> fSl = new ArrayList();
    private ArrayList<Pair<Float, Float>> fSm = new ArrayList();
    private long startTime = 0;

    /* renamed from: com.tencent.mm.modelstat.e$b */
    class C18684b {
        long eRt = 0;
        C18690a fSA = null;
        C18690a fSB = null;
        C18690a fSC = null;
        private Long fSD = null;
        ArrayList<Long> fSE = new ArrayList();
        ArrayList<C18690a> fSF = new ArrayList();
        ArrayList<C18690a> fSG = new ArrayList();
        ArrayList<C18690a> fSH = new ArrayList();
        ArrayList<float[]> fSI = new ArrayList();
        private SensorEventListener fSJ = new C186851();
        long fSz = 0;
        private HandlerThread handlerThread = null;
        private SensorManager sensorManager;

        /* renamed from: com.tencent.mm.modelstat.e$b$1 */
        class C186851 implements SensorEventListener {
            C186851() {
            }

            public final void onAccuracyChanged(Sensor sensor, int i) {
            }

            public final void onSensorChanged(SensorEvent sensorEvent) {
                AppMethodBeat.m2504i(78718);
                if (sensorEvent == null) {
                    AppMethodBeat.m2505o(78718);
                    return;
                }
                long anU = C5046bo.anU();
                if (sensorEvent.sensor.getType() == 1) {
                    C18684b.this.fSA = new C18690a(sensorEvent);
                } else if (sensorEvent.sensor.getType() == 2) {
                    C18684b.this.fSB = new C18690a(sensorEvent);
                } else if (sensorEvent.sensor.getType() == 4) {
                    C18684b.this.fSC = new C18690a(sensorEvent);
                }
                long j = anU - C18684b.this.eRt;
                if (!(C18684b.this.fSA == null || C18684b.this.fSB == null || C18684b.this.fSC == null || (j <= C18684b.this.fSz && j >= 0))) {
                    float[] fArr = new float[9];
                    SensorManager.getRotationMatrix(fArr, null, C18684b.this.fSA.values, C18684b.this.fSB.values);
                    float[] fArr2 = new float[3];
                    SensorManager.getOrientation(fArr, fArr2);
                    C18684b.this.eRt = anU;
                    C18684b.this.fSE.add(Long.valueOf(anU));
                    C18684b.this.fSF.add(C18684b.this.fSA);
                    C18684b.this.fSG.add(C18684b.this.fSB);
                    C18684b.this.fSH.add(C18684b.this.fSC);
                    C18684b.this.fSI.add(fArr2);
                    int size = C18684b.this.fSF.size() - 1;
                    C4990ab.m7417i("MicroMsg.IndoorReporter", "RES ,  %d  acc[%d,%f,%f,%f]  ", Integer.valueOf(C18684b.this.fSF.size()), Integer.valueOf(((C18690a) C18684b.this.fSF.get(size)).accuracy), Float.valueOf(((C18690a) C18684b.this.fSF.get(size)).values[0]), Float.valueOf(((C18690a) C18684b.this.fSF.get(size)).values[1]), Float.valueOf(((C18690a) C18684b.this.fSF.get(size)).values[2]));
                    C4990ab.m7419v("MicroMsg.IndoorReporter", "Res:%d acc[%d,%f,%f,%f] mag[%d,%f,%f,%f] gyr[%d,%f,%f,%f] ori[%f,%f,%f]", Long.valueOf(j), Integer.valueOf(C18684b.this.fSA.accuracy), Float.valueOf(C18684b.this.fSA.values[0]), Float.valueOf(C18684b.this.fSA.values[1]), Float.valueOf(C18684b.this.fSA.values[2]), Integer.valueOf(C18684b.this.fSB.accuracy), Float.valueOf(C18684b.this.fSB.values[0]), Float.valueOf(C18684b.this.fSB.values[1]), Float.valueOf(C18684b.this.fSB.values[2]), Integer.valueOf(C18684b.this.fSC.accuracy), Float.valueOf(C18684b.this.fSC.values[0]), Float.valueOf(C18684b.this.fSC.values[1]), Float.valueOf(C18684b.this.fSC.values[2]), Float.valueOf(fArr2[0]), Float.valueOf(fArr2[1]), Float.valueOf(fArr2[2]));
                }
                AppMethodBeat.m2505o(78718);
            }
        }

        C18684b() {
            AppMethodBeat.m2504i(78719);
            AppMethodBeat.m2505o(78719);
        }

        /* renamed from: A */
        public final boolean mo33952A(Context context, int i) {
            boolean z;
            AppMethodBeat.m2504i(78720);
            try {
                if (this.sensorManager == null) {
                    this.sensorManager = (SensorManager) context.getSystemService("sensor");
                }
                if (this.handlerThread == null) {
                    this.handlerThread = C7305d.m12297ek("MicroMsg.IndoorReporter", 1);
                    this.handlerThread.start();
                }
                Handler handler = new Handler(this.handlerThread.getLooper());
                z = this.sensorManager.registerListener(this.fSJ, this.sensorManager.getDefaultSensor(1), 3, handler) && this.sensorManager.registerListener(this.fSJ, this.sensorManager.getDefaultSensor(4), 3, handler) && this.sensorManager.registerListener(this.fSJ, this.sensorManager.getDefaultSensor(2), 3, handler);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.IndoorReporter", "start except:%s", e.getMessage());
                z = false;
            }
            if (!z) {
                try {
                    if (this.sensorManager != null) {
                        this.sensorManager.unregisterListener(this.fSJ);
                        this.sensorManager = null;
                    }
                } catch (Exception e2) {
                }
                try {
                    if (this.handlerThread != null) {
                        this.handlerThread.quit();
                        this.handlerThread = null;
                    }
                } catch (Exception e3) {
                }
            }
            this.fSz = (long) i;
            this.fSD = Long.valueOf(C5046bo.anU());
            AppMethodBeat.m2505o(78720);
            return z;
        }

        public final String akg() {
            AppMethodBeat.m2504i(78721);
            try {
                if (this.sensorManager != null) {
                    this.sensorManager.unregisterListener(this.fSJ);
                    this.sensorManager = null;
                }
            } catch (Exception e) {
            }
            try {
                if (this.handlerThread != null) {
                    this.handlerThread.quit();
                    this.handlerThread = null;
                }
            } catch (Exception e2) {
            }
            C4990ab.m7417i("MicroMsg.IndoorReporter", "stop sampling Res Count: %d", Integer.valueOf(this.fSE.size()));
            String str = this.fSD + ";" + this.fSE.size() + ";#";
            for (int i = 0; i < this.fSE.size(); i++) {
                str = (str + (((Long) this.fSE.get(i)).longValue() - this.fSD.longValue()) + ";") + C18684b.m29202a((C18690a) this.fSF.get(i));
                C4990ab.m7417i("MicroMsg.IndoorReporter", "%d accResArr [%d,%f,%f,%f]  %s", Integer.valueOf(i), Integer.valueOf(((C18690a) this.fSF.get(i)).accuracy), Float.valueOf(((C18690a) this.fSF.get(i)).values[0]), Float.valueOf(((C18690a) this.fSF.get(i)).values[1]), Float.valueOf(((C18690a) this.fSF.get(i)).values[2]), C18684b.m29202a((C18690a) this.fSF.get(i)));
                str = ((str + C18684b.m29202a((C18690a) this.fSH.get(i))) + C18684b.m29202a((C18690a) this.fSG.get(i))) + String.format("%.3f;%.3f;%.3f;#", new Object[]{Float.valueOf(((float[]) this.fSI.get(i))[0]), Float.valueOf(((float[]) this.fSI.get(i))[1]), Float.valueOf(((float[]) this.fSI.get(i))[2])});
            }
            C4990ab.m7417i("MicroMsg.IndoorReporter", "stop  Res: %d [%s]", Integer.valueOf(str.length()), str);
            AppMethodBeat.m2505o(78721);
            return str;
        }

        /* renamed from: a */
        private static String m29202a(C18690a c18690a) {
            AppMethodBeat.m2504i(78722);
            String str;
            try {
                str = new String();
                str = String.format("%d;%.3f;%.3f;%.3f;", new Object[]{Integer.valueOf(c18690a.accuracy), Float.valueOf(c18690a.values[0]), Float.valueOf(c18690a.values[1]), Float.valueOf(c18690a.values[2])});
                AppMethodBeat.m2505o(78722);
                return str;
            } catch (Exception e) {
                str = "0;0;0;0;";
                AppMethodBeat.m2505o(78722);
                return str;
            }
        }
    }

    /* renamed from: com.tencent.mm.modelstat.e$c */
    class C18688c {
        WifiManager bJj;
        int fSL = 0;
        boolean fSM = false;
        List<String> fSN = new ArrayList();
        int fSk = 0;
        long startTime = 0;
        Thread thread = C7305d.m12301h(new C186891(), "MicroMsg.IndoorReporter_WIFI_Scan");

        /* renamed from: com.tencent.mm.modelstat.e$c$1 */
        class C186891 implements Runnable {

            /* renamed from: com.tencent.mm.modelstat.e$c$1$1 */
            class C97101 implements Comparator<ScanResult> {
                C97101() {
                }

                public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                    return ((ScanResult) obj2).level - ((ScanResult) obj).level;
                }
            }

            C186891() {
            }

            public final void run() {
                AppMethodBeat.m2504i(78723);
                C4990ab.m7416i("MicroMsg.IndoorReporter", "start wifi");
                while (C18688c.this.fSM) {
                    try {
                        int i;
                        long anU = C5046bo.anU();
                        List scanResults = C18688c.this.bJj.getScanResults();
                        String str = "";
                        if (scanResults == null || scanResults.size() <= 0) {
                            i = 0;
                        } else {
                            Collections.sort(scanResults, new C97101());
                            int i2 = 0;
                            i = 0;
                            while (i2 < scanResults.size()) {
                                int i3;
                                ScanResult scanResult = (ScanResult) scanResults.get(i2);
                                if (scanResult != null && !C5046bo.isNullOrNil(scanResult.BSSID) && !C5046bo.isNullOrNil(scanResult.SSID)) {
                                    str = str + scanResult.SSID.replace(";", "").replace(" ", "").replace(",", "").replace("#", "") + ";" + scanResult.BSSID + ";" + scanResult.level + ";";
                                    i3 = i + 1;
                                    if (i3 >= C18688c.this.fSk) {
                                        i = i3;
                                        break;
                                    }
                                } else {
                                    i3 = i;
                                }
                                i2++;
                                i = i3;
                            }
                        }
                        C4990ab.m7417i("MicroMsg.IndoorReporter", "%d %s", Integer.valueOf(((anU - C18688c.this.startTime) + ";" + (scanResults != null ? scanResults.size() : 0) + ";" + i + ";" + str).length()), (anU - C18688c.this.startTime) + ";" + (scanResults != null ? scanResults.size() : 0) + ";" + i + ";" + str);
                        C18688c.this.fSN.add(r0);
                        C18688c.this.bJj.startScan();
                        Thread.sleep((long) C18688c.this.fSL);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.IndoorReporter", "Except:%s", e.getMessage());
                        AppMethodBeat.m2505o(78723);
                        return;
                    }
                }
                AppMethodBeat.m2505o(78723);
            }
        }

        C18688c() {
            AppMethodBeat.m2504i(78724);
            AppMethodBeat.m2505o(78724);
        }

        public final String akg() {
            boolean z = false;
            AppMethodBeat.m2504i(78725);
            this.fSM = false;
            try {
                if (this.thread != null && this.thread.isAlive()) {
                    this.thread.join(500);
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.IndoorReporter", "stop, join Thread failed:%s ", e.getMessage());
            }
            String str = this.fSN.size() + ";#";
            while (true) {
                boolean z2 = z;
                if (z2 < this.fSN.size()) {
                    str = str + ((String) this.fSN.get(z2)) + "#";
                    z = z2 + 1;
                } else {
                    AppMethodBeat.m2505o(78725);
                    return str;
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.modelstat.e$a */
    static class C18690a {
        public int accuracy = 0;
        public float[] values;

        public C18690a(SensorEvent sensorEvent) {
            AppMethodBeat.m2504i(78717);
            if (sensorEvent != null) {
                this.accuracy = sensorEvent.accuracy;
                this.values = new float[sensorEvent.values.length];
                System.arraycopy(sensorEvent.values, 0, this.values, 0, sensorEvent.values.length);
            }
            AppMethodBeat.m2505o(78717);
        }
    }

    public C18686e() {
        AppMethodBeat.m2504i(78726);
        AppMethodBeat.m2505o(78726);
    }

    public static C18686e akf() {
        AppMethodBeat.m2504i(78727);
        if (fSf == null) {
            synchronized (C18686e.class) {
                try {
                    if (fSf == null) {
                        fSf = new C18686e();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(78727);
                    }
                }
            }
        }
        C18686e c18686e = fSf;
        AppMethodBeat.m2505o(78727);
        return c18686e;
    }

    /* renamed from: a */
    public final void mo33956a(int i, boolean z, boolean z2, float f, float f2, int i2) {
        AppMethodBeat.m2504i(78728);
        C4990ab.m7417i("MicroMsg.IndoorReporter", "report scene:%d agps:%b mars:%b lon:%f lat:%f acc:%d", Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2));
        if (C1720g.m3534RN().mo5161QY()) {
            C1720g.m3534RN();
            if (!C1668a.m3393QT()) {
                C45183b.aiD().mo73167a(f, f2, i2, "", "", z2 ? 1 : 0, i);
                if (this.fSm.size() == 0 && this.fSl.size() == 0 && !mo33957tI(C26373g.m41964Nu().getValue("AndroidIndoorSensorReport"))) {
                    AppMethodBeat.m2505o(78728);
                    return;
                }
                if (!C4872b.dnO()) {
                    C1720g.m3534RN();
                    int bL = C1179i.m2593bL(C1668a.m3383QF() + 5, 100);
                    if (bL > this.fSg) {
                        r3 = new Object[3];
                        C1720g.m3534RN();
                        r3[0] = Long.valueOf(new C1183p(C1668a.m3383QF()).longValue());
                        r3[1] = Integer.valueOf(bL);
                        r3[2] = Integer.valueOf(this.fSg);
                        C4990ab.m7411d("MicroMsg.IndoorReporter", "report uin:%s hash:%d config:%d", r3);
                        AppMethodBeat.m2505o(78728);
                        return;
                    }
                }
                C1720g.m3537RQ();
                final boolean z3 = z2;
                final float f3 = f;
                final float f4 = f2;
                final int i3 = i;
                final boolean z4 = z;
                final int i4 = i2;
                C1720g.m3539RS().mo10302aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(78716);
                        try {
                            if (C1720g.m3534RN().mo5161QY()) {
                                C1720g.m3534RN();
                                if (!C1668a.m3393QT()) {
                                    long anU = C5046bo.anU();
                                    if (C18686e.this.startTime == 0 || anU - C18686e.this.startTime >= 1800000) {
                                        List b;
                                        Pair pair;
                                        if (z3) {
                                            b = C18686e.this.fSl;
                                        } else {
                                            Object b2 = C18686e.this.fSm;
                                        }
                                        int i = 0;
                                        while (i < b2.size()) {
                                            if (C18686e.m29204F(f3, ((Float) ((Pair) b2.get(i)).first).floatValue()) && C18686e.m29204F(f4, ((Float) ((Pair) b2.get(i)).second).floatValue())) {
                                                pair = (Pair) b2.get(i);
                                                break;
                                            }
                                            i++;
                                        }
                                        pair = null;
                                        if (pair == null) {
                                            C4990ab.m7410d("MicroMsg.IndoorReporter", "Ignore this report, no hit any Point");
                                            AppMethodBeat.m2505o(78716);
                                            return;
                                        }
                                        int i2;
                                        C18686e.this.startTime = anU;
                                        StringBuilder stringBuilder = new StringBuilder();
                                        C1720g.m3534RN();
                                        final String stringBuilder2 = stringBuilder.append(new C1183p(C1668a.m3383QF()).toString()).append("_").append(C18686e.this.startTime).toString();
                                        StringBuilder append = new StringBuilder().append(pair.first).append(",").append(pair.second).append(",").append(i3).append(",");
                                        int i3 = z4 ? 1 : 2;
                                        if (z3) {
                                            i2 = 10;
                                        } else {
                                            i2 = 20;
                                        }
                                        final String stringBuilder3 = append.append(i2 + i3).append(",").append(f3).append(",").append(f4).append(",0,").append(i4).append(",").append(C18686e.this.startTime).append(",").toString();
                                        final C18688c c18688c = new C18688c();
                                        Context context = C4996ah.getContext();
                                        i3 = C18686e.this.fSi;
                                        int e = C18686e.this.fSk;
                                        if (c18688c.bJj == null) {
                                            c18688c.bJj = (WifiManager) context.getSystemService("wifi");
                                        }
                                        c18688c.fSL = i3;
                                        c18688c.fSk = e;
                                        c18688c.startTime = C5046bo.anU();
                                        c18688c.fSM = true;
                                        c18688c.thread.start();
                                        final C18684b c18684b = new C18684b();
                                        if (c18684b.mo33952A(C4996ah.getContext(), C18686e.this.fSj)) {
                                            C1720g.m3537RQ();
                                            new C7564ap(C1720g.m3539RS().oAl.getLooper(), new C5015a() {
                                                boolean fSt = false;

                                                /* renamed from: BI */
                                                public final boolean mo4499BI() {
                                                    AppMethodBeat.m2504i(78715);
                                                    boolean eA = C40618o.m70061eA(C4996ah.getContext());
                                                    long anU = C5046bo.anU();
                                                    long a = anU - C18686e.this.startTime;
                                                    if (a <= ((long) C18686e.this.fSh)) {
                                                        if (eA) {
                                                            this.fSt = false;
                                                            AppMethodBeat.m2505o(78715);
                                                            return true;
                                                        } else if (!this.fSt) {
                                                            this.fSt = true;
                                                            AppMethodBeat.m2505o(78715);
                                                            return true;
                                                        }
                                                    }
                                                    C4990ab.m7417i("MicroMsg.IndoorReporter", "Stop Now goingbg:%b fg:%b runtime:%d", Boolean.valueOf(this.fSt), Boolean.valueOf(eA), Long.valueOf(a));
                                                    C18686e.this.startTime = 0;
                                                    String akg = c18684b.akg();
                                                    String akg2 = c18688c.akg();
                                                    try {
                                                        if (C5046bo.isNullOrNil(akg) || C5046bo.isNullOrNil(akg2)) {
                                                            C4990ab.m7413e("MicroMsg.IndoorReporter", "get Res Failed [%s][%s]", akg, akg2);
                                                            C7060h.pYm.mo8374X(13381, stringBuilder3 + stringBuilder2 + (!C5046bo.isNullOrNil(akg) ? ",-10011,ERROR:StopFailed." : ",-10012,ERROR:StopFailed."));
                                                            AppMethodBeat.m2505o(78715);
                                                            return false;
                                                        }
                                                        String str = akg + akg2;
                                                        int ceil = (int) Math.ceil(((double) str.length()) / 5400.0d);
                                                        for (int i = 0; i < ceil; i++) {
                                                            C4990ab.m7417i("MicroMsg.IndoorReporter", "reportKV [%d/%d] res:%d kv:%d [%s]", Integer.valueOf(i), Integer.valueOf(ceil), Integer.valueOf(str.length()), Integer.valueOf((stringBuilder3 + stringBuilder2 + "_" + anU + "_" + ceil + "_" + (a > ((long) C18686e.this.fSh) ? "1" : "2") + "," + (i + 1) + "," + str.substring(i * 5400, Math.min((i + 1) * 5400, str.length()))).length()), stringBuilder3 + stringBuilder2 + "_" + anU + "_" + ceil + "_" + (a > ((long) C18686e.this.fSh) ? "1" : "2") + "," + (i + 1) + "," + str.substring(i * 5400, Math.min((i + 1) * 5400, str.length())));
                                                            C7060h.pYm.mo8374X(13381, akg);
                                                        }
                                                        AppMethodBeat.m2505o(78715);
                                                        return false;
                                                    } catch (Exception e) {
                                                        C4990ab.m7413e("MicroMsg.IndoorReporter", "reprot Stop exception:%s", e.getMessage());
                                                    }
                                                }
                                            }, true).mo16770ae(3000, 3000);
                                            AppMethodBeat.m2505o(78716);
                                            return;
                                        }
                                        C4990ab.m7413e("MicroMsg.IndoorReporter", "Ignore this report. Error:start wifi:%b sensor:%b  ", Boolean.TRUE, Boolean.valueOf(c18684b.mo33952A(C4996ah.getContext(), C18686e.this.fSj)));
                                        c18684b.akg();
                                        c18688c.akg();
                                        C7060h.pYm.mo8374X(13381, stringBuilder3 + stringBuilder2 + ",-10002,ERROR:StartFailed.");
                                        AppMethodBeat.m2505o(78716);
                                        return;
                                    }
                                    C4990ab.m7413e("MicroMsg.IndoorReporter", "Ignore this Report,Another Report is Running & not timeout:%d.", Long.valueOf(anU - C18686e.this.startTime));
                                    AppMethodBeat.m2505o(78716);
                                    return;
                                }
                            }
                            AppMethodBeat.m2505o(78716);
                        } catch (Exception e2) {
                            C4990ab.m7413e("MicroMsg.IndoorReporter", "reprot Start exception:%s", e2.getMessage());
                            AppMethodBeat.m2505o(78716);
                        }
                    }
                });
                AppMethodBeat.m2505o(78728);
                return;
            }
        }
        AppMethodBeat.m2505o(78728);
    }

    /* renamed from: tI */
    public final boolean mo33957tI(String str) {
        AppMethodBeat.m2504i(78729);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(78729);
            return false;
        }
        try {
            String[] split = str.split(",");
            this.fSg = C5046bo.getInt(split[0], -1);
            if (this.fSg > 101) {
                Assert.assertTrue(false);
            }
            this.fSh = C5046bo.getInt(split[1], C1625i.sHCENCODEVIDEOTIMEOUT);
            this.fSi = C5046bo.getInt(split[2], AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
            this.fSj = C5046bo.getInt(split[3], 1000);
            this.fSk = C5046bo.getInt(split[4], 20);
            int i = C5046bo.getInt(split[5], 0);
            for (int i2 = 0; i2 < i; i2++) {
                String[] split2 = split[i2 + 6].split(";");
                if ("1".equals(split2[0])) {
                    this.fSl.add(new Pair(Float.valueOf(C5046bo.ann(split2[1])), Float.valueOf(C5046bo.ann(split2[2]))));
                } else {
                    this.fSm.add(new Pair(Float.valueOf(C5046bo.ann(split2[1])), Float.valueOf(C5046bo.ann(split2[2]))));
                }
            }
            C4990ab.m7417i("MicroMsg.IndoorReporter", "parseConfig: max:%d wifiFreq:%d sensorFreq:%d maxWifiCount:%d cnt:%d mars:%d earth:%d", Integer.valueOf(this.fSh), Integer.valueOf(this.fSi), Integer.valueOf(this.fSj), Integer.valueOf(this.fSk), Integer.valueOf(i), Integer.valueOf(this.fSl.size()), Integer.valueOf(this.fSm.size()));
            AppMethodBeat.m2505o(78729);
            return true;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.IndoorReporter", "parseConfig e:%s  [%s]", e.getMessage(), str);
            AppMethodBeat.m2505o(78729);
            return false;
        }
    }

    /* renamed from: F */
    static /* synthetic */ boolean m29204F(float f, float f2) {
        AppMethodBeat.m2504i(78730);
        if (((double) Math.abs(f - f2)) < Math.pow(0.1d, 2.0d)) {
            AppMethodBeat.m2505o(78730);
            return true;
        }
        AppMethodBeat.m2505o(78730);
        return false;
    }
}
