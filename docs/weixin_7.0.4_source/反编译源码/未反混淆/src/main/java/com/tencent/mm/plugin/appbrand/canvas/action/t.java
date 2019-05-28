package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontStyleActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;
import org.json.JSONException;

public final class t implements d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.i(103242);
        SetFontStyleActionArg setFontStyleActionArg = new SetFontStyleActionArg();
        AppMethodBeat.o(103242);
        return setFontStyleActionArg;
    }

    public final String getMethod() {
        return "setFontStyle";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        boolean z = false;
        AppMethodBeat.i(103243);
        if (jSONArray.length() == 0) {
            AppMethodBeat.o(103243);
            return z;
        }
        try {
            z = b(dVar, jSONArray.getString(0));
            AppMethodBeat.o(103243);
            return z;
        } catch (JSONException e) {
            com.tencent.luggage.g.d.i("MicroMsg.SetFontStyle", "get 'fontStyle' error.");
            AppMethodBeat.o(103243);
            return z;
        }
    }

    private static boolean b(d dVar, String str) {
        AppMethodBeat.i(103244);
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
                dVar.hcE.nE(2);
                dVar.hcF.nE(2);
                break;
            case 1:
                dVar.hcE.nE(2);
                dVar.hcF.nE(2);
                break;
            case 2:
                dVar.hcE.nE(0);
                dVar.hcF.nE(0);
                break;
        }
        AppMethodBeat.o(103244);
        return true;
    }

    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(103245);
        SetFontStyleActionArg setFontStyleActionArg = (SetFontStyleActionArg) drawActionArg;
        if (setFontStyleActionArg == null) {
            AppMethodBeat.o(103245);
            return false;
        }
        boolean b = b(dVar, setFontStyleActionArg.hdh);
        AppMethodBeat.o(103245);
        return b;
    }
}
