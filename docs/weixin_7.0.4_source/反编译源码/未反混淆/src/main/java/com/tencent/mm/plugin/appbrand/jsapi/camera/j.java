package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.permission.n;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.view.d;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j extends com.tencent.mm.plugin.appbrand.jsapi.base.a {
    private static final int CTRL_INDEX = 329;
    public static final String NAME = "insertCamera";
    static a hHa;

    public interface a {
        e cI(Context context);
    }

    public final View a(e eVar, JSONObject jSONObject) {
        CharSequence string;
        AppMethodBeat.i(126243);
        Context context = eVar.getContext();
        e cI = hHa.cI(context);
        int optInt = jSONObject.optInt("cameraId");
        String optString = jSONObject.optString("mode", "normal");
        String optString2 = jSONObject.optString("devicePosition", "back");
        String optString3 = jSONObject.optString("flash", "auto");
        String optString4 = jSONObject.optString("size");
        int i = 720;
        Object obj = -1;
        switch (optString4.hashCode()) {
            case -1078030475:
                if (optString4.equals(b.MEDIUM)) {
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
                i = d.MIC_PTU_YOUJIALI;
                break;
            case 1:
                i = 480;
                break;
            case 2:
                i = 720;
                break;
        }
        boolean optBoolean = jSONObject.optBoolean("needOutput", false);
        cI.setAppId(eVar.getAppId());
        cI.setPage(eVar);
        cI.setCameraId(optInt);
        cI.setMode(optString);
        cI.ai(optString2, true);
        cI.setFlash(optString3);
        cI.setFrameLimitSize(i);
        cI.setNeedOutput(optBoolean);
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        int a = g.a(optJSONObject, "width", 0);
        i = g.a(optJSONObject, "height", 0);
        if (!(a == 0 || i == 0)) {
            cI.da(a, i);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("scanArea");
        if (optJSONArray == null || optJSONArray.length() != 4) {
            cI.w(0, 0, a, i);
        } else {
            ab.i("MicroMsg.JsApiInsertCamera", "scanAreaArray:%s, scanAreaArray.length:%d", optJSONArray, Integer.valueOf(optJSONArray.length()));
            cI.w(g.qb(optJSONArray.optInt(0)), g.qb(optJSONArray.optInt(1)), g.qb(optJSONArray.optInt(2)), g.qb(optJSONArray.optInt(3)));
        }
        cI.setScanFreq(jSONObject.optInt("scanFreq"));
        ab.d("MicroMsg.JsApiInsertCamera", "inflateView cameraId: %d,devicePosition: %s,flash: %s,width: %d,height: %d", Integer.valueOf(optInt), optString2, optString3, Integer.valueOf(a), Integer.valueOf(i));
        View view = cI.getView();
        if ("normal".equals(optString)) {
            string = context.getString(R.string.g3);
        } else {
            string = context.getString(R.string.g4);
        }
        view.setContentDescription(string);
        CoverViewContainer coverViewContainer = new CoverViewContainer(context, (View) cI);
        AppMethodBeat.o(126243);
        return coverViewContainer;
    }

    public final int r(JSONObject jSONObject) {
        AppMethodBeat.i(126244);
        int optInt = jSONObject.optInt("cameraId");
        AppMethodBeat.o(126244);
        return optInt;
    }

    public final boolean aCE() {
        return true;
    }

    public final void a(final e eVar, final int i, View view, JSONObject jSONObject, com.tencent.mm.plugin.appbrand.jsapi.base.g gVar) {
        AppMethodBeat.i(138256);
        ab.i("MicroMsg.JsApiInsertCamera", "onInsertView cameraId=%d", Integer.valueOf(i));
        gVar.AR(j("ok", null));
        final e eVar2 = (e) ((CoverViewContainer) view).ah(View.class);
        if (eVar2 == null) {
            ab.w("MicroMsg.JsApiInsertCamera", "onInsertView(viewId : %d) failed, cameraView is null", Integer.valueOf(i));
            AppMethodBeat.o(138256);
            return;
        }
        a((c) eVar, eVar2);
        a aDb = a.hGl;
        aDb.hGk.put(Integer.valueOf(eVar2.getCameraId()), eVar2);
        eVar.a((f.d) eVar2);
        eVar.a((f.b) eVar2);
        eVar.a((f.c) eVar2);
        com.tencent.mm.plugin.appbrand.g.a(eVar.getAppId(), new com.tencent.mm.plugin.appbrand.g.c() {
            public final void onDestroy() {
                AppMethodBeat.i(126241);
                eVar.b((f.d) eVar2);
                eVar.b((f.b) eVar2);
                eVar.b((f.c) eVar2);
                a aDb = a.hGl;
                Integer valueOf = Integer.valueOf(i);
                if (aDb.hGk.containsKey(valueOf)) {
                    ((e) aDb.hGk.remove(valueOf)).release();
                }
                com.tencent.mm.plugin.appbrand.g.b(eVar.getAppId(), this);
                AppMethodBeat.o(126241);
            }
        });
        eVar2.setOutPutCallBack(new b() {
        });
        AppMethodBeat.o(138256);
    }

    /* Access modifiers changed, original: final */
    public final boolean a(final c cVar, final e eVar) {
        AppMethodBeat.i(126246);
        n.b(String.valueOf(cVar.getAppId()), new android.support.v4.app.a.a() {
            public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                AppMethodBeat.i(126242);
                HashMap hashMap;
                if (i != 16) {
                    if (i == 18) {
                        if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                            hashMap = new HashMap();
                            hashMap.put("cameraId", Integer.valueOf(eVar.getCameraId()));
                            new g().j(cVar).AM(new JSONObject(hashMap).toString()).aCj();
                            a.hGl.hGj = false;
                        } else {
                            a.hGl.hGj = true;
                            j.this.a(cVar, eVar);
                            AppMethodBeat.o(126242);
                            return;
                        }
                    }
                    AppMethodBeat.o(126242);
                } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                    hashMap = new HashMap();
                    hashMap.put("cameraId", Integer.valueOf(eVar.getCameraId()));
                    new g().j(cVar).AM(new JSONObject(hashMap).toString()).aCj();
                    a.hGl.hGi = false;
                    AppMethodBeat.o(126242);
                } else {
                    a.hGl.hGi = true;
                    j.this.a(cVar, eVar);
                    AppMethodBeat.o(126242);
                }
            }
        });
        Activity activity = (Activity) cVar.getContext();
        if (activity == null) {
            AppMethodBeat.o(126246);
            return false;
        }
        boolean a = com.tencent.luggage.g.g.a(activity, "android.permission.CAMERA", 16, "", "");
        a.hGl.hGi = a;
        if (a) {
            boolean a2 = com.tencent.luggage.g.g.a(activity, "android.permission.RECORD_AUDIO", 18, "", "");
            a.hGl.hGj = a2;
            if (a2) {
                n.Dr(cVar.getAppId());
                eVar.initView();
                AppMethodBeat.o(126246);
                return true;
            }
            AppMethodBeat.o(126246);
            return false;
        }
        AppMethodBeat.o(126246);
        return false;
    }
}
