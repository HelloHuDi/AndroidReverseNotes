package com.tencent.p177mm.plugin.wenote.model.nativenote.p586c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C40380c;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44001c;

/* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.c.d */
public final class C4670d {
    public int coc = -1;
    public int endPos = -1;
    public int startOffset = -1;
    public int uRf = -1;

    public C4670d() {
        AppMethodBeat.m2504i(26855);
        set(-1, -1, -1, -1);
        AppMethodBeat.m2505o(26855);
    }

    public C4670d(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(26856);
        set(i, i2, i3, i4);
        AppMethodBeat.m2505o(26856);
    }

    public final void set(int i, int i2, int i3, int i4) {
        this.coc = i;
        this.startOffset = i2;
        this.endPos = i3;
        this.uRf = i4;
    }

    public final int dfa() {
        AppMethodBeat.m2504i(26857);
        if (this.coc < 0 || this.startOffset < 0 || this.endPos < 0 || this.uRf < 0 || this.coc > this.endPos || (this.coc == this.endPos && this.startOffset > this.uRf)) {
            AppMethodBeat.m2505o(26857);
            return 0;
        }
        C44001c Ke = C40380c.dem().mo63750Ke(this.coc);
        C44001c Ke2 = C40380c.dem().mo63750Ke(this.endPos);
        if (Ke == null || Ke2 == null) {
            AppMethodBeat.m2505o(26857);
            return 0;
        } else if (this.coc == this.endPos && this.startOffset == this.uRf) {
            AppMethodBeat.m2505o(26857);
            return 1;
        } else if (this.coc == this.endPos && Ke.getType() == 1) {
            AppMethodBeat.m2505o(26857);
            return 2;
        } else {
            AppMethodBeat.m2505o(26857);
            return 3;
        }
    }
}
