package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cdg */
public final class cdg extends C1331a {
    public cdh xcS;
    public cdf xcT;
    public cde xcU;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94631);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xcS != null) {
                c6093a.mo13479iy(1, this.xcS.computeSize());
                this.xcS.writeFields(c6093a);
            }
            if (this.xcT != null) {
                c6093a.mo13479iy(2, this.xcT.computeSize());
                this.xcT.writeFields(c6093a);
            }
            if (this.xcU != null) {
                c6093a.mo13479iy(3, this.xcU.computeSize());
                this.xcU.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(94631);
            return 0;
        } else if (i == 1) {
            if (this.xcS != null) {
                ix = C6087a.m9557ix(1, this.xcS.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.xcT != null) {
                ix += C6087a.m9557ix(2, this.xcT.computeSize());
            }
            if (this.xcU != null) {
                ix += C6087a.m9557ix(3, this.xcU.computeSize());
            }
            AppMethodBeat.m2505o(94631);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(94631);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cdg cdg = (cdg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdh cdh = new cdh();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdh.populateBuilderWithField(c6086a3, cdh, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cdg.xcS = cdh;
                    }
                    AppMethodBeat.m2505o(94631);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdf cdf = new cdf();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdf.populateBuilderWithField(c6086a3, cdf, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cdg.xcT = cdf;
                    }
                    AppMethodBeat.m2505o(94631);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cde cde = new cde();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cde.populateBuilderWithField(c6086a3, cde, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cdg.xcU = cde;
                    }
                    AppMethodBeat.m2505o(94631);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94631);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94631);
            return -1;
        }
    }
}
