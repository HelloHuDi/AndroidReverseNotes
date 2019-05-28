package com.tencent.p177mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.p177mm.plugin.appbrand.C2119d;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c */
public interface C2320c {

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c$b */
    public interface C2321b {
        void cancel();

        void proceed();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c$a */
    public static class C2322a {
        public String businessType;
        public int cOq;
        public String cOr;
        public String cst;
        public int cvp;
        public String hQF;
        public String hgS;
        public int scene;
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c$c */
    public interface C2323c {
        /* renamed from: dY */
        void mo6193dY(boolean z);
    }

    /* renamed from: a */
    void mo6194a(C2119d c2119d, String str, int i, String str2, C2322a c2322a, JSONObject jSONObject, JSONObject jSONObject2, C2323c c2323c);
}
