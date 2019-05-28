package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetPixelsActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.f;
import com.tencent.mm.plugin.appbrand.r.g;
import org.json.JSONArray;

public final class ad implements d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.i(103279);
        SetPixelsActionArg setPixelsActionArg = new SetPixelsActionArg();
        AppMethodBeat.o(103279);
        return setPixelsActionArg;
    }

    public final String getMethod() {
        return "__setPixels";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(103280);
        try {
            boolean a = a(dVar, canvas, (Bitmap) jSONArray.get(4), g.a(jSONArray, 0), g.a(jSONArray, 1), g.a(jSONArray, 2), g.a(jSONArray, 3));
            AppMethodBeat.o(103280);
            return a;
        } catch (Exception e) {
            com.tencent.luggage.g.d.w("MicroMsg.SetPixelsAction", "get bitmap data error, %s", Log.getStackTraceString(e));
            AppMethodBeat.o(103280);
            return false;
        }
    }

    private static boolean a(d dVar, Canvas canvas, Bitmap bitmap, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(103281);
        if (canvas.isHardwareAccelerated()) {
            if (canvas instanceof f) {
                ((f) canvas).g((float) i, (float) i2, (float) (i + i3), (float) (i2 + i4));
                com.tencent.luggage.g.d.v("MicroMsg.SetPixelsAction", "MCanvas.clearRect(x : %s, y : %s, w : %s, h : %s)", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            } else if (dVar.hcJ != null) {
                canvas.drawRect((float) i, (float) i2, (float) (i + i3), (float) (i2 + i4), dVar.hcJ);
                com.tencent.luggage.g.d.v("MicroMsg.SetPixelsAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with custom clearPaint", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            } else {
                com.tencent.luggage.g.d.v("MicroMsg.SetPixelsAction", "clearRect(x : %s, y : %s, w : %s, h : %s) failed", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            }
        } else if (dVar.hcJ != null) {
            canvas.drawRect((float) i, (float) i2, (float) (i + i3), (float) (i2 + i4), dVar.hcJ);
            com.tencent.luggage.g.d.v("MicroMsg.SetPixelsAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with custom clearPaint", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        } else {
            canvas.drawRect((float) i, (float) i2, (float) (i + i3), (float) (i2 + i4), dVar.hcI);
            com.tencent.luggage.g.d.v("MicroMsg.SetPixelsAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with default clearPaint", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        }
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(103281);
            return false;
        }
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new RectF((float) i, (float) i2, (float) (i + i3), (float) (i2 + i4)), dVar.hcE);
        AppMethodBeat.o(103281);
        return true;
    }

    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(103282);
        SetPixelsActionArg setPixelsActionArg = (SetPixelsActionArg) drawActionArg;
        if (setPixelsActionArg == null) {
            AppMethodBeat.o(103282);
            return false;
        }
        boolean a = a(dVar, canvas, setPixelsActionArg.bitmap, setPixelsActionArg.x, setPixelsActionArg.y, setPixelsActionArg.width, setPixelsActionArg.height);
        AppMethodBeat.o(103282);
        return a;
    }
}
