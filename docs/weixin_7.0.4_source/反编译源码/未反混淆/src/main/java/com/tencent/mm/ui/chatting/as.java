package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.a;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Resp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.aj;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

public final class as implements ab {
    private static l<ab, Bundle> yMP = new l<ab, Bundle>() {
        public final /* synthetic */ void w(Object obj, Object obj2) {
            AppMethodBeat.i(31086);
            ((ab) obj).ay((Bundle) obj2);
            AppMethodBeat.o(31086);
        }
    };
    private Context context;
    private final Map<String, Req> yMS = new HashMap();

    static {
        AppMethodBeat.i(31094);
        AppMethodBeat.o(31094);
    }

    public as(Context context) {
        AppMethodBeat.i(31089);
        this.context = context;
        AppMethodBeat.o(31089);
    }

    public static void az(Bundle bundle) {
        AppMethodBeat.i(31090);
        yMP.cF(bundle);
        yMP.doNotify();
        AppMethodBeat.o(31090);
    }

    public final void ay(Bundle bundle) {
        AppMethodBeat.i(31091);
        ab.d("MicroMsg.WXAppMessageShower", "handleResp, appid = ".concat(String.valueOf(Uri.parse(bundle.getString(ConstantsAPI.CONTENT)).getQueryParameter("appid"))));
        Resp resp = new Resp(bundle);
        ab.i("MicroMsg.WXAppMessageShower", "handleResp, errCode = " + resp.errCode + ", type = " + resp.getType());
        if (((Req) this.yMS.get(resp.transaction)) == null) {
            ab.e("MicroMsg.WXAppMessageShower", "invalid resp, check transaction failed, transaction=" + resp.transaction);
            AppMethodBeat.o(31091);
            return;
        }
        this.yMS.remove(resp.transaction);
        AppMethodBeat.o(31091);
    }

    public final void a(String str, WXMediaMessage wXMediaMessage, String str2, String str3) {
        AppMethodBeat.i(31092);
        a(str, wXMediaMessage, str2, str3, null);
        AppMethodBeat.o(31092);
    }

    public final void a(String str, WXMediaMessage wXMediaMessage, String str2, String str3, aj ajVar) {
        AppMethodBeat.i(31093);
        ab.d("MicroMsg.WXAppMessageShower", "request pkg = %s, openId = %s", str, str3);
        final WXMediaMessage wXMediaMessage2 = wXMediaMessage;
        final String str4 = str3;
        final String str5 = str;
        final String str6 = str2;
        final aj ajVar2 = ajVar;
        a.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(31088);
                final Req c = g.c(as.this.context, wXMediaMessage2, str4);
                g.a(as.this.context, str5, str6, c, 0, new aj() {
                    public final void dR(boolean z) {
                        AppMethodBeat.i(31087);
                        if (z) {
                            as.this.yMS.put(c.transaction, c);
                        }
                        if (ajVar2 != null) {
                            ajVar2.dR(z);
                        }
                        AppMethodBeat.o(31087);
                    }
                }, null);
                AppMethodBeat.o(31088);
            }
        });
        AppMethodBeat.o(31093);
    }
}
