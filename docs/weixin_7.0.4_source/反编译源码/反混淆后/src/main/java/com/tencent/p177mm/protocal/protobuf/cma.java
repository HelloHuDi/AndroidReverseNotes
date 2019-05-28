package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cma */
public final class cma extends C1331a {
    public String title;
    public LinkedList<cgf> xjK = new LinkedList();
    public LinkedList<cgf> xjL = new LinkedList();
    public LinkedList<C23446tm> xjM = new LinkedList();

    public cma() {
        AppMethodBeat.m2504i(89150);
        AppMethodBeat.m2505o(89150);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(89151);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.title != null) {
                c6093a.mo13475e(1, this.title);
            }
            c6093a.mo13474e(2, 8, this.xjK);
            c6093a.mo13474e(3, 8, this.xjL);
            c6093a.mo13474e(4, 8, this.xjM);
            AppMethodBeat.m2505o(89151);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = C6091a.m9575f(1, this.title) + 0;
            } else {
                f = 0;
            }
            int c = ((f + C6087a.m9552c(2, 8, this.xjK)) + C6087a.m9552c(3, 8, this.xjL)) + C6087a.m9552c(4, 8, this.xjM);
            AppMethodBeat.m2505o(89151);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xjK.clear();
            this.xjL.clear();
            this.xjM.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(89151);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cma cma = (cma) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            cgf cgf;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    cma.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89151);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgf = new cgf();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgf.populateBuilderWithField(c6086a3, cgf, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cma.xjK.add(cgf);
                    }
                    AppMethodBeat.m2505o(89151);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgf = new cgf();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgf.populateBuilderWithField(c6086a3, cgf, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cma.xjL.add(cgf);
                    }
                    AppMethodBeat.m2505o(89151);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C23446tm c23446tm = new C23446tm();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23446tm.populateBuilderWithField(c6086a3, c23446tm, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cma.xjM.add(c23446tm);
                    }
                    AppMethodBeat.m2505o(89151);
                    return 0;
                default:
                    AppMethodBeat.m2505o(89151);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(89151);
            return -1;
        }
    }
}
