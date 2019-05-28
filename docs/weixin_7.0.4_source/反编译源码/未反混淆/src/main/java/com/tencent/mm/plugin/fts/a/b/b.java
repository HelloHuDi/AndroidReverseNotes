package com.tencent.mm.plugin.fts.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public final class b {
    private HashSet<String> mEQ = new HashSet();
    public c mER = new c(' ');

    public b() {
        AppMethodBeat.i(114284);
        AppMethodBeat.o(114284);
    }

    public final void Ni(String str) {
        AppMethodBeat.i(114285);
        if (this.mEQ.add(str)) {
            c cVar = this.mER;
            char[] toCharArray = str.toLowerCase().toCharArray();
            for (int i = 0; i < toCharArray.length; i++) {
                int i2 = toCharArray[i] - 97;
                if (cVar.mES[i2] == null) {
                    cVar.mES[i2] = new c(toCharArray[i]);
                }
                cVar = cVar.mES[i2];
            }
            cVar.mEP = true;
            AppMethodBeat.o(114285);
            return;
        }
        AppMethodBeat.o(114285);
    }

    public final List<List<String>> Nj(String str) {
        AppMethodBeat.i(114286);
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.offer(new a(0, 0, null));
        char[] toCharArray = str.toLowerCase().toCharArray();
        ArrayList arrayList = new ArrayList();
        while (!arrayDeque.isEmpty()) {
            a aVar = (a) arrayDeque.poll();
            if (aVar == null) {
                break;
            }
            int i = aVar.end;
            c cVar = this.mER;
            while (i < toCharArray.length) {
                int i2 = toCharArray[i] - 97;
                if (cVar.mES[i2] == null) {
                    break;
                }
                cVar = cVar.mES[i2];
                if (cVar.mEP || i == toCharArray.length - 1) {
                    if (aVar.bnR == null) {
                        aVar.bnR = new ArrayList();
                    }
                    a aVar2 = new a(aVar.end, i + 1, aVar);
                    aVar.bnR.add(aVar2);
                    if (aVar2.end == toCharArray.length) {
                        aVar2.mEP = true;
                    }
                    arrayDeque.offer(aVar2);
                }
                i++;
            }
            if (aVar.mEP) {
                ArrayList arrayList2 = new ArrayList();
                while (aVar != null) {
                    if (aVar.end > aVar.start) {
                        arrayList2.add(str.substring(aVar.start, aVar.end));
                    }
                    aVar = aVar.mEO;
                }
                Collections.reverse(arrayList2);
                arrayList.add(arrayList2);
            }
        }
        AppMethodBeat.o(114286);
        return arrayList;
    }
}
