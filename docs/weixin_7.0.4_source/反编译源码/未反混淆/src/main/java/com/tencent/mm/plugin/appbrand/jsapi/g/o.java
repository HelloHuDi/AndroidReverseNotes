package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.k;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.l;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.n;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.p;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.q;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.s;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.t;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.u;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.model.WMElement;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class o extends com.tencent.mm.plugin.appbrand.jsapi.base.a {
    public static final int CTRL_INDEX = 2;
    public static final String NAME = "insertMap";

    public static class f extends ah {
        private static final int CTRL_INDEX = 147;
        private static final String NAME = "onMapRegionChange";
    }

    public static class e extends ah {
        private static final int CTRL_INDEX = 511;
        private static final String NAME = "onMapPoiClick";
    }

    public static class b extends ah {
        private static final int CTRL_INDEX = 151;
        private static final String NAME = "onMapClick";
    }

    public static class d extends ah {
        private static final int CTRL_INDEX = 142;
        private static final String NAME = "onMapMarkerClick";
    }

    public static class a extends ah {
        private static final int CTRL_INDEX = 199;
        private static final String NAME = "onMapCalloutClick";
    }

    public static class c extends ah {
        private static final int CTRL_INDEX = 524;
        private static final String NAME = "onMapIndoorChange";
    }

    public final View a(final com.tencent.mm.plugin.appbrand.jsapi.e eVar, final JSONObject jSONObject) {
        AppMethodBeat.i(93863);
        float f = bo.getFloat(jSONObject.optString("centerLatitude"), 0.0f);
        float f2 = bo.getFloat(jSONObject.optString("centerLongitude"), 0.0f);
        int optInt = jSONObject.optInt(WMElement.ANIMATE_TYPE_SCALE, 16);
        int optInt2 = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, 0);
        int optInt3 = jSONObject.optInt("skew", 0);
        if (Math.abs(f) > 90.0f || Math.abs(f2) > 180.0f) {
            ab.d("MicroMsg.JsApiInsertMap", "centerLatitude or centerLongitude value is error!");
            AppMethodBeat.o(93863);
            return null;
        }
        com.tencent.mm.plugin.appbrand.jsapi.g.a.e.oq(0);
        final String appId = eVar.getAppId();
        int r = r(jSONObject);
        ab.i("MicroMsg.JsApiInsertMap", "insertMap appId:%s viewId:%d data:%s", appId, Integer.valueOf(r), jSONObject);
        final com.tencent.mm.plugin.appbrand.jsapi.g.a.b a = ((com.tencent.mm.plugin.appbrand.jsapi.g.a.c) com.tencent.luggage.a.e.B(com.tencent.mm.plugin.appbrand.jsapi.g.a.c.class)).a(eVar, jSONObject);
        if (a == null) {
            ab.e("MicroMsg.JsApiInsertMap", "mapView is null, return");
            AppMethodBeat.o(93863);
            return null;
        } else if (g.a(appId, com.tencent.mm.plugin.appbrand.jsapi.g.a.f.g(eVar, jSONObject), a)) {
            com.tencent.mm.plugin.appbrand.jsapi.g.a.e.oq(2);
            a.ed(jSONObject.optBoolean("enableZoom", true));
            a.ee(jSONObject.optBoolean("enableScroll", true));
            a.ef(jSONObject.optBoolean("enableRotate", false));
            a.eg(jSONObject.optBoolean("showCompass", false));
            a.eh(jSONObject.optBoolean("enable3D", false));
            a.ei(jSONObject.optBoolean("enableOverlooking", false));
            a.ej(jSONObject.optBoolean("enableSatellite", false));
            a.el(jSONObject.optBoolean("enableIndoor", true));
            a.em(jSONObject.optBoolean("enableIndoorLevelPick", false));
            a.a(f, f2, (float) optInt, (float) optInt2, (float) optInt3);
            eVar.a((com.tencent.mm.plugin.appbrand.jsapi.f.b) new com.tencent.mm.plugin.appbrand.jsapi.f.b() {
                public final void wW() {
                    AppMethodBeat.i(93852);
                    ab.i("MicroMsg.JsApiInsertMap", "onBackground");
                    if (a != null) {
                        a.onPause();
                    }
                    AppMethodBeat.o(93852);
                }
            });
            eVar.a((com.tencent.mm.plugin.appbrand.jsapi.f.d) new com.tencent.mm.plugin.appbrand.jsapi.f.d() {
                public final void wU() {
                    AppMethodBeat.i(93853);
                    ab.i("MicroMsg.JsApiInsertMap", "onForeground");
                    if (a != null) {
                        a.onResume();
                    }
                    AppMethodBeat.o(93853);
                }
            });
            eVar.a((com.tencent.mm.plugin.appbrand.jsapi.f.c) new com.tencent.mm.plugin.appbrand.jsapi.f.c() {
                public final void onDestroy() {
                    AppMethodBeat.i(93854);
                    ab.i("MicroMsg.JsApiInsertMap", "onDestroy");
                    eVar.b((com.tencent.mm.plugin.appbrand.jsapi.f.c) this);
                    g.ck(appId, com.tencent.mm.plugin.appbrand.jsapi.g.a.f.g(eVar, jSONObject));
                    AppMethodBeat.o(93854);
                }
            });
            a.getView().setVisibility(0);
            View coverViewContainer = new CoverViewContainer(eVar.getContext(), a.getView());
            AppMethodBeat.o(93863);
            return coverViewContainer;
        } else {
            ab.e("MicroMsg.JsApiInsertMap", "initMapView is false, return");
            com.tencent.mm.plugin.appbrand.jsapi.g.a.e.oq(1);
            AppMethodBeat.o(93863);
            return null;
        }
    }

    public final int r(JSONObject jSONObject) {
        AppMethodBeat.i(93864);
        try {
            int optInt = jSONObject.optInt("mapId");
            AppMethodBeat.o(93864);
            return optInt;
        } catch (Exception e) {
            ab.e("MicroMsg.JsApiInsertMap", "get mapId error, exception : %s", e);
            AppMethodBeat.o(93864);
            return -1;
        }
    }

    public final void a(final com.tencent.mm.plugin.appbrand.jsapi.e eVar, final int i, View view, JSONObject jSONObject) {
        AppMethodBeat.i(93865);
        com.tencent.mm.plugin.appbrand.jsapi.g.a.b cj = g.cj(eVar.getAppId(), com.tencent.mm.plugin.appbrand.jsapi.g.a.f.g(eVar, jSONObject));
        if (cj == null) {
            ab.e("MicroMsg.JsApiInsertMap", "mapView is null, error, return");
            AppMethodBeat.o(93865);
            return;
        }
        cj.a(new k() {
            public final void a(q qVar) {
                AppMethodBeat.i(93855);
                a aVar = new a();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("mapId", i);
                    jSONObject.put("data", qVar.data);
                } catch (JSONException e) {
                    ab.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", e);
                }
                aVar.AM(jSONObject.toString());
                eVar.b(aVar);
                AppMethodBeat.o(93855);
            }
        });
        cj.a(new n() {
            public final boolean b(q qVar) {
                AppMethodBeat.i(93856);
                d dVar = new d();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("mapId", i);
                    jSONObject.put("data", qVar.data);
                } catch (JSONException e) {
                    ab.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", e);
                }
                dVar.AM(jSONObject.toString());
                eVar.b(dVar);
                AppMethodBeat.o(93856);
                return false;
            }
        });
        cj.a(new l() {
            public final void aDL() {
                AppMethodBeat.i(93857);
                b bVar = new b();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("mapId", i);
                } catch (JSONException e) {
                    ab.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", e);
                }
                bVar.AM(jSONObject.toString());
                eVar.b(bVar);
                AppMethodBeat.o(93857);
            }
        });
        cj.a(new u() {
            public final void a(p pVar) {
                AppMethodBeat.i(93858);
                e eVar = new e();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("mapId", i);
                    jSONObject.put("latitude", pVar.latitude);
                    jSONObject.put("longitude", pVar.longitude);
                    jSONObject.put("name", pVar.name);
                    if (!bo.isNullOrNil(pVar.buildingId)) {
                        jSONObject.put("buildingId", pVar.buildingId);
                        jSONObject.put("floorName", pVar.floorName);
                    }
                } catch (JSONException e) {
                    ab.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", e);
                }
                eVar.AM(jSONObject.toString());
                eVar.b(eVar);
                ab.v("MicroMsg.JsApiInsertMap", "OnMapPoiClick %s", jSONObject.toString());
                AppMethodBeat.o(93858);
            }
        });
        cj.en(jSONObject.optBoolean("showLocation"));
        cj.a(new s() {
            AtomicBoolean hML = new AtomicBoolean(false);
            float hMM;
            f hMN = new f();
            JSONObject jsonObject = new JSONObject();

            public final void a(com.tencent.mm.plugin.appbrand.jsapi.g.a.b.a aVar) {
                AppMethodBeat.i(93860);
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
                        ab.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", e);
                    }
                    this.hMN.AM(this.jsonObject.toString());
                    eVar.b(this.hMN);
                    this.hMM = aVar.zoom;
                    ab.v("MicroMsg.JsApiInsertMap", "onCameraChange begin");
                }
                AppMethodBeat.o(93860);
            }

            public final void a(com.tencent.mm.plugin.appbrand.jsapi.g.a.b.a aVar, boolean z) {
                AppMethodBeat.i(93861);
                if (this.hML.compareAndSet(true, false)) {
                    try {
                        this.jsonObject.remove("mapId");
                        this.jsonObject.put("mapId", i);
                        this.jsonObject.remove("type");
                        this.jsonObject.put("type", "end");
                        this.jsonObject.remove("causedBy");
                        boolean z2 = aVar.zoom != this.hMM;
                        if (!z) {
                            this.jsonObject.put("causedBy", "update");
                        } else if (z2) {
                            this.jsonObject.put("causedBy", WMElement.ANIMATE_TYPE_SCALE);
                        } else {
                            this.jsonObject.put("causedBy", "drag");
                        }
                        this.jsonObject.remove(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION);
                        this.jsonObject.put(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, (double) aVar.rotate);
                        this.jsonObject.remove("skew");
                        this.jsonObject.put("skew", (double) aVar.skew);
                    } catch (JSONException e) {
                        ab.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", e);
                    }
                    this.hMN.AM(this.jsonObject.toString());
                    eVar.b(this.hMN);
                    ab.v("MicroMsg.JsApiInsertMap", "onCameraChange finish, result:%s", this.jsonObject.toString());
                }
                AppMethodBeat.o(93861);
            }
        });
        cj.a(new t() {
            public final void a(com.tencent.mm.plugin.appbrand.jsapi.g.a.b.e eVar) {
                AppMethodBeat.i(93862);
                c cVar = new c();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("mapId", i);
                    if (eVar != null) {
                        jSONObject.put("buildingId", eVar.buildingId);
                        jSONObject.put("buildingName", eVar.buildingName);
                        if (eVar.hNP != null && eVar.hNP.size() > 0) {
                            JSONArray jSONArray = new JSONArray();
                            for (com.tencent.mm.plugin.appbrand.jsapi.g.a.b.f fVar : eVar.hNP) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("name", fVar.floorName);
                                jSONArray.put(jSONObject2);
                            }
                            jSONObject.put("floorList", jSONArray);
                        }
                        jSONObject.put("floorIndex", eVar.hNQ);
                    }
                } catch (JSONException e) {
                    ab.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", e);
                }
                cVar.AM(jSONObject.toString());
                eVar.b(cVar);
                ab.v("MicroMsg.JsApiInsertMap", "OnMapIndoorStateChange:%s", jSONObject.toString());
                AppMethodBeat.o(93862);
            }
        });
        AppMethodBeat.o(93865);
    }
}
