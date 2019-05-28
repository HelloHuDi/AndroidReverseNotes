package com.tencent.p177mm.plugin.backup.p920g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1182l;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.backup.p342b.C45732c;
import com.tencent.p177mm.plugin.backup.p921i.C19994v;
import com.tencent.p177mm.plugin.backup.p921i.C27494w;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.backup.g.a */
public final class C24713a extends C19978b {
    final String authId;
    public C19994v jwX = new C19994v();
    public C27494w jwY = new C27494w();
    final int jwZ;
    final String jxa;
    final byte[] jxb;

    public C24713a(String str, String str2, byte[] bArr, String str3, int i, int i2) {
        AppMethodBeat.m2504i(17636);
        C4990ab.m7417i("MicroMsg.BackupAuthScene", "BackupAuthScene init, backupType[%d], stack:%s", Integer.valueOf(i2), C5046bo.dpG());
        this.jwX.jBi = new C1332b(C1182l.m2608d(str.getBytes(), bArr));
        this.jwX.jCs = 0;
        this.jwX.f4368ID = str3;
        this.jwX.Version = i;
        this.jxa = str2;
        this.authId = str3;
        this.jxb = bArr;
        this.jwZ = i2;
        AppMethodBeat.m2505o(17636);
    }

    public final int getType() {
        return 1;
    }

    public final C1331a aTS() {
        return this.jwY;
    }

    public final C1331a aTT() {
        return this.jwX;
    }

    /* renamed from: rw */
    public final void mo6711rw(int i) {
        AppMethodBeat.m2504i(17637);
        if (this.jwY.jBT != 0) {
            C4990ab.m7413e("MicroMsg.BackupAuthScene", "onSceneEnd errType[%d]", Integer.valueOf(this.jwY.jBT));
            mo35227l(4, this.jwY.jBT, "onSceneEnd status failed");
            AppMethodBeat.m2505o(17637);
        } else if (this.authId.equals(this.jwY.f13685ID)) {
            boolean z;
            String str = new String(C1182l.m2607c(this.jwY.jBi.f1226wR, this.jxb));
            if (str.length() != this.jxa.length()) {
                z = false;
            } else {
                z = str.equals(this.jxa);
            }
            C4990ab.m7417i("MicroMsg.BackupAuthScene", "onSceneEnd check ok result[%b]", Boolean.valueOf(z));
            if (z) {
                mo35227l(0, 0, "onSceneEnd auth success");
                if (this.jwZ != 22 || this.jwY.Version >= C45732c.jqG) {
                    this.jwX.jBi = new C1332b(C1182l.m2608d(this.jxa.getBytes(), this.jxb));
                    this.jwX.jCs = 1;
                    this.jwX.f4368ID = this.authId;
                    try {
                        C4990ab.m7416i("MicroMsg.BackupAuthScene", "directSendAuthOk");
                        C19978b.m30889r(this.jwX.toByteArray(), 1, i);
                        AppMethodBeat.m2505o(17637);
                        return;
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.BackupAuthScene", e, "directSendAuthOk req to bur err.", new Object[0]);
                        AppMethodBeat.m2505o(17637);
                        return;
                    }
                }
                AppMethodBeat.m2505o(17637);
                return;
            }
            C4990ab.m7412e("MicroMsg.BackupAuthScene", "onSceneEnd check ok failed");
            mo35227l(4, -3, "onSceneEnd check ok failed");
            AppMethodBeat.m2505o(17637);
        } else {
            C4990ab.m7412e("MicroMsg.BackupAuthScene", "onSceneEnd not the same id");
            mo35227l(4, -1, "onSceneEnd not the same id");
            AppMethodBeat.m2505o(17637);
        }
    }

    /* renamed from: u */
    public final void mo41608u(boolean z, boolean z2) {
        C19994v c19994v;
        if (z) {
            c19994v = this.jwX;
            c19994v.jCu |= C45732c.jqK;
        }
        c19994v = this.jwX;
        c19994v.jCu |= C45732c.jqL;
        c19994v = this.jwX;
        c19994v.jCu |= C45732c.jqM;
        if (z2) {
            c19994v = this.jwX;
            c19994v.jCu |= C45732c.jqN;
        }
    }
}
