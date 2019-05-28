package com.tencent.p177mm.plugin.game.luggage.p429b;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.game.luggage.p432d.C12140e;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.game.luggage.b.l */
public class C43178l extends C22840bc<C12140e> {
    public final String name() {
        return "openGameRegion";
    }

    public final int biG() {
        return 0;
    }

    /* renamed from: b */
    public final void mo9618b(final C32183a c32183a) {
        AppMethodBeat.m2504i(135881);
        C4990ab.m7416i("MicroMsg.JsApiOpenGameRegion", "invoke");
        final Context context = (MMActivity) ((C12140e) c32183a.bOZ).mContext;
        context.ifE = new C5186a() {
            /* renamed from: c */
            public final void mo6069c(int i, int i2, Intent intent) {
                AppMethodBeat.m2504i(135880);
                if (i == (C43178l.this.hashCode() & CdnLogic.kBizGeneric)) {
                    if (i2 == -1) {
                        if (intent != null) {
                            String bc = C5046bo.m7532bc(intent.getStringExtra("gameRegionName"), "");
                            HashMap hashMap = new HashMap();
                            hashMap.put("gameRegionName", bc);
                            c32183a.mo52825c("", hashMap);
                        } else {
                            c32183a.mo52824a("fail", null);
                        }
                    } else if (i2 == 1) {
                        c32183a.mo52824a("fail", null);
                    } else {
                        c32183a.mo52824a("cancel", null);
                    }
                    context.ifE = null;
                }
                AppMethodBeat.m2505o(135880);
            }
        };
        C25985d.m41453a(context, "game", ".ui.GameRegionSelectUI", null, hashCode() & CdnLogic.kBizGeneric, false);
        AppMethodBeat.m2505o(135881);
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }
}
