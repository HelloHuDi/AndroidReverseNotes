package com.tencent.p177mm.plugin.backup.p921i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.backup.i.j */
public final class C45752j extends C1331a {
    public LinkedList<String> jBx = new LinkedList();
    public LinkedList<Long> jBy = new LinkedList();

    public C45752j() {
        AppMethodBeat.m2504i(18055);
        AppMethodBeat.m2505o(18055);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(18056);
        int c;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13474e(1, 1, this.jBx);
            c6093a.mo13474e(2, 3, this.jBy);
            AppMethodBeat.m2505o(18056);
            return 0;
        } else if (i == 1) {
            c = (C6087a.m9552c(1, 1, this.jBx) + 0) + C6087a.m9552c(2, 3, this.jBy);
            AppMethodBeat.m2505o(18056);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.jBx.clear();
            this.jBy.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(18056);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C45752j c45752j = (C45752j) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c45752j.jBx.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(18056);
                    return 0;
                case 2:
                    c45752j.jBy.add(Long.valueOf(c6086a2.BTU.mo13459ve()));
                    AppMethodBeat.m2505o(18056);
                    return 0;
                default:
                    AppMethodBeat.m2505o(18056);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(18056);
            return -1;
        }
    }
}
