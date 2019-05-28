package com.tencent.c.a.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class r {
    private static r cbL = null;
    private Map<Integer, q> cbJ;
    private int cbK;

    private r(Context context) {
        AppMethodBeat.i(125724);
        this.cbJ = null;
        this.cbK = 0;
        this.cbJ = new HashMap(3);
        this.cbJ.put(Integer.valueOf(1), new o(context));
        this.cbJ.put(Integer.valueOf(2), new d(context));
        this.cbJ.put(Integer.valueOf(4), new k(context));
        AppMethodBeat.o(125724);
    }

    static synchronized r aI(Context context) {
        r rVar;
        synchronized (r.class) {
            AppMethodBeat.i(125725);
            if (cbL == null) {
                cbL = new r(context);
            }
            rVar = cbL;
            AppMethodBeat.o(125725);
        }
        return rVar;
    }

    /* Access modifiers changed, original: final */
    public final g zV() {
        AppMethodBeat.i(125726);
        g F = F(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4)})));
        AppMethodBeat.o(125726);
        return F;
    }

    /* Access modifiers changed, original: final */
    public final g F(List<Integer> list) {
        g zV;
        AppMethodBeat.i(125727);
        if (list.size() >= 0) {
            for (Integer num : list) {
                q qVar = (q) this.cbJ.get(num);
                if (qVar != null) {
                    zV = qVar.zV();
                    if (zV != null && s.cp(zV.cbr)) {
                        AppMethodBeat.o(125727);
                        return zV;
                    }
                }
            }
        }
        zV = new g();
        AppMethodBeat.o(125727);
        return zV;
    }

    /* Access modifiers changed, original: final */
    public final a zW() {
        AppMethodBeat.i(125728);
        a G = G(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(4)})));
        AppMethodBeat.o(125728);
        return G;
    }

    private a G(List<Integer> list) {
        a zW;
        AppMethodBeat.i(125729);
        if (list.size() > 0) {
            for (Integer num : list) {
                q qVar = (q) this.cbJ.get(num);
                if (qVar != null) {
                    zW = qVar.zW();
                    if (zW != null) {
                        AppMethodBeat.o(125729);
                        return zW;
                    }
                }
            }
        }
        zW = new a();
        AppMethodBeat.o(125729);
        return zW;
    }

    /* Access modifiers changed, original: final */
    public final void b(a aVar) {
        AppMethodBeat.i(125730);
        for (Entry value : this.cbJ.entrySet()) {
            ((q) value.getValue()).b(aVar);
        }
        AppMethodBeat.o(125730);
    }

    /* Access modifiers changed, original: final */
    public final void b(g gVar) {
        AppMethodBeat.i(125731);
        for (Entry value : this.cbJ.entrySet()) {
            ((q) value.getValue()).b(gVar);
        }
        AppMethodBeat.o(125731);
    }
}
