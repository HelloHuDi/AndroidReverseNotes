package com.tencent.p177mm.plugin.report.p499b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C7247af;
import com.tencent.p177mm.protocal.protobuf.C7248ag;
import com.tencent.p177mm.protocal.protobuf.C7531ads;
import com.tencent.p177mm.protocal.protobuf.adt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.report.b.g */
public final class C7049g extends C1207m implements C1918k {
    private static boolean isRunning = false;
    private static Object lock = new Object();
    private C7472b ehh;
    private C1202f ehi;
    private C7531ads pXt = null;
    public C7248ag pXu;

    static {
        AppMethodBeat.m2504i(72683);
        AppMethodBeat.m2505o(72683);
    }

    private static void setIsRunning(boolean z) {
        synchronized (lock) {
            isRunning = z;
        }
    }

    public C7049g(int i, int i2) {
        AppMethodBeat.m2504i(72680);
        C7049g.setIsRunning(true);
        C7247af c7247af = new C7247af();
        this.pXt = new C7531ads();
        try {
            c7247af.vBo = i;
            c7247af.vBp = i2;
            this.pXt.wlS = c7247af;
            AppMethodBeat.m2505o(72680);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.NetSceneGetAPMStrategy", "parse data error");
            AppMethodBeat.m2505o(72680);
        }
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(72681);
        try {
            this.pXu = null;
            if (C1720g.m3535RO().eJo == null || C1720g.m3535RO().eJo.ftA == null) {
                C4990ab.m7414f("MicroMsg.NetSceneGetAPMStrategy", "null == network().getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
                this.ehi.onSceneEnd(i2, i3, str, this);
            } else if (i2 != 0) {
                C4990ab.m7412e("MicroMsg.NetSceneGetAPMStrategy", "get report strategy err, errType:" + i2 + ", errCode:" + i3);
                this.ehi.onSceneEnd(i2, i3, str, this);
                C7049g.setIsRunning(false);
                AppMethodBeat.m2505o(72681);
            } else {
                C4990ab.m7410d("MicroMsg.NetSceneGetAPMStrategy", "get report strategy ok");
                this.pXu = ((adt) this.ehh.fsH.fsP).wlT;
                this.ehi.onSceneEnd(i2, i3, str, this);
                C7049g.setIsRunning(false);
                AppMethodBeat.m2505o(72681);
            }
        } finally {
            C7049g.setIsRunning(false);
            AppMethodBeat.m2505o(72681);
        }
    }

    public final int getType() {
        return 914;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(72682);
        this.ehi = c1202f;
        C1720g.m3534RN();
        if (C1668a.m3395QX()) {
            C1196a c1196a = new C1196a();
            c1196a.fsN = false;
            c1196a.fsJ = this.pXt;
            c1196a.fsK = new adt();
            c1196a.uri = "/cgi-bin/micromsg-bin/getapmstrategy";
            c1196a.fsI = 914;
            this.ehh = c1196a.acD();
            int a = mo4457a(c1902e, this.ehh, this);
            if (a < 0) {
                C4990ab.m7417i("MicroMsg.NetSceneGetAPMStrategy", "mark all failed. do scene %d", Integer.valueOf(a));
                try {
                    this.pXu = null;
                    C7049g.setIsRunning(false);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.NetSceneGetAPMStrategy", "onStrategyResp failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), C5046bo.m7574l(e));
                }
            }
            AppMethodBeat.m2505o(72682);
            return a;
        }
        C4990ab.m7420w("MicroMsg.NetSceneGetAPMStrategy", "get mrs strategy must go after login");
        AppMethodBeat.m2505o(72682);
        return -1;
    }
}
