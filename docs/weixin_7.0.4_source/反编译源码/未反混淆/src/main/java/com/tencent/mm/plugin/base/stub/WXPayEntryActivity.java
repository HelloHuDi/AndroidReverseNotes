package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hc;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.modelpay.PayReq.Options;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.plugin.wallet_index.ui.e;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class WXPayEntryActivity extends AutoLoginActivity {
    private String fOs = null;
    private long jEg = 0;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(18221);
        this.jEg = System.currentTimeMillis();
        w.b(getIntent(), "key_auto_login_wizard_exit", true);
        super.onCreate(bundle);
        AppMethodBeat.o(18221);
    }

    public final boolean O(Intent intent) {
        return true;
    }

    public final void a(a aVar, Intent intent) {
        boolean z = true;
        AppMethodBeat.i(18222);
        if (intent == null) {
            finish();
            AppMethodBeat.o(18222);
            return;
        }
        ab.i("MicroMsg.WXPayEntryActivity", "postLogin, delegate intent to OrderHandlerUI, resultCode = ".concat(String.valueOf(aVar)));
        switch (aVar) {
            case LOGIN_OK:
                ab.i("MicroMsg.WXPayEntryActivity", "coreaccount st %s", Boolean.valueOf(com.tencent.mm.kernel.a.QT()));
                if (com.tencent.mm.kernel.a.QT()) {
                    finish();
                    AppMethodBeat.o(18222);
                    return;
                }
                break;
            case LOGIN_CANCEL:
                rN(-2);
                ab.e("MicroMsg.WXPayEntryActivity", "postLogin fail, loginResult = ".concat(String.valueOf(aVar)));
                finish();
                AppMethodBeat.o(18222);
                return;
            case LOGIN_FAIL:
                rN(-1);
                ab.e("MicroMsg.WXPayEntryActivity", "postLogin fail, loginResult = ".concat(String.valueOf(aVar)));
                finish();
                AppMethodBeat.o(18222);
                return;
            default:
                ab.e("MicroMsg.WXPayEntryActivity", "postLogin, unknown login result = ".concat(String.valueOf(aVar)));
                break;
        }
        this.fOs = w.n(intent, ConstantsAPI.APP_PACKAGE);
        ab.i("MicroMsg.WXPayEntryActivity", "postLogin, getCallingPackage success, value = " + this.fOs);
        if (getIntent() == null || w.aM(getIntent()) == null) {
            z = false;
        } else {
            PayReq payReq = new PayReq();
            payReq.fromBundle(w.aM(getIntent()));
            String str = payReq.appId;
            ab.d("MicroMsg.WXPayEntryActivity", "postLogin, appId = ".concat(String.valueOf(str)));
            if (str == null || str.length() == 0) {
                ab.e("MicroMsg.WXPayEntryActivity", "checkApp fail, appId is null");
                z = false;
            } else {
                f bT = g.bT(str, true);
                if (bT == null) {
                    ab.w("MicroMsg.WXPayEntryActivity", "checkApp fail, not reg");
                    bT = new f();
                    bT.field_appId = str;
                    bT.field_appName = "";
                    bT.field_packageName = this.fOs;
                    bT.field_status = 0;
                    String bw = p.bw(this, this.fOs);
                    if (bw != null) {
                        bT.field_signature = bw;
                    }
                    if (am.bYJ().n(bT) && bo.isNullOrNil(bT.field_openId)) {
                        ab.d("MicroMsg.WXPayEntryActivity", "checkApp, trigger getAppSetting, appId = ".concat(String.valueOf(str)));
                        am.bYL().wy(str);
                    }
                } else if (bT.field_status == 3) {
                    ab.e("MicroMsg.WXPayEntryActivity", "checkApp fail, app is in blacklist");
                    z = false;
                } else if (!p.a(this, bT, this.fOs, true)) {
                    a(this, bT, this.fOs);
                    ab.e("MicroMsg.WXPayEntryActivity", "checkApp fail, app invalid");
                    z = false;
                }
            }
        }
        if (!z) {
            ab.e("MicroMsg.WXPayEntryActivity", "postLogin, checkApp fail");
        }
        try {
            intent.putExtra("key_scene", 0);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.IntentUtil", e, "", new Object[0]);
        }
        Bundle aM = w.aM(intent);
        aM.putLong("wallet_pay_key_check_time", this.jEg);
        h.a((Context) this, aM, z, "");
        finish();
        AppMethodBeat.o(18222);
    }

    private static void a(Context context, f fVar, String str) {
        AppMethodBeat.i(18223);
        Signature[] bx = p.bx(context, str);
        Object obj = "";
        if (bx != null && bx.length > 0) {
            for (Signature toByteArray : bx) {
                obj = obj + q.aiQ(com.tencent.mm.a.g.x(toByteArray.toByteArray())) + "|";
            }
        }
        if (obj.length() > 1) {
            obj = obj.substring(0, obj.length() - 1);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("raw_package_name", bo.bc(str, ""));
            jSONObject.put("package_name", bo.bc(fVar.field_packageName, ""));
            jSONObject.put("raw_signature", obj);
            jSONObject.put("signature", bo.bc(fVar.field_signature, ""));
            jSONObject.put("scene", 5);
        } catch (Exception e) {
            ab.i("MicroMsg.WXPayEntryActivity", "doIfAppInValid, jsonException = " + e.getMessage());
        }
        hc hcVar = new hc();
        hcVar.cBN.appId = fVar.field_appId;
        hcVar.cBN.opType = 3;
        hcVar.cBN.cvq = jSONObject.toString();
        com.tencent.mm.sdk.b.a.xxA.m(hcVar);
        AppMethodBeat.o(18223);
    }

    private void rN(int i) {
        AppMethodBeat.i(18224);
        PayReq payReq = new PayReq();
        payReq.fromBundle(w.aM(getIntent()));
        Options options = new Options();
        options.fromBundle(w.aM(getIntent()));
        PayResp payResp = new PayResp();
        payResp.prepayId = payReq.prepayId;
        payResp.extData = payReq.extData;
        payResp.errCode = i;
        e.a(this, w.n(getIntent(), ConstantsAPI.APP_PACKAGE), payResp, options);
        AppMethodBeat.o(18224);
    }
}
