package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public final class c extends com.tencent.mm.plugin.appbrand.jsapi.a<u> {
    private static final int CTRL_INDEX = 280;
    private static final String NAME = "getRegionData";
    private static final AtomicReference<String> hUi = new AtomicReference();

    static final class a implements i<IPCVoid, IPCString> {
        private a() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(131426);
            String str = g.RP().eJM + "address";
            if (e.ct(str)) {
                IPCString iPCString = new IPCString(str);
                AppMethodBeat.o(131426);
                return iPCString;
            }
            Object iPCString2 = new IPCString("");
            AppMethodBeat.o(131426);
            return iPCString2;
        }
    }

    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(131427);
        final WeakReference weakReference = new WeakReference((u) cVar);
        d.post(new Runnable() {
            public final void run() {
                Object cy;
                String cy2 = null;
                AppMethodBeat.i(131425);
                String str = (String) c.hUi.get();
                if (bo.isNullOrNil(str)) {
                    String str2;
                    if (ah.doI()) {
                        try {
                            str2 = ((IPCString) XIPCInvoker.a("com.tencent.mm", IPCVoid.eGH, a.class)).value;
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.AppBrand.JsApiGetRegionData", e, "query updated address path", new Object[0]);
                            str2 = cy2;
                        }
                    } else {
                        str2 = "";
                    }
                    if (bo.isNullOrNil(str2)) {
                        cy2 = str;
                    } else {
                        try {
                            cy2 = e.cy(str2);
                        } catch (Exception e2) {
                            ab.printErrStackTrace("MicroMsg.AppBrand.JsApiGetRegionData", e2, "read address from file %s", str2);
                        }
                    }
                    if (bo.isNullOrNil(cy2)) {
                        try {
                            cy2 = bo.convertStreamToString(ah.getContext().getAssets().open("address"));
                        } catch (Exception e22) {
                            ab.printErrStackTrace("MicroMsg.AppBrand.JsApiGetRegionData", e22, "read address from assets", new Object[0]);
                        }
                    }
                    if (!bo.isNullOrNil(cy2)) {
                        c.hUi.set(cy2);
                    }
                } else {
                    cy2 = str;
                }
                u uVar = (u) weakReference.get();
                if (uVar != null && uVar.isRunning()) {
                    HashMap hashMap = new HashMap(1);
                    hashMap.put("data", cy2);
                    uVar.M(i, c.this.j("ok", hashMap));
                }
                AppMethodBeat.o(131425);
            }
        }, "AppBrandJsApiGetRegionData");
        AppMethodBeat.o(131427);
    }

    static {
        AppMethodBeat.i(131428);
        AppMethodBeat.o(131428);
    }
}
