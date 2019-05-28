package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.style.LeadingMarginSpan.Standard;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IndentationSpan extends Standard implements f<Integer>, g<Integer> {
    private final boolean uRV;
    private final int uRW;

    private IndentationSpan(int i, boolean z) {
        super(i);
        this.uRW = i;
        this.uRV = z;
    }

    public int getLeadingMargin(boolean z) {
        return this.uRV ? 0 : this.uRW;
    }

    public final /* synthetic */ Object getValue() {
        AppMethodBeat.i(26941);
        Integer valueOf = Integer.valueOf(this.uRW);
        AppMethodBeat.o(26941);
        return valueOf;
    }

    public final /* synthetic */ f dfC() {
        AppMethodBeat.i(26942);
        IndentationSpan indentationSpan = new IndentationSpan(this.uRW, this.uRV);
        AppMethodBeat.o(26942);
        return indentationSpan;
    }
}
