package com.tencent.mm.plugin.webview.luggage.c;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class c {

    static class a implements i<IPCString, WebViewJSSDKFileItem> {
        private a() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(6502);
            WebViewJSSDKFileItem aex = g.cYF().aex(((IPCString) obj).value);
            AppMethodBeat.o(6502);
            return aex;
        }
    }

    public static class b implements i<Bundle, Bundle> {
        private b() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(6503);
            Bundle bundle = new Bundle();
            bundle.putBoolean("has_set_uin", com.tencent.mm.kernel.g.RK());
            AppMethodBeat.o(6503);
            return bundle;
        }
    }

    public static void runOnUiThread(Runnable runnable) {
        AppMethodBeat.i(6504);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            al.d(runnable);
            AppMethodBeat.o(6504);
            return;
        }
        runnable.run();
        AppMethodBeat.o(6504);
    }

    public static JSONObject AI(String str) {
        AppMethodBeat.i(6505);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(6505);
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            AppMethodBeat.o(6505);
            return jSONObject;
        } catch (Exception e) {
            ab.e("MicroMsg.LuggageWebViewUtil", e.getMessage());
            AppMethodBeat.o(6505);
            return null;
        }
    }

    public static WebViewJSSDKFileItem aeo(String str) {
        AppMethodBeat.i(6506);
        WebViewJSSDKFileItem aex;
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.LuggageWebViewUtil", "get by local id error, local id is null or nil");
            AppMethodBeat.o(6506);
            return null;
        } else if (ah.bqo()) {
            aex = g.cYF().aex(str);
            AppMethodBeat.o(6506);
            return aex;
        } else {
            aex = (WebViewJSSDKFileItem) f.a("com.tencent.mm", new IPCString(str), a.class);
            AppMethodBeat.o(6506);
            return aex;
        }
    }
}
