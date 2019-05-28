package com.tencent.p177mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p230g.p231a.C9421nd;
import com.tencent.p177mm.plugin.address.p1467a.C33045a;
import com.tencent.p177mm.plugin.address.p1534d.C38090b;
import com.tencent.p177mm.plugin.address.p1534d.C45505a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.address.model.k */
public final class C38091k extends C4884c<C9421nd> implements C1202f {
    private C9421nd gIM;
    private C16527d gIN;

    public C38091k() {
        AppMethodBeat.m2504i(16751);
        this.xxI = C9421nd.class.getName().hashCode();
        AppMethodBeat.m2505o(16751);
    }

    /* renamed from: a */
    private boolean m64436a(C9421nd c9421nd) {
        AppMethodBeat.m2504i(16752);
        if (c9421nd instanceof C9421nd) {
            this.gIM = c9421nd;
            C9638aw.m17182Rg().mo14539a(417, (C1202f) this);
            C9638aw.m17182Rg().mo14541a(new C42320e(this.gIM.cJl.url, this.gIM.cJl.appId, 1), 0);
        }
        AppMethodBeat.m2505o(16752);
        return true;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(16753);
        C4990ab.m7411d("MicroMsg.RcptGetAddrEventListener", "onSceneEnd errType[%s], errCode[%s]", Integer.valueOf(i), Integer.valueOf(i2));
        if (c1207m instanceof C42320e) {
            if (i2 == 0) {
                m64435F(i2, true);
                AppMethodBeat.m2505o(16753);
                return;
            }
            m64435F(i2, false);
        }
        AppMethodBeat.m2505o(16753);
    }

    /* renamed from: F */
    private void m64435F(int i, boolean z) {
        AppMethodBeat.m2504i(16754);
        C4990ab.m7411d("MicroMsg.RcptGetAddrEventListener", "setResult errCode[%s], isAccept[%s]", Integer.valueOf(i), Boolean.valueOf(z));
        this.gIM.cJm.errCode = i;
        if (i != 0) {
            this.gIM.cJm.cJn = false;
        } else if (z) {
            C17903f.m28101h(this.gIN);
            this.gIM.cJm.cJn = true;
            C33045a.arQ();
            C45505a c45505a = C33045a.arS().gIQ;
            if (c45505a.gIY.size() > 0) {
                C38090b c38090b = (C38090b) c45505a.gIY.getFirst();
                this.gIM.cJm.cJo = c38090b.gJh;
                this.gIM.cJm.userName = c38090b.gJf;
                this.gIM.cJm.cJp = c38090b.gJg;
                this.gIM.cJm.cJq = c38090b.gJd;
                this.gIM.cJm.cJr = c38090b.gJa;
                this.gIM.cJm.cJs = c38090b.gJb;
                this.gIM.cJm.cJt = c38090b.gJc;
                this.gIM.cJm.cJu = c38090b.gJe;
            }
        } else {
            C17903f.m28102i(this.gIN);
            this.gIM.cJm.cJn = false;
        }
        if (this.gIM.callback != null) {
            this.gIM.callback.run();
        }
        C9638aw.m17182Rg().mo14546b(417, (C1202f) this);
        AppMethodBeat.m2505o(16754);
    }
}
