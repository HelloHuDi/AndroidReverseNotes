package com.tencent.p177mm.plugin.soter.p527b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.soter.p527b.C29251h.C168681;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.soter.p663a.C30954a;

/* renamed from: com.tencent.mm.plugin.soter.b.d */
public abstract class C35149d extends C1207m implements C1918k {
    private C29251h rNG;

    /* renamed from: com.tencent.mm.plugin.soter.b.d$a */
    class C35150a implements C29250a {
        private C35150a() {
        }

        /* synthetic */ C35150a(C35149d c35149d, byte b) {
            this();
        }

        public final void cvF() {
            AppMethodBeat.m2504i(59302);
            C35149d.this.bxO();
            AppMethodBeat.m2505o(59302);
        }

        /* renamed from: EA */
        public final void mo47426EA(int i) {
            AppMethodBeat.m2504i(59303);
            C35149d.this.mo55793vL(i);
            AppMethodBeat.m2505o(59303);
        }
    }

    public abstract void bxO();

    /* renamed from: d */
    public abstract void mo55792d(int i, int i2, String str, C1929q c1929q);

    /* renamed from: vL */
    public abstract void mo55793vL(int i);

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        int i4 = 1;
        C4990ab.m7417i("MicroMsg.NetSceneSoterBase", "onGYNetEnd errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.rNG = new C29251h(new C35150a(this, (byte) 0));
        this.rNG.rNJ = -3202;
        C29251h c29251h = this.rNG;
        if (i2 == 4 && i3 == -3200) {
            C30954a.m49587a(new C168681(), true, new C35151f());
        } else if (i2 != 4 || i3 != c29251h.rNJ) {
            i4 = 0;
        } else if (c29251h.rNI != null) {
            c29251h.rNI.cvF();
        }
        if (i4 == 0) {
            mo55792d(i2, i3, str, c1929q);
        }
    }
}
