package com.tencent.p177mm.plugin.voip.model.p746a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.plugin.voip.model.C14047k;
import com.tencent.p177mm.plugin.voip.model.C29500l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;

/* renamed from: com.tencent.mm.plugin.voip.model.a.n */
public abstract class C22456n<REQ, RESP> extends C1207m implements C1918k {
    protected C7472b ehh;
    C1202f ehi;
    private C1202f mww;
    protected C14047k sPK = C29500l.cIW();

    public abstract C1202f cKt();

    /* renamed from: a */
    public final void mo4498a(int i, final int i2, final int i3, final String str, C1929q c1929q, byte[] bArr) {
        mo26283fW(i2, i3);
        if (this.mww != null) {
            this.mww.onSceneEnd(i2, i3, str, this);
        }
        if (this.ehi != null) {
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(4738);
                    if (C22456n.this.ehi != null) {
                        C22456n.this.ehi.onSceneEnd(i2, i3, str, C22456n.this);
                    }
                    AppMethodBeat.m2505o(4738);
                }
            });
        }
    }

    public int cKu() {
        return 0;
    }

    /* renamed from: fW */
    public void mo26283fW(int i, int i2) {
    }

    public final void cKw() {
        C4990ab.m7416i("MicroMsg.VoipNetSceneBase", "netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " is started.");
        C1720g.m3540Rg().mo14541a((C1207m) this, 0);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        int cKu = cKu();
        if (cKu != 0) {
            return cKu;
        }
        this.mww = c1202f;
        this.ehi = cKt();
        return mo4457a(c1902e, this.ehh, this);
    }

    public final <RESP> RESP cKx() {
        return this.ehh.fsH.fsP;
    }

    public final <REQ> REQ cKy() {
        return this.ehh.fsG.fsP;
    }
}
