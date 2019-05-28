package com.tencent.p124c.p125a.p126a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.c.a.a.r */
public final class C0914r {
    private static C0914r cbL = null;
    private Map<Integer, C25595q> cbJ;
    private int cbK;

    private C0914r(Context context) {
        AppMethodBeat.m2504i(125724);
        this.cbJ = null;
        this.cbK = 0;
        this.cbJ = new HashMap(3);
        this.cbJ.put(Integer.valueOf(1), new C32107o(context));
        this.cbJ.put(Integer.valueOf(2), new C37312d(context));
        this.cbJ.put(Integer.valueOf(4), new C8758k(context));
        AppMethodBeat.m2505o(125724);
    }

    /* renamed from: aI */
    static synchronized C0914r m2068aI(Context context) {
        C0914r c0914r;
        synchronized (C0914r.class) {
            AppMethodBeat.m2504i(125725);
            if (cbL == null) {
                cbL = new C0914r(context);
            }
            c0914r = cbL;
            AppMethodBeat.m2505o(125725);
        }
        return c0914r;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: zV */
    public final C37314g mo3747zV() {
        AppMethodBeat.m2504i(125726);
        C37314g F = mo3744F(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4)})));
        AppMethodBeat.m2505o(125726);
        return F;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: F */
    public final C37314g mo3744F(List<Integer> list) {
        C37314g zV;
        AppMethodBeat.m2504i(125727);
        if (list.size() >= 0) {
            for (Integer num : list) {
                C25595q c25595q = (C25595q) this.cbJ.get(num);
                if (c25595q != null) {
                    zV = c25595q.mo43323zV();
                    if (zV != null && C0916s.m2086cp(zV.cbr)) {
                        AppMethodBeat.m2505o(125727);
                        return zV;
                    }
                }
            }
        }
        zV = new C37314g();
        AppMethodBeat.m2505o(125727);
        return zV;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: zW */
    public final C25593a mo3748zW() {
        AppMethodBeat.m2504i(125728);
        C25593a G = m2067G(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(4)})));
        AppMethodBeat.m2505o(125728);
        return G;
    }

    /* renamed from: G */
    private C25593a m2067G(List<Integer> list) {
        C25593a zW;
        AppMethodBeat.m2504i(125729);
        if (list.size() > 0) {
            for (Integer num : list) {
                C25595q c25595q = (C25595q) this.cbJ.get(num);
                if (c25595q != null) {
                    zW = c25595q.mo43324zW();
                    if (zW != null) {
                        AppMethodBeat.m2505o(125729);
                        return zW;
                    }
                }
            }
        }
        zW = new C25593a();
        AppMethodBeat.m2505o(125729);
        return zW;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo3745b(C25593a c25593a) {
        AppMethodBeat.m2504i(125730);
        for (Entry value : this.cbJ.entrySet()) {
            ((C25595q) value.getValue()).mo43321b(c25593a);
        }
        AppMethodBeat.m2505o(125730);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo3746b(C37314g c37314g) {
        AppMethodBeat.m2504i(125731);
        for (Entry value : this.cbJ.entrySet()) {
            ((C25595q) value.getValue()).mo43322b(c37314g);
        }
        AppMethodBeat.m2505o(125731);
    }
}
