package com.tencent.p177mm.plugin.appbrand.jsapi.fakenative;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p230g.p231a.C9398kh;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.plugin.appbrand.C2119d;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil.C19360a;
import com.tencent.p177mm.plugin.appbrand.jsapi.miniprogram_navigator.C16672a;
import com.tencent.p177mm.plugin.appbrand.jsapi.miniprogram_navigator.C2319b;
import com.tencent.p177mm.plugin.appbrand.jsapi.miniprogram_navigator.C2320c;
import com.tencent.p177mm.plugin.appbrand.jsapi.miniprogram_navigator.C2320c.C2322a;
import com.tencent.p177mm.plugin.appbrand.jsapi.miniprogram_navigator.C2320c.C2323c;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.fakenative.c */
public final class C19365c extends C16672a {
    public static final int CTRL_INDEX = 592;
    public static final String NAME = "openBusinessView";
    private C44275p eir;
    boolean hJm = false;
    private C4884c<C9398kh> hJn;

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(131038);
        final C2119d c2119d = (C2119d) c2241c;
        String optString = jSONObject.optString("businessType");
        if (C5046bo.isNullOrNil(optString)) {
            m30052a(c2119d, i, C26968d.INVALID_BUSINESS_TYPE.errCode, C26968d.INVALID_BUSINESS_TYPE.aIm);
            AppMethodBeat.m2505o(131038);
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
        int i2 = c2119d.getRuntime().mo15034ye().hhd.gVt;
        int i3 = C2319b.m4539a(jSONObject.optString("envVersion"), C2319b.RELEASE).har;
        if (!(i2 == 1 || i2 == 2)) {
            i3 = 0;
        }
        i2 = jSONObject.optInt("sourcetype", 5);
        String optString3 = jSONObject.optString("agentId");
        final C2322a c2322a = new C2322a();
        c2322a.scene = jSONObject.optInt("scene", 0);
        c2322a.cst = jSONObject.optString("sceneNote");
        c2322a.cOq = jSONObject.optInt("preScene", 0);
        c2322a.cOr = jSONObject.optString("preSceneNote");
        c2322a.cvp = i2;
        c2322a.hgS = optString3;
        c2322a.businessType = optString;
        String appId = c2119d.getAppId();
        this.hJm = false;
        Context context = c2119d.getContext();
        final int i4 = i;
        OnCancelListener c193621 = new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(131029);
                C4990ab.m7420w("MicroMsg.JsApiOpenBusinessView", "openBusinessViewByMiniProgram, user canceled");
                C19365c.this.hJm = true;
                C19365c.m30053a(C19365c.this, c2119d, i4, C26968d.CANCEL.errCode, C26968d.CANCEL.aIm);
                AppMethodBeat.m2505o(131029);
            }
        };
        aDw();
        context.getString(C25738R.string.f9238tz);
        this.eir = C30379h.m48458b(context, context.getString(C25738R.string.f9260un), true, c193621);
        i4 = i;
        this.hJn = new C4884c<C9398kh>() {
            /* renamed from: a */
            private boolean m30055a(C9398kh c9398kh) {
                AppMethodBeat.m2504i(131034);
                int i = c9398kh.cFN.errCode;
                HashMap hashMap;
                if (i < 0) {
                    String str;
                    hashMap = new HashMap();
                    hashMap.put("errCode", Integer.valueOf(i));
                    if (i == C26968d.CGI_ERROR.errCode) {
                        str = C26968d.CGI_ERROR.aIm;
                    } else if (i == C26968d.CANCEL.errCode) {
                        str = C26968d.CANCEL.aIm;
                    } else if (i == C26968d.INVALID_BUSINESS_TYPE.errCode) {
                        str = C26968d.INVALID_BUSINESS_TYPE.aIm;
                    } else {
                        str = C26968d.SYSTEM_ERROR.aIm;
                    }
                    C4990ab.m7417i("MicroMsg.JsApiOpenBusinessView", "navigate back MiniProgram fail, errCode:%s, errMsg:%s", Integer.valueOf(i), str);
                    c2119d.mo6107M(i4, C19365c.this.mo73394j(str, hashMap));
                } else {
                    Object jSONObject;
                    hashMap = new HashMap();
                    hashMap.put("errCode", Integer.valueOf(i));
                    try {
                        jSONObject = new JSONObject(C5046bo.m7532bc(c9398kh.cFN.cFM, "{}"));
                    } catch (JSONException e) {
                        C4990ab.m7413e("MicroMsg.JsApiOpenBusinessView", "navigate back MiniProgram, parse extraData fail", e);
                        jSONObject = new JSONObject();
                    }
                    hashMap.put("extraData", jSONObject);
                    C4990ab.m7416i("MicroMsg.JsApiOpenBusinessView", "navigate back MiniProgram success");
                    c2119d.mo6107M(i4, C19365c.this.mo73394j(C26968d.OK.aIm, hashMap));
                }
                dead();
                AppMethodBeat.m2505o(131034);
                return false;
            }
        };
        this.hJn.dnU();
        final int i5 = i;
        OpenBusinessViewUtil.m30037a(3, optString, optString2, appId, null, new C19360a() {

            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.fakenative.c$2$1 */
            class C193631 implements C2323c {
                C193631() {
                }

                /* renamed from: dY */
                public final void mo6193dY(boolean z) {
                    AppMethodBeat.m2504i(131030);
                    if (z) {
                        C4990ab.m7416i("MicroMsg.JsApiOpenBusinessView", "openBusinessViewByMiniProgram success");
                        AppMethodBeat.m2505o(131030);
                        return;
                    }
                    C4990ab.m7412e("MicroMsg.JsApiOpenBusinessView", "openBusinessViewByMiniProgram fail");
                    C19365c.m30053a(C19365c.this, c2119d, i5, C26968d.SYSTEM_ERROR.errCode, C26968d.SYSTEM_ERROR.aIm);
                    AppMethodBeat.m2505o(131030);
                }
            }

            /* renamed from: ce */
            public final void mo6278ce(String str, String str2) {
                AppMethodBeat.m2504i(131031);
                C19365c.this.aDw();
                if (C19365c.this.hJm) {
                    AppMethodBeat.m2505o(131031);
                } else if (C5046bo.isNullOrNil(str)) {
                    C4990ab.m7412e("MicroMsg.JsApiOpenBusinessView", "openBusinessViewByMiniProgram, invalid businessType");
                    C19365c.m30053a(C19365c.this, c2119d, i5, C26968d.INVALID_BUSINESS_TYPE.errCode, C26968d.INVALID_BUSINESS_TYPE.aIm);
                    AppMethodBeat.m2505o(131031);
                } else {
                    C10383e.hJB.mo6194a(c2119d, str, i3, str2, c2322a, optJSONObject, optJSONObject2, new C193631());
                    AppMethodBeat.m2505o(131031);
                }
            }

            /* renamed from: R */
            public final void mo6277R(int i, String str) {
                AppMethodBeat.m2504i(131032);
                C19365c.this.aDw();
                C4990ab.m7413e("MicroMsg.JsApiOpenBusinessView", "openBusinessViewByMiniProgram fail, CGI errCode:%d, errMsg:%s", Integer.valueOf(i), str);
                C19365c.m30053a(C19365c.this, c2119d, i5, C26968d.CGI_ERROR.errCode, C26968d.CGI_ERROR.aIm);
                AppMethodBeat.m2505o(131032);
            }
        });
        AppMethodBeat.m2505o(131038);
    }

    /* renamed from: a */
    static /* synthetic */ void m30053a(C19365c c19365c, C2119d c2119d, int i, int i2, String str) {
        AppMethodBeat.m2504i(131039);
        c19365c.m30052a(c2119d, i, i2, str);
        AppMethodBeat.m2505o(131039);
    }

    /* renamed from: a */
    private void m30052a(C2119d c2119d, int i, int i2, String str) {
        AppMethodBeat.m2504i(131036);
        HashMap hashMap = new HashMap();
        hashMap.put("errCode", Integer.valueOf(i2));
        c2119d.mo6107M(i, mo73394j(str, hashMap));
        AppMethodBeat.m2505o(131036);
    }

    public final C2320c aDv() {
        return C10383e.hJB;
    }

    /* Access modifiers changed, original: final */
    public final void aDw() {
        AppMethodBeat.m2504i(131037);
        if (this.eir != null) {
            this.eir.dismiss();
            this.eir = null;
        }
        AppMethodBeat.m2505o(131037);
    }
}
