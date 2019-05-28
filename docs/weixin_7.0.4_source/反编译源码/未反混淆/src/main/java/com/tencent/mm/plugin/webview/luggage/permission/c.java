package com.tencent.mm.plugin.webview.luggage.permission;

import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.protocal.c.g;
import java.util.HashSet;
import java.util.Set;

public final class c implements a {
    private d uiI;
    private LuggageGetA8Key uii;
    private Set<String> ulu = new HashSet();

    public c(d dVar, LuggageGetA8Key luggageGetA8Key) {
        AppMethodBeat.i(6490);
        this.uiI = dVar;
        this.uii = luggageGetA8Key;
        AppMethodBeat.o(6490);
    }

    public final void aen(String str) {
        AppMethodBeat.i(6491);
        this.ulu.add(str);
        AppMethodBeat.o(6491);
    }

    public final void a(com.tencent.luggage.d.a.c cVar) {
        AppMethodBeat.i(6492);
        cVar.a(b.PASS);
        AppMethodBeat.o(6492);
    }

    public final void a(String str, com.tencent.luggage.d.a.c cVar) {
        AppMethodBeat.i(6493);
        if (this.ulu.contains(str)) {
            this.ulu.remove(str);
            cVar.a(b.PASS);
            AppMethodBeat.o(6493);
            return;
        }
        int i;
        LuggageGetA8Key luggageGetA8Key = this.uii;
        String url = this.uiI.getUrl();
        g akD = com.tencent.mm.protocal.c.akD(str);
        if (akD == null) {
            i = -1;
        } else {
            i = akD.dmb();
        }
        cVar.a(luggageGetA8Key.dA(url, i) ? b.PASS : b.REJECT);
        AppMethodBeat.o(6493);
    }
}
