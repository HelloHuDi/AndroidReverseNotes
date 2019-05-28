package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.axq */
public final class axq extends bsr {
    public String fKh;
    public cwf wBB;
    public cxm wBC;
    public cxe wBD;
    public cyb wBE;
    public cxj wBF;
    public cxn wBG;
    public int wBH;
    public int wsv;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(96273);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.fKh != null) {
                c6093a.mo13475e(2, this.fKh);
            }
            if (this.wBB != null) {
                c6093a.mo13479iy(3, this.wBB.computeSize());
                this.wBB.writeFields(c6093a);
            }
            c6093a.mo13480iz(4, this.wsv);
            if (this.wBC != null) {
                c6093a.mo13479iy(5, this.wBC.computeSize());
                this.wBC.writeFields(c6093a);
            }
            if (this.wBD != null) {
                c6093a.mo13479iy(6, this.wBD.computeSize());
                this.wBD.writeFields(c6093a);
            }
            if (this.wBE != null) {
                c6093a.mo13479iy(7, this.wBE.computeSize());
                this.wBE.writeFields(c6093a);
            }
            if (this.wBF != null) {
                c6093a.mo13479iy(8, this.wBF.computeSize());
                this.wBF.writeFields(c6093a);
            }
            if (this.wBG != null) {
                c6093a.mo13479iy(9, this.wBG.computeSize());
                this.wBG.writeFields(c6093a);
            }
            c6093a.mo13480iz(10, this.wBH);
            AppMethodBeat.m2505o(96273);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.fKh != null) {
                ix += C6091a.m9575f(2, this.fKh);
            }
            if (this.wBB != null) {
                ix += C6087a.m9557ix(3, this.wBB.computeSize());
            }
            ix += C6091a.m9572bs(4, this.wsv);
            if (this.wBC != null) {
                ix += C6087a.m9557ix(5, this.wBC.computeSize());
            }
            if (this.wBD != null) {
                ix += C6087a.m9557ix(6, this.wBD.computeSize());
            }
            if (this.wBE != null) {
                ix += C6087a.m9557ix(7, this.wBE.computeSize());
            }
            if (this.wBF != null) {
                ix += C6087a.m9557ix(8, this.wBF.computeSize());
            }
            if (this.wBG != null) {
                ix += C6087a.m9557ix(9, this.wBG.computeSize());
            }
            int bs = ix + C6091a.m9572bs(10, this.wBH);
            AppMethodBeat.m2505o(96273);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(96273);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            axq axq = (axq) objArr[1];
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
                        C7267hl c7267hl = new C7267hl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        axq.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(96273);
                    return 0;
                case 2:
                    axq.fKh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96273);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cwf cwf = new cwf();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cwf.populateBuilderWithField(c6086a3, cwf, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        axq.wBB = cwf;
                    }
                    AppMethodBeat.m2505o(96273);
                    return 0;
                case 4:
                    axq.wsv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96273);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cxm cxm = new cxm();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cxm.populateBuilderWithField(c6086a3, cxm, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        axq.wBC = cxm;
                    }
                    AppMethodBeat.m2505o(96273);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cxe cxe = new cxe();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cxe.populateBuilderWithField(c6086a3, cxe, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        axq.wBD = cxe;
                    }
                    AppMethodBeat.m2505o(96273);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cyb cyb = new cyb();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cyb.populateBuilderWithField(c6086a3, cyb, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        axq.wBE = cyb;
                    }
                    AppMethodBeat.m2505o(96273);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cxj cxj = new cxj();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cxj.populateBuilderWithField(c6086a3, cxj, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        axq.wBF = cxj;
                    }
                    AppMethodBeat.m2505o(96273);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cxn cxn = new cxn();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cxn.populateBuilderWithField(c6086a3, cxn, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        axq.wBG = cxn;
                    }
                    AppMethodBeat.m2505o(96273);
                    return 0;
                case 10:
                    axq.wBH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96273);
                    return 0;
                default:
                    AppMethodBeat.m2505o(96273);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(96273);
            return -1;
        }
    }
}
