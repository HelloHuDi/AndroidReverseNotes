package com.tencent.mm.plugin.expt.a;

import android.app.Activity;
import android.app.Application;

public interface b extends com.tencent.mm.kernel.c.a {

    public interface a {
        void B(Activity activity);

        void C(Activity activity);

        void D(Activity activity);

        void E(Activity activity);

        void KM(String str);

        void ea(String str, String str2);

        void eb(String str, String str2);
    }

    public interface b {
        void a(String str, String str2, int i, long j, int i2);

        void ec(String str, String str2);

        void ed(String str, String str2);
    }

    void a(a aVar);

    void a(b bVar);

    void f(Application application);
}
