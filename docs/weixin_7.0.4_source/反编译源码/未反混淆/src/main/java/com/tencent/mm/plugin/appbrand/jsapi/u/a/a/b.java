package com.tencent.mm.plugin.appbrand.jsapi.u.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.k;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.l;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.n;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.p;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.q;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.s;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.t;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.u;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.g.o;
import com.tencent.mm.plugin.appbrand.jsapi.g.o.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.o.f;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.model.WMElement;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends a {
    private static final int CTRL_INDEX = -2;
    public static final String NAME = "insertXWebMap";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.a.a.b$2 */
    public class AnonymousClass2 implements d {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.g.a.b hMI;

        public AnonymousClass2(com.tencent.mm.plugin.appbrand.jsapi.g.a.b bVar) {
            this.hMI = bVar;
        }

        public final void wU() {
            AppMethodBeat.i(117354);
            ab.i("MicroMsg.JsApiInsertXWebMap", "onForeground");
            if (this.hMI != null) {
                this.hMI.onResume();
            }
            AppMethodBeat.o(117354);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.a.a.b$7 */
    public class AnonymousClass7 implements u {
        final /* synthetic */ int hMD;
        final /* synthetic */ c hyd;

        public AnonymousClass7(int i, c cVar) {
            this.hMD = i;
            this.hyd = cVar;
        }

        public final void a(p pVar) {
            AppMethodBeat.i(117359);
            e eVar = new e();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mapId", this.hMD);
                jSONObject.put("latitude", pVar.latitude);
                jSONObject.put("longitude", pVar.longitude);
                jSONObject.put("name", pVar.name);
                if (!bo.isNullOrNil(pVar.buildingId)) {
                    jSONObject.put("buildingId", pVar.buildingId);
                    jSONObject.put("floorName", pVar.floorName);
                }
            } catch (JSONException e) {
                ab.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", e);
            }
            eVar.AM(jSONObject.toString());
            this.hyd.b(eVar);
            ab.v("MicroMsg.JsApiInsertXWebMap", "OnMapPoiClick %s", jSONObject.toString());
            AppMethodBeat.o(117359);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.a.a.b$1 */
    public class AnonymousClass1 implements com.tencent.mm.plugin.appbrand.jsapi.f.b {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.g.a.b hMI;

        public AnonymousClass1(com.tencent.mm.plugin.appbrand.jsapi.g.a.b bVar) {
            this.hMI = bVar;
        }

        public final void wW() {
            AppMethodBeat.i(117353);
            ab.i("MicroMsg.JsApiInsertXWebMap", "onBackground");
            if (this.hMI != null) {
                this.hMI.onPause();
            }
            AppMethodBeat.o(117353);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.a.a.b$8 */
    public class AnonymousClass8 implements s {
        final /* synthetic */ int hMD;
        AtomicBoolean hML = new AtomicBoolean(false);
        float hMM;
        f hMN = new f();
        final /* synthetic */ c hyd;
        JSONObject jsonObject = new JSONObject();

        public AnonymousClass8(int i, c cVar) {
            this.hMD = i;
            this.hyd = cVar;
            AppMethodBeat.i(117360);
            AppMethodBeat.o(117360);
        }

        public final void a(a aVar) {
            AppMethodBeat.i(117361);
            if (this.hML.compareAndSet(false, true)) {
                try {
                    this.jsonObject.remove("mapId");
                    this.jsonObject.put("mapId", this.hMD);
                    this.jsonObject.remove("type");
                    this.jsonObject.put("type", "begin");
                    this.jsonObject.remove("causedBy");
                    this.jsonObject.remove(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION);
                    this.jsonObject.remove("skew");
                } catch (JSONException e) {
                    ab.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", e);
                }
                this.hMN.AM(this.jsonObject.toString());
                this.hyd.b(this.hMN);
                this.hMM = aVar.zoom;
                ab.v("MicroMsg.JsApiInsertXWebMap", "onCameraChange begin");
            }
            AppMethodBeat.o(117361);
        }

        public final void a(a aVar, boolean z) {
            AppMethodBeat.i(117362);
            if (this.hML.compareAndSet(true, false)) {
                try {
                    this.jsonObject.remove("mapId");
                    this.jsonObject.put("mapId", this.hMD);
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
                    ab.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", e);
                }
                this.hMN.AM(this.jsonObject.toString());
                this.hyd.b(this.hMN);
                ab.v("MicroMsg.JsApiInsertXWebMap", "onCameraChange finish, result:%s", this.jsonObject.toString());
            }
            AppMethodBeat.o(117362);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.a.a.b$3 */
    public class AnonymousClass3 implements com.tencent.mm.plugin.appbrand.jsapi.f.c {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.e hCQ;
        final /* synthetic */ JSONObject hsm;
        final /* synthetic */ c hyd;
        final /* synthetic */ String val$appId;

        public AnonymousClass3(com.tencent.mm.plugin.appbrand.jsapi.e eVar, String str, c cVar, JSONObject jSONObject) {
            this.hCQ = eVar;
            this.val$appId = str;
            this.hyd = cVar;
            this.hsm = jSONObject;
        }

        public final void onDestroy() {
            AppMethodBeat.i(117355);
            ab.i("MicroMsg.JsApiInsertXWebMap", "onDestroy");
            this.hCQ.b((com.tencent.mm.plugin.appbrand.jsapi.f.c) this);
            g.ck(this.val$appId, com.tencent.mm.plugin.appbrand.jsapi.g.a.f.g(this.hyd, this.hsm));
            AppMethodBeat.o(117355);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.a.a.b$4 */
    public class AnonymousClass4 implements k {
        final /* synthetic */ int hMD;
        final /* synthetic */ c hyd;

        public AnonymousClass4(int i, c cVar) {
            this.hMD = i;
            this.hyd = cVar;
        }

        public final void a(q qVar) {
            AppMethodBeat.i(117356);
            o.a aVar = new o.a();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mapId", this.hMD);
                jSONObject.put("data", qVar.data);
            } catch (JSONException e) {
                ab.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", e);
            }
            aVar.AM(jSONObject.toString());
            this.hyd.b(aVar);
            AppMethodBeat.o(117356);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.a.a.b$6 */
    public class AnonymousClass6 implements l {
        final /* synthetic */ int hMD;
        final /* synthetic */ c hyd;

        public AnonymousClass6(int i, c cVar) {
            this.hMD = i;
            this.hyd = cVar;
        }

        public final void aDL() {
            AppMethodBeat.i(117358);
            com.tencent.mm.plugin.appbrand.jsapi.g.o.b bVar = new com.tencent.mm.plugin.appbrand.jsapi.g.o.b();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mapId", this.hMD);
            } catch (JSONException e) {
                ab.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", e);
            }
            bVar.AM(jSONObject.toString());
            this.hyd.b(bVar);
            AppMethodBeat.o(117358);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.a.a.b$9 */
    public class AnonymousClass9 implements t {
        final /* synthetic */ int hMD;
        final /* synthetic */ c hyd;

        public AnonymousClass9(int i, c cVar) {
            this.hMD = i;
            this.hyd = cVar;
        }

        public final void a(com.tencent.mm.plugin.appbrand.jsapi.g.a.b.e eVar) {
            AppMethodBeat.i(117363);
            o.c cVar = new o.c();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mapId", this.hMD);
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
                ab.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", e);
            }
            cVar.AM(jSONObject.toString());
            this.hyd.b(cVar);
            this.hyd.a(cVar);
            ab.v("MicroMsg.JsApiInsertXWebMap", "OnMapIndoorStateChange:%s", jSONObject.toString());
            AppMethodBeat.o(117363);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.a.a.b$5 */
    public class AnonymousClass5 implements n {
        final /* synthetic */ int hMD;
        final /* synthetic */ c hyd;

        public AnonymousClass5(int i, c cVar) {
            this.hMD = i;
            this.hyd = cVar;
        }

        public final boolean b(q qVar) {
            AppMethodBeat.i(117357);
            o.d dVar = new o.d();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mapId", this.hMD);
                jSONObject.put("data", qVar.data);
            } catch (JSONException e) {
                ab.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", e);
            }
            dVar.AM(jSONObject.toString());
            this.hyd.b(dVar);
            AppMethodBeat.o(117357);
            return false;
        }
    }
}
