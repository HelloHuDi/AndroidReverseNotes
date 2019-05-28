package com.tencent.luggage.sdk.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import org.json.JSONObject;

public class b extends q {
    public /* synthetic */ u getCurrentPageView() {
        AppMethodBeat.i(101661);
        a xV = xV();
        AppMethodBeat.o(101661);
        return xV;
    }

    public /* synthetic */ i getRuntime() {
        AppMethodBeat.i(101660);
        com.tencent.luggage.sdk.b.b xL = xL();
        AppMethodBeat.o(101660);
        return xL;
    }

    public a xV() {
        AppMethodBeat.i(101657);
        a aVar = (a) super.ac(a.class);
        AppMethodBeat.o(101657);
        return aVar;
    }

    public com.tencent.luggage.sdk.b.b xL() {
        AppMethodBeat.i(101658);
        com.tencent.luggage.sdk.b.b bVar = (com.tencent.luggage.sdk.b.b) super.getRuntime();
        AppMethodBeat.o(101658);
        return bVar;
    }

    public JSONObject xW() {
        AppMethodBeat.i(101659);
        JSONObject xW = super.xW();
        b(xW, "appType", Integer.valueOf(xL().ya().bQe));
        AppMethodBeat.o(101659);
        return xW;
    }

    public final boolean xX() {
        return true;
    }
}
