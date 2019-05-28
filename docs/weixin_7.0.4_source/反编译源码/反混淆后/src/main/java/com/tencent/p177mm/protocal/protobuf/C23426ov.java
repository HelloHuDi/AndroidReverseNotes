package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ov */
public final class C23426ov extends bsr {
    public int cIb;
    public int nUf;
    public int pOA;
    public String pPS;
    public String pPT;
    public String vFb;
    public String vFc;
    public String vVW;
    public String vVX;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56749);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.vFb != null) {
                c6093a.mo13475e(2, this.vFb);
            }
            if (this.vFc != null) {
                c6093a.mo13475e(3, this.vFc);
            }
            c6093a.mo13480iz(4, this.nUf);
            if (this.pPT != null) {
                c6093a.mo13475e(5, this.pPT);
            }
            if (this.pPS != null) {
                c6093a.mo13475e(6, this.pPS);
            }
            c6093a.mo13480iz(7, this.cIb);
            c6093a.mo13480iz(8, this.pOA);
            if (this.vVW != null) {
                c6093a.mo13475e(9, this.vVW);
            }
            if (this.vVX != null) {
                c6093a.mo13475e(10, this.vVX);
            }
            AppMethodBeat.m2505o(56749);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vFb != null) {
                ix += C6091a.m9575f(2, this.vFb);
            }
            if (this.vFc != null) {
                ix += C6091a.m9575f(3, this.vFc);
            }
            ix += C6091a.m9572bs(4, this.nUf);
            if (this.pPT != null) {
                ix += C6091a.m9575f(5, this.pPT);
            }
            if (this.pPS != null) {
                ix += C6091a.m9575f(6, this.pPS);
            }
            ix = (ix + C6091a.m9572bs(7, this.cIb)) + C6091a.m9572bs(8, this.pOA);
            if (this.vVW != null) {
                ix += C6091a.m9575f(9, this.vVW);
            }
            if (this.vVX != null) {
                ix += C6091a.m9575f(10, this.vVX);
            }
            AppMethodBeat.m2505o(56749);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56749);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23426ov c23426ov = (C23426ov) objArr[1];
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
                        c23426ov.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(56749);
                    return 0;
                case 2:
                    c23426ov.vFb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56749);
                    return 0;
                case 3:
                    c23426ov.vFc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56749);
                    return 0;
                case 4:
                    c23426ov.nUf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56749);
                    return 0;
                case 5:
                    c23426ov.pPT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56749);
                    return 0;
                case 6:
                    c23426ov.pPS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56749);
                    return 0;
                case 7:
                    c23426ov.cIb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56749);
                    return 0;
                case 8:
                    c23426ov.pOA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56749);
                    return 0;
                case 9:
                    c23426ov.vVW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56749);
                    return 0;
                case 10:
                    c23426ov.vVX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56749);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56749);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56749);
            return -1;
        }
    }
}
