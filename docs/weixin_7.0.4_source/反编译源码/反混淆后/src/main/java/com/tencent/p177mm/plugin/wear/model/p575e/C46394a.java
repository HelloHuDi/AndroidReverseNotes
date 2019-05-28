package com.tencent.p177mm.plugin.wear.model.p575e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wear.model.C43841a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wear.model.e.a */
public abstract class C46394a {
    public abstract List<Integer> cUA();

    /* renamed from: p */
    public abstract byte[] mo9572p(int i, byte[] bArr);

    /* renamed from: d */
    public final void mo74592d(int i, int i2, int i3, byte[] bArr) {
        if (mo9570HJ(i3) && bArr != null) {
            bArr = C43841a.cUn().tXt.mo56291bB(bArr);
            if (bArr == null) {
                C4990ab.m7412e("MicroMsg.Wear.BaseHttpServer", "request data decrypt error");
                return;
            }
        }
        byte[] p = mo9572p(i3, bArr);
        if (cUB()) {
            if (mo9569HI(i3)) {
                p = C43841a.cUn().tXt.mo56292bC(p);
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeInt(i);
                dataOutputStream.writeInt(i2);
                dataOutputStream.writeInt(i3);
                if (p == null || p.length <= 0) {
                    dataOutputStream.writeInt(0);
                } else {
                    dataOutputStream.writeInt(p.length);
                    dataOutputStream.write(p);
                }
                p = byteArrayOutputStream.toByteArray();
                C4990ab.m7417i("MicroMsg.Wear.BaseHttpServer", "send data funId=%d length=%d", Integer.valueOf(i3), Integer.valueOf(p.length));
                if (mo26668HK(i3)) {
                    C7305d.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(26384);
                            C43841a.cUn().tXt.mo56290bA(p);
                            AppMethodBeat.m2505o(26384);
                        }
                    }, "WearSendResponseTask");
                } else {
                    C43841a.cUn().tXt.mo56290bA(p);
                }
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.Wear.BaseHttpServer", e, "gen response data error connectType=%d, sessionId=%d, funId=%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            }
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: HI */
    public boolean mo9569HI(int i) {
        return false;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: HJ */
    public boolean mo9570HJ(int i) {
        return false;
    }

    /* renamed from: HK */
    public boolean mo26668HK(int i) {
        return false;
    }

    public boolean cUB() {
        return true;
    }
}
