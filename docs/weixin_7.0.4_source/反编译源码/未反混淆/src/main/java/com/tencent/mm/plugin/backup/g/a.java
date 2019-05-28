package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.l;
import com.tencent.mm.bt.b;
import com.tencent.mm.plugin.backup.b.c;
import com.tencent.mm.plugin.backup.i.v;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a extends b {
    final String authId;
    public v jwX = new v();
    public w jwY = new w();
    final int jwZ;
    final String jxa;
    final byte[] jxb;

    public a(String str, String str2, byte[] bArr, String str3, int i, int i2) {
        AppMethodBeat.i(17636);
        ab.i("MicroMsg.BackupAuthScene", "BackupAuthScene init, backupType[%d], stack:%s", Integer.valueOf(i2), bo.dpG());
        this.jwX.jBi = new b(l.d(str.getBytes(), bArr));
        this.jwX.jCs = 0;
        this.jwX.ID = str3;
        this.jwX.Version = i;
        this.jxa = str2;
        this.authId = str3;
        this.jxb = bArr;
        this.jwZ = i2;
        AppMethodBeat.o(17636);
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
        AppMethodBeat.i(17637);
        if (this.jwY.jBT != 0) {
            ab.e("MicroMsg.BackupAuthScene", "onSceneEnd errType[%d]", Integer.valueOf(this.jwY.jBT));
            l(4, this.jwY.jBT, "onSceneEnd status failed");
            AppMethodBeat.o(17637);
        } else if (this.authId.equals(this.jwY.ID)) {
            boolean z;
            String str = new String(l.c(this.jwY.jBi.wR, this.jxb));
            if (str.length() != this.jxa.length()) {
                z = false;
            } else {
                z = str.equals(this.jxa);
            }
            ab.i("MicroMsg.BackupAuthScene", "onSceneEnd check ok result[%b]", Boolean.valueOf(z));
            if (z) {
                l(0, 0, "onSceneEnd auth success");
                if (this.jwZ != 22 || this.jwY.Version >= c.jqG) {
                    this.jwX.jBi = new b(l.d(this.jxa.getBytes(), this.jxb));
                    this.jwX.jCs = 1;
                    this.jwX.ID = this.authId;
                    try {
                        ab.i("MicroMsg.BackupAuthScene", "directSendAuthOk");
                        b.r(this.jwX.toByteArray(), 1, i);
                        AppMethodBeat.o(17637);
                        return;
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.BackupAuthScene", e, "directSendAuthOk req to bur err.", new Object[0]);
                        AppMethodBeat.o(17637);
                        return;
                    }
                }
                AppMethodBeat.o(17637);
                return;
            }
            ab.e("MicroMsg.BackupAuthScene", "onSceneEnd check ok failed");
            l(4, -3, "onSceneEnd check ok failed");
            AppMethodBeat.o(17637);
        } else {
            ab.e("MicroMsg.BackupAuthScene", "onSceneEnd not the same id");
            l(4, -1, "onSceneEnd not the same id");
            AppMethodBeat.o(17637);
        }
    }

    public final void u(boolean z, boolean z2) {
        v vVar;
        if (z) {
            vVar = this.jwX;
            vVar.jCu |= c.jqK;
        }
        vVar = this.jwX;
        vVar.jCu |= c.jqL;
        vVar = this.jwX;
        vVar.jCu |= c.jqM;
        if (z2) {
            vVar = this.jwX;
            vVar.jCu |= c.jqN;
        }
    }
}
