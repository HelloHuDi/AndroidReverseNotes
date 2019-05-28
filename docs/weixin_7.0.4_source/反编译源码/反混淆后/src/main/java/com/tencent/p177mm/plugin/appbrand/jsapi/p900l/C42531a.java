package com.tencent.p177mm.plugin.appbrand.jsapi.p900l;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p900l.C10443b.C10444a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p900l.C10443b.C10445b;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.pluginsdk.wallet.C40493g;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.l.a */
public enum C42531a implements C10443b {
    ;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.l.a$4 */
    class C194094 implements C5186a {
        final /* synthetic */ C10444a hTL;

        C194094(C10444a c10444a) {
            this.hTL = c10444a;
        }

        /* renamed from: c */
        public final void mo6069c(int i, int i2, Intent intent) {
            AppMethodBeat.m2504i(131404);
            if (i != (C42531a.this.hashCode() & CdnLogic.kBizGeneric)) {
                AppMethodBeat.m2505o(131404);
            } else if (i2 == -1) {
                if (this.hTL != null) {
                    this.hTL.mo21960a(1, null, null);
                }
                AppMethodBeat.m2505o(131404);
            } else if (i2 == 2) {
                if (this.hTL != null) {
                    this.hTL.mo21960a(2, intent != null ? intent.getStringExtra("key_result_errmsg") : "", null);
                }
                AppMethodBeat.m2505o(131404);
            } else {
                if (this.hTL != null) {
                    this.hTL.mo21960a(3, null, null);
                }
                AppMethodBeat.m2505o(131404);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.l.a$2 */
    class C383222 implements C5186a {
        final /* synthetic */ C10444a hTL;

        C383222(C10444a c10444a) {
            this.hTL = c10444a;
        }

        /* renamed from: c */
        public final void mo6069c(int i, int i2, Intent intent) {
            AppMethodBeat.m2504i(131402);
            if (i != (C42531a.this.hashCode() & CdnLogic.kBizGeneric)) {
                AppMethodBeat.m2505o(131402);
            } else if (i2 == -1) {
                HashMap hashMap = new HashMap();
                String bc = C5046bo.m7532bc(intent.getStringExtra("token"), "");
                String bc2 = C5046bo.m7532bc(intent.getStringExtra("bind_serial"), "");
                hashMap.put("token", bc);
                hashMap.put("bindSerial", bc2);
                if (this.hTL != null) {
                    this.hTL.mo21960a(1, null, hashMap);
                }
                AppMethodBeat.m2505o(131402);
            } else {
                if (this.hTL != null) {
                    this.hTL.mo21960a(2, null, null);
                }
                AppMethodBeat.m2505o(131402);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.l.a$3 */
    class C425323 implements C5186a {
        final /* synthetic */ C10444a hTL;

        C425323(C10444a c10444a) {
            this.hTL = c10444a;
        }

        /* renamed from: c */
        public final void mo6069c(int i, int i2, Intent intent) {
            AppMethodBeat.m2504i(131403);
            if (i != (C42531a.this.hashCode() & CdnLogic.kBizGeneric)) {
                AppMethodBeat.m2505o(131403);
                return;
            }
            if (i2 == -1) {
                if (this.hTL != null) {
                    this.hTL.mo21960a(1, null, null);
                    AppMethodBeat.m2505o(131403);
                    return;
                }
            } else if (this.hTL != null) {
                this.hTL.mo21960a(2, null, null);
            }
            AppMethodBeat.m2505o(131403);
        }
    }

    private C42531a(String str) {
    }

    static {
        AppMethodBeat.m2505o(131410);
    }

    /* renamed from: a */
    public final boolean mo67992a(MMActivity mMActivity, AppBrandStatObject appBrandStatObject, JSONObject jSONObject, final C10444a c10444a, PString pString) {
        AppMethodBeat.m2504i(131408);
        C40493g c40493g = new C40493g(jSONObject);
        if (appBrandStatObject != null) {
            c40493g.cvS = C40493g.m69626gT(appBrandStatObject.scene, appBrandStatObject.cOo);
            c40493g.vwt = C40493g.m69625gS(appBrandStatObject.scene, appBrandStatObject.cOo);
        }
        c40493g.cIf = 46;
        pString.value = c40493g.packageExt;
        boolean a = C35899h.m58859a(mMActivity, c40493g, hashCode() & CdnLogic.kBizGeneric, new C5186a() {
            /* renamed from: c */
            public final void mo6069c(int i, int i2, Intent intent) {
                AppMethodBeat.m2504i(131401);
                if (i != (C42531a.this.hashCode() & CdnLogic.kBizGeneric)) {
                    AppMethodBeat.m2505o(131401);
                    return;
                }
                int intExtra;
                if (intent != null) {
                    intExtra = intent.getIntExtra("key_is_clear_failure", -1);
                } else {
                    intExtra = -1;
                }
                HashMap hashMap = new HashMap();
                if (intExtra == 0) {
                    hashMap.put("payStatus", "pending");
                } else if (intExtra == 1) {
                    hashMap.put("pay_status", "fail");
                }
                if (i2 == -1) {
                    if (c10444a != null) {
                        c10444a.mo21960a(1, null, hashMap);
                    }
                    AppMethodBeat.m2505o(131401);
                } else if (i2 == 5) {
                    intExtra = intent.getIntExtra("key_jsapi_pay_err_code", 0);
                    C4990ab.m7413e("MicroMsg.AppBrandJsApiPayService", "errCode: %d, errMsg: %s", Integer.valueOf(intExtra), C5046bo.nullAsNil(intent.getStringExtra("key_jsapi_pay_err_msg")));
                    if (c10444a != null) {
                        c10444a.mo21960a(2, r1, hashMap);
                    }
                    AppMethodBeat.m2505o(131401);
                } else {
                    if (c10444a != null) {
                        c10444a.mo21960a(3, null, hashMap);
                    }
                    AppMethodBeat.m2505o(131401);
                }
            }
        });
        AppMethodBeat.m2505o(131408);
        return a;
    }

    /* renamed from: a */
    public final void mo67991a(MMActivity mMActivity, JSONObject jSONObject, final C10445b c10445b) {
        AppMethodBeat.m2504i(131409);
        C270155 c270155 = new C5186a() {
            /* renamed from: c */
            public final void mo6069c(int i, int i2, Intent intent) {
                AppMethodBeat.m2504i(131405);
                if (i != (C42531a.this.hashCode() & CdnLogic.kBizGeneric)) {
                    AppMethodBeat.m2505o(131405);
                } else if (i2 == -1) {
                    CharSequence charSequence = "";
                    if (intent != null) {
                        charSequence = C5046bo.m7532bc(intent.getStringExtra("token"), "");
                    }
                    if (TextUtils.isEmpty(charSequence)) {
                        C4990ab.m7416i("MicroMsg.AppBrandJsApiPayService", "checkPwdToken is empty, verifyWCPayPassword:fail");
                        if (c10445b != null) {
                            c10445b.mo21961h(false, null);
                        }
                    } else {
                        C4990ab.m7416i("MicroMsg.AppBrandJsApiPayService", "checkPwdToken is valid, verifyWCPayPassword:ok");
                        if (c10445b != null) {
                            c10445b.mo21961h(true, charSequence);
                            AppMethodBeat.m2505o(131405);
                            return;
                        }
                    }
                    AppMethodBeat.m2505o(131405);
                } else {
                    if (c10445b != null) {
                        c10445b.mo21961h(false, null);
                    }
                    AppMethodBeat.m2505o(131405);
                }
            }
        };
        C40493g c40493g = new C40493g(jSONObject);
        Intent intent = new Intent();
        intent.putExtra("appId", c40493g.appId);
        intent.putExtra("timeStamp", c40493g.timeStamp);
        intent.putExtra("nonceStr", c40493g.nonceStr);
        intent.putExtra("packageExt", c40493g.packageExt);
        intent.putExtra("signtype", c40493g.signType);
        intent.putExtra("paySignature", c40493g.cId);
        intent.putExtra("url", c40493g.url);
        intent.putExtra("scene", 1);
        mMActivity.ifE = c270155;
        Context context = mMActivity;
        C25985d.m41453a(context, "wallet_core", ".ui.WalletCheckPwdUI", intent, CdnLogic.kBizGeneric & hashCode(), false);
        AppMethodBeat.m2505o(131409);
    }
}
