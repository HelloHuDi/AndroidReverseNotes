package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class p {
    final ArrayList<a> uSf = new ArrayList();

    static class a {
        final f uSg;
        final n uSh;
        final boolean uSi;

        a(Object obj, n nVar, boolean z) {
            AppMethodBeat.i(26960);
            this.uSg = (f) obj;
            this.uSh = nVar;
            this.uSi = z;
            AppMethodBeat.o(26960);
        }
    }

    public p() {
        AppMethodBeat.i(26961);
        AppMethodBeat.o(26961);
    }

    public final void a(ArrayList<Object> arrayList, n nVar) {
        AppMethodBeat.i(26962);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a(it.next(), nVar);
        }
        AppMethodBeat.o(26962);
    }

    private void a(Object obj, n nVar) {
        AppMethodBeat.i(26963);
        if (obj instanceof f) {
            this.uSf.add(new a(obj, nVar, true));
        }
        AppMethodBeat.o(26963);
    }

    public final void b(Object obj, n nVar) {
        AppMethodBeat.i(26964);
        this.uSf.add(new a(obj, nVar, false));
        AppMethodBeat.o(26964);
    }

    public final void c(Spannable spannable) {
        AppMethodBeat.i(26965);
        Iterator it = this.uSf.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            f fVar = aVar.uSg;
            int i = aVar.uSh.aqm;
            int spanStart;
            if (aVar.uSi) {
                spanStart = spannable.getSpanStart(fVar);
                if (spanStart >= 0 && spanStart < i) {
                    spannable.setSpan(fVar.dfC(), spanStart, i, 34);
                }
                spannable.removeSpan(fVar);
            } else {
                n nVar = aVar.uSh;
                int i2 = aVar.uSh.Ls;
                spanStart = (nVar.uRZ && nVar.isEmpty()) ? 34 : (nVar.uRZ && nVar.uRY) ? 18 : nVar.uRZ ? 34 : 33;
                if (i2 > spannable.length()) {
                    i2 = spannable.length();
                }
                spannable.setSpan(fVar, i, i2, spanStart);
            }
        }
        AppMethodBeat.o(26965);
    }
}
