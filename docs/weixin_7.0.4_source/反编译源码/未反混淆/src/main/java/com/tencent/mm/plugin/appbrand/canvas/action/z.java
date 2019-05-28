package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.r.g;
import org.json.JSONArray;
import org.json.JSONException;

@Deprecated
public final class z implements d {
    public final BaseDrawActionArg ayf() {
        return null;
    }

    public final String getMethod() {
        return "setLineHeight";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(103266);
        if (jSONArray.length() == 0) {
            AppMethodBeat.o(103266);
        } else {
            try {
                g.o(jSONArray);
            } catch (JSONException e) {
                com.tencent.luggage.g.d.i("MicroMsg.SetLineHeight", "get 'lineHeight' error");
            }
            AppMethodBeat.o(103266);
        }
        return false;
    }

    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        return false;
    }
}
