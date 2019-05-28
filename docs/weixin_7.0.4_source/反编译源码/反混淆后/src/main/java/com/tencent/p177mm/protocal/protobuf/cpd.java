package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cpd */
public final class cpd extends bsr {
    public String ndF;
    public int wOQ;
    public String wPm;
    public int wem;
    public long wen;
    public long xlQ;
    public cqf xmK;
    public int xmL;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(5234);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xmK == null) {
                c6092b = new C6092b("Not all required fields were included: ReportData");
                AppMethodBeat.m2505o(5234);
                throw c6092b;
            }
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.wPm != null) {
                c6093a.mo13475e(2, this.wPm);
            }
            c6093a.mo13480iz(3, this.wem);
            c6093a.mo13472ai(4, this.wen);
            if (this.ndF != null) {
                c6093a.mo13475e(6, this.ndF);
            }
            if (this.xmK != null) {
                c6093a.mo13479iy(8, this.xmK.computeSize());
                this.xmK.writeFields(c6093a);
            }
            c6093a.mo13480iz(9, this.xmL);
            c6093a.mo13472ai(10, this.xlQ);
            c6093a.mo13480iz(11, this.wOQ);
            AppMethodBeat.m2505o(5234);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wPm != null) {
                ix += C6091a.m9575f(2, this.wPm);
            }
            ix = (ix + C6091a.m9572bs(3, this.wem)) + C6091a.m9578o(4, this.wen);
            if (this.ndF != null) {
                ix += C6091a.m9575f(6, this.ndF);
            }
            if (this.xmK != null) {
                ix += C6087a.m9557ix(8, this.xmK.computeSize());
            }
            int bs = ((ix + C6091a.m9572bs(9, this.xmL)) + C6091a.m9578o(10, this.xlQ)) + C6091a.m9572bs(11, this.wOQ);
            AppMethodBeat.m2505o(5234);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.xmK == null) {
                c6092b = new C6092b("Not all required fields were included: ReportData");
                AppMethodBeat.m2505o(5234);
                throw c6092b;
            }
            AppMethodBeat.m2505o(5234);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cpd cpd = (cpd) objArr[1];
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
                        cpd.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(5234);
                    return 0;
                case 2:
                    cpd.wPm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(5234);
                    return 0;
                case 3:
                    cpd.wem = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5234);
                    return 0;
                case 4:
                    cpd.wen = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(5234);
                    return 0;
                case 6:
                    cpd.ndF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(5234);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cqf cqf = new cqf();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cqf.populateBuilderWithField(c6086a3, cqf, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cpd.xmK = cqf;
                    }
                    AppMethodBeat.m2505o(5234);
                    return 0;
                case 9:
                    cpd.xmL = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5234);
                    return 0;
                case 10:
                    cpd.xlQ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(5234);
                    return 0;
                case 11:
                    cpd.wOQ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5234);
                    return 0;
                default:
                    AppMethodBeat.m2505o(5234);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(5234);
            return -1;
        }
    }
}
