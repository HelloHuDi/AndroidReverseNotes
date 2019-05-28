package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Editable;
import android.text.Spannable;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import java.util.ArrayList;
import java.util.Iterator;

public final class l extends o<Boolean, m> {
    private p uRS = new p();

    public l() {
        AppMethodBeat.i(26952);
        AppMethodBeat.o(26952);
    }

    public final /* synthetic */ void a(WXRTEditText wXRTEditText, e eVar, Object obj) {
        AppMethodBeat.i(26953);
        Boolean bool = (Boolean) obj;
        Editable text = wXRTEditText.getText();
        if (bool == null) {
            bool = Boolean.FALSE;
        }
        this.uRS.uSf.clear();
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        ArrayList paragraphs = wXRTEditText.getParagraphs();
        int size = paragraphs.size();
        int i = 0;
        int i2 = 1;
        while (i < size) {
            int i3;
            int i4;
            Object next;
            boolean booleanValue;
            n nVar = (n) paragraphs.get(i);
            int i5 = 0;
            ArrayList a = u.uSD.a((Spannable) text, (e) nVar, s.EXACT);
            if (a.isEmpty()) {
                i3 = 0;
            } else {
                Iterator it = a.iterator();
                while (true) {
                    i4 = i5;
                    if (!it.hasNext()) {
                        break;
                    }
                    next = it.next();
                    if (next instanceof g) {
                        i5 = ((Integer) ((g) next).getValue()).intValue() + i4;
                    } else {
                        i5 = i4;
                    }
                }
                i3 = i4;
            }
            sparseIntArray.put(i2, i3);
            ArrayList a2 = a((Spannable) text, (e) nVar, s.SPAN_FLAGS);
            this.uRS.a(a2, nVar);
            boolean z = !a2.isEmpty();
            if (nVar.a(eVar)) {
                booleanValue = bool.booleanValue();
            } else {
                booleanValue = z;
            }
            if (i <= 0 || nVar.dfF() != 1 || ((n) paragraphs.get(i - 1)).dfF() != 1 || bool.booleanValue()) {
                next = null;
            } else {
                next = 1;
            }
            if (next != null) {
                z = false;
            } else {
                z = booleanValue;
            }
            if (z) {
                i4 = 1;
                for (int i6 = 1; i6 < i2; i6++) {
                    i5 = sparseIntArray.get(i6);
                    int i7 = sparseIntArray2.get(i6);
                    if (i5 < i3) {
                        i5 = 1;
                    } else if (i5 != i3) {
                    } else {
                        i5 = i7 == 0 ? 1 : i7 + 1;
                    }
                    i4 = i5;
                }
                sparseIntArray2.put(i2, i4);
                this.uRS.b(new m(i4, b.del(), nVar.isEmpty(), nVar.uRY, nVar.uRZ), nVar);
                u.uSB.a((Spannable) text, nVar, this.uRS);
                u.uSA.a((Spannable) text, nVar, this.uRS);
            }
            i++;
            i2++;
        }
        this.uRS.c(text);
        AppMethodBeat.o(26953);
    }

    public final int dfy() {
        return 2;
    }
}
