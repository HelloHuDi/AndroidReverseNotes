package com.tencent.mm.plugin.wenote.model.nativenote.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.c;

public final class d {
    public int coc = -1;
    public int endPos = -1;
    public int startOffset = -1;
    public int uRf = -1;

    public d() {
        AppMethodBeat.i(26855);
        set(-1, -1, -1, -1);
        AppMethodBeat.o(26855);
    }

    public d(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(26856);
        set(i, i2, i3, i4);
        AppMethodBeat.o(26856);
    }

    public final void set(int i, int i2, int i3, int i4) {
        this.coc = i;
        this.startOffset = i2;
        this.endPos = i3;
        this.uRf = i4;
    }

    public final int dfa() {
        AppMethodBeat.i(26857);
        if (this.coc < 0 || this.startOffset < 0 || this.endPos < 0 || this.uRf < 0 || this.coc > this.endPos || (this.coc == this.endPos && this.startOffset > this.uRf)) {
            AppMethodBeat.o(26857);
            return 0;
        }
        c Ke = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().Ke(this.coc);
        c Ke2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().Ke(this.endPos);
        if (Ke == null || Ke2 == null) {
            AppMethodBeat.o(26857);
            return 0;
        } else if (this.coc == this.endPos && this.startOffset == this.uRf) {
            AppMethodBeat.o(26857);
            return 1;
        } else if (this.coc == this.endPos && Ke.getType() == 1) {
            AppMethodBeat.o(26857);
            return 2;
        } else {
            AppMethodBeat.o(26857);
            return 3;
        }
    }
}
