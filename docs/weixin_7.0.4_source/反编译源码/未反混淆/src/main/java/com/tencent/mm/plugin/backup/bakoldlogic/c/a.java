package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.l;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.backup.i.v;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a extends b {
    final String jAd;
    final String jAe;
    private boolean jAf = false;
    final int jqS;
    private v jwX = new v();
    private w jwY = new w();
    final byte[] key;

    public a(String str, String str2, byte[] bArr, String str3) {
        AppMethodBeat.i(17879);
        ab.i("MicroMsg.BakOldAuthScene", "summerbak init id:%s,  hello:%s, ok:%s, stack[%s]", str3, str, str2, bo.dpG());
        this.jwX.jBi = new com.tencent.mm.bt.b(l.d(str.getBytes(), bArr));
        this.jwX.jCs = 0;
        this.jwX.ID = str3;
        this.jwX.Version = 0;
        this.jAd = str2;
        this.jAe = str3;
        this.key = bArr;
        this.jqS = -1;
        AppMethodBeat.o(17879);
    }

    public final int getType() {
        return 1;
    }

    public final com.tencent.mm.bt.a aTS() {
        return this.jwY;
    }

    public final com.tencent.mm.bt.a aTT() {
        return this.jwX;
    }

    public final void rw(int i) {
        AppMethodBeat.i(17880);
        if (this.jwY.jBT != 0) {
            ab.e("MicroMsg.BakOldAuthScene", "errType %d", Integer.valueOf(this.jwY.jBT));
            l(4, this.jwY.jBT, "not not success");
            AppMethodBeat.o(17880);
        } else if (this.jAe.equals(this.jwY.ID)) {
            boolean z;
            String str = new String(l.c(this.jwY.jBi.wR, this.key));
            if (str.length() != this.jAd.length()) {
                z = false;
            } else {
                z = str.equals(this.jAd);
            }
            this.jAf = z;
            ab.i("MicroMsg.BakOldAuthScene", "check ok result:%b", Boolean.valueOf(this.jAf));
            if (this.jAf) {
                l(0, 0, "auth ok");
                this.jwX.jBi = new com.tencent.mm.bt.b(l.d(this.jAd.getBytes(), this.key));
                this.jwX.jCs = 1;
                this.jwX.ID = this.jAe;
                try {
                    ab.i("MicroMsg.BakOldAuthScene", "directSendAuthOk");
                    b.r(this.jwX.toByteArray(), 1, i);
                    AppMethodBeat.o(17880);
                    return;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.BakOldAuthScene", e, "directSendAuthOk req to bur err.", new Object[0]);
                    AppMethodBeat.o(17880);
                    return;
                }
            }
            ab.e("MicroMsg.BakOldAuthScene", "check ok failed");
            l(4, 1, "not ok packet");
            AppMethodBeat.o(17880);
        } else {
            ab.e("MicroMsg.BakOldAuthScene", "not the same id");
            l(4, -1, "not the same id");
            AppMethodBeat.o(17880);
        }
    }
}
