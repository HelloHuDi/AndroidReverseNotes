package com.tencent.p177mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.y */
final class C33438y {

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.y$a */
    public enum C33437a {
        NONE,
        MISSING_PKG,
        NO_USE_RECENT,
        INVALID_FIELDS,
        VERSION_NOT_FOUND,
        PATH_NOT_FOUND,
        CMD_UPDATE_VERSION,
        ATTRS_NOT_FOUND;

        static {
            AppMethodBeat.m2505o(131905);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.y$b */
    public enum C33439b {
        SYNC_GET_ATTRS(20),
        SYNC_LAUNCH(21),
        GET_DOWNLOAD_URL(22);
        
        final int hsh;

        static {
            AppMethodBeat.m2505o(131908);
        }

        private C33439b(int i) {
            this.hsh = i;
        }
    }

    /* renamed from: a */
    static void m54643a(C33439b c33439b, String str, int i, int i2, int i3, long j) {
        AppMethodBeat.m2504i(131909);
        int Dw = C19690c.m30493Dw(str);
        C4990ab.m7411d("MicroMsg.AppBrand.LaunchStepCostReporter", "report %s | %s | %d | %d | %d", c33439b.name(), str, Long.valueOf(j), Integer.valueOf(Dw), Integer.valueOf(0));
        C7060h.pYm.mo8381e(13886, str, Integer.valueOf(i), Integer.valueOf(i2 + 1), Integer.valueOf(c33439b.hsh), "", "", Long.valueOf(j), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(Dw), Integer.valueOf(0));
        AppMethodBeat.m2505o(131909);
    }
}
