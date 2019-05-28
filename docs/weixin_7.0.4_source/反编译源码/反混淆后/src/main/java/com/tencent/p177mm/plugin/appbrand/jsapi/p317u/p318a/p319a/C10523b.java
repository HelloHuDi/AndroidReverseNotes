package com.tencent.p177mm.plugin.appbrand.jsapi.p317u.p318a.p319a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10379b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10380c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10381d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C26985o.C19397f;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C26985o.C26984e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C26985o.C26989b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C26985o.C26990d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C26985o.C26993a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C26985o.C26994c;
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

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.a.a.b */
public final class C10523b extends C27108a {
    private static final int CTRL_INDEX = -2;
    public static final String NAME = "insertXWebMap";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.a.a.b$2 */
    public class C23472 implements C10381d {
        final /* synthetic */ C10406b hMI;

        public C23472(C10406b c10406b) {
            this.hMI = c10406b;
        }

        /* renamed from: wU */
        public final void mo6095wU() {
            AppMethodBeat.m2504i(117354);
            C4990ab.m7416i("MicroMsg.JsApiInsertXWebMap", "onForeground");
            if (this.hMI != null) {
                this.hMI.onResume();
            }
            AppMethodBeat.m2505o(117354);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.a.a.b$7 */
    public class C23487 implements C10404u {
        final /* synthetic */ int hMD;
        final /* synthetic */ C2241c hyd;

        public C23487(int i, C2241c c2241c) {
            this.hMD = i;
            this.hyd = c2241c;
        }

        /* renamed from: a */
        public final void mo6230a(C10415p c10415p) {
            AppMethodBeat.m2504i(117359);
            C26984e c26984e = new C26984e();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mapId", this.hMD);
                jSONObject.put("latitude", c10415p.latitude);
                jSONObject.put("longitude", c10415p.longitude);
                jSONObject.put("name", c10415p.name);
                if (!C5046bo.isNullOrNil(c10415p.buildingId)) {
                    jSONObject.put("buildingId", c10415p.buildingId);
                    jSONObject.put("floorName", c10415p.floorName);
                }
            } catch (JSONException e) {
                C4990ab.m7413e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", e);
            }
            c26984e.mo61028AM(jSONObject.toString());
            this.hyd.mo6115b(c26984e);
            C4990ab.m7419v("MicroMsg.JsApiInsertXWebMap", "OnMapPoiClick %s", jSONObject.toString());
            AppMethodBeat.m2505o(117359);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.a.a.b$1 */
    public class C105241 implements C10379b {
        final /* synthetic */ C10406b hMI;

        public C105241(C10406b c10406b) {
            this.hMI = c10406b;
        }

        /* renamed from: wW */
        public final void mo21857wW() {
            AppMethodBeat.m2504i(117353);
            C4990ab.m7416i("MicroMsg.JsApiInsertXWebMap", "onBackground");
            if (this.hMI != null) {
                this.hMI.onPause();
            }
            AppMethodBeat.m2505o(117353);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.a.a.b$8 */
    public class C105258 implements C10419s {
        final /* synthetic */ int hMD;
        AtomicBoolean hML = new AtomicBoolean(false);
        float hMM;
        C19397f hMN = new C19397f();
        final /* synthetic */ C2241c hyd;
        JSONObject jsonObject = new JSONObject();

        public C105258(int i, C2241c c2241c) {
            this.hMD = i;
            this.hyd = c2241c;
            AppMethodBeat.m2504i(117360);
            AppMethodBeat.m2505o(117360);
        }

        /* renamed from: a */
        public final void mo21936a(C10416a c10416a) {
            AppMethodBeat.m2504i(117361);
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
                    C4990ab.m7413e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", e);
                }
                this.hMN.mo61028AM(this.jsonObject.toString());
                this.hyd.mo6115b(this.hMN);
                this.hMM = c10416a.zoom;
                C4990ab.m7418v("MicroMsg.JsApiInsertXWebMap", "onCameraChange begin");
            }
            AppMethodBeat.m2505o(117361);
        }

        /* renamed from: a */
        public final void mo21937a(C10416a c10416a, boolean z) {
            AppMethodBeat.m2504i(117362);
            if (this.hML.compareAndSet(true, false)) {
                try {
                    this.jsonObject.remove("mapId");
                    this.jsonObject.put("mapId", this.hMD);
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
                    C4990ab.m7413e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", e);
                }
                this.hMN.mo61028AM(this.jsonObject.toString());
                this.hyd.mo6115b(this.hMN);
                C4990ab.m7419v("MicroMsg.JsApiInsertXWebMap", "onCameraChange finish, result:%s", this.jsonObject.toString());
            }
            AppMethodBeat.m2505o(117362);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.a.a.b$3 */
    public class C105263 implements C10380c {
        final /* synthetic */ C33303e hCQ;
        final /* synthetic */ JSONObject hsm;
        final /* synthetic */ C2241c hyd;
        final /* synthetic */ String val$appId;

        public C105263(C33303e c33303e, String str, C2241c c2241c, JSONObject jSONObject) {
            this.hCQ = c33303e;
            this.val$appId = str;
            this.hyd = c2241c;
            this.hsm = jSONObject;
        }

        public final void onDestroy() {
            AppMethodBeat.m2504i(117355);
            C4990ab.m7416i("MicroMsg.JsApiInsertXWebMap", "onDestroy");
            this.hCQ.mo53833b((C10380c) this);
            C33320g.m54495ck(this.val$appId, C38303f.m64817g(this.hyd, this.hsm));
            AppMethodBeat.m2505o(117355);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.a.a.b$4 */
    public class C105274 implements C10425k {
        final /* synthetic */ int hMD;
        final /* synthetic */ C2241c hyd;

        public C105274(int i, C2241c c2241c) {
            this.hMD = i;
            this.hyd = c2241c;
        }

        /* renamed from: a */
        public final void mo21939a(C10418q c10418q) {
            AppMethodBeat.m2504i(117356);
            C26993a c26993a = new C26993a();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mapId", this.hMD);
                jSONObject.put("data", c10418q.data);
            } catch (JSONException e) {
                C4990ab.m7413e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", e);
            }
            c26993a.mo61028AM(jSONObject.toString());
            this.hyd.mo6115b(c26993a);
            AppMethodBeat.m2505o(117356);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.a.a.b$6 */
    public class C105286 implements C10426l {
        final /* synthetic */ int hMD;
        final /* synthetic */ C2241c hyd;

        public C105286(int i, C2241c c2241c) {
            this.hMD = i;
            this.hyd = c2241c;
        }

        public final void aDL() {
            AppMethodBeat.m2504i(117358);
            C26989b c26989b = new C26989b();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mapId", this.hMD);
            } catch (JSONException e) {
                C4990ab.m7413e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", e);
            }
            c26989b.mo61028AM(jSONObject.toString());
            this.hyd.mo6115b(c26989b);
            AppMethodBeat.m2505o(117358);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.a.a.b$9 */
    public class C105299 implements C10420t {
        final /* synthetic */ int hMD;
        final /* synthetic */ C2241c hyd;

        public C105299(int i, C2241c c2241c) {
            this.hMD = i;
            this.hyd = c2241c;
        }

        /* renamed from: a */
        public final void mo21938a(C10407e c10407e) {
            AppMethodBeat.m2504i(117363);
            C26994c c26994c = new C26994c();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mapId", this.hMD);
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
                C4990ab.m7413e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", e);
            }
            c26994c.mo61028AM(jSONObject.toString());
            this.hyd.mo6115b(c26994c);
            this.hyd.mo6108a(c26994c);
            C4990ab.m7419v("MicroMsg.JsApiInsertXWebMap", "OnMapIndoorStateChange:%s", jSONObject.toString());
            AppMethodBeat.m2505o(117363);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.a.a.b$5 */
    public class C105305 implements C10413n {
        final /* synthetic */ int hMD;
        final /* synthetic */ C2241c hyd;

        public C105305(int i, C2241c c2241c) {
            this.hMD = i;
            this.hyd = c2241c;
        }

        /* renamed from: b */
        public final boolean mo6163b(C10418q c10418q) {
            AppMethodBeat.m2504i(117357);
            C26990d c26990d = new C26990d();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mapId", this.hMD);
                jSONObject.put("data", c10418q.data);
            } catch (JSONException e) {
                C4990ab.m7413e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", e);
            }
            c26990d.mo61028AM(jSONObject.toString());
            this.hyd.mo6115b(c26990d);
            AppMethodBeat.m2505o(117357);
            return false;
        }
    }
}
