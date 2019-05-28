package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bvy */
public final class bvy extends C1331a {
    public int wWH;
    public int wWI;
    public int wWJ;
    public int wWK;
    public int wWL;
    public int wWM;
    public int wWN;
    public C1332b wdt;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28628);
        C6092b c6092b;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wdt == null) {
                c6092b = new C6092b("Not all required fields were included: data");
                AppMethodBeat.m2505o(28628);
                throw c6092b;
            }
            c6093a.mo13480iz(1, this.wWH);
            c6093a.mo13480iz(2, this.wWI);
            c6093a.mo13480iz(3, this.wWJ);
            c6093a.mo13480iz(4, this.wWK);
            c6093a.mo13480iz(5, this.wWL);
            c6093a.mo13480iz(6, this.wWM);
            c6093a.mo13480iz(7, this.wWN);
            if (this.wdt != null) {
                c6093a.mo13473c(8, this.wdt);
            }
            AppMethodBeat.m2505o(28628);
            return 0;
        } else if (i == 1) {
            int bs = ((((((C6091a.m9572bs(1, this.wWH) + 0) + C6091a.m9572bs(2, this.wWI)) + C6091a.m9572bs(3, this.wWJ)) + C6091a.m9572bs(4, this.wWK)) + C6091a.m9572bs(5, this.wWL)) + C6091a.m9572bs(6, this.wWM)) + C6091a.m9572bs(7, this.wWN);
            if (this.wdt != null) {
                bs += C6091a.m9571b(8, this.wdt);
            }
            AppMethodBeat.m2505o(28628);
            return bs;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (int nextFieldNumber = C1331a.getNextFieldNumber(c6086a); nextFieldNumber > 0; nextFieldNumber = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, nextFieldNumber)) {
                    c6086a.ems();
                }
            }
            if (bArr == null) {
                c6092b = new C6092b("Not all required fields were included: data");
                AppMethodBeat.m2505o(28628);
                throw c6092b;
            }
            AppMethodBeat.m2505o(28628);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bvy bvy = (bvy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bvy.wWH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28628);
                    return 0;
                case 2:
                    bvy.wWI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28628);
                    return 0;
                case 3:
                    bvy.wWJ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28628);
                    return 0;
                case 4:
                    bvy.wWK = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28628);
                    return 0;
                case 5:
                    bvy.wWL = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28628);
                    return 0;
                case 6:
                    bvy.wWM = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28628);
                    return 0;
                case 7:
                    bvy.wWN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28628);
                    return 0;
                case 8:
                    bvy.wdt = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(28628);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28628);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28628);
            return -1;
        }
    }
}
