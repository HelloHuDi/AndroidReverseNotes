package com.tencent.p177mm.plugin.voip_cs.p1309a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C42070ug;
import com.tencent.p177mm.plugin.voip_cs.p547b.C22488e;
import com.tencent.p177mm.plugin.voip_cs.p547b.C43749c;
import com.tencent.p177mm.protocal.protobuf.cov;
import com.tencent.p177mm.protocal.protobuf.cpc;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.voip_cs.a.a */
public final class C22485a extends C4884c<C42070ug> {
    public C22485a() {
        AppMethodBeat.m2504i(135282);
        this.xxI = C42070ug.class.getName().hashCode();
        AppMethodBeat.m2505o(135282);
    }

    /* renamed from: a */
    private static boolean m34188a(C42070ug c42070ug) {
        AppMethodBeat.m2504i(135283);
        if (c42070ug instanceof C42070ug) {
            if (C1720g.m3531RK()) {
                C22488e cMf = C43749c.cMf();
                byte[] bArr = c42070ug.cQq.cQr;
                if (!(bArr == null || bArr.length == 0)) {
                    byte[] bArr2 = new byte[(bArr.length - 1)];
                    System.arraycopy(bArr, 1, bArr2, 0, bArr2.length);
                    cov cov = new cov();
                    try {
                        cov.parseFrom(bArr2);
                        C4990ab.m7416i("MicroMsg.voipcs.VoipCSService", "notify status = " + cov.xmF + ",notifySeq = " + cMf.tdG);
                        cpc cpc = new cpc();
                        cpc.xeF = cov.xeF;
                        cpc.wen = cov.wen;
                        cpc.xmD = cov.xmD;
                        cpc.xmF = cov.xmF;
                        cpc.xmG = cov.xmG;
                        cpc.xmH = cov.xmH;
                        cpc.xmE = cov.xmE;
                        cMf.mo38043a(cpc);
                    } catch (IOException e) {
                        C4990ab.m7413e("MicroMsg.voipcs.VoipCSService", "csNotify.parseFrom content error!", e);
                    }
                }
            } else {
                AppMethodBeat.m2505o(135283);
                return false;
            }
        }
        AppMethodBeat.m2505o(135283);
        return false;
    }
}
