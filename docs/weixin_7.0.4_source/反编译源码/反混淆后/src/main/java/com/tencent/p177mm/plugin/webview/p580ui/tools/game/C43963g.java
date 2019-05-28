package com.tencent.p177mm.plugin.webview.p580ui.tools.game;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.g */
public final class C43963g {
    private static HashMap<String, C43963g> uDS = new HashMap();
    public long startTime;
    public long uDL;
    public long uDM;
    public long uDN;
    public long uDO;
    public long uDP;
    public long uDQ;
    public long uDR;
    public String url;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.g$a */
    public static class C43964a implements C37866a<Bundle, Bundle> {
        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(8706);
            Bundle bundle = (Bundle) obj;
            int i = bundle.getInt("type");
            String string = bundle.getString("url");
            long j = bundle.getLong("time", System.currentTimeMillis());
            switch (i) {
                case 1:
                    C43963g.m78905az(string, j);
                    AppMethodBeat.m2505o(8706);
                    return;
                case 2:
                    C43963g.m78898aA(string, j);
                    AppMethodBeat.m2505o(8706);
                    return;
                case 3:
                    C43963g.m78899aB(string, j);
                    AppMethodBeat.m2505o(8706);
                    return;
                case 4:
                    C43963g.m78900aC(string, j);
                    AppMethodBeat.m2505o(8706);
                    return;
                case 5:
                    C43963g.m78901aD(string, j);
                    AppMethodBeat.m2505o(8706);
                    return;
                case 6:
                    C43963g.m78902aE(string, j);
                    AppMethodBeat.m2505o(8706);
                    return;
                case 7:
                    C43963g.m78903aF(string, j);
                    AppMethodBeat.m2505o(8706);
                    return;
                case 8:
                    C43963g.m78904aG(string, j);
                    break;
            }
            AppMethodBeat.m2505o(8706);
        }
    }

    static {
        AppMethodBeat.m2504i(8719);
        AppMethodBeat.m2505o(8719);
    }

    public static C43963g agg(String str) {
        AppMethodBeat.m2504i(8707);
        if (uDS.containsKey(str)) {
            uDS.remove(str);
        }
        C43963g c43963g = new C43963g();
        c43963g.url = str;
        uDS.put(str, c43963g);
        AppMethodBeat.m2505o(8707);
        return c43963g;
    }

    public static C43963g agh(String str) {
        AppMethodBeat.m2504i(8708);
        C43963g c43963g;
        if (uDS.containsKey(str)) {
            c43963g = (C43963g) uDS.get(str);
            AppMethodBeat.m2505o(8708);
            return c43963g;
        }
        c43963g = new C43963g();
        c43963g.url = str;
        uDS.put(str, c43963g);
        AppMethodBeat.m2505o(8708);
        return c43963g;
    }

    public static C43963g agi(String str) {
        AppMethodBeat.m2504i(8709);
        C43963g c43963g = (C43963g) uDS.remove(str);
        AppMethodBeat.m2505o(8709);
        return c43963g;
    }

    /* renamed from: az */
    public static void m78905az(String str, long j) {
        AppMethodBeat.m2504i(8710);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(8710);
        } else if (C4996ah.doF()) {
            C43963g.agh(str).startTime = j;
            AppMethodBeat.m2505o(8710);
        } else {
            C9549f.m17012a("com.tencent.mm:tools", C43963g.m78897a(1, str, j), C43964a.class, null);
            AppMethodBeat.m2505o(8710);
        }
    }

    /* renamed from: aA */
    public static void m78898aA(String str, long j) {
        AppMethodBeat.m2504i(8711);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(8711);
        } else if (C4996ah.doF()) {
            C43963g.agh(str).uDL = j;
            AppMethodBeat.m2505o(8711);
        } else {
            C9549f.m17012a("com.tencent.mm:tools", C43963g.m78897a(2, str, j), C43964a.class, null);
            AppMethodBeat.m2505o(8711);
        }
    }

    /* renamed from: aB */
    public static void m78899aB(String str, long j) {
        AppMethodBeat.m2504i(8712);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(8712);
        } else if (C4996ah.doF()) {
            C43963g.agh(str).uDM = j;
            AppMethodBeat.m2505o(8712);
        } else {
            C9549f.m17012a("com.tencent.mm:tools", C43963g.m78897a(3, str, j), C43964a.class, null);
            AppMethodBeat.m2505o(8712);
        }
    }

    /* renamed from: aC */
    public static void m78900aC(String str, long j) {
        AppMethodBeat.m2504i(8713);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(8713);
        } else if (C4996ah.doF()) {
            C43963g.agh(str).uDN = j;
            AppMethodBeat.m2505o(8713);
        } else {
            C9549f.m17012a("com.tencent.mm:tools", C43963g.m78897a(4, str, j), C43964a.class, null);
            AppMethodBeat.m2505o(8713);
        }
    }

    /* renamed from: aD */
    public static void m78901aD(String str, long j) {
        AppMethodBeat.m2504i(8714);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(8714);
        } else if (C4996ah.doF()) {
            C43963g.agh(str).uDO = j;
            AppMethodBeat.m2505o(8714);
        } else {
            C9549f.m17012a("com.tencent.mm:tools", C43963g.m78897a(5, str, j), C43964a.class, null);
            AppMethodBeat.m2505o(8714);
        }
    }

    /* renamed from: aE */
    public static void m78902aE(String str, long j) {
        AppMethodBeat.m2504i(8715);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(8715);
        } else if (C4996ah.doF()) {
            C43963g.agh(str).uDP = j;
            AppMethodBeat.m2505o(8715);
        } else {
            C9549f.m17012a("com.tencent.mm:tools", C43963g.m78897a(6, str, j), C43964a.class, null);
            AppMethodBeat.m2505o(8715);
        }
    }

    /* renamed from: aF */
    public static void m78903aF(String str, long j) {
        AppMethodBeat.m2504i(8716);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(8716);
        } else if (C4996ah.doF()) {
            C43963g.agh(str).uDQ = j;
            AppMethodBeat.m2505o(8716);
        } else {
            C9549f.m17012a("com.tencent.mm:tools", C43963g.m78897a(7, str, j), C43964a.class, null);
            AppMethodBeat.m2505o(8716);
        }
    }

    /* renamed from: aG */
    public static void m78904aG(String str, long j) {
        AppMethodBeat.m2504i(8717);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(8717);
        } else if (C4996ah.doF()) {
            C43963g.agh(str).uDR = j;
            AppMethodBeat.m2505o(8717);
        } else {
            C9549f.m17012a("com.tencent.mm:tools", C43963g.m78897a(8, str, j), C43964a.class, null);
            AppMethodBeat.m2505o(8717);
        }
    }

    /* renamed from: a */
    private static Bundle m78897a(int i, String str, long j) {
        AppMethodBeat.m2504i(8718);
        Bundle bundle = new Bundle();
        bundle.putInt("type", i);
        bundle.putString("url", str);
        bundle.putLong("time", j);
        AppMethodBeat.m2505o(8718);
        return bundle;
    }
}
