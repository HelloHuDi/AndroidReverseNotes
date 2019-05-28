package com.tencent.mm.plugin.appbrand.jsapi.d;

import android.os.Looper;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.plugin.appbrand.widget.input.h;
import com.tencent.mm.plugin.appbrand.widget.input.w;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bj;
import org.json.JSONObject;

public final class f extends u<com.tencent.mm.plugin.appbrand.page.u> {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "restoreWebviewFocus";

    public final /* synthetic */ String b(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(123543);
        final com.tencent.mm.plugin.appbrand.page.u uVar = (com.tencent.mm.plugin.appbrand.page.u) cVar;
        final boolean optBoolean = jSONObject.optBoolean("focus", false);
        new bj<Void>() {
            public final /* synthetic */ Object run() {
                AppMethodBeat.i(123542);
                com.tencent.mm.plugin.appbrand.page.u uVar = uVar;
                boolean z = optBoolean;
                h.aQx().d(uVar.aJz());
                View contentView = uVar.aJz().getContentView();
                if (z) {
                    w cO = w.cO(contentView);
                    if (cO != null) {
                        cO.setShowDoneButton(false);
                    }
                    contentView.requestFocus();
                }
                AppMethodBeat.o(123542);
                return null;
            }
        }.b(new ak(Looper.getMainLooper()));
        String j = j("ok", null);
        AppMethodBeat.o(123543);
        return j;
    }
}
