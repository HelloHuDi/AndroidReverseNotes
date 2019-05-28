package com.tencent.p177mm.plugin.appbrand.jsapi.websocket;

import android.support.annotation.Keep;
import android.util.Pair;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1449k;
import com.tencent.p177mm.plugin.appbrand.p326n.C2402a;
import com.tencent.p177mm.plugin.appbrand.p326n.C33458b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.websocket.WcWss */
public class WcWss {
    private static HashMap<Pair<String, Integer>, C2353a> ici = new HashMap();

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.websocket.WcWss$a */
    public interface C2353a {
        int doCertificateVerify(String str, byte[][] bArr);

        void onClose(String str, int i, int i2, String str2);

        void onHandShake(String str, int i, String[] strArr, String[] strArr2);

        void onMessage(String str, int i, byte[] bArr, boolean z);

        void onOpen(String str, int i, boolean z, String[] strArr, String[] strArr2, int i2, String str2);
    }

    public static native void closeSocket(String str, int i, int i2, String str2);

    private static native int connectSocket(String str, String str2, Object[] objArr, Object[] objArr2, Object[] objArr3, Object obj, Object[] objArr4);

    public static native void init();

    public static native int sendBuffer(String str, int i, byte[] bArr, boolean z);

    public static native void setDebugIp(String str, int i);

    static {
        AppMethodBeat.m2504i(108125);
        C1449k.m3079a("wcwss", WcWss.class.getClassLoader());
        WcWss.init();
        AppMethodBeat.m2505o(108125);
    }

    /* renamed from: a */
    public static int m75411a(C2353a c2353a, String str, String str2, Object[] objArr, Object[] objArr2, Object obj, Object[] objArr3) {
        AppMethodBeat.m2504i(108115);
        int connectSocket = WcWss.connectSocket(str, str2, objArr, objArr2, null, obj, objArr3);
        if (connectSocket > 0) {
            C4990ab.m7417i("MicroMsg.WcWss", "connect wss pair(%s, %d)", str, Integer.valueOf(connectSocket));
            Pair pair = new Pair(str, Integer.valueOf(connectSocket));
            if (ici.containsKey(pair)) {
                C4990ab.m7413e("MicroMsg.WcWss", "already exists pair(%s, %d)", str, Integer.valueOf(connectSocket));
                AppMethodBeat.m2505o(108115);
                return -1;
            }
            ici.put(pair, c2353a);
        }
        AppMethodBeat.m2505o(108115);
        return connectSocket;
    }

    @Keep
    public static void onHandShake(String str, int i, String[] strArr, String[] strArr2) {
        AppMethodBeat.m2504i(108116);
        C4990ab.m7417i("MicroMsg.WcWss", "onHandShake group:%s, wssId:%s", str, Integer.valueOf(i));
        Pair pair = new Pair(str, Integer.valueOf(i));
        if (ici.containsKey(pair)) {
            ((C2353a) ici.get(pair)).onHandShake(str, i, strArr, strArr2);
            AppMethodBeat.m2505o(108116);
            return;
        }
        C4990ab.m7412e("MicroMsg.WcWss", "onHandShake callback is null");
        AppMethodBeat.m2505o(108116);
    }

    @Keep
    public static void onOpen(String str, int i, boolean z, String[] strArr, String[] strArr2, int i2, String str2) {
        AppMethodBeat.m2504i(108117);
        C4990ab.m7417i("MicroMsg.WcWss", "onOpen group:%s,isSuc:%s, msg:%s, code:%s, wssId:%s", str, Boolean.valueOf(z), str2, Integer.valueOf(i2), Integer.valueOf(i));
        Pair pair = new Pair(str, Integer.valueOf(i));
        if (ici.containsKey(pair)) {
            ((C2353a) ici.get(pair)).onOpen(str, i, z, strArr, strArr2, i2, str2);
            if (!z) {
                ici.remove(pair);
                AppMethodBeat.m2505o(108117);
                return;
            }
        }
        C4990ab.m7412e("MicroMsg.WcWss", "onOpen callback is null");
        AppMethodBeat.m2505o(108117);
    }

    @Keep
    public static void onMessage(String str, int i, byte[] bArr, boolean z) {
        AppMethodBeat.m2504i(108118);
        C4990ab.m7417i("MicroMsg.WcWss", "onMessage group:%s,wssId:%s,isText:%s", str, Integer.valueOf(i), Boolean.valueOf(z));
        Pair pair = new Pair(str, Integer.valueOf(i));
        if (ici.containsKey(pair)) {
            ((C2353a) ici.get(pair)).onMessage(str, i, bArr, z);
            AppMethodBeat.m2505o(108118);
            return;
        }
        C4990ab.m7412e("MicroMsg.WcWss", "onMessage callback is null");
        AppMethodBeat.m2505o(108118);
    }

    @Keep
    public static void onClose(String str, int i, int i2, String str2) {
        AppMethodBeat.m2504i(108119);
        C4990ab.m7417i("MicroMsg.WcWss", "onClose group:%s,id:%s, reason:%s, code:%s", str, Integer.valueOf(i), str2, Integer.valueOf(i2));
        Pair pair = new Pair(str, Integer.valueOf(i));
        if (ici.containsKey(pair)) {
            ((C2353a) ici.get(pair)).onClose(str, i, i2, str2);
            ici.remove(pair);
            AppMethodBeat.m2505o(108119);
            return;
        }
        C4990ab.m7412e("MicroMsg.WcWss", "onClose callback is null");
        AppMethodBeat.m2505o(108119);
    }

    @Keep
    public static void onKvStat(int i, String str) {
        AppMethodBeat.m2504i(108120);
        C4990ab.m7417i("MicroMsg.WcWss", "onKvStat logId:%s", Integer.valueOf(i));
        ((C33458b) C37384e.m62986C(C33458b.class)).mo53943X(i, str);
        AppMethodBeat.m2505o(108120);
    }

    @Keep
    public static void onIdKeyStat(int[] iArr, int[] iArr2, int[] iArr3) {
        AppMethodBeat.m2504i(108121);
        C4990ab.m7418v("MicroMsg.WcWss", "onIdKeyStat");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < iArr.length; i++) {
            arrayList.add(new IDKey(iArr[i], iArr2[i], iArr3[i]));
        }
        ((C2402a) C37384e.m62986C(C2402a.class)).mo6306b(arrayList, false);
        AppMethodBeat.m2505o(108121);
    }

    @Keep
    public static int getNetworkType() {
        AppMethodBeat.m2504i(108122);
        int statisticsNetType = WcWss.getStatisticsNetType();
        AppMethodBeat.m2505o(108122);
        return statisticsNetType;
    }

    @Keep
    public static int doCertificateVerify(String str, int i, String str2, byte[][] bArr) {
        AppMethodBeat.m2504i(108123);
        C4990ab.m7417i("MicroMsg.WcWss", "doCertificateVerify group:%s,wssId:%s,hostname:%s", str, Integer.valueOf(i), str2);
        Pair pair = new Pair(str, Integer.valueOf(i));
        if (ici.containsKey(pair)) {
            int doCertificateVerify = ((C2353a) ici.get(pair)).doCertificateVerify(str2, bArr);
            AppMethodBeat.m2505o(108123);
            return doCertificateVerify;
        }
        C4990ab.m7412e("MicroMsg.WcWss", "onMessage callback is null");
        AppMethodBeat.m2505o(108123);
        return -1;
    }

    private static int getStatisticsNetType() {
        int i = -1;
        AppMethodBeat.m2504i(108124);
        try {
            int netType = C5023at.getNetType(C4996ah.getContext());
            if (netType == i) {
                AppMethodBeat.m2505o(108124);
                return i;
            } else if (C5023at.is2G(C4996ah.getContext())) {
                AppMethodBeat.m2505o(108124);
                return 3;
            } else if (C5023at.is3G(C4996ah.getContext())) {
                AppMethodBeat.m2505o(108124);
                return 4;
            } else if (C5023at.is4G(C4996ah.getContext())) {
                AppMethodBeat.m2505o(108124);
                return 5;
            } else if (C5023at.isWifi(netType)) {
                AppMethodBeat.m2505o(108124);
                return 1;
            } else if (C5023at.isWap(netType)) {
                AppMethodBeat.m2505o(108124);
                return 2;
            } else {
                AppMethodBeat.m2505o(108124);
                return 6;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.WcWss", e, "getStatisticsNetType_", new Object[0]);
            AppMethodBeat.m2505o(108124);
            return i;
        }
    }
}
