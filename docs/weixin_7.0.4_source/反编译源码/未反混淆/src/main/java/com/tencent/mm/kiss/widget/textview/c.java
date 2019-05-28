package com.tencent.mm.kiss.widget.textview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.a.a;
import java.util.concurrent.ConcurrentHashMap;

public final class c {
    public static c eNj = new c();
    public ConcurrentHashMap<Integer, b> eNk = new ConcurrentHashMap();

    public c() {
        AppMethodBeat.i(105694);
        AppMethodBeat.o(105694);
    }

    static {
        AppMethodBeat.i(105699);
        AppMethodBeat.o(105699);
    }

    public final void a(a aVar, f fVar) {
        AppMethodBeat.i(105695);
        if (aVar == null) {
            AppMethodBeat.o(105695);
            return;
        }
        b bVar = (b) this.eNk.get(Integer.valueOf(aVar.hashCode()));
        if (bVar != null) {
            bVar.a(fVar);
            this.eNk.put(Integer.valueOf(aVar.hashCode()), bVar);
            AppMethodBeat.o(105695);
            return;
        }
        bVar = new b();
        bVar.a(fVar);
        this.eNk.put(Integer.valueOf(aVar.hashCode()), bVar);
        AppMethodBeat.o(105695);
    }

    public final f a(a aVar, CharSequence charSequence) {
        AppMethodBeat.i(105696);
        if (aVar != null) {
            b bVar = (b) this.eNk.get(Integer.valueOf(aVar.hashCode()));
            if (bVar != null) {
                f u = bVar.u(charSequence);
                AppMethodBeat.o(105696);
                return u;
            }
        }
        AppMethodBeat.o(105696);
        return null;
    }

    public final void SN() {
        AppMethodBeat.i(105697);
        for (b bVar : this.eNk.values()) {
            bVar.eNi.clear();
        }
        this.eNk.clear();
        AppMethodBeat.o(105697);
    }

    public static int a(a aVar) {
        AppMethodBeat.i(105698);
        int hashCode = aVar.hashCode();
        AppMethodBeat.o(105698);
        return hashCode;
    }
}
