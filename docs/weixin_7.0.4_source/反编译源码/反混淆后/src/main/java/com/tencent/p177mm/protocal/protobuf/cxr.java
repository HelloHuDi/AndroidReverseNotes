package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cxr */
public final class cxr extends C1331a {
    public cxt xtd;
    public cxs xte;
    public cxu xtf;
    public cxw xtg;
    public cxv xth;
    public cxx xti;
    public cxq xtj;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(115018);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xtd != null) {
                c6093a.mo13479iy(1, this.xtd.computeSize());
                this.xtd.writeFields(c6093a);
            }
            if (this.xte != null) {
                c6093a.mo13479iy(2, this.xte.computeSize());
                this.xte.writeFields(c6093a);
            }
            if (this.xtf != null) {
                c6093a.mo13479iy(3, this.xtf.computeSize());
                this.xtf.writeFields(c6093a);
            }
            if (this.xtg != null) {
                c6093a.mo13479iy(4, this.xtg.computeSize());
                this.xtg.writeFields(c6093a);
            }
            if (this.xth != null) {
                c6093a.mo13479iy(5, this.xth.computeSize());
                this.xth.writeFields(c6093a);
            }
            if (this.xti != null) {
                c6093a.mo13479iy(6, this.xti.computeSize());
                this.xti.writeFields(c6093a);
            }
            if (this.xtj != null) {
                c6093a.mo13479iy(7, this.xtj.computeSize());
                this.xtj.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(115018);
            return 0;
        } else if (i == 1) {
            if (this.xtd != null) {
                ix = C6087a.m9557ix(1, this.xtd.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.xte != null) {
                ix += C6087a.m9557ix(2, this.xte.computeSize());
            }
            if (this.xtf != null) {
                ix += C6087a.m9557ix(3, this.xtf.computeSize());
            }
            if (this.xtg != null) {
                ix += C6087a.m9557ix(4, this.xtg.computeSize());
            }
            if (this.xth != null) {
                ix += C6087a.m9557ix(5, this.xth.computeSize());
            }
            if (this.xti != null) {
                ix += C6087a.m9557ix(6, this.xti.computeSize());
            }
            if (this.xtj != null) {
                ix += C6087a.m9557ix(7, this.xtj.computeSize());
            }
            AppMethodBeat.m2505o(115018);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(115018);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cxr cxr = (cxr) objArr[1];
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
                        cxt cxt = new cxt();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cxt.populateBuilderWithField(c6086a3, cxt, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cxr.xtd = cxt;
                    }
                    AppMethodBeat.m2505o(115018);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cxs cxs = new cxs();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cxs.populateBuilderWithField(c6086a3, cxs, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cxr.xte = cxs;
                    }
                    AppMethodBeat.m2505o(115018);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cxu cxu = new cxu();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cxu.populateBuilderWithField(c6086a3, cxu, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cxr.xtf = cxu;
                    }
                    AppMethodBeat.m2505o(115018);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cxw cxw = new cxw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cxw.populateBuilderWithField(c6086a3, cxw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cxr.xtg = cxw;
                    }
                    AppMethodBeat.m2505o(115018);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cxv cxv = new cxv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cxv.populateBuilderWithField(c6086a3, cxv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cxr.xth = cxv;
                    }
                    AppMethodBeat.m2505o(115018);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cxx cxx = new cxx();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cxx.populateBuilderWithField(c6086a3, cxx, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cxr.xti = cxx;
                    }
                    AppMethodBeat.m2505o(115018);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cxq cxq = new cxq();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cxq.populateBuilderWithField(c6086a3, cxq, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cxr.xtj = cxq;
                    }
                    AppMethodBeat.m2505o(115018);
                    return 0;
                default:
                    AppMethodBeat.m2505o(115018);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(115018);
            return -1;
        }
    }
}
