package com.tencent.p177mm.modelstat;

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
import com.tencent.p177mm.compatible.p221e.C18172y;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p230g.p231a.C9391jm;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.bpu;
import com.tencent.p177mm.protocal.protobuf.bpv;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5023at.C5022a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C5128ac.C5127a;
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

/* renamed from: com.tencent.mm.modelstat.o */
public final class C18698o {
    private static C7564ap che = new C7564ap(C1720g.m3539RS().oAl.getLooper(), new C187024(), false);
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

    /* renamed from: com.tencent.mm.modelstat.o$a */
    static class C1875a extends BroadcastReceiver {
        private C1875a() {
        }

        /* synthetic */ C1875a(byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(78772);
            try {
                if (C1720g.m3534RN().mo5161QY()) {
                    C1720g.m3534RN();
                    if (!C1668a.m3393QT()) {
                        if (intent != null) {
                            if (!C5046bo.isNullOrNil(intent.getAction())) {
                                String action = intent.getAction();
                                C4990ab.m7417i("MicroMsg.NetTypeReporter", "onReceive action:%s foreground:%b", action, Boolean.valueOf(C4872b.foreground));
                                if (!C4872b.foreground) {
                                    AppMethodBeat.m2505o(78772);
                                    return;
                                } else if (action.equals("android.net.wifi.supplicant.CONNECTION_CHANGE")) {
                                    C18698o.m29229mg(1001);
                                    AppMethodBeat.m2505o(78772);
                                    return;
                                } else if (action.equals("android.net.wifi.supplicant.STATE_CHANGE")) {
                                    C18698o.m29229mg(1002);
                                    AppMethodBeat.m2505o(78772);
                                    return;
                                } else if (action.equals("android.net.wifi.STATE_CHANGE")) {
                                    C18698o.m29229mg(1003);
                                    AppMethodBeat.m2505o(78772);
                                    return;
                                } else if (action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                                    C18698o.m29229mg(1004);
                                    AppMethodBeat.m2505o(78772);
                                    return;
                                } else if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                                    C18698o.m29229mg(1005);
                                    AppMethodBeat.m2505o(78772);
                                    return;
                                } else {
                                    if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                                        C18698o.m29229mg(1006);
                                        C4879a.xxA.mo10055m(new C9391jm());
                                    }
                                    AppMethodBeat.m2505o(78772);
                                    return;
                                }
                            }
                        }
                        String str = "MicroMsg.NetTypeReporter";
                        String str2 = "onReceive %s  ";
                        Object[] objArr = new Object[1];
                        objArr[0] = intent == null ? "intent is null" : "action is null";
                        C4990ab.m7413e(str, str2, objArr);
                        AppMethodBeat.m2505o(78772);
                        return;
                    }
                }
                Object[] objArr2 = new Object[2];
                objArr2[0] = Boolean.valueOf(C1720g.m3534RN().mo5161QY());
                C1720g.m3534RN();
                objArr2[1] = Boolean.valueOf(C1668a.m3393QT());
                C4990ab.m7413e("MicroMsg.NetTypeReporter", "onReceive acc not ready .%b %b", objArr2);
                AppMethodBeat.m2505o(78772);
            } catch (Throwable th) {
                C4990ab.m7413e("MicroMsg.NetTypeReporter", "onReceive : %s", C5046bo.m7574l(th));
                AppMethodBeat.m2505o(78772);
            }
        }
    }

    /* renamed from: com.tencent.mm.modelstat.o$1 */
    static class C186991 implements Comparator<ScanResult> {
        C186991() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((ScanResult) obj2).level - ((ScanResult) obj).level;
        }
    }

    /* renamed from: com.tencent.mm.modelstat.o$4 */
    static class C187024 implements C5015a {
        C187024() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(78770);
            try {
                C18698o.fTS = Long.MAX_VALUE;
                if (C18698o.fTT >= 2000 || C18698o.fTT <= 1000) {
                    C18698o.m29231mi(C18698o.fTT);
                    AppMethodBeat.m2505o(78770);
                    return false;
                }
                C18698o.m29230mh(C18698o.fTT);
                AppMethodBeat.m2505o(78770);
                return false;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.NetTypeReporter", "run :%s", C5046bo.m7574l(e));
            }
        }
    }

    /* renamed from: com.tencent.mm.modelstat.o$5 */
    static class C187035 implements Runnable {
        C187035() {
        }

        public final void run() {
            AppMethodBeat.m2504i(78771);
            C18698o.m29229mg(1005);
            AppMethodBeat.m2505o(78771);
        }
    }

    /* renamed from: mi */
    static /* synthetic */ void m29231mi(int i) {
        AppMethodBeat.m2504i(78785);
        C18698o.m29223a(i, 0.0f, 0.0f, 0, 0);
        AppMethodBeat.m2505o(78785);
    }

    /* renamed from: ce */
    public static void m29226ce(Context context) {
        AppMethodBeat.m2504i(78773);
        if (context == null) {
            try {
                C4990ab.m7412e("MicroMsg.NetTypeReporter", "registerReceiver ctx == null");
                AppMethodBeat.m2505o(78773);
                return;
            } catch (Throwable th) {
                C4990ab.m7413e("MicroMsg.NetTypeReporter", "registerReceiver : %s", C5046bo.m7574l(th));
                AppMethodBeat.m2505o(78773);
                return;
            }
        }
        C1875a c1875a = new C1875a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.supplicant.CONNECTION_CHANGE");
        intentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(c1875a, intentFilter);
        C4990ab.m7416i("MicroMsg.NetTypeReporter", "registerReceiver finish");
        AppMethodBeat.m2505o(78773);
    }

    static {
        AppMethodBeat.m2504i(78786);
        AppMethodBeat.m2505o(78786);
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
    /* renamed from: i */
    private static boolean m29227i(ArrayList<String> arrayList) {
        ObjectInputStream objectInputStream;
        Throwable e;
        Iterator it;
        boolean z;
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        AppMethodBeat.m2504i(78774);
        if (arrayList.size() == 0) {
            C4990ab.m7420w("MicroMsg.NetTypeReporter", "checkBssidShouldReport no value in list.");
            AppMethodBeat.m2505o(78774);
            return false;
        }
        if (C5046bo.isNullOrNil(fTR)) {
            fTR = C1720g.m3536RP().cachePath + "bssidcache.bin";
        }
        if (fTQ.size() == 0) {
            FileInputStream fileInputStream;
            try {
                if (C1173e.m2560cs(fTR) > 10485760) {
                    C1173e.deleteFile(fTR);
                }
                fileInputStream = new FileInputStream(fTR);
                try {
                    objectInputStream = new ObjectInputStream(new BufferedInputStream(fileInputStream));
                } catch (Exception e2) {
                    e = e2;
                    objectInputStream = null;
                    try {
                        C4990ab.m7413e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", C5046bo.m7574l(e));
                        fTQ = new HashMap();
                        if (objectInputStream != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        C4990ab.m7417i("MicroMsg.NetTypeReporter", "checkBssidShouldReport remove size:%d  file:%s", Integer.valueOf(fTQ.size()), fTR);
                        C1173e.deleteFile(fTR);
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
                                    C4990ab.m7417i("MicroMsg.NetTypeReporter", "checkBssidShouldReport write file size:%d", Integer.valueOf(fTQ.size()));
                                    try {
                                        objectOutputStream.close();
                                        fileOutputStream.close();
                                    } catch (Exception e3) {
                                        C4990ab.m7413e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", C5046bo.m7574l(e3));
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    try {
                                        C4990ab.m7413e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", C5046bo.m7574l(e));
                                        if (objectOutputStream != null) {
                                            try {
                                                objectOutputStream.close();
                                            } catch (Exception e32) {
                                                C4990ab.m7413e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", C5046bo.m7574l(e32));
                                            }
                                        }
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        AppMethodBeat.m2505o(78774);
                                        return z;
                                    } catch (Throwable th) {
                                        e = th;
                                        if (objectOutputStream != null) {
                                            try {
                                                objectOutputStream.close();
                                            } catch (Exception e5) {
                                                C4990ab.m7413e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", C5046bo.m7574l(e5));
                                                AppMethodBeat.m2505o(78774);
                                                throw e;
                                            }
                                        }
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        AppMethodBeat.m2505o(78774);
                                        throw e;
                                    }
                                }
                            } catch (Exception e6) {
                                e = e6;
                                objectOutputStream = null;
                                C4990ab.m7413e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", C5046bo.m7574l(e));
                                if (objectOutputStream != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                AppMethodBeat.m2505o(78774);
                                return z;
                            } catch (Throwable th2) {
                                e = th2;
                                objectOutputStream = null;
                                if (objectOutputStream != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                AppMethodBeat.m2505o(78774);
                                throw e;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            objectOutputStream = null;
                            fileOutputStream = null;
                            C4990ab.m7413e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", C5046bo.m7574l(e));
                            if (objectOutputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            AppMethodBeat.m2505o(78774);
                            return z;
                        } catch (Throwable th3) {
                            e = th3;
                            objectOutputStream = null;
                            fileOutputStream = null;
                            if (objectOutputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            AppMethodBeat.m2505o(78774);
                            throw e;
                        }
                        AppMethodBeat.m2505o(78774);
                        return z;
                    } catch (Throwable th4) {
                        e = th4;
                        if (objectInputStream != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.m2505o(78774);
                        throw e;
                    }
                } catch (Throwable th5) {
                    e = th5;
                    objectInputStream = null;
                    if (objectInputStream != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    AppMethodBeat.m2505o(78774);
                    throw e;
                }
                try {
                    fTQ = (HashMap) objectInputStream.readObject();
                    C4990ab.m7417i("MicroMsg.NetTypeReporter", "checkBssidShouldReport read file size:%d", Integer.valueOf(fTQ.size()));
                    try {
                        objectInputStream.close();
                        fileInputStream.close();
                    } catch (Exception e322) {
                        C4990ab.m7413e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", C5046bo.m7574l(e322));
                        fTQ = new HashMap();
                    }
                } catch (Exception e8) {
                    e = e8;
                    C4990ab.m7413e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", C5046bo.m7574l(e));
                    fTQ = new HashMap();
                    if (objectInputStream != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    C4990ab.m7417i("MicroMsg.NetTypeReporter", "checkBssidShouldReport remove size:%d  file:%s", Integer.valueOf(fTQ.size()), fTR);
                    C1173e.deleteFile(fTR);
                    it = arrayList.iterator();
                    z = false;
                    while (it.hasNext()) {
                    }
                    fileOutputStream = new FileOutputStream(fTR);
                    objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    objectOutputStream.writeObject(fTQ);
                    fileOutputStream.flush();
                    C4990ab.m7417i("MicroMsg.NetTypeReporter", "checkBssidShouldReport write file size:%d", Integer.valueOf(fTQ.size()));
                    objectOutputStream.close();
                    fileOutputStream.close();
                    AppMethodBeat.m2505o(78774);
                    return z;
                }
            } catch (Exception e9) {
                e = e9;
                objectInputStream = null;
                fileInputStream = null;
                C4990ab.m7413e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", C5046bo.m7574l(e));
                fTQ = new HashMap();
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (Exception e3222) {
                        C4990ab.m7413e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", C5046bo.m7574l(e3222));
                        fTQ = new HashMap();
                    }
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                C4990ab.m7417i("MicroMsg.NetTypeReporter", "checkBssidShouldReport remove size:%d  file:%s", Integer.valueOf(fTQ.size()), fTR);
                C1173e.deleteFile(fTR);
                it = arrayList.iterator();
                z = false;
                while (it.hasNext()) {
                }
                fileOutputStream = new FileOutputStream(fTR);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(fTQ);
                fileOutputStream.flush();
                C4990ab.m7417i("MicroMsg.NetTypeReporter", "checkBssidShouldReport write file size:%d", Integer.valueOf(fTQ.size()));
                objectOutputStream.close();
                fileOutputStream.close();
                AppMethodBeat.m2505o(78774);
                return z;
            } catch (Throwable th6) {
                e = th6;
                objectInputStream = null;
                fileInputStream = null;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (Exception e52) {
                        C4990ab.m7413e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", C5046bo.m7574l(e52));
                        fTQ = new HashMap();
                        AppMethodBeat.m2505o(78774);
                        throw e;
                    }
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                AppMethodBeat.m2505o(78774);
                throw e;
            }
            if (fTQ.size() <= 0 || fTQ.size() > 1000) {
                C4990ab.m7417i("MicroMsg.NetTypeReporter", "checkBssidShouldReport remove size:%d  file:%s", Integer.valueOf(fTQ.size()), fTR);
                C1173e.deleteFile(fTR);
            }
        }
        it = arrayList.iterator();
        z = false;
        while (it.hasNext()) {
            boolean z2;
            String str = (String) it.next();
            long gb = C5046bo.m7566gb(C5046bo.m7538cE(fTQ.get(str)));
            C4990ab.m7411d("MicroMsg.NetTypeReporter", "checkBssidShouldReport report bssid:%s diff:%d", str, Long.valueOf(gb));
            if (gb <= 0 || gb > fTP) {
                fTQ.put(str, Long.valueOf(C5046bo.anU()));
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
            C4990ab.m7417i("MicroMsg.NetTypeReporter", "checkBssidShouldReport write file size:%d", Integer.valueOf(fTQ.size()));
            objectOutputStream.close();
            fileOutputStream.close();
        }
        AppMethodBeat.m2505o(78774);
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
    /* renamed from: mf */
    private static String[] m29228mf(int i) {
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
        AppMethodBeat.m2504i(78775);
        C4990ab.m7417i("MicroMsg.NetTypeReporter", "dkNetTypeRead scene:%d fg:%b time:%d diff:%d", Integer.valueOf(i), Boolean.valueOf(C4872b.foreground), Long.valueOf(fTU), Long.valueOf(C5046bo.m7566gb(fTU)));
        if (i <= 0) {
            C4990ab.m7413e("MicroMsg.NetTypeReporter", "ERROR PARAM: scene:%d", Integer.valueOf(i));
            AppMethodBeat.m2505o(78775);
            return null;
        }
        Context context = C4996ah.getContext();
        if (context == null) {
            C4990ab.m7413e("MicroMsg.NetTypeReporter", "ERROR Context is null scene:%d", Integer.valueOf(i));
            AppMethodBeat.m2505o(78775);
            return null;
        }
        int Me;
        C4990ab.m7417i("MicroMsg.NetTypeReporter", "read scene:%d foreground:%b", Integer.valueOf(i), Boolean.valueOf(C4872b.foreground));
        int i3 = 0;
        try {
            Me = C18172y.m28611Me();
        } catch (Exception e3) {
            C4990ab.m7413e("MicroMsg.NetTypeReporter", "getNetType : %s", C5046bo.m7574l(e3));
            Me = i3;
        }
        C4990ab.m7417i("MicroMsg.NetTypeReporter", "get netType :%d", Integer.valueOf(Me));
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
            stringBuffer.append(C5023at.m7474gE(C4996ah.getContext()));
            stringBuffer2.append(C5023at.m7475gF(C4996ah.getContext()));
            String gF = C5023at.m7475gF(C4996ah.getContext());
            arrayList.add(gF);
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (scanResults != null) {
                Collections.sort(scanResults, new C186991());
                int i5 = 20;
                for (ScanResult scanResult : scanResults) {
                    if (!(scanResult == null || C5046bo.isNullOrNil(scanResult.BSSID))) {
                        if (!scanResult.BSSID.equals(gF)) {
                            int i6 = i5 - 1;
                            if (i5 <= 0) {
                                break;
                            }
                            stringBuffer.append("|");
                            stringBuffer.append(C5046bo.nullAsNil(scanResult.SSID).replace("|", "").replace(" ", ""));
                            stringBuffer2.append("|");
                            stringBuffer2.append(C5046bo.nullAsNil(scanResult.BSSID).replace("|", "").replace(" ", ""));
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
            if (i >= 2000 || C18698o.m29227i(arrayList)) {
                String str9;
                str6 = stringBuffer.toString();
                String stringBuffer4 = stringBuffer2.toString();
                try {
                    str8 = i3 + stringBuffer3.toString();
                } catch (Exception e4) {
                    e = e4;
                    str = stringBuffer4;
                    C4990ab.m7413e("MicroMsg.NetTypeReporter", "getWifiInfo : %s", C5046bo.m7574l(e));
                    stringBuffer4 = str;
                    C4990ab.m7411d("MicroMsg.NetTypeReporter", "get wifi :[%s] [%s]", stringBuffer4, str6);
                    str2 = "";
                    telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager == null) {
                    }
                    str2 = str;
                    C4990ab.m7417i("MicroMsg.NetTypeReporter", "get ispName: %s", str2);
                    str3 = "";
                    str4 = "";
                    str5 = "";
                    str = "";
                    str9 = "";
                    gJ = C5023at.m7479gJ(context);
                    i2 = 0;
                    str7 = str;
                    while (i2 < gJ.size()) {
                        try {
                        } catch (Exception e5) {
                            e2 = e5;
                            str = str7;
                            C4990ab.m7413e("MicroMsg.NetTypeReporter", "getNetType : %s", C5046bo.m7574l(e2));
                            C4990ab.m7411d("MicroMsg.NetTypeReporter", "mcc:%s mnc:%s cell:%s", str3, str4, str5);
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(C5046bo.anT()).append(",");
                            stringBuilder.append(i).append(",");
                            stringBuilder.append(Me).append(",");
                            stringBuilder.append(str6.replace(",", " ")).append(",");
                            stringBuilder.append(C18698o.m29232tJ(stringBuffer4.replace(",", " "))).append(",");
                            stringBuilder.append(str2.replace(",", " ")).append(",");
                            stringBuilder.append(C18698o.m29232tJ(str3.replace(",", " "))).append(",");
                            stringBuilder.append(C18698o.m29232tJ(str4.replace(",", " "))).append(",");
                            stringBuilder.append(C18698o.m29232tJ(str5.replace(",", " "))).append(",");
                            if (C18698o.ako() >= 0) {
                            }
                        }
                    }
                    str = str7;
                    C4990ab.m7411d("MicroMsg.NetTypeReporter", "mcc:%s mnc:%s cell:%s", str3, str4, str5);
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(C5046bo.anT()).append(",");
                    stringBuilder.append(i).append(",");
                    stringBuilder.append(Me).append(",");
                    stringBuilder.append(str6.replace(",", " ")).append(",");
                    stringBuilder.append(C18698o.m29232tJ(stringBuffer4.replace(",", " "))).append(",");
                    stringBuilder.append(str2.replace(",", " ")).append(",");
                    stringBuilder.append(C18698o.m29232tJ(str3.replace(",", " "))).append(",");
                    stringBuilder.append(C18698o.m29232tJ(str4.replace(",", " "))).append(",");
                    stringBuilder.append(C18698o.m29232tJ(str5.replace(",", " "))).append(",");
                    if (C18698o.ako() >= 0) {
                    }
                }
                C4990ab.m7411d("MicroMsg.NetTypeReporter", "get wifi :[%s] [%s]", stringBuffer4, str6);
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
                    C4990ab.m7413e("MicroMsg.NetTypeReporter", "getNetType : %s", C5046bo.m7574l(e6));
                }
                C4990ab.m7417i("MicroMsg.NetTypeReporter", "get ispName: %s", str2);
                str3 = "";
                str4 = "";
                str5 = "";
                str = "";
                str9 = "";
                try {
                    gJ = C5023at.m7479gJ(context);
                    i2 = 0;
                    str7 = str;
                    while (i2 < gJ.size()) {
                        String str10;
                        C5022a c5022a = (C5022a) gJ.get(i2);
                        str3 = C5046bo.m7532bc(c5022a.org, "");
                        str4 = C5046bo.m7532bc(c5022a.orh, "");
                        if (str5.length() > 0 && !C5046bo.isNullOrNil(c5022a.ori)) {
                            str5 = str5 + "|";
                        }
                        if (!C5046bo.isNullOrNil(c5022a.ori)) {
                            str5 = str5 + c5022a.ori;
                        }
                        if (str7.length() <= 0 || C5046bo.isNullOrNil(c5022a.tzp)) {
                            str10 = str7;
                        } else {
                            str10 = str7 + "|";
                        }
                        try {
                            if (!C5046bo.isNullOrNil(c5022a.tzp)) {
                                str10 = str10 + c5022a.tzp;
                            }
                            if (str9.length() > 0) {
                                str9 = str9 + "|";
                            }
                            stringBuilder = new StringBuilder().append(str9);
                            if (C5046bo.isNullOrNil(c5022a.tzt)) {
                                str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                            } else {
                                str = c5022a.tzt;
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
                    C4990ab.m7413e("MicroMsg.NetTypeReporter", "getNetType : %s", C5046bo.m7574l(e2));
                    C4990ab.m7411d("MicroMsg.NetTypeReporter", "mcc:%s mnc:%s cell:%s", str3, str4, str5);
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(C5046bo.anT()).append(",");
                    stringBuilder.append(i).append(",");
                    stringBuilder.append(Me).append(",");
                    stringBuilder.append(str6.replace(",", " ")).append(",");
                    stringBuilder.append(C18698o.m29232tJ(stringBuffer4.replace(",", " "))).append(",");
                    stringBuilder.append(str2.replace(",", " ")).append(",");
                    stringBuilder.append(C18698o.m29232tJ(str3.replace(",", " "))).append(",");
                    stringBuilder.append(C18698o.m29232tJ(str4.replace(",", " "))).append(",");
                    stringBuilder.append(C18698o.m29232tJ(str5.replace(",", " "))).append(",");
                    if (C18698o.ako() >= 0) {
                    }
                }
                C4990ab.m7411d("MicroMsg.NetTypeReporter", "mcc:%s mnc:%s cell:%s", str3, str4, str5);
                stringBuilder = new StringBuilder();
                stringBuilder.append(C5046bo.anT()).append(",");
                stringBuilder.append(i).append(",");
                stringBuilder.append(Me).append(",");
                stringBuilder.append(str6.replace(",", " ")).append(",");
                stringBuilder.append(C18698o.m29232tJ(stringBuffer4.replace(",", " "))).append(",");
                stringBuilder.append(str2.replace(",", " ")).append(",");
                stringBuilder.append(C18698o.m29232tJ(str3.replace(",", " "))).append(",");
                stringBuilder.append(C18698o.m29232tJ(str4.replace(",", " "))).append(",");
                stringBuilder.append(C18698o.m29232tJ(str5.replace(",", " "))).append(",");
                if (C18698o.ako() >= 0) {
                    AppMethodBeat.m2505o(78775);
                    return null;
                }
                String[] strArr = new String[]{C18698o.ako() + "," + stringBuilder.toString(), C18698o.m29232tJ(str8), C18698o.m29232tJ(str), C18698o.m29232tJ(str9)};
                AppMethodBeat.m2505o(78775);
                return strArr;
            }
            C4990ab.m7421w("MicroMsg.NetTypeReporter", "checkBssid: find all report already  , give up. scene:%d ", Integer.valueOf(i));
            AppMethodBeat.m2505o(78775);
            return null;
        } catch (Exception e8) {
            e = e8;
            str = str7;
        }
    }

    /* renamed from: tJ */
    private static String m29232tJ(String str) {
        AppMethodBeat.m2504i(78776);
        if (TextUtils.isEmpty(str)) {
            str = "";
            AppMethodBeat.m2505o(78776);
            return str;
        }
        for (char c : str.toCharArray()) {
            if ((c < 'a' || c > 'z') && ((c < 'A' || c > 'Z') && !((c >= '0' && c <= '9') || c == '|' || c == '-' || c == ' ' || c == ':'))) {
                str = "";
                AppMethodBeat.m2505o(78776);
                return str;
            }
        }
        AppMethodBeat.m2505o(78776);
        return str;
    }

    private static long ako() {
        String a;
        AppMethodBeat.m2504i(78777);
        synchronized (eMl) {
            long a2;
            try {
                a = C5046bo.m7514a((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_REPORTNETTYPE_SEQ_LONG, null), 1);
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_REPORTNETTYPE_SEQ_LONG, Long.valueOf(1 + a));
                C1720g.m3536RP().mo5239Ry().dsb();
                a2 = C5046bo.m7514a((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_REPORTNETTYPE_SEQ_LONG, null), 1);
                Object[] objArr = new Object[2];
                objArr[0] = Long.valueOf(a);
                a2 = Long.valueOf(a2);
                objArr[1] = a2;
                C4990ab.m7417i("MicroMsg.NetTypeReporter", "incSeq after write  old:%d new:%d", objArr);
            } catch (Exception e) {
                a = "incSeq :%s";
                C4990ab.m7413e("MicroMsg.NetTypeReporter", a, C5046bo.m7574l(e));
                a2 = -1;
                return a2;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(78777);
            }
        }
        return a;
    }

    /* renamed from: a */
    private static void m29223a(int i, float f, float f2, int i2, long j) {
        AppMethodBeat.m2504i(78778);
        long anU = C5046bo.anU();
        if (fTU <= 0 || anU - fTU <= 5000) {
            final String[] mf = C18698o.m29228mf(i);
            if (mf == null || mf.length != 4 || C5046bo.isNullOrNil(mf[0])) {
                C4990ab.m7412e("MicroMsg.NetTypeReporter", "report get failed val");
                AppMethodBeat.m2505o(78778);
                return;
            }
            C4990ab.m7411d("MicroMsg.NetTypeReporter", "report scene:%d time:%d lon:%f lat:%f pre:%d scanuse:%d [%s]", Integer.valueOf(i), Long.valueOf(C5046bo.m7566gb(anU)), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2), Long.valueOf(j), mf[0]);
            C1196a c1196a = new C1196a();
            c1196a.fsJ = new bpu();
            c1196a.fsK = new bpv();
            c1196a.uri = "/cgi-bin/micromsg-bin/rtkvreport";
            c1196a.fsI = 716;
            C7472b acD = c1196a.acD();
            final bpu bpu = (bpu) acD.fsG.fsP;
            bpu.vOz = C7243d.vxj;
            bpu.vOA = C7243d.vxi;
            bpu.vOB = C7243d.vxl;
            bpu.vOC = C7243d.vxm;
            bpu.vOD = C4988aa.dor();
            bpu.wBd = 11747;
            anU = C5046bo.m7566gb(fTU);
            if (anU > 600000 || anU < 0) {
                anU = 0;
            }
            bpu.pXM = mf[0] + "0," + f + "," + f2 + "," + i2 + "," + j + "," + (C4872b.foreground ? "1" : String.valueOf(anU)) + "," + mf[1] + "," + mf[2] + "," + mf[3];
            final long anU2 = C5046bo.anU();
            final float f3 = f;
            final float f4 = f2;
            final int i3 = i2;
            final long j2 = j;
            C1226w.m2655a(acD, new C1224a() {
                /* renamed from: a */
                public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                    AppMethodBeat.m2504i(78768);
                    C4990ab.m7411d("MicroMsg.NetTypeReporter", "onGYNetEnd errType:%d errCode:%d msg:%s  %d val:%s ", Integer.valueOf(i), Integer.valueOf(i2), str, Long.valueOf(C5046bo.m7566gb(anU2)), bpu.pXM);
                    if (!(i == 0 && i2 == 0)) {
                        long gb = C5046bo.m7566gb(C18698o.fTU);
                        if (gb > 600000 || gb < 0) {
                            gb = 0;
                        }
                        C7060h.pYm.mo8374X(11747, mf[0] + "1," + f3 + "," + f4 + "," + i3 + "," + j2 + "," + (C4872b.foreground ? "1" : String.valueOf(gb)) + "," + mf[1] + "," + mf[2] + "," + mf[3]);
                    }
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_REPORTNETTYPE_LASTREPORT_LONG, Long.valueOf(C5046bo.anU()));
                    AppMethodBeat.m2505o(78768);
                    return 0;
                }
            }, true);
            AppMethodBeat.m2505o(78778);
            return;
        }
        C4990ab.m7413e("MicroMsg.NetTypeReporter", "never  report  at  background :%d diff:%d", Long.valueOf(fTU), Long.valueOf(anU - fTU));
        AppMethodBeat.m2505o(78778);
    }

    /* renamed from: y */
    public static void m29233y(int i, String str) {
        AppMethodBeat.m2504i(78779);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bpu();
        c1196a.fsK = new bpv();
        c1196a.uri = "/cgi-bin/micromsg-bin/rtkvreport";
        c1196a.fsI = 716;
        C7472b acD = c1196a.acD();
        final bpu bpu = (bpu) acD.fsG.fsP;
        bpu.vOz = C7243d.vxj;
        bpu.vOA = C7243d.vxi;
        bpu.vOB = C7243d.vxl;
        bpu.vOC = C7243d.vxm;
        bpu.vOD = C4988aa.dor();
        bpu.wBd = i;
        bpu.pXM = str;
        C4990ab.m7417i("MicroMsg.NetTypeReporter", "reportCgi logId:%d, value:%s", Integer.valueOf(i), str);
        final long anU = C5046bo.anU();
        C1226w.m2654a(acD, new C1224a() {
            /* renamed from: a */
            public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                AppMethodBeat.m2504i(78769);
                C4990ab.m7411d("MicroMsg.NetTypeReporter", "onGYNetEnd errType:%d errCode:%d msg:%s  %d val:%s ", Integer.valueOf(i), Integer.valueOf(i2), str, Long.valueOf(C5046bo.m7566gb(anU)), bpu.pXM);
                AppMethodBeat.m2505o(78769);
                return 0;
            }
        });
        AppMethodBeat.m2505o(78779);
    }

    /* renamed from: b */
    private static void m29224b(int i, float f, float f2, int i2, long j) {
        AppMethodBeat.m2504i(78780);
        try {
            C4990ab.m7417i("MicroMsg.NetTypeReporter", "checkTimeReport scene:%d diff:%d  time:%d", Integer.valueOf(i), Long.valueOf(C5046bo.m7566gb(fTS)), Long.valueOf(fTS));
            if (i > 2000 || C5046bo.m7566gb(fTS) > 300000) {
                C4990ab.m7417i("MicroMsg.NetTypeReporter", "force Run, scene:%d diff:%d time:%d ", Integer.valueOf(i), Long.valueOf(C5046bo.m7566gb(fTS)), Long.valueOf(fTS));
                fTT = i;
                fTS = Long.MAX_VALUE;
                C18698o.m29223a(i, f, f2, i2, j);
                AppMethodBeat.m2505o(78780);
                return;
            }
            if (fTS == Long.MAX_VALUE) {
                fTS = C5046bo.anU() + 60000;
            }
            fTT = i;
            che.mo16770ae(60000, 60000);
            AppMethodBeat.m2505o(78780);
        } catch (Throwable th) {
            C4990ab.m7413e("MicroMsg.NetTypeReporter", "checkTimeReport error: %s", C5046bo.m7574l(th));
            AppMethodBeat.m2505o(78780);
        }
    }

    /* renamed from: cT */
    public static void m29225cT(boolean z) {
        AppMethodBeat.m2504i(78781);
        if (z) {
            fTU = 0;
            AppMethodBeat.m2505o(78781);
        } else if (che.doT()) {
            AppMethodBeat.m2505o(78781);
        } else {
            C4990ab.m7416i("MicroMsg.NetTypeReporter", "setToForeground user turn to background run report now");
            fTU = C5046bo.anU();
            che.mo16770ae(0, 0);
            AppMethodBeat.m2505o(78781);
        }
    }

    /* renamed from: a */
    public static synchronized void m29222a(int i, float f, float f2, int i2) {
        synchronized (C18698o.class) {
            AppMethodBeat.m2504i(78782);
            if (i < 2000 || f == 0.0f || f2 == 0.0f) {
                C4990ab.m7413e("MicroMsg.NetTypeReporter", "reportGps, invalid args, scene = %d, lon = %f, lat = %f, pre = %d", Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2));
                AppMethodBeat.m2505o(78782);
            } else if (C5046bo.m7566gb(fUa) < 60000) {
                C4990ab.m7413e("MicroMsg.NetTypeReporter", "reportGps, hit lastReportGpsLimit, request dropped, scene = %d, lon = %f, lat = %f, pre = %d", Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2));
                AppMethodBeat.m2505o(78782);
            } else {
                C4990ab.m7417i("MicroMsg.NetTypeReporter", "reportGps scene:%d lon:%f lat:%f pre:%d last:%d", Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2), Long.valueOf(C5046bo.m7566gb(fUa)));
                fUa = C5046bo.anU();
                fTZ = i;
                fTV = C5046bo.anU();
                fTY = i2;
                fTW = f2;
                fTX = f;
                try {
                    ((WifiManager) C4996ah.getContext().getSystemService("wifi")).startScan();
                    C1720g.m3539RS().mo10310m(new C187035(), 5000);
                    AppMethodBeat.m2505o(78782);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.NetTypeReporter", "reportGps :%s", C5046bo.m7574l(e));
                    AppMethodBeat.m2505o(78782);
                }
            }
        }
    }

    /* renamed from: mg */
    public static synchronized void m29229mg(int i) {
        synchronized (C18698o.class) {
            AppMethodBeat.m2504i(78783);
            C4990ab.m7417i("MicroMsg.NetTypeReporter", "run scene:%d foreground:%b lastGpsTime:%d lastbssid:%s", Integer.valueOf(i), Boolean.valueOf(C4872b.foreground), Long.valueOf(fTV), fUb);
            if (i == 1005) {
                try {
                    if (fTV > 0) {
                        C4990ab.m7411d("MicroMsg.NetTypeReporter", "report gps scene:%d lastscene:%d [%f,%f,%d] lastGpsTime", Integer.valueOf(i), Integer.valueOf(fTZ), Float.valueOf(fTX), Float.valueOf(fTW), Integer.valueOf(fTY), Long.valueOf(fTV));
                        long gb = C5046bo.m7566gb(fTV);
                        int i2 = fTZ;
                        float f = fTW;
                        float f2 = fTX;
                        int i3 = fTY;
                        fTV = 0;
                        fTW = 0.0f;
                        fTX = 0.0f;
                        fTY = 0;
                        fTZ = 0;
                        C18698o.m29224b(i2, f2, f, i3, gb);
                        AppMethodBeat.m2505o(78783);
                    }
                } catch (Throwable th) {
                    C4990ab.m7413e("MicroMsg.NetTypeReporter", "run :%s", C5046bo.m7574l(th));
                    AppMethodBeat.m2505o(78783);
                }
            }
            if (!C4872b.foreground) {
                C4990ab.m7421w("MicroMsg.NetTypeReporter", "run is not foreground give up %d ", Integer.valueOf(i));
                AppMethodBeat.m2505o(78783);
            } else if (i == 3) {
                String bssid = ((WifiManager) C4996ah.getContext().getSystemService("wifi")).getConnectionInfo().getBSSID();
                C4990ab.m7411d("MicroMsg.NetTypeReporter", "run scene:%d SCENE_TO_FOREGROUND_BSSID_CHANGE %s %s ", Integer.valueOf(i), bssid, fUb);
                if (!(C5046bo.isNullOrNil(bssid) || bssid.equals(fUb))) {
                    fUb = bssid;
                    C18698o.m29224b(i, 0.0f, 0.0f, 0, 0);
                }
                AppMethodBeat.m2505o(78783);
            } else if (i == 4) {
                C4990ab.m7417i("MicroMsg.NetTypeReporter", "run scene:%d SCENE_TO_FOREGROUND_TIMEOUT  diff:%d", Integer.valueOf(i), Long.valueOf(C5046bo.m7566gb(C5046bo.m7514a((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_REPORTNETTYPE_LASTREPORT_LONG, null), 0))));
                if (C5046bo.m7566gb(C5046bo.m7514a((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_REPORTNETTYPE_LASTREPORT_LONG, null), 0)) >= 21600000) {
                    C18698o.m29224b(i, 0.0f, 0.0f, 0, 0);
                }
                AppMethodBeat.m2505o(78783);
            } else {
                C18698o.m29224b(i, 0.0f, 0.0f, 0, 0);
                AppMethodBeat.m2505o(78783);
            }
        }
    }

    /* renamed from: mh */
    static /* synthetic */ void m29230mh(int i) {
        AppMethodBeat.m2504i(78784);
        long anU = C5046bo.anU();
        if (fTU <= 0 || anU - fTU <= 5000) {
            String[] mf = C18698o.m29228mf(i);
            if (mf == null || mf.length != 4 || C5046bo.isNullOrNil(mf[0])) {
                C4990ab.m7412e("MicroMsg.NetTypeReporter", "report get failed val");
                AppMethodBeat.m2505o(78784);
                return;
            }
            C4990ab.m7411d("MicroMsg.NetTypeReporter", "report scene:%d time:%d lon:%f lat:%f pre:%d scanuse:%d [%s]", Integer.valueOf(i), Long.valueOf(C5046bo.m7566gb(anU)), Float.valueOf(0.0f), Float.valueOf(0.0f), Integer.valueOf(0), Long.valueOf(0), mf[0]);
            anU = C5046bo.m7566gb(fTU);
            if (anU > 600000 || anU < 0) {
                anU = 0;
            }
            C7060h.pYm.mo8374X(11747, mf[0] + "1,0.0,0.0,0,0," + (C4872b.foreground ? "1" : String.valueOf(anU)) + "," + mf[1] + "," + mf[2] + "," + mf[3]);
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_REPORTNETTYPE_LASTREPORT_LONG, Long.valueOf(C5046bo.anU()));
            AppMethodBeat.m2505o(78784);
            return;
        }
        C4990ab.m7413e("MicroMsg.NetTypeReporter", "never  report (reportKV) at  background :%d diff:%d", Long.valueOf(fTU), Long.valueOf(anU - fTU));
        AppMethodBeat.m2505o(78784);
    }
}
