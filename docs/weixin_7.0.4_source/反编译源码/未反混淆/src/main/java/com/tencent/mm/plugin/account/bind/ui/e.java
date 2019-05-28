package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ki;
import com.tencent.mm.plugin.account.bind.ui.f.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

public final class e extends c<ki> implements a {
    private ki gua;

    public e() {
        AppMethodBeat.i(13746);
        this.xxI = ki.class.getName().hashCode();
        AppMethodBeat.o(13746);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(13749);
        ki kiVar = (ki) bVar;
        if (kiVar instanceof ki) {
            this.gua = kiVar;
            new f(this.gua.cFO.czX, this).apv();
            AppMethodBeat.o(13749);
        } else {
            AppMethodBeat.o(13749);
        }
        return false;
    }

    public final boolean cL(int i, int i2) {
        AppMethodBeat.i(13747);
        if (this.gua == null) {
            AppMethodBeat.o(13747);
            return false;
        } else if (this.gua.cFO.cFQ == null) {
            this.gua = null;
            AppMethodBeat.o(13747);
            return false;
        } else if (i == 0 && i2 == 0) {
            this.gua.cFP.cvi = true;
            this.gua.cFO.cFQ.run();
            this.gua = null;
            AppMethodBeat.o(13747);
            return true;
        } else {
            this.gua.cFP.cvi = false;
            this.gua.cFO.cFQ.run();
            this.gua = null;
            AppMethodBeat.o(13747);
            return false;
        }
    }

    public final void apu() {
        AppMethodBeat.i(13748);
        if (!(this.gua == null || this.gua.cFO.cFQ == null)) {
            this.gua.cFP.cvi = false;
            this.gua.cFO.cFQ.run();
            this.gua = null;
        }
        AppMethodBeat.o(13748);
    }
}
