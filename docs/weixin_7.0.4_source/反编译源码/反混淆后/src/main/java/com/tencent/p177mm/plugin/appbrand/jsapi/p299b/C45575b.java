package com.tencent.p177mm.plugin.appbrand.jsapi.p299b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import android.view.View;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.widget.C10164a;
import com.tencent.p177mm.plugin.appbrand.canvas.widget.C10164a.C10165a;
import com.tencent.p177mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C10333f;
import com.tencent.p177mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.plugin.appbrand.p328r.C45672d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.b.b */
public final class C45575b extends C10296a<C2241c> {
    public static final int CTRL_INDEX = 373;
    public static final String NAME = "canvasPutImageData";

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(103842);
        try {
            int i2 = jSONObject.getInt("canvasId");
            C33303e c = ((C10333f) c2241c.mo5936B(C10333f.class)).mo21784c(c2241c);
            if (c == null) {
                C4990ab.m7420w("MicroMsg.JsApiCanvasPutImageData", "invoke JsApi canvasPutImageData failed, component view is null.");
                c2241c.mo6107M(i, mo73394j("fail:page is null", null));
                AppMethodBeat.m2505o(103842);
                return;
            }
            View q = c.aBf().mo73454q(i2);
            if (q == null) {
                C4990ab.m7421w("MicroMsg.JsApiCanvasPutImageData", "view(%s) is null.", Integer.valueOf(i2));
                c2241c.mo6107M(i, mo73394j("fail:view is null", null));
                AppMethodBeat.m2505o(103842);
            } else if (q instanceof CoverViewContainer) {
                q = (View) ((CoverViewContainer) q).mo60996ah(View.class);
                if (q instanceof C10164a) {
                    float aNQ = C42668g.aNQ();
                    int optInt = jSONObject.optInt(VideoMaterialUtil.CRAZYFACE_X);
                    int optInt2 = jSONObject.optInt(VideoMaterialUtil.CRAZYFACE_Y);
                    int optInt3 = jSONObject.optInt("width");
                    int optInt4 = jSONObject.optInt("height");
                    Math.round(((float) optInt) * aNQ);
                    Math.round(((float) optInt2) * aNQ);
                    Math.round(((float) optInt3) * aNQ);
                    Math.round(aNQ * ((float) optInt4));
                    if (optInt3 == 0 || optInt4 == 0) {
                        C4990ab.m7417i("MicroMsg.JsApiCanvasPutImageData", "width(%s) or height(%s) is 0.(%s)", Integer.valueOf(optInt3), Integer.valueOf(optInt4), Integer.valueOf(i2));
                        c2241c.mo6107M(i, mo73394j("fail:width or height is 0", null));
                        AppMethodBeat.m2505o(103842);
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
                            int[] n = C45575b.m84082n(byteBuffer);
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                JSONArray jSONArray2 = new JSONArray();
                                jSONArray2.put(optInt);
                                jSONArray2.put(optInt2);
                                jSONArray2.put(i2);
                                jSONArray2.put(optInt3);
                                jSONArray2.put(Bitmap.createBitmap(n, i2, optInt3, Config.ARGB_8888));
                                jSONObject2.put(C8741b.METHOD, "__setPixels");
                                jSONObject2.put("data", jSONArray2);
                                jSONArray.put(jSONObject2);
                                C10164a c10164a = (C10164a) q;
                                c10164a.mo21539b(jSONArray, new C10165a() {
                                    /* renamed from: a */
                                    public final void mo6094a(DrawCanvasArg drawCanvasArg) {
                                        AppMethodBeat.m2504i(103841);
                                        c2241c.mo6107M(i, C45575b.this.mo73394j("ok", null));
                                        AppMethodBeat.m2505o(103841);
                                    }
                                });
                                c10164a.ayc();
                                AppMethodBeat.m2505o(103842);
                                return;
                            } catch (JSONException e) {
                                C4990ab.m7421w("MicroMsg.JsApiCanvasPutImageData", "put json value error : %s", e);
                                c2241c.mo6107M(i, mo73394j("fail:build action JSON error", null));
                                AppMethodBeat.m2505o(103842);
                                return;
                            }
                        }
                        C4990ab.m7416i("MicroMsg.JsApiCanvasPutImageData", "get data failed, value is not a ByteBuffer");
                        c2241c.mo6107M(i, mo73394j("fail:illegal data", null));
                        AppMethodBeat.m2505o(103842);
                        return;
                    } catch (JSONException e2) {
                        C4990ab.m7417i("MicroMsg.JsApiCanvasPutImageData", "get data failed, %s", Log.getStackTraceString(e2));
                        c2241c.mo6107M(i, mo73394j("fail:missing data", null));
                        AppMethodBeat.m2505o(103842);
                        return;
                    }
                }
                C4990ab.m7417i("MicroMsg.JsApiCanvasPutImageData", "the view is not a instance of CanvasView.(%s)", Integer.valueOf(i2));
                c2241c.mo6107M(i, mo73394j("fail:illegal view type", null));
                AppMethodBeat.m2505o(103842);
            } else {
                C4990ab.m7421w("MicroMsg.JsApiCanvasPutImageData", "the viewId is not a canvas(%s).", Integer.valueOf(i2));
                c2241c.mo6107M(i, mo73394j("fail:illegal view type", null));
                AppMethodBeat.m2505o(103842);
            }
        } catch (JSONException e22) {
            C4990ab.m7417i("MicroMsg.JsApiCanvasPutImageData", "get canvas id failed, %s", Log.getStackTraceString(e22));
            c2241c.mo6107M(i, mo73394j("fail:illegal canvasId", null));
            AppMethodBeat.m2505o(103842);
        }
    }

    /* renamed from: n */
    private static int[] m84082n(ByteBuffer byteBuffer) {
        int i = 0;
        AppMethodBeat.m2504i(103843);
        byte[] q = C45672d.m84374q(byteBuffer);
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
                AppMethodBeat.m2505o(103843);
                return iArr;
            }
        }
    }
}
