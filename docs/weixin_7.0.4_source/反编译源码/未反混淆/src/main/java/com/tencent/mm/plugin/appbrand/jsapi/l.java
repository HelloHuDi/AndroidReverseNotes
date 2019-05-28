package com.tencent.mm.plugin.appbrand.jsapi;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

public final class l {
    private final d hwa;
    private int hwb = 0;
    ConcurrentHashMap<Integer, String> hwc = new ConcurrentHashMap();

    public l(d dVar) {
        AppMethodBeat.i(91027);
        this.hwa = dVar;
        AppMethodBeat.o(91027);
    }

    @JavascriptInterface
    public final void publishHandler(String str, String str2, String str3) {
        AppMethodBeat.i(91028);
        try {
            this.hwa.a(str, str2, zL(str3));
            AppMethodBeat.o(91028);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AppBrandJSInterface", e, "publishHandler", new Object[0]);
            AppMethodBeat.o(91028);
            throw e;
        }
    }

    @JavascriptInterface
    public final String invokeHandler(String str, String str2, int i) {
        AppMethodBeat.i(91029);
        try {
            String n = this.hwa.n(str, str2, i);
            AppMethodBeat.o(91029);
            return n;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AppBrandJSInterface", e, "invokeHandler", new Object[0]);
            AppMethodBeat.o(91029);
            throw e;
        }
    }

    @JavascriptInterface
    public final String retrieveEvent(int i) {
        AppMethodBeat.i(91030);
        String str = (String) this.hwc.get(Integer.valueOf(i));
        this.hwc.remove(Integer.valueOf(i));
        if (str == null) {
            str = "";
            AppMethodBeat.o(91030);
            return str;
        }
        AppMethodBeat.o(91030);
        return str;
    }

    @JavascriptInterface
    public final boolean isDebugPackage() {
        AppMethodBeat.i(91031);
        boolean dnO = b.dnO();
        AppMethodBeat.o(91031);
        return dnO;
    }

    private static int[] zL(String str) {
        int i = 0;
        AppMethodBeat.i(91032);
        int[] iArr = new int[0];
        try {
            JSONArray jSONArray = new JSONArray(str);
            iArr = new int[jSONArray.length()];
            while (i < jSONArray.length()) {
                iArr[i] = jSONArray.getInt(i);
                i++;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrandJSInterface", e.getMessage());
        }
        AppMethodBeat.o(91032);
        return iArr;
    }
}
