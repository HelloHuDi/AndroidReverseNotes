package com.tencent.p177mm.plugin.ipcall.p438a.p982f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.ipcall.p438a.C34378h;
import com.tencent.p177mm.plugin.ipcall.p438a.C34378h.C34379a;
import com.tencent.p177mm.plugin.ipcall.p438a.p1274a.C43218a;
import com.tencent.p177mm.plugin.ipcall.p438a.p1274a.C43219c;
import com.tencent.p177mm.protocal.protobuf.bmc;
import com.tencent.p177mm.sdk.p600b.C4879a;

/* renamed from: com.tencent.mm.plugin.ipcall.a.f.e */
public final class C28330e extends C43218a implements C34379a {
    private C34378h nzq = null;

    public final int[] bHC() {
        return new int[0];
    }

    public final int getServiceType() {
        return 8;
    }

    /* renamed from: wO */
    public final void mo24092wO() {
        AppMethodBeat.m2504i(21905);
        this.nzq = new C34378h();
        this.nzq.nvS = this;
        C4879a.xxA.mo10052c(this.nzq);
        AppMethodBeat.m2505o(21905);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(21906);
        C4879a.xxA.mo10053d(this.nzq);
        AppMethodBeat.m2505o(21906);
    }

    /* renamed from: b */
    public final void mo24088b(C43219c c43219c) {
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
    }

    /* renamed from: a */
    public final void mo46242a(bmc bmc) {
        AppMethodBeat.m2504i(21907);
        this.nwr.mo46234a(8, bmc, 0, 0);
        AppMethodBeat.m2505o(21907);
    }
}
