package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C26942j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.view.C31128d;
import org.json.JSONObject;

@TargetApi(18)
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.e */
public final class C19334e extends C10296a {
    private static final int CTRL_INDEX = 174;
    private static final String NAME = "closeBluetoothAdapter";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(94183);
        C42484c.m75254kT(116);
        C4990ab.m7417i("MicroMsg.JsApiCloseBluetoothAdapter", "appId:%s closeBluetoothAdapter!", c2241c.getAppId());
        C26942j AU = C42483a.m75251AU(r0);
        C4990ab.m7417i("MicroMsg.JsApiCloseBluetoothAdapter", "result:%s", AU);
        switch (AU.errCode) {
            case 0:
                c2241c.mo6107M(i, mo73394j("ok", null));
                C42484c.m75254kT(C31128d.MIC_ALPHA_ADJUST_REAL);
                AppMethodBeat.m2505o(94183);
                return;
            default:
                c2241c.mo6107M(i, mo73394j(AU.aIm, null));
                C42484c.m75254kT(118);
                AppMethodBeat.m2505o(94183);
                return;
        }
    }
}
