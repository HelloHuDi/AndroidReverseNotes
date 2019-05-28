package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class z extends a {
    private static final int CTRL_INDEX = 117;
    private static final String NAME = "removeSavedFile";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(102799);
        String optString = jSONObject.optString("filePath", "");
        if (!bo.isNullOrNil(optString)) {
            if (cVar.asE().yi(optString)) {
                j yf = cVar.asE().yf(optString);
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
        cVar.M(i, j(optString, null));
        AppMethodBeat.o(102799);
    }
}
