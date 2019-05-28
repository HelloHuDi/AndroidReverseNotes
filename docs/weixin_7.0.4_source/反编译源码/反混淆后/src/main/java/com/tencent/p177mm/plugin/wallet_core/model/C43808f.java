package com.tencent.p177mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.f */
public final class C43808f {
    public String txA;
    public int txv;
    public String txw;
    public String txx;
    public String txy;
    public String txz;

    public static C43808f acw(String str) {
        AppMethodBeat.m2504i(46720);
        if (!C5046bo.isNullOrNil(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                C43808f c43808f = new C43808f();
                c43808f.txv = jSONObject.optInt("menu_jump_type", -1);
                c43808f.txw = jSONObject.optString("menu_jump_url", "");
                c43808f.txx = jSONObject.optString("menu_username", "");
                c43808f.txy = jSONObject.optString("menu_path", "");
                c43808f.txz = jSONObject.optString("menu_title", "");
                c43808f.txA = jSONObject.optString("menu_icon_url", "");
                C4990ab.m7417i("BindCardMenu", "parse bind card menu, type: %s, title: %s", Integer.valueOf(c43808f.txv), c43808f.txz);
                AppMethodBeat.m2505o(46720);
                return c43808f;
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("BindCardMenu", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(46720);
        return null;
    }
}
