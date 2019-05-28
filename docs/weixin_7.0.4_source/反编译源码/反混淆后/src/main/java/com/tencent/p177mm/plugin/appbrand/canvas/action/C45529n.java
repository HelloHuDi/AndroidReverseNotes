package com.tencent.p177mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.RotateActionArg;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.n */
public final class C45529n implements C10155d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.m2504i(103220);
        RotateActionArg rotateActionArg = new RotateActionArg();
        AppMethodBeat.m2505o(103220);
        return rotateActionArg;
    }

    public final String getMethod() {
        return FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION;
    }

    /* renamed from: a */
    public final boolean mo5873a(C2102d c2102d, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103221);
        if (jSONArray.length() <= 0) {
            AppMethodBeat.m2505o(103221);
            return false;
        }
        boolean a = C45529n.m83953a(canvas, (float) jSONArray.optDouble(0));
        AppMethodBeat.m2505o(103221);
        return a;
    }

    /* renamed from: a */
    private static boolean m83953a(Canvas canvas, float f) {
        AppMethodBeat.m2504i(103222);
        canvas.rotate((float) ((((double) f) / 3.141592653589793d) * 180.0d));
        AppMethodBeat.m2505o(103222);
        return true;
    }

    /* renamed from: a */
    public final boolean mo5872a(C2102d c2102d, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.m2504i(103223);
        RotateActionArg rotateActionArg = (RotateActionArg) drawActionArg;
        if (rotateActionArg == null) {
            AppMethodBeat.m2505o(103223);
            return false;
        }
        boolean a = C45529n.m83953a(canvas, rotateActionArg.hde);
        AppMethodBeat.m2505o(103223);
        return a;
    }
}
