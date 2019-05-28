package com.tencent.p177mm.plugin.backup.bakoldlogic.p343c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.jniinterface.AesEcb;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p183ai.C32231g;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p1393a.C27452a;
import com.tencent.p177mm.plugin.backup.p920g.C19978b;
import com.tencent.p177mm.plugin.backup.p921i.C33708ad;
import com.tencent.p177mm.plugin.backup.p921i.C38660ae;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.c.d */
public final class C2645d extends C19978b {
    private static int progress;
    private int frO;
    /* renamed from: id */
    public String f1262id;
    private C32231g jAi = null;
    private C33708ad jAk = new C33708ad();
    private C38660ae jAl = new C38660ae();
    private String jAm;
    private byte[] key;
    private int offset = 0;
    private int start = 0;

    public C2645d(String str, String str2, int i, int i2, C32231g c32231g, byte[] bArr) {
        AppMethodBeat.m2504i(17887);
        if (i == 1) {
            this.jAm = str + "backupItem/" + C27452a.m43552Fb(str2);
        } else {
            this.jAm = str + "backupMeida/" + C27452a.m43552Fb(str2);
        }
        this.f1262id = str2;
        this.jAk.jCx = str2;
        this.jAk.jCy = i;
        this.frO = i2;
        C4990ab.m7417i("MicroMsg.BakSceneRestoreData", "BakSceneRestoreData init, %s, type:%d, totalLen:%d", this.jAk.jCx, Integer.valueOf(this.jAk.jCy), Integer.valueOf(this.frO));
        this.jAi = c32231g;
        this.key = bArr;
        AppMethodBeat.m2505o(17887);
    }

    public final boolean aUc() {
        int i;
        long j = C1625i.ACTION_MINI_PROGRAM_LAUNCH;
        AppMethodBeat.m2504i(17888);
        C4990ab.m7416i("MicroMsg.BakSceneRestoreData", "doSecne");
        int i2 = this.frO;
        if (this.jAk.jCy == 2) {
            if (((long) (this.frO - this.offset)) <= C1625i.ACTION_MINI_PROGRAM_LAUNCH) {
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
        AppMethodBeat.m2505o(17888);
        return aUc;
    }

    public static void setProgress(int i) {
        AppMethodBeat.m2504i(17889);
        C4990ab.m7417i("MicroMsg.BakSceneRestoreData", "setProgress %d", Integer.valueOf(i));
        progress = i;
        AppMethodBeat.m2505o(17889);
    }

    public final C1331a aTS() {
        return this.jAl;
    }

    public final C1331a aTT() {
        return this.jAk;
    }

    /* renamed from: rw */
    public final void mo6711rw(int i) {
        AppMethodBeat.m2504i(17890);
        C4990ab.m7417i("MicroMsg.BakSceneRestoreData", "onSceneEnd id:%s, type:%d, s:%d, e:%d, status:%d", this.jAl.jCx, Integer.valueOf(this.jAl.jCy), Integer.valueOf(this.jAl.jCA), Integer.valueOf(this.jAl.jCB), Integer.valueOf(this.jAl.jBT));
        if (this.jAl.jBT != 0 && this.jAl.jBT != 10) {
            mo35227l(4, this.jAl.jBT, "error");
            AppMethodBeat.m2505o(17890);
        } else if (this.jAl.jCA == this.start && this.jAl.jCB == this.offset) {
            byte[] aesCryptEcb;
            this.jAi.mo8280a(this.jAk.jCB - this.jAk.jCA, this.frO, this);
            byte[] bArr = this.jAl.jBi.f1226wR;
            if (this.key != null) {
                aesCryptEcb = AesEcb.aesCryptEcb(bArr, this.key, false, this.offset == this.frO);
            } else {
                aesCryptEcb = bArr;
            }
            String str = this.jAm;
            String str2 = this.f1262id;
            File file = new File(str + str2);
            long length = file.exists() ? file.length() : 0;
            C1173e.m2558b(str, str2, aesCryptEcb);
            File file2 = new File(str + str2);
            if (length == (file2.exists() ? file2.length() : 0)) {
                C4990ab.m7413e("MicroMsg.BakSceneRestoreData", "append failed and try again:%s", str + str2);
                C1173e.m2558b(str, str2, aesCryptEcb);
            }
            str = "MicroMsg.BakSceneRestoreData";
            String str3 = "onSceneEnd appendbuf len:%d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(aesCryptEcb == null ? 0 : aesCryptEcb.length);
            C4990ab.m7417i(str, str3, objArr);
            if (this.offset == this.frO) {
                C4990ab.m7417i("MicroMsg.BakSceneRestoreData", "recover cmoplete:%s  %d", this.f1262id, Integer.valueOf(this.frO));
                mo35227l(0, 0, "success");
                AppMethodBeat.m2505o(17890);
                return;
            }
            aUc();
            AppMethodBeat.m2505o(17890);
        } else {
            C4990ab.m7413e("MicroMsg.BakSceneRestoreData", "err local:%d, %d;   server:%d,%d", Integer.valueOf(this.start), Integer.valueOf(this.offset), Integer.valueOf(this.jAl.jCA), Integer.valueOf(this.jAl.jCB));
            mo35227l(3, -1, "error");
            AppMethodBeat.m2505o(17890);
        }
    }

    public final int getType() {
        return 7;
    }
}
