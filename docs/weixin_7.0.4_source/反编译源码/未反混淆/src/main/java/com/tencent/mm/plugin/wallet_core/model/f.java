package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public final class f {
    public String txA;
    public int txv;
    public String txw;
    public String txx;
    public String txy;
    public String txz;

    public static f acw(String str) {
        AppMethodBeat.i(46720);
        if (!bo.isNullOrNil(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                f fVar = new f();
                fVar.txv = jSONObject.optInt("menu_jump_type", -1);
                fVar.txw = jSONObject.optString("menu_jump_url", "");
                fVar.txx = jSONObject.optString("menu_username", "");
                fVar.txy = jSONObject.optString("menu_path", "");
                fVar.txz = jSONObject.optString("menu_title", "");
                fVar.txA = jSONObject.optString("menu_icon_url", "");
                ab.i("BindCardMenu", "parse bind card menu, type: %s, title: %s", Integer.valueOf(fVar.txv), fVar.txz);
                AppMethodBeat.o(46720);
                return fVar;
            } catch (JSONException e) {
                ab.printErrStackTrace("BindCardMenu", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(46720);
        return null;
    }
}
