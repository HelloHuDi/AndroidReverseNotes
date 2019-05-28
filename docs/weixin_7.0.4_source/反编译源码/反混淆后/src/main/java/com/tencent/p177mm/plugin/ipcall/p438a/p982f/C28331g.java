package com.tencent.p177mm.plugin.ipcall.p438a.p982f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.plugin.ipcall.p438a.p1274a.C43218a;
import com.tencent.p177mm.plugin.ipcall.p438a.p1274a.C43219c;
import com.tencent.p177mm.plugin.ipcall.p438a.p732d.C34374l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.ipcall.a.f.g */
public final class C28331g extends C43218a {
    public final int[] bHC() {
        return new int[]{227};
    }

    public final int getServiceType() {
        return 7;
    }

    /* renamed from: wO */
    public final void mo24092wO() {
    }

    public final void onDestroy() {
    }

    /* renamed from: b */
    public final void mo24088b(C43219c c43219c) {
        AppMethodBeat.m2504i(21909);
        if (c43219c != null) {
            C9638aw.m17182Rg().mo14541a(new C34374l(c43219c.nwu, c43219c.nww, c43219c.nwZ), 0);
            C4990ab.m7417i("MicroMsg.IPCallReportService", "start report, roomid: %d, callseq: %d, isAccept: %b", Integer.valueOf(c43219c.nwu), Long.valueOf(c43219c.nww), Boolean.valueOf(c43219c.nwZ));
        }
        AppMethodBeat.m2505o(21909);
    }
}
