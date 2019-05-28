package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontWeightArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;
import org.json.JSONException;

public final class u implements d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.i(103246);
        SetFontWeightArg setFontWeightArg = new SetFontWeightArg();
        AppMethodBeat.o(103246);
        return setFontWeightArg;
    }

    public final String getMethod() {
        return "setFontWeight";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        boolean z = false;
        AppMethodBeat.i(103247);
        if (jSONArray.length() == 0) {
            AppMethodBeat.o(103247);
            return z;
        }
        try {
            z = b(dVar, jSONArray.getString(0));
            AppMethodBeat.o(103247);
            return z;
        } catch (JSONException e) {
            com.tencent.luggage.g.d.i("MicroMsg.SetFontWeight", "get 'fontWeight' error.");
            AppMethodBeat.o(103247);
            return z;
        }
    }

    private static boolean b(d dVar, String str) {
        AppMethodBeat.i(103248);
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
                dVar.hcE.setFakeBoldText(true);
                dVar.hcF.setFakeBoldText(true);
                break;
            case true:
                dVar.hcE.setFakeBoldText(false);
                dVar.hcF.setFakeBoldText(false);
                break;
        }
        AppMethodBeat.o(103248);
        return true;
    }

    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(103249);
        SetFontWeightArg setFontWeightArg = (SetFontWeightArg) drawActionArg;
        if (setFontWeightArg == null) {
            AppMethodBeat.o(103249);
            return false;
        }
        boolean b = b(dVar, setFontWeightArg.hdi);
        AppMethodBeat.o(103249);
        return b;
    }
}
