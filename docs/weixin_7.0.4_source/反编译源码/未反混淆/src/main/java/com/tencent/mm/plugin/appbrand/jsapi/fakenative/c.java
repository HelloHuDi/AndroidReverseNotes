package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.kh;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.a;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_INDEX = 592;
    public static final String NAME = "openBusinessView";
    private p eir;
    boolean hJm = false;
    private com.tencent.mm.sdk.b.c<kh> hJn;

    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(131038);
        final d dVar = (d) cVar;
        String optString = jSONObject.optString("businessType");
        if (bo.isNullOrNil(optString)) {
            a(dVar, i, d.INVALID_BUSINESS_TYPE.errCode, d.INVALID_BUSINESS_TYPE.aIm);
            AppMethodBeat.o(131038);
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("extraData");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("privateExtraData");
        if (optJSONObject2 == null) {
            optJSONObject2 = new JSONObject();
        }
        String optString2 = jSONObject.optString("queryString");
        int i2 = dVar.getRuntime().ye().hhd.gVt;
        int i3 = b.a(jSONObject.optString("envVersion"), b.RELEASE).har;
        if (!(i2 == 1 || i2 == 2)) {
            i3 = 0;
        }
        i2 = jSONObject.optInt("sourcetype", 5);
        String optString3 = jSONObject.optString("agentId");
        final com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c.a aVar = new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c.a();
        aVar.scene = jSONObject.optInt("scene", 0);
        aVar.cst = jSONObject.optString("sceneNote");
        aVar.cOq = jSONObject.optInt("preScene", 0);
        aVar.cOr = jSONObject.optString("preSceneNote");
        aVar.cvp = i2;
        aVar.hgS = optString3;
        aVar.businessType = optString;
        String appId = dVar.getAppId();
        this.hJm = false;
        Context context = dVar.getContext();
        final int i4 = i;
        OnCancelListener anonymousClass1 = new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(131029);
                ab.w("MicroMsg.JsApiOpenBusinessView", "openBusinessViewByMiniProgram, user canceled");
                c.this.hJm = true;
                c.a(c.this, dVar, i4, d.CANCEL.errCode, d.CANCEL.aIm);
                AppMethodBeat.o(131029);
            }
        };
        aDw();
        context.getString(R.string.tz);
        this.eir = h.b(context, context.getString(R.string.un), true, anonymousClass1);
        i4 = i;
        this.hJn = new com.tencent.mm.sdk.b.c<kh>() {
            private boolean a(kh khVar) {
                AppMethodBeat.i(131034);
                int i = khVar.cFN.errCode;
                HashMap hashMap;
                if (i < 0) {
                    String str;
                    hashMap = new HashMap();
                    hashMap.put("errCode", Integer.valueOf(i));
                    if (i == d.CGI_ERROR.errCode) {
                        str = d.CGI_ERROR.aIm;
                    } else if (i == d.CANCEL.errCode) {
                        str = d.CANCEL.aIm;
                    } else if (i == d.INVALID_BUSINESS_TYPE.errCode) {
                        str = d.INVALID_BUSINESS_TYPE.aIm;
                    } else {
                        str = d.SYSTEM_ERROR.aIm;
                    }
                    ab.i("MicroMsg.JsApiOpenBusinessView", "navigate back MiniProgram fail, errCode:%s, errMsg:%s", Integer.valueOf(i), str);
                    dVar.M(i4, c.this.j(str, hashMap));
                } else {
                    Object jSONObject;
                    hashMap = new HashMap();
                    hashMap.put("errCode", Integer.valueOf(i));
                    try {
                        jSONObject = new JSONObject(bo.bc(khVar.cFN.cFM, "{}"));
                    } catch (JSONException e) {
                        ab.e("MicroMsg.JsApiOpenBusinessView", "navigate back MiniProgram, parse extraData fail", e);
                        jSONObject = new JSONObject();
                    }
                    hashMap.put("extraData", jSONObject);
                    ab.i("MicroMsg.JsApiOpenBusinessView", "navigate back MiniProgram success");
                    dVar.M(i4, c.this.j(d.OK.aIm, hashMap));
                }
                dead();
                AppMethodBeat.o(131034);
                return false;
            }
        };
        this.hJn.dnU();
        final int i5 = i;
        OpenBusinessViewUtil.a(3, optString, optString2, appId, null, new OpenBusinessViewUtil.a() {
            public final void ce(String str, String str2) {
                AppMethodBeat.i(131031);
                c.this.aDw();
                if (c.this.hJm) {
                    AppMethodBeat.o(131031);
                } else if (bo.isNullOrNil(str)) {
                    ab.e("MicroMsg.JsApiOpenBusinessView", "openBusinessViewByMiniProgram, invalid businessType");
                    c.a(c.this, dVar, i5, d.INVALID_BUSINESS_TYPE.errCode, d.INVALID_BUSINESS_TYPE.aIm);
                    AppMethodBeat.o(131031);
                } else {
                    e.hJB.a(dVar, str, i3, str2, aVar, optJSONObject, optJSONObject2, new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c.c() {
                        public final void dY(boolean z) {
                            AppMethodBeat.i(131030);
                            if (z) {
                                ab.i("MicroMsg.JsApiOpenBusinessView", "openBusinessViewByMiniProgram success");
                                AppMethodBeat.o(131030);
                                return;
                            }
                            ab.e("MicroMsg.JsApiOpenBusinessView", "openBusinessViewByMiniProgram fail");
                            c.a(c.this, dVar, i5, d.SYSTEM_ERROR.errCode, d.SYSTEM_ERROR.aIm);
                            AppMethodBeat.o(131030);
                        }
                    });
                    AppMethodBeat.o(131031);
                }
            }

            public final void R(int i, String str) {
                AppMethodBeat.i(131032);
                c.this.aDw();
                ab.e("MicroMsg.JsApiOpenBusinessView", "openBusinessViewByMiniProgram fail, CGI errCode:%d, errMsg:%s", Integer.valueOf(i), str);
                c.a(c.this, dVar, i5, d.CGI_ERROR.errCode, d.CGI_ERROR.aIm);
                AppMethodBeat.o(131032);
            }
        });
        AppMethodBeat.o(131038);
    }

    static /* synthetic */ void a(c cVar, d dVar, int i, int i2, String str) {
        AppMethodBeat.i(131039);
        cVar.a(dVar, i, i2, str);
        AppMethodBeat.o(131039);
    }

    private void a(d dVar, int i, int i2, String str) {
        AppMethodBeat.i(131036);
        HashMap hashMap = new HashMap();
        hashMap.put("errCode", Integer.valueOf(i2));
        dVar.M(i, j(str, hashMap));
        AppMethodBeat.o(131036);
    }

    public final com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c aDv() {
        return e.hJB;
    }

    /* Access modifiers changed, original: final */
    public final void aDw() {
        AppMethodBeat.i(131037);
        if (this.eir != null) {
            this.eir.dismiss();
            this.eir = null;
        }
        AppMethodBeat.o(131037);
    }
}
