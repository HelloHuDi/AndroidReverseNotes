package com.tencent.mm.plugin.appbrand.config;

import android.webkit.WebSettings;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.file.a;
import com.tencent.mm.plugin.appbrand.r.j;
import com.tencent.mm.plugin.appbrand.r.q;
import com.tencent.mm.protocal.protobuf.azz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

public final class d {
    public static ArrayList<byte[]> s(i iVar) {
        AppMethodBeat.i(101789);
        ArrayList<byte[]> arrayList = new ArrayList();
        j jVar = new j();
        iVar.asE().b("cer", jVar);
        if (jVar.value == null) {
            AppMethodBeat.o(101789);
            return arrayList;
        }
        byte[] q = com.tencent.mm.plugin.appbrand.r.d.q((ByteBuffer) jVar.value);
        try {
            azz azz = new azz();
            azz.parseFrom(q);
            if (azz.wDN == null) {
                AppMethodBeat.o(101789);
                return arrayList;
            }
            Iterator it = azz.wDN.iterator();
            while (it.hasNext()) {
                arrayList.add(((b) it.next()).wR);
            }
            AppMethodBeat.o(101789);
            return arrayList;
        } catch (Exception e) {
            ab.e("", "readPkgCertificate, parse error: ".concat(String.valueOf(e)));
        }
    }

    @Deprecated
    public static void a(AppBrandSysConfigLU appBrandSysConfigLU) {
        appBrandSysConfigLU.cwz = appBrandSysConfigLU.cwz;
        appBrandSysConfigLU.appId = appBrandSysConfigLU.appId;
        appBrandSysConfigLU.hgW = appBrandSysConfigLU.hgW;
        appBrandSysConfigLU.hgX = appBrandSysConfigLU.hgX;
        appBrandSysConfigLU.hhb = appBrandSysConfigLU.hhb;
        appBrandSysConfigLU.hhc = appBrandSysConfigLU.hhc;
        appBrandSysConfigLU.hhd = appBrandSysConfigLU.hhd;
        appBrandSysConfigLU.hgY = appBrandSysConfigLU.hgY;
    }

    public static a b(AppBrandSysConfigLU appBrandSysConfigLU) {
        AppMethodBeat.i(101790);
        a aVar = new a();
        aVar.bQD = appBrandSysConfigLU.bQD;
        if (aVar.bQD <= 0) {
            aVar.bQD = 10;
        }
        aVar.hgg = appBrandSysConfigLU.bQO.hgg;
        if (aVar.hgg <= 0) {
            aVar.hgg = 30;
        }
        AppMethodBeat.o(101790);
        return aVar;
    }

    public static int n(int... iArr) {
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
        AppMethodBeat.i(101791);
        try {
            defaultUserAgent = WebSettings.getDefaultUserAgent(ah.getContext());
        } catch (Exception e) {
            defaultUserAgent = System.getProperty("http.agent");
        }
        String a = q.a(ah.getContext(), defaultUserAgent, (q.a) e.B(q.a.class));
        AppMethodBeat.o(101791);
        return a;
    }
}
