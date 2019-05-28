package com.tencent.p177mm.plugin.appbrand.canvas.action;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C19151f;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.SetPixelsActionArg;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.ad */
public final class C26802ad implements C10155d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.m2504i(103279);
        SetPixelsActionArg setPixelsActionArg = new SetPixelsActionArg();
        AppMethodBeat.m2505o(103279);
        return setPixelsActionArg;
    }

    public final String getMethod() {
        return "__setPixels";
    }

    /* renamed from: a */
    public final boolean mo5873a(C2102d c2102d, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103280);
        try {
            boolean a = C26802ad.m42664a(c2102d, canvas, (Bitmap) jSONArray.get(4), C42668g.m75554a(jSONArray, 0), C42668g.m75554a(jSONArray, 1), C42668g.m75554a(jSONArray, 2), C42668g.m75554a(jSONArray, 3));
            AppMethodBeat.m2505o(103280);
            return a;
        } catch (Exception e) {
            C45124d.m82934w("MicroMsg.SetPixelsAction", "get bitmap data error, %s", Log.getStackTraceString(e));
            AppMethodBeat.m2505o(103280);
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m42664a(C2102d c2102d, Canvas canvas, Bitmap bitmap, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(103281);
        if (canvas.isHardwareAccelerated()) {
            if (canvas instanceof C19151f) {
                ((C19151f) canvas).mo34373g((float) i, (float) i2, (float) (i + i3), (float) (i2 + i4));
                C45124d.m82932v("MicroMsg.SetPixelsAction", "MCanvas.clearRect(x : %s, y : %s, w : %s, h : %s)", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            } else if (c2102d.hcJ != null) {
                canvas.drawRect((float) i, (float) i2, (float) (i + i3), (float) (i2 + i4), c2102d.hcJ);
                C45124d.m82932v("MicroMsg.SetPixelsAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with custom clearPaint", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            } else {
                C45124d.m82932v("MicroMsg.SetPixelsAction", "clearRect(x : %s, y : %s, w : %s, h : %s) failed", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            }
        } else if (c2102d.hcJ != null) {
            canvas.drawRect((float) i, (float) i2, (float) (i + i3), (float) (i2 + i4), c2102d.hcJ);
            C45124d.m82932v("MicroMsg.SetPixelsAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with custom clearPaint", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        } else {
            canvas.drawRect((float) i, (float) i2, (float) (i + i3), (float) (i2 + i4), c2102d.hcI);
            C45124d.m82932v("MicroMsg.SetPixelsAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with default clearPaint", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        }
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.m2505o(103281);
            return false;
        }
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new RectF((float) i, (float) i2, (float) (i + i3), (float) (i2 + i4)), c2102d.hcE);
        AppMethodBeat.m2505o(103281);
        return true;
    }

    /* renamed from: a */
    public final boolean mo5872a(C2102d c2102d, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.m2504i(103282);
        SetPixelsActionArg setPixelsActionArg = (SetPixelsActionArg) drawActionArg;
        if (setPixelsActionArg == null) {
            AppMethodBeat.m2505o(103282);
            return false;
        }
        boolean a = C26802ad.m42664a(c2102d, canvas, setPixelsActionArg.bitmap, setPixelsActionArg.f1243x, setPixelsActionArg.f1244y, setPixelsActionArg.width, setPixelsActionArg.height);
        AppMethodBeat.m2505o(103282);
        return a;
    }
}
