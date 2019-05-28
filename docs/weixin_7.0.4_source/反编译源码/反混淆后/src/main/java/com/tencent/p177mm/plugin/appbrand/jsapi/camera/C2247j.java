package com.tencent.p177mm.plugin.appbrand.jsapi.camera;

import android.app.Activity;
import android.content.Context;
import android.support.p057v4.app.C6184a.C0315a;
import android.view.View;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.luggage.p147g.C0991g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33186c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10379b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10380c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10381d;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C26932g;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C45577a;
import com.tencent.p177mm.plugin.appbrand.jsapi.camera.C10360a.C10361a;
import com.tencent.p177mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.plugin.appbrand.permission.C19663n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.view.C31128d;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.camera.j */
public final class C2247j extends C45577a {
    private static final int CTRL_INDEX = 329;
    public static final String NAME = "insertCamera";
    static C2251a hHa;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.camera.j$2 */
    class C22492 implements C26953b {
        C22492() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.camera.j$a */
    public interface C2251a {
        /* renamed from: cI */
        C33272e mo6131cI(Context context);
    }

    /* renamed from: a */
    public final View mo6126a(C33303e c33303e, JSONObject jSONObject) {
        CharSequence string;
        AppMethodBeat.m2504i(126243);
        Context context = c33303e.getContext();
        C33272e cI = hHa.mo6131cI(context);
        int optInt = jSONObject.optInt("cameraId");
        String optString = jSONObject.optString("mode", "normal");
        String optString2 = jSONObject.optString("devicePosition", "back");
        String optString3 = jSONObject.optString("flash", "auto");
        String optString4 = jSONObject.optString("size");
        int i = 720;
        Object obj = -1;
        switch (optString4.hashCode()) {
            case -1078030475:
                if (optString4.equals(C8741b.MEDIUM)) {
                    obj = 1;
                    break;
                }
                break;
            case 102742843:
                if (optString4.equals("large")) {
                    obj = 2;
                    break;
                }
                break;
            case 109548807:
                if (optString4.equals("small")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                i = C31128d.MIC_PTU_YOUJIALI;
                break;
            case 1:
                i = 480;
                break;
            case 2:
                i = 720;
                break;
        }
        boolean optBoolean = jSONObject.optBoolean("needOutput", false);
        cI.setAppId(c33303e.getAppId());
        cI.setPage(c33303e);
        cI.setCameraId(optInt);
        cI.setMode(optString);
        cI.mo30612ai(optString2, true);
        cI.setFlash(optString3);
        cI.setFrameLimitSize(i);
        cI.setNeedOutput(optBoolean);
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        int a = C42668g.m75555a(optJSONObject, "width", 0);
        i = C42668g.m75555a(optJSONObject, "height", 0);
        if (!(a == 0 || i == 0)) {
            cI.mo30613da(a, i);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("scanArea");
        if (optJSONArray == null || optJSONArray.length() != 4) {
            cI.mo30630w(0, 0, a, i);
        } else {
            C4990ab.m7417i("MicroMsg.JsApiInsertCamera", "scanAreaArray:%s, scanAreaArray.length:%d", optJSONArray, Integer.valueOf(optJSONArray.length()));
            cI.mo30630w(C42668g.m75571qb(optJSONArray.optInt(0)), C42668g.m75571qb(optJSONArray.optInt(1)), C42668g.m75571qb(optJSONArray.optInt(2)), C42668g.m75571qb(optJSONArray.optInt(3)));
        }
        cI.setScanFreq(jSONObject.optInt("scanFreq"));
        C4990ab.m7411d("MicroMsg.JsApiInsertCamera", "inflateView cameraId: %d,devicePosition: %s,flash: %s,width: %d,height: %d", Integer.valueOf(optInt), optString2, optString3, Integer.valueOf(a), Integer.valueOf(i));
        View view = cI.getView();
        if ("normal".equals(optString)) {
            string = context.getString(C25738R.string.f8825g3);
        } else {
            string = context.getString(C25738R.string.f8826g4);
        }
        view.setContentDescription(string);
        CoverViewContainer coverViewContainer = new CoverViewContainer(context, (View) cI);
        AppMethodBeat.m2505o(126243);
        return coverViewContainer;
    }

    /* renamed from: r */
    public final int mo6130r(JSONObject jSONObject) {
        AppMethodBeat.m2504i(126244);
        int optInt = jSONObject.optInt("cameraId");
        AppMethodBeat.m2505o(126244);
        return optInt;
    }

    public final boolean aCE() {
        return true;
    }

    /* renamed from: a */
    public final void mo6127a(final C33303e c33303e, final int i, View view, JSONObject jSONObject, C26932g c26932g) {
        AppMethodBeat.m2504i(138256);
        C4990ab.m7417i("MicroMsg.JsApiInsertCamera", "onInsertView cameraId=%d", Integer.valueOf(i));
        c26932g.mo44674AR(mo73394j("ok", null));
        final C33272e c33272e = (C33272e) ((CoverViewContainer) view).mo60996ah(View.class);
        if (c33272e == null) {
            C4990ab.m7421w("MicroMsg.JsApiInsertCamera", "onInsertView(viewId : %d) failed, cameraView is null", Integer.valueOf(i));
            AppMethodBeat.m2505o(138256);
            return;
        }
        mo6128a((C2241c) c33303e, c33272e);
        C10360a aDb = C10361a.hGl;
        aDb.hGk.put(Integer.valueOf(c33272e.getCameraId()), c33272e);
        c33303e.mo53829a((C10381d) c33272e);
        c33303e.mo53827a((C10379b) c33272e);
        c33303e.mo53828a((C10380c) c33272e);
        C33183g.m54274a(c33303e.getAppId(), new C33186c() {
            public final void onDestroy() {
                AppMethodBeat.m2504i(126241);
                c33303e.mo53834b((C10381d) c33272e);
                c33303e.mo53832b((C10379b) c33272e);
                c33303e.mo53833b((C10380c) c33272e);
                C10360a aDb = C10361a.hGl;
                Integer valueOf = Integer.valueOf(i);
                if (aDb.hGk.containsKey(valueOf)) {
                    ((C33272e) aDb.hGk.remove(valueOf)).release();
                }
                C33183g.m54276b(c33303e.getAppId(), this);
                AppMethodBeat.m2505o(126241);
            }
        });
        c33272e.setOutPutCallBack(new C22492());
        AppMethodBeat.m2505o(138256);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final boolean mo6128a(final C2241c c2241c, final C33272e c33272e) {
        AppMethodBeat.m2504i(126246);
        C19663n.m30463b(String.valueOf(c2241c.getAppId()), new C0315a() {
            public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                AppMethodBeat.m2504i(126242);
                HashMap hashMap;
                if (i != 16) {
                    if (i == 18) {
                        if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                            hashMap = new HashMap();
                            hashMap.put("cameraId", Integer.valueOf(c33272e.getCameraId()));
                            new C33275g().mo61032j(c2241c).mo61028AM(new JSONObject(hashMap).toString()).aCj();
                            C10361a.hGl.hGj = false;
                        } else {
                            C10361a.hGl.hGj = true;
                            C2247j.this.mo6128a(c2241c, c33272e);
                            AppMethodBeat.m2505o(126242);
                            return;
                        }
                    }
                    AppMethodBeat.m2505o(126242);
                } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                    hashMap = new HashMap();
                    hashMap.put("cameraId", Integer.valueOf(c33272e.getCameraId()));
                    new C33275g().mo61032j(c2241c).mo61028AM(new JSONObject(hashMap).toString()).aCj();
                    C10361a.hGl.hGi = false;
                    AppMethodBeat.m2505o(126242);
                } else {
                    C10361a.hGl.hGi = true;
                    C2247j.this.mo6128a(c2241c, c33272e);
                    AppMethodBeat.m2505o(126242);
                }
            }
        });
        Activity activity = (Activity) c2241c.getContext();
        if (activity == null) {
            AppMethodBeat.m2505o(126246);
            return false;
        }
        boolean a = C0991g.m2252a(activity, "android.permission.CAMERA", 16, "", "");
        C10361a.hGl.hGi = a;
        if (a) {
            boolean a2 = C0991g.m2252a(activity, "android.permission.RECORD_AUDIO", 18, "", "");
            C10361a.hGl.hGj = a2;
            if (a2) {
                C19663n.m30460Dr(c2241c.getAppId());
                c33272e.initView();
                AppMethodBeat.m2505o(126246);
                return true;
            }
            AppMethodBeat.m2505o(126246);
            return false;
        }
        AppMethodBeat.m2505o(126246);
        return false;
    }
}
