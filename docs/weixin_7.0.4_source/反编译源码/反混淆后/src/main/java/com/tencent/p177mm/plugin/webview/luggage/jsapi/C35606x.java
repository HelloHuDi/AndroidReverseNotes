package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.plugin.webview.p1562a.C40211a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.x */
public class C35606x extends C46419bd {
    public final String name() {
        return "jumpToBizProfile";
    }

    public final int biG() {
        return 2;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, final C22841a c22841a) {
        AppMethodBeat.m2504i(6321);
        try {
            JSONObject jSONObject = new JSONObject(str);
            C4990ab.m7411d("MicroMsg.JsApiJumpToBizProfile", "doJumpToBizProfile %s, %s", jSONObject.optString("tousername"), jSONObject.optString("extmsg"));
            String optString = jSONObject.optString("currentUrl");
            Intent intent = new Intent();
            intent.putExtra("toUserName", r1);
            intent.putExtra(IssueStorage.COLUMN_EXT_INFO, r2);
            intent.putExtra("fromURL", optString);
            intent.putExtra("source", 2);
            C40211a.gkE.mo38893a(intent, hashCode() & CdnLogic.kBizGeneric, new C5186a() {
                /* renamed from: c */
                public final void mo6069c(int i, int i2, Intent intent) {
                    AppMethodBeat.m2504i(6320);
                    if (i == (C35606x.this.hashCode() & CdnLogic.kBizGeneric)) {
                        C4990ab.m7416i("MicroMsg.JsApiJumpToBizProfile", "request jumpToBizProfile, resultCode = ".concat(String.valueOf(i2)));
                        switch (i2) {
                            case -1:
                                c22841a.mo26722d(null, null);
                                AppMethodBeat.m2505o(6320);
                                return;
                            case 0:
                                c22841a.mo26722d("cancel", null);
                                AppMethodBeat.m2505o(6320);
                                return;
                            case 2:
                            case 3:
                                c22841a.mo26722d("check_fail", null);
                                AppMethodBeat.m2505o(6320);
                                return;
                            default:
                                c22841a.mo26722d("fail", null);
                                C4990ab.m7412e("MicroMsg.JsApiJumpToBizProfile", "unknown resultCode");
                                break;
                        }
                    }
                    AppMethodBeat.m2505o(6320);
                }
            }, (MMActivity) context);
            AppMethodBeat.m2505o(6321);
        } catch (JSONException e) {
            C4990ab.m7412e("MicroMsg.JsApiJumpToBizProfile", "parase json fail");
            c22841a.mo26722d("fail", null);
            AppMethodBeat.m2505o(6321);
        }
    }
}
