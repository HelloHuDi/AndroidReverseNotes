package com.tencent.p177mm.plugin.search.p741b.p742a.p743a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.service.C42687f;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3157b;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C28144j;
import com.tencent.p177mm.plugin.search.p1292a.C34844a;

/* renamed from: com.tencent.mm.plugin.search.b.a.a.a */
public final class C34845a implements C3157b {
    /* renamed from: a */
    public final boolean mo7423a(Context context, C3154a c3154a) {
        AppMethodBeat.m2504i(24405);
        C28144j c28144j = (C28144j) c3154a;
        ((C12029n) C1720g.m3530M(C12029n.class)).updateTopHitsRank(c28144j.mDz.mDY, c28144j.hpS, 0);
        Intent intent;
        if (((C42687f) C1720g.m3528K(C42687f.class)).mo68089Cl(c28144j.mKM.field_url)) {
            AppMethodBeat.m2505o(24405);
        } else if (c28144j.mKM.field_actionType == 2) {
            intent = new Intent();
            intent.putExtra("rawUrl", c28144j.mKM.field_url);
            C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(24405);
        } else {
            if (!C34844a.m57234U(context, c28144j.mKM.field_featureId)) {
                intent = new Intent();
                intent.putExtra("rawUrl", c28144j.mKM.field_updateUrl);
                C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent);
            }
            AppMethodBeat.m2505o(24405);
        }
        return true;
    }
}
