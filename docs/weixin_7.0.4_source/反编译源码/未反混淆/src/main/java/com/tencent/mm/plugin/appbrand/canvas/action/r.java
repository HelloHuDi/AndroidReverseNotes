package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontFamilyActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;
import org.json.JSONException;

public final class r implements d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.i(103234);
        SetFontFamilyActionArg setFontFamilyActionArg = new SetFontFamilyActionArg();
        AppMethodBeat.o(103234);
        return setFontFamilyActionArg;
    }

    public final String getMethod() {
        return "setFontFamily";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        boolean z = false;
        AppMethodBeat.i(103235);
        if (jSONArray.length() == 0) {
            AppMethodBeat.o(103235);
            return z;
        }
        try {
            z = b(dVar, jSONArray.getString(0));
            AppMethodBeat.o(103235);
            return z;
        } catch (JSONException e) {
            com.tencent.luggage.g.d.i("MicroMsg.SetFontFamily", "get 'fontFamily' error.");
            AppMethodBeat.o(103235);
            return z;
        }
    }

    private static boolean b(d dVar, String str) {
        AppMethodBeat.i(103236);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(103236);
            return false;
        }
        dVar.hcE.yB(str);
        dVar.hcF.yB(str);
        AppMethodBeat.o(103236);
        return true;
    }

    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(103237);
        SetFontFamilyActionArg setFontFamilyActionArg = (SetFontFamilyActionArg) drawActionArg;
        if (setFontFamilyActionArg == null) {
            AppMethodBeat.o(103237);
            return false;
        }
        boolean b = b(dVar, setFontFamilyActionArg.bnS);
        AppMethodBeat.o(103237);
        return b;
    }
}
