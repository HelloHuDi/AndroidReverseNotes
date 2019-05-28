package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ui */
public final class C15387ui extends C1331a {
    public int state;
    public cgv vCN;
    public String vJS;
    public LinkedList<cgv> vTB = new LinkedList();
    public LinkedList<cgv> wbU = new LinkedList();
    public String wbV;

    public C15387ui() {
        AppMethodBeat.m2504i(48826);
        AppMethodBeat.m2505o(48826);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48827);
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.state);
            if (this.vCN != null) {
                c6093a.mo13479iy(2, this.vCN.computeSize());
                this.vCN.writeFields(c6093a);
            }
            c6093a.mo13474e(3, 8, this.vTB);
            c6093a.mo13474e(4, 8, this.wbU);
            if (this.wbV != null) {
                c6093a.mo13475e(5, this.wbV);
            }
            if (this.vJS != null) {
                c6093a.mo13475e(6, this.vJS);
            }
            AppMethodBeat.m2505o(48827);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.state) + 0;
            if (this.vCN != null) {
                bs += C6087a.m9557ix(2, this.vCN.computeSize());
            }
            bs = (bs + C6087a.m9552c(3, 8, this.vTB)) + C6087a.m9552c(4, 8, this.wbU);
            if (this.wbV != null) {
                bs += C6091a.m9575f(5, this.wbV);
            }
            if (this.vJS != null) {
                bs += C6091a.m9575f(6, this.vJS);
            }
            AppMethodBeat.m2505o(48827);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vTB.clear();
            this.wbU.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48827);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C15387ui c15387ui = (C15387ui) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            cgv cgv;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c15387ui.state = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48827);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv = new cgv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(c6086a3, cgv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15387ui.vCN = cgv;
                    }
                    AppMethodBeat.m2505o(48827);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv = new cgv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(c6086a3, cgv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15387ui.vTB.add(cgv);
                    }
                    AppMethodBeat.m2505o(48827);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv = new cgv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(c6086a3, cgv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15387ui.wbU.add(cgv);
                    }
                    AppMethodBeat.m2505o(48827);
                    return 0;
                case 5:
                    c15387ui.wbV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48827);
                    return 0;
                case 6:
                    c15387ui.vJS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48827);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48827);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48827);
            return -1;
        }
    }
}
