package com.tencent.mm.plugin.search.b.a.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.fts.a.d.a.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.j;

public final class a implements b {
    public final boolean a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
        AppMethodBeat.i(24405);
        j jVar = (j) aVar;
        ((n) g.M(n.class)).updateTopHitsRank(jVar.mDz.mDY, jVar.hpS, 0);
        Intent intent;
        if (((f) g.K(f.class)).Cl(jVar.mKM.field_url)) {
            AppMethodBeat.o(24405);
        } else if (jVar.mKM.field_actionType == 2) {
            intent = new Intent();
            intent.putExtra("rawUrl", jVar.mKM.field_url);
            d.b(context, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(24405);
        } else {
            if (!com.tencent.mm.plugin.search.a.a.U(context, jVar.mKM.field_featureId)) {
                intent = new Intent();
                intent.putExtra("rawUrl", jVar.mKM.field_updateUrl);
                d.b(context, "webview", ".ui.tools.WebViewUI", intent);
            }
            AppMethodBeat.o(24405);
        }
        return true;
    }
}
