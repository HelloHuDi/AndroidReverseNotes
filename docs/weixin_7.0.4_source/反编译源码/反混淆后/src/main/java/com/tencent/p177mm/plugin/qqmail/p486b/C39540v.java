package com.tencent.p177mm.plugin.qqmail.p486b;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.plugin.qqmail.p486b.C43403n.C28742a;
import com.tencent.p177mm.plugin.qqmail.p486b.C43403n.C39538b;
import com.tencent.p177mm.plugin.qqmail.p486b.C43403n.C39539d;
import com.tencent.p177mm.plugin.qqmail.p486b.C43403n.C43402c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.vfs.C5730e;
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

/* renamed from: com.tencent.mm.plugin.qqmail.b.v */
public final class C39540v {
    private static SparseArray<String> puI = null;
    public C46149p puD;
    public C21519i puE;
    private C28741k puF;
    private Map<Long, C39542d> puG = new HashMap();
    private Map<Long, C31388b> puH = new HashMap();
    private Map<String, String> pud = new HashMap();

    /* renamed from: com.tencent.mm.plugin.qqmail.b.v$a */
    public static abstract class C21523a {
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

    /* renamed from: com.tencent.mm.plugin.qqmail.b.v$c */
    public static class C28746c {
        public boolean puO = false;
        public boolean puP = true;
        public boolean puQ = true;

        public final void toBundle(Bundle bundle) {
            AppMethodBeat.m2504i(68001);
            bundle.putBoolean("qqmail_httpoptions_expired", this.puO);
            bundle.putBoolean("qqmail_httpoptions_needcache", this.puP);
            bundle.putBoolean("qqmail_httpoptions_needparse", this.puQ);
            AppMethodBeat.m2505o(68001);
        }

        public final void fromBundle(Bundle bundle) {
            AppMethodBeat.m2504i(68002);
            this.puO = bundle.getBoolean("qqmail_httpoptions_expired");
            this.puP = bundle.getBoolean("qqmail_httpoptions_needcache");
            this.puQ = bundle.getBoolean("qqmail_httpoptions_needparse");
            AppMethodBeat.m2505o(68002);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.b.v$b */
    class C31388b extends AsyncTask<C39542d, Integer, C39542d> implements C28742a {
        private C43403n puL;
        C39542d puM;

        /* renamed from: com.tencent.mm.plugin.qqmail.b.v$b$1 */
        class C313891 implements Runnable {
            C313891() {
            }

            public final void run() {
                AppMethodBeat.m2504i(67993);
                if (C31388b.this.puL != null) {
                    C31388b.this.puL.cancel();
                }
                AppMethodBeat.m2505o(67993);
            }

            public final String toString() {
                AppMethodBeat.m2504i(67994);
                String str = super.toString() + "|onCancelled";
                AppMethodBeat.m2505o(67994);
                return str;
            }
        }

        private C31388b() {
        }

        /* synthetic */ C31388b(C39540v c39540v, byte b) {
            this();
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.m2504i(68000);
            C39542d c39542d = ((C39542d[]) objArr)[0];
            if (!C5046bo.isNullOrNil((String) c39542d.puS.pud.get("skey"))) {
                if (!c39542d.puR.puO && c39542d.puR.puP) {
                    String str;
                    byte[] t = C39540v.this.puF.mo46895t(c39542d.uri, c39542d.puS.puc);
                    if (t == null) {
                        str = null;
                    } else {
                        str = new String(t);
                    }
                    if (str != null) {
                        c39542d.puT = new C43402c(304, null, str);
                        if (c39542d.puR.puQ || !(c39542d.puT.status == 304 || c39542d.puT.status == 200)) {
                            C4990ab.m7413e("MicroMsg.NormalMailAppService", "http error, %d", Integer.valueOf(c39542d.puT.status));
                        } else {
                            c39542d.puU = C5049br.m7595z(c39542d.puT.content, "Response");
                        }
                    }
                }
                if (c39542d.puS.pue != null) {
                    this.puL = new C21521l();
                } else {
                    this.puL = new C44756m();
                }
                c39542d.puT = this.puL.mo36997a("https://", c39542d.uri, c39542d.puS, this);
                if (c39542d.puT == null) {
                    AppMethodBeat.m2505o(68000);
                    return null;
                }
                if (c39542d.puR.puQ) {
                }
                C4990ab.m7413e("MicroMsg.NormalMailAppService", "http error, %d", Integer.valueOf(c39542d.puT.status));
            }
            AppMethodBeat.m2505o(68000);
            return c39542d;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.m2504i(67999);
            C39542d c39542d = (C39542d) obj;
            if (c39542d != null) {
                if (C5046bo.isNullOrNil((String) c39542d.puS.pud.get("skey"))) {
                    c39542d.puV.onError(-5, "");
                } else if (c39542d.puT.status == 304) {
                    C39540v.m67560a(c39542d);
                } else if (c39542d.puT.status == 200) {
                    C39540v.m67563a(C39540v.this, c39542d.puT.pud);
                    if (C39540v.m67560a(c39542d) == 0 && c39542d.puR.puP) {
                        C39540v.this.puF.mo46893a(c39542d.uri, c39542d.puS.puc, c39542d.puT.content.getBytes());
                    }
                } else {
                    c39542d.puV.onError(c39542d.puT.status, C39540v.m67559Bq(c39542d.puT.status));
                }
                c39542d.puV.onComplete();
                C39540v.this.puG.remove(Long.valueOf(c39542d.f16179id));
                C39540v.this.puH.remove(Long.valueOf(c39542d.f16179id));
            }
            AppMethodBeat.m2505o(67999);
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onProgressUpdate(Object[] objArr) {
            AppMethodBeat.m2504i(67998);
            this.puM.puV.onProgress(((Integer[]) objArr)[0].intValue());
            AppMethodBeat.m2505o(67998);
        }

        /* renamed from: b */
        public final boolean mo51324b(C39542d c39542d) {
            AppMethodBeat.m2504i(67995);
            if (c39542d.puV.onReady()) {
                this.puM = c39542d;
                super.execute(new C39542d[]{c39542d});
                AppMethodBeat.m2505o(67995);
                return true;
            }
            AppMethodBeat.m2505o(67995);
            return false;
        }

        public final void ccp() {
            AppMethodBeat.m2504i(67996);
            publishProgress(new Integer[]{Integer.valueOf(0)});
            AppMethodBeat.m2505o(67996);
        }

        /* Access modifiers changed, original: protected|final */
        public final void onCancelled() {
            AppMethodBeat.m2504i(67997);
            C1720g.m3537RQ();
            C1720g.m3539RS().mo10302aa(new C313891());
            super.onCancelled();
            AppMethodBeat.m2505o(67997);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.b.v$d */
    class C39542d {
        /* renamed from: id */
        long f16179id = System.currentTimeMillis();
        C28746c puR;
        C39538b puS;
        C43402c puT;
        Map<String, String> puU;
        C21523a puV;
        String uri;

        public C39542d(String str, C39538b c39538b, C21523a c21523a) {
            AppMethodBeat.m2504i(68003);
            this.uri = str;
            this.puS = c39538b;
            this.puV = c21523a;
            AppMethodBeat.m2505o(68003);
        }
    }

    /* renamed from: Bq */
    static /* synthetic */ String m67559Bq(int i) {
        AppMethodBeat.m2504i(68023);
        String Bp = C39540v.m67558Bp(i);
        AppMethodBeat.m2505o(68023);
        return Bp;
    }

    public C39540v(int i, String str) {
        AppMethodBeat.m2504i(68004);
        C43403n.setHost("qqmail.weixin.qq.com:443");
        C43403n.setUserAgent("weixin/" + str + "/0x" + Integer.toHexString(i));
        reset();
        AppMethodBeat.m2505o(68004);
    }

    /* renamed from: a */
    public final long mo62491a(String str, Map<String, String> map, C21523a c21523a) {
        AppMethodBeat.m2504i(68005);
        long a = mo62492a(str, map, new C28746c(), c21523a);
        AppMethodBeat.m2505o(68005);
        return a;
    }

    /* renamed from: a */
    public final long mo62492a(String str, Map<String, String> map, C28746c c28746c, C21523a c21523a) {
        AppMethodBeat.m2504i(68006);
        long a = m67561a(str, 1, map, null, c28746c, c21523a);
        AppMethodBeat.m2505o(68006);
        return a;
    }

    /* renamed from: b */
    public final long mo62493b(String str, Map<String, String> map, C21523a c21523a) {
        AppMethodBeat.m2504i(68007);
        long b = mo62494b(str, map, new C28746c(), c21523a);
        AppMethodBeat.m2505o(68007);
        return b;
    }

    /* renamed from: b */
    public final long mo62494b(String str, Map<String, String> map, C28746c c28746c, C21523a c21523a) {
        AppMethodBeat.m2504i(68008);
        long a = m67561a(str, 0, map, null, c28746c, c21523a);
        AppMethodBeat.m2505o(68008);
        return a;
    }

    /* renamed from: a */
    public final long mo62490a(String str, String str2, String str3, C28746c c28746c, C21523a c21523a) {
        AppMethodBeat.m2504i(68009);
        long a = m67561a(str, 1, null, new C39539d(str2, str3), c28746c, c21523a);
        AppMethodBeat.m2505o(68009);
        return a;
    }

    public static String ccw() {
        return "https://qqmail.weixin.qq.com:443";
    }

    /* renamed from: a */
    private long m67561a(String str, int i, Map<String, String> map, C39539d c39539d, C28746c c28746c, C21523a c21523a) {
        Map map2;
        AppMethodBeat.m2504i(68010);
        if (map2 == null) {
            map2 = new HashMap();
        }
        map2.put("appname", "qqmail_weixin");
        map2.put("f", BaseTemplateParser.POSTFIX_ORIG);
        map2.put("charset", ProtocolPackage.ServerEncoding);
        map2.put("clientip", C39540v.getLocalIp());
        final C39542d c39542d = new C39542d(str, new C39538b(i, map2, getCookie(), c39539d), c21523a);
        c39542d.puR = c28746c;
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(67992);
                C31388b c31388b = new C31388b(C39540v.this, (byte) 0);
                C39540v.this.puG.put(Long.valueOf(c39542d.f16179id), c39542d);
                C39540v.this.puH.put(Long.valueOf(c39542d.f16179id), c31388b);
                c31388b.mo51324b(c39542d);
                AppMethodBeat.m2505o(67992);
            }
        });
        long j = c39542d.f16179id;
        AppMethodBeat.m2505o(68010);
        return j;
    }

    private void cancel() {
        AppMethodBeat.m2504i(68011);
        for (C31388b cancel : this.puH.values()) {
            cancel.cancel(true);
        }
        this.puH.clear();
        this.puG.clear();
        AppMethodBeat.m2505o(68011);
    }

    public final void cancel(long j) {
        AppMethodBeat.m2504i(68012);
        C31388b c31388b = (C31388b) this.puH.get(Long.valueOf(j));
        if (c31388b != null) {
            c31388b.onCancelled();
            c31388b.cancel(true);
        }
        this.puH.remove(Long.valueOf(j));
        this.puG.remove(Long.valueOf(j));
        AppMethodBeat.m2505o(68012);
    }

    public final void reset() {
        AppMethodBeat.m2504i(68013);
        C43403n.m77460Vg(C39540v.getDownloadPath());
        cancel();
        this.pud.clear();
        String ccx = C39540v.ccx();
        this.puD = new C46149p(ccx + "addr/");
        this.puE = new C21519i(ccx + "draft/");
        this.puF = new C28741k(ccx + "http/", 0);
        AppMethodBeat.m2505o(68013);
    }

    public final void clearData() {
        AppMethodBeat.m2504i(68014);
        C5730e.m8618N(C39540v.ccx(), true);
        reset();
        AppMethodBeat.m2505o(68014);
    }

    public static String getDownloadPath() {
        AppMethodBeat.m2504i(68015);
        String str = C6457e.euQ;
        C5730e.m8643tf(str);
        AppMethodBeat.m2505o(68015);
        return str;
    }

    private static String getLocalIp() {
        AppMethodBeat.m2504i(68016);
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        String hostAddress = inetAddress.getHostAddress();
                        AppMethodBeat.m2505o(68016);
                        return hostAddress;
                    }
                }
            }
        } catch (Exception | SocketException e) {
        }
        AppMethodBeat.m2505o(68016);
        return null;
    }

    public final Map<String, String> getCookie() {
        Object obj;
        AppMethodBeat.m2504i(68017);
        String str = (String) C1720g.m3536RP().mo5239Ry().get(-1535680990, null);
        Map map = this.pud;
        String str2 = "skey";
        if (str == null) {
            obj = "";
        } else {
            String obj2 = str;
        }
        map.put(str2, obj2);
        this.pud.put(OpenSDKTool4Assistant.EXTRA_UIN, "o" + new C1183p(C5046bo.m7550g(C1720g.m3536RP().mo5239Ry().get(9, null), 0)));
        C4990ab.m7411d("MicroMsg.NormalMailAppService", "sKey:%b, uin:%d", Boolean.valueOf(C5046bo.isNullOrNil(str)), Integer.valueOf(r1));
        Map map2 = this.pud;
        AppMethodBeat.m2505o(68017);
        return map2;
    }

    /* renamed from: aX */
    private static String m67564aX(int i, String str) {
        AppMethodBeat.m2504i(68019);
        int i2 = 0;
        switch (i) {
            case ZipJNI.UNZ_CRCERROR /*-105*/:
            case -6:
                i2 = C25738R.string.ddz;
                break;
            case ZipJNI.UNZ_INTERNALERROR /*-104*/:
                i2 = C25738R.string.ddx;
                break;
            case ZipJNI.UNZ_BADZIPFILE /*-103*/:
                i2 = C25738R.string.ddw;
                break;
            case ZipJNI.UNZ_PARAMERROR /*-102*/:
                i2 = C25738R.string.ddv;
                break;
            case -7:
                i2 = C25738R.string.de0;
                break;
            case -4:
            case -3:
                i2 = C25738R.string.ddy;
                break;
            case -1:
                i2 = C25738R.string.ddt;
                break;
        }
        if (i2 == 0) {
            AppMethodBeat.m2505o(68019);
            return str;
        }
        str = C1338a.m2858an(C4996ah.getContext(), i2);
        AppMethodBeat.m2505o(68019);
        return str;
    }

    private static String ccx() {
        AppMethodBeat.m2504i(68020);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3537RQ();
        String stringBuilder2 = stringBuilder.append(C1720g.m3536RP().eJM).append("mailapp/").toString();
        AppMethodBeat.m2505o(68020);
        return stringBuilder2;
    }

    /* renamed from: Bp */
    private static String m67558Bp(int i) {
        AppMethodBeat.m2504i(68018);
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
            str = C39540v.m67564aX(i, "request error");
            AppMethodBeat.m2505o(68018);
            return str;
        }
        AppMethodBeat.m2505o(68018);
        return str;
    }

    /* renamed from: a */
    static /* synthetic */ void m67563a(C39540v c39540v, Map map) {
        AppMethodBeat.m2504i(68022);
        if (c39540v.pud == null || map == null) {
            AppMethodBeat.m2505o(68022);
            return;
        }
        for (String str : map.keySet()) {
            c39540v.pud.put(str, map.get(str));
        }
        AppMethodBeat.m2505o(68022);
    }
}
