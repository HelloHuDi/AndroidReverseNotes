package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;

public final class b implements o {
    public static n gkE;
    public static m gkF;

    public final void a(n nVar) {
        gkE = nVar;
    }

    public final void a(m mVar) {
        gkF = mVar;
    }

    public static void h(int i, Object obj) {
        AppMethodBeat.i(13798);
        String str = "MicroMsg.BrandService.BrandServiceApplication";
        String str2 = "set config, key[%d], value[%s]";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = obj == null ? BuildConfig.COMMAND : obj.toString();
        ab.i(str, str2, objArr);
        g.RQ();
        g.RP().Ry().set(i, obj);
        AppMethodBeat.o(13798);
    }

    public static void a(String str, Runnable runnable, long j) {
        AppMethodBeat.i(13799);
        if (j > 0) {
            d.xDG.b(runnable, str, j);
            AppMethodBeat.o(13799);
            return;
        }
        d.xDG.b(runnable, str);
        AppMethodBeat.o(13799);
    }
}
