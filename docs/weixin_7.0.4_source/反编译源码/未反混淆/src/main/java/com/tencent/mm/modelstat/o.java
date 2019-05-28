package com.tencent.mm.modelstat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.compatible.e.y;
import com.tencent.mm.g.a.jm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bpu;
import com.tencent.mm.protocal.protobuf.bpv;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class o {
    private static ap che = new ap(g.RS().oAl.getLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(78770);
            try {
                o.fTS = Long.MAX_VALUE;
                if (o.fTT >= 2000 || o.fTT <= 1000) {
                    o.mi(o.fTT);
                    AppMethodBeat.o(78770);
                    return false;
                }
                o.mh(o.fTT);
                AppMethodBeat.o(78770);
                return false;
            } catch (Exception e) {
                ab.e("MicroMsg.NetTypeReporter", "run :%s", bo.l(e));
            }
        }
    }, false);
    private static final byte[] eMl = new byte[0];
    private static long fTP = 86400000;
    private static HashMap<String, Long> fTQ = new HashMap();
    private static String fTR = null;
    private static long fTS = Long.MAX_VALUE;
    private static int fTT = 0;
    private static long fTU = 0;
    private static long fTV = 0;
    private static float fTW = 0.0f;
    private static float fTX = 0.0f;
    private static int fTY = 0;
    private static int fTZ = 0;
    private static long fUa = 0;
    private static String fUb = "";

    static class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(78772);
            try {
                if (g.RN().QY()) {
                    g.RN();
                    if (!com.tencent.mm.kernel.a.QT()) {
                        if (intent != null) {
                            if (!bo.isNullOrNil(intent.getAction())) {
                                String action = intent.getAction();
                                ab.i("MicroMsg.NetTypeReporter", "onReceive action:%s foreground:%b", action, Boolean.valueOf(b.foreground));
                                if (!b.foreground) {
                                    AppMethodBeat.o(78772);
                                    return;
                                } else if (action.equals("android.net.wifi.supplicant.CONNECTION_CHANGE")) {
                                    o.mg(1001);
                                    AppMethodBeat.o(78772);
                                    return;
                                } else if (action.equals("android.net.wifi.supplicant.STATE_CHANGE")) {
                                    o.mg(1002);
                                    AppMethodBeat.o(78772);
                                    return;
                                } else if (action.equals("android.net.wifi.STATE_CHANGE")) {
                                    o.mg(1003);
                                    AppMethodBeat.o(78772);
                                    return;
                                } else if (action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                                    o.mg(1004);
                                    AppMethodBeat.o(78772);
                                    return;
                                } else if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                                    o.mg(1005);
                                    AppMethodBeat.o(78772);
                                    return;
                                } else {
                                    if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                                        o.mg(1006);
                                        com.tencent.mm.sdk.b.a.xxA.m(new jm());
                                    }
                                    AppMethodBeat.o(78772);
                                    return;
                                }
                            }
                        }
                        String str = "MicroMsg.NetTypeReporter";
                        String str2 = "onReceive %s  ";
                        Object[] objArr = new Object[1];
                        objArr[0] = intent == null ? "intent is null" : "action is null";
                        ab.e(str, str2, objArr);
                        AppMethodBeat.o(78772);
                        return;
                    }
                }
                Object[] objArr2 = new Object[2];
                objArr2[0] = Boolean.valueOf(g.RN().QY());
                g.RN();
                objArr2[1] = Boolean.valueOf(com.tencent.mm.kernel.a.QT());
                ab.e("MicroMsg.NetTypeReporter", "onReceive acc not ready .%b %b", objArr2);
                AppMethodBeat.o(78772);
            } catch (Throwable th) {
                ab.e("MicroMsg.NetTypeReporter", "onReceive : %s", bo.l(th));
                AppMethodBeat.o(78772);
            }
        }
    }

    static /* synthetic */ void mi(int i) {
        AppMethodBeat.i(78785);
        a(i, 0.0f, 0.0f, 0, 0);
        AppMethodBeat.o(78785);
    }

    public static void ce(Context context) {
        AppMethodBeat.i(78773);
        if (context == null) {
            try {
                ab.e("MicroMsg.NetTypeReporter", "registerReceiver ctx == null");
                AppMethodBeat.o(78773);
                return;
            } catch (Throwable th) {
                ab.e("MicroMsg.NetTypeReporter", "registerReceiver : %s", bo.l(th));
                AppMethodBeat.o(78773);
                return;
            }
        }
        a aVar = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.supplicant.CONNECTION_CHANGE");
        intentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(aVar, intentFilter);
        ab.i("MicroMsg.NetTypeReporter", "registerReceiver finish");
        AppMethodBeat.o(78773);
    }

    static {
        AppMethodBeat.i(78786);
        AppMethodBeat.o(78786);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0208 A:{SYNTHETIC, Splitter:B:76:0x0208} */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x020d A:{Catch:{ Exception -> 0x0211 }} */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0229 A:{SYNTHETIC, Splitter:B:85:0x0229} */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x022e A:{Catch:{ Exception -> 0x0235 }} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x014a A:{SYNTHETIC, Splitter:B:40:0x014a} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x014f A:{Catch:{ Exception -> 0x0154 }} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0174 A:{SYNTHETIC, Splitter:B:49:0x0174} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0179 A:{Catch:{ Exception -> 0x0180 }} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x014a A:{SYNTHETIC, Splitter:B:40:0x014a} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x014f A:{Catch:{ Exception -> 0x0154 }} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0208 A:{SYNTHETIC, Splitter:B:76:0x0208} */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x020d A:{Catch:{ Exception -> 0x0211 }} */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0229 A:{SYNTHETIC, Splitter:B:85:0x0229} */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x022e A:{Catch:{ Exception -> 0x0235 }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0174 A:{SYNTHETIC, Splitter:B:49:0x0174} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0179 A:{Catch:{ Exception -> 0x0180 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean i(ArrayList<String> arrayList) {
        ObjectInputStream objectInputStream;
        Throwable e;
        Iterator it;
        boolean z;
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        AppMethodBeat.i(78774);
        if (arrayList.size() == 0) {
            ab.w("MicroMsg.NetTypeReporter", "checkBssidShouldReport no value in list.");
            AppMethodBeat.o(78774);
            return false;
        }
        if (bo.isNullOrNil(fTR)) {
            fTR = g.RP().cachePath + "bssidcache.bin";
        }
        if (fTQ.size() == 0) {
            FileInputStream fileInputStream;
            try {
                if (e.cs(fTR) > 10485760) {
                    e.deleteFile(fTR);
                }
                fileInputStream = new FileInputStream(fTR);
                try {
                    objectInputStream = new ObjectInputStream(new BufferedInputStream(fileInputStream));
                } catch (Exception e2) {
                    e = e2;
                    objectInputStream = null;
                    try {
                        ab.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", bo.l(e));
                        fTQ = new HashMap();
                        if (objectInputStream != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        ab.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport remove size:%d  file:%s", Integer.valueOf(fTQ.size()), fTR);
                        e.deleteFile(fTR);
                        it = arrayList.iterator();
                        z = false;
                        while (it.hasNext()) {
                        }
                        try {
                            fileOutputStream = new FileOutputStream(fTR);
                            try {
                                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                                try {
                                    objectOutputStream.writeObject(fTQ);
                                    fileOutputStream.flush();
                                    ab.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport write file size:%d", Integer.valueOf(fTQ.size()));
                                    try {
                                        objectOutputStream.close();
                                        fileOutputStream.close();
                                    } catch (Exception e3) {
                                        ab.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", bo.l(e3));
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    try {
                                        ab.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", bo.l(e));
                                        if (objectOutputStream != null) {
                                            try {
                                                objectOutputStream.close();
                                            } catch (Exception e32) {
                                                ab.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", bo.l(e32));
                                            }
                                        }
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        AppMethodBeat.o(78774);
                                        return z;
                                    } catch (Throwable th) {
                                        e = th;
                                        if (objectOutputStream != null) {
                                            try {
                                                objectOutputStream.close();
                                            } catch (Exception e5) {
                                                ab.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", bo.l(e5));
                                                AppMethodBeat.o(78774);
                                                throw e;
                                            }
                                        }
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        AppMethodBeat.o(78774);
                                        throw e;
                                    }
                                }
                            } catch (Exception e6) {
                                e = e6;
                                objectOutputStream = null;
                                ab.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", bo.l(e));
                                if (objectOutputStream != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                AppMethodBeat.o(78774);
                                return z;
                            } catch (Throwable th2) {
                                e = th2;
                                objectOutputStream = null;
                                if (objectOutputStream != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                AppMethodBeat.o(78774);
                                throw e;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            objectOutputStream = null;
                            fileOutputStream = null;
                            ab.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", bo.l(e));
                            if (objectOutputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            AppMethodBeat.o(78774);
                            return z;
                        } catch (Throwable th3) {
                            e = th3;
                            objectOutputStream = null;
                            fileOutputStream = null;
                            if (objectOutputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            AppMethodBeat.o(78774);
                            throw e;
                        }
                        AppMethodBeat.o(78774);
                        return z;
                    } catch (Throwable th4) {
                        e = th4;
                        if (objectInputStream != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.o(78774);
                        throw e;
                    }
                } catch (Throwable th5) {
                    e = th5;
                    objectInputStream = null;
                    if (objectInputStream != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    AppMethodBeat.o(78774);
                    throw e;
                }
                try {
                    fTQ = (HashMap) objectInputStream.readObject();
                    ab.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport read file size:%d", Integer.valueOf(fTQ.size()));
                    try {
                        objectInputStream.close();
                        fileInputStream.close();
                    } catch (Exception e322) {
                        ab.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", bo.l(e322));
                        fTQ = new HashMap();
                    }
                } catch (Exception e8) {
                    e = e8;
                    ab.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", bo.l(e));
                    fTQ = new HashMap();
                    if (objectInputStream != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    ab.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport remove size:%d  file:%s", Integer.valueOf(fTQ.size()), fTR);
                    e.deleteFile(fTR);
                    it = arrayList.iterator();
                    z = false;
                    while (it.hasNext()) {
                    }
                    fileOutputStream = new FileOutputStream(fTR);
                    objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    objectOutputStream.writeObject(fTQ);
                    fileOutputStream.flush();
                    ab.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport write file size:%d", Integer.valueOf(fTQ.size()));
                    objectOutputStream.close();
                    fileOutputStream.close();
                    AppMethodBeat.o(78774);
                    return z;
                }
            } catch (Exception e9) {
                e = e9;
                objectInputStream = null;
                fileInputStream = null;
                ab.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", bo.l(e));
                fTQ = new HashMap();
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (Exception e3222) {
                        ab.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", bo.l(e3222));
                        fTQ = new HashMap();
                    }
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                ab.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport remove size:%d  file:%s", Integer.valueOf(fTQ.size()), fTR);
                e.deleteFile(fTR);
                it = arrayList.iterator();
                z = false;
                while (it.hasNext()) {
                }
                fileOutputStream = new FileOutputStream(fTR);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(fTQ);
                fileOutputStream.flush();
                ab.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport write file size:%d", Integer.valueOf(fTQ.size()));
                objectOutputStream.close();
                fileOutputStream.close();
                AppMethodBeat.o(78774);
                return z;
            } catch (Throwable th6) {
                e = th6;
                objectInputStream = null;
                fileInputStream = null;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (Exception e52) {
                        ab.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", bo.l(e52));
                        fTQ = new HashMap();
                        AppMethodBeat.o(78774);
                        throw e;
                    }
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                AppMethodBeat.o(78774);
                throw e;
            }
            if (fTQ.size() <= 0 || fTQ.size() > 1000) {
                ab.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport remove size:%d  file:%s", Integer.valueOf(fTQ.size()), fTR);
                e.deleteFile(fTR);
            }
        }
        it = arrayList.iterator();
        z = false;
        while (it.hasNext()) {
            boolean z2;
            String str = (String) it.next();
            long gb = bo.gb(bo.cE(fTQ.get(str)));
            ab.d("MicroMsg.NetTypeReporter", "checkBssidShouldReport report bssid:%s diff:%d", str, Long.valueOf(gb));
            if (gb <= 0 || gb > fTP) {
                fTQ.put(str, Long.valueOf(bo.anU()));
                z2 = true;
            } else {
                z2 = z;
            }
            z = z2;
        }
        if (z && fTQ.size() > 0) {
            fileOutputStream = new FileOutputStream(fTR);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(fTQ);
            fileOutputStream.flush();
            ab.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport write file size:%d", Integer.valueOf(fTQ.size()));
            objectOutputStream.close();
            fileOutputStream.close();
        }
        AppMethodBeat.o(78774);
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:95:0x044a  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0429  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0498  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0214 A:{Catch:{ Exception -> 0x033f }} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0243 A:{Catch:{ Exception -> 0x048e }} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0429  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x044a  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x044a  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0429  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String[] mf(int i) {
        Throwable e;
        String str;
        String str2;
        TelephonyManager telephonyManager;
        String str3;
        String str4;
        String str5;
        List gJ;
        int i2;
        Throwable e2;
        StringBuilder stringBuilder;
        AppMethodBeat.i(78775);
        ab.i("MicroMsg.NetTypeReporter", "dkNetTypeRead scene:%d fg:%b time:%d diff:%d", Integer.valueOf(i), Boolean.valueOf(b.foreground), Long.valueOf(fTU), Long.valueOf(bo.gb(fTU)));
        if (i <= 0) {
            ab.e("MicroMsg.NetTypeReporter", "ERROR PARAM: scene:%d", Integer.valueOf(i));
            AppMethodBeat.o(78775);
            return null;
        }
        Context context = ah.getContext();
        if (context == null) {
            ab.e("MicroMsg.NetTypeReporter", "ERROR Context is null scene:%d", Integer.valueOf(i));
            AppMethodBeat.o(78775);
            return null;
        }
        int Me;
        ab.i("MicroMsg.NetTypeReporter", "read scene:%d foreground:%b", Integer.valueOf(i), Boolean.valueOf(b.foreground));
        int i3 = 0;
        try {
            Me = y.Me();
        } catch (Exception e3) {
            ab.e("MicroMsg.NetTypeReporter", "getNetType : %s", bo.l(e3));
            Me = i3;
        }
        ab.i("MicroMsg.NetTypeReporter", "get netType :%d", Integer.valueOf(Me));
        String str6 = "";
        String str7 = "";
        String str8 = "";
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            StringBuffer stringBuffer3 = new StringBuffer();
            int i4 = 0;
            ArrayList arrayList = new ArrayList();
            stringBuffer.append(at.gE(ah.getContext()));
            stringBuffer2.append(at.gF(ah.getContext()));
            String gF = at.gF(ah.getContext());
            arrayList.add(gF);
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (scanResults != null) {
                Collections.sort(scanResults, new Comparator<ScanResult>() {
                    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                        return ((ScanResult) obj2).level - ((ScanResult) obj).level;
                    }
                });
                int i5 = 20;
                for (ScanResult scanResult : scanResults) {
                    if (!(scanResult == null || bo.isNullOrNil(scanResult.BSSID))) {
                        if (!scanResult.BSSID.equals(gF)) {
                            int i6 = i5 - 1;
                            if (i5 <= 0) {
                                break;
                            }
                            stringBuffer.append("|");
                            stringBuffer.append(bo.nullAsNil(scanResult.SSID).replace("|", "").replace(" ", ""));
                            stringBuffer2.append("|");
                            stringBuffer2.append(bo.nullAsNil(scanResult.BSSID).replace("|", "").replace(" ", ""));
                            arrayList.add(scanResult.BSSID);
                            stringBuffer3.append("|");
                            stringBuffer3.append(scanResult.level);
                            i5 = i6;
                        } else {
                            i4 = scanResult.level;
                        }
                    }
                }
            }
            i3 = i4;
            if (i >= 2000 || i(arrayList)) {
                String str9;
                str6 = stringBuffer.toString();
                String stringBuffer4 = stringBuffer2.toString();
                try {
                    str8 = i3 + stringBuffer3.toString();
                } catch (Exception e4) {
                    e = e4;
                    str = stringBuffer4;
                    ab.e("MicroMsg.NetTypeReporter", "getWifiInfo : %s", bo.l(e));
                    stringBuffer4 = str;
                    ab.d("MicroMsg.NetTypeReporter", "get wifi :[%s] [%s]", stringBuffer4, str6);
                    str2 = "";
                    telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager == null) {
                    }
                    str2 = str;
                    ab.i("MicroMsg.NetTypeReporter", "get ispName: %s", str2);
                    str3 = "";
                    str4 = "";
                    str5 = "";
                    str = "";
                    str9 = "";
                    gJ = at.gJ(context);
                    i2 = 0;
                    str7 = str;
                    while (i2 < gJ.size()) {
                        try {
                        } catch (Exception e5) {
                            e2 = e5;
                            str = str7;
                            ab.e("MicroMsg.NetTypeReporter", "getNetType : %s", bo.l(e2));
                            ab.d("MicroMsg.NetTypeReporter", "mcc:%s mnc:%s cell:%s", str3, str4, str5);
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(bo.anT()).append(",");
                            stringBuilder.append(i).append(",");
                            stringBuilder.append(Me).append(",");
                            stringBuilder.append(str6.replace(",", " ")).append(",");
                            stringBuilder.append(tJ(stringBuffer4.replace(",", " "))).append(",");
                            stringBuilder.append(str2.replace(",", " ")).append(",");
                            stringBuilder.append(tJ(str3.replace(",", " "))).append(",");
                            stringBuilder.append(tJ(str4.replace(",", " "))).append(",");
                            stringBuilder.append(tJ(str5.replace(",", " "))).append(",");
                            if (ako() >= 0) {
                            }
                        }
                    }
                    str = str7;
                    ab.d("MicroMsg.NetTypeReporter", "mcc:%s mnc:%s cell:%s", str3, str4, str5);
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(bo.anT()).append(",");
                    stringBuilder.append(i).append(",");
                    stringBuilder.append(Me).append(",");
                    stringBuilder.append(str6.replace(",", " ")).append(",");
                    stringBuilder.append(tJ(stringBuffer4.replace(",", " "))).append(",");
                    stringBuilder.append(str2.replace(",", " ")).append(",");
                    stringBuilder.append(tJ(str3.replace(",", " "))).append(",");
                    stringBuilder.append(tJ(str4.replace(",", " "))).append(",");
                    stringBuilder.append(tJ(str5.replace(",", " "))).append(",");
                    if (ako() >= 0) {
                    }
                }
                ab.d("MicroMsg.NetTypeReporter", "get wifi :[%s] [%s]", stringBuffer4, str6);
                str2 = "";
                try {
                    telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager == null) {
                        str = telephonyManager.getNetworkOperatorName();
                    } else {
                        str = str2;
                    }
                    str2 = str;
                } catch (Exception e6) {
                    ab.e("MicroMsg.NetTypeReporter", "getNetType : %s", bo.l(e6));
                }
                ab.i("MicroMsg.NetTypeReporter", "get ispName: %s", str2);
                str3 = "";
                str4 = "";
                str5 = "";
                str = "";
                str9 = "";
                try {
                    gJ = at.gJ(context);
                    i2 = 0;
                    str7 = str;
                    while (i2 < gJ.size()) {
                        String str10;
                        com.tencent.mm.sdk.platformtools.at.a aVar = (com.tencent.mm.sdk.platformtools.at.a) gJ.get(i2);
                        str3 = bo.bc(aVar.org, "");
                        str4 = bo.bc(aVar.orh, "");
                        if (str5.length() > 0 && !bo.isNullOrNil(aVar.ori)) {
                            str5 = str5 + "|";
                        }
                        if (!bo.isNullOrNil(aVar.ori)) {
                            str5 = str5 + aVar.ori;
                        }
                        if (str7.length() <= 0 || bo.isNullOrNil(aVar.tzp)) {
                            str10 = str7;
                        } else {
                            str10 = str7 + "|";
                        }
                        try {
                            if (!bo.isNullOrNil(aVar.tzp)) {
                                str10 = str10 + aVar.tzp;
                            }
                            if (str9.length() > 0) {
                                str9 = str9 + "|";
                            }
                            stringBuilder = new StringBuilder().append(str9);
                            if (bo.isNullOrNil(aVar.tzt)) {
                                str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                            } else {
                                str = aVar.tzt;
                            }
                            str9 = stringBuilder.append(str).toString();
                            i2++;
                            str7 = str10;
                        } catch (Exception e7) {
                            e2 = e7;
                            str = str10;
                        }
                    }
                    str = str7;
                } catch (Exception e72) {
                    e2 = e72;
                    ab.e("MicroMsg.NetTypeReporter", "getNetType : %s", bo.l(e2));
                    ab.d("MicroMsg.NetTypeReporter", "mcc:%s mnc:%s cell:%s", str3, str4, str5);
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(bo.anT()).append(",");
                    stringBuilder.append(i).append(",");
                    stringBuilder.append(Me).append(",");
                    stringBuilder.append(str6.replace(",", " ")).append(",");
                    stringBuilder.append(tJ(stringBuffer4.replace(",", " "))).append(",");
                    stringBuilder.append(str2.replace(",", " ")).append(",");
                    stringBuilder.append(tJ(str3.replace(",", " "))).append(",");
                    stringBuilder.append(tJ(str4.replace(",", " "))).append(",");
                    stringBuilder.append(tJ(str5.replace(",", " "))).append(",");
                    if (ako() >= 0) {
                    }
                }
                ab.d("MicroMsg.NetTypeReporter", "mcc:%s mnc:%s cell:%s", str3, str4, str5);
                stringBuilder = new StringBuilder();
                stringBuilder.append(bo.anT()).append(",");
                stringBuilder.append(i).append(",");
                stringBuilder.append(Me).append(",");
                stringBuilder.append(str6.replace(",", " ")).append(",");
                stringBuilder.append(tJ(stringBuffer4.replace(",", " "))).append(",");
                stringBuilder.append(str2.replace(",", " ")).append(",");
                stringBuilder.append(tJ(str3.replace(",", " "))).append(",");
                stringBuilder.append(tJ(str4.replace(",", " "))).append(",");
                stringBuilder.append(tJ(str5.replace(",", " "))).append(",");
                if (ako() >= 0) {
                    AppMethodBeat.o(78775);
                    return null;
                }
                String[] strArr = new String[]{ako() + "," + stringBuilder.toString(), tJ(str8), tJ(str), tJ(str9)};
                AppMethodBeat.o(78775);
                return strArr;
            }
            ab.w("MicroMsg.NetTypeReporter", "checkBssid: find all report already  , give up. scene:%d ", Integer.valueOf(i));
            AppMethodBeat.o(78775);
            return null;
        } catch (Exception e8) {
            e = e8;
            str = str7;
        }
    }

    private static String tJ(String str) {
        AppMethodBeat.i(78776);
        if (TextUtils.isEmpty(str)) {
            str = "";
            AppMethodBeat.o(78776);
            return str;
        }
        for (char c : str.toCharArray()) {
            if ((c < 'a' || c > 'z') && ((c < 'A' || c > 'Z') && !((c >= '0' && c <= '9') || c == '|' || c == '-' || c == ' ' || c == ':'))) {
                str = "";
                AppMethodBeat.o(78776);
                return str;
            }
        }
        AppMethodBeat.o(78776);
        return str;
    }

    private static long ako() {
        String a;
        AppMethodBeat.i(78777);
        synchronized (eMl) {
            long a2;
            try {
                a = bo.a((Long) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_REPORTNETTYPE_SEQ_LONG, null), 1);
                g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_REPORTNETTYPE_SEQ_LONG, Long.valueOf(1 + a));
                g.RP().Ry().dsb();
                a2 = bo.a((Long) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_REPORTNETTYPE_SEQ_LONG, null), 1);
                Object[] objArr = new Object[2];
                objArr[0] = Long.valueOf(a);
                a2 = Long.valueOf(a2);
                objArr[1] = a2;
                ab.i("MicroMsg.NetTypeReporter", "incSeq after write  old:%d new:%d", objArr);
            } catch (Exception e) {
                a = "incSeq :%s";
                ab.e("MicroMsg.NetTypeReporter", a, bo.l(e));
                a2 = -1;
                return a2;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(78777);
            }
        }
        return a;
    }

    private static void a(int i, float f, float f2, int i2, long j) {
        AppMethodBeat.i(78778);
        long anU = bo.anU();
        if (fTU <= 0 || anU - fTU <= 5000) {
            final String[] mf = mf(i);
            if (mf == null || mf.length != 4 || bo.isNullOrNil(mf[0])) {
                ab.e("MicroMsg.NetTypeReporter", "report get failed val");
                AppMethodBeat.o(78778);
                return;
            }
            ab.d("MicroMsg.NetTypeReporter", "report scene:%d time:%d lon:%f lat:%f pre:%d scanuse:%d [%s]", Integer.valueOf(i), Long.valueOf(bo.gb(anU)), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2), Long.valueOf(j), mf[0]);
            com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
            aVar.fsJ = new bpu();
            aVar.fsK = new bpv();
            aVar.uri = "/cgi-bin/micromsg-bin/rtkvreport";
            aVar.fsI = 716;
            com.tencent.mm.ai.b acD = aVar.acD();
            final bpu bpu = (bpu) acD.fsG.fsP;
            bpu.vOz = d.vxj;
            bpu.vOA = d.vxi;
            bpu.vOB = d.vxl;
            bpu.vOC = d.vxm;
            bpu.vOD = aa.dor();
            bpu.wBd = 11747;
            anU = bo.gb(fTU);
            if (anU > 600000 || anU < 0) {
                anU = 0;
            }
            bpu.pXM = mf[0] + "0," + f + "," + f2 + "," + i2 + "," + j + "," + (b.foreground ? "1" : String.valueOf(anU)) + "," + mf[1] + "," + mf[2] + "," + mf[3];
            final long anU2 = bo.anU();
            final float f3 = f;
            final float f4 = f2;
            final int i3 = i2;
            final long j2 = j;
            w.a(acD, new com.tencent.mm.ai.w.a() {
                public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                    AppMethodBeat.i(78768);
                    ab.d("MicroMsg.NetTypeReporter", "onGYNetEnd errType:%d errCode:%d msg:%s  %d val:%s ", Integer.valueOf(i), Integer.valueOf(i2), str, Long.valueOf(bo.gb(anU2)), bpu.pXM);
                    if (!(i == 0 && i2 == 0)) {
                        long gb = bo.gb(o.fTU);
                        if (gb > 600000 || gb < 0) {
                            gb = 0;
                        }
                        h.pYm.X(11747, mf[0] + "1," + f3 + "," + f4 + "," + i3 + "," + j2 + "," + (b.foreground ? "1" : String.valueOf(gb)) + "," + mf[1] + "," + mf[2] + "," + mf[3]);
                    }
                    g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_REPORTNETTYPE_LASTREPORT_LONG, Long.valueOf(bo.anU()));
                    AppMethodBeat.o(78768);
                    return 0;
                }
            }, true);
            AppMethodBeat.o(78778);
            return;
        }
        ab.e("MicroMsg.NetTypeReporter", "never  report  at  background :%d diff:%d", Long.valueOf(fTU), Long.valueOf(anU - fTU));
        AppMethodBeat.o(78778);
    }

    public static void y(int i, String str) {
        AppMethodBeat.i(78779);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new bpu();
        aVar.fsK = new bpv();
        aVar.uri = "/cgi-bin/micromsg-bin/rtkvreport";
        aVar.fsI = 716;
        com.tencent.mm.ai.b acD = aVar.acD();
        final bpu bpu = (bpu) acD.fsG.fsP;
        bpu.vOz = d.vxj;
        bpu.vOA = d.vxi;
        bpu.vOB = d.vxl;
        bpu.vOC = d.vxm;
        bpu.vOD = aa.dor();
        bpu.wBd = i;
        bpu.pXM = str;
        ab.i("MicroMsg.NetTypeReporter", "reportCgi logId:%d, value:%s", Integer.valueOf(i), str);
        final long anU = bo.anU();
        w.a(acD, new com.tencent.mm.ai.w.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                AppMethodBeat.i(78769);
                ab.d("MicroMsg.NetTypeReporter", "onGYNetEnd errType:%d errCode:%d msg:%s  %d val:%s ", Integer.valueOf(i), Integer.valueOf(i2), str, Long.valueOf(bo.gb(anU)), bpu.pXM);
                AppMethodBeat.o(78769);
                return 0;
            }
        });
        AppMethodBeat.o(78779);
    }

    private static void b(int i, float f, float f2, int i2, long j) {
        AppMethodBeat.i(78780);
        try {
            ab.i("MicroMsg.NetTypeReporter", "checkTimeReport scene:%d diff:%d  time:%d", Integer.valueOf(i), Long.valueOf(bo.gb(fTS)), Long.valueOf(fTS));
            if (i > 2000 || bo.gb(fTS) > 300000) {
                ab.i("MicroMsg.NetTypeReporter", "force Run, scene:%d diff:%d time:%d ", Integer.valueOf(i), Long.valueOf(bo.gb(fTS)), Long.valueOf(fTS));
                fTT = i;
                fTS = Long.MAX_VALUE;
                a(i, f, f2, i2, j);
                AppMethodBeat.o(78780);
                return;
            }
            if (fTS == Long.MAX_VALUE) {
                fTS = bo.anU() + 60000;
            }
            fTT = i;
            che.ae(60000, 60000);
            AppMethodBeat.o(78780);
        } catch (Throwable th) {
            ab.e("MicroMsg.NetTypeReporter", "checkTimeReport error: %s", bo.l(th));
            AppMethodBeat.o(78780);
        }
    }

    public static void cT(boolean z) {
        AppMethodBeat.i(78781);
        if (z) {
            fTU = 0;
            AppMethodBeat.o(78781);
        } else if (che.doT()) {
            AppMethodBeat.o(78781);
        } else {
            ab.i("MicroMsg.NetTypeReporter", "setToForeground user turn to background run report now");
            fTU = bo.anU();
            che.ae(0, 0);
            AppMethodBeat.o(78781);
        }
    }

    public static synchronized void a(int i, float f, float f2, int i2) {
        synchronized (o.class) {
            AppMethodBeat.i(78782);
            if (i < 2000 || f == 0.0f || f2 == 0.0f) {
                ab.e("MicroMsg.NetTypeReporter", "reportGps, invalid args, scene = %d, lon = %f, lat = %f, pre = %d", Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2));
                AppMethodBeat.o(78782);
            } else if (bo.gb(fUa) < 60000) {
                ab.e("MicroMsg.NetTypeReporter", "reportGps, hit lastReportGpsLimit, request dropped, scene = %d, lon = %f, lat = %f, pre = %d", Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2));
                AppMethodBeat.o(78782);
            } else {
                ab.i("MicroMsg.NetTypeReporter", "reportGps scene:%d lon:%f lat:%f pre:%d last:%d", Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2), Long.valueOf(bo.gb(fUa)));
                fUa = bo.anU();
                fTZ = i;
                fTV = bo.anU();
                fTY = i2;
                fTW = f2;
                fTX = f;
                try {
                    ((WifiManager) ah.getContext().getSystemService("wifi")).startScan();
                    g.RS().m(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(78771);
                            o.mg(1005);
                            AppMethodBeat.o(78771);
                        }
                    }, 5000);
                    AppMethodBeat.o(78782);
                } catch (Exception e) {
                    ab.e("MicroMsg.NetTypeReporter", "reportGps :%s", bo.l(e));
                    AppMethodBeat.o(78782);
                }
            }
        }
    }

    public static synchronized void mg(int i) {
        synchronized (o.class) {
            AppMethodBeat.i(78783);
            ab.i("MicroMsg.NetTypeReporter", "run scene:%d foreground:%b lastGpsTime:%d lastbssid:%s", Integer.valueOf(i), Boolean.valueOf(b.foreground), Long.valueOf(fTV), fUb);
            if (i == 1005) {
                try {
                    if (fTV > 0) {
                        ab.d("MicroMsg.NetTypeReporter", "report gps scene:%d lastscene:%d [%f,%f,%d] lastGpsTime", Integer.valueOf(i), Integer.valueOf(fTZ), Float.valueOf(fTX), Float.valueOf(fTW), Integer.valueOf(fTY), Long.valueOf(fTV));
                        long gb = bo.gb(fTV);
                        int i2 = fTZ;
                        float f = fTW;
                        float f2 = fTX;
                        int i3 = fTY;
                        fTV = 0;
                        fTW = 0.0f;
                        fTX = 0.0f;
                        fTY = 0;
                        fTZ = 0;
                        b(i2, f2, f, i3, gb);
                        AppMethodBeat.o(78783);
                    }
                } catch (Throwable th) {
                    ab.e("MicroMsg.NetTypeReporter", "run :%s", bo.l(th));
                    AppMethodBeat.o(78783);
                }
            }
            if (!b.foreground) {
                ab.w("MicroMsg.NetTypeReporter", "run is not foreground give up %d ", Integer.valueOf(i));
                AppMethodBeat.o(78783);
            } else if (i == 3) {
                String bssid = ((WifiManager) ah.getContext().getSystemService("wifi")).getConnectionInfo().getBSSID();
                ab.d("MicroMsg.NetTypeReporter", "run scene:%d SCENE_TO_FOREGROUND_BSSID_CHANGE %s %s ", Integer.valueOf(i), bssid, fUb);
                if (!(bo.isNullOrNil(bssid) || bssid.equals(fUb))) {
                    fUb = bssid;
                    b(i, 0.0f, 0.0f, 0, 0);
                }
                AppMethodBeat.o(78783);
            } else if (i == 4) {
                ab.i("MicroMsg.NetTypeReporter", "run scene:%d SCENE_TO_FOREGROUND_TIMEOUT  diff:%d", Integer.valueOf(i), Long.valueOf(bo.gb(bo.a((Long) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_REPORTNETTYPE_LASTREPORT_LONG, null), 0))));
                if (bo.gb(bo.a((Long) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_REPORTNETTYPE_LASTREPORT_LONG, null), 0)) >= 21600000) {
                    b(i, 0.0f, 0.0f, 0, 0);
                }
                AppMethodBeat.o(78783);
            } else {
                b(i, 0.0f, 0.0f, 0, 0);
                AppMethodBeat.o(78783);
            }
        }
    }

    static /* synthetic */ void mh(int i) {
        AppMethodBeat.i(78784);
        long anU = bo.anU();
        if (fTU <= 0 || anU - fTU <= 5000) {
            String[] mf = mf(i);
            if (mf == null || mf.length != 4 || bo.isNullOrNil(mf[0])) {
                ab.e("MicroMsg.NetTypeReporter", "report get failed val");
                AppMethodBeat.o(78784);
                return;
            }
            ab.d("MicroMsg.NetTypeReporter", "report scene:%d time:%d lon:%f lat:%f pre:%d scanuse:%d [%s]", Integer.valueOf(i), Long.valueOf(bo.gb(anU)), Float.valueOf(0.0f), Float.valueOf(0.0f), Integer.valueOf(0), Long.valueOf(0), mf[0]);
            anU = bo.gb(fTU);
            if (anU > 600000 || anU < 0) {
                anU = 0;
            }
            h.pYm.X(11747, mf[0] + "1,0.0,0.0,0,0," + (b.foreground ? "1" : String.valueOf(anU)) + "," + mf[1] + "," + mf[2] + "," + mf[3]);
            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_REPORTNETTYPE_LASTREPORT_LONG, Long.valueOf(bo.anU()));
            AppMethodBeat.o(78784);
            return;
        }
        ab.e("MicroMsg.NetTypeReporter", "never  report (reportKV) at  background :%d diff:%d", Long.valueOf(fTU), Long.valueOf(anU - fTU));
        AppMethodBeat.o(78784);
    }
}
