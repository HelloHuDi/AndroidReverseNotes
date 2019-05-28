package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.os.Handler;
import com.tencent.luggage.p1170a.C25681b;
import com.tencent.p177mm.plugin.appbrand.appstorage.C19092p;
import com.tencent.p177mm.plugin.appbrand.p281b.C45524b;
import com.tencent.p177mm.plugin.appbrand.p297h.C6747i;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C33589k;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.c */
public interface C2241c {

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.c$a */
    public interface C2242a {
        /* renamed from: AH */
        void mo6118AH(String str);

        void proceed();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.c$b */
    public interface C2243b {
        /* renamed from: D */
        void mo6120D(int i, String str);

        /* renamed from: a */
        void mo6121a(C42467ah c42467ah, C2242a c2242a);

        /* renamed from: a */
        void mo6122a(C45608m c45608m, String str, int i, String str2);

        /* renamed from: a */
        boolean mo6123a(C45608m c45608m, String str, int i, C2242a c2242a);
    }

    /* renamed from: B */
    <T extends C25681b> T mo5936B(Class<T> cls);

    /* renamed from: B */
    void mo6106B(Runnable runnable);

    /* renamed from: M */
    void mo6107M(int i, String str);

    /* renamed from: a */
    void mo6108a(C42467ah c42467ah);

    /* renamed from: a */
    void mo6109a(String str, String str2, int[] iArr);

    int aBw();

    C6747i aBx();

    Handler aBy();

    /* renamed from: aa */
    <T extends C10441j> T mo5937aa(Class<T> cls);

    C45524b asD();

    C19092p asE();

    C33589k asF();

    C6747i aua();

    Map<String, C45608m> aub();

    /* renamed from: b */
    void mo6115b(C42467ah c42467ah);

    /* renamed from: bX */
    void mo6116bX(String str, String str2);

    String getAppId();

    Context getContext();

    boolean isRunning();
}
