package com.tencent.p177mm.plugin.ipcall.p438a.p982f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.plugin.ipcall.p438a.p1274a.C43218a;
import com.tencent.p177mm.plugin.ipcall.p438a.p1274a.C43219c;
import com.tencent.p177mm.plugin.ipcall.p438a.p732d.C6951i;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.ipcall.a.f.d */
public final class C21081d extends C43218a {
    public final int[] bHC() {
        return new int[]{991};
    }

    public final int getServiceType() {
        return 1;
    }

    /* renamed from: wO */
    public final void mo24092wO() {
    }

    public final void onDestroy() {
    }

    /* renamed from: b */
    public final void mo24088b(C43219c c43219c) {
        AppMethodBeat.m2504i(21904);
        if (c43219c != null) {
            if (c43219c.nwx == 0) {
                c43219c.nwx = (int) System.currentTimeMillis();
            }
            C9638aw.m17182Rg().mo14541a(new C6951i(c43219c.cMr, c43219c.nwW, c43219c.nwx, c43219c.nwy, c43219c.nwz), 0);
            C4990ab.m7411d("MicroMsg.IPCallInviteService", "start invite, toUsername: %s, toPhoneNumber: %s, inviteid: %d", c43219c.cMr, c43219c.nwW, Integer.valueOf(c43219c.nwx));
        }
        AppMethodBeat.m2505o(21904);
    }
}
