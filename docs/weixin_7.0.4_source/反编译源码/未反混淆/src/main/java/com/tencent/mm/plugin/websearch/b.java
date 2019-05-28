package com.tencent.mm.plugin.websearch;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.w;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.protocal.protobuf.bur;
import com.tencent.mm.protocal.protobuf.bus;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ar;

public final class b implements m {
    private static String tZm = "websearch_";
    private static String tZn;
    private static String tZo;
    private Runnable tZk;
    private Runnable tZl;

    private static SharedPreferences cUI() {
        AppMethodBeat.i(91343);
        init();
        ab.i("WebSearchPrivacyMgr", " sp name %s ", tZm);
        SharedPreferences s = ar.s(ah.getContext(), tZm, 0);
        AppMethodBeat.o(91343);
        return s;
    }

    public static void init() {
        AppMethodBeat.i(91344);
        if (tZn == null) {
            cUJ();
        }
        AppMethodBeat.o(91344);
    }

    public static void cUJ() {
        AppMethodBeat.i(91345);
        ab.i("WebSearchPrivacyMgr", "reInit");
        StringBuilder stringBuilder = new StringBuilder("websearch_");
        g.RN();
        tZm = stringBuilder.append(a.QG()).toString();
        Object obj = g.RP().Ry().get(274436, (Object) "");
        String str = "en";
        if (obj != null) {
            str = obj.toString();
        }
        tZn = ah.getContext().getString(R.string.g8d, new Object[]{aa.dor(), str});
        tZo = ah.getContext().getString(R.string.g6j, new Object[]{aa.dor(), str});
        AppMethodBeat.o(91345);
    }

    public final void cUK() {
        AppMethodBeat.i(91346);
        ab.i("WebSearchPrivacyMgr", "openSearch ");
        init();
        if (this.tZk != null) {
            this.tZk.run();
            if (this.tZk == this.tZk) {
                this.tZk = null;
            }
        }
        cUI().edit().putBoolean("websearch_confirmed", true).commit();
        bur bur = new bur();
        bur.wWg = 1;
        bur.Timestamp = (int) (System.currentTimeMillis() / 1000);
        bur.nbk = 1;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = bur;
        aVar.fsK = new bus();
        aVar.uri = "/cgi-bin/mmsearch-bin/searchconfirm";
        aVar.fsI = 2957;
        w.a(aVar.acD(), new w.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, com.tencent.mm.ai.m mVar) {
                return 0;
            }
        });
        AppMethodBeat.o(91346);
    }

    public final void cUL() {
        AppMethodBeat.i(91347);
        ab.i("WebSearchPrivacyMgr", "closeSearch ");
        init();
        if (this.tZl != null) {
            this.tZl.run();
            if (this.tZl == this.tZl) {
                this.tZl = null;
            }
        }
        cUI().edit().putBoolean("websearch_confirmed", false).commit();
        bur bur = new bur();
        bur.wWg = 1;
        bur.Timestamp = (int) (System.currentTimeMillis() / 1000);
        bur.nbk = 2;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = bur;
        aVar.fsK = new bus();
        aVar.uri = "/cgi-bin/mmsearch-bin/searchconfirm";
        aVar.fsI = 2957;
        w.a(aVar.acD(), new w.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, com.tencent.mm.ai.m mVar) {
                return 0;
            }
        });
        ((n) g.M(n.class)).deleteSOSHistory();
        if (ai.uaA != null) {
            ai.uaA = null;
        }
        ah.getContext().getSharedPreferences("fts_recent_biz_sp", 0).edit().remove(ai.cVl()).commit();
        AppMethodBeat.o(91347);
    }

    public final void a(Context context, Runnable runnable) {
        AppMethodBeat.i(91348);
        init();
        if (cUI().getBoolean("websearch_confirmed", false) || !com.tencent.mm.au.b.sO((String) g.RP().Ry().get(274436, null))) {
            runnable.run();
            AppMethodBeat.o(91348);
            return;
        }
        this.tZk = runnable;
        bg(context, tZn);
        AppMethodBeat.o(91348);
    }

    public final boolean b(Context context, Runnable runnable) {
        AppMethodBeat.i(91349);
        init();
        if (com.tencent.mm.au.b.sO((String) g.RP().Ry().get(274436, null))) {
            this.tZl = runnable;
            bg(context, tZo);
            AppMethodBeat.o(91349);
            return true;
        }
        runnable.run();
        AppMethodBeat.o(91349);
        return false;
    }

    private static void bg(Context context, String str) {
        AppMethodBeat.i(91350);
        Intent intent = new Intent();
        intent.putExtra("showShare", true);
        intent.putExtra("rawUrl", str);
        d.b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(91350);
    }
}
