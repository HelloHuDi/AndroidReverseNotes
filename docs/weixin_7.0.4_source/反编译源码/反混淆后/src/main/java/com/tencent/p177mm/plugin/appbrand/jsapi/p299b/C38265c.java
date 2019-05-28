package com.tencent.p177mm.plugin.appbrand.jsapi.p299b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C19151f;
import com.tencent.p177mm.plugin.appbrand.canvas.widget.C10164a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C10333f;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C26932g;
import com.tencent.p177mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5736j;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.b.c */
public final class C38265c extends C10296a<C2241c> {
    public static final int CTRL_INDEX = 100;
    public static final String NAME = "canvasToTempFilePath";

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, final JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(103845);
        C45673m.aNS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(103844);
                if (c2241c.isRunning()) {
                    C33303e c = ((C10333f) c2241c.mo5936B(C10333f.class)).mo21784c(c2241c);
                    if (c == null) {
                        C4990ab.m7420w("MicroMsg.JsApiCanvasToTempFilePath", "invoke JsApi canvasToTempFilePath failed, component view is null.");
                        c2241c.mo6107M(i, C38265c.this.mo73394j("fail:page is null", null));
                        AppMethodBeat.m2505o(103844);
                        return;
                    }
                    C38265c c38265c = C38265c.this;
                    JSONObject jSONObject = jSONObject;
                    C26932g c26932g = new C26932g(c2241c, i);
                    try {
                        int i = jSONObject.getInt("canvasId");
                        View q = c.aBf().mo73454q(i);
                        if (q == null) {
                            C4990ab.m7421w("MicroMsg.JsApiCanvasToTempFilePath", "get view by viewId(%s) return null.", Integer.valueOf(i));
                            c26932g.mo44674AR(c38265c.mo73394j("fail:get canvas by canvasId failed", null));
                            AppMethodBeat.m2505o(103844);
                            return;
                        } else if (q instanceof CoverViewContainer) {
                            View view = (View) ((CoverViewContainer) q).mo60996ah(View.class);
                            if (view == null) {
                                C4990ab.m7421w("MicroMsg.JsApiCanvasToTempFilePath", "getTargetView return null, viewId(%s).", Integer.valueOf(i));
                                c26932g.mo44674AR(c38265c.mo73394j("fail:target view is null.", null));
                                AppMethodBeat.m2505o(103844);
                                return;
                            }
                            int measuredWidth = view.getMeasuredWidth();
                            int measuredHeight = view.getMeasuredHeight();
                            try {
                                float f;
                                float f2;
                                Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Config.ARGB_8888);
                                float h = C42668g.m75565h(jSONObject, VideoMaterialUtil.CRAZYFACE_X);
                                float h2 = C42668g.m75565h(jSONObject, VideoMaterialUtil.CRAZYFACE_Y);
                                float a = C42668g.m75553a(jSONObject, "width", (float) measuredWidth);
                                float a2 = C42668g.m75553a(jSONObject, "height", (float) measuredHeight);
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
                                float f3 = C5046bo.getFloat(jSONObject.optString("destWidth"), f);
                                float f4 = C5046bo.getFloat(jSONObject.optString("destHeight"), f2);
                                if (((int) h) < 0 || ((int) h2) < 0 || ((int) f) <= 0 || ((int) f2) <= 0 || ((int) (h + f)) > measuredWidth || ((int) (h2 + f2)) > measuredHeight || ((int) f3) <= 0 || ((int) f4) <= 0) {
                                    C4990ab.m7413e("MicroMsg.JsApiCanvasToTempFilePath", "illegal arguments(x : %s, y : %s, width : %s, height : %s) failed, viewId(%s).", Float.valueOf(h), Float.valueOf(h2), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i));
                                    c26932g.mo44674AR(c38265c.mo73394j("fail:illegal arguments", null));
                                    AppMethodBeat.m2505o(103844);
                                    return;
                                }
                                Bitmap createBitmap2;
                                if (view instanceof C10164a) {
                                    ((C10164a) view).mo21540e(new C19151f(createBitmap));
                                } else {
                                    view.draw(new C19151f(createBitmap));
                                }
                                if (!(f == ((float) measuredWidth) && f2 == ((float) measuredHeight))) {
                                    createBitmap2 = Bitmap.createBitmap(createBitmap, (int) h, (int) h2, (int) f, (int) f2, null, false);
                                    C4990ab.m7417i("MicroMsg.JsApiCanvasToTempFilePath", "bitmap recycle %s", createBitmap);
                                    createBitmap.recycle();
                                    createBitmap = createBitmap2;
                                }
                                if (!(f == f3 && f2 == f4)) {
                                    createBitmap2 = Bitmap.createScaledBitmap(createBitmap, (int) f3, (int) f4, false);
                                    C4990ab.m7417i("MicroMsg.JsApiCanvasToTempFilePath", "bitmap recycle %s", createBitmap);
                                    createBitmap.recycle();
                                    createBitmap = createBitmap2;
                                }
                                CompressFormat x = C38265c.m64758x(jSONObject);
                                String str = x == CompressFormat.JPEG ? "jpg" : "png";
                                C5728b yh = c.asE().mo34315yh("canvas_" + i + "." + str);
                                if (yh == null) {
                                    C4990ab.m7412e("MicroMsg.JsApiCanvasToTempFilePath", "toTempFilePath, alloc file failed");
                                    c26932g.mo44674AR(c38265c.mo73394j("fail alloc file failed", null));
                                    AppMethodBeat.m2505o(103844);
                                    return;
                                }
                                String w = C5736j.m8649w(yh.dMD());
                                C4990ab.m7411d("MicroMsg.JsApiCanvasToTempFilePath", "toTempFilePath, savePath = %s", w);
                                try {
                                    C5056d.m7625a(createBitmap, C38265c.m64757w(jSONObject), x, w, true);
                                    C19681j c19681j = new C19681j();
                                    c.asE().mo5835a(new File(w), str, true, c19681j);
                                    C4990ab.m7411d("MicroMsg.JsApiCanvasToTempFilePath", "toTempFilePath, returnPath = %s", (String) c19681j.value);
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("tempFilePath", r1);
                                    c26932g.mo44674AR(c38265c.mo73394j("ok", hashMap));
                                    AppMethodBeat.m2505o(103844);
                                    return;
                                } catch (IOException e) {
                                    C4990ab.m7421w("MicroMsg.JsApiCanvasToTempFilePath", "save bitmap to file failed, viewId(%s). exception : %s", Integer.valueOf(i), e);
                                    c26932g.mo44674AR(c38265c.mo73394j("fail:write file failed", null));
                                    AppMethodBeat.m2505o(103844);
                                    return;
                                }
                            } catch (Exception e2) {
                                C4990ab.m7421w("MicroMsg.JsApiCanvasToTempFilePath", "create bitmap failed, viewId(%s). Exception : %s", Integer.valueOf(i), e2);
                                c26932g.mo44674AR(c38265c.mo73394j("fail:create bitmap failed", null));
                                AppMethodBeat.m2505o(103844);
                                return;
                            }
                        } else {
                            C4990ab.m7421w("MicroMsg.JsApiCanvasToTempFilePath", "the view(%s) is not a instance of CoverViewContainer.", Integer.valueOf(i));
                            c26932g.mo44674AR(c38265c.mo73394j("fail:the view is not a instance of CoverViewContainer", null));
                            AppMethodBeat.m2505o(103844);
                            return;
                        }
                    } catch (JSONException e3) {
                        C4990ab.m7421w("MicroMsg.JsApiCanvasToTempFilePath", "canvasId do not exist. exception : %s", e3);
                        c26932g.mo44674AR(c38265c.mo73394j("fail:canvasId do not exist", null));
                        AppMethodBeat.m2505o(103844);
                        return;
                    }
                }
                C4990ab.m7420w("MicroMsg.JsApiCanvasToTempFilePath", "invoke JsApi insertView failed, current page view is null.");
                c2241c.mo6107M(i, C38265c.this.mo73394j("fail", null));
                AppMethodBeat.m2505o(103844);
            }
        });
        AppMethodBeat.m2505o(103845);
    }

    /* renamed from: w */
    public static int m64757w(JSONObject jSONObject) {
        float f = 0.0f;
        AppMethodBeat.m2504i(103846);
        float optDouble = (float) jSONObject.optDouble("quality", 1.0d);
        if (optDouble >= 0.0f) {
            if (optDouble > 1.0f) {
                f = 100.0f;
            } else {
                f = optDouble * 100.0f;
            }
        }
        int i = (int) f;
        AppMethodBeat.m2505o(103846);
        return i;
    }

    /* renamed from: x */
    public static CompressFormat m64758x(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103847);
        CompressFormat compressFormat = CompressFormat.PNG;
        if ("jpg".equalsIgnoreCase(jSONObject.optString("fileType"))) {
            compressFormat = CompressFormat.JPEG;
        }
        AppMethodBeat.m2505o(103847);
        return compressFormat;
    }
}
