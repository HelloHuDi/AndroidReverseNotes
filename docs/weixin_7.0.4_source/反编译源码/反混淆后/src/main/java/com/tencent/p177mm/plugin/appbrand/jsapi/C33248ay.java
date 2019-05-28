package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ay */
public final class C33248ay extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 434;
    public static final String NAME = "openQRCode";
    private static volatile boolean hyh = false;

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(73154);
        final C38492q c38492q = (C38492q) c2241c;
        if (hyh) {
            c38492q.mo6107M(i, mo73394j("cancel", null));
            AppMethodBeat.m2505o(73154);
            return;
        }
        hyh = true;
        C4990ab.m7417i("MicroMsg.JsApiOpenQRCode", "openQRCode data::%s", jSONObject);
        Context context = (MMActivity) c38492q.mo61197ad(MMActivity.class);
        if (context == null) {
            hyh = false;
            C4990ab.m7412e("MicroMsg.JsApiOpenQRCode", "pageContext is null, err");
            c38492q.mo6107M(i, mo73394j("fail:context is err", null));
            AppMethodBeat.m2505o(73154);
            return;
        }
        boolean z;
        boolean z2;
        int i2;
        jSONObject.optString("desc");
        int i3 = C5046bo.getInt(jSONObject.optString("needResult"), 1);
        String optString = jSONObject.optString("scanType");
        if (C5046bo.isNullOrNil(optString)) {
            z = true;
            z2 = true;
        } else {
            z = false;
            z2 = false;
        }
        if (optString != null) {
            try {
                JSONArray jSONArray = new JSONArray(optString);
                int i4 = 0;
                while (i4 < jSONArray.length()) {
                    boolean z3;
                    optString = (String) jSONArray.get(i4);
                    if (optString.equalsIgnoreCase("qrCode")) {
                        z3 = z;
                        z2 = true;
                    } else if (optString.equalsIgnoreCase("barCode")) {
                        z3 = true;
                    } else {
                        z3 = z;
                    }
                    i4++;
                    z = z3;
                }
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.JsApiOpenQRCode", "doScanQRCode, ex in scanType");
            }
        }
        if (z2 && !r2) {
            i2 = 8;
        } else if (z2 || !r2) {
            i2 = 1;
        } else {
            i2 = 4;
        }
        context.ifE = new C5186a() {
            /* renamed from: c */
            public final void mo6069c(int i, int i2, Intent intent) {
                AppMethodBeat.m2504i(73153);
                C33248ay.hyh = false;
                if (i != (C33248ay.this.hashCode() & CdnLogic.kBizGeneric)) {
                    AppMethodBeat.m2505o(73153);
                    return;
                }
                C4990ab.m7417i("MicroMsg.JsApiOpenQRCode", "onActivityResult requestCode:%d  resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
                switch (i2) {
                    case -1:
                        if (intent == null) {
                            C4990ab.m7412e("MicroMsg.JsApiOpenQRCode", "data is null, err");
                            c38492q.mo6107M(i, C33248ay.this.mo73394j("fail:unknown err", null));
                            AppMethodBeat.m2505o(73153);
                            return;
                        }
                        HashMap hashMap = new HashMap();
                        C4990ab.m7411d("MicroMsg.JsApiOpenQRCode", "result:%s, resultType:%d", intent.getStringExtra("key_scan_result"), Integer.valueOf(intent.getIntExtra("key_scan_result_type", 0)));
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("scan_type", intent.getIntExtra("key_scan_result_type", 0) == 1 ? "qrcode" : "barcode");
                            jSONObject.put("scan_result", r2);
                        } catch (JSONException e) {
                            C4990ab.printErrStackTrace("MicroMsg.JsApiOpenQRCode", e, "", new Object[0]);
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("scan_code", jSONObject);
                        } catch (JSONException e2) {
                            C4990ab.printErrStackTrace("MicroMsg.JsApiOpenQRCode", e2, "", new Object[0]);
                        }
                        hashMap.put("resultStr", jSONObject2.toString());
                        C4990ab.m7411d("MicroMsg.JsApiOpenQRCode", "ret:%s", hashMap);
                        c38492q.mo6107M(i, C33248ay.this.mo73394j("ok", hashMap));
                        AppMethodBeat.m2505o(73153);
                        return;
                    case 0:
                        c38492q.mo6107M(i, C33248ay.this.mo73394j("cancel", null));
                        AppMethodBeat.m2505o(73153);
                        return;
                    default:
                        c38492q.mo6107M(i, C33248ay.this.mo73394j("fail", null));
                        AppMethodBeat.m2505o(73153);
                        return;
                }
            }
        };
        if (i3 == 0) {
            C4990ab.m7416i("MicroMsg.JsApiOpenQRCode", "doScanQRCode, startActivity");
            Intent intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", i2);
            C25985d.m41472c(context, "scanner", ".ui.SingleTopScanUI", intent);
            hyh = false;
            c38492q.mo6107M(i, mo73394j("ok", null));
            AppMethodBeat.m2505o(73154);
        } else if (i3 == 1) {
            C4990ab.m7411d("MicroMsg.JsApiOpenQRCode", "doScanQRCode, startActivityForResult requestCode:%d", Integer.valueOf(hashCode()));
            Intent intent2 = new Intent();
            intent2.putExtra("BaseScanUI_select_scan_mode", i2);
            intent2.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
            intent2.putExtra("key_is_finish_on_scanned", true);
            intent2.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 3);
            C25985d.m41453a(context, "scanner", ".ui.SingleTopScanUI", intent2, hashCode() & CdnLogic.kBizGeneric, false);
            AppMethodBeat.m2505o(73154);
        } else {
            C4990ab.m7412e("MicroMsg.JsApiOpenQRCode", "needResult is err");
            c38492q.mo6107M(i, mo73394j("fail:invalid data", null));
            AppMethodBeat.m2505o(73154);
        }
    }
}
