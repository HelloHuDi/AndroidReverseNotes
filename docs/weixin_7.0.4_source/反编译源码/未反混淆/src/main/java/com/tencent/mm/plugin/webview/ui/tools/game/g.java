package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public final class g {
    private static HashMap<String, g> uDS = new HashMap();
    public long startTime;
    public long uDL;
    public long uDM;
    public long uDN;
    public long uDO;
    public long uDP;
    public long uDQ;
    public long uDR;
    public String url;

    public static class a implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
        public final /* synthetic */ void a(Object obj, c cVar) {
            AppMethodBeat.i(8706);
            Bundle bundle = (Bundle) obj;
            int i = bundle.getInt("type");
            String string = bundle.getString("url");
            long j = bundle.getLong("time", System.currentTimeMillis());
            switch (i) {
                case 1:
                    g.az(string, j);
                    AppMethodBeat.o(8706);
                    return;
                case 2:
                    g.aA(string, j);
                    AppMethodBeat.o(8706);
                    return;
                case 3:
                    g.aB(string, j);
                    AppMethodBeat.o(8706);
                    return;
                case 4:
                    g.aC(string, j);
                    AppMethodBeat.o(8706);
                    return;
                case 5:
                    g.aD(string, j);
                    AppMethodBeat.o(8706);
                    return;
                case 6:
                    g.aE(string, j);
                    AppMethodBeat.o(8706);
                    return;
                case 7:
                    g.aF(string, j);
                    AppMethodBeat.o(8706);
                    return;
                case 8:
                    g.aG(string, j);
                    break;
            }
            AppMethodBeat.o(8706);
        }
    }

    static {
        AppMethodBeat.i(8719);
        AppMethodBeat.o(8719);
    }

    public static g agg(String str) {
        AppMethodBeat.i(8707);
        if (uDS.containsKey(str)) {
            uDS.remove(str);
        }
        g gVar = new g();
        gVar.url = str;
        uDS.put(str, gVar);
        AppMethodBeat.o(8707);
        return gVar;
    }

    public static g agh(String str) {
        AppMethodBeat.i(8708);
        g gVar;
        if (uDS.containsKey(str)) {
            gVar = (g) uDS.get(str);
            AppMethodBeat.o(8708);
            return gVar;
        }
        gVar = new g();
        gVar.url = str;
        uDS.put(str, gVar);
        AppMethodBeat.o(8708);
        return gVar;
    }

    public static g agi(String str) {
        AppMethodBeat.i(8709);
        g gVar = (g) uDS.remove(str);
        AppMethodBeat.o(8709);
        return gVar;
    }

    public static void az(String str, long j) {
        AppMethodBeat.i(8710);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(8710);
        } else if (ah.doF()) {
            agh(str).startTime = j;
            AppMethodBeat.o(8710);
        } else {
            f.a("com.tencent.mm:tools", a(1, str, j), a.class, null);
            AppMethodBeat.o(8710);
        }
    }

    public static void aA(String str, long j) {
        AppMethodBeat.i(8711);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(8711);
        } else if (ah.doF()) {
            agh(str).uDL = j;
            AppMethodBeat.o(8711);
        } else {
            f.a("com.tencent.mm:tools", a(2, str, j), a.class, null);
            AppMethodBeat.o(8711);
        }
    }

    public static void aB(String str, long j) {
        AppMethodBeat.i(8712);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(8712);
        } else if (ah.doF()) {
            agh(str).uDM = j;
            AppMethodBeat.o(8712);
        } else {
            f.a("com.tencent.mm:tools", a(3, str, j), a.class, null);
            AppMethodBeat.o(8712);
        }
    }

    public static void aC(String str, long j) {
        AppMethodBeat.i(8713);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(8713);
        } else if (ah.doF()) {
            agh(str).uDN = j;
            AppMethodBeat.o(8713);
        } else {
            f.a("com.tencent.mm:tools", a(4, str, j), a.class, null);
            AppMethodBeat.o(8713);
        }
    }

    public static void aD(String str, long j) {
        AppMethodBeat.i(8714);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(8714);
        } else if (ah.doF()) {
            agh(str).uDO = j;
            AppMethodBeat.o(8714);
        } else {
            f.a("com.tencent.mm:tools", a(5, str, j), a.class, null);
            AppMethodBeat.o(8714);
        }
    }

    public static void aE(String str, long j) {
        AppMethodBeat.i(8715);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(8715);
        } else if (ah.doF()) {
            agh(str).uDP = j;
            AppMethodBeat.o(8715);
        } else {
            f.a("com.tencent.mm:tools", a(6, str, j), a.class, null);
            AppMethodBeat.o(8715);
        }
    }

    public static void aF(String str, long j) {
        AppMethodBeat.i(8716);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(8716);
        } else if (ah.doF()) {
            agh(str).uDQ = j;
            AppMethodBeat.o(8716);
        } else {
            f.a("com.tencent.mm:tools", a(7, str, j), a.class, null);
            AppMethodBeat.o(8716);
        }
    }

    public static void aG(String str, long j) {
        AppMethodBeat.i(8717);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(8717);
        } else if (ah.doF()) {
            agh(str).uDR = j;
            AppMethodBeat.o(8717);
        } else {
            f.a("com.tencent.mm:tools", a(8, str, j), a.class, null);
            AppMethodBeat.o(8717);
        }
    }

    private static Bundle a(int i, String str, long j) {
        AppMethodBeat.i(8718);
        Bundle bundle = new Bundle();
        bundle.putInt("type", i);
        bundle.putString("url", str);
        bundle.putLong("time", j);
        AppMethodBeat.o(8718);
        return bundle;
    }
}
