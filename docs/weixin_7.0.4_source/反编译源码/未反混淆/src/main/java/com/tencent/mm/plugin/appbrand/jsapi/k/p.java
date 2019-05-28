package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import org.json.JSONObject;

public class p extends a<h> {
    private static final int CTRL_INDEX = 238;
    private static final String NAME = "setNavigationBarRightButton";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        u uVar;
        boolean z = false;
        AppMethodBeat.i(102008);
        h hVar = (h) cVar;
        if (hVar instanceof u) {
            uVar = (u) hVar;
        } else {
            uVar = ((q) hVar).getCurrentPageView();
        }
        boolean optBoolean = jSONObject.optBoolean(MessengerShareContentUtility.SHARE_BUTTON_HIDE, false);
        if (uVar == null) {
            hVar.M(i, j("fail:page don't exist", null));
            AppMethodBeat.o(102008);
            return;
        }
        if (!optBoolean) {
            z = true;
        }
        uVar.ew(z);
        hVar.M(i, j("ok", null));
        AppMethodBeat.o(102008);
    }
}
