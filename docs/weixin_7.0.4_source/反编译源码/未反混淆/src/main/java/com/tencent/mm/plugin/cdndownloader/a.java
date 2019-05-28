package com.tencent.mm.plugin.cdndownloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.plugin.cdndownloader.f.c;
import java.util.HashMap;

public final class a implements com.tencent.mm.kernel.api.bucket.a, d, com.tencent.mm.plugin.cdndownloader.b.a {
    private c ksY;

    public final c beQ() {
        return this.ksY;
    }

    public final HashMap<Integer, h.d> collectDatabaseFactory() {
        AppMethodBeat.i(859);
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf("CdnDownloadInfo".hashCode()), new h.d() {
            public final String[] Af() {
                return c.fnj;
            }
        });
        AppMethodBeat.o(859);
        return hashMap;
    }

    public final void onDataBaseOpened(h hVar, h hVar2) {
        AppMethodBeat.i(860);
        this.ksY = new c(hVar);
        AppMethodBeat.o(860);
    }

    public final void onDataBaseClosed(h hVar, h hVar2) {
    }
}
