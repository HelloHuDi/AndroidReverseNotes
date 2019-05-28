package com.tencent.mm.audio.mix.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.b;
import com.tencent.mm.audio.mix.b.a;
import java.util.List;

public final class d implements i {
    private h cmO;
    private int cmP = 4;

    public final void init() {
        AppMethodBeat.i(137115);
        if (this.cmO == null) {
            h nVar;
            switch (this.cmP) {
                case 1:
                    nVar = new n();
                    break;
                case 2:
                    nVar = new a();
                    break;
                case 3:
                    nVar = new k();
                    break;
                case 4:
                    nVar = new j();
                    break;
                case 5:
                    nVar = new m();
                    break;
                case 6:
                    nVar = new o();
                    break;
                case 7:
                    nVar = new l();
                    break;
                case 8:
                    nVar = new b();
                    break;
                default:
                    nVar = new j();
                    break;
            }
            this.cmO = nVar;
        }
        AppMethodBeat.o(137115);
    }

    public final b I(List<com.tencent.mm.audio.mix.a.d> list) {
        AppMethodBeat.i(137116);
        if (this.cmO == null) {
            com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixer", "mixAlgorithm must be init, please call init() first");
            AppMethodBeat.o(137116);
            return null;
        }
        b Dh = a.Dg().Dh();
        if (this.cmO.a(Dh, list)) {
            AppMethodBeat.o(137116);
            return Dh;
        }
        com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixer", "mix audio fail");
        AppMethodBeat.o(137116);
        return null;
    }
}
