package com.tencent.p177mm.plugin.appbrand.jsapi.p306g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10402o;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10409g;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.u */
public final class C2289u extends C42517a {
    public static final int CTRL_INDEX = 200;
    public static final String NAME = "translateMapMarker";
    private List<Runnable> hMO = new ArrayList();
    private AtomicBoolean hMP = new AtomicBoolean(false);

    public C2289u() {
        AppMethodBeat.m2504i(93874);
        AppMethodBeat.m2505o(93874);
    }

    /* renamed from: a */
    static /* synthetic */ void m4511a(C2289u c2289u, C2241c c2241c, int i, String str, boolean z) {
        AppMethodBeat.m2504i(93879);
        c2289u.m4510a(c2241c, i, str, z);
        AppMethodBeat.m2505o(93879);
    }

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, final JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(93875);
        super.mo5994a(c2241c, jSONObject, i);
        this.hMO.add(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(93872);
                C2289u.this.mo6164d(c2241c, jSONObject, i);
                AppMethodBeat.m2505o(93872);
            }
        });
        aDM();
        AppMethodBeat.m2505o(93875);
    }

    private synchronized void aDM() {
        AppMethodBeat.m2504i(93876);
        if (this.hMP.get()) {
            AppMethodBeat.m2505o(93876);
        } else if (this.hMO.size() == 0) {
            AppMethodBeat.m2505o(93876);
        } else {
            Runnable runnable = (Runnable) this.hMO.remove(0);
            if (runnable != null) {
                C45673m.aNS().mo10302aa(runnable);
            }
            AppMethodBeat.m2505o(93876);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: d */
    public final void mo6164d(final C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(93877);
        this.hMP.set(true);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiTranslateMapMarker", "data is invalid, err");
            m4510a(c2241c, i, "fail:invalid data", false);
            AppMethodBeat.m2505o(93877);
            return;
        }
        C4990ab.m7411d("MicroMsg.JsApiTranslateMapMarker", "data:%s", jSONObject.toString());
        final C10406b f = mo67990f(c2241c, jSONObject);
        if (f == null) {
            C4990ab.m7412e("MicroMsg.JsApiTranslateMapMarker", "mapView is null, return");
            m4510a(c2241c, i, String.format("fail:internal error %s", new Object[]{"mapview is null"}), false);
            AppMethodBeat.m2505o(93877);
            return;
        }
        String optString = jSONObject.optString("markerId");
        try {
            JSONArray jSONArray = new JSONArray(jSONObject.optString("keyFrames"));
            LinkedList linkedList = new LinkedList();
            C4990ab.m7411d("MicroMsg.JsApiTranslateMapMarker", "keyFramesArray size :%d", Integer.valueOf(jSONArray.length()));
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                C10409g c10409g = new C10409g();
                c10409g.duration = jSONObject2.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION, 0);
                if (c10409g.duration == 0) {
                    C4990ab.m7412e("MicroMsg.JsApiTranslateMapMarker", "keyFrame.duration is zero, err continue");
                } else {
                    c10409g.rotate = (float) jSONObject2.optDouble(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, 0.0d);
                    String optString2 = jSONObject2.optString("latitude");
                    if (!C5046bo.isNullOrNil(optString2)) {
                        c10409g.latitude = (double) C5046bo.getFloat(optString2, 0.0f);
                    }
                    String optString3 = jSONObject2.optString("longitude");
                    if (!C5046bo.isNullOrNil(optString3)) {
                        c10409g.longitude = (double) C5046bo.getFloat(optString3, 0.0f);
                    }
                    linkedList.add(c10409g);
                }
            }
            f.mo21894a(optString, linkedList, new C10402o() {
                /* renamed from: ec */
                public final void mo6165ec(boolean z) {
                    AppMethodBeat.m2504i(93873);
                    C4990ab.m7417i("MicroMsg.JsApiTranslateMapMarker", "onMarkerTranslate result::%b", Boolean.valueOf(z));
                    if (z) {
                        C2289u.m4511a(C2289u.this, c2241c, i, "ok", f.aDU());
                        AppMethodBeat.m2505o(93873);
                        return;
                    }
                    C2289u.m4511a(C2289u.this, c2241c, i, "fail", f.aDU());
                    AppMethodBeat.m2505o(93873);
                }
            });
            AppMethodBeat.m2505o(93877);
        } catch (JSONException e) {
            C4990ab.m7413e("MicroMsg.JsApiTranslateMapMarker", "parse keyFrames error, exception : %s", e);
            m4510a(c2241c, i, String.format("fail:internal error %s", new Object[]{"parse json fail"}), f.aDU());
            AppMethodBeat.m2505o(93877);
        }
    }

    /* renamed from: a */
    private void m4510a(C2241c c2241c, int i, String str, boolean z) {
        AppMethodBeat.m2504i(93878);
        mo67989a(c2241c, i, mo73394j(str, null), str.equals("ok"), z);
        this.hMP.set(false);
        aDM();
        AppMethodBeat.m2505o(93878);
    }
}
