package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.a.a;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import org.json.JSONException;
import org.json.JSONObject;

public class x extends bd {
    public final String name() {
        return "jumpToBizProfile";
    }

    public final int biG() {
        return 2;
    }

    public final void b(a aVar) {
    }

    public final void a(Context context, String str, final bc.a aVar) {
        AppMethodBeat.i(6321);
        try {
            JSONObject jSONObject = new JSONObject(str);
            ab.d("MicroMsg.JsApiJumpToBizProfile", "doJumpToBizProfile %s, %s", jSONObject.optString("tousername"), jSONObject.optString("extmsg"));
            String optString = jSONObject.optString("currentUrl");
            Intent intent = new Intent();
            intent.putExtra("toUserName", r1);
            intent.putExtra(IssueStorage.COLUMN_EXT_INFO, r2);
            intent.putExtra("fromURL", optString);
            intent.putExtra("source", 2);
            com.tencent.mm.plugin.webview.a.a.gkE.a(intent, hashCode() & CdnLogic.kBizGeneric, new MMActivity.a() {
                public final void c(int i, int i2, Intent intent) {
                    AppMethodBeat.i(6320);
                    if (i == (x.this.hashCode() & CdnLogic.kBizGeneric)) {
                        ab.i("MicroMsg.JsApiJumpToBizProfile", "request jumpToBizProfile, resultCode = ".concat(String.valueOf(i2)));
                        switch (i2) {
                            case -1:
                                aVar.d(null, null);
                                AppMethodBeat.o(6320);
                                return;
                            case 0:
                                aVar.d("cancel", null);
                                AppMethodBeat.o(6320);
                                return;
                            case 2:
                            case 3:
                                aVar.d("check_fail", null);
                                AppMethodBeat.o(6320);
                                return;
                            default:
                                aVar.d("fail", null);
                                ab.e("MicroMsg.JsApiJumpToBizProfile", "unknown resultCode");
                                break;
                        }
                    }
                    AppMethodBeat.o(6320);
                }
            }, (MMActivity) context);
            AppMethodBeat.o(6321);
        } catch (JSONException e) {
            ab.e("MicroMsg.JsApiJumpToBizProfile", "parase json fail");
            aVar.d("fail", null);
            AppMethodBeat.o(6321);
        }
    }
}
