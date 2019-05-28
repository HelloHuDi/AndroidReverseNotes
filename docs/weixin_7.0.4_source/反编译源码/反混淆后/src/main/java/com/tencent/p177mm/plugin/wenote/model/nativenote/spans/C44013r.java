package com.tencent.p177mm.plugin.wenote.model.nativenote.spans;

import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.spans.r */
public final class C44013r implements ParagraphStyle {
    public final C44012q uRP;
    public final ParagraphStyle uSv;

    public C44013r(C44012q c44012q, ParagraphStyle paragraphStyle) {
        this.uRP = c44012q;
        this.uSv = paragraphStyle;
    }

    public final String toString() {
        AppMethodBeat.m2504i(26969);
        String str = this.uRP.name() + " - " + this.uSv.getClass().getSimpleName();
        AppMethodBeat.m2505o(26969);
        return str;
    }
}
