package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.mm.plugin.appbrand.d;
import org.json.JSONObject;

public interface c {

    public interface b {
        void cancel();

        void proceed();
    }

    public static class a {
        public String businessType;
        public int cOq;
        public String cOr;
        public String cst;
        public int cvp;
        public String hQF;
        public String hgS;
        public int scene;
    }

    public interface c {
        void dY(boolean z);
    }

    void a(d dVar, String str, int i, String str2, a aVar, JSONObject jSONObject, JSONObject jSONObject2, c cVar);
}
