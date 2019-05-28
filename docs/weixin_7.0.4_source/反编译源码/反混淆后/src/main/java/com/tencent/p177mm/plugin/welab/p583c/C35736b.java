package com.tencent.p177mm.plugin.welab.p583c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.websearch.api.C29736ac;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.plugin.welab.p1072a.p1073a.C29973b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.welab.c.b */
public final class C35736b implements C29973b {
    /* renamed from: f */
    public final void mo9766f(Activity activity, String str) {
        AppMethodBeat.m2504i(26579);
        if (C46400aa.m87304HU(0)) {
            Intent cVd = C46400aa.cVd();
            cVd.putExtra("ftsbizscene", 20);
            Map d = C46400aa.m87334d(20, true, 0);
            cVd.putExtra("ftsneedkeyboard", true);
            cVd.putExtra("rawUrl", C46400aa.m87298E(d));
            C25985d.m41467b((Context) activity, "webview", ".ui.tools.fts.FTSSearchOneSearchWebViewUI", cVd);
            AppMethodBeat.m2505o(26579);
            return;
        }
        C4990ab.m7412e("MicroMsg.FTS.SearchOneSearchOpener", "fts h5 template not avail");
        AppMethodBeat.m2505o(26579);
    }

    public final String ddq() {
        AppMethodBeat.m2504i(26580);
        String optString = C29736ac.adL("discoverSearchEntry").optString("labIcon");
        AppMethodBeat.m2505o(26580);
        return optString;
    }

    public final String ddr() {
        AppMethodBeat.m2504i(26581);
        String optString = C29736ac.adL("discoverSearchEntry").optString("wording");
        if (C5046bo.isNullOrNil(optString)) {
            optString = C4996ah.getContext().getString(C25738R.string.btu);
            AppMethodBeat.m2505o(26581);
            return optString;
        }
        AppMethodBeat.m2505o(26581);
        return optString;
    }
}
