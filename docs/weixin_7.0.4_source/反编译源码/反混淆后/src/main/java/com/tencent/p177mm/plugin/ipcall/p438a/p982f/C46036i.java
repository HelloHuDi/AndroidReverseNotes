package com.tencent.p177mm.plugin.ipcall.p438a.p982f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.plugin.ipcall.p438a.p1274a.C43219c;
import com.tencent.p177mm.plugin.ipcall.p438a.p1274a.C44747b;
import com.tencent.p177mm.plugin.ipcall.p438a.p732d.C39257o;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.ipcall.a.f.i */
public final class C46036i extends C44747b {
    private C39257o nzt = null;
    private int nzu = 0;

    public final int[] bHC() {
        return new int[]{819};
    }

    public final void onStop() {
        AppMethodBeat.m2504i(21911);
        if (this.nzt != null) {
            C9638aw.m17182Rg().mo14547c(this.nzt);
        }
        AppMethodBeat.m2505o(21911);
    }

    public final int getServiceType() {
        return 2;
    }

    /* renamed from: wO */
    public final void mo24092wO() {
    }

    public final void onDestroy() {
    }

    /* renamed from: b */
    public final void mo24088b(C43219c c43219c) {
        boolean z = true;
        AppMethodBeat.m2504i(21912);
        String str = "MicroMsg.IPCallSyncService";
        String str2 = "serviceImpl, info==null: %b";
        Object[] objArr = new Object[1];
        if (c43219c != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        C4990ab.m7411d(str, str2, objArr);
        if (this.nvN != null) {
            this.nzu = this.nvN.nwE;
            this.nzt = new C39257o(this.nvN.nwu, this.nvN.nwv, this.nvN.bHG(), this.nvN.nww, false);
            C9638aw.m17182Rg().mo14541a(this.nzt, 0);
        }
        AppMethodBeat.m2505o(21912);
    }

    public final int bHD() {
        return this.nzu;
    }

    public final void bHE() {
        AppMethodBeat.m2504i(21913);
        C4990ab.m7410d("MicroMsg.IPCallSyncService", "onLoopSuccess");
        AppMethodBeat.m2505o(21913);
    }

    public final void bHF() {
        AppMethodBeat.m2504i(21914);
        C4990ab.m7410d("MicroMsg.IPCallSyncService", "onLoopFailed");
        AppMethodBeat.m2505o(21914);
    }
}
