package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r implements ParagraphStyle {
    public final q uRP;
    public final ParagraphStyle uSv;

    public r(q qVar, ParagraphStyle paragraphStyle) {
        this.uRP = qVar;
        this.uSv = paragraphStyle;
    }

    public final String toString() {
        AppMethodBeat.i(26969);
        String str = this.uRP.name() + " - " + this.uSv.getClass().getSimpleName();
        AppMethodBeat.o(26969);
        return str;
    }
}
