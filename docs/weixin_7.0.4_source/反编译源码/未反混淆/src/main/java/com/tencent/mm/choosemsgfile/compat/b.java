package com.tencent.mm.choosemsgfile.compat;

import com.tencent.mm.at.e;
import com.tencent.mm.storage.bi;

public interface b extends com.tencent.mm.kernel.c.a {

    public interface a {
        void bQ(int i, int i2);

        void m(int i, String str);
    }

    public interface b {
        void n(int i, String str);
    }

    com.tencent.mm.vending.e.a a(long j, String str, a aVar);

    String a(bi biVar, e eVar);

    void a(com.tencent.mm.pluginsdk.model.app.b bVar);

    void a(bi biVar, a aVar);

    boolean a(bi biVar, com.tencent.mm.pluginsdk.model.app.b bVar);

    boolean a(String str, bi biVar, b bVar);

    boolean c(bi biVar);

    e d(bi biVar);

    String e(bi biVar);

    boolean f(bi biVar);

    com.tencent.mm.pluginsdk.model.app.b i(String str, long j);
}
