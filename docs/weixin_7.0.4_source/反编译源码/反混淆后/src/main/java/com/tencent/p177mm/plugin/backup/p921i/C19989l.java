package com.tencent.p177mm.plugin.backup.p921i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.backup.i.l */
public final class C19989l extends C1331a {
    public LinkedList<C38663k> jBC = new LinkedList();
    public int jBD;

    public C19989l() {
        AppMethodBeat.m2504i(18058);
        AppMethodBeat.m2505o(18058);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(18059);
        int c;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13474e(1, 8, this.jBC);
            c6093a.mo13480iz(2, this.jBD);
            AppMethodBeat.m2505o(18059);
            return 0;
        } else if (i == 1) {
            c = (C6087a.m9552c(1, 8, this.jBC) + 0) + C6091a.m9572bs(2, this.jBD);
            AppMethodBeat.m2505o(18059);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.jBC.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(18059);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C19989l c19989l = (C19989l) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C38663k c38663k = new C38663k();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c38663k.populateBuilderWithField(c6086a3, c38663k, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c19989l.jBC.add(c38663k);
                    }
                    AppMethodBeat.m2505o(18059);
                    return 0;
                case 2:
                    c19989l.jBD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18059);
                    return 0;
                default:
                    AppMethodBeat.m2505o(18059);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(18059);
            return -1;
        }
    }
}
