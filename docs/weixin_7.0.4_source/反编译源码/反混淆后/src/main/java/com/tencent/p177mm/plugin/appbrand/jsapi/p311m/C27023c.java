package com.tencent.p177mm.plugin.appbrand.jsapi.p311m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.p177mm.ipcinvoker.type.IPCString;
import com.tencent.p177mm.ipcinvoker.type.IPCVoid;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.m.c */
public final class C27023c extends C10296a<C44709u> {
    private static final int CTRL_INDEX = 280;
    private static final String NAME = "getRegionData";
    private static final AtomicReference<String> hUi = new AtomicReference();

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.m.c$a */
    static final class C19429a implements C45413i<IPCVoid, IPCString> {
        private C19429a() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(131426);
            String str = C1720g.m3536RP().eJM + "address";
            if (C1173e.m2561ct(str)) {
                IPCString iPCString = new IPCString(str);
                AppMethodBeat.m2505o(131426);
                return iPCString;
            }
            Object iPCString2 = new IPCString("");
            AppMethodBeat.m2505o(131426);
            return iPCString2;
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(131427);
        final WeakReference weakReference = new WeakReference((C44709u) c2241c);
        C7305d.post(new Runnable() {
            public final void run() {
                Object cy;
                String cy2 = null;
                AppMethodBeat.m2504i(131425);
                String str = (String) C27023c.hUi.get();
                if (C5046bo.isNullOrNil(str)) {
                    String str2;
                    if (C4996ah.doI()) {
                        try {
                            str2 = ((IPCString) XIPCInvoker.m83628a("com.tencent.mm", IPCVoid.eGH, C19429a.class)).value;
                        } catch (Exception e) {
                            C4990ab.printErrStackTrace("MicroMsg.AppBrand.JsApiGetRegionData", e, "query updated address path", new Object[0]);
                            str2 = cy2;
                        }
                    } else {
                        str2 = "";
                    }
                    if (C5046bo.isNullOrNil(str2)) {
                        cy2 = str;
                    } else {
                        try {
                            cy2 = C1173e.m2566cy(str2);
                        } catch (Exception e2) {
                            C4990ab.printErrStackTrace("MicroMsg.AppBrand.JsApiGetRegionData", e2, "read address from file %s", str2);
                        }
                    }
                    if (C5046bo.isNullOrNil(cy2)) {
                        try {
                            cy2 = C5046bo.convertStreamToString(C4996ah.getContext().getAssets().open("address"));
                        } catch (Exception e22) {
                            C4990ab.printErrStackTrace("MicroMsg.AppBrand.JsApiGetRegionData", e22, "read address from assets", new Object[0]);
                        }
                    }
                    if (!C5046bo.isNullOrNil(cy2)) {
                        C27023c.hUi.set(cy2);
                    }
                } else {
                    cy2 = str;
                }
                C44709u c44709u = (C44709u) weakReference.get();
                if (c44709u != null && c44709u.isRunning()) {
                    HashMap hashMap = new HashMap(1);
                    hashMap.put("data", cy2);
                    c44709u.mo6107M(i, C27023c.this.mo73394j("ok", hashMap));
                }
                AppMethodBeat.m2505o(131425);
            }
        }, "AppBrandJsApiGetRegionData");
        AppMethodBeat.m2505o(131427);
    }

    static {
        AppMethodBeat.m2504i(131428);
        AppMethodBeat.m2505o(131428);
    }
}
