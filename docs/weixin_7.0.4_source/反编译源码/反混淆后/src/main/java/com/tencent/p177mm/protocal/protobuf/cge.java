package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cge */
public final class cge extends C1331a {
    public bdq xfl;
    public LinkedList<ave> xfm = new LinkedList();
    public LinkedList<cgv> xfn = new LinkedList();

    public cge() {
        AppMethodBeat.m2504i(48967);
        AppMethodBeat.m2505o(48967);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48968);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xfl != null) {
                c6093a.mo13479iy(1, this.xfl.computeSize());
                this.xfl.writeFields(c6093a);
            }
            c6093a.mo13474e(2, 8, this.xfm);
            c6093a.mo13474e(3, 8, this.xfn);
            AppMethodBeat.m2505o(48968);
            return 0;
        } else if (i == 1) {
            if (this.xfl != null) {
                ix = C6087a.m9557ix(1, this.xfl.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int c = (ix + C6087a.m9552c(2, 8, this.xfm)) + C6087a.m9552c(3, 8, this.xfn);
            AppMethodBeat.m2505o(48968);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xfm.clear();
            this.xfn.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48968);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cge cge = (cge) objArr[1];
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
                        bdq bdq = new bdq();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdq.populateBuilderWithField(c6086a3, bdq, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cge.xfl = bdq;
                    }
                    AppMethodBeat.m2505o(48968);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ave ave = new ave();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ave.populateBuilderWithField(c6086a3, ave, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cge.xfm.add(ave);
                    }
                    AppMethodBeat.m2505o(48968);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv cgv = new cgv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(c6086a3, cgv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cge.xfn.add(cgv);
                    }
                    AppMethodBeat.m2505o(48968);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48968);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48968);
            return -1;
        }
    }
}
