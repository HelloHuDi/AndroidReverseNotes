package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

public final class d {
    c hAA = new c<ke>() {
        {
            AppMethodBeat.i(14144);
            this.xxI = ke.class.getName().hashCode();
            AppMethodBeat.o(14144);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(14145);
            switch (((ke) bVar).cFH.action) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 7:
                    d.this.jNN.aWv();
                    break;
            }
            AppMethodBeat.o(14145);
            return false;
        }
    };
    h jNN;

    public d(h hVar) {
        AppMethodBeat.i(14146);
        this.jNN = hVar;
        AppMethodBeat.o(14146);
    }
}
