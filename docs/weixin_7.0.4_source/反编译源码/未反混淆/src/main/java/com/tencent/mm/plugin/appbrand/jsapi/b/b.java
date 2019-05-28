package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.f;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.r.d;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends a<c> {
    public static final int CTRL_INDEX = 373;
    public static final String NAME = "canvasPutImageData";

    public final void a(final c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(103842);
        try {
            int i2 = jSONObject.getInt("canvasId");
            e c = ((f) cVar.B(f.class)).c(cVar);
            if (c == null) {
                ab.w("MicroMsg.JsApiCanvasPutImageData", "invoke JsApi canvasPutImageData failed, component view is null.");
                cVar.M(i, j("fail:page is null", null));
                AppMethodBeat.o(103842);
                return;
            }
            View q = c.aBf().q(i2);
            if (q == null) {
                ab.w("MicroMsg.JsApiCanvasPutImageData", "view(%s) is null.", Integer.valueOf(i2));
                cVar.M(i, j("fail:view is null", null));
                AppMethodBeat.o(103842);
            } else if (q instanceof CoverViewContainer) {
                q = (View) ((CoverViewContainer) q).ah(View.class);
                if (q instanceof com.tencent.mm.plugin.appbrand.canvas.widget.a) {
                    float aNQ = g.aNQ();
                    int optInt = jSONObject.optInt(VideoMaterialUtil.CRAZYFACE_X);
                    int optInt2 = jSONObject.optInt(VideoMaterialUtil.CRAZYFACE_Y);
                    int optInt3 = jSONObject.optInt("width");
                    int optInt4 = jSONObject.optInt("height");
                    Math.round(((float) optInt) * aNQ);
                    Math.round(((float) optInt2) * aNQ);
                    Math.round(((float) optInt3) * aNQ);
                    Math.round(aNQ * ((float) optInt4));
                    if (optInt3 == 0 || optInt4 == 0) {
                        ab.i("MicroMsg.JsApiCanvasPutImageData", "width(%s) or height(%s) is 0.(%s)", Integer.valueOf(optInt3), Integer.valueOf(optInt4), Integer.valueOf(i2));
                        cVar.M(i, j("fail:width or height is 0", null));
                        AppMethodBeat.o(103842);
                        return;
                    }
                    if (optInt3 < 0) {
                        optInt += optInt3;
                        i2 = -optInt3;
                    } else {
                        i2 = optInt3;
                    }
                    if (optInt4 < 0) {
                        optInt2 += optInt4;
                        optInt3 = -optInt4;
                    } else {
                        optInt3 = optInt4;
                    }
                    try {
                        Object obj = jSONObject.get("data");
                        if (obj instanceof ByteBuffer) {
                            ByteBuffer byteBuffer = (ByteBuffer) obj;
                            JSONArray jSONArray = new JSONArray();
                            int[] n = n(byteBuffer);
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                JSONArray jSONArray2 = new JSONArray();
                                jSONArray2.put(optInt);
                                jSONArray2.put(optInt2);
                                jSONArray2.put(i2);
                                jSONArray2.put(optInt3);
                                jSONArray2.put(Bitmap.createBitmap(n, i2, optInt3, Config.ARGB_8888));
                                jSONObject2.put(com.google.firebase.analytics.FirebaseAnalytics.b.METHOD, "__setPixels");
                                jSONObject2.put("data", jSONArray2);
                                jSONArray.put(jSONObject2);
                                com.tencent.mm.plugin.appbrand.canvas.widget.a aVar = (com.tencent.mm.plugin.appbrand.canvas.widget.a) q;
                                aVar.b(jSONArray, new com.tencent.mm.plugin.appbrand.canvas.widget.a.a() {
                                    public final void a(DrawCanvasArg drawCanvasArg) {
                                        AppMethodBeat.i(103841);
                                        cVar.M(i, b.this.j("ok", null));
                                        AppMethodBeat.o(103841);
                                    }
                                });
                                aVar.ayc();
                                AppMethodBeat.o(103842);
                                return;
                            } catch (JSONException e) {
                                ab.w("MicroMsg.JsApiCanvasPutImageData", "put json value error : %s", e);
                                cVar.M(i, j("fail:build action JSON error", null));
                                AppMethodBeat.o(103842);
                                return;
                            }
                        }
                        ab.i("MicroMsg.JsApiCanvasPutImageData", "get data failed, value is not a ByteBuffer");
                        cVar.M(i, j("fail:illegal data", null));
                        AppMethodBeat.o(103842);
                        return;
                    } catch (JSONException e2) {
                        ab.i("MicroMsg.JsApiCanvasPutImageData", "get data failed, %s", Log.getStackTraceString(e2));
                        cVar.M(i, j("fail:missing data", null));
                        AppMethodBeat.o(103842);
                        return;
                    }
                }
                ab.i("MicroMsg.JsApiCanvasPutImageData", "the view is not a instance of CanvasView.(%s)", Integer.valueOf(i2));
                cVar.M(i, j("fail:illegal view type", null));
                AppMethodBeat.o(103842);
            } else {
                ab.w("MicroMsg.JsApiCanvasPutImageData", "the viewId is not a canvas(%s).", Integer.valueOf(i2));
                cVar.M(i, j("fail:illegal view type", null));
                AppMethodBeat.o(103842);
            }
        } catch (JSONException e22) {
            ab.i("MicroMsg.JsApiCanvasPutImageData", "get canvas id failed, %s", Log.getStackTraceString(e22));
            cVar.M(i, j("fail:illegal canvasId", null));
            AppMethodBeat.o(103842);
        }
    }

    private static int[] n(ByteBuffer byteBuffer) {
        int i = 0;
        AppMethodBeat.i(103843);
        byte[] q = d.q(byteBuffer);
        int[] iArr = new int[(q.length / 4)];
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < iArr.length) {
                i = i3 + 1;
                int i4 = i + 1;
                i = ((q[i] & 255) << 8) | ((q[i3] & 255) << 16);
                i3 = i4 + 1;
                i4 = (q[i4] & 255) | i;
                i = i3 + 1;
                iArr[i2] = ((q[i3] & 255) << 24) | i4;
                i2++;
            } else {
                AppMethodBeat.o(103843);
                return iArr;
            }
        }
    }
}
