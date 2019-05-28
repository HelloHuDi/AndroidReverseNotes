package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.d;
import com.tencent.mm.g.a.nd;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class k extends c<nd> implements f {
    private nd gIM;
    private d gIN;

    public k() {
        AppMethodBeat.i(16751);
        this.xxI = nd.class.getName().hashCode();
        AppMethodBeat.o(16751);
    }

    private boolean a(nd ndVar) {
        AppMethodBeat.i(16752);
        if (ndVar instanceof nd) {
            this.gIM = ndVar;
            aw.Rg().a(417, (f) this);
            aw.Rg().a(new e(this.gIM.cJl.url, this.gIM.cJl.appId, 1), 0);
        }
        AppMethodBeat.o(16752);
        return true;
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(16753);
        ab.d("MicroMsg.RcptGetAddrEventListener", "onSceneEnd errType[%s], errCode[%s]", Integer.valueOf(i), Integer.valueOf(i2));
        if (mVar instanceof e) {
            if (i2 == 0) {
                F(i2, true);
                AppMethodBeat.o(16753);
                return;
            }
            F(i2, false);
        }
        AppMethodBeat.o(16753);
    }

    private void F(int i, boolean z) {
        AppMethodBeat.i(16754);
        ab.d("MicroMsg.RcptGetAddrEventListener", "setResult errCode[%s], isAccept[%s]", Integer.valueOf(i), Boolean.valueOf(z));
        this.gIM.cJm.errCode = i;
        if (i != 0) {
            this.gIM.cJm.cJn = false;
        } else if (z) {
            com.tencent.mm.aj.f.h(this.gIN);
            this.gIM.cJm.cJn = true;
            a.arQ();
            com.tencent.mm.plugin.address.d.a aVar = a.arS().gIQ;
            if (aVar.gIY.size() > 0) {
                b bVar = (b) aVar.gIY.getFirst();
                this.gIM.cJm.cJo = bVar.gJh;
                this.gIM.cJm.userName = bVar.gJf;
                this.gIM.cJm.cJp = bVar.gJg;
                this.gIM.cJm.cJq = bVar.gJd;
                this.gIM.cJm.cJr = bVar.gJa;
                this.gIM.cJm.cJs = bVar.gJb;
                this.gIM.cJm.cJt = bVar.gJc;
                this.gIM.cJm.cJu = bVar.gJe;
            }
        } else {
            com.tencent.mm.aj.f.i(this.gIN);
            this.gIM.cJm.cJn = false;
        }
        if (this.gIM.callback != null) {
            this.gIM.callback.run();
        }
        aw.Rg().b(417, (f) this);
        AppMethodBeat.o(16754);
    }
}
