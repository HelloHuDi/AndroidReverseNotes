package com.tencent.p177mm.plugin.backup.bakoldlogic.p343c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1182l;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.backup.p920g.C19978b;
import com.tencent.p177mm.plugin.backup.p921i.C19994v;
import com.tencent.p177mm.plugin.backup.p921i.C27494w;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.c.a */
public final class C45739a extends C19978b {
    final String jAd;
    final String jAe;
    private boolean jAf = false;
    final int jqS;
    private C19994v jwX = new C19994v();
    private C27494w jwY = new C27494w();
    final byte[] key;

    public C45739a(String str, String str2, byte[] bArr, String str3) {
        AppMethodBeat.m2504i(17879);
        C4990ab.m7417i("MicroMsg.BakOldAuthScene", "summerbak init id:%s,  hello:%s, ok:%s, stack[%s]", str3, str, str2, C5046bo.dpG());
        this.jwX.jBi = new C1332b(C1182l.m2608d(str.getBytes(), bArr));
        this.jwX.jCs = 0;
        this.jwX.f4368ID = str3;
        this.jwX.Version = 0;
        this.jAd = str2;
        this.jAe = str3;
        this.key = bArr;
        this.jqS = -1;
        AppMethodBeat.m2505o(17879);
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
        AppMethodBeat.m2504i(17880);
        if (this.jwY.jBT != 0) {
            C4990ab.m7413e("MicroMsg.BakOldAuthScene", "errType %d", Integer.valueOf(this.jwY.jBT));
            mo35227l(4, this.jwY.jBT, "not not success");
            AppMethodBeat.m2505o(17880);
        } else if (this.jAe.equals(this.jwY.f13685ID)) {
            boolean z;
            String str = new String(C1182l.m2607c(this.jwY.jBi.f1226wR, this.key));
            if (str.length() != this.jAd.length()) {
                z = false;
            } else {
                z = str.equals(this.jAd);
            }
            this.jAf = z;
            C4990ab.m7417i("MicroMsg.BakOldAuthScene", "check ok result:%b", Boolean.valueOf(this.jAf));
            if (this.jAf) {
                mo35227l(0, 0, "auth ok");
                this.jwX.jBi = new C1332b(C1182l.m2608d(this.jAd.getBytes(), this.key));
                this.jwX.jCs = 1;
                this.jwX.f4368ID = this.jAe;
                try {
                    C4990ab.m7416i("MicroMsg.BakOldAuthScene", "directSendAuthOk");
                    C19978b.m30889r(this.jwX.toByteArray(), 1, i);
                    AppMethodBeat.m2505o(17880);
                    return;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.BakOldAuthScene", e, "directSendAuthOk req to bur err.", new Object[0]);
                    AppMethodBeat.m2505o(17880);
                    return;
                }
            }
            C4990ab.m7412e("MicroMsg.BakOldAuthScene", "check ok failed");
            mo35227l(4, 1, "not ok packet");
            AppMethodBeat.m2505o(17880);
        } else {
            C4990ab.m7412e("MicroMsg.BakOldAuthScene", "not the same id");
            mo35227l(4, -1, "not the same id");
            AppMethodBeat.m2505o(17880);
        }
    }
}
