package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

public abstract class a {
    public abstract List<Integer> cUA();

    public abstract byte[] p(int i, byte[] bArr);

    public final void d(int i, int i2, int i3, byte[] bArr) {
        if (HJ(i3) && bArr != null) {
            bArr = com.tencent.mm.plugin.wear.model.a.cUn().tXt.bB(bArr);
            if (bArr == null) {
                ab.e("MicroMsg.Wear.BaseHttpServer", "request data decrypt error");
                return;
            }
        }
        byte[] p = p(i3, bArr);
        if (cUB()) {
            if (HI(i3)) {
                p = com.tencent.mm.plugin.wear.model.a.cUn().tXt.bC(p);
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
                ab.i("MicroMsg.Wear.BaseHttpServer", "send data funId=%d length=%d", Integer.valueOf(i3), Integer.valueOf(p.length));
                if (HK(i3)) {
                    d.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(26384);
                            com.tencent.mm.plugin.wear.model.a.cUn().tXt.bA(p);
                            AppMethodBeat.o(26384);
                        }
                    }, "WearSendResponseTask");
                } else {
                    com.tencent.mm.plugin.wear.model.a.cUn().tXt.bA(p);
                }
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.Wear.BaseHttpServer", e, "gen response data error connectType=%d, sessionId=%d, funId=%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean HI(int i) {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public boolean HJ(int i) {
        return false;
    }

    public boolean HK(int i) {
        return false;
    }

    public boolean cUB() {
        return true;
    }
}
