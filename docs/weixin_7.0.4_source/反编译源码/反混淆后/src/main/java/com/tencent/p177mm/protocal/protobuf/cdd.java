package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cdd */
public final class cdd extends C1331a {
    public int fQh;
    public int fQi;
    public int fQj;
    public int fQk;
    public int opType;
    public long timeStamp;
    public String xcN;
    public String xcO;
    public String xcP;
    public String xcQ;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94628);
        C6092b c6092b;
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xcN == null) {
                c6092b = new C6092b("Not all required fields were included: StatusDesc1");
                AppMethodBeat.m2505o(94628);
                throw c6092b;
            } else if (this.xcO == null) {
                c6092b = new C6092b("Not all required fields were included: StatusDesc2");
                AppMethodBeat.m2505o(94628);
                throw c6092b;
            } else if (this.xcP == null) {
                c6092b = new C6092b("Not all required fields were included: DataFlowSourceInfo");
                AppMethodBeat.m2505o(94628);
                throw c6092b;
            } else if (this.xcQ == null) {
                c6092b = new C6092b("Not all required fields were included: DataFlowResultInfo");
                AppMethodBeat.m2505o(94628);
                throw c6092b;
            } else {
                c6093a.mo13480iz(1, this.opType);
                c6093a.mo13480iz(2, this.fQk);
                c6093a.mo13480iz(3, this.fQh);
                c6093a.mo13472ai(4, this.timeStamp);
                c6093a.mo13480iz(5, this.fQi);
                c6093a.mo13480iz(6, this.fQj);
                if (this.xcN != null) {
                    c6093a.mo13475e(7, this.xcN);
                }
                if (this.xcO != null) {
                    c6093a.mo13475e(8, this.xcO);
                }
                if (this.xcP != null) {
                    c6093a.mo13475e(9, this.xcP);
                }
                if (this.xcQ != null) {
                    c6093a.mo13475e(10, this.xcQ);
                }
                AppMethodBeat.m2505o(94628);
                return 0;
            }
        } else if (i == 1) {
            bs = (((((C6091a.m9572bs(1, this.opType) + 0) + C6091a.m9572bs(2, this.fQk)) + C6091a.m9572bs(3, this.fQh)) + C6091a.m9578o(4, this.timeStamp)) + C6091a.m9572bs(5, this.fQi)) + C6091a.m9572bs(6, this.fQj);
            if (this.xcN != null) {
                bs += C6091a.m9575f(7, this.xcN);
            }
            if (this.xcO != null) {
                bs += C6091a.m9575f(8, this.xcO);
            }
            if (this.xcP != null) {
                bs += C6091a.m9575f(9, this.xcP);
            }
            if (this.xcQ != null) {
                bs += C6091a.m9575f(10, this.xcQ);
            }
            AppMethodBeat.m2505o(94628);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.xcN == null) {
                c6092b = new C6092b("Not all required fields were included: StatusDesc1");
                AppMethodBeat.m2505o(94628);
                throw c6092b;
            } else if (this.xcO == null) {
                c6092b = new C6092b("Not all required fields were included: StatusDesc2");
                AppMethodBeat.m2505o(94628);
                throw c6092b;
            } else if (this.xcP == null) {
                c6092b = new C6092b("Not all required fields were included: DataFlowSourceInfo");
                AppMethodBeat.m2505o(94628);
                throw c6092b;
            } else if (this.xcQ == null) {
                c6092b = new C6092b("Not all required fields were included: DataFlowResultInfo");
                AppMethodBeat.m2505o(94628);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(94628);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cdd cdd = (cdd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cdd.opType = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94628);
                    return 0;
                case 2:
                    cdd.fQk = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94628);
                    return 0;
                case 3:
                    cdd.fQh = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94628);
                    return 0;
                case 4:
                    cdd.timeStamp = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(94628);
                    return 0;
                case 5:
                    cdd.fQi = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94628);
                    return 0;
                case 6:
                    cdd.fQj = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94628);
                    return 0;
                case 7:
                    cdd.xcN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94628);
                    return 0;
                case 8:
                    cdd.xcO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94628);
                    return 0;
                case 9:
                    cdd.xcP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94628);
                    return 0;
                case 10:
                    cdd.xcQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94628);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94628);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94628);
            return -1;
        }
    }
}
