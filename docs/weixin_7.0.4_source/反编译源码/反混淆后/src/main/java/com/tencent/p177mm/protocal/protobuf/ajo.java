package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ajo */
public final class ajo extends C1331a {
    public LinkedList<ajn> wpm = new LinkedList();
    public ajm wpn;

    public ajo() {
        AppMethodBeat.m2504i(10177);
        AppMethodBeat.m2505o(10177);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(10178);
        int c;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13474e(1, 8, this.wpm);
            if (this.wpn != null) {
                c6093a.mo13479iy(2, this.wpn.computeSize());
                this.wpn.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(10178);
            return 0;
        } else if (i == 1) {
            c = C6087a.m9552c(1, 8, this.wpm) + 0;
            if (this.wpn != null) {
                c += C6087a.m9557ix(2, this.wpn.computeSize());
            }
            AppMethodBeat.m2505o(10178);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wpm.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(10178);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ajo ajo = (ajo) objArr[1];
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
                        ajn ajn = new ajn();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ajn.populateBuilderWithField(c6086a3, ajn, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ajo.wpm.add(ajn);
                    }
                    AppMethodBeat.m2505o(10178);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ajm ajm = new ajm();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ajm.populateBuilderWithField(c6086a3, ajm, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ajo.wpn = ajm;
                    }
                    AppMethodBeat.m2505o(10178);
                    return 0;
                default:
                    AppMethodBeat.m2505o(10178);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(10178);
            return -1;
        }
    }
}
