package com.tencent.p177mm.plugin.webview.luggage.p1420c;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.ipcinvoker.type.IPCString;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.p177mm.plugin.webview.modeltools.C29833g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.c.c */
public final class C29782c {

    /* renamed from: com.tencent.mm.plugin.webview.luggage.c.c$a */
    static class C29783a implements C45413i<IPCString, WebViewJSSDKFileItem> {
        private C29783a() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(6502);
            WebViewJSSDKFileItem aex = C29833g.cYF().aex(((IPCString) obj).value);
            AppMethodBeat.m2505o(6502);
            return aex;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.c.c$b */
    public static class C29784b implements C45413i<Bundle, Bundle> {
        private C29784b() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(6503);
            Bundle bundle = new Bundle();
            bundle.putBoolean("has_set_uin", C1720g.m3531RK());
            AppMethodBeat.m2505o(6503);
            return bundle;
        }
    }

    public static void runOnUiThread(Runnable runnable) {
        AppMethodBeat.m2504i(6504);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            C5004al.m7441d(runnable);
            AppMethodBeat.m2505o(6504);
            return;
        }
        runnable.run();
        AppMethodBeat.m2505o(6504);
    }

    /* renamed from: AI */
    public static JSONObject m47225AI(String str) {
        AppMethodBeat.m2504i(6505);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(6505);
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            AppMethodBeat.m2505o(6505);
            return jSONObject;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.LuggageWebViewUtil", e.getMessage());
            AppMethodBeat.m2505o(6505);
            return null;
        }
    }

    public static WebViewJSSDKFileItem aeo(String str) {
        AppMethodBeat.m2504i(6506);
        WebViewJSSDKFileItem aex;
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.LuggageWebViewUtil", "get by local id error, local id is null or nil");
            AppMethodBeat.m2505o(6506);
            return null;
        } else if (C4996ah.bqo()) {
            aex = C29833g.cYF().aex(str);
            AppMethodBeat.m2505o(6506);
            return aex;
        } else {
            aex = (WebViewJSSDKFileItem) C9549f.m17010a("com.tencent.mm", new IPCString(str), C29783a.class);
            AppMethodBeat.m2505o(6506);
            return aex;
        }
    }
}
