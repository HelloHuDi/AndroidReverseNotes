package com.tencent.mm.plugin.cdndownloader.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class c extends j<a> {
    public static final String[] fnj = new String[]{j.a(a.ccO, "CdnDownloadInfo")};

    static {
        AppMethodBeat.i(963);
        AppMethodBeat.o(963);
    }

    public c(e eVar) {
        super(eVar, a.ccO, "CdnDownloadInfo", null);
    }

    public final boolean HG(String str) {
        AppMethodBeat.i(962);
        boolean hY = hY("CdnDownloadInfo", String.format("delete from %s where %s=%s", new Object[]{"CdnDownloadInfo", "downloadUrlHashCode", Integer.valueOf(str.hashCode())}));
        AppMethodBeat.o(962);
        return hY;
    }
}
