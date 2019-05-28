package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.RotateActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import org.json.JSONArray;

public final class n implements d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.i(103220);
        RotateActionArg rotateActionArg = new RotateActionArg();
        AppMethodBeat.o(103220);
        return rotateActionArg;
    }

    public final String getMethod() {
        return FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION;
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(103221);
        if (jSONArray.length() <= 0) {
            AppMethodBeat.o(103221);
            return false;
        }
        boolean a = a(canvas, (float) jSONArray.optDouble(0));
        AppMethodBeat.o(103221);
        return a;
    }

    private static boolean a(Canvas canvas, float f) {
        AppMethodBeat.i(103222);
        canvas.rotate((float) ((((double) f) / 3.141592653589793d) * 180.0d));
        AppMethodBeat.o(103222);
        return true;
    }

    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(103223);
        RotateActionArg rotateActionArg = (RotateActionArg) drawActionArg;
        if (rotateActionArg == null) {
            AppMethodBeat.o(103223);
            return false;
        }
        boolean a = a(canvas, rotateActionArg.hde);
        AppMethodBeat.o(103223);
        return a;
    }
}
