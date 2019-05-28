package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ba */
public final class C23370ba extends C1331a {
    public LinkedList<C46524az> vCQ = new LinkedList();
    public cgv vCR;

    public C23370ba() {
        AppMethodBeat.m2504i(48770);
        AppMethodBeat.m2505o(48770);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48771);
        int c;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13474e(1, 8, this.vCQ);
            if (this.vCR != null) {
                c6093a.mo13479iy(2, this.vCR.computeSize());
                this.vCR.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(48771);
            return 0;
        } else if (i == 1) {
            c = C6087a.m9552c(1, 8, this.vCQ) + 0;
            if (this.vCR != null) {
                c += C6087a.m9557ix(2, this.vCR.computeSize());
            }
            AppMethodBeat.m2505o(48771);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vCQ.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48771);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23370ba c23370ba = (C23370ba) objArr[1];
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
                        C46524az c46524az = new C46524az();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c46524az.populateBuilderWithField(c6086a3, c46524az, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c23370ba.vCQ.add(c46524az);
                    }
                    AppMethodBeat.m2505o(48771);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv cgv = new cgv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(c6086a3, cgv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c23370ba.vCR = cgv;
                    }
                    AppMethodBeat.m2505o(48771);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48771);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48771);
            return -1;
        }
    }
}
