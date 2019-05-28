package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import com.tencent.mm.plugin.appbrand.t.e.h;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

public interface d {
    public static final ArrayList<e> ich = new ArrayList();

    public interface a {
        void BB(String str);

        void K(int i, String str);

        void a(com.tencent.mm.plugin.appbrand.t.e.a aVar);

        void b(h hVar);

        void l(ByteBuffer byteBuffer);

        void zJ(String str);

        void zK(String str);
    }

    e BS(String str);

    void a(e eVar);

    void a(e eVar, int i, String str);

    void a(e eVar, String str);

    void a(e eVar, ByteBuffer byteBuffer);

    void a(String str, String str2, int i, int i2, JSONObject jSONObject, Map<String, String> map, a aVar);

    boolean b(e eVar);

    void release();
}
