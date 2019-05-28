package com.tencent.mm.plugin.appbrand.jsapi.u.a;

import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.u.a.a.b.AnonymousClass2;
import com.tencent.mm.plugin.appbrand.jsapi.u.a.a.b.AnonymousClass3;
import com.tencent.mm.plugin.appbrand.jsapi.u.a.a.b.AnonymousClass4;
import com.tencent.mm.plugin.appbrand.jsapi.u.a.a.b.AnonymousClass5;
import com.tencent.mm.plugin.appbrand.jsapi.u.a.a.b.AnonymousClass6;
import com.tencent.mm.plugin.appbrand.jsapi.u.a.a.b.AnonymousClass7;
import com.tencent.mm.plugin.appbrand.jsapi.u.a.a.b.AnonymousClass8;
import com.tencent.mm.plugin.appbrand.jsapi.u.a.a.b.AnonymousClass9;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.model.WMElement;
import java.util.HashMap;
import org.json.JSONObject;

public final class a extends e {
    volatile b idE;
    volatile SurfaceTexture mSurfaceTexture;

    public final void d(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(117345);
        super.d(surfaceTexture);
        this.mSurfaceTexture = surfaceTexture;
        AppMethodBeat.o(117345);
    }

    public final void yr() {
        AppMethodBeat.i(117346);
        super.yr();
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.release();
            this.mSurfaceTexture = null;
        }
        AppMethodBeat.o(117346);
    }

    public final String a(c cVar, JSONObject jSONObject, m mVar, int i) {
        AppMethodBeat.i(117347);
        ab.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "*** handler(%s) handleJsApi(%s), data:%s", wP(), mVar.getName(), jSONObject.toString());
        final m mVar2 = mVar;
        final c cVar2 = cVar;
        final JSONObject jSONObject2 = jSONObject;
        final int i2 = i;
        AnonymousClass1 anonymousClass1 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(117344);
                int optInt;
                if (mVar2 instanceof com.tencent.mm.plugin.appbrand.jsapi.u.a.a.b) {
                    ab.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "Tummy insert");
                    com.tencent.mm.plugin.appbrand.jsapi.g.a.e.oq(9);
                    a aVar = a.this;
                    c cVar = cVar2;
                    JSONObject jSONObject = jSONObject2;
                    m mVar = mVar2;
                    int i = i2;
                    if (aVar.mSurfaceTexture == null) {
                        ab.e("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "remove mSurfaceTexture is null, err");
                        cVar.M(i, mVar.j("fail:internal error", null));
                        com.tencent.mm.plugin.appbrand.jsapi.g.a.e.oq(11);
                        AppMethodBeat.o(117344);
                        return;
                    }
                    b bVar;
                    com.tencent.mm.plugin.appbrand.jsapi.u.a.a.b bVar2 = (com.tencent.mm.plugin.appbrand.jsapi.u.a.a.b) mVar;
                    SurfaceTexture surfaceTexture = aVar.mSurfaceTexture;
                    ab.i("MicroMsg.JsApiInsertXWebMap", "insertXwebMap:%s", jSONObject);
                    float f = bo.getFloat(jSONObject.optString("centerLatitude"), 0.0f);
                    float f2 = bo.getFloat(jSONObject.optString("centerLongitude"), 0.0f);
                    optInt = jSONObject.optInt(WMElement.ANIMATE_TYPE_SCALE, 16);
                    int optInt2 = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, 0);
                    int optInt3 = jSONObject.optInt("skew", 0);
                    if (Math.abs(f) > 90.0f || Math.abs(f2) > 180.0f) {
                        ab.d("MicroMsg.JsApiInsertXWebMap", "centerLatitude or centerLongitude value is error!");
                        bVar = null;
                    } else {
                        String appId = cVar.getAppId();
                        String optString = jSONObject.optString("theme", "");
                        String optString2 = jSONObject.optString("subKey", "");
                        String appId2 = cVar.getAppId();
                        int optInt4 = jSONObject.optInt("styleId", 0);
                        JSONObject optJSONObject = jSONObject.optJSONObject("position");
                        if (optJSONObject == null) {
                            ab.e("MicroMsg.JsApiInsertXWebMap", "positionObj is null, err, return");
                            bVar = null;
                        } else {
                            int a = g.a(optJSONObject, "width", 0);
                            int a2 = g.a(optJSONObject, "height", 0);
                            String g = f.g(cVar, jSONObject);
                            HashMap hashMap = new HashMap(5);
                            hashMap.put("theme", optString);
                            hashMap.put("subKey", optString2);
                            hashMap.put("subId", appId2);
                            hashMap.put("styleId", Integer.valueOf(optInt4));
                            hashMap.put("surface", surfaceTexture);
                            hashMap.put("width", Integer.valueOf(a));
                            hashMap.put("height", Integer.valueOf(a2));
                            hashMap.put("mapType", Integer.valueOf(2));
                            bVar = ((com.tencent.mm.plugin.appbrand.jsapi.g.a.c) com.tencent.luggage.a.e.B(com.tencent.mm.plugin.appbrand.jsapi.g.a.c.class)).a(cVar.getContext(), g, hashMap);
                            if (bVar == null) {
                                ab.e("MicroMsg.JsApiInsertXWebMap", "mapView is null, return");
                                bVar = null;
                            } else if (com.tencent.mm.plugin.appbrand.jsapi.g.a.g.a(appId, f.g(cVar, jSONObject), bVar)) {
                                bVar.ed(jSONObject.optBoolean("enableZoom", true));
                                bVar.ee(jSONObject.optBoolean("enableScroll", true));
                                bVar.ef(jSONObject.optBoolean("enableRotate", false));
                                bVar.eg(jSONObject.optBoolean("showCompass", false));
                                bVar.eh(jSONObject.optBoolean("enable3D", false));
                                bVar.ei(jSONObject.optBoolean("enableOverlooking", false));
                                bVar.ej(jSONObject.optBoolean("enableSatellite", false));
                                bVar.el(jSONObject.optBoolean("enableIndoor", true));
                                bVar.em(jSONObject.optBoolean("enableIndoorLevelPick", false));
                                bVar.a(f, f2, (float) optInt, (float) optInt2, (float) optInt3);
                                if (cVar instanceof com.tencent.mm.plugin.appbrand.jsapi.e) {
                                    com.tencent.mm.plugin.appbrand.jsapi.e eVar = (com.tencent.mm.plugin.appbrand.jsapi.e) cVar;
                                    eVar.a((com.tencent.mm.plugin.appbrand.jsapi.f.b) new com.tencent.mm.plugin.appbrand.jsapi.u.a.a.b.AnonymousClass1(bVar));
                                    eVar.a((d) new AnonymousClass2(bVar));
                                    eVar.a((com.tencent.mm.plugin.appbrand.jsapi.f.c) new AnonymousClass3(eVar, appId, cVar, jSONObject));
                                }
                                bVar.getView().setVisibility(0);
                                if (bVar == null) {
                                    ab.e("MicroMsg.JsApiInsertXWebMap", "mapView is null, error, return");
                                    bVar = null;
                                } else {
                                    int B = f.B(jSONObject);
                                    bVar.a(new AnonymousClass4(B, cVar));
                                    bVar.a(new AnonymousClass5(B, cVar));
                                    bVar.a(new AnonymousClass6(B, cVar));
                                    bVar.a(new AnonymousClass7(B, cVar));
                                    bVar.en(jSONObject.optBoolean("showLocation"));
                                    bVar.a(new AnonymousClass8(B, cVar));
                                    bVar.a(new AnonymousClass9(B, cVar));
                                }
                            } else {
                                ab.e("MicroMsg.JsApiInsertXWebMap", "initMapView is false, return");
                                bVar = null;
                            }
                        }
                    }
                    aVar.idE = bVar;
                    cVar.M(i, mVar.j("ok", null));
                    com.tencent.mm.plugin.appbrand.jsapi.g.a.e.oq(10);
                    AppMethodBeat.o(117344);
                } else if (mVar2 instanceof com.tencent.mm.plugin.appbrand.jsapi.u.a.a.d) {
                    ab.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "Tummy update");
                    com.tencent.mm.plugin.appbrand.jsapi.g.a.e.oq(12);
                    a.this.b(cVar2, jSONObject2, mVar2, i2);
                    AppMethodBeat.o(117344);
                } else {
                    if (mVar2 instanceof com.tencent.mm.plugin.appbrand.jsapi.u.a.a.c) {
                        Object obj;
                        com.tencent.mm.plugin.appbrand.jsapi.g.a.e.oq(15);
                        c cVar2 = cVar2;
                        JSONObject jSONObject2 = jSONObject2;
                        m mVar2 = mVar2;
                        optInt = i2;
                        if (jSONObject2 == null) {
                            ab.e("MicroMsg.JsApiRemoveXWebMap", "data is null");
                            obj = null;
                        } else {
                            ab.i("MicroMsg.JsApiRemoveXWebMap", "removeXWebMap:%s", jSONObject2);
                            com.tencent.mm.plugin.appbrand.jsapi.g.a.g.ck(cVar2.getAppId(), f.g(cVar2, jSONObject2));
                            obj = 1;
                        }
                        if (obj != null) {
                            cVar2.M(optInt, mVar2.j("ok", null));
                            com.tencent.mm.plugin.appbrand.jsapi.g.a.e.oq(16);
                            AppMethodBeat.o(117344);
                            return;
                        }
                        ab.e("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "remove fail");
                        com.tencent.mm.plugin.appbrand.jsapi.g.a.e.oq(17);
                        cVar2.M(optInt, mVar2.j("fail:internal error", null));
                    }
                    AppMethodBeat.o(117344);
                }
            }
        };
        if (cVar.aBy().getLooper() == Looper.myLooper()) {
            anonymousClass1.run();
        } else {
            cVar.aBy().post(anonymousClass1);
        }
        AppMethodBeat.o(117347);
        return null;
    }

    public final boolean a(m mVar) {
        return this.hpN || (mVar != null && (mVar instanceof com.tencent.mm.plugin.appbrand.jsapi.u.a.a.c));
    }

    public final void m(MotionEvent motionEvent) {
        AppMethodBeat.i(117348);
        this.idE.onTouchEvent(motionEvent);
        AppMethodBeat.o(117348);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void b(c cVar, JSONObject jSONObject, m mVar, int i) {
        AppMethodBeat.i(117349);
        if (com.tencent.mm.plugin.appbrand.jsapi.u.a.a.d.h(cVar, jSONObject)) {
            cVar.M(i, mVar.j("ok", null));
            com.tencent.mm.plugin.appbrand.jsapi.g.a.e.oq(13);
            AppMethodBeat.o(117349);
        } else {
            ab.e("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "update fail");
            com.tencent.mm.plugin.appbrand.jsapi.g.a.e.oq(14);
            cVar.M(i, mVar.j("fail:internal error", null));
            AppMethodBeat.o(117349);
        }
    }
}
