package com.tencent.p177mm.plugin.appbrand.jsapi.p314q;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.q.d */
public class C16674d extends C10296a {
    public static final int CTRL_INDEX = 39;
    public static final String NAME = "getNetworkType";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.q.d$a */
    public enum C16675a {
        None("none"),
        Mobile_2g("2g"),
        Mobile_3g("3g"),
        Mobile_4g("4g"),
        Wifi("wifi"),
        Unknown("unknown");
        
        public final String value;

        static {
            AppMethodBeat.m2505o(126409);
        }

        private C16675a(String str) {
            this.value = str;
        }
    }

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(126410);
        HashMap hashMap = new HashMap();
        hashMap.put("networkType", mo30644v(c2241c).value);
        c2241c.mo6107M(i, mo73394j("ok", hashMap));
        AppMethodBeat.m2505o(126410);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: v */
    public C16675a mo30644v(C2241c c2241c) {
        AppMethodBeat.m2504i(126411);
        C16675a cK = C16674d.m25680cK(c2241c.getContext());
        AppMethodBeat.m2505o(126411);
        return cK;
    }

    /* renamed from: cK */
    public static C16675a m25680cK(Context context) {
        AppMethodBeat.m2504i(126412);
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            C16675a c16675a;
            if (connectivityManager == null) {
                c16675a = C16675a.Unknown;
                AppMethodBeat.m2505o(126412);
                return c16675a;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                c16675a = C16675a.None;
                AppMethodBeat.m2505o(126412);
                return c16675a;
            } else if (activeNetworkInfo.getType() == 1) {
                c16675a = C16675a.Wifi;
                AppMethodBeat.m2505o(126412);
                return c16675a;
            } else if (activeNetworkInfo.getSubtype() == 2 || activeNetworkInfo.getSubtype() == 1 || activeNetworkInfo.getSubtype() == 4) {
                c16675a = C16675a.Mobile_2g;
                AppMethodBeat.m2505o(126412);
                return c16675a;
            } else if (activeNetworkInfo.getSubtype() < 5 || activeNetworkInfo.getSubtype() >= 13) {
                if (activeNetworkInfo.getSubtype() >= 13) {
                    c16675a = C16675a.Mobile_4g;
                    AppMethodBeat.m2505o(126412);
                    return c16675a;
                }
                c16675a = C16675a.Unknown;
                AppMethodBeat.m2505o(126412);
                return c16675a;
            } else {
                c16675a = C16675a.Mobile_3g;
                AppMethodBeat.m2505o(126412);
                return c16675a;
            }
        } catch (Exception e) {
            C45124d.printErrStackTrace("MicroMsg.JsApiGetNetworkType", e, "", new Object[0]);
        }
    }
}
