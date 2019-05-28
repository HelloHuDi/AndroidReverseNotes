package com.tencent.p177mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.SetFontWeightArg;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.u */
public final class C19150u implements C10155d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.m2504i(103246);
        SetFontWeightArg setFontWeightArg = new SetFontWeightArg();
        AppMethodBeat.m2505o(103246);
        return setFontWeightArg;
    }

    public final String getMethod() {
        return "setFontWeight";
    }

    /* renamed from: a */
    public final boolean mo5873a(C2102d c2102d, Canvas canvas, JSONArray jSONArray) {
        boolean z = false;
        AppMethodBeat.m2504i(103247);
        if (jSONArray.length() == 0) {
            AppMethodBeat.m2505o(103247);
            return z;
        }
        try {
            z = C19150u.m29790b(c2102d, jSONArray.getString(0));
            AppMethodBeat.m2505o(103247);
            return z;
        } catch (JSONException e) {
            C45124d.m82929i("MicroMsg.SetFontWeight", "get 'fontWeight' error.");
            AppMethodBeat.m2505o(103247);
            return z;
        }
    }

    /* renamed from: b */
    private static boolean m29790b(C2102d c2102d, String str) {
        AppMethodBeat.m2504i(103248);
        boolean z = true;
        switch (str.hashCode()) {
            case -1039745817:
                if (str.equals("normal")) {
                    z = true;
                    break;
                }
                break;
            case 3029637:
                if (str.equals("bold")) {
                    z = false;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                c2102d.hcE.setFakeBoldText(true);
                c2102d.hcF.setFakeBoldText(true);
                break;
            case true:
                c2102d.hcE.setFakeBoldText(false);
                c2102d.hcF.setFakeBoldText(false);
                break;
        }
        AppMethodBeat.m2505o(103248);
        return true;
    }

    /* renamed from: a */
    public final boolean mo5872a(C2102d c2102d, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.m2504i(103249);
        SetFontWeightArg setFontWeightArg = (SetFontWeightArg) drawActionArg;
        if (setFontWeightArg == null) {
            AppMethodBeat.m2505o(103249);
            return false;
        }
        boolean b = C19150u.m29790b(c2102d, setFontWeightArg.hdi);
        AppMethodBeat.m2505o(103249);
        return b;
    }
}
