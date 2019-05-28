package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bo;

public final class m extends j<l> {
    public static final String[] fjY = new String[]{j.a(l.fjX, "WxaWidgetInfo")};
    public static final String[] fjZ = new String[0];

    static {
        AppMethodBeat.i(70664);
        AppMethodBeat.o(70664);
    }

    public m(e eVar) {
        super(eVar, l.fjX, "WxaWidgetInfo", fjZ);
    }

    public final l Ev(String str) {
        AppMethodBeat.i(70663);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(70663);
            return null;
        }
        l lVar = new l();
        lVar.field_appId = str;
        lVar.field_appIdHash = str.hashCode();
        if (b((c) lVar, "appIdHash")) {
            AppMethodBeat.o(70663);
            return lVar;
        }
        AppMethodBeat.o(70663);
        return null;
    }
}
