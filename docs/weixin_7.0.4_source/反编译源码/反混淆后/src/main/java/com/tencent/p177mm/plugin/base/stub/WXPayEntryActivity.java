package com.tencent.p177mm.plugin.base.stub;

import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI;
import com.tencent.p177mm.opensdk.modelpay.PayReq;
import com.tencent.p177mm.opensdk.modelpay.PayReq.Options;
import com.tencent.p177mm.opensdk.modelpay.PayResp;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p230g.p231a.C41999hc;
import com.tencent.p177mm.plugin.wallet_index.p566ui.C4488e;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C35800q;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.p597ui.AutoLoginActivity;
import com.tencent.p177mm.pluginsdk.p597ui.AutoLoginActivity.C4737a;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5068w;
import org.json.JSONObject;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
/* renamed from: com.tencent.mm.plugin.base.stub.WXPayEntryActivity */
public class WXPayEntryActivity extends AutoLoginActivity {
    private String fOs = null;
    private long jEg = 0;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(18221);
        this.jEg = System.currentTimeMillis();
        C5068w.m7685b(getIntent(), "key_auto_login_wizard_exit", true);
        super.onCreate(bundle);
        AppMethodBeat.m2505o(18221);
    }

    /* renamed from: O */
    public final boolean mo6736O(Intent intent) {
        return true;
    }

    /* renamed from: a */
    public final void mo6737a(C4737a c4737a, Intent intent) {
        boolean z = true;
        AppMethodBeat.m2504i(18222);
        if (intent == null) {
            finish();
            AppMethodBeat.m2505o(18222);
            return;
        }
        C4990ab.m7416i("MicroMsg.WXPayEntryActivity", "postLogin, delegate intent to OrderHandlerUI, resultCode = ".concat(String.valueOf(c4737a)));
        switch (c4737a) {
            case LOGIN_OK:
                C4990ab.m7417i("MicroMsg.WXPayEntryActivity", "coreaccount st %s", Boolean.valueOf(C1668a.m3393QT()));
                if (C1668a.m3393QT()) {
                    finish();
                    AppMethodBeat.m2505o(18222);
                    return;
                }
                break;
            case LOGIN_CANCEL:
                m84558rN(-2);
                C4990ab.m7412e("MicroMsg.WXPayEntryActivity", "postLogin fail, loginResult = ".concat(String.valueOf(c4737a)));
                finish();
                AppMethodBeat.m2505o(18222);
                return;
            case LOGIN_FAIL:
                m84558rN(-1);
                C4990ab.m7412e("MicroMsg.WXPayEntryActivity", "postLogin fail, loginResult = ".concat(String.valueOf(c4737a)));
                finish();
                AppMethodBeat.m2505o(18222);
                return;
            default:
                C4990ab.m7412e("MicroMsg.WXPayEntryActivity", "postLogin, unknown login result = ".concat(String.valueOf(c4737a)));
                break;
        }
        this.fOs = C5068w.m7689n(intent, ConstantsAPI.APP_PACKAGE);
        C4990ab.m7416i("MicroMsg.WXPayEntryActivity", "postLogin, getCallingPackage success, value = " + this.fOs);
        if (getIntent() == null || C5068w.m7684aM(getIntent()) == null) {
            z = false;
        } else {
            PayReq payReq = new PayReq();
            payReq.fromBundle(C5068w.m7684aM(getIntent()));
            String str = payReq.appId;
            C4990ab.m7410d("MicroMsg.WXPayEntryActivity", "postLogin, appId = ".concat(String.valueOf(str)));
            if (str == null || str.length() == 0) {
                C4990ab.m7412e("MicroMsg.WXPayEntryActivity", "checkApp fail, appId is null");
                z = false;
            } else {
                C40439f bT = C46494g.m87739bT(str, true);
                if (bT == null) {
                    C4990ab.m7420w("MicroMsg.WXPayEntryActivity", "checkApp fail, not reg");
                    bT = new C40439f();
                    bT.field_appId = str;
                    bT.field_appName = "";
                    bT.field_packageName = this.fOs;
                    bT.field_status = 0;
                    String bw = C35799p.m58690bw(this, this.fOs);
                    if (bw != null) {
                        bT.field_signature = bw;
                    }
                    if (C14877am.bYJ().mo56573n(bT) && C5046bo.isNullOrNil(bT.field_openId)) {
                        C4990ab.m7410d("MicroMsg.WXPayEntryActivity", "checkApp, trigger getAppSetting, appId = ".concat(String.valueOf(str)));
                        C14877am.bYL().mo9878wy(str);
                    }
                } else if (bT.field_status == 3) {
                    C4990ab.m7412e("MicroMsg.WXPayEntryActivity", "checkApp fail, app is in blacklist");
                    z = false;
                } else if (!C35799p.m58686a(this, bT, this.fOs, true)) {
                    WXPayEntryActivity.m84557a(this, bT, this.fOs);
                    C4990ab.m7412e("MicroMsg.WXPayEntryActivity", "checkApp fail, app invalid");
                    z = false;
                }
            }
        }
        if (!z) {
            C4990ab.m7412e("MicroMsg.WXPayEntryActivity", "postLogin, checkApp fail");
        }
        try {
            intent.putExtra("key_scene", 0);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.IntentUtil", e, "", new Object[0]);
        }
        Bundle aM = C5068w.m7684aM(intent);
        aM.putLong("wallet_pay_key_check_time", this.jEg);
        C35899h.m58852a((Context) this, aM, z, "");
        finish();
        AppMethodBeat.m2505o(18222);
    }

    /* renamed from: a */
    private static void m84557a(Context context, C40439f c40439f, String str) {
        AppMethodBeat.m2504i(18223);
        Signature[] bx = C35799p.m58691bx(context, str);
        Object obj = "";
        if (bx != null && bx.length > 0) {
            for (Signature toByteArray : bx) {
                obj = obj + C35800q.aiQ(C1178g.m2591x(toByteArray.toByteArray())) + "|";
            }
        }
        if (obj.length() > 1) {
            obj = obj.substring(0, obj.length() - 1);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("raw_package_name", C5046bo.m7532bc(str, ""));
            jSONObject.put("package_name", C5046bo.m7532bc(c40439f.field_packageName, ""));
            jSONObject.put("raw_signature", obj);
            jSONObject.put("signature", C5046bo.m7532bc(c40439f.field_signature, ""));
            jSONObject.put("scene", 5);
        } catch (Exception e) {
            C4990ab.m7416i("MicroMsg.WXPayEntryActivity", "doIfAppInValid, jsonException = " + e.getMessage());
        }
        C41999hc c41999hc = new C41999hc();
        c41999hc.cBN.appId = c40439f.field_appId;
        c41999hc.cBN.opType = 3;
        c41999hc.cBN.cvq = jSONObject.toString();
        C4879a.xxA.mo10055m(c41999hc);
        AppMethodBeat.m2505o(18223);
    }

    /* renamed from: rN */
    private void m84558rN(int i) {
        AppMethodBeat.m2504i(18224);
        PayReq payReq = new PayReq();
        payReq.fromBundle(C5068w.m7684aM(getIntent()));
        Options options = new Options();
        options.fromBundle(C5068w.m7684aM(getIntent()));
        PayResp payResp = new PayResp();
        payResp.prepayId = payReq.prepayId;
        payResp.extData = payReq.extData;
        payResp.errCode = i;
        C4488e.m6863a(this, C5068w.m7689n(getIntent(), ConstantsAPI.APP_PACKAGE), payResp, options);
        AppMethodBeat.m2505o(18224);
    }
}
