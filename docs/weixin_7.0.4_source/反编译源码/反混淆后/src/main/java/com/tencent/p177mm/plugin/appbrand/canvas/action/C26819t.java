package com.tencent.p177mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.SetFontStyleActionArg;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.t */
public final class C26819t implements C10155d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.m2504i(103242);
        SetFontStyleActionArg setFontStyleActionArg = new SetFontStyleActionArg();
        AppMethodBeat.m2505o(103242);
        return setFontStyleActionArg;
    }

    public final String getMethod() {
        return "setFontStyle";
    }

    /* renamed from: a */
    public final boolean mo5873a(C2102d c2102d, Canvas canvas, JSONArray jSONArray) {
        boolean z = false;
        AppMethodBeat.m2504i(103243);
        if (jSONArray.length() == 0) {
            AppMethodBeat.m2505o(103243);
            return z;
        }
        try {
            z = C26819t.m42696b(c2102d, jSONArray.getString(0));
            AppMethodBeat.m2505o(103243);
            return z;
        } catch (JSONException e) {
            C45124d.m82929i("MicroMsg.SetFontStyle", "get 'fontStyle' error.");
            AppMethodBeat.m2505o(103243);
            return z;
        }
    }

    /* renamed from: b */
    private static boolean m42696b(C2102d c2102d, String str) {
        AppMethodBeat.m2504i(103244);
        int i = -1;
        switch (str.hashCode()) {
            case -1657669071:
                if (str.equals("oblique")) {
                    i = 0;
                    break;
                }
                break;
            case -1178781136:
                if (str.equals("italic")) {
                    boolean i2 = true;
                    break;
                }
                break;
            case -1039745817:
                if (str.equals("normal")) {
                    i2 = 2;
                    break;
                }
                break;
        }
        switch (i2) {
            case 0:
                c2102d.hcE.mo21507nE(2);
                c2102d.hcF.mo21507nE(2);
                break;
            case 1:
                c2102d.hcE.mo21507nE(2);
                c2102d.hcF.mo21507nE(2);
                break;
            case 2:
                c2102d.hcE.mo21507nE(0);
                c2102d.hcF.mo21507nE(0);
                break;
        }
        AppMethodBeat.m2505o(103244);
        return true;
    }

    /* renamed from: a */
    public final boolean mo5872a(C2102d c2102d, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.m2504i(103245);
        SetFontStyleActionArg setFontStyleActionArg = (SetFontStyleActionArg) drawActionArg;
        if (setFontStyleActionArg == null) {
            AppMethodBeat.m2505o(103245);
            return false;
        }
        boolean b = C26819t.m42696b(c2102d, setFontStyleActionArg.hdh);
        AppMethodBeat.m2505o(103245);
        return b;
    }
}
