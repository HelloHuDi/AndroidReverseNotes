package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ot */
public final class C23425ot extends bsr {
    public String kfT;
    public int nUf;
    public String nickname;
    public String pPH;
    public String pPI;
    public String pPZ;
    public String pPw;
    public String pQc;
    public String vVT;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56746);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.nUf);
            if (this.kfT != null) {
                c6093a.mo13475e(3, this.kfT);
            }
            if (this.pPZ != null) {
                c6093a.mo13475e(4, this.pPZ);
            }
            if (this.vVT != null) {
                c6093a.mo13475e(5, this.vVT);
            }
            if (this.pPH != null) {
                c6093a.mo13475e(6, this.pPH);
            }
            if (this.pPI != null) {
                c6093a.mo13475e(7, this.pPI);
            }
            if (this.pQc != null) {
                c6093a.mo13475e(8, this.pQc);
            }
            if (this.nickname != null) {
                c6093a.mo13475e(9, this.nickname);
            }
            if (this.pPw != null) {
                c6093a.mo13475e(10, this.pPw);
            }
            AppMethodBeat.m2505o(56746);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.nUf);
            if (this.kfT != null) {
                ix += C6091a.m9575f(3, this.kfT);
            }
            if (this.pPZ != null) {
                ix += C6091a.m9575f(4, this.pPZ);
            }
            if (this.vVT != null) {
                ix += C6091a.m9575f(5, this.vVT);
            }
            if (this.pPH != null) {
                ix += C6091a.m9575f(6, this.pPH);
            }
            if (this.pPI != null) {
                ix += C6091a.m9575f(7, this.pPI);
            }
            if (this.pQc != null) {
                ix += C6091a.m9575f(8, this.pQc);
            }
            if (this.nickname != null) {
                ix += C6091a.m9575f(9, this.nickname);
            }
            if (this.pPw != null) {
                ix += C6091a.m9575f(10, this.pPw);
            }
            AppMethodBeat.m2505o(56746);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56746);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23425ot c23425ot = (C23425ot) objArr[1];
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
                        c23425ot.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(56746);
                    return 0;
                case 2:
                    c23425ot.nUf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56746);
                    return 0;
                case 3:
                    c23425ot.kfT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56746);
                    return 0;
                case 4:
                    c23425ot.pPZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56746);
                    return 0;
                case 5:
                    c23425ot.vVT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56746);
                    return 0;
                case 6:
                    c23425ot.pPH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56746);
                    return 0;
                case 7:
                    c23425ot.pPI = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56746);
                    return 0;
                case 8:
                    c23425ot.pQc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56746);
                    return 0;
                case 9:
                    c23425ot.nickname = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56746);
                    return 0;
                case 10:
                    c23425ot.pPw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56746);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56746);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56746);
            return -1;
        }
    }
}
