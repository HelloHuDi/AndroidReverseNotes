package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ay extends a<q> {
    public static final int CTRL_INDEX = 434;
    public static final String NAME = "openQRCode";
    private static volatile boolean hyh = false;

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(73154);
        final q qVar = (q) cVar;
        if (hyh) {
            qVar.M(i, j("cancel", null));
            AppMethodBeat.o(73154);
            return;
        }
        hyh = true;
        ab.i("MicroMsg.JsApiOpenQRCode", "openQRCode data::%s", jSONObject);
        Context context = (MMActivity) qVar.ad(MMActivity.class);
        if (context == null) {
            hyh = false;
            ab.e("MicroMsg.JsApiOpenQRCode", "pageContext is null, err");
            qVar.M(i, j("fail:context is err", null));
            AppMethodBeat.o(73154);
            return;
        }
        boolean z;
        boolean z2;
        int i2;
        jSONObject.optString("desc");
        int i3 = bo.getInt(jSONObject.optString("needResult"), 1);
        String optString = jSONObject.optString("scanType");
        if (bo.isNullOrNil(optString)) {
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
                ab.e("MicroMsg.JsApiOpenQRCode", "doScanQRCode, ex in scanType");
            }
        }
        if (z2 && !r2) {
            i2 = 8;
        } else if (z2 || !r2) {
            i2 = 1;
        } else {
            i2 = 4;
        }
        context.ifE = new a() {
            public final void c(int i, int i2, Intent intent) {
                AppMethodBeat.i(73153);
                ay.hyh = false;
                if (i != (ay.this.hashCode() & CdnLogic.kBizGeneric)) {
                    AppMethodBeat.o(73153);
                    return;
                }
                ab.i("MicroMsg.JsApiOpenQRCode", "onActivityResult requestCode:%d  resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
                switch (i2) {
                    case -1:
                        if (intent == null) {
                            ab.e("MicroMsg.JsApiOpenQRCode", "data is null, err");
                            qVar.M(i, ay.this.j("fail:unknown err", null));
                            AppMethodBeat.o(73153);
                            return;
                        }
                        HashMap hashMap = new HashMap();
                        ab.d("MicroMsg.JsApiOpenQRCode", "result:%s, resultType:%d", intent.getStringExtra("key_scan_result"), Integer.valueOf(intent.getIntExtra("key_scan_result_type", 0)));
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("scan_type", intent.getIntExtra("key_scan_result_type", 0) == 1 ? "qrcode" : "barcode");
                            jSONObject.put("scan_result", r2);
                        } catch (JSONException e) {
                            ab.printErrStackTrace("MicroMsg.JsApiOpenQRCode", e, "", new Object[0]);
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("scan_code", jSONObject);
                        } catch (JSONException e2) {
                            ab.printErrStackTrace("MicroMsg.JsApiOpenQRCode", e2, "", new Object[0]);
                        }
                        hashMap.put("resultStr", jSONObject2.toString());
                        ab.d("MicroMsg.JsApiOpenQRCode", "ret:%s", hashMap);
                        qVar.M(i, ay.this.j("ok", hashMap));
                        AppMethodBeat.o(73153);
                        return;
                    case 0:
                        qVar.M(i, ay.this.j("cancel", null));
                        AppMethodBeat.o(73153);
                        return;
                    default:
                        qVar.M(i, ay.this.j("fail", null));
                        AppMethodBeat.o(73153);
                        return;
                }
            }
        };
        if (i3 == 0) {
            ab.i("MicroMsg.JsApiOpenQRCode", "doScanQRCode, startActivity");
            Intent intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", i2);
            d.c(context, "scanner", ".ui.SingleTopScanUI", intent);
            hyh = false;
            qVar.M(i, j("ok", null));
            AppMethodBeat.o(73154);
        } else if (i3 == 1) {
            ab.d("MicroMsg.JsApiOpenQRCode", "doScanQRCode, startActivityForResult requestCode:%d", Integer.valueOf(hashCode()));
            Intent intent2 = new Intent();
            intent2.putExtra("BaseScanUI_select_scan_mode", i2);
            intent2.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
            intent2.putExtra("key_is_finish_on_scanned", true);
            intent2.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 3);
            d.a(context, "scanner", ".ui.SingleTopScanUI", intent2, hashCode() & CdnLogic.kBizGeneric, false);
            AppMethodBeat.o(73154);
        } else {
            ab.e("MicroMsg.JsApiOpenQRCode", "needResult is err");
            qVar.M(i, j("fail:invalid data", null));
            AppMethodBeat.o(73154);
        }
    }
}
