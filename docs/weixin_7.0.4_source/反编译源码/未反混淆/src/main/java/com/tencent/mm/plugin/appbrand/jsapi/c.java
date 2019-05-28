package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.os.Handler;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.h.i;
import com.tencent.mm.plugin.appbrand.widget.b.k;
import java.util.Map;

public interface c {

    public interface a {
        void AH(String str);

        void proceed();
    }

    public interface b {
        void D(int i, String str);

        void a(ah ahVar, a aVar);

        void a(m mVar, String str, int i, String str2);

        boolean a(m mVar, String str, int i, a aVar);
    }

    <T extends com.tencent.luggage.a.b> T B(Class<T> cls);

    void B(Runnable runnable);

    void M(int i, String str);

    void a(ah ahVar);

    void a(String str, String str2, int[] iArr);

    int aBw();

    i aBx();

    Handler aBy();

    <T extends j> T aa(Class<T> cls);

    com.tencent.mm.plugin.appbrand.b.b asD();

    p asE();

    k asF();

    i aua();

    Map<String, m> aub();

    void b(ah ahVar);

    void bX(String str, String str2);

    String getAppId();

    Context getContext();

    boolean isRunning();
}
