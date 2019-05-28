package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.qt */
public final class C23433qt extends bsr {
    public int Scene;
    public String mZr;
    public String ndF;
    public String ndT;
    public int vFH;
    public int vXK;
    public LinkedList<bts> vXL = new LinkedList();
    public String vXM;
    public String vXN;

    public C23433qt() {
        AppMethodBeat.m2504i(11731);
        AppMethodBeat.m2505o(11731);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(11732);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.vFH);
            if (this.ndF != null) {
                c6093a.mo13475e(3, this.ndF);
            }
            if (this.ndT != null) {
                c6093a.mo13475e(4, this.ndT);
            }
            if (this.mZr != null) {
                c6093a.mo13475e(5, this.mZr);
            }
            c6093a.mo13480iz(6, this.vXK);
            c6093a.mo13474e(7, 8, this.vXL);
            if (this.vXM != null) {
                c6093a.mo13475e(8, this.vXM);
            }
            if (this.vXN != null) {
                c6093a.mo13475e(9, this.vXN);
            }
            c6093a.mo13480iz(10, this.Scene);
            AppMethodBeat.m2505o(11732);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.vFH);
            if (this.ndF != null) {
                ix += C6091a.m9575f(3, this.ndF);
            }
            if (this.ndT != null) {
                ix += C6091a.m9575f(4, this.ndT);
            }
            if (this.mZr != null) {
                ix += C6091a.m9575f(5, this.mZr);
            }
            ix = (ix + C6091a.m9572bs(6, this.vXK)) + C6087a.m9552c(7, 8, this.vXL);
            if (this.vXM != null) {
                ix += C6091a.m9575f(8, this.vXM);
            }
            if (this.vXN != null) {
                ix += C6091a.m9575f(9, this.vXN);
            }
            int bs = ix + C6091a.m9572bs(10, this.Scene);
            AppMethodBeat.m2505o(11732);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vXL.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(11732);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23433qt c23433qt = (C23433qt) objArr[1];
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
                        c23433qt.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(11732);
                    return 0;
                case 2:
                    c23433qt.vFH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11732);
                    return 0;
                case 3:
                    c23433qt.ndF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11732);
                    return 0;
                case 4:
                    c23433qt.ndT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11732);
                    return 0;
                case 5:
                    c23433qt.mZr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11732);
                    return 0;
                case 6:
                    c23433qt.vXK = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11732);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c23433qt.vXL.add(bts);
                    }
                    AppMethodBeat.m2505o(11732);
                    return 0;
                case 8:
                    c23433qt.vXM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11732);
                    return 0;
                case 9:
                    c23433qt.vXN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11732);
                    return 0;
                case 10:
                    c23433qt.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11732);
                    return 0;
                default:
                    AppMethodBeat.m2505o(11732);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(11732);
            return -1;
        }
    }
}
