package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

public class ac extends a implements v {
    private c hAA = new c<ke>() {
        {
            AppMethodBeat.i(31605);
            this.xxI = ke.class.getName().hashCode();
            AppMethodBeat.o(31605);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(31606);
            switch (((ke) bVar).cFH.action) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 7:
                    if (ac.this.cgL != null) {
                        ac.this.cgL.aWv();
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(31606);
            return false;
        }
    };

    public ac() {
        AppMethodBeat.i(31607);
        AppMethodBeat.o(31607);
    }

    private void dDi() {
        AppMethodBeat.i(31608);
        a.xxA.d(this.hAA);
        AppMethodBeat.o(31608);
    }

    public final void dxC() {
        AppMethodBeat.i(31610);
        dDi();
        AppMethodBeat.o(31610);
    }

    public final void dDh() {
        AppMethodBeat.i(31611);
        super.dDh();
        dDi();
        AppMethodBeat.o(31611);
    }

    public final void dxz() {
        AppMethodBeat.i(31609);
        a.xxA.c(this.hAA);
        AppMethodBeat.o(31609);
    }
}
