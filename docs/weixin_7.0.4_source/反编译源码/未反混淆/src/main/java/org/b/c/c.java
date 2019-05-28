package org.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import org.b.d.e;
import org.b.g.d;

public final class c implements b {
    public final String a(org.b.d.c cVar) {
        AppMethodBeat.i(77241);
        d.r(cVar, "Cannot extract base string from null object");
        if (cVar.BYN == null || cVar.BYN.size() <= 0) {
            org.b.b.c cVar2 = new org.b.b.c(cVar);
            AppMethodBeat.o(77241);
            throw cVar2;
        }
        String encode = org.b.g.c.encode(cVar.emZ().name());
        String encode2 = org.b.g.c.encode(cVar.enf());
        e eVar = new e();
        eVar.a(cVar.emY());
        eVar.a(cVar.ene());
        eVar.a(new e(cVar.BYN));
        e eVar2 = new e(eVar.BYO);
        Collections.sort(eVar2.BYO);
        String encode3 = org.b.g.c.encode(eVar2.enh());
        encode = String.format("%s&%s&%s", new Object[]{encode, encode2, encode3});
        AppMethodBeat.o(77241);
        return encode;
    }
}
