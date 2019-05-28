package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.ae */
public class C29797ae extends C22840bc {
    public final String name() {
        return "openBizChat";
    }

    public final int biG() {
        return 1;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
        AppMethodBeat.m2504i(6338);
        try {
            String optString = new JSONObject(str).optString("username");
            if (C5046bo.isNullOrNil(optString)) {
                c22841a.mo26722d("param_err", null);
                AppMethodBeat.m2505o(6338);
                return;
            }
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(optString);
            if (aoO == null || !aoO.dsf()) {
                c22841a.mo26722d("not biz username", null);
                AppMethodBeat.m2505o(6338);
            } else if (C7486a.m12942jh(aoO.field_type)) {
                Intent intent = new Intent();
                intent.putExtra("Chat_User", optString);
                intent.putExtra("finish_direct", true);
                C25985d.m41473f(context, ".ui.chatting.ChattingUI", intent);
                c22841a.mo26722d(null, null);
                AppMethodBeat.m2505o(6338);
            } else {
                c22841a.mo26722d("open_biz_chat", null);
                AppMethodBeat.m2505o(6338);
            }
        } catch (JSONException e) {
            C4990ab.m7412e("MicroMsg.JsApiOpenBizChat", "parase json fail");
            c22841a.mo26722d("fail", null);
            AppMethodBeat.m2505o(6338);
        }
    }
}
