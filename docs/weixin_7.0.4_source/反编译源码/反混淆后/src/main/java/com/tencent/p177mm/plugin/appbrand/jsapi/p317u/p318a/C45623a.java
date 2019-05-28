package com.tencent.p177mm.plugin.appbrand.jsapi.p317u.p318a;

import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.view.MotionEvent;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10379b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10380c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10381d;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C31303c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C33319e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C33320g;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C38303f;
import com.tencent.p177mm.plugin.appbrand.jsapi.p317u.p318a.p319a.C10523b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p317u.p318a.p319a.C10523b.C105241;
import com.tencent.p177mm.plugin.appbrand.jsapi.p317u.p318a.p319a.C10523b.C105258;
import com.tencent.p177mm.plugin.appbrand.jsapi.p317u.p318a.p319a.C10523b.C105263;
import com.tencent.p177mm.plugin.appbrand.jsapi.p317u.p318a.p319a.C10523b.C105274;
import com.tencent.p177mm.plugin.appbrand.jsapi.p317u.p318a.p319a.C10523b.C105286;
import com.tencent.p177mm.plugin.appbrand.jsapi.p317u.p318a.p319a.C10523b.C105299;
import com.tencent.p177mm.plugin.appbrand.jsapi.p317u.p318a.p319a.C10523b.C105305;
import com.tencent.p177mm.plugin.appbrand.jsapi.p317u.p318a.p319a.C10523b.C23472;
import com.tencent.p177mm.plugin.appbrand.jsapi.p317u.p318a.p319a.C10523b.C23487;
import com.tencent.p177mm.plugin.appbrand.jsapi.p317u.p318a.p319a.C19491d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p317u.p318a.p319a.C31308c;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.plugin.appbrand.p893e.C42433e;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.model.WMElement;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.a.a */
public final class C45623a extends C42433e {
    volatile C10406b idE;
    volatile SurfaceTexture mSurfaceTexture;

    /* renamed from: d */
    public final void mo32980d(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(117345);
        super.mo32980d(surfaceTexture);
        this.mSurfaceTexture = surfaceTexture;
        AppMethodBeat.m2505o(117345);
    }

    /* renamed from: yr */
    public final void mo32982yr() {
        AppMethodBeat.m2504i(117346);
        super.mo32982yr();
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.release();
            this.mSurfaceTexture = null;
        }
        AppMethodBeat.m2505o(117346);
    }

    /* renamed from: a */
    public final String mo41591a(C2241c c2241c, JSONObject jSONObject, C45608m c45608m, int i) {
        AppMethodBeat.m2504i(117347);
        C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "*** handler(%s) handleJsApi(%s), data:%s", mo67958wP(), c45608m.getName(), jSONObject.toString());
        final C45608m c45608m2 = c45608m;
        final C2241c c2241c2 = c2241c;
        final JSONObject jSONObject2 = jSONObject;
        final int i2 = i;
        C194901 c194901 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(117344);
                int optInt;
                if (c45608m2 instanceof C10523b) {
                    C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "Tummy insert");
                    C33319e.m54490oq(9);
                    C45623a c45623a = C45623a.this;
                    C2241c c2241c = c2241c2;
                    JSONObject jSONObject = jSONObject2;
                    C45608m c45608m = c45608m2;
                    int i = i2;
                    if (c45623a.mSurfaceTexture == null) {
                        C4990ab.m7412e("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "remove mSurfaceTexture is null, err");
                        c2241c.mo6107M(i, c45608m.mo73394j("fail:internal error", null));
                        C33319e.m54490oq(11);
                        AppMethodBeat.m2505o(117344);
                        return;
                    }
                    C10406b c10406b;
                    C10523b c10523b = (C10523b) c45608m;
                    SurfaceTexture surfaceTexture = c45623a.mSurfaceTexture;
                    C4990ab.m7417i("MicroMsg.JsApiInsertXWebMap", "insertXwebMap:%s", jSONObject);
                    float f = C5046bo.getFloat(jSONObject.optString("centerLatitude"), 0.0f);
                    float f2 = C5046bo.getFloat(jSONObject.optString("centerLongitude"), 0.0f);
                    optInt = jSONObject.optInt(WMElement.ANIMATE_TYPE_SCALE, 16);
                    int optInt2 = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, 0);
                    int optInt3 = jSONObject.optInt("skew", 0);
                    if (Math.abs(f) > 90.0f || Math.abs(f2) > 180.0f) {
                        C4990ab.m7410d("MicroMsg.JsApiInsertXWebMap", "centerLatitude or centerLongitude value is error!");
                        c10406b = null;
                    } else {
                        String appId = c2241c.getAppId();
                        String optString = jSONObject.optString("theme", "");
                        String optString2 = jSONObject.optString("subKey", "");
                        String appId2 = c2241c.getAppId();
                        int optInt4 = jSONObject.optInt("styleId", 0);
                        JSONObject optJSONObject = jSONObject.optJSONObject("position");
                        if (optJSONObject == null) {
                            C4990ab.m7412e("MicroMsg.JsApiInsertXWebMap", "positionObj is null, err, return");
                            c10406b = null;
                        } else {
                            int a = C42668g.m75555a(optJSONObject, "width", 0);
                            int a2 = C42668g.m75555a(optJSONObject, "height", 0);
                            String g = C38303f.m64817g(c2241c, jSONObject);
                            HashMap hashMap = new HashMap(5);
                            hashMap.put("theme", optString);
                            hashMap.put("subKey", optString2);
                            hashMap.put("subId", appId2);
                            hashMap.put("styleId", Integer.valueOf(optInt4));
                            hashMap.put("surface", surfaceTexture);
                            hashMap.put("width", Integer.valueOf(a));
                            hashMap.put("height", Integer.valueOf(a2));
                            hashMap.put("mapType", Integer.valueOf(2));
                            c10406b = ((C31303c) C37384e.m62985B(C31303c.class)).mo20060a(c2241c.getContext(), g, hashMap);
                            if (c10406b == null) {
                                C4990ab.m7412e("MicroMsg.JsApiInsertXWebMap", "mapView is null, return");
                                c10406b = null;
                            } else if (C33320g.m54492a(appId, C38303f.m64817g(c2241c, jSONObject), c10406b)) {
                                c10406b.mo21914ed(jSONObject.optBoolean("enableZoom", true));
                                c10406b.mo21915ee(jSONObject.optBoolean("enableScroll", true));
                                c10406b.mo21916ef(jSONObject.optBoolean("enableRotate", false));
                                c10406b.mo21917eg(jSONObject.optBoolean("showCompass", false));
                                c10406b.mo21918eh(jSONObject.optBoolean("enable3D", false));
                                c10406b.mo21919ei(jSONObject.optBoolean("enableOverlooking", false));
                                c10406b.mo21920ej(jSONObject.optBoolean("enableSatellite", false));
                                c10406b.mo21922el(jSONObject.optBoolean("enableIndoor", true));
                                c10406b.mo21923em(jSONObject.optBoolean("enableIndoorLevelPick", false));
                                c10406b.mo21883a(f, f2, (float) optInt, (float) optInt2, (float) optInt3);
                                if (c2241c instanceof C33303e) {
                                    C33303e c33303e = (C33303e) c2241c;
                                    c33303e.mo53827a((C10379b) new C105241(c10406b));
                                    c33303e.mo53829a((C10381d) new C23472(c10406b));
                                    c33303e.mo53828a((C10380c) new C105263(c33303e, appId, c2241c, jSONObject));
                                }
                                c10406b.getView().setVisibility(0);
                                if (c10406b == null) {
                                    C4990ab.m7412e("MicroMsg.JsApiInsertXWebMap", "mapView is null, error, return");
                                    c10406b = null;
                                } else {
                                    int B = C38303f.m64811B(jSONObject);
                                    c10406b.mo21886a(new C105274(B, c2241c));
                                    c10406b.mo21888a(new C105305(B, c2241c));
                                    c10406b.mo21887a(new C105286(B, c2241c));
                                    c10406b.mo21891a(new C23487(B, c2241c));
                                    c10406b.mo21924en(jSONObject.optBoolean("showLocation"));
                                    c10406b.mo21889a(new C105258(B, c2241c));
                                    c10406b.mo21890a(new C105299(B, c2241c));
                                }
                            } else {
                                C4990ab.m7412e("MicroMsg.JsApiInsertXWebMap", "initMapView is false, return");
                                c10406b = null;
                            }
                        }
                    }
                    c45623a.idE = c10406b;
                    c2241c.mo6107M(i, c45608m.mo73394j("ok", null));
                    C33319e.m54490oq(10);
                    AppMethodBeat.m2505o(117344);
                } else if (c45608m2 instanceof C19491d) {
                    C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "Tummy update");
                    C33319e.m54490oq(12);
                    C45623a.this.mo73407b(c2241c2, jSONObject2, c45608m2, i2);
                    AppMethodBeat.m2505o(117344);
                } else {
                    if (c45608m2 instanceof C31308c) {
                        Object obj;
                        C33319e.m54490oq(15);
                        C2241c c2241c2 = c2241c2;
                        JSONObject jSONObject2 = jSONObject2;
                        C45608m c45608m2 = c45608m2;
                        optInt = i2;
                        if (jSONObject2 == null) {
                            C4990ab.m7412e("MicroMsg.JsApiRemoveXWebMap", "data is null");
                            obj = null;
                        } else {
                            C4990ab.m7417i("MicroMsg.JsApiRemoveXWebMap", "removeXWebMap:%s", jSONObject2);
                            C33320g.m54495ck(c2241c2.getAppId(), C38303f.m64817g(c2241c2, jSONObject2));
                            obj = 1;
                        }
                        if (obj != null) {
                            c2241c2.mo6107M(optInt, c45608m2.mo73394j("ok", null));
                            C33319e.m54490oq(16);
                            AppMethodBeat.m2505o(117344);
                            return;
                        }
                        C4990ab.m7412e("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "remove fail");
                        C33319e.m54490oq(17);
                        c2241c2.mo6107M(optInt, c45608m2.mo73394j("fail:internal error", null));
                    }
                    AppMethodBeat.m2505o(117344);
                }
            }
        };
        if (c2241c.aBy().getLooper() == Looper.myLooper()) {
            c194901.run();
        } else {
            c2241c.aBy().post(c194901);
        }
        AppMethodBeat.m2505o(117347);
        return null;
    }

    /* renamed from: a */
    public final boolean mo41593a(C45608m c45608m) {
        return this.hpN || (c45608m != null && (c45608m instanceof C31308c));
    }

    /* renamed from: m */
    public final void mo32981m(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(117348);
        this.idE.onTouchEvent(motionEvent);
        AppMethodBeat.m2505o(117348);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* renamed from: b */
    public final synchronized void mo73407b(C2241c c2241c, JSONObject jSONObject, C45608m c45608m, int i) {
        AppMethodBeat.m2504i(117349);
        if (C19491d.m30173h(c2241c, jSONObject)) {
            c2241c.mo6107M(i, c45608m.mo73394j("ok", null));
            C33319e.m54490oq(13);
            AppMethodBeat.m2505o(117349);
        } else {
            C4990ab.m7412e("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "update fail");
            C33319e.m54490oq(14);
            c2241c.mo6107M(i, c45608m.mo73394j("fail:internal error", null));
            AppMethodBeat.m2505o(117349);
        }
    }
}
