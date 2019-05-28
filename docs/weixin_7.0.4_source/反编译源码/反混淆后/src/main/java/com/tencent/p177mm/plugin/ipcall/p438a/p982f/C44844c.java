package com.tencent.p177mm.plugin.ipcall.p438a.p982f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.plugin.ipcall.p438a.p1274a.C43219c;
import com.tencent.p177mm.plugin.ipcall.p438a.p1274a.C44747b;
import com.tencent.p177mm.plugin.ipcall.p438a.p732d.C6950h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.wcdb.database.SQLiteDatabase;

/* renamed from: com.tencent.mm.plugin.ipcall.a.f.c */
public final class C44844c extends C44747b {
    private C6950h nzp;

    public final int[] bHC() {
        return new int[]{824};
    }

    public final void onStop() {
        AppMethodBeat.m2504i(21900);
        if (this.nzp != null) {
            C9638aw.m17182Rg().mo14547c(this.nzp);
        }
        AppMethodBeat.m2505o(21900);
    }

    public final int getServiceType() {
        return 5;
    }

    /* renamed from: wO */
    public final void mo24092wO() {
    }

    public final void onDestroy() {
    }

    /* renamed from: b */
    public final void mo24088b(C43219c c43219c) {
        AppMethodBeat.m2504i(21901);
        if (this.nvN != null) {
            this.nzp = new C6950h(this.nvN.nwu, this.nvN.nwv, this.nvN.nww);
            C9638aw.m17182Rg().mo14541a(this.nzp, 0);
        }
        AppMethodBeat.m2505o(21901);
    }

    public final int bHD() {
        return SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH;
    }

    public final void bHE() {
        AppMethodBeat.m2504i(21902);
        C4990ab.m7410d("MicroMsg.IPCallHeartBeatService", "heartbeat, onLoopSuccess");
        AppMethodBeat.m2505o(21902);
    }

    public final void bHF() {
        AppMethodBeat.m2504i(21903);
        C4990ab.m7410d("MicroMsg.IPCallHeartBeatService", "heartbeat, onLoopFailed");
        AppMethodBeat.m2505o(21903);
    }
}
