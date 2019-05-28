package com.tencent.p177mm.p612ui.chatting;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI;
import com.tencent.p177mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.p177mm.opensdk.modelmsg.ShowMessageFromWX.Resp;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.pluginsdk.model.app.C14875aj;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.p603e.C4934l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.ui.chatting.as */
public final class C15584as implements C30457ab {
    private static C4934l<C30457ab, Bundle> yMP = new C155851();
    private Context context;
    private final Map<String, Req> yMS = new HashMap();

    /* renamed from: com.tencent.mm.ui.chatting.as$1 */
    static class C155851 extends C4934l<C30457ab, Bundle> {
        C155851() {
        }

        /* renamed from: w */
        public final /* synthetic */ void mo10134w(Object obj, Object obj2) {
            AppMethodBeat.m2504i(31086);
            ((C30457ab) obj).mo27754ay((Bundle) obj2);
            AppMethodBeat.m2505o(31086);
        }
    }

    static {
        AppMethodBeat.m2504i(31094);
        AppMethodBeat.m2505o(31094);
    }

    public C15584as(Context context) {
        AppMethodBeat.m2504i(31089);
        this.context = context;
        AppMethodBeat.m2505o(31089);
    }

    /* renamed from: az */
    public static void m23881az(Bundle bundle) {
        AppMethodBeat.m2504i(31090);
        yMP.mo10126cF(bundle);
        yMP.doNotify();
        AppMethodBeat.m2505o(31090);
    }

    /* renamed from: ay */
    public final void mo27754ay(Bundle bundle) {
        AppMethodBeat.m2504i(31091);
        C4990ab.m7410d("MicroMsg.WXAppMessageShower", "handleResp, appid = ".concat(String.valueOf(Uri.parse(bundle.getString(ConstantsAPI.CONTENT)).getQueryParameter("appid"))));
        Resp resp = new Resp(bundle);
        C4990ab.m7416i("MicroMsg.WXAppMessageShower", "handleResp, errCode = " + resp.errCode + ", type = " + resp.getType());
        if (((Req) this.yMS.get(resp.transaction)) == null) {
            C4990ab.m7412e("MicroMsg.WXAppMessageShower", "invalid resp, check transaction failed, transaction=" + resp.transaction);
            AppMethodBeat.m2505o(31091);
            return;
        }
        this.yMS.remove(resp.transaction);
        AppMethodBeat.m2505o(31091);
    }

    /* renamed from: a */
    public final void mo27752a(String str, WXMediaMessage wXMediaMessage, String str2, String str3) {
        AppMethodBeat.m2504i(31092);
        mo27753a(str, wXMediaMessage, str2, str3, null);
        AppMethodBeat.m2505o(31092);
    }

    /* renamed from: a */
    public final void mo27753a(String str, WXMediaMessage wXMediaMessage, String str2, String str3, C14875aj c14875aj) {
        AppMethodBeat.m2504i(31093);
        C4990ab.m7411d("MicroMsg.WXAppMessageShower", "request pkg = %s, openId = %s", str, str3);
        final WXMediaMessage wXMediaMessage2 = wXMediaMessage;
        final String str4 = str3;
        final String str5 = str;
        final String str6 = str2;
        final C14875aj c14875aj2 = c14875aj;
        C26006a.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(31088);
                final Req c = C46494g.m87740c(C15584as.this.context, wXMediaMessage2, str4);
                C46494g.m87729a(C15584as.this.context, str5, str6, c, 0, new C14875aj() {
                    /* renamed from: dR */
                    public final void mo6036dR(boolean z) {
                        AppMethodBeat.m2504i(31087);
                        if (z) {
                            C15584as.this.yMS.put(c.transaction, c);
                        }
                        if (c14875aj2 != null) {
                            c14875aj2.mo6036dR(z);
                        }
                        AppMethodBeat.m2505o(31087);
                    }
                }, null);
                AppMethodBeat.m2505o(31088);
            }
        });
        AppMethodBeat.m2505o(31093);
    }
}
