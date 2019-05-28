package com.tencent.p177mm.plugin.appbrand.jsapi.p316t;

import com.tencent.luggage.p1170a.C25681b;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.t.c */
public final class C42583c {

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.t.c$a */
    public interface C19489a extends C25681b {
        /* renamed from: a */
        C42581b mo34612a(C42582c c42582c);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.t.c$b */
    public interface C42581b {
        void cleanup();

        /* renamed from: k */
        void mo44755k(boolean z, int i);

        /* renamed from: wU */
        void mo44757wU();

        /* renamed from: wW */
        void mo44758wW();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.t.c$c */
    public interface C42582c {
        /* renamed from: BV */
        void mo68013BV(String str);

        /* renamed from: BW */
        void mo68014BW(String str);

        /* renamed from: D */
        void mo68015D(JSONObject jSONObject);

        void aGp();

        boolean aGr();

        /* renamed from: bF */
        void mo68018bF(String str);

        String getAppId();

        String[] getJsApiReportArgs();

        MMWebView getWebView();

        /* renamed from: m */
        void mo68022m(String str, int i, String str2);

        void runOnUiThread(Runnable runnable);
    }
}
