package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class y {

    public enum a {
        NONE,
        MISSING_PKG,
        NO_USE_RECENT,
        INVALID_FIELDS,
        VERSION_NOT_FOUND,
        PATH_NOT_FOUND,
        CMD_UPDATE_VERSION,
        ATTRS_NOT_FOUND;

        static {
            AppMethodBeat.o(131905);
        }
    }

    public enum b {
        SYNC_GET_ATTRS(20),
        SYNC_LAUNCH(21),
        GET_DOWNLOAD_URL(22);
        
        final int hsh;

        static {
            AppMethodBeat.o(131908);
        }

        private b(int i) {
            this.hsh = i;
        }
    }

    static void a(b bVar, String str, int i, int i2, int i3, long j) {
        AppMethodBeat.i(131909);
        int Dw = c.Dw(str);
        ab.d("MicroMsg.AppBrand.LaunchStepCostReporter", "report %s | %s | %d | %d | %d", bVar.name(), str, Long.valueOf(j), Integer.valueOf(Dw), Integer.valueOf(0));
        h.pYm.e(13886, str, Integer.valueOf(i), Integer.valueOf(i2 + 1), Integer.valueOf(bVar.hsh), "", "", Long.valueOf(j), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(Dw), Integer.valueOf(0));
        AppMethodBeat.o(131909);
    }
}
