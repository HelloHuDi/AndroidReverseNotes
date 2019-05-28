package com.tencent.p177mm.plugin.wenote.model.nativenote.spans;

import android.text.style.LeadingMarginSpan.Standard;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.spans.IndentationSpan */
public class IndentationSpan extends Standard implements C14739f<Integer>, C46458g<Integer> {
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
        AppMethodBeat.m2504i(26941);
        Integer valueOf = Integer.valueOf(this.uRW);
        AppMethodBeat.m2505o(26941);
        return valueOf;
    }

    public final /* synthetic */ C14739f dfC() {
        AppMethodBeat.m2504i(26942);
        IndentationSpan indentationSpan = new IndentationSpan(this.uRW, this.uRV);
        AppMethodBeat.m2505o(26942);
        return indentationSpan;
    }
}
