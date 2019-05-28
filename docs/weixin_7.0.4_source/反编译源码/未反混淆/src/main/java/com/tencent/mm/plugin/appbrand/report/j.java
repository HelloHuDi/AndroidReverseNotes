package com.tencent.mm.plugin.appbrand.report;

import a.l;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.q.d;
import com.tencent.mm.plugin.appbrand.jsapi.q.d.a;
import com.tencent.mm.sdk.platformtools.ah;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/report/ReportUtilKt;", "", "()V", "getNetworkTypeForReport", "", "context", "Landroid/content/Context;", "plugin-appbrand-integration_release"})
public final class j {
    public static final j iAv = new j();

    static {
        AppMethodBeat.i(134943);
        AppMethodBeat.o(134943);
    }

    private j() {
    }

    public static final String cW(Context context) {
        AppMethodBeat.i(134942);
        if (context == null) {
            context = ah.getContext();
        }
        a cK = d.cK(context);
        String str;
        switch (k.eQZ[cK.ordinal()]) {
            case 1:
                str = "offline";
                AppMethodBeat.o(134942);
                return str;
            default:
                str = cK.value;
                a.f.b.j.o(str, "type.value");
                AppMethodBeat.o(134942);
                return str;
        }
    }
}
