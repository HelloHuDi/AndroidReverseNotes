package com.tencent.p177mm.plugin.welab.p583c;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C26190ll;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.websearch.api.C14423an;
import com.tencent.p177mm.plugin.websearch.api.C29736ac;
import com.tencent.p177mm.plugin.websearch.api.C40193m;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.plugin.welab.p1072a.p1073a.C29973b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.welab.c.a */
public final class C4665a implements C29973b {
    /* renamed from: f */
    public final void mo9766f(final Activity activity, String str) {
        AppMethodBeat.m2504i(26576);
        if (C46400aa.m87304HU(0)) {
            final String optString = C29736ac.adL("discoverRecommendEntry").optString("wording");
            if (C5046bo.isNullOrNil(optString)) {
                C4990ab.m7412e("MicroMsg.FTS.LookOneLookOpener", "empty query");
                AppMethodBeat.m2505o(26576);
                return;
            }
            ((C40193m) C1720g.m3528K(C40193m.class)).mo63531a(C4996ah.getContext(), new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(26575);
                    Intent cVd = C46400aa.cVd();
                    cVd.putExtra("ftsbizscene", 21);
                    cVd.putExtra("ftsQuery", optString);
                    cVd.putExtra("title", optString);
                    cVd.putExtra("isWebwx", optString);
                    cVd.putExtra("ftscaneditable", false);
                    Map d = C46400aa.m87334d(21, false, 2);
                    d.put(SearchIntents.EXTRA_QUERY, optString);
                    d.put("sceneActionType", "2");
                    cVd.putExtra("rawUrl", C46400aa.m87333d(d, 1));
                    C26190ll c26190ll = new C26190ll();
                    c26190ll.cHk.scene = 0;
                    C4879a.xxA.mo10055m(c26190ll);
                    C25985d.m41467b(activity, "webview", ".ui.tools.fts.FTSWebViewUI", cVd);
                    C14423an.m22652bz(21, optString);
                    AppMethodBeat.m2505o(26575);
                }
            });
            AppMethodBeat.m2505o(26576);
            return;
        }
        C4990ab.m7412e("MicroMsg.FTS.LookOneLookOpener", "fts h5 template not avail");
        AppMethodBeat.m2505o(26576);
    }

    public final String ddq() {
        AppMethodBeat.m2504i(26577);
        String optString = C29736ac.adL("discoverRecommendEntry").optString("labIcon");
        AppMethodBeat.m2505o(26577);
        return optString;
    }

    public final String ddr() {
        AppMethodBeat.m2504i(26578);
        String optString = C29736ac.adL("discoverRecommendEntry").optString("wording");
        if (C5046bo.isNullOrNil(optString)) {
            optString = C4996ah.getContext().getString(C25738R.string.btu);
            AppMethodBeat.m2505o(26578);
            return optString;
        }
        AppMethodBeat.m2505o(26578);
        return optString;
    }
}
