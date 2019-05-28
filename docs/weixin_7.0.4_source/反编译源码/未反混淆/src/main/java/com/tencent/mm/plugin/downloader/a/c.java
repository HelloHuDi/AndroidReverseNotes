package com.tencent.mm.plugin.downloader.a;

import android.net.Uri;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hg;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c {
    private static final String[] kKf = new String[]{"dlied4.myapp.com", "dlied5.myapp.com"};
    private static final Map<String, String> kKg = new ConcurrentHashMap();

    static class a implements i<IPCString, IPCString> {
        private a() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(67886);
            IPCString iPCString = (IPCString) obj;
            if (iPCString == null) {
                AppMethodBeat.o(67886);
                return null;
            }
            String str = iPCString.value;
            String str2 = (String) c.kKg.get(str);
            if (bo.isNullOrNil(str2)) {
                hg hgVar = new hg();
                hgVar.cCb.url = str;
                com.tencent.mm.sdk.b.a.xxA.m(hgVar);
                str2 = hgVar.cCc.csB;
            }
            if (Looper.getMainLooper() == Looper.myLooper()) {
                ab.i("MicroMsg.GameDownloadExtension", "getOpenId invoke in main thread");
                f bT = g.bT(str2, false);
                str2 = (bT == null || bo.isNullOrNil(bT.field_openId)) ? null : bT.field_openId;
            } else {
                ab.i("MicroMsg.GameDownloadExtension", "getOpenId invoke in worker thread");
                com.tencent.mm.plugin.s.a.bYL();
                str2 = m.aiN(str2);
            }
            Object iPCString2 = new IPCString(str2);
            AppMethodBeat.o(67886);
            return iPCString2;
        }
    }

    static {
        AppMethodBeat.i(67892);
        AppMethodBeat.o(67892);
    }

    public static synchronized void h(String str, String... strArr) {
        synchronized (c.class) {
            AppMethodBeat.i(67887);
            if (!bo.isNullOrNil(str)) {
                for (int i = 0; i < 2; i++) {
                    if (!bo.isNullOrNil(strArr[i])) {
                        kKg.put(strArr[i], str);
                    }
                }
            }
            AppMethodBeat.o(67887);
        }
    }

    public static synchronized void o(String... strArr) {
        synchronized (c.class) {
            AppMethodBeat.i(67888);
            for (int i = 0; i < 2; i++) {
                if (!bo.isNullOrNil(strArr[i])) {
                    kKg.remove(strArr[i]);
                }
            }
            AppMethodBeat.o(67888);
        }
    }

    public static void clearCache() {
        AppMethodBeat.i(67889);
        kKg.clear();
        AppMethodBeat.o(67889);
    }

    private static String dC(String str, String str2) {
        AppMethodBeat.i(67891);
        try {
            String str3;
            URI uri = new URI(str);
            String query = uri.getQuery();
            if (query == null) {
                str3 = str2;
            } else {
                str3 = query + "&" + str2;
            }
            str = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), str3, uri.getFragment()).toString();
            AppMethodBeat.o(67891);
        } catch (URISyntaxException e) {
            AppMethodBeat.o(67891);
        }
        return str;
    }

    public static String Ij(String str) {
        String str2;
        AppMethodBeat.i(67890);
        if (bo.isNullOrNil(str)) {
            str2 = "";
        } else {
            str2 = Uri.parse(str).getHost();
        }
        if (bo.isNullOrNil(str2) || !Arrays.asList(kKf).contains(str2)) {
            ab.i("MicroMsg.GameDownloadExtension", "domain is not dlied4/dlied5");
            AppMethodBeat.o(67890);
            return str;
        }
        IPCString iPCString = (IPCString) com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", new IPCString(str), a.class);
        String str3 = "";
        if (iPCString != null) {
            str2 = iPCString.value;
        } else {
            str2 = str3;
        }
        ab.i("MicroMsg.GameDownloadExtension", "after openid added, url: %s", dC(dC(str, String.format("openid=%s", new Object[]{str2})), "p=wechat"));
        AppMethodBeat.o(67890);
        return dC(dC(str, String.format("openid=%s", new Object[]{str2})), "p=wechat");
    }
}
