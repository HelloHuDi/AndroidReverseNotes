package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Editable;
import android.text.Spannable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import java.util.ArrayList;

public final class c extends o<Boolean, d> {
    private p uRS = new p();

    public c() {
        AppMethodBeat.i(26935);
        AppMethodBeat.o(26935);
    }

    public final /* synthetic */ void a(WXRTEditText wXRTEditText, e eVar, Object obj) {
        AppMethodBeat.i(26936);
        Boolean bool = (Boolean) obj;
        Editable text = wXRTEditText.getText();
        if (bool == null) {
            bool = Boolean.FALSE;
        }
        this.uRS.uSf.clear();
        ArrayList paragraphs = wXRTEditText.getParagraphs();
        int size = paragraphs.size();
        int i = 0;
        while (i < size) {
            boolean booleanValue;
            Object obj2;
            n nVar = (n) paragraphs.get(i);
            ArrayList a = a((Spannable) text, (e) nVar, s.SPAN_FLAGS);
            this.uRS.a(a, nVar);
            boolean z = !a.isEmpty();
            if (nVar.a(eVar)) {
                booleanValue = bool.booleanValue();
            } else {
                booleanValue = z;
            }
            if (i <= 0 || nVar.dfF() != 1 || ((n) paragraphs.get(i - 1)).dfF() != 1 || bool.booleanValue()) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (obj2 != null) {
                z = false;
            } else {
                z = booleanValue;
            }
            if (z) {
                this.uRS.b(new d(b.del(), nVar.isEmpty(), nVar.uRY, nVar.uRZ), nVar);
                u.uSC.a((Spannable) text, nVar, this.uRS);
                u.uSA.a((Spannable) text, nVar, this.uRS);
            }
            i++;
        }
        this.uRS.c(text);
        AppMethodBeat.o(26936);
    }

    public final int dfy() {
        return 1;
    }
}
