package com.tencent.p177mm.p190at.p191a.p828f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p190at.p191a.C9012b;
import com.tencent.p177mm.p190at.p191a.p1527d.C37477b;
import com.tencent.p177mm.p190at.p191a.p193c.C25816a;
import com.tencent.p177mm.p190at.p191a.p193c.C37474b;
import com.tencent.p177mm.p190at.p191a.p193c.C45158c;
import com.tencent.p177mm.p190at.p191a.p827a.C17926b;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.sdk.platformtools.C5056d;

/* renamed from: com.tencent.mm.at.a.f.a */
public final class C25818a implements Runnable {
    private final C17926b fGK = this.fHp.fGK;
    private final C25814c fGS;
    private final C25816a fGU;
    private final C37474b fGV;
    private final C9012b fHp;
    private final C45158c fHq;
    private final String url;

    public C25818a(String str, C25814c c25814c, C9012b c9012b, C45158c c45158c) {
        AppMethodBeat.m2504i(116104);
        this.url = str;
        this.fHp = c9012b;
        if (c25814c == null) {
            this.fGS = this.fGK.fGS;
        } else {
            this.fGS = c25814c;
        }
        this.fHq = c45158c;
        if (this.fGS.fGV != null) {
            this.fGV = this.fGS.fGV;
        } else {
            this.fGV = this.fGK.fGV;
        }
        this.fGU = this.fGK.fGU;
        AppMethodBeat.m2505o(116104);
    }

    public final void run() {
        AppMethodBeat.m2504i(116105);
        C37477b c37477b = new C37477b();
        c37477b = this.fGV.mo33454sE(this.url);
        if (c37477b == null) {
            if (this.fHq != null) {
                this.fHq.mo15193a(false, this.fGS.eQd);
                AppMethodBeat.m2505o(116105);
                return;
            }
        } else if (!(C5056d.decodeByteArray(c37477b.data, 10, 10) == null && this.fGS.eQb) && this.fGU.mo43778a(this.url, c37477b.data, this.fGS)) {
            if (this.fHq != null) {
                this.fHq.mo15193a(true, this.fGS.eQd);
                AppMethodBeat.m2505o(116105);
                return;
            }
        } else if (this.fHq != null) {
            this.fHq.mo15193a(false, this.fGS.eQd);
        }
        AppMethodBeat.m2505o(116105);
    }
}
