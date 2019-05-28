package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.xn */
public final class C44193xn extends bsr {
    public int ptD;
    public long ptF;
    public String vEf;
    public String vFF;
    public int vOq;
    public int wdn;
    public long wdo;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(116802);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.ptD);
            c6093a.mo13480iz(2, this.vOq);
            c6093a.mo13480iz(3, this.wdn);
            if (this.vFF != null) {
                c6093a.mo13475e(4, this.vFF);
            }
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(5, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13472ai(6, this.ptF);
            if (this.vEf != null) {
                c6093a.mo13475e(7, this.vEf);
            }
            c6093a.mo13472ai(8, this.wdo);
            AppMethodBeat.m2505o(116802);
            return 0;
        } else if (i == 1) {
            bs = ((C6091a.m9572bs(1, this.ptD) + 0) + C6091a.m9572bs(2, this.vOq)) + C6091a.m9572bs(3, this.wdn);
            if (this.vFF != null) {
                bs += C6091a.m9575f(4, this.vFF);
            }
            if (this.BaseRequest != null) {
                bs += C6087a.m9557ix(5, this.BaseRequest.computeSize());
            }
            bs += C6091a.m9578o(6, this.ptF);
            if (this.vEf != null) {
                bs += C6091a.m9575f(7, this.vEf);
            }
            bs += C6091a.m9578o(8, this.wdo);
            AppMethodBeat.m2505o(116802);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(116802);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44193xn c44193xn = (C44193xn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c44193xn.ptD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116802);
                    return 0;
                case 2:
                    c44193xn.vOq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116802);
                    return 0;
                case 3:
                    c44193xn.wdn = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116802);
                    return 0;
                case 4:
                    c44193xn.vFF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(116802);
                    return 0;
                case 5:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C7267hl c7267hl = new C7267hl();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44193xn.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(116802);
                    return 0;
                case 6:
                    c44193xn.ptF = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(116802);
                    return 0;
                case 7:
                    c44193xn.vEf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(116802);
                    return 0;
                case 8:
                    c44193xn.wdo = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(116802);
                    return 0;
                default:
                    AppMethodBeat.m2505o(116802);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(116802);
            return -1;
        }
    }
}
