package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.f;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.a<c> {
    public static final int CTRL_INDEX = 372;
    public static final String NAME = "canvasGetImageData";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(103838);
        try {
            int i2 = jSONObject.getInt("canvasId");
            e c = ((f) cVar.B(f.class)).c(cVar);
            if (c == null) {
                ab.w("MicroMsg.JsApiCanvasGetImageData", "invoke JsApi canvasGetImageData failed, component view is null.");
                cVar.M(i, j("fail:page is null", null));
                AppMethodBeat.o(103838);
                return;
            }
            View q = c.aBf().q(i2);
            if (q == null) {
                ab.w("MicroMsg.JsApiCanvasGetImageData", "view(%s) is null.", Integer.valueOf(i2));
                cVar.M(i, j("fail:view is null", null));
                AppMethodBeat.o(103838);
            } else if (q instanceof CoverViewContainer) {
                q = (View) ((CoverViewContainer) q).ah(View.class);
                if (q instanceof com.tencent.mm.plugin.appbrand.canvas.widget.a) {
                    float aNQ = g.aNQ();
                    int optInt = jSONObject.optInt(VideoMaterialUtil.CRAZYFACE_X);
                    int optInt2 = jSONObject.optInt(VideoMaterialUtil.CRAZYFACE_Y);
                    int optInt3 = jSONObject.optInt("width");
                    int optInt4 = jSONObject.optInt("height");
                    if (optInt3 == 0 || optInt4 == 0) {
                        ab.i("MicroMsg.JsApiCanvasGetImageData", "width(%s) or height(%s) is 0.(%s)", Integer.valueOf(optInt3), Integer.valueOf(optInt4), Integer.valueOf(i2));
                        cVar.M(i, j("fail:width or height is 0", null));
                        AppMethodBeat.o(103838);
                        return;
                    }
                    int i3;
                    int i4;
                    int i5;
                    int i6;
                    if (optInt3 < 0) {
                        optInt += optInt3;
                        optInt3 = -optInt3;
                        i3 = optInt;
                    } else {
                        i3 = optInt;
                    }
                    if (optInt4 < 0) {
                        optInt = optInt2 + optInt4;
                        i4 = -optInt4;
                    } else {
                        optInt = optInt2;
                        i4 = optInt4;
                    }
                    int round = Math.round(((float) i3) * aNQ);
                    int round2 = Math.round(((float) optInt) * aNQ);
                    optInt4 = Math.round(((float) optInt3) * aNQ);
                    optInt2 = Math.round(((float) i4) * aNQ);
                    int measuredWidth = q.getMeasuredWidth();
                    int measuredHeight = q.getMeasuredHeight();
                    if (round < 0) {
                        i5 = 0;
                    } else if (round >= measuredWidth) {
                        cVar.M(i, a(cVar, "ok", e(new int[(optInt3 * i4)], optInt3, i4)));
                        AppMethodBeat.o(103838);
                        return;
                    } else {
                        i5 = round;
                    }
                    if (round2 < 0) {
                        i6 = 0;
                    } else if (round2 >= measuredHeight) {
                        cVar.M(i, a(cVar, "ok", e(new int[(optInt3 * i4)], optInt3, i4)));
                        AppMethodBeat.o(103838);
                        return;
                    } else {
                        i6 = round2;
                    }
                    if (round + optInt4 > measuredWidth) {
                        optInt4 = measuredWidth - i5;
                    } else if (round + optInt4 <= 0) {
                        cVar.M(i, a(cVar, "ok", e(new int[(optInt3 * i4)], optInt3, i4)));
                        AppMethodBeat.o(103838);
                        return;
                    } else if (round < 0) {
                        optInt4 += round;
                    }
                    if (round2 + optInt2 > measuredHeight) {
                        optInt2 = measuredHeight - i6;
                    } else if (round2 + optInt2 <= 0) {
                        cVar.M(i, a(cVar, "ok", e(new int[(optInt3 * i4)], optInt3, i4)));
                        AppMethodBeat.o(103838);
                        return;
                    } else if (round2 < 0) {
                        optInt2 += round2;
                    }
                    measuredWidth = Math.round(((float) i5) / aNQ);
                    measuredHeight = Math.round(((float) i6) / aNQ);
                    round2 = Math.round(((float) optInt4) / aNQ);
                    round = Math.round(((float) optInt2) / aNQ);
                    try {
                        Bitmap createBitmap = Bitmap.createBitmap(optInt4, optInt2, Config.ARGB_8888);
                        com.tencent.mm.plugin.appbrand.canvas.f fVar = new com.tencent.mm.plugin.appbrand.canvas.f(createBitmap);
                        fVar.save();
                        fVar.translate((float) (-i5), (float) (-i6));
                        ((com.tencent.mm.plugin.appbrand.canvas.widget.a) q).e(fVar);
                        fVar.restore();
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, round2, round, false);
                        int[] iArr = new int[(optInt3 * i4)];
                        createScaledBitmap.getPixels(iArr, ((measuredHeight - optInt) * optInt3) + (measuredWidth - i3), optInt3, 0, 0, round2, round);
                        cVar.M(i, a(cVar, "ok", e(iArr, optInt3, i4)));
                        AppMethodBeat.o(103838);
                        return;
                    } catch (Exception e) {
                        ab.w("MicroMsg.JsApiCanvasGetImageData", "create bitmap failed, viewId(%s). Exception : %s", Integer.valueOf(i2), e);
                        cVar.M(i, j("fail:create bitmap failed", null));
                        AppMethodBeat.o(103838);
                        return;
                    }
                }
                ab.i("MicroMsg.JsApiCanvasGetImageData", "the view is not a instance of CanvasView.(%s)", Integer.valueOf(i2));
                cVar.M(i, j("fail:illegal view type", null));
                AppMethodBeat.o(103838);
            } else {
                ab.w("MicroMsg.JsApiCanvasGetImageData", "the viewId is not a canvas(%s).", Integer.valueOf(i2));
                cVar.M(i, j("fail:illegal view type", null));
                AppMethodBeat.o(103838);
            }
        } catch (JSONException e2) {
            ab.i("MicroMsg.JsApiCanvasGetImageData", "get canvas id failed, %s", Log.getStackTraceString(e2));
            cVar.M(i, j("fail:illegal canvasId", null));
            AppMethodBeat.o(103838);
        }
    }

    private static Map<String, Object> e(int[] iArr, int i, int i2) {
        AppMethodBeat.i(103839);
        ByteBuffer o = o(iArr);
        HashMap hashMap = new HashMap();
        hashMap.put("data", o);
        hashMap.put("width", Integer.valueOf(i));
        hashMap.put("height", Integer.valueOf(i2));
        AppMethodBeat.o(103839);
        return hashMap;
    }

    private static ByteBuffer o(int[] iArr) {
        int i = 0;
        AppMethodBeat.i(103840);
        byte[] bArr = new byte[(iArr.length * 4)];
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < iArr.length) {
                i = i3 + 1;
                bArr[i3] = (byte) ((iArr[i2] >> 16) & 255);
                i3 = i + 1;
                bArr[i] = (byte) ((iArr[i2] >> 8) & 255);
                int i4 = i3 + 1;
                bArr[i3] = (byte) (iArr[i2] & 255);
                i = i4 + 1;
                bArr[i4] = (byte) ((iArr[i2] >> 24) & 255);
                i2++;
            } else {
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                AppMethodBeat.o(103840);
                return wrap;
            }
        }
    }
}
