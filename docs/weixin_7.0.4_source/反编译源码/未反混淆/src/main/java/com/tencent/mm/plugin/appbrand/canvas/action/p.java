package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.ScaleActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.ttpic.model.WMElement;
import org.json.JSONArray;

public final class p implements d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.i(103228);
        ScaleActionArg scaleActionArg = new ScaleActionArg();
        AppMethodBeat.o(103228);
        return scaleActionArg;
    }

    public final String getMethod() {
        return WMElement.ANIMATE_TYPE_SCALE;
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(103229);
        if (jSONArray.length() < 2) {
            AppMethodBeat.o(103229);
            return false;
        }
        canvas.scale((float) jSONArray.optDouble(0), (float) jSONArray.optDouble(1));
        AppMethodBeat.o(103229);
        return true;
    }

    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(103230);
        ScaleActionArg scaleActionArg = (ScaleActionArg) drawActionArg;
        if (scaleActionArg == null) {
            AppMethodBeat.o(103230);
            return false;
        }
        canvas.scale(scaleActionArg.hcX, scaleActionArg.hcY);
        AppMethodBeat.o(103230);
        return true;
    }
}
