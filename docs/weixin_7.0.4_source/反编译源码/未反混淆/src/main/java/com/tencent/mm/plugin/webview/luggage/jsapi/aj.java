package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.luggage.d.a.a;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public class aj extends bd<d> {
    public final String name() {
        return "previewVideo";
    }

    public final int biG() {
        return 0;
    }

    public final void b(final a aVar) {
        AppMethodBeat.i(6348);
        ab.i("MicroMsg.GameJsApiPreviewVideo", "invoke");
        if (bo.isNullOrNil(aVar.bPa.bOf.optString("localId"))) {
            ab.i("MicroMsg.GameJsApiPreviewVideo", "data is invalid");
            aVar.a("invalid_data", null);
            AppMethodBeat.o(6348);
            return;
        }
        WebViewJSSDKFileItem aeo = c.aeo(aVar.bPa.bOf.optString("localId"));
        if (aeo == null || TextUtils.isEmpty(aeo.heo) || !e.ct(aeo.heo)) {
            ab.e("MicroMsg.GameJsApiPreviewVideo", "the item is null or the File item not exist for localId: %s", r0);
            aVar.a("fail", null);
            AppMethodBeat.o(6348);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("key_video_path", aeo.heo);
        final Context context = (MMActivity) ((d) aVar.bOZ).mContext;
        context.ifE = new MMActivity.a() {
            public final void c(int i, int i2, Intent intent) {
                AppMethodBeat.i(6347);
                if (i == (aj.this.hashCode() & CdnLogic.kBizGeneric)) {
                    switch (i2) {
                        case -1:
                            aVar.a("", null);
                            break;
                        case 0:
                            aVar.a("cancel", null);
                            break;
                        default:
                            aVar.a("fail", null);
                            break;
                    }
                    context.ifE = null;
                }
                AppMethodBeat.o(6347);
            }
        };
        com.tencent.mm.bp.d.b(context, "card", ".ui.CardGiftVideoUI", intent, hashCode() & CdnLogic.kBizGeneric);
        AppMethodBeat.o(6348);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
