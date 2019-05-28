package com.tencent.mm.plugin.cdndownloader.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.cdndownloader.b.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.util.VideoFilterUtil;

public final class b {
    public static void a(a aVar) {
        AppMethodBeat.i(959);
        c beQ = beQ();
        if (beQ != null) {
            ab.i("MicroMsg.CdnDownloadInfoDBHelp", "insert: ".concat(String.valueOf(beQ.b((c) aVar))));
        }
        AppMethodBeat.o(959);
    }

    public static void HF(String str) {
        AppMethodBeat.i(VideoFilterUtil.IMAGE_HEIGHT);
        c beQ = beQ();
        if (beQ != null) {
            ab.i("MicroMsg.CdnDownloadInfoDBHelp", "removeDownloadInfoByDownloadUrl: ".concat(String.valueOf(beQ.HG(str))));
        }
        AppMethodBeat.o(VideoFilterUtil.IMAGE_HEIGHT);
    }

    public static c beQ() {
        AppMethodBeat.i(961);
        c beQ = ((a) g.K(a.class)).beQ();
        AppMethodBeat.o(961);
        return beQ;
    }
}
