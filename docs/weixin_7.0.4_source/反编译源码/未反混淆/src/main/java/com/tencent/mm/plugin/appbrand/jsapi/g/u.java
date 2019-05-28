package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.o;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class u extends a {
    public static final int CTRL_INDEX = 200;
    public static final String NAME = "translateMapMarker";
    private List<Runnable> hMO = new ArrayList();
    private AtomicBoolean hMP = new AtomicBoolean(false);

    public u() {
        AppMethodBeat.i(93874);
        AppMethodBeat.o(93874);
    }

    static /* synthetic */ void a(u uVar, c cVar, int i, String str, boolean z) {
        AppMethodBeat.i(93879);
        uVar.a(cVar, i, str, z);
        AppMethodBeat.o(93879);
    }

    public final void a(final c cVar, final JSONObject jSONObject, final int i) {
        AppMethodBeat.i(93875);
        super.a(cVar, jSONObject, i);
        this.hMO.add(new Runnable() {
            public final void run() {
                AppMethodBeat.i(93872);
                u.this.d(cVar, jSONObject, i);
                AppMethodBeat.o(93872);
            }
        });
        aDM();
        AppMethodBeat.o(93875);
    }

    private synchronized void aDM() {
        AppMethodBeat.i(93876);
        if (this.hMP.get()) {
            AppMethodBeat.o(93876);
        } else if (this.hMO.size() == 0) {
            AppMethodBeat.o(93876);
        } else {
            Runnable runnable = (Runnable) this.hMO.remove(0);
            if (runnable != null) {
                m.aNS().aa(runnable);
            }
            AppMethodBeat.o(93876);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void d(final c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(93877);
        this.hMP.set(true);
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiTranslateMapMarker", "data is invalid, err");
            a(cVar, i, "fail:invalid data", false);
            AppMethodBeat.o(93877);
            return;
        }
        ab.d("MicroMsg.JsApiTranslateMapMarker", "data:%s", jSONObject.toString());
        final b f = f(cVar, jSONObject);
        if (f == null) {
            ab.e("MicroMsg.JsApiTranslateMapMarker", "mapView is null, return");
            a(cVar, i, String.format("fail:internal error %s", new Object[]{"mapview is null"}), false);
            AppMethodBeat.o(93877);
            return;
        }
        String optString = jSONObject.optString("markerId");
        try {
            JSONArray jSONArray = new JSONArray(jSONObject.optString("keyFrames"));
            LinkedList linkedList = new LinkedList();
            ab.d("MicroMsg.JsApiTranslateMapMarker", "keyFramesArray size :%d", Integer.valueOf(jSONArray.length()));
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                g gVar = new g();
                gVar.duration = jSONObject2.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION, 0);
                if (gVar.duration == 0) {
                    ab.e("MicroMsg.JsApiTranslateMapMarker", "keyFrame.duration is zero, err continue");
                } else {
                    gVar.rotate = (float) jSONObject2.optDouble(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, 0.0d);
                    String optString2 = jSONObject2.optString("latitude");
                    if (!bo.isNullOrNil(optString2)) {
                        gVar.latitude = (double) bo.getFloat(optString2, 0.0f);
                    }
                    String optString3 = jSONObject2.optString("longitude");
                    if (!bo.isNullOrNil(optString3)) {
                        gVar.longitude = (double) bo.getFloat(optString3, 0.0f);
                    }
                    linkedList.add(gVar);
                }
            }
            f.a(optString, linkedList, new o() {
                public final void ec(boolean z) {
                    AppMethodBeat.i(93873);
                    ab.i("MicroMsg.JsApiTranslateMapMarker", "onMarkerTranslate result::%b", Boolean.valueOf(z));
                    if (z) {
                        u.a(u.this, cVar, i, "ok", f.aDU());
                        AppMethodBeat.o(93873);
                        return;
                    }
                    u.a(u.this, cVar, i, "fail", f.aDU());
                    AppMethodBeat.o(93873);
                }
            });
            AppMethodBeat.o(93877);
        } catch (JSONException e) {
            ab.e("MicroMsg.JsApiTranslateMapMarker", "parse keyFrames error, exception : %s", e);
            a(cVar, i, String.format("fail:internal error %s", new Object[]{"parse json fail"}), f.aDU());
            AppMethodBeat.o(93877);
        }
    }

    private void a(c cVar, int i, String str, boolean z) {
        AppMethodBeat.i(93878);
        a(cVar, i, j(str, null), str.equals("ok"), z);
        this.hMP.set(false);
        aDM();
        AppMethodBeat.o(93878);
    }
}
