package com.tencent.p177mm.plugin.sns.p1025h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.sns.h.c */
public final class C21896c extends C1331a {
    public LinkedList<Long> qQf = new LinkedList();

    public C21896c() {
        AppMethodBeat.m2504i(36824);
        AppMethodBeat.m2505o(36824);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(36825);
        int c;
        if (i == 0) {
            ((C6093a) objArr[0]).mo13474e(1, 3, this.qQf);
            AppMethodBeat.m2505o(36825);
            return 0;
        } else if (i == 1) {
            c = C6087a.m9552c(1, 3, this.qQf) + 0;
            AppMethodBeat.m2505o(36825);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.qQf.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(36825);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C21896c c21896c = (C21896c) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c21896c.qQf.add(Long.valueOf(c6086a2.BTU.mo13459ve()));
                    AppMethodBeat.m2505o(36825);
                    return 0;
                default:
                    AppMethodBeat.m2505o(36825);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(36825);
            return -1;
        }
    }
}
