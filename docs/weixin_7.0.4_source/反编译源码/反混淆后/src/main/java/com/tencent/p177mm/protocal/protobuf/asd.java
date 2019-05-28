package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.asd */
public final class asd extends C1331a {
    public cgv vCN;
    public LinkedList<bzy> vCQ = new LinkedList();
    public String vJS;

    public asd() {
        AppMethodBeat.m2504i(48861);
        AppMethodBeat.m2505o(48861);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48862);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vCN != null) {
                c6093a.mo13479iy(1, this.vCN.computeSize());
                this.vCN.writeFields(c6093a);
            }
            c6093a.mo13474e(2, 8, this.vCQ);
            if (this.vJS != null) {
                c6093a.mo13475e(3, this.vJS);
            }
            AppMethodBeat.m2505o(48862);
            return 0;
        } else if (i == 1) {
            if (this.vCN != null) {
                ix = C6087a.m9557ix(1, this.vCN.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6087a.m9552c(2, 8, this.vCQ);
            if (this.vJS != null) {
                ix += C6091a.m9575f(3, this.vJS);
            }
            AppMethodBeat.m2505o(48862);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vCQ.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48862);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            asd asd = (asd) objArr[1];
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
                        cgv cgv = new cgv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(c6086a3, cgv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        asd.vCN = cgv;
                    }
                    AppMethodBeat.m2505o(48862);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzy bzy = new bzy();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzy.populateBuilderWithField(c6086a3, bzy, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        asd.vCQ.add(bzy);
                    }
                    AppMethodBeat.m2505o(48862);
                    return 0;
                case 3:
                    asd.vJS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48862);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48862);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48862);
            return -1;
        }
    }
}
