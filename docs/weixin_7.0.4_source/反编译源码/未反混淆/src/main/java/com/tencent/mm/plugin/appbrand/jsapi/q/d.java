package com.tencent.mm.plugin.appbrand.jsapi.q;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.HashMap;
import org.json.JSONObject;

public class d extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 39;
    public static final String NAME = "getNetworkType";

    public enum a {
        None("none"),
        Mobile_2g("2g"),
        Mobile_3g("3g"),
        Mobile_4g("4g"),
        Wifi("wifi"),
        Unknown("unknown");
        
        public final String value;

        static {
            AppMethodBeat.o(126409);
        }

        private a(String str) {
            this.value = str;
        }
    }

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(126410);
        HashMap hashMap = new HashMap();
        hashMap.put("networkType", v(cVar).value);
        cVar.M(i, j("ok", hashMap));
        AppMethodBeat.o(126410);
    }

    /* Access modifiers changed, original: protected */
    public a v(c cVar) {
        AppMethodBeat.i(126411);
        a cK = cK(cVar.getContext());
        AppMethodBeat.o(126411);
        return cK;
    }

    public static a cK(Context context) {
        AppMethodBeat.i(126412);
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            a aVar;
            if (connectivityManager == null) {
                aVar = a.Unknown;
                AppMethodBeat.o(126412);
                return aVar;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                aVar = a.None;
                AppMethodBeat.o(126412);
                return aVar;
            } else if (activeNetworkInfo.getType() == 1) {
                aVar = a.Wifi;
                AppMethodBeat.o(126412);
                return aVar;
            } else if (activeNetworkInfo.getSubtype() == 2 || activeNetworkInfo.getSubtype() == 1 || activeNetworkInfo.getSubtype() == 4) {
                aVar = a.Mobile_2g;
                AppMethodBeat.o(126412);
                return aVar;
            } else if (activeNetworkInfo.getSubtype() < 5 || activeNetworkInfo.getSubtype() >= 13) {
                if (activeNetworkInfo.getSubtype() >= 13) {
                    aVar = a.Mobile_4g;
                    AppMethodBeat.o(126412);
                    return aVar;
                }
                aVar = a.Unknown;
                AppMethodBeat.o(126412);
                return aVar;
            } else {
                aVar = a.Mobile_3g;
                AppMethodBeat.o(126412);
                return aVar;
            }
        } catch (Exception e) {
            com.tencent.luggage.g.d.printErrStackTrace("MicroMsg.JsApiGetNetworkType", e, "", new Object[0]);
        }
    }
}
