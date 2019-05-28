package com.tencent.p177mm.plugin.ipcall.p438a.p982f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.plugin.ipcall.p438a.p1274a.C43218a;
import com.tencent.p177mm.plugin.ipcall.p438a.p1274a.C43219c;
import com.tencent.p177mm.plugin.ipcall.p438a.p732d.C46033n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.ipcall.a.f.h */
public final class C39261h extends C43218a {
    public int nzr = 1;
    public boolean nzs = false;

    public final int[] bHC() {
        return new int[]{723};
    }

    public final int getServiceType() {
        return 4;
    }

    /* renamed from: wO */
    public final void mo24092wO() {
    }

    public final void onDestroy() {
    }

    /* renamed from: b */
    public final void mo24088b(C43219c c43219c) {
        AppMethodBeat.m2504i(21910);
        if (c43219c != null) {
            C4990ab.m7411d("MicroMsg.IPCallShutDownService", "call shutdown scene, roomId: %d, inviteId: %d", Integer.valueOf(c43219c.nwu), Integer.valueOf(c43219c.nwx));
            C9638aw.m17182Rg().mo14541a(new C46033n(c43219c.nwu, c43219c.nwv, c43219c.nww, this.nzr), 0);
        }
        AppMethodBeat.m2505o(21910);
    }
}
