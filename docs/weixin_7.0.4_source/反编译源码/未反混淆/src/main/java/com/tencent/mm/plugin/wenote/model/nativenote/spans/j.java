package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Editable;
import android.text.Spannable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import java.util.ArrayList;
import java.util.Iterator;

public final class j extends o<Boolean, k> {
    private p uRS = new p();

    public j() {
        AppMethodBeat.i(26945);
        AppMethodBeat.o(26945);
    }

    public final /* synthetic */ void a(WXRTEditText wXRTEditText, e eVar, Object obj) {
        AppMethodBeat.i(26946);
        Boolean bool = (Boolean) obj;
        Editable text = wXRTEditText.getText();
        if (bool == null) {
            bool = Boolean.FALSE;
        }
        this.uRS.uSf.clear();
        ArrayList paragraphs = wXRTEditText.getParagraphs();
        int size = paragraphs.size();
        int i = 0;
        k kVar = null;
        while (i < size) {
            k kVar2;
            boolean booleanValue;
            Object obj2;
            boolean z;
            n nVar = (n) paragraphs.get(i);
            ArrayList a = a((Spannable) text, (e) nVar, s.SPAN_FLAGS);
            this.uRS.a(a, nVar);
            if (a.isEmpty() || !(a.get(0) instanceof k)) {
                kVar2 = null;
            } else {
                kVar2 = (k) a.get(0);
            }
            boolean z2 = kVar2 != null && kVar2.uSb;
            if (kVar != null && kVar == kVar2 && z2) {
                z2 = false;
            }
            boolean z3 = !a.isEmpty();
            if (nVar.a(eVar)) {
                booleanValue = bool.booleanValue();
            } else {
                booleanValue = z3;
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
                this.uRS.b(new k(z2, b.del(), nVar.isEmpty(), nVar.uRY, nVar.uRZ), nVar);
                u.uSC.a((Spannable) text, nVar, this.uRS);
                u.uSB.a((Spannable) text, nVar, this.uRS);
            }
            if (!z && z3) {
                Iterator it = a.iterator();
                while (it.hasNext()) {
                    text.removeSpan(it.next());
                }
            }
            i++;
            kVar = kVar2;
        }
        this.uRS.c(text);
        AppMethodBeat.o(26946);
    }

    public final int dfy() {
        return 3;
    }
}
