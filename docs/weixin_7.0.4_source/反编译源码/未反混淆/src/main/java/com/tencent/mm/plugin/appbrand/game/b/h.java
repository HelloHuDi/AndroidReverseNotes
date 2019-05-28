package com.tencent.mm.plugin.appbrand.game.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.game.b.a.b;
import com.tencent.mm.plugin.fts.a.a.l;
import java.util.Comparator;

public final class h implements Comparator<l> {
    public static final h hri = new h();

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        AppMethodBeat.i(130091);
        l lVar = (l) obj;
        if (f.avb() != null) {
            b As = f.avb().As(lVar.mDx);
            if (As != null && As.field_isSync) {
                AppMethodBeat.o(130091);
                return 1;
            }
        }
        AppMethodBeat.o(130091);
        return -1;
    }

    static {
        AppMethodBeat.i(130092);
        AppMethodBeat.o(130092);
    }
}
