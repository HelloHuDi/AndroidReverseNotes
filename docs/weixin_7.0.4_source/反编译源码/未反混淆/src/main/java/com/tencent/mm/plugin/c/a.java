package com.tencent.mm.plugin.c;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.kernel.api.e;
import com.tencent.mm.kernel.b.c;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.g;
import java.util.HashMap;
import java.util.regex.Pattern;

public final class a implements com.tencent.mm.kernel.api.a, e, c {
    private static final HashMap<Integer, d> eaA;
    private static a gLq;
    private g gLr;

    private a() {
    }

    public static synchronized a ask() {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(79047);
            if (gLq == null) {
                gLq = new a();
            }
            aVar = gLq;
            AppMethodBeat.o(79047);
        }
        return aVar;
    }

    public final g Yn() {
        AppMethodBeat.i(79048);
        com.tencent.mm.kernel.g.RN().QU();
        g gVar = this.gLr;
        AppMethodBeat.o(79048);
        return gVar;
    }

    public static boolean x(CharSequence charSequence) {
        AppMethodBeat.i(79049);
        if (bo.ac(charSequence) || !com.tencent.mm.kernel.g.RN().eJb) {
            AppMethodBeat.o(79049);
            return false;
        }
        try {
            String value = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("ClipProtectPattern");
            if (!bo.isNullOrNil(value)) {
                String str = new String(Base64.decode(value, 0));
                if (!bo.isNullOrNil(str) && Pattern.compile(str).matcher(charSequence).matches()) {
                    AppMethodBeat.o(79049);
                    return true;
                }
            }
        } catch (Exception e) {
        }
        AppMethodBeat.o(79049);
        return false;
    }

    public final void onDataBaseOpened(h hVar, h hVar2) {
        AppMethodBeat.i(79050);
        this.gLr = new g(hVar);
        AppMethodBeat.o(79050);
    }

    public final void onDataBaseClosed(h hVar, h hVar2) {
    }

    public final HashMap<Integer, d> collectDatabaseFactory() {
        return eaA;
    }

    static {
        AppMethodBeat.i(79051);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("AddContactAntispamTicket".hashCode()), new d() {
            public final String[] Af() {
                return g.fnj;
            }
        });
        AppMethodBeat.o(79051);
    }
}
