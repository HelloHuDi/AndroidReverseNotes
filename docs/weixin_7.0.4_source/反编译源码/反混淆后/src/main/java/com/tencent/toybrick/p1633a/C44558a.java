package com.tencent.toybrick.p1633a;

import android.support.p069v7.p075h.C0595c.C0597a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.p680c.C44830g;
import java.util.List;

/* renamed from: com.tencent.toybrick.a.a */
public final class C44558a extends C0597a {
    private List<C44830g> AFL;
    private List<C44830g> AFM;

    public C44558a(List<C44830g> list, List<C44830g> list2) {
        this.AFL = list;
        this.AFM = list2;
    }

    /* renamed from: fV */
    public final int mo1477fV() {
        AppMethodBeat.m2504i(113175);
        if (this.AFL == null) {
            AppMethodBeat.m2505o(113175);
            return 0;
        }
        int size = this.AFL.size();
        AppMethodBeat.m2505o(113175);
        return size;
    }

    /* renamed from: fW */
    public final int mo1478fW() {
        AppMethodBeat.m2504i(113176);
        if (this.AFM == null) {
            AppMethodBeat.m2505o(113176);
            return 0;
        }
        int size = this.AFM.size();
        AppMethodBeat.m2505o(113176);
        return size;
    }

    /* renamed from: J */
    public final boolean mo1474J(int i, int i2) {
        AppMethodBeat.m2504i(113177);
        C44830g c44830g = (C44830g) this.AFL.get(i);
        C44830g c44830g2 = (C44830g) this.AFM.get(i2);
        if (c44830g == null || c44830g2 == null) {
            AppMethodBeat.m2505o(113177);
            return false;
        } else if (c44830g.hashCode() == c44830g2.hashCode()) {
            AppMethodBeat.m2505o(113177);
            return true;
        } else {
            AppMethodBeat.m2505o(113177);
            return false;
        }
    }

    /* renamed from: K */
    public final boolean mo1475K(int i, int i2) {
        AppMethodBeat.m2504i(113178);
        C44830g c44830g = (C44830g) this.AFL.get(i);
        C44830g c44830g2 = (C44830g) this.AFM.get(i2);
        if (c44830g == null || c44830g2 == null) {
            AppMethodBeat.m2505o(113178);
            return false;
        }
        boolean equals = c44830g.equals(c44830g2);
        AppMethodBeat.m2505o(113178);
        return equals;
    }
}
