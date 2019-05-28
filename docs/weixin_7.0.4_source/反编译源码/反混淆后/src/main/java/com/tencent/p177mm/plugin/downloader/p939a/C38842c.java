package com.tencent.p177mm.plugin.downloader.p939a;

import android.net.Uri;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.ipcinvoker.type.IPCString;
import com.tencent.p177mm.p230g.p231a.C18283hg;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.model.app.C4735m;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.downloader.a.c */
public final class C38842c {
    private static final String[] kKf = new String[]{"dlied4.myapp.com", "dlied5.myapp.com"};
    private static final Map<String, String> kKg = new ConcurrentHashMap();

    /* renamed from: com.tencent.mm.plugin.downloader.a.c$a */
    static class C11499a implements C45413i<IPCString, IPCString> {
        private C11499a() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(67886);
            IPCString iPCString = (IPCString) obj;
            if (iPCString == null) {
                AppMethodBeat.m2505o(67886);
                return null;
            }
            String str = iPCString.value;
            String str2 = (String) C38842c.kKg.get(str);
            if (C5046bo.isNullOrNil(str2)) {
                C18283hg c18283hg = new C18283hg();
                c18283hg.cCb.url = str;
                C4879a.xxA.mo10055m(c18283hg);
                str2 = c18283hg.cCc.csB;
            }
            if (Looper.getMainLooper() == Looper.myLooper()) {
                C4990ab.m7416i("MicroMsg.GameDownloadExtension", "getOpenId invoke in main thread");
                C40439f bT = C46494g.m87739bT(str2, false);
                str2 = (bT == null || C5046bo.isNullOrNil(bT.field_openId)) ? null : bT.field_openId;
            } else {
                C4990ab.m7416i("MicroMsg.GameDownloadExtension", "getOpenId invoke in worker thread");
                C34832a.bYL();
                str2 = C4735m.aiN(str2);
            }
            Object iPCString2 = new IPCString(str2);
            AppMethodBeat.m2505o(67886);
            return iPCString2;
        }
    }

    static {
        AppMethodBeat.m2504i(67892);
        AppMethodBeat.m2505o(67892);
    }

    /* renamed from: h */
    public static synchronized void m65896h(String str, String... strArr) {
        synchronized (C38842c.class) {
            AppMethodBeat.m2504i(67887);
            if (!C5046bo.isNullOrNil(str)) {
                for (int i = 0; i < 2; i++) {
                    if (!C5046bo.isNullOrNil(strArr[i])) {
                        kKg.put(strArr[i], str);
                    }
                }
            }
            AppMethodBeat.m2505o(67887);
        }
    }

    /* renamed from: o */
    public static synchronized void m65897o(String... strArr) {
        synchronized (C38842c.class) {
            AppMethodBeat.m2504i(67888);
            for (int i = 0; i < 2; i++) {
                if (!C5046bo.isNullOrNil(strArr[i])) {
                    kKg.remove(strArr[i]);
                }
            }
            AppMethodBeat.m2505o(67888);
        }
    }

    public static void clearCache() {
        AppMethodBeat.m2504i(67889);
        kKg.clear();
        AppMethodBeat.m2505o(67889);
    }

    /* renamed from: dC */
    private static String m65895dC(String str, String str2) {
        AppMethodBeat.m2504i(67891);
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
            AppMethodBeat.m2505o(67891);
        } catch (URISyntaxException e) {
            AppMethodBeat.m2505o(67891);
        }
        return str;
    }

    /* renamed from: Ij */
    public static String m65894Ij(String str) {
        String str2;
        AppMethodBeat.m2504i(67890);
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
        } else {
            str2 = Uri.parse(str).getHost();
        }
        if (C5046bo.isNullOrNil(str2) || !Arrays.asList(kKf).contains(str2)) {
            C4990ab.m7416i("MicroMsg.GameDownloadExtension", "domain is not dlied4/dlied5");
            AppMethodBeat.m2505o(67890);
            return str;
        }
        IPCString iPCString = (IPCString) C9549f.m17010a("com.tencent.mm", new IPCString(str), C11499a.class);
        String str3 = "";
        if (iPCString != null) {
            str2 = iPCString.value;
        } else {
            str2 = str3;
        }
        C4990ab.m7417i("MicroMsg.GameDownloadExtension", "after openid added, url: %s", C38842c.m65895dC(C38842c.m65895dC(str, String.format("openid=%s", new Object[]{str2})), "p=wechat"));
        AppMethodBeat.m2505o(67890);
        return C38842c.m65895dC(C38842c.m65895dC(str, String.format("openid=%s", new Object[]{str2})), "p=wechat");
    }
}
