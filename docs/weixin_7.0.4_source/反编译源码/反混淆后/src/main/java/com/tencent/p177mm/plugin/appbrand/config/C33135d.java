package com.tencent.p177mm.plugin.appbrand.config;

import android.webkit.WebSettings;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.jsapi.file.C33305a;
import com.tencent.p177mm.plugin.appbrand.p328r.C10707q;
import com.tencent.p177mm.plugin.appbrand.p328r.C10707q.C10708a;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.plugin.appbrand.p328r.C45672d;
import com.tencent.p177mm.protocal.protobuf.azz;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.appbrand.config.d */
public final class C33135d {
    /* renamed from: s */
    public static ArrayList<byte[]> m54172s(C6750i c6750i) {
        AppMethodBeat.m2504i(101789);
        ArrayList<byte[]> arrayList = new ArrayList();
        C19681j c19681j = new C19681j();
        c6750i.asE().mo5843b("cer", c19681j);
        if (c19681j.value == null) {
            AppMethodBeat.m2505o(101789);
            return arrayList;
        }
        byte[] q = C45672d.m84374q((ByteBuffer) c19681j.value);
        try {
            azz azz = new azz();
            azz.parseFrom(q);
            if (azz.wDN == null) {
                AppMethodBeat.m2505o(101789);
                return arrayList;
            }
            Iterator it = azz.wDN.iterator();
            while (it.hasNext()) {
                arrayList.add(((C1332b) it.next()).f1226wR);
            }
            AppMethodBeat.m2505o(101789);
            return arrayList;
        } catch (Exception e) {
            C4990ab.m7412e("", "readPkgCertificate, parse error: ".concat(String.valueOf(e)));
        }
    }

    @Deprecated
    /* renamed from: a */
    public static void m54169a(AppBrandSysConfigLU appBrandSysConfigLU) {
        appBrandSysConfigLU.cwz = appBrandSysConfigLU.cwz;
        appBrandSysConfigLU.appId = appBrandSysConfigLU.appId;
        appBrandSysConfigLU.hgW = appBrandSysConfigLU.hgW;
        appBrandSysConfigLU.hgX = appBrandSysConfigLU.hgX;
        appBrandSysConfigLU.hhb = appBrandSysConfigLU.hhb;
        appBrandSysConfigLU.hhc = appBrandSysConfigLU.hhc;
        appBrandSysConfigLU.hhd = appBrandSysConfigLU.hhd;
        appBrandSysConfigLU.hgY = appBrandSysConfigLU.hgY;
    }

    /* renamed from: b */
    public static C33305a m54170b(AppBrandSysConfigLU appBrandSysConfigLU) {
        AppMethodBeat.m2504i(101790);
        C33305a c33305a = new C33305a();
        c33305a.bQD = appBrandSysConfigLU.bQD;
        if (c33305a.bQD <= 0) {
            c33305a.bQD = 10;
        }
        c33305a.hgg = appBrandSysConfigLU.bQO.hgg;
        if (c33305a.hgg <= 0) {
            c33305a.hgg = 30;
        }
        AppMethodBeat.m2505o(101790);
        return c33305a;
    }

    /* renamed from: n */
    public static int m54171n(int... iArr) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 >= 2) {
                return i3;
            }
            i = iArr[i2];
            if (i <= 0 || (i3 != 0 && i >= i3)) {
                i = i3;
            }
            i2++;
        }
    }

    public static String ayy() {
        String defaultUserAgent;
        AppMethodBeat.m2504i(101791);
        try {
            defaultUserAgent = WebSettings.getDefaultUserAgent(C4996ah.getContext());
        } catch (Exception e) {
            defaultUserAgent = System.getProperty("http.agent");
        }
        String a = C10707q.m18380a(C4996ah.getContext(), defaultUserAgent, (C10708a) C37384e.m62985B(C10708a.class));
        AppMethodBeat.m2505o(101791);
        return a;
    }
}
