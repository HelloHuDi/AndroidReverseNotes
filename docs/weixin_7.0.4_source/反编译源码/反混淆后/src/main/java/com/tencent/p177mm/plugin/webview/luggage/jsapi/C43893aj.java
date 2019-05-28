package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.plugin.webview.luggage.p1420c.C29782c;
import com.tencent.p177mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.aj */
public class C43893aj extends C46419bd<C24905d> {
    public final String name() {
        return "previewVideo";
    }

    public final int biG() {
        return 0;
    }

    /* renamed from: b */
    public final void mo9618b(final C32183a c32183a) {
        AppMethodBeat.m2504i(6348);
        C4990ab.m7416i("MicroMsg.GameJsApiPreviewVideo", "invoke");
        if (C5046bo.isNullOrNil(c32183a.bPa.bOf.optString("localId"))) {
            C4990ab.m7416i("MicroMsg.GameJsApiPreviewVideo", "data is invalid");
            c32183a.mo52824a("invalid_data", null);
            AppMethodBeat.m2505o(6348);
            return;
        }
        WebViewJSSDKFileItem aeo = C29782c.aeo(c32183a.bPa.bOf.optString("localId"));
        if (aeo == null || TextUtils.isEmpty(aeo.heo) || !C1173e.m2561ct(aeo.heo)) {
            C4990ab.m7413e("MicroMsg.GameJsApiPreviewVideo", "the item is null or the File item not exist for localId: %s", r0);
            c32183a.mo52824a("fail", null);
            AppMethodBeat.m2505o(6348);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("key_video_path", aeo.heo);
        final Context context = (MMActivity) ((C24905d) c32183a.bOZ).mContext;
        context.ifE = new C5186a() {
            /* renamed from: c */
            public final void mo6069c(int i, int i2, Intent intent) {
                AppMethodBeat.m2504i(6347);
                if (i == (C43893aj.this.hashCode() & CdnLogic.kBizGeneric)) {
                    switch (i2) {
                        case -1:
                            c32183a.mo52824a("", null);
                            break;
                        case 0:
                            c32183a.mo52824a("cancel", null);
                            break;
                        default:
                            c32183a.mo52824a("fail", null);
                            break;
                    }
                    context.ifE = null;
                }
                AppMethodBeat.m2505o(6347);
            }
        };
        C25985d.m41468b(context, "card", ".ui.CardGiftVideoUI", intent, hashCode() & CdnLogic.kBizGeneric);
        AppMethodBeat.m2505o(6348);
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }
}
