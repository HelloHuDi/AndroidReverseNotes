package com.tencent.p177mm.plugin.appbrand.jsapi.p299b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C19151f;
import com.tencent.p177mm.plugin.appbrand.canvas.widget.C10164a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C10333f;
import com.tencent.p177mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.b.a */
public final class C33251a extends C10296a<C2241c> {
    public static final int CTRL_INDEX = 372;
    public static final String NAME = "canvasGetImageData";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(103838);
        try {
            int i2 = jSONObject.getInt("canvasId");
            C33303e c = ((C10333f) c2241c.mo5936B(C10333f.class)).mo21784c(c2241c);
            if (c == null) {
                C4990ab.m7420w("MicroMsg.JsApiCanvasGetImageData", "invoke JsApi canvasGetImageData failed, component view is null.");
                c2241c.mo6107M(i, mo73394j("fail:page is null", null));
                AppMethodBeat.m2505o(103838);
                return;
            }
            View q = c.aBf().mo73454q(i2);
            if (q == null) {
                C4990ab.m7421w("MicroMsg.JsApiCanvasGetImageData", "view(%s) is null.", Integer.valueOf(i2));
                c2241c.mo6107M(i, mo73394j("fail:view is null", null));
                AppMethodBeat.m2505o(103838);
            } else if (q instanceof CoverViewContainer) {
                q = (View) ((CoverViewContainer) q).mo60996ah(View.class);
                if (q instanceof C10164a) {
                    float aNQ = C42668g.aNQ();
                    int optInt = jSONObject.optInt(VideoMaterialUtil.CRAZYFACE_X);
                    int optInt2 = jSONObject.optInt(VideoMaterialUtil.CRAZYFACE_Y);
                    int optInt3 = jSONObject.optInt("width");
                    int optInt4 = jSONObject.optInt("height");
                    if (optInt3 == 0 || optInt4 == 0) {
                        C4990ab.m7417i("MicroMsg.JsApiCanvasGetImageData", "width(%s) or height(%s) is 0.(%s)", Integer.valueOf(optInt3), Integer.valueOf(optInt4), Integer.valueOf(i2));
                        c2241c.mo6107M(i, mo73394j("fail:width or height is 0", null));
                        AppMethodBeat.m2505o(103838);
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
                        c2241c.mo6107M(i, mo73393a(c2241c, "ok", C33251a.m54402e(new int[(optInt3 * i4)], optInt3, i4)));
                        AppMethodBeat.m2505o(103838);
                        return;
                    } else {
                        i5 = round;
                    }
                    if (round2 < 0) {
                        i6 = 0;
                    } else if (round2 >= measuredHeight) {
                        c2241c.mo6107M(i, mo73393a(c2241c, "ok", C33251a.m54402e(new int[(optInt3 * i4)], optInt3, i4)));
                        AppMethodBeat.m2505o(103838);
                        return;
                    } else {
                        i6 = round2;
                    }
                    if (round + optInt4 > measuredWidth) {
                        optInt4 = measuredWidth - i5;
                    } else if (round + optInt4 <= 0) {
                        c2241c.mo6107M(i, mo73393a(c2241c, "ok", C33251a.m54402e(new int[(optInt3 * i4)], optInt3, i4)));
                        AppMethodBeat.m2505o(103838);
                        return;
                    } else if (round < 0) {
                        optInt4 += round;
                    }
                    if (round2 + optInt2 > measuredHeight) {
                        optInt2 = measuredHeight - i6;
                    } else if (round2 + optInt2 <= 0) {
                        c2241c.mo6107M(i, mo73393a(c2241c, "ok", C33251a.m54402e(new int[(optInt3 * i4)], optInt3, i4)));
                        AppMethodBeat.m2505o(103838);
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
                        C19151f c19151f = new C19151f(createBitmap);
                        c19151f.save();
                        c19151f.translate((float) (-i5), (float) (-i6));
                        ((C10164a) q).mo21540e(c19151f);
                        c19151f.restore();
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, round2, round, false);
                        int[] iArr = new int[(optInt3 * i4)];
                        createScaledBitmap.getPixels(iArr, ((measuredHeight - optInt) * optInt3) + (measuredWidth - i3), optInt3, 0, 0, round2, round);
                        c2241c.mo6107M(i, mo73393a(c2241c, "ok", C33251a.m54402e(iArr, optInt3, i4)));
                        AppMethodBeat.m2505o(103838);
                        return;
                    } catch (Exception e) {
                        C4990ab.m7421w("MicroMsg.JsApiCanvasGetImageData", "create bitmap failed, viewId(%s). Exception : %s", Integer.valueOf(i2), e);
                        c2241c.mo6107M(i, mo73394j("fail:create bitmap failed", null));
                        AppMethodBeat.m2505o(103838);
                        return;
                    }
                }
                C4990ab.m7417i("MicroMsg.JsApiCanvasGetImageData", "the view is not a instance of CanvasView.(%s)", Integer.valueOf(i2));
                c2241c.mo6107M(i, mo73394j("fail:illegal view type", null));
                AppMethodBeat.m2505o(103838);
            } else {
                C4990ab.m7421w("MicroMsg.JsApiCanvasGetImageData", "the viewId is not a canvas(%s).", Integer.valueOf(i2));
                c2241c.mo6107M(i, mo73394j("fail:illegal view type", null));
                AppMethodBeat.m2505o(103838);
            }
        } catch (JSONException e2) {
            C4990ab.m7417i("MicroMsg.JsApiCanvasGetImageData", "get canvas id failed, %s", Log.getStackTraceString(e2));
            c2241c.mo6107M(i, mo73394j("fail:illegal canvasId", null));
            AppMethodBeat.m2505o(103838);
        }
    }

    /* renamed from: e */
    private static Map<String, Object> m54402e(int[] iArr, int i, int i2) {
        AppMethodBeat.m2504i(103839);
        ByteBuffer o = C33251a.m54403o(iArr);
        HashMap hashMap = new HashMap();
        hashMap.put("data", o);
        hashMap.put("width", Integer.valueOf(i));
        hashMap.put("height", Integer.valueOf(i2));
        AppMethodBeat.m2505o(103839);
        return hashMap;
    }

    /* renamed from: o */
    private static ByteBuffer m54403o(int[] iArr) {
        int i = 0;
        AppMethodBeat.m2504i(103840);
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
                AppMethodBeat.m2505o(103840);
                return wrap;
            }
        }
    }
}
