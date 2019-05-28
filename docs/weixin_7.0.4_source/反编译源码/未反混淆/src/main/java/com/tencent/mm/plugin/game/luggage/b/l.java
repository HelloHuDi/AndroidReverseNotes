package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.a.a;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.game.luggage.d.e;
import com.tencent.mm.plugin.webview.luggage.jsapi.bc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;

public class l extends bc<e> {
    public final String name() {
        return "openGameRegion";
    }

    public final int biG() {
        return 0;
    }

    public final void b(final a aVar) {
        AppMethodBeat.i(135881);
        ab.i("MicroMsg.JsApiOpenGameRegion", "invoke");
        final Context context = (MMActivity) ((e) aVar.bOZ).mContext;
        context.ifE = new MMActivity.a() {
            public final void c(int i, int i2, Intent intent) {
                AppMethodBeat.i(135880);
                if (i == (l.this.hashCode() & CdnLogic.kBizGeneric)) {
                    if (i2 == -1) {
                        if (intent != null) {
                            String bc = bo.bc(intent.getStringExtra("gameRegionName"), "");
                            HashMap hashMap = new HashMap();
                            hashMap.put("gameRegionName", bc);
                            aVar.c("", hashMap);
                        } else {
                            aVar.a("fail", null);
                        }
                    } else if (i2 == 1) {
                        aVar.a("fail", null);
                    } else {
                        aVar.a("cancel", null);
                    }
                    context.ifE = null;
                }
                AppMethodBeat.o(135880);
            }
        };
        d.a(context, "game", ".ui.GameRegionSelectUI", null, hashCode() & CdnLogic.kBizGeneric, false);
        AppMethodBeat.o(135881);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
