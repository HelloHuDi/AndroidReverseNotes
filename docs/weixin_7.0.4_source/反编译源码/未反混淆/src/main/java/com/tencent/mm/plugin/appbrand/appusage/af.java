package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.sdk.e.g;
import java.util.List;

@e(c.class)
public interface af extends com.tencent.mm.kernel.c.a, g {

    public enum a {
        DESC,
        ASC,
        UPATE_TIME_DESC;

        static {
            AppMethodBeat.o(114907);
        }
    }

    List<LocalUsageInfo> a(int i, a aVar);

    boolean aB(String str, int i);

    int aC(String str, int i);

    boolean aD(String str, int i);

    void awX();

    int awY();

    boolean g(List<LocalUsageInfo> list, int i);

    int getCount();
}
