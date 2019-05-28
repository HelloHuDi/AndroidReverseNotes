package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.f;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends a<com.tencent.mm.plugin.appbrand.jsapi.c> {
    public static final int CTRL_INDEX = 100;
    public static final String NAME = "canvasToTempFilePath";

    public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c cVar, final JSONObject jSONObject, final int i) {
        AppMethodBeat.i(103845);
        m.aNS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(103844);
                if (cVar.isRunning()) {
                    e c = ((f) cVar.B(f.class)).c(cVar);
                    if (c == null) {
                        ab.w("MicroMsg.JsApiCanvasToTempFilePath", "invoke JsApi canvasToTempFilePath failed, component view is null.");
                        cVar.M(i, c.this.j("fail:page is null", null));
                        AppMethodBeat.o(103844);
                        return;
                    }
                    c cVar = c.this;
                    JSONObject jSONObject = jSONObject;
                    g gVar = new g(cVar, i);
                    try {
                        int i = jSONObject.getInt("canvasId");
                        View q = c.aBf().q(i);
                        if (q == null) {
                            ab.w("MicroMsg.JsApiCanvasToTempFilePath", "get view by viewId(%s) return null.", Integer.valueOf(i));
                            gVar.AR(cVar.j("fail:get canvas by canvasId failed", null));
                            AppMethodBeat.o(103844);
                            return;
                        } else if (q instanceof CoverViewContainer) {
                            View view = (View) ((CoverViewContainer) q).ah(View.class);
                            if (view == null) {
                                ab.w("MicroMsg.JsApiCanvasToTempFilePath", "getTargetView return null, viewId(%s).", Integer.valueOf(i));
                                gVar.AR(cVar.j("fail:target view is null.", null));
                                AppMethodBeat.o(103844);
                                return;
                            }
                            int measuredWidth = view.getMeasuredWidth();
                            int measuredHeight = view.getMeasuredHeight();
                            try {
                                float f;
                                float f2;
                                Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Config.ARGB_8888);
                                float h = com.tencent.mm.plugin.appbrand.r.g.h(jSONObject, VideoMaterialUtil.CRAZYFACE_X);
                                float h2 = com.tencent.mm.plugin.appbrand.r.g.h(jSONObject, VideoMaterialUtil.CRAZYFACE_Y);
                                float a = com.tencent.mm.plugin.appbrand.r.g.a(jSONObject, "width", (float) measuredWidth);
                                float a2 = com.tencent.mm.plugin.appbrand.r.g.a(jSONObject, "height", (float) measuredHeight);
                                if (h + a > ((float) measuredWidth)) {
                                    f = ((float) measuredWidth) - h;
                                } else {
                                    f = a;
                                }
                                if (h2 + a2 > ((float) measuredHeight)) {
                                    f2 = ((float) measuredHeight) - h2;
                                } else {
                                    f2 = a2;
                                }
                                float f3 = bo.getFloat(jSONObject.optString("destWidth"), f);
                                float f4 = bo.getFloat(jSONObject.optString("destHeight"), f2);
                                if (((int) h) < 0 || ((int) h2) < 0 || ((int) f) <= 0 || ((int) f2) <= 0 || ((int) (h + f)) > measuredWidth || ((int) (h2 + f2)) > measuredHeight || ((int) f3) <= 0 || ((int) f4) <= 0) {
                                    ab.e("MicroMsg.JsApiCanvasToTempFilePath", "illegal arguments(x : %s, y : %s, width : %s, height : %s) failed, viewId(%s).", Float.valueOf(h), Float.valueOf(h2), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i));
                                    gVar.AR(cVar.j("fail:illegal arguments", null));
                                    AppMethodBeat.o(103844);
                                    return;
                                }
                                Bitmap createBitmap2;
                                if (view instanceof com.tencent.mm.plugin.appbrand.canvas.widget.a) {
                                    ((com.tencent.mm.plugin.appbrand.canvas.widget.a) view).e(new com.tencent.mm.plugin.appbrand.canvas.f(createBitmap));
                                } else {
                                    view.draw(new com.tencent.mm.plugin.appbrand.canvas.f(createBitmap));
                                }
                                if (!(f == ((float) measuredWidth) && f2 == ((float) measuredHeight))) {
                                    createBitmap2 = Bitmap.createBitmap(createBitmap, (int) h, (int) h2, (int) f, (int) f2, null, false);
                                    ab.i("MicroMsg.JsApiCanvasToTempFilePath", "bitmap recycle %s", createBitmap);
                                    createBitmap.recycle();
                                    createBitmap = createBitmap2;
                                }
                                if (!(f == f3 && f2 == f4)) {
                                    createBitmap2 = Bitmap.createScaledBitmap(createBitmap, (int) f3, (int) f4, false);
                                    ab.i("MicroMsg.JsApiCanvasToTempFilePath", "bitmap recycle %s", createBitmap);
                                    createBitmap.recycle();
                                    createBitmap = createBitmap2;
                                }
                                CompressFormat x = c.x(jSONObject);
                                String str = x == CompressFormat.JPEG ? "jpg" : "png";
                                b yh = c.asE().yh("canvas_" + i + "." + str);
                                if (yh == null) {
                                    ab.e("MicroMsg.JsApiCanvasToTempFilePath", "toTempFilePath, alloc file failed");
                                    gVar.AR(cVar.j("fail alloc file failed", null));
                                    AppMethodBeat.o(103844);
                                    return;
                                }
                                String w = j.w(yh.dMD());
                                ab.d("MicroMsg.JsApiCanvasToTempFilePath", "toTempFilePath, savePath = %s", w);
                                try {
                                    d.a(createBitmap, c.w(jSONObject), x, w, true);
                                    com.tencent.mm.plugin.appbrand.r.j jVar = new com.tencent.mm.plugin.appbrand.r.j();
                                    c.asE().a(new File(w), str, true, jVar);
                                    ab.d("MicroMsg.JsApiCanvasToTempFilePath", "toTempFilePath, returnPath = %s", (String) jVar.value);
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("tempFilePath", r1);
                                    gVar.AR(cVar.j("ok", hashMap));
                                    AppMethodBeat.o(103844);
                                    return;
                                } catch (IOException e) {
                                    ab.w("MicroMsg.JsApiCanvasToTempFilePath", "save bitmap to file failed, viewId(%s). exception : %s", Integer.valueOf(i), e);
                                    gVar.AR(cVar.j("fail:write file failed", null));
                                    AppMethodBeat.o(103844);
                                    return;
                                }
                            } catch (Exception e2) {
                                ab.w("MicroMsg.JsApiCanvasToTempFilePath", "create bitmap failed, viewId(%s). Exception : %s", Integer.valueOf(i), e2);
                                gVar.AR(cVar.j("fail:create bitmap failed", null));
                                AppMethodBeat.o(103844);
                                return;
                            }
                        } else {
                            ab.w("MicroMsg.JsApiCanvasToTempFilePath", "the view(%s) is not a instance of CoverViewContainer.", Integer.valueOf(i));
                            gVar.AR(cVar.j("fail:the view is not a instance of CoverViewContainer", null));
                            AppMethodBeat.o(103844);
                            return;
                        }
                    } catch (JSONException e3) {
                        ab.w("MicroMsg.JsApiCanvasToTempFilePath", "canvasId do not exist. exception : %s", e3);
                        gVar.AR(cVar.j("fail:canvasId do not exist", null));
                        AppMethodBeat.o(103844);
                        return;
                    }
                }
                ab.w("MicroMsg.JsApiCanvasToTempFilePath", "invoke JsApi insertView failed, current page view is null.");
                cVar.M(i, c.this.j("fail", null));
                AppMethodBeat.o(103844);
            }
        });
        AppMethodBeat.o(103845);
    }

    public static int w(JSONObject jSONObject) {
        float f = 0.0f;
        AppMethodBeat.i(103846);
        float optDouble = (float) jSONObject.optDouble("quality", 1.0d);
        if (optDouble >= 0.0f) {
            if (optDouble > 1.0f) {
                f = 100.0f;
            } else {
                f = optDouble * 100.0f;
            }
        }
        int i = (int) f;
        AppMethodBeat.o(103846);
        return i;
    }

    public static CompressFormat x(JSONObject jSONObject) {
        AppMethodBeat.i(103847);
        CompressFormat compressFormat = CompressFormat.PNG;
        if ("jpg".equalsIgnoreCase(jSONObject.optString("fileType"))) {
            compressFormat = CompressFormat.JPEG;
        }
        AppMethodBeat.o(103847);
        return compressFormat;
    }
}
