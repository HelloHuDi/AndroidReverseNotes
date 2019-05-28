package com.tencent.mm.plugin.appbrand.jsapi.t;

import com.tencent.mm.ui.widget.MMWebView;
import org.json.JSONObject;

public final class c {

    public interface a extends com.tencent.luggage.a.b {
        b a(c cVar);
    }

    public interface b {
        void cleanup();

        void k(boolean z, int i);

        void wU();

        void wW();
    }

    public interface c {
        void BV(String str);

        void BW(String str);

        void D(JSONObject jSONObject);

        void aGp();

        boolean aGr();

        void bF(String str);

        String getAppId();

        String[] getJsApiReportArgs();

        MMWebView getWebView();

        void m(String str, int i, String str2);

        void runOnUiThread(Runnable runnable);
    }
}
