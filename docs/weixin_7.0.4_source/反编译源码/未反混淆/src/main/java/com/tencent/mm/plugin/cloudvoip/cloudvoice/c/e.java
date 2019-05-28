package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Timer;

public final class e {
    final ArrayList<a> kzA = new ArrayList(2);
    Timer kzB;
    final ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a> kzy = new ArrayList(10);
    ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a> kzz = new ArrayList(10);

    interface a {
        void v(ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a> arrayList);
    }

    public e() {
        AppMethodBeat.i(135479);
        AppMethodBeat.o(135479);
    }

    static /* synthetic */ boolean a(e eVar, ArrayList arrayList) {
        AppMethodBeat.i(135480);
        if (eVar.kzz == null) {
            AppMethodBeat.o(135480);
            return true;
        } else if (arrayList.size() != eVar.kzz.size()) {
            AppMethodBeat.o(135480);
            return false;
        } else {
            for (int i = 0; i < arrayList.size(); i++) {
                if (((com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a) arrayList.get(i)).kyZ != ((com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a) eVar.kzz.get(i)).kyZ) {
                    AppMethodBeat.o(135480);
                    return false;
                }
            }
            AppMethodBeat.o(135480);
            return true;
        }
    }
}
