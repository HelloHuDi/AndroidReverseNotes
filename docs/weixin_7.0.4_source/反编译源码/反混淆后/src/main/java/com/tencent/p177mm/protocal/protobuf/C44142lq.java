package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.lq */
public final class C44142lq extends bsr {
    public int cIb;
    public int nUf;
    public int pOA;
    public String pOB;
    public String pOC;
    public String pPW;
    public String pPZ;
    public String vFf;
    public String vPl;
    public int vPm;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56720);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.nUf);
            c6093a.mo13480iz(3, this.cIb);
            c6093a.mo13480iz(4, this.pOA);
            if (this.vPl != null) {
                c6093a.mo13475e(5, this.vPl);
            }
            if (this.pPW != null) {
                c6093a.mo13475e(6, this.pPW);
            }
            if (this.pOB != null) {
                c6093a.mo13475e(7, this.pOB);
            }
            if (this.pPZ != null) {
                c6093a.mo13475e(8, this.pPZ);
            }
            if (this.vFf != null) {
                c6093a.mo13475e(9, this.vFf);
            }
            if (this.pOC != null) {
                c6093a.mo13475e(10, this.pOC);
            }
            c6093a.mo13480iz(11, this.vPm);
            AppMethodBeat.m2505o(56720);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((ix + C6091a.m9572bs(2, this.nUf)) + C6091a.m9572bs(3, this.cIb)) + C6091a.m9572bs(4, this.pOA);
            if (this.vPl != null) {
                ix += C6091a.m9575f(5, this.vPl);
            }
            if (this.pPW != null) {
                ix += C6091a.m9575f(6, this.pPW);
            }
            if (this.pOB != null) {
                ix += C6091a.m9575f(7, this.pOB);
            }
            if (this.pPZ != null) {
                ix += C6091a.m9575f(8, this.pPZ);
            }
            if (this.vFf != null) {
                ix += C6091a.m9575f(9, this.vFf);
            }
            if (this.pOC != null) {
                ix += C6091a.m9575f(10, this.pOC);
            }
            int bs = ix + C6091a.m9572bs(11, this.vPm);
            AppMethodBeat.m2505o(56720);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56720);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44142lq c44142lq = (C44142lq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C7267hl c7267hl = new C7267hl();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44142lq.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(56720);
                    return 0;
                case 2:
                    c44142lq.nUf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56720);
                    return 0;
                case 3:
                    c44142lq.cIb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56720);
                    return 0;
                case 4:
                    c44142lq.pOA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56720);
                    return 0;
                case 5:
                    c44142lq.vPl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56720);
                    return 0;
                case 6:
                    c44142lq.pPW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56720);
                    return 0;
                case 7:
                    c44142lq.pOB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56720);
                    return 0;
                case 8:
                    c44142lq.pPZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56720);
                    return 0;
                case 9:
                    c44142lq.vFf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56720);
                    return 0;
                case 10:
                    c44142lq.pOC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56720);
                    return 0;
                case 11:
                    c44142lq.vPm = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56720);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56720);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56720);
            return -1;
        }
    }
}
