package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.ai.g;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.backup.i.ad;
import com.tencent.mm.plugin.backup.i.ae;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;

public final class d extends b {
    private static int progress;
    private int frO;
    public String id;
    private g jAi = null;
    private ad jAk = new ad();
    private ae jAl = new ae();
    private String jAm;
    private byte[] key;
    private int offset = 0;
    private int start = 0;

    public d(String str, String str2, int i, int i2, g gVar, byte[] bArr) {
        AppMethodBeat.i(17887);
        if (i == 1) {
            this.jAm = str + "backupItem/" + a.Fb(str2);
        } else {
            this.jAm = str + "backupMeida/" + a.Fb(str2);
        }
        this.id = str2;
        this.jAk.jCx = str2;
        this.jAk.jCy = i;
        this.frO = i2;
        ab.i("MicroMsg.BakSceneRestoreData", "BakSceneRestoreData init, %s, type:%d, totalLen:%d", this.jAk.jCx, Integer.valueOf(this.jAk.jCy), Integer.valueOf(this.frO));
        this.jAi = gVar;
        this.key = bArr;
        AppMethodBeat.o(17887);
    }

    public final boolean aUc() {
        int i;
        long j = i.ACTION_MINI_PROGRAM_LAUNCH;
        AppMethodBeat.i(17888);
        ab.i("MicroMsg.BakSceneRestoreData", "doSecne");
        int i2 = this.frO;
        if (this.jAk.jCy == 2) {
            if (((long) (this.frO - this.offset)) <= i.ACTION_MINI_PROGRAM_LAUNCH) {
                j = (long) (this.frO - this.offset);
            }
            i = (int) j;
        } else {
            i = i2;
        }
        this.start = this.offset;
        this.offset = i + this.start;
        this.jAk.jCA = this.start;
        this.jAk.jCB = this.offset;
        this.jAk.jCD = progress;
        boolean aUc = super.aUc();
        AppMethodBeat.o(17888);
        return aUc;
    }

    public static void setProgress(int i) {
        AppMethodBeat.i(17889);
        ab.i("MicroMsg.BakSceneRestoreData", "setProgress %d", Integer.valueOf(i));
        progress = i;
        AppMethodBeat.o(17889);
    }

    public final com.tencent.mm.bt.a aTS() {
        return this.jAl;
    }

    public final com.tencent.mm.bt.a aTT() {
        return this.jAk;
    }

    public final void rw(int i) {
        AppMethodBeat.i(17890);
        ab.i("MicroMsg.BakSceneRestoreData", "onSceneEnd id:%s, type:%d, s:%d, e:%d, status:%d", this.jAl.jCx, Integer.valueOf(this.jAl.jCy), Integer.valueOf(this.jAl.jCA), Integer.valueOf(this.jAl.jCB), Integer.valueOf(this.jAl.jBT));
        if (this.jAl.jBT != 0 && this.jAl.jBT != 10) {
            l(4, this.jAl.jBT, "error");
            AppMethodBeat.o(17890);
        } else if (this.jAl.jCA == this.start && this.jAl.jCB == this.offset) {
            byte[] aesCryptEcb;
            this.jAi.a(this.jAk.jCB - this.jAk.jCA, this.frO, this);
            byte[] bArr = this.jAl.jBi.wR;
            if (this.key != null) {
                aesCryptEcb = AesEcb.aesCryptEcb(bArr, this.key, false, this.offset == this.frO);
            } else {
                aesCryptEcb = bArr;
            }
            String str = this.jAm;
            String str2 = this.id;
            File file = new File(str + str2);
            long length = file.exists() ? file.length() : 0;
            e.b(str, str2, aesCryptEcb);
            File file2 = new File(str + str2);
            if (length == (file2.exists() ? file2.length() : 0)) {
                ab.e("MicroMsg.BakSceneRestoreData", "append failed and try again:%s", str + str2);
                e.b(str, str2, aesCryptEcb);
            }
            str = "MicroMsg.BakSceneRestoreData";
            String str3 = "onSceneEnd appendbuf len:%d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(aesCryptEcb == null ? 0 : aesCryptEcb.length);
            ab.i(str, str3, objArr);
            if (this.offset == this.frO) {
                ab.i("MicroMsg.BakSceneRestoreData", "recover cmoplete:%s  %d", this.id, Integer.valueOf(this.frO));
                l(0, 0, "success");
                AppMethodBeat.o(17890);
                return;
            }
            aUc();
            AppMethodBeat.o(17890);
        } else {
            ab.e("MicroMsg.BakSceneRestoreData", "err local:%d, %d;   server:%d,%d", Integer.valueOf(this.start), Integer.valueOf(this.offset), Integer.valueOf(this.jAl.jCA), Integer.valueOf(this.jAl.jCB));
            l(3, -1, "error");
            AppMethodBeat.o(17890);
        }
    }

    public final int getType() {
        return 7;
    }
}
