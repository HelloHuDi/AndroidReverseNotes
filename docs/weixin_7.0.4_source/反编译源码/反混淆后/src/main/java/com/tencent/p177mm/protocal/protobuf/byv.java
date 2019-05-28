package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.byv */
public final class byv extends bsr {
    public int cME;
    public LinkedList<byx> fjr = new LinkedList();
    public cdc vBy;
    public String wSq;
    public int wYd;
    public bzm wYe;
    public String wni;

    public byv() {
        AppMethodBeat.m2504i(89137);
        AppMethodBeat.m2505o(89137);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(89138);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.wYd);
            c6093a.mo13474e(3, 8, this.fjr);
            if (this.wSq != null) {
                c6093a.mo13475e(4, this.wSq);
            }
            if (this.wni != null) {
                c6093a.mo13475e(5, this.wni);
            }
            if (this.wYe != null) {
                c6093a.mo13479iy(6, this.wYe.computeSize());
                this.wYe.writeFields(c6093a);
            }
            c6093a.mo13480iz(7, this.cME);
            if (this.vBy != null) {
                c6093a.mo13479iy(8, this.vBy.computeSize());
                this.vBy.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(89138);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + C6091a.m9572bs(2, this.wYd)) + C6087a.m9552c(3, 8, this.fjr);
            if (this.wSq != null) {
                ix += C6091a.m9575f(4, this.wSq);
            }
            if (this.wni != null) {
                ix += C6091a.m9575f(5, this.wni);
            }
            if (this.wYe != null) {
                ix += C6087a.m9557ix(6, this.wYe.computeSize());
            }
            ix += C6091a.m9572bs(7, this.cME);
            if (this.vBy != null) {
                ix += C6087a.m9557ix(8, this.vBy.computeSize());
            }
            AppMethodBeat.m2505o(89138);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.fjr.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(89138);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            byv byv = (byv) objArr[1];
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
                        C7267hl c7267hl = new C7267hl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        byv.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(89138);
                    return 0;
                case 2:
                    byv.wYd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89138);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        byx byx = new byx();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = byx.populateBuilderWithField(c6086a3, byx, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        byv.fjr.add(byx);
                    }
                    AppMethodBeat.m2505o(89138);
                    return 0;
                case 4:
                    byv.wSq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89138);
                    return 0;
                case 5:
                    byv.wni = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89138);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzm bzm = new bzm();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzm.populateBuilderWithField(c6086a3, bzm, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        byv.wYe = bzm;
                    }
                    AppMethodBeat.m2505o(89138);
                    return 0;
                case 7:
                    byv.cME = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89138);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdc cdc = new cdc();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdc.populateBuilderWithField(c6086a3, cdc, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        byv.vBy = cdc;
                    }
                    AppMethodBeat.m2505o(89138);
                    return 0;
                default:
                    AppMethodBeat.m2505o(89138);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(89138);
            return -1;
        }
    }
}
