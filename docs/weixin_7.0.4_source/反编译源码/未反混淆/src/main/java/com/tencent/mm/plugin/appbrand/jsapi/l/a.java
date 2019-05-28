package com.tencent.mm.plugin.appbrand.jsapi.l;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.appbrand.jsapi.l.b.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import org.json.JSONObject;

public enum a implements b {
    ;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.l.a$4 */
    class AnonymousClass4 implements com.tencent.mm.ui.MMActivity.a {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.l.b.a hTL;

        AnonymousClass4(com.tencent.mm.plugin.appbrand.jsapi.l.b.a aVar) {
            this.hTL = aVar;
        }

        public final void c(int i, int i2, Intent intent) {
            AppMethodBeat.i(131404);
            if (i != (a.this.hashCode() & CdnLogic.kBizGeneric)) {
                AppMethodBeat.o(131404);
            } else if (i2 == -1) {
                if (this.hTL != null) {
                    this.hTL.a(1, null, null);
                }
                AppMethodBeat.o(131404);
            } else if (i2 == 2) {
                if (this.hTL != null) {
                    this.hTL.a(2, intent != null ? intent.getStringExtra("key_result_errmsg") : "", null);
                }
                AppMethodBeat.o(131404);
            } else {
                if (this.hTL != null) {
                    this.hTL.a(3, null, null);
                }
                AppMethodBeat.o(131404);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.l.a$2 */
    class AnonymousClass2 implements com.tencent.mm.ui.MMActivity.a {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.l.b.a hTL;

        AnonymousClass2(com.tencent.mm.plugin.appbrand.jsapi.l.b.a aVar) {
            this.hTL = aVar;
        }

        public final void c(int i, int i2, Intent intent) {
            AppMethodBeat.i(131402);
            if (i != (a.this.hashCode() & CdnLogic.kBizGeneric)) {
                AppMethodBeat.o(131402);
            } else if (i2 == -1) {
                HashMap hashMap = new HashMap();
                String bc = bo.bc(intent.getStringExtra("token"), "");
                String bc2 = bo.bc(intent.getStringExtra("bind_serial"), "");
                hashMap.put("token", bc);
                hashMap.put("bindSerial", bc2);
                if (this.hTL != null) {
                    this.hTL.a(1, null, hashMap);
                }
                AppMethodBeat.o(131402);
            } else {
                if (this.hTL != null) {
                    this.hTL.a(2, null, null);
                }
                AppMethodBeat.o(131402);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.l.a$3 */
    class AnonymousClass3 implements com.tencent.mm.ui.MMActivity.a {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.l.b.a hTL;

        AnonymousClass3(com.tencent.mm.plugin.appbrand.jsapi.l.b.a aVar) {
            this.hTL = aVar;
        }

        public final void c(int i, int i2, Intent intent) {
            AppMethodBeat.i(131403);
            if (i != (a.this.hashCode() & CdnLogic.kBizGeneric)) {
                AppMethodBeat.o(131403);
                return;
            }
            if (i2 == -1) {
                if (this.hTL != null) {
                    this.hTL.a(1, null, null);
                    AppMethodBeat.o(131403);
                    return;
                }
            } else if (this.hTL != null) {
                this.hTL.a(2, null, null);
            }
            AppMethodBeat.o(131403);
        }
    }

    private a(String str) {
    }

    static {
        AppMethodBeat.o(131410);
    }

    public final boolean a(MMActivity mMActivity, AppBrandStatObject appBrandStatObject, JSONObject jSONObject, final com.tencent.mm.plugin.appbrand.jsapi.l.b.a aVar, PString pString) {
        AppMethodBeat.i(131408);
        g gVar = new g(jSONObject);
        if (appBrandStatObject != null) {
            gVar.cvS = g.gT(appBrandStatObject.scene, appBrandStatObject.cOo);
            gVar.vwt = g.gS(appBrandStatObject.scene, appBrandStatObject.cOo);
        }
        gVar.cIf = 46;
        pString.value = gVar.packageExt;
        boolean a = h.a(mMActivity, gVar, hashCode() & CdnLogic.kBizGeneric, new com.tencent.mm.ui.MMActivity.a() {
            public final void c(int i, int i2, Intent intent) {
                AppMethodBeat.i(131401);
                if (i != (a.this.hashCode() & CdnLogic.kBizGeneric)) {
                    AppMethodBeat.o(131401);
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
                    if (aVar != null) {
                        aVar.a(1, null, hashMap);
                    }
                    AppMethodBeat.o(131401);
                } else if (i2 == 5) {
                    intExtra = intent.getIntExtra("key_jsapi_pay_err_code", 0);
                    ab.e("MicroMsg.AppBrandJsApiPayService", "errCode: %d, errMsg: %s", Integer.valueOf(intExtra), bo.nullAsNil(intent.getStringExtra("key_jsapi_pay_err_msg")));
                    if (aVar != null) {
                        aVar.a(2, r1, hashMap);
                    }
                    AppMethodBeat.o(131401);
                } else {
                    if (aVar != null) {
                        aVar.a(3, null, hashMap);
                    }
                    AppMethodBeat.o(131401);
                }
            }
        });
        AppMethodBeat.o(131408);
        return a;
    }

    public final void a(MMActivity mMActivity, JSONObject jSONObject, final b bVar) {
        AppMethodBeat.i(131409);
        AnonymousClass5 anonymousClass5 = new com.tencent.mm.ui.MMActivity.a() {
            public final void c(int i, int i2, Intent intent) {
                AppMethodBeat.i(131405);
                if (i != (a.this.hashCode() & CdnLogic.kBizGeneric)) {
                    AppMethodBeat.o(131405);
                } else if (i2 == -1) {
                    CharSequence charSequence = "";
                    if (intent != null) {
                        charSequence = bo.bc(intent.getStringExtra("token"), "");
                    }
                    if (TextUtils.isEmpty(charSequence)) {
                        ab.i("MicroMsg.AppBrandJsApiPayService", "checkPwdToken is empty, verifyWCPayPassword:fail");
                        if (bVar != null) {
                            bVar.h(false, null);
                        }
                    } else {
                        ab.i("MicroMsg.AppBrandJsApiPayService", "checkPwdToken is valid, verifyWCPayPassword:ok");
                        if (bVar != null) {
                            bVar.h(true, charSequence);
                            AppMethodBeat.o(131405);
                            return;
                        }
                    }
                    AppMethodBeat.o(131405);
                } else {
                    if (bVar != null) {
                        bVar.h(false, null);
                    }
                    AppMethodBeat.o(131405);
                }
            }
        };
        g gVar = new g(jSONObject);
        Intent intent = new Intent();
        intent.putExtra("appId", gVar.appId);
        intent.putExtra("timeStamp", gVar.timeStamp);
        intent.putExtra("nonceStr", gVar.nonceStr);
        intent.putExtra("packageExt", gVar.packageExt);
        intent.putExtra("signtype", gVar.signType);
        intent.putExtra("paySignature", gVar.cId);
        intent.putExtra("url", gVar.url);
        intent.putExtra("scene", 1);
        mMActivity.ifE = anonymousClass5;
        Context context = mMActivity;
        d.a(context, "wallet_core", ".ui.WalletCheckPwdUI", intent, CdnLogic.kBizGeneric & hashCode(), false);
        AppMethodBeat.o(131409);
    }
}
