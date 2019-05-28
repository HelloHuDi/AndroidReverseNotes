package com.tencent.p177mm.plugin.appbrand.jsapi.p306g;

import android.view.View;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10379b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10380c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10381d;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C45577a;
import com.tencent.p177mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10404u;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10407e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10408f;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10413n;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10415p;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10416a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10418q;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10419s;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10420t;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10425k;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10426l;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C31303c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C33319e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C33320g;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C38303f;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.model.WMElement;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.o */
public final class C26985o extends C45577a {
    public static final int CTRL_INDEX = 2;
    public static final String NAME = "insertMap";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.o$f */
    public static class C19397f extends C42467ah {
        private static final int CTRL_INDEX = 147;
        private static final String NAME = "onMapRegionChange";
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.o$e */
    public static class C26984e extends C42467ah {
        private static final int CTRL_INDEX = 511;
        private static final String NAME = "onMapPoiClick";
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.o$b */
    public static class C26989b extends C42467ah {
        private static final int CTRL_INDEX = 151;
        private static final String NAME = "onMapClick";
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.o$d */
    public static class C26990d extends C42467ah {
        private static final int CTRL_INDEX = 142;
        private static final String NAME = "onMapMarkerClick";
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.o$a */
    public static class C26993a extends C42467ah {
        private static final int CTRL_INDEX = 199;
        private static final String NAME = "onMapCalloutClick";
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.o$c */
    public static class C26994c extends C42467ah {
        private static final int CTRL_INDEX = 524;
        private static final String NAME = "onMapIndoorChange";
    }

    /* renamed from: a */
    public final View mo6126a(final C33303e c33303e, final JSONObject jSONObject) {
        AppMethodBeat.m2504i(93863);
        float f = C5046bo.getFloat(jSONObject.optString("centerLatitude"), 0.0f);
        float f2 = C5046bo.getFloat(jSONObject.optString("centerLongitude"), 0.0f);
        int optInt = jSONObject.optInt(WMElement.ANIMATE_TYPE_SCALE, 16);
        int optInt2 = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, 0);
        int optInt3 = jSONObject.optInt("skew", 0);
        if (Math.abs(f) > 90.0f || Math.abs(f2) > 180.0f) {
            C4990ab.m7410d("MicroMsg.JsApiInsertMap", "centerLatitude or centerLongitude value is error!");
            AppMethodBeat.m2505o(93863);
            return null;
        }
        C33319e.m54490oq(0);
        final String appId = c33303e.getAppId();
        int r = mo6130r(jSONObject);
        C4990ab.m7417i("MicroMsg.JsApiInsertMap", "insertMap appId:%s viewId:%d data:%s", appId, Integer.valueOf(r), jSONObject);
        final C10406b a = ((C31303c) C37384e.m62985B(C31303c.class)).mo20061a(c33303e, jSONObject);
        if (a == null) {
            C4990ab.m7412e("MicroMsg.JsApiInsertMap", "mapView is null, return");
            AppMethodBeat.m2505o(93863);
            return null;
        } else if (C33320g.m54492a(appId, C38303f.m64817g(c33303e, jSONObject), a)) {
            C33319e.m54490oq(2);
            a.mo21914ed(jSONObject.optBoolean("enableZoom", true));
            a.mo21915ee(jSONObject.optBoolean("enableScroll", true));
            a.mo21916ef(jSONObject.optBoolean("enableRotate", false));
            a.mo21917eg(jSONObject.optBoolean("showCompass", false));
            a.mo21918eh(jSONObject.optBoolean("enable3D", false));
            a.mo21919ei(jSONObject.optBoolean("enableOverlooking", false));
            a.mo21920ej(jSONObject.optBoolean("enableSatellite", false));
            a.mo21922el(jSONObject.optBoolean("enableIndoor", true));
            a.mo21923em(jSONObject.optBoolean("enableIndoorLevelPick", false));
            a.mo21883a(f, f2, (float) optInt, (float) optInt2, (float) optInt3);
            c33303e.mo53827a((C10379b) new C10379b() {
                /* renamed from: wW */
                public final void mo21857wW() {
                    AppMethodBeat.m2504i(93852);
                    C4990ab.m7416i("MicroMsg.JsApiInsertMap", "onBackground");
                    if (a != null) {
                        a.onPause();
                    }
                    AppMethodBeat.m2505o(93852);
                }
            });
            c33303e.mo53829a((C10381d) new C10381d() {
                /* renamed from: wU */
                public final void mo6095wU() {
                    AppMethodBeat.m2504i(93853);
                    C4990ab.m7416i("MicroMsg.JsApiInsertMap", "onForeground");
                    if (a != null) {
                        a.onResume();
                    }
                    AppMethodBeat.m2505o(93853);
                }
            });
            c33303e.mo53828a((C10380c) new C10380c() {
                public final void onDestroy() {
                    AppMethodBeat.m2504i(93854);
                    C4990ab.m7416i("MicroMsg.JsApiInsertMap", "onDestroy");
                    c33303e.mo53833b((C10380c) this);
                    C33320g.m54495ck(appId, C38303f.m64817g(c33303e, jSONObject));
                    AppMethodBeat.m2505o(93854);
                }
            });
            a.getView().setVisibility(0);
            View coverViewContainer = new CoverViewContainer(c33303e.getContext(), a.getView());
            AppMethodBeat.m2505o(93863);
            return coverViewContainer;
        } else {
            C4990ab.m7412e("MicroMsg.JsApiInsertMap", "initMapView is false, return");
            C33319e.m54490oq(1);
            AppMethodBeat.m2505o(93863);
            return null;
        }
    }

    /* renamed from: r */
    public final int mo6130r(JSONObject jSONObject) {
        AppMethodBeat.m2504i(93864);
        try {
            int optInt = jSONObject.optInt("mapId");
            AppMethodBeat.m2505o(93864);
            return optInt;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.JsApiInsertMap", "get mapId error, exception : %s", e);
            AppMethodBeat.m2505o(93864);
            return -1;
        }
    }

    /* renamed from: a */
    public final void mo6140a(final C33303e c33303e, final int i, View view, JSONObject jSONObject) {
        AppMethodBeat.m2504i(93865);
        C10406b cj = C33320g.m54494cj(c33303e.getAppId(), C38303f.m64817g(c33303e, jSONObject));
        if (cj == null) {
            C4990ab.m7412e("MicroMsg.JsApiInsertMap", "mapView is null, error, return");
            AppMethodBeat.m2505o(93865);
            return;
        }
        cj.mo21886a(new C10425k() {
            /* renamed from: a */
            public final void mo21939a(C10418q c10418q) {
                AppMethodBeat.m2504i(93855);
                C26993a c26993a = new C26993a();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("mapId", i);
                    jSONObject.put("data", c10418q.data);
                } catch (JSONException e) {
                    C4990ab.m7413e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", e);
                }
                c26993a.mo61028AM(jSONObject.toString());
                c33303e.mo6115b(c26993a);
                AppMethodBeat.m2505o(93855);
            }
        });
        cj.mo21888a(new C10413n() {
            /* renamed from: b */
            public final boolean mo6163b(C10418q c10418q) {
                AppMethodBeat.m2504i(93856);
                C26990d c26990d = new C26990d();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("mapId", i);
                    jSONObject.put("data", c10418q.data);
                } catch (JSONException e) {
                    C4990ab.m7413e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", e);
                }
                c26990d.mo61028AM(jSONObject.toString());
                c33303e.mo6115b(c26990d);
                AppMethodBeat.m2505o(93856);
                return false;
            }
        });
        cj.mo21887a(new C10426l() {
            public final void aDL() {
                AppMethodBeat.m2504i(93857);
                C26989b c26989b = new C26989b();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("mapId", i);
                } catch (JSONException e) {
                    C4990ab.m7413e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", e);
                }
                c26989b.mo61028AM(jSONObject.toString());
                c33303e.mo6115b(c26989b);
                AppMethodBeat.m2505o(93857);
            }
        });
        cj.mo21891a(new C10404u() {
            /* renamed from: a */
            public final void mo6230a(C10415p c10415p) {
                AppMethodBeat.m2504i(93858);
                C26984e c26984e = new C26984e();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("mapId", i);
                    jSONObject.put("latitude", c10415p.latitude);
                    jSONObject.put("longitude", c10415p.longitude);
                    jSONObject.put("name", c10415p.name);
                    if (!C5046bo.isNullOrNil(c10415p.buildingId)) {
                        jSONObject.put("buildingId", c10415p.buildingId);
                        jSONObject.put("floorName", c10415p.floorName);
                    }
                } catch (JSONException e) {
                    C4990ab.m7413e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", e);
                }
                c26984e.mo61028AM(jSONObject.toString());
                c33303e.mo6115b(c26984e);
                C4990ab.m7419v("MicroMsg.JsApiInsertMap", "OnMapPoiClick %s", jSONObject.toString());
                AppMethodBeat.m2505o(93858);
            }
        });
        cj.mo21924en(jSONObject.optBoolean("showLocation"));
        cj.mo21889a(new C10419s() {
            AtomicBoolean hML = new AtomicBoolean(false);
            float hMM;
            C19397f hMN = new C19397f();
            JSONObject jsonObject = new JSONObject();

            /* renamed from: a */
            public final void mo21936a(C10416a c10416a) {
                AppMethodBeat.m2504i(93860);
                if (this.hML.compareAndSet(false, true)) {
                    try {
                        this.jsonObject.remove("mapId");
                        this.jsonObject.put("mapId", i);
                        this.jsonObject.remove("type");
                        this.jsonObject.put("type", "begin");
                        this.jsonObject.remove("causedBy");
                        this.jsonObject.remove(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION);
                        this.jsonObject.remove("skew");
                    } catch (JSONException e) {
                        C4990ab.m7413e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", e);
                    }
                    this.hMN.mo61028AM(this.jsonObject.toString());
                    c33303e.mo6115b(this.hMN);
                    this.hMM = c10416a.zoom;
                    C4990ab.m7418v("MicroMsg.JsApiInsertMap", "onCameraChange begin");
                }
                AppMethodBeat.m2505o(93860);
            }

            /* renamed from: a */
            public final void mo21937a(C10416a c10416a, boolean z) {
                AppMethodBeat.m2504i(93861);
                if (this.hML.compareAndSet(true, false)) {
                    try {
                        this.jsonObject.remove("mapId");
                        this.jsonObject.put("mapId", i);
                        this.jsonObject.remove("type");
                        this.jsonObject.put("type", "end");
                        this.jsonObject.remove("causedBy");
                        boolean z2 = c10416a.zoom != this.hMM;
                        if (!z) {
                            this.jsonObject.put("causedBy", "update");
                        } else if (z2) {
                            this.jsonObject.put("causedBy", WMElement.ANIMATE_TYPE_SCALE);
                        } else {
                            this.jsonObject.put("causedBy", "drag");
                        }
                        this.jsonObject.remove(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION);
                        this.jsonObject.put(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, (double) c10416a.rotate);
                        this.jsonObject.remove("skew");
                        this.jsonObject.put("skew", (double) c10416a.skew);
                    } catch (JSONException e) {
                        C4990ab.m7413e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", e);
                    }
                    this.hMN.mo61028AM(this.jsonObject.toString());
                    c33303e.mo6115b(this.hMN);
                    C4990ab.m7419v("MicroMsg.JsApiInsertMap", "onCameraChange finish, result:%s", this.jsonObject.toString());
                }
                AppMethodBeat.m2505o(93861);
            }
        });
        cj.mo21890a(new C10420t() {
            /* renamed from: a */
            public final void mo21938a(C10407e c10407e) {
                AppMethodBeat.m2504i(93862);
                C26994c c26994c = new C26994c();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("mapId", i);
                    if (c10407e != null) {
                        jSONObject.put("buildingId", c10407e.buildingId);
                        jSONObject.put("buildingName", c10407e.buildingName);
                        if (c10407e.hNP != null && c10407e.hNP.size() > 0) {
                            JSONArray jSONArray = new JSONArray();
                            for (C10408f c10408f : c10407e.hNP) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("name", c10408f.floorName);
                                jSONArray.put(jSONObject2);
                            }
                            jSONObject.put("floorList", jSONArray);
                        }
                        jSONObject.put("floorIndex", c10407e.hNQ);
                    }
                } catch (JSONException e) {
                    C4990ab.m7413e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", e);
                }
                c26994c.mo61028AM(jSONObject.toString());
                c33303e.mo6115b(c26994c);
                C4990ab.m7419v("MicroMsg.JsApiInsertMap", "OnMapIndoorStateChange:%s", jSONObject.toString());
                AppMethodBeat.m2505o(93862);
            }
        });
        AppMethodBeat.m2505o(93865);
    }
}
