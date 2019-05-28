package com.tencent.mm.plugin.qqmail.b;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.vfs.e;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.ttpic.baseutils.BaseTemplateParser;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public final class v {
    private static SparseArray<String> puI = null;
    public p puD;
    public i puE;
    private k puF;
    private Map<Long, d> puG = new HashMap();
    private Map<Long, b> puH = new HashMap();
    private Map<String, String> pud = new HashMap();

    public static abstract class a {
        public abstract void onError(int i, String str);

        public abstract void onSuccess(String str, Map<String, String> map);

        public boolean onReady() {
            return true;
        }

        public void onProgress(int i) {
        }

        public void onComplete() {
        }
    }

    public static class c {
        public boolean puO = false;
        public boolean puP = true;
        public boolean puQ = true;

        public final void toBundle(Bundle bundle) {
            AppMethodBeat.i(68001);
            bundle.putBoolean("qqmail_httpoptions_expired", this.puO);
            bundle.putBoolean("qqmail_httpoptions_needcache", this.puP);
            bundle.putBoolean("qqmail_httpoptions_needparse", this.puQ);
            AppMethodBeat.o(68001);
        }

        public final void fromBundle(Bundle bundle) {
            AppMethodBeat.i(68002);
            this.puO = bundle.getBoolean("qqmail_httpoptions_expired");
            this.puP = bundle.getBoolean("qqmail_httpoptions_needcache");
            this.puQ = bundle.getBoolean("qqmail_httpoptions_needparse");
            AppMethodBeat.o(68002);
        }
    }

    class b extends AsyncTask<d, Integer, d> implements com.tencent.mm.plugin.qqmail.b.n.a {
        private n puL;
        d puM;

        private b() {
        }

        /* synthetic */ b(v vVar, byte b) {
            this();
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.i(68000);
            d dVar = ((d[]) objArr)[0];
            if (!bo.isNullOrNil((String) dVar.puS.pud.get("skey"))) {
                if (!dVar.puR.puO && dVar.puR.puP) {
                    String str;
                    byte[] t = v.this.puF.t(dVar.uri, dVar.puS.puc);
                    if (t == null) {
                        str = null;
                    } else {
                        str = new String(t);
                    }
                    if (str != null) {
                        dVar.puT = new com.tencent.mm.plugin.qqmail.b.n.c(304, null, str);
                        if (dVar.puR.puQ || !(dVar.puT.status == 304 || dVar.puT.status == 200)) {
                            ab.e("MicroMsg.NormalMailAppService", "http error, %d", Integer.valueOf(dVar.puT.status));
                        } else {
                            dVar.puU = br.z(dVar.puT.content, "Response");
                        }
                    }
                }
                if (dVar.puS.pue != null) {
                    this.puL = new l();
                } else {
                    this.puL = new m();
                }
                dVar.puT = this.puL.a("https://", dVar.uri, dVar.puS, this);
                if (dVar.puT == null) {
                    AppMethodBeat.o(68000);
                    return null;
                }
                if (dVar.puR.puQ) {
                }
                ab.e("MicroMsg.NormalMailAppService", "http error, %d", Integer.valueOf(dVar.puT.status));
            }
            AppMethodBeat.o(68000);
            return dVar;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.i(67999);
            d dVar = (d) obj;
            if (dVar != null) {
                if (bo.isNullOrNil((String) dVar.puS.pud.get("skey"))) {
                    dVar.puV.onError(-5, "");
                } else if (dVar.puT.status == 304) {
                    v.a(dVar);
                } else if (dVar.puT.status == 200) {
                    v.a(v.this, dVar.puT.pud);
                    if (v.a(dVar) == 0 && dVar.puR.puP) {
                        v.this.puF.a(dVar.uri, dVar.puS.puc, dVar.puT.content.getBytes());
                    }
                } else {
                    dVar.puV.onError(dVar.puT.status, v.Bq(dVar.puT.status));
                }
                dVar.puV.onComplete();
                v.this.puG.remove(Long.valueOf(dVar.id));
                v.this.puH.remove(Long.valueOf(dVar.id));
            }
            AppMethodBeat.o(67999);
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onProgressUpdate(Object[] objArr) {
            AppMethodBeat.i(67998);
            this.puM.puV.onProgress(((Integer[]) objArr)[0].intValue());
            AppMethodBeat.o(67998);
        }

        public final boolean b(d dVar) {
            AppMethodBeat.i(67995);
            if (dVar.puV.onReady()) {
                this.puM = dVar;
                super.execute(new d[]{dVar});
                AppMethodBeat.o(67995);
                return true;
            }
            AppMethodBeat.o(67995);
            return false;
        }

        public final void ccp() {
            AppMethodBeat.i(67996);
            publishProgress(new Integer[]{Integer.valueOf(0)});
            AppMethodBeat.o(67996);
        }

        /* Access modifiers changed, original: protected|final */
        public final void onCancelled() {
            AppMethodBeat.i(67997);
            g.RQ();
            g.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(67993);
                    if (b.this.puL != null) {
                        b.this.puL.cancel();
                    }
                    AppMethodBeat.o(67993);
                }

                public final String toString() {
                    AppMethodBeat.i(67994);
                    String str = super.toString() + "|onCancelled";
                    AppMethodBeat.o(67994);
                    return str;
                }
            });
            super.onCancelled();
            AppMethodBeat.o(67997);
        }
    }

    class d {
        long id = System.currentTimeMillis();
        c puR;
        com.tencent.mm.plugin.qqmail.b.n.b puS;
        com.tencent.mm.plugin.qqmail.b.n.c puT;
        Map<String, String> puU;
        a puV;
        String uri;

        public d(String str, com.tencent.mm.plugin.qqmail.b.n.b bVar, a aVar) {
            AppMethodBeat.i(68003);
            this.uri = str;
            this.puS = bVar;
            this.puV = aVar;
            AppMethodBeat.o(68003);
        }
    }

    static /* synthetic */ String Bq(int i) {
        AppMethodBeat.i(68023);
        String Bp = Bp(i);
        AppMethodBeat.o(68023);
        return Bp;
    }

    public v(int i, String str) {
        AppMethodBeat.i(68004);
        n.setHost("qqmail.weixin.qq.com:443");
        n.setUserAgent("weixin/" + str + "/0x" + Integer.toHexString(i));
        reset();
        AppMethodBeat.o(68004);
    }

    public final long a(String str, Map<String, String> map, a aVar) {
        AppMethodBeat.i(68005);
        long a = a(str, map, new c(), aVar);
        AppMethodBeat.o(68005);
        return a;
    }

    public final long a(String str, Map<String, String> map, c cVar, a aVar) {
        AppMethodBeat.i(68006);
        long a = a(str, 1, map, null, cVar, aVar);
        AppMethodBeat.o(68006);
        return a;
    }

    public final long b(String str, Map<String, String> map, a aVar) {
        AppMethodBeat.i(68007);
        long b = b(str, map, new c(), aVar);
        AppMethodBeat.o(68007);
        return b;
    }

    public final long b(String str, Map<String, String> map, c cVar, a aVar) {
        AppMethodBeat.i(68008);
        long a = a(str, 0, map, null, cVar, aVar);
        AppMethodBeat.o(68008);
        return a;
    }

    public final long a(String str, String str2, String str3, c cVar, a aVar) {
        AppMethodBeat.i(68009);
        long a = a(str, 1, null, new com.tencent.mm.plugin.qqmail.b.n.d(str2, str3), cVar, aVar);
        AppMethodBeat.o(68009);
        return a;
    }

    public static String ccw() {
        return "https://qqmail.weixin.qq.com:443";
    }

    private long a(String str, int i, Map<String, String> map, com.tencent.mm.plugin.qqmail.b.n.d dVar, c cVar, a aVar) {
        Map map2;
        AppMethodBeat.i(68010);
        if (map2 == null) {
            map2 = new HashMap();
        }
        map2.put("appname", "qqmail_weixin");
        map2.put("f", BaseTemplateParser.POSTFIX_ORIG);
        map2.put("charset", ProtocolPackage.ServerEncoding);
        map2.put("clientip", getLocalIp());
        final d dVar2 = new d(str, new com.tencent.mm.plugin.qqmail.b.n.b(i, map2, getCookie(), dVar), aVar);
        dVar2.puR = cVar;
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(67992);
                b bVar = new b(v.this, (byte) 0);
                v.this.puG.put(Long.valueOf(dVar2.id), dVar2);
                v.this.puH.put(Long.valueOf(dVar2.id), bVar);
                bVar.b(dVar2);
                AppMethodBeat.o(67992);
            }
        });
        long j = dVar2.id;
        AppMethodBeat.o(68010);
        return j;
    }

    private void cancel() {
        AppMethodBeat.i(68011);
        for (b cancel : this.puH.values()) {
            cancel.cancel(true);
        }
        this.puH.clear();
        this.puG.clear();
        AppMethodBeat.o(68011);
    }

    public final void cancel(long j) {
        AppMethodBeat.i(68012);
        b bVar = (b) this.puH.get(Long.valueOf(j));
        if (bVar != null) {
            bVar.onCancelled();
            bVar.cancel(true);
        }
        this.puH.remove(Long.valueOf(j));
        this.puG.remove(Long.valueOf(j));
        AppMethodBeat.o(68012);
    }

    public final void reset() {
        AppMethodBeat.i(68013);
        n.Vg(getDownloadPath());
        cancel();
        this.pud.clear();
        String ccx = ccx();
        this.puD = new p(ccx + "addr/");
        this.puE = new i(ccx + "draft/");
        this.puF = new k(ccx + "http/", 0);
        AppMethodBeat.o(68013);
    }

    public final void clearData() {
        AppMethodBeat.i(68014);
        e.N(ccx(), true);
        reset();
        AppMethodBeat.o(68014);
    }

    public static String getDownloadPath() {
        AppMethodBeat.i(68015);
        String str = com.tencent.mm.compatible.util.e.euQ;
        e.tf(str);
        AppMethodBeat.o(68015);
        return str;
    }

    private static String getLocalIp() {
        AppMethodBeat.i(68016);
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        String hostAddress = inetAddress.getHostAddress();
                        AppMethodBeat.o(68016);
                        return hostAddress;
                    }
                }
            }
        } catch (Exception | SocketException e) {
        }
        AppMethodBeat.o(68016);
        return null;
    }

    public final Map<String, String> getCookie() {
        Object obj;
        AppMethodBeat.i(68017);
        String str = (String) g.RP().Ry().get(-1535680990, null);
        Map map = this.pud;
        String str2 = "skey";
        if (str == null) {
            obj = "";
        } else {
            String obj2 = str;
        }
        map.put(str2, obj2);
        this.pud.put(OpenSDKTool4Assistant.EXTRA_UIN, "o" + new p(bo.g(g.RP().Ry().get(9, null), 0)));
        ab.d("MicroMsg.NormalMailAppService", "sKey:%b, uin:%d", Boolean.valueOf(bo.isNullOrNil(str)), Integer.valueOf(r1));
        Map map2 = this.pud;
        AppMethodBeat.o(68017);
        return map2;
    }

    private static String aX(int i, String str) {
        AppMethodBeat.i(68019);
        int i2 = 0;
        switch (i) {
            case ZipJNI.UNZ_CRCERROR /*-105*/:
            case -6:
                i2 = R.string.ddz;
                break;
            case ZipJNI.UNZ_INTERNALERROR /*-104*/:
                i2 = R.string.ddx;
                break;
            case ZipJNI.UNZ_BADZIPFILE /*-103*/:
                i2 = R.string.ddw;
                break;
            case ZipJNI.UNZ_PARAMERROR /*-102*/:
                i2 = R.string.ddv;
                break;
            case -7:
                i2 = R.string.de0;
                break;
            case -4:
            case -3:
                i2 = R.string.ddy;
                break;
            case -1:
                i2 = R.string.ddt;
                break;
        }
        if (i2 == 0) {
            AppMethodBeat.o(68019);
            return str;
        }
        str = com.tencent.mm.bz.a.an(ah.getContext(), i2);
        AppMethodBeat.o(68019);
        return str;
    }

    private static String ccx() {
        AppMethodBeat.i(68020);
        StringBuilder stringBuilder = new StringBuilder();
        g.RQ();
        String stringBuilder2 = stringBuilder.append(g.RP().eJM).append("mailapp/").toString();
        AppMethodBeat.o(68020);
        return stringBuilder2;
    }

    private static String Bp(int i) {
        AppMethodBeat.i(68018);
        if (puI == null) {
            puI = new SparseArray();
            for (Field field : HttpURLConnection.class.getDeclaredFields()) {
                int modifiers = field.getModifiers();
                String name = field.getName();
                if (name != null && name.startsWith("HTTP_") && Modifier.isPublic(modifiers) && Modifier.isFinal(modifiers) && Modifier.isStatic(modifiers)) {
                    try {
                        modifiers = field.getInt(Integer.valueOf(0));
                        StringBuilder stringBuilder = new StringBuilder();
                        String[] split = name.split("_");
                        if (split != null) {
                            for (int i2 = 1; i2 < split.length; i2++) {
                                stringBuilder.append(split[i2]).append(' ');
                            }
                            stringBuilder.append("error");
                        }
                        puI.put(modifiers, stringBuilder.toString().toLowerCase());
                    } catch (Exception e) {
                    }
                }
            }
        }
        String str = (String) puI.get(i);
        if (str == null) {
            str = aX(i, "request error");
            AppMethodBeat.o(68018);
            return str;
        }
        AppMethodBeat.o(68018);
        return str;
    }

    static /* synthetic */ void a(v vVar, Map map) {
        AppMethodBeat.i(68022);
        if (vVar.pud == null || map == null) {
            AppMethodBeat.o(68022);
            return;
        }
        for (String str : map.keySet()) {
            vVar.pud.put(str, map.get(str));
        }
        AppMethodBeat.o(68022);
    }
}
