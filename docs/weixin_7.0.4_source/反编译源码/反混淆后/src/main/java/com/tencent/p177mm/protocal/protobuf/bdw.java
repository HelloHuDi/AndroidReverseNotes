package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bdw */
public final class bdw extends C1331a {
    public cgv vCN;
    public String vJS;
    public LinkedList<cgv> vTB = new LinkedList();
    public String wHC;

    public bdw() {
        AppMethodBeat.m2504i(48901);
        AppMethodBeat.m2505o(48901);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48902);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vCN != null) {
                c6093a.mo13479iy(1, this.vCN.computeSize());
                this.vCN.writeFields(c6093a);
            }
            c6093a.mo13474e(2, 8, this.vTB);
            if (this.vJS != null) {
                c6093a.mo13475e(3, this.vJS);
            }
            if (this.wHC != null) {
                c6093a.mo13475e(4, this.wHC);
            }
            AppMethodBeat.m2505o(48902);
            return 0;
        } else if (i == 1) {
            if (this.vCN != null) {
                ix = C6087a.m9557ix(1, this.vCN.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6087a.m9552c(2, 8, this.vTB);
            if (this.vJS != null) {
                ix += C6091a.m9575f(3, this.vJS);
            }
            if (this.wHC != null) {
                ix += C6091a.m9575f(4, this.wHC);
            }
            AppMethodBeat.m2505o(48902);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vTB.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48902);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bdw bdw = (bdw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            cgv cgv;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv = new cgv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(c6086a3, cgv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bdw.vCN = cgv;
                    }
                    AppMethodBeat.m2505o(48902);
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
                        bdw.vTB.add(cgv);
                    }
                    AppMethodBeat.m2505o(48902);
                    return 0;
                case 3:
                    bdw.vJS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48902);
                    return 0;
                case 4:
                    bdw.wHC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48902);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48902);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48902);
            return -1;
        }
    }
}
