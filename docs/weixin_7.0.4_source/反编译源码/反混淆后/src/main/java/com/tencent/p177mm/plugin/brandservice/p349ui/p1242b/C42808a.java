package com.tencent.p177mm.plugin.brandservice.p349ui.p1242b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.offenread.C42822d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.storage.C46627q;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.b.a */
public final class C42808a {
    public static int jYZ = 180;
    private static long jZa = 43200000;
    private static long jZb = 0;

    /* renamed from: gP */
    public static void m75914gP(long j) {
        jZa = j;
    }

    public static long aYQ() {
        if (jZa <= 0) {
            jZa = 43200000;
        }
        return jZa;
    }

    /* renamed from: gQ */
    public static void m75915gQ(long j) {
        jZb = j;
    }

    /* renamed from: e */
    public static boolean m75913e(C46627q c46627q) {
        AppMethodBeat.m2504i(14446);
        if (c46627q == null) {
            AppMethodBeat.m2505o(14446);
            return false;
        }
        int i;
        c46627q.xHU = C42822d.m75969FG(c46627q.field_talker);
        if ((c46627q.field_bitFlag & 1) != 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            AppMethodBeat.m2505o(14446);
            return true;
        } else if (C42808a.m75916sG(2) && c46627q.xHU) {
            AppMethodBeat.m2505o(14446);
            return true;
        } else {
            if (C42808a.m75916sG(1)) {
                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c46627q.field_talker);
                if (aoO != null && aoO.mo16702Oe()) {
                    AppMethodBeat.m2505o(14446);
                    return true;
                }
            }
            AppMethodBeat.m2505o(14446);
            return false;
        }
    }

    /* renamed from: sG */
    public static boolean m75916sG(int i) {
        return (jZb & ((long) i)) != 0;
    }
}
