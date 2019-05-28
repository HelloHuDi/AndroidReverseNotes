package com.tencent.mm.modelstat;

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
import com.tencent.mm.a.p;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import junit.framework.Assert;

public class e {
    private static e fSf;
    private int fSg = -1;
    private int fSh = i.sHCENCODEVIDEOTIMEOUT;
    private int fSi = AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS;
    private int fSj = 1000;
    private int fSk = 20;
    private ArrayList<Pair<Float, Float>> fSl = new ArrayList();
    private ArrayList<Pair<Float, Float>> fSm = new ArrayList();
    private long startTime = 0;

    class b {
        long eRt = 0;
        a fSA = null;
        a fSB = null;
        a fSC = null;
        private Long fSD = null;
        ArrayList<Long> fSE = new ArrayList();
        ArrayList<a> fSF = new ArrayList();
        ArrayList<a> fSG = new ArrayList();
        ArrayList<a> fSH = new ArrayList();
        ArrayList<float[]> fSI = new ArrayList();
        private SensorEventListener fSJ = new SensorEventListener() {
            public final void onAccuracyChanged(Sensor sensor, int i) {
            }

            public final void onSensorChanged(SensorEvent sensorEvent) {
                AppMethodBeat.i(78718);
                if (sensorEvent == null) {
                    AppMethodBeat.o(78718);
                    return;
                }
                long anU = bo.anU();
                if (sensorEvent.sensor.getType() == 1) {
                    b.this.fSA = new a(sensorEvent);
                } else if (sensorEvent.sensor.getType() == 2) {
                    b.this.fSB = new a(sensorEvent);
                } else if (sensorEvent.sensor.getType() == 4) {
                    b.this.fSC = new a(sensorEvent);
                }
                long j = anU - b.this.eRt;
                if (!(b.this.fSA == null || b.this.fSB == null || b.this.fSC == null || (j <= b.this.fSz && j >= 0))) {
                    float[] fArr = new float[9];
                    SensorManager.getRotationMatrix(fArr, null, b.this.fSA.values, b.this.fSB.values);
                    float[] fArr2 = new float[3];
                    SensorManager.getOrientation(fArr, fArr2);
                    b.this.eRt = anU;
                    b.this.fSE.add(Long.valueOf(anU));
                    b.this.fSF.add(b.this.fSA);
                    b.this.fSG.add(b.this.fSB);
                    b.this.fSH.add(b.this.fSC);
                    b.this.fSI.add(fArr2);
                    int size = b.this.fSF.size() - 1;
                    ab.i("MicroMsg.IndoorReporter", "RES ,  %d  acc[%d,%f,%f,%f]  ", Integer.valueOf(b.this.fSF.size()), Integer.valueOf(((a) b.this.fSF.get(size)).accuracy), Float.valueOf(((a) b.this.fSF.get(size)).values[0]), Float.valueOf(((a) b.this.fSF.get(size)).values[1]), Float.valueOf(((a) b.this.fSF.get(size)).values[2]));
                    ab.v("MicroMsg.IndoorReporter", "Res:%d acc[%d,%f,%f,%f] mag[%d,%f,%f,%f] gyr[%d,%f,%f,%f] ori[%f,%f,%f]", Long.valueOf(j), Integer.valueOf(b.this.fSA.accuracy), Float.valueOf(b.this.fSA.values[0]), Float.valueOf(b.this.fSA.values[1]), Float.valueOf(b.this.fSA.values[2]), Integer.valueOf(b.this.fSB.accuracy), Float.valueOf(b.this.fSB.values[0]), Float.valueOf(b.this.fSB.values[1]), Float.valueOf(b.this.fSB.values[2]), Integer.valueOf(b.this.fSC.accuracy), Float.valueOf(b.this.fSC.values[0]), Float.valueOf(b.this.fSC.values[1]), Float.valueOf(b.this.fSC.values[2]), Float.valueOf(fArr2[0]), Float.valueOf(fArr2[1]), Float.valueOf(fArr2[2]));
                }
                AppMethodBeat.o(78718);
            }
        };
        long fSz = 0;
        private HandlerThread handlerThread = null;
        private SensorManager sensorManager;

        b() {
            AppMethodBeat.i(78719);
            AppMethodBeat.o(78719);
        }

        public final boolean A(Context context, int i) {
            boolean z;
            AppMethodBeat.i(78720);
            try {
                if (this.sensorManager == null) {
                    this.sensorManager = (SensorManager) context.getSystemService("sensor");
                }
                if (this.handlerThread == null) {
                    this.handlerThread = d.ek("MicroMsg.IndoorReporter", 1);
                    this.handlerThread.start();
                }
                Handler handler = new Handler(this.handlerThread.getLooper());
                z = this.sensorManager.registerListener(this.fSJ, this.sensorManager.getDefaultSensor(1), 3, handler) && this.sensorManager.registerListener(this.fSJ, this.sensorManager.getDefaultSensor(4), 3, handler) && this.sensorManager.registerListener(this.fSJ, this.sensorManager.getDefaultSensor(2), 3, handler);
            } catch (Exception e) {
                ab.e("MicroMsg.IndoorReporter", "start except:%s", e.getMessage());
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
            this.fSD = Long.valueOf(bo.anU());
            AppMethodBeat.o(78720);
            return z;
        }

        public final String akg() {
            AppMethodBeat.i(78721);
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
            ab.i("MicroMsg.IndoorReporter", "stop sampling Res Count: %d", Integer.valueOf(this.fSE.size()));
            String str = this.fSD + ";" + this.fSE.size() + ";#";
            for (int i = 0; i < this.fSE.size(); i++) {
                str = (str + (((Long) this.fSE.get(i)).longValue() - this.fSD.longValue()) + ";") + a((a) this.fSF.get(i));
                ab.i("MicroMsg.IndoorReporter", "%d accResArr [%d,%f,%f,%f]  %s", Integer.valueOf(i), Integer.valueOf(((a) this.fSF.get(i)).accuracy), Float.valueOf(((a) this.fSF.get(i)).values[0]), Float.valueOf(((a) this.fSF.get(i)).values[1]), Float.valueOf(((a) this.fSF.get(i)).values[2]), a((a) this.fSF.get(i)));
                str = ((str + a((a) this.fSH.get(i))) + a((a) this.fSG.get(i))) + String.format("%.3f;%.3f;%.3f;#", new Object[]{Float.valueOf(((float[]) this.fSI.get(i))[0]), Float.valueOf(((float[]) this.fSI.get(i))[1]), Float.valueOf(((float[]) this.fSI.get(i))[2])});
            }
            ab.i("MicroMsg.IndoorReporter", "stop  Res: %d [%s]", Integer.valueOf(str.length()), str);
            AppMethodBeat.o(78721);
            return str;
        }

        private static String a(a aVar) {
            AppMethodBeat.i(78722);
            String str;
            try {
                str = new String();
                str = String.format("%d;%.3f;%.3f;%.3f;", new Object[]{Integer.valueOf(aVar.accuracy), Float.valueOf(aVar.values[0]), Float.valueOf(aVar.values[1]), Float.valueOf(aVar.values[2])});
                AppMethodBeat.o(78722);
                return str;
            } catch (Exception e) {
                str = "0;0;0;0;";
                AppMethodBeat.o(78722);
                return str;
            }
        }
    }

    class c {
        WifiManager bJj;
        int fSL = 0;
        boolean fSM = false;
        List<String> fSN = new ArrayList();
        int fSk = 0;
        long startTime = 0;
        Thread thread = d.h(new Runnable() {
            public final void run() {
                AppMethodBeat.i(78723);
                ab.i("MicroMsg.IndoorReporter", "start wifi");
                while (c.this.fSM) {
                    try {
                        int i;
                        long anU = bo.anU();
                        List scanResults = c.this.bJj.getScanResults();
                        String str = "";
                        if (scanResults == null || scanResults.size() <= 0) {
                            i = 0;
                        } else {
                            Collections.sort(scanResults, new Comparator<ScanResult>() {
                                public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                                    return ((ScanResult) obj2).level - ((ScanResult) obj).level;
                                }
                            });
                            int i2 = 0;
                            i = 0;
                            while (i2 < scanResults.size()) {
                                int i3;
                                ScanResult scanResult = (ScanResult) scanResults.get(i2);
                                if (scanResult != null && !bo.isNullOrNil(scanResult.BSSID) && !bo.isNullOrNil(scanResult.SSID)) {
                                    str = str + scanResult.SSID.replace(";", "").replace(" ", "").replace(",", "").replace("#", "") + ";" + scanResult.BSSID + ";" + scanResult.level + ";";
                                    i3 = i + 1;
                                    if (i3 >= c.this.fSk) {
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
                        ab.i("MicroMsg.IndoorReporter", "%d %s", Integer.valueOf(((anU - c.this.startTime) + ";" + (scanResults != null ? scanResults.size() : 0) + ";" + i + ";" + str).length()), (anU - c.this.startTime) + ";" + (scanResults != null ? scanResults.size() : 0) + ";" + i + ";" + str);
                        c.this.fSN.add(r0);
                        c.this.bJj.startScan();
                        Thread.sleep((long) c.this.fSL);
                    } catch (Exception e) {
                        ab.e("MicroMsg.IndoorReporter", "Except:%s", e.getMessage());
                        AppMethodBeat.o(78723);
                        return;
                    }
                }
                AppMethodBeat.o(78723);
            }
        }, "MicroMsg.IndoorReporter_WIFI_Scan");

        c() {
            AppMethodBeat.i(78724);
            AppMethodBeat.o(78724);
        }

        public final String akg() {
            boolean z = false;
            AppMethodBeat.i(78725);
            this.fSM = false;
            try {
                if (this.thread != null && this.thread.isAlive()) {
                    this.thread.join(500);
                }
            } catch (Exception e) {
                ab.e("MicroMsg.IndoorReporter", "stop, join Thread failed:%s ", e.getMessage());
            }
            String str = this.fSN.size() + ";#";
            while (true) {
                boolean z2 = z;
                if (z2 < this.fSN.size()) {
                    str = str + ((String) this.fSN.get(z2)) + "#";
                    z = z2 + 1;
                } else {
                    AppMethodBeat.o(78725);
                    return str;
                }
            }
        }
    }

    static class a {
        public int accuracy = 0;
        public float[] values;

        public a(SensorEvent sensorEvent) {
            AppMethodBeat.i(78717);
            if (sensorEvent != null) {
                this.accuracy = sensorEvent.accuracy;
                this.values = new float[sensorEvent.values.length];
                System.arraycopy(sensorEvent.values, 0, this.values, 0, sensorEvent.values.length);
            }
            AppMethodBeat.o(78717);
        }
    }

    public e() {
        AppMethodBeat.i(78726);
        AppMethodBeat.o(78726);
    }

    public static e akf() {
        AppMethodBeat.i(78727);
        if (fSf == null) {
            synchronized (e.class) {
                try {
                    if (fSf == null) {
                        fSf = new e();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(78727);
                    }
                }
            }
        }
        e eVar = fSf;
        AppMethodBeat.o(78727);
        return eVar;
    }

    public final void a(int i, boolean z, boolean z2, float f, float f2, int i2) {
        AppMethodBeat.i(78728);
        ab.i("MicroMsg.IndoorReporter", "report scene:%d agps:%b mars:%b lon:%f lat:%f acc:%d", Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2));
        if (g.RN().QY()) {
            g.RN();
            if (!com.tencent.mm.kernel.a.QT()) {
                com.tencent.mm.be.b.aiD().a(f, f2, i2, "", "", z2 ? 1 : 0, i);
                if (this.fSm.size() == 0 && this.fSl.size() == 0 && !tI(com.tencent.mm.m.g.Nu().getValue("AndroidIndoorSensorReport"))) {
                    AppMethodBeat.o(78728);
                    return;
                }
                if (!com.tencent.mm.sdk.a.b.dnO()) {
                    g.RN();
                    int bL = com.tencent.mm.a.i.bL(com.tencent.mm.kernel.a.QF() + 5, 100);
                    if (bL > this.fSg) {
                        r3 = new Object[3];
                        g.RN();
                        r3[0] = Long.valueOf(new p(com.tencent.mm.kernel.a.QF()).longValue());
                        r3[1] = Integer.valueOf(bL);
                        r3[2] = Integer.valueOf(this.fSg);
                        ab.d("MicroMsg.IndoorReporter", "report uin:%s hash:%d config:%d", r3);
                        AppMethodBeat.o(78728);
                        return;
                    }
                }
                g.RQ();
                final boolean z3 = z2;
                final float f3 = f;
                final float f4 = f2;
                final int i3 = i;
                final boolean z4 = z;
                final int i4 = i2;
                g.RS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(78716);
                        try {
                            if (g.RN().QY()) {
                                g.RN();
                                if (!com.tencent.mm.kernel.a.QT()) {
                                    long anU = bo.anU();
                                    if (e.this.startTime == 0 || anU - e.this.startTime >= 1800000) {
                                        List b;
                                        Pair pair;
                                        if (z3) {
                                            b = e.this.fSl;
                                        } else {
                                            Object b2 = e.this.fSm;
                                        }
                                        int i = 0;
                                        while (i < b2.size()) {
                                            if (e.F(f3, ((Float) ((Pair) b2.get(i)).first).floatValue()) && e.F(f4, ((Float) ((Pair) b2.get(i)).second).floatValue())) {
                                                pair = (Pair) b2.get(i);
                                                break;
                                            }
                                            i++;
                                        }
                                        pair = null;
                                        if (pair == null) {
                                            ab.d("MicroMsg.IndoorReporter", "Ignore this report, no hit any Point");
                                            AppMethodBeat.o(78716);
                                            return;
                                        }
                                        int i2;
                                        e.this.startTime = anU;
                                        StringBuilder stringBuilder = new StringBuilder();
                                        g.RN();
                                        final String stringBuilder2 = stringBuilder.append(new p(com.tencent.mm.kernel.a.QF()).toString()).append("_").append(e.this.startTime).toString();
                                        StringBuilder append = new StringBuilder().append(pair.first).append(",").append(pair.second).append(",").append(i3).append(",");
                                        int i3 = z4 ? 1 : 2;
                                        if (z3) {
                                            i2 = 10;
                                        } else {
                                            i2 = 20;
                                        }
                                        final String stringBuilder3 = append.append(i2 + i3).append(",").append(f3).append(",").append(f4).append(",0,").append(i4).append(",").append(e.this.startTime).append(",").toString();
                                        final c cVar = new c();
                                        Context context = ah.getContext();
                                        i3 = e.this.fSi;
                                        int e = e.this.fSk;
                                        if (cVar.bJj == null) {
                                            cVar.bJj = (WifiManager) context.getSystemService("wifi");
                                        }
                                        cVar.fSL = i3;
                                        cVar.fSk = e;
                                        cVar.startTime = bo.anU();
                                        cVar.fSM = true;
                                        cVar.thread.start();
                                        final b bVar = new b();
                                        if (bVar.A(ah.getContext(), e.this.fSj)) {
                                            g.RQ();
                                            new ap(g.RS().oAl.getLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
                                                boolean fSt = false;

                                                public final boolean BI() {
                                                    AppMethodBeat.i(78715);
                                                    boolean eA = o.eA(ah.getContext());
                                                    long anU = bo.anU();
                                                    long a = anU - e.this.startTime;
                                                    if (a <= ((long) e.this.fSh)) {
                                                        if (eA) {
                                                            this.fSt = false;
                                                            AppMethodBeat.o(78715);
                                                            return true;
                                                        } else if (!this.fSt) {
                                                            this.fSt = true;
                                                            AppMethodBeat.o(78715);
                                                            return true;
                                                        }
                                                    }
                                                    ab.i("MicroMsg.IndoorReporter", "Stop Now goingbg:%b fg:%b runtime:%d", Boolean.valueOf(this.fSt), Boolean.valueOf(eA), Long.valueOf(a));
                                                    e.this.startTime = 0;
                                                    String akg = bVar.akg();
                                                    String akg2 = cVar.akg();
                                                    try {
                                                        if (bo.isNullOrNil(akg) || bo.isNullOrNil(akg2)) {
                                                            ab.e("MicroMsg.IndoorReporter", "get Res Failed [%s][%s]", akg, akg2);
                                                            h.pYm.X(13381, stringBuilder3 + stringBuilder2 + (!bo.isNullOrNil(akg) ? ",-10011,ERROR:StopFailed." : ",-10012,ERROR:StopFailed."));
                                                            AppMethodBeat.o(78715);
                                                            return false;
                                                        }
                                                        String str = akg + akg2;
                                                        int ceil = (int) Math.ceil(((double) str.length()) / 5400.0d);
                                                        for (int i = 0; i < ceil; i++) {
                                                            ab.i("MicroMsg.IndoorReporter", "reportKV [%d/%d] res:%d kv:%d [%s]", Integer.valueOf(i), Integer.valueOf(ceil), Integer.valueOf(str.length()), Integer.valueOf((stringBuilder3 + stringBuilder2 + "_" + anU + "_" + ceil + "_" + (a > ((long) e.this.fSh) ? "1" : "2") + "," + (i + 1) + "," + str.substring(i * 5400, Math.min((i + 1) * 5400, str.length()))).length()), stringBuilder3 + stringBuilder2 + "_" + anU + "_" + ceil + "_" + (a > ((long) e.this.fSh) ? "1" : "2") + "," + (i + 1) + "," + str.substring(i * 5400, Math.min((i + 1) * 5400, str.length())));
                                                            h.pYm.X(13381, akg);
                                                        }
                                                        AppMethodBeat.o(78715);
                                                        return false;
                                                    } catch (Exception e) {
                                                        ab.e("MicroMsg.IndoorReporter", "reprot Stop exception:%s", e.getMessage());
                                                    }
                                                }
                                            }, true).ae(3000, 3000);
                                            AppMethodBeat.o(78716);
                                            return;
                                        }
                                        ab.e("MicroMsg.IndoorReporter", "Ignore this report. Error:start wifi:%b sensor:%b  ", Boolean.TRUE, Boolean.valueOf(bVar.A(ah.getContext(), e.this.fSj)));
                                        bVar.akg();
                                        cVar.akg();
                                        h.pYm.X(13381, stringBuilder3 + stringBuilder2 + ",-10002,ERROR:StartFailed.");
                                        AppMethodBeat.o(78716);
                                        return;
                                    }
                                    ab.e("MicroMsg.IndoorReporter", "Ignore this Report,Another Report is Running & not timeout:%d.", Long.valueOf(anU - e.this.startTime));
                                    AppMethodBeat.o(78716);
                                    return;
                                }
                            }
                            AppMethodBeat.o(78716);
                        } catch (Exception e2) {
                            ab.e("MicroMsg.IndoorReporter", "reprot Start exception:%s", e2.getMessage());
                            AppMethodBeat.o(78716);
                        }
                    }
                });
                AppMethodBeat.o(78728);
                return;
            }
        }
        AppMethodBeat.o(78728);
    }

    public final boolean tI(String str) {
        AppMethodBeat.i(78729);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(78729);
            return false;
        }
        try {
            String[] split = str.split(",");
            this.fSg = bo.getInt(split[0], -1);
            if (this.fSg > 101) {
                Assert.assertTrue(false);
            }
            this.fSh = bo.getInt(split[1], i.sHCENCODEVIDEOTIMEOUT);
            this.fSi = bo.getInt(split[2], AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
            this.fSj = bo.getInt(split[3], 1000);
            this.fSk = bo.getInt(split[4], 20);
            int i = bo.getInt(split[5], 0);
            for (int i2 = 0; i2 < i; i2++) {
                String[] split2 = split[i2 + 6].split(";");
                if ("1".equals(split2[0])) {
                    this.fSl.add(new Pair(Float.valueOf(bo.ann(split2[1])), Float.valueOf(bo.ann(split2[2]))));
                } else {
                    this.fSm.add(new Pair(Float.valueOf(bo.ann(split2[1])), Float.valueOf(bo.ann(split2[2]))));
                }
            }
            ab.i("MicroMsg.IndoorReporter", "parseConfig: max:%d wifiFreq:%d sensorFreq:%d maxWifiCount:%d cnt:%d mars:%d earth:%d", Integer.valueOf(this.fSh), Integer.valueOf(this.fSi), Integer.valueOf(this.fSj), Integer.valueOf(this.fSk), Integer.valueOf(i), Integer.valueOf(this.fSl.size()), Integer.valueOf(this.fSm.size()));
            AppMethodBeat.o(78729);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.IndoorReporter", "parseConfig e:%s  [%s]", e.getMessage(), str);
            AppMethodBeat.o(78729);
            return false;
        }
    }

    static /* synthetic */ boolean F(float f, float f2) {
        AppMethodBeat.i(78730);
        if (((double) Math.abs(f - f2)) < Math.pow(0.1d, 2.0d)) {
            AppMethodBeat.o(78730);
            return true;
        }
        AppMethodBeat.o(78730);
        return false;
    }
}
