package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bno */
public final class bno extends bsr {
    public String pQe;
    public String tgu;
    public String wOm;
    public int wPw;
    public String wQm;
    public int wao;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56938);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.wQm != null) {
                c6093a.mo13475e(2, this.wQm);
            }
            if (this.pQe != null) {
                c6093a.mo13475e(3, this.pQe);
            }
            c6093a.mo13480iz(4, this.wPw);
            c6093a.mo13480iz(5, this.wao);
            if (this.wOm != null) {
                c6093a.mo13475e(6, this.wOm);
            }
            if (this.tgu != null) {
                c6093a.mo13475e(100, this.tgu);
            }
            AppMethodBeat.m2505o(56938);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wQm != null) {
                ix += C6091a.m9575f(2, this.wQm);
            }
            if (this.pQe != null) {
                ix += C6091a.m9575f(3, this.pQe);
            }
            ix = (ix + C6091a.m9572bs(4, this.wPw)) + C6091a.m9572bs(5, this.wao);
            if (this.wOm != null) {
                ix += C6091a.m9575f(6, this.wOm);
            }
            if (this.tgu != null) {
                ix += C6091a.m9575f(100, this.tgu);
            }
            AppMethodBeat.m2505o(56938);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56938);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bno bno = (bno) objArr[1];
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
                        bno.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(56938);
                    return 0;
                case 2:
                    bno.wQm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56938);
                    return 0;
                case 3:
                    bno.pQe = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56938);
                    return 0;
                case 4:
                    bno.wPw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56938);
                    return 0;
                case 5:
                    bno.wao = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56938);
                    return 0;
                case 6:
                    bno.wOm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56938);
                    return 0;
                case 100:
                    bno.tgu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56938);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56938);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56938);
            return -1;
        }
    }
}
