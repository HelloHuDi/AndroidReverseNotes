package com.tencent.p177mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C45518j;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.z */
public final class C38300z extends C10296a {
    private static final int CTRL_INDEX = 117;
    private static final String NAME = "removeSavedFile";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(102799);
        String optString = jSONObject.optString("filePath", "");
        if (!C5046bo.isNullOrNil(optString)) {
            if (c2241c.asE().mo34316yi(optString)) {
                C45518j yf = c2241c.asE().mo5851yf(optString);
                switch (yf) {
                    case OK:
                        optString = "ok";
                        break;
                    case ERR_NOT_SUPPORTED:
                        optString = "fail:invalid data";
                        break;
                    case ERR_OP_FAIL:
                        optString = "fail";
                        break;
                    default:
                        optString = "fail " + yf.name();
                        break;
                }
            }
            optString = "fail not a store filePath";
        } else {
            optString = "fail:invalid data";
        }
        c2241c.mo6107M(i, mo73394j(optString, null));
        AppMethodBeat.m2505o(102799);
    }
}
