package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bmj */
public final class bmj extends bsr {
    public long wOP;
    public long wOS;
    public String wPm;
    public int wPn;
    public int wPo;
    public int wem;
    public long wen;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28593);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wPm == null) {
                c6092b = new C6092b("Not all required fields were included: FromUsername");
                AppMethodBeat.m2505o(28593);
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
            c6093a.mo13472ai(5, this.wOP);
            c6093a.mo13480iz(6, this.wPn);
            c6093a.mo13472ai(7, this.wOS);
            c6093a.mo13480iz(8, this.wPo);
            AppMethodBeat.m2505o(28593);
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
            int bs = (((((ix + C6091a.m9572bs(3, this.wem)) + C6091a.m9578o(4, this.wen)) + C6091a.m9578o(5, this.wOP)) + C6091a.m9572bs(6, this.wPn)) + C6091a.m9578o(7, this.wOS)) + C6091a.m9572bs(8, this.wPo);
            AppMethodBeat.m2505o(28593);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.wPm == null) {
                c6092b = new C6092b("Not all required fields were included: FromUsername");
                AppMethodBeat.m2505o(28593);
                throw c6092b;
            }
            AppMethodBeat.m2505o(28593);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bmj bmj = (bmj) objArr[1];
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
                        bmj.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(28593);
                    return 0;
                case 2:
                    bmj.wPm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28593);
                    return 0;
                case 3:
                    bmj.wem = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28593);
                    return 0;
                case 4:
                    bmj.wen = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(28593);
                    return 0;
                case 5:
                    bmj.wOP = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(28593);
                    return 0;
                case 6:
                    bmj.wPn = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28593);
                    return 0;
                case 7:
                    bmj.wOS = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(28593);
                    return 0;
                case 8:
                    bmj.wPo = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28593);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28593);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28593);
            return -1;
        }
    }
}
