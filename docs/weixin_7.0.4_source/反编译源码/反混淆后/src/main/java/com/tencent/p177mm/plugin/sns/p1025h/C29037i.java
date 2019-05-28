package com.tencent.p177mm.plugin.sns.p1025h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.sns.h.i */
public final class C29037i extends C1331a {
    public LinkedList<C21897h> qQr = new LinkedList();
    public C43547g qQs;

    public C29037i() {
        AppMethodBeat.m2504i(36832);
        AppMethodBeat.m2505o(36832);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(36833);
        int c;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13474e(1, 8, this.qQr);
            if (this.qQs != null) {
                c6093a.mo13479iy(2, this.qQs.computeSize());
                this.qQs.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(36833);
            return 0;
        } else if (i == 1) {
            c = C6087a.m9552c(1, 8, this.qQr) + 0;
            if (this.qQs != null) {
                c += C6087a.m9557ix(2, this.qQs.computeSize());
            }
            AppMethodBeat.m2505o(36833);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.qQr.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(36833);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C29037i c29037i = (C29037i) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C21897h c21897h = new C21897h();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c21897h.populateBuilderWithField(c6086a3, c21897h, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c29037i.qQr.add(c21897h);
                    }
                    AppMethodBeat.m2505o(36833);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C43547g c43547g = new C43547g();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c43547g.populateBuilderWithField(c6086a3, c43547g, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c29037i.qQs = c43547g;
                    }
                    AppMethodBeat.m2505o(36833);
                    return 0;
                default:
                    AppMethodBeat.m2505o(36833);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(36833);
            return -1;
        }
    }
}
