package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.l */
public final class C10448l {
    private final C33295d hwa;
    private int hwb = 0;
    ConcurrentHashMap<Integer, String> hwc = new ConcurrentHashMap();

    public C10448l(C33295d c33295d) {
        AppMethodBeat.m2504i(91027);
        this.hwa = c33295d;
        AppMethodBeat.m2505o(91027);
    }

    @JavascriptInterface
    public final void publishHandler(String str, String str2, String str3) {
        AppMethodBeat.m2504i(91028);
        try {
            this.hwa.mo6109a(str, str2, C10448l.m18179zL(str3));
            AppMethodBeat.m2505o(91028);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandJSInterface", e, "publishHandler", new Object[0]);
            AppMethodBeat.m2505o(91028);
            throw e;
        }
    }

    @JavascriptInterface
    public final String invokeHandler(String str, String str2, int i) {
        AppMethodBeat.m2504i(91029);
        try {
            String n = this.hwa.mo53814n(str, str2, i);
            AppMethodBeat.m2505o(91029);
            return n;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandJSInterface", e, "invokeHandler", new Object[0]);
            AppMethodBeat.m2505o(91029);
            throw e;
        }
    }

    @JavascriptInterface
    public final String retrieveEvent(int i) {
        AppMethodBeat.m2504i(91030);
        String str = (String) this.hwc.get(Integer.valueOf(i));
        this.hwc.remove(Integer.valueOf(i));
        if (str == null) {
            str = "";
            AppMethodBeat.m2505o(91030);
            return str;
        }
        AppMethodBeat.m2505o(91030);
        return str;
    }

    @JavascriptInterface
    public final boolean isDebugPackage() {
        AppMethodBeat.m2504i(91031);
        boolean dnO = C4872b.dnO();
        AppMethodBeat.m2505o(91031);
        return dnO;
    }

    /* renamed from: zL */
    private static int[] m18179zL(String str) {
        int i = 0;
        AppMethodBeat.m2504i(91032);
        int[] iArr = new int[0];
        try {
            JSONArray jSONArray = new JSONArray(str);
            iArr = new int[jSONArray.length()];
            while (i < jSONArray.length()) {
                iArr[i] = jSONArray.getInt(i);
                i++;
            }
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.AppBrandJSInterface", e.getMessage());
        }
        AppMethodBeat.m2505o(91032);
        return iArr;
    }
}
