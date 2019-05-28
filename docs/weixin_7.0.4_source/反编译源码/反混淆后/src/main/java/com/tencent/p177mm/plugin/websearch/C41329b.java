package com.tencent.p177mm.plugin.websearch;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.websearch.api.C35573ai;
import com.tencent.p177mm.plugin.websearch.api.C40193m;
import com.tencent.p177mm.protocal.protobuf.bur;
import com.tencent.p177mm.protocal.protobuf.bus;
import com.tencent.p177mm.sdk.platformtools.C30284ar;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.websearch.b */
public final class C41329b implements C40193m {
    private static String tZm = "websearch_";
    private static String tZn;
    private static String tZo;
    private Runnable tZk;
    private Runnable tZl;

    /* renamed from: com.tencent.mm.plugin.websearch.b$1 */
    class C413301 implements C1224a {
        C413301() {
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.b$2 */
    class C413312 implements C1224a {
        C413312() {
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            return 0;
        }
    }

    private static SharedPreferences cUI() {
        AppMethodBeat.m2504i(91343);
        C41329b.init();
        C4990ab.m7417i("WebSearchPrivacyMgr", " sp name %s ", tZm);
        SharedPreferences s = C30284ar.m48183s(C4996ah.getContext(), tZm, 0);
        AppMethodBeat.m2505o(91343);
        return s;
    }

    public static void init() {
        AppMethodBeat.m2504i(91344);
        if (tZn == null) {
            C41329b.cUJ();
        }
        AppMethodBeat.m2505o(91344);
    }

    public static void cUJ() {
        AppMethodBeat.m2504i(91345);
        C4990ab.m7416i("WebSearchPrivacyMgr", "reInit");
        StringBuilder stringBuilder = new StringBuilder("websearch_");
        C1720g.m3534RN();
        tZm = stringBuilder.append(C1668a.m3384QG()).toString();
        Object obj = C1720g.m3536RP().mo5239Ry().get(274436, (Object) "");
        String str = "en";
        if (obj != null) {
            str = obj.toString();
        }
        tZn = C4996ah.getContext().getString(C25738R.string.g8d, new Object[]{C4988aa.dor(), str});
        tZo = C4996ah.getContext().getString(C25738R.string.g6j, new Object[]{C4988aa.dor(), str});
        AppMethodBeat.m2505o(91345);
    }

    public final void cUK() {
        AppMethodBeat.m2504i(91346);
        C4990ab.m7416i("WebSearchPrivacyMgr", "openSearch ");
        C41329b.init();
        if (this.tZk != null) {
            this.tZk.run();
            if (this.tZk == this.tZk) {
                this.tZk = null;
            }
        }
        C41329b.cUI().edit().putBoolean("websearch_confirmed", true).commit();
        bur bur = new bur();
        bur.wWg = 1;
        bur.Timestamp = (int) (System.currentTimeMillis() / 1000);
        bur.nbk = 1;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = bur;
        c1196a.fsK = new bus();
        c1196a.uri = "/cgi-bin/mmsearch-bin/searchconfirm";
        c1196a.fsI = 2957;
        C1226w.m2654a(c1196a.acD(), new C413301());
        AppMethodBeat.m2505o(91346);
    }

    public final void cUL() {
        AppMethodBeat.m2504i(91347);
        C4990ab.m7416i("WebSearchPrivacyMgr", "closeSearch ");
        C41329b.init();
        if (this.tZl != null) {
            this.tZl.run();
            if (this.tZl == this.tZl) {
                this.tZl = null;
            }
        }
        C41329b.cUI().edit().putBoolean("websearch_confirmed", false).commit();
        bur bur = new bur();
        bur.wWg = 1;
        bur.Timestamp = (int) (System.currentTimeMillis() / 1000);
        bur.nbk = 2;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = bur;
        c1196a.fsK = new bus();
        c1196a.uri = "/cgi-bin/mmsearch-bin/searchconfirm";
        c1196a.fsI = 2957;
        C1226w.m2654a(c1196a.acD(), new C413312());
        ((C12029n) C1720g.m3530M(C12029n.class)).deleteSOSHistory();
        if (C35573ai.uaA != null) {
            C35573ai.uaA = null;
        }
        C4996ah.getContext().getSharedPreferences("fts_recent_biz_sp", 0).edit().remove(C35573ai.cVl()).commit();
        AppMethodBeat.m2505o(91347);
    }

    /* renamed from: a */
    public final void mo63531a(Context context, Runnable runnable) {
        AppMethodBeat.m2504i(91348);
        C41329b.init();
        if (C41329b.cUI().getBoolean("websearch_confirmed", false) || !C17950b.m28216sO((String) C1720g.m3536RP().mo5239Ry().get(274436, null))) {
            runnable.run();
            AppMethodBeat.m2505o(91348);
            return;
        }
        this.tZk = runnable;
        C41329b.m72086bg(context, tZn);
        AppMethodBeat.m2505o(91348);
    }

    /* renamed from: b */
    public final boolean mo63532b(Context context, Runnable runnable) {
        AppMethodBeat.m2504i(91349);
        C41329b.init();
        if (C17950b.m28216sO((String) C1720g.m3536RP().mo5239Ry().get(274436, null))) {
            this.tZl = runnable;
            C41329b.m72086bg(context, tZo);
            AppMethodBeat.m2505o(91349);
            return true;
        }
        runnable.run();
        AppMethodBeat.m2505o(91349);
        return false;
    }

    /* renamed from: bg */
    private static void m72086bg(Context context, String str) {
        AppMethodBeat.m2504i(91350);
        Intent intent = new Intent();
        intent.putExtra("showShare", true);
        intent.putExtra("rawUrl", str);
        C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(91350);
    }
}
