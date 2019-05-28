package com.tencent.mm.plugin.voip_cs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ug;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip_cs.b.e;
import com.tencent.mm.protocal.protobuf.cov;
import com.tencent.mm.protocal.protobuf.cpc;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public final class a extends c<ug> {
    public a() {
        AppMethodBeat.i(135282);
        this.xxI = ug.class.getName().hashCode();
        AppMethodBeat.o(135282);
    }

    private static boolean a(ug ugVar) {
        AppMethodBeat.i(135283);
        if (ugVar instanceof ug) {
            if (g.RK()) {
                e cMf = com.tencent.mm.plugin.voip_cs.b.c.cMf();
                byte[] bArr = ugVar.cQq.cQr;
                if (!(bArr == null || bArr.length == 0)) {
                    byte[] bArr2 = new byte[(bArr.length - 1)];
                    System.arraycopy(bArr, 1, bArr2, 0, bArr2.length);
                    cov cov = new cov();
                    try {
                        cov.parseFrom(bArr2);
                        ab.i("MicroMsg.voipcs.VoipCSService", "notify status = " + cov.xmF + ",notifySeq = " + cMf.tdG);
                        cpc cpc = new cpc();
                        cpc.xeF = cov.xeF;
                        cpc.wen = cov.wen;
                        cpc.xmD = cov.xmD;
                        cpc.xmF = cov.xmF;
                        cpc.xmG = cov.xmG;
                        cpc.xmH = cov.xmH;
                        cpc.xmE = cov.xmE;
                        cMf.a(cpc);
                    } catch (IOException e) {
                        ab.e("MicroMsg.voipcs.VoipCSService", "csNotify.parseFrom content error!", e);
                    }
                }
            } else {
                AppMethodBeat.o(135283);
                return false;
            }
        }
        AppMethodBeat.o(135283);
        return false;
    }
}
