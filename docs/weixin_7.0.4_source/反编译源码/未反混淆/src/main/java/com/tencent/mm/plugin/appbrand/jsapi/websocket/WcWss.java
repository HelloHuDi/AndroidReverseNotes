package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import android.support.annotation.Keep;
import android.util.Pair;
import com.tencent.luggage.a.e;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.appbrand.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import java.util.ArrayList;
import java.util.HashMap;

public class WcWss {
    private static HashMap<Pair<String, Integer>, a> ici = new HashMap();

    public interface a {
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
        AppMethodBeat.i(108125);
        k.a("wcwss", WcWss.class.getClassLoader());
        init();
        AppMethodBeat.o(108125);
    }

    public static int a(a aVar, String str, String str2, Object[] objArr, Object[] objArr2, Object obj, Object[] objArr3) {
        AppMethodBeat.i(108115);
        int connectSocket = connectSocket(str, str2, objArr, objArr2, null, obj, objArr3);
        if (connectSocket > 0) {
            ab.i("MicroMsg.WcWss", "connect wss pair(%s, %d)", str, Integer.valueOf(connectSocket));
            Pair pair = new Pair(str, Integer.valueOf(connectSocket));
            if (ici.containsKey(pair)) {
                ab.e("MicroMsg.WcWss", "already exists pair(%s, %d)", str, Integer.valueOf(connectSocket));
                AppMethodBeat.o(108115);
                return -1;
            }
            ici.put(pair, aVar);
        }
        AppMethodBeat.o(108115);
        return connectSocket;
    }

    @Keep
    public static void onHandShake(String str, int i, String[] strArr, String[] strArr2) {
        AppMethodBeat.i(108116);
        ab.i("MicroMsg.WcWss", "onHandShake group:%s, wssId:%s", str, Integer.valueOf(i));
        Pair pair = new Pair(str, Integer.valueOf(i));
        if (ici.containsKey(pair)) {
            ((a) ici.get(pair)).onHandShake(str, i, strArr, strArr2);
            AppMethodBeat.o(108116);
            return;
        }
        ab.e("MicroMsg.WcWss", "onHandShake callback is null");
        AppMethodBeat.o(108116);
    }

    @Keep
    public static void onOpen(String str, int i, boolean z, String[] strArr, String[] strArr2, int i2, String str2) {
        AppMethodBeat.i(108117);
        ab.i("MicroMsg.WcWss", "onOpen group:%s,isSuc:%s, msg:%s, code:%s, wssId:%s", str, Boolean.valueOf(z), str2, Integer.valueOf(i2), Integer.valueOf(i));
        Pair pair = new Pair(str, Integer.valueOf(i));
        if (ici.containsKey(pair)) {
            ((a) ici.get(pair)).onOpen(str, i, z, strArr, strArr2, i2, str2);
            if (!z) {
                ici.remove(pair);
                AppMethodBeat.o(108117);
                return;
            }
        }
        ab.e("MicroMsg.WcWss", "onOpen callback is null");
        AppMethodBeat.o(108117);
    }

    @Keep
    public static void onMessage(String str, int i, byte[] bArr, boolean z) {
        AppMethodBeat.i(108118);
        ab.i("MicroMsg.WcWss", "onMessage group:%s,wssId:%s,isText:%s", str, Integer.valueOf(i), Boolean.valueOf(z));
        Pair pair = new Pair(str, Integer.valueOf(i));
        if (ici.containsKey(pair)) {
            ((a) ici.get(pair)).onMessage(str, i, bArr, z);
            AppMethodBeat.o(108118);
            return;
        }
        ab.e("MicroMsg.WcWss", "onMessage callback is null");
        AppMethodBeat.o(108118);
    }

    @Keep
    public static void onClose(String str, int i, int i2, String str2) {
        AppMethodBeat.i(108119);
        ab.i("MicroMsg.WcWss", "onClose group:%s,id:%s, reason:%s, code:%s", str, Integer.valueOf(i), str2, Integer.valueOf(i2));
        Pair pair = new Pair(str, Integer.valueOf(i));
        if (ici.containsKey(pair)) {
            ((a) ici.get(pair)).onClose(str, i, i2, str2);
            ici.remove(pair);
            AppMethodBeat.o(108119);
            return;
        }
        ab.e("MicroMsg.WcWss", "onClose callback is null");
        AppMethodBeat.o(108119);
    }

    @Keep
    public static void onKvStat(int i, String str) {
        AppMethodBeat.i(108120);
        ab.i("MicroMsg.WcWss", "onKvStat logId:%s", Integer.valueOf(i));
        ((b) e.C(b.class)).X(i, str);
        AppMethodBeat.o(108120);
    }

    @Keep
    public static void onIdKeyStat(int[] iArr, int[] iArr2, int[] iArr3) {
        AppMethodBeat.i(108121);
        ab.v("MicroMsg.WcWss", "onIdKeyStat");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < iArr.length; i++) {
            arrayList.add(new IDKey(iArr[i], iArr2[i], iArr3[i]));
        }
        ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).b(arrayList, false);
        AppMethodBeat.o(108121);
    }

    @Keep
    public static int getNetworkType() {
        AppMethodBeat.i(108122);
        int statisticsNetType = getStatisticsNetType();
        AppMethodBeat.o(108122);
        return statisticsNetType;
    }

    @Keep
    public static int doCertificateVerify(String str, int i, String str2, byte[][] bArr) {
        AppMethodBeat.i(108123);
        ab.i("MicroMsg.WcWss", "doCertificateVerify group:%s,wssId:%s,hostname:%s", str, Integer.valueOf(i), str2);
        Pair pair = new Pair(str, Integer.valueOf(i));
        if (ici.containsKey(pair)) {
            int doCertificateVerify = ((a) ici.get(pair)).doCertificateVerify(str2, bArr);
            AppMethodBeat.o(108123);
            return doCertificateVerify;
        }
        ab.e("MicroMsg.WcWss", "onMessage callback is null");
        AppMethodBeat.o(108123);
        return -1;
    }

    private static int getStatisticsNetType() {
        int i = -1;
        AppMethodBeat.i(108124);
        try {
            int netType = at.getNetType(ah.getContext());
            if (netType == i) {
                AppMethodBeat.o(108124);
                return i;
            } else if (at.is2G(ah.getContext())) {
                AppMethodBeat.o(108124);
                return 3;
            } else if (at.is3G(ah.getContext())) {
                AppMethodBeat.o(108124);
                return 4;
            } else if (at.is4G(ah.getContext())) {
                AppMethodBeat.o(108124);
                return 5;
            } else if (at.isWifi(netType)) {
                AppMethodBeat.o(108124);
                return 1;
            } else if (at.isWap(netType)) {
                AppMethodBeat.o(108124);
                return 2;
            } else {
                AppMethodBeat.o(108124);
                return 6;
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.WcWss", e, "getStatisticsNetType_", new Object[0]);
            AppMethodBeat.o(108124);
            return i;
        }
    }
}
