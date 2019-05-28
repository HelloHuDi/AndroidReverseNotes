package com.tencent.p177mm.plugin.appbrand.jsapi.websocket;

import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C16696h;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C38514a;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.websocket.d */
public interface C10562d {
    public static final ArrayList<C27135e> ich = new ArrayList();

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.websocket.d$a */
    public interface C10563a {
        /* renamed from: BB */
        void mo22064BB(String str);

        /* renamed from: K */
        void mo22065K(int i, String str);

        /* renamed from: a */
        void mo22066a(C38514a c38514a);

        /* renamed from: b */
        void mo22067b(C16696h c16696h);

        /* renamed from: l */
        void mo22068l(ByteBuffer byteBuffer);

        /* renamed from: zJ */
        void mo22069zJ(String str);

        /* renamed from: zK */
        void mo22070zK(String str);
    }

    /* renamed from: BS */
    C27135e mo22056BS(String str);

    /* renamed from: a */
    void mo22057a(C27135e c27135e);

    /* renamed from: a */
    void mo22058a(C27135e c27135e, int i, String str);

    /* renamed from: a */
    void mo22059a(C27135e c27135e, String str);

    /* renamed from: a */
    void mo22060a(C27135e c27135e, ByteBuffer byteBuffer);

    /* renamed from: a */
    void mo22061a(String str, String str2, int i, int i2, JSONObject jSONObject, Map<String, String> map, C10563a c10563a);

    /* renamed from: b */
    boolean mo22062b(C27135e c27135e);

    void release();
}
