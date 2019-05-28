package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.Paint.Cap;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineCapActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class x implements d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.i(103258);
        SetLineCapActionArg setLineCapActionArg = new SetLineCapActionArg();
        AppMethodBeat.o(103258);
        return setLineCapActionArg;
    }

    public final String getMethod() {
        return "setLineCap";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(103259);
        if (jSONArray.length() <= 0) {
            AppMethodBeat.o(103259);
            return false;
        }
        boolean b = b(dVar, jSONArray.optString(0));
        AppMethodBeat.o(103259);
        return b;
    }

    private static boolean b(d dVar, String str) {
        AppMethodBeat.i(103260);
        if ("butt".equalsIgnoreCase(str)) {
            dVar.hcF.setStrokeCap(Cap.BUTT);
            dVar.hcE.setStrokeCap(Cap.BUTT);
        } else if ("round".equalsIgnoreCase(str)) {
            dVar.hcF.setStrokeCap(Cap.ROUND);
            dVar.hcE.setStrokeCap(Cap.ROUND);
        } else if (MessengerShareContentUtility.IMAGE_RATIO_SQUARE.equalsIgnoreCase(str)) {
            dVar.hcF.setStrokeCap(Cap.SQUARE);
            dVar.hcE.setStrokeCap(Cap.SQUARE);
        }
        AppMethodBeat.o(103260);
        return true;
    }

    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(103261);
        SetLineCapActionArg setLineCapActionArg = (SetLineCapActionArg) drawActionArg;
        if (setLineCapActionArg == null) {
            AppMethodBeat.o(103261);
            return false;
        }
        boolean b = b(dVar, setLineCapActionArg.hdj);
        AppMethodBeat.o(103261);
        return b;
    }
}
