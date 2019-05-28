package com.tencent.mm.plugin.welab.c;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.ll;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

public final class a implements b {
    public final void f(final Activity activity, String str) {
        AppMethodBeat.i(26576);
        if (aa.HU(0)) {
            final String optString = ac.adL("discoverRecommendEntry").optString("wording");
            if (bo.isNullOrNil(optString)) {
                ab.e("MicroMsg.FTS.LookOneLookOpener", "empty query");
                AppMethodBeat.o(26576);
                return;
            }
            ((m) g.K(m.class)).a(ah.getContext(), new Runnable() {
                public final void run() {
                    AppMethodBeat.i(26575);
                    Intent cVd = aa.cVd();
                    cVd.putExtra("ftsbizscene", 21);
                    cVd.putExtra("ftsQuery", optString);
                    cVd.putExtra("title", optString);
                    cVd.putExtra("isWebwx", optString);
                    cVd.putExtra("ftscaneditable", false);
                    Map d = aa.d(21, false, 2);
                    d.put(SearchIntents.EXTRA_QUERY, optString);
                    d.put("sceneActionType", "2");
                    cVd.putExtra("rawUrl", aa.d(d, 1));
                    ll llVar = new ll();
                    llVar.cHk.scene = 0;
                    com.tencent.mm.sdk.b.a.xxA.m(llVar);
                    d.b(activity, "webview", ".ui.tools.fts.FTSWebViewUI", cVd);
                    an.bz(21, optString);
                    AppMethodBeat.o(26575);
                }
            });
            AppMethodBeat.o(26576);
            return;
        }
        ab.e("MicroMsg.FTS.LookOneLookOpener", "fts h5 template not avail");
        AppMethodBeat.o(26576);
    }

    public final String ddq() {
        AppMethodBeat.i(26577);
        String optString = ac.adL("discoverRecommendEntry").optString("labIcon");
        AppMethodBeat.o(26577);
        return optString;
    }

    public final String ddr() {
        AppMethodBeat.i(26578);
        String optString = ac.adL("discoverRecommendEntry").optString("wording");
        if (bo.isNullOrNil(optString)) {
            optString = ah.getContext().getString(R.string.btu);
            AppMethodBeat.o(26578);
            return optString;
        }
        AppMethodBeat.o(26578);
        return optString;
    }
}
