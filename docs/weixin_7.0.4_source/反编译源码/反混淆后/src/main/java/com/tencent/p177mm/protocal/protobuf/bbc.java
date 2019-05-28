package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bbc */
public final class bbc extends C1331a {
    public String cEh;
    public int type;
    public String url;
    public String wFS;
    public String wFT;
    public String wFU;
    public int wFV;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56853);
        C6092b c6092b;
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.cEh == null) {
                c6092b = new C6092b("Not all required fields were included: wording");
                AppMethodBeat.m2505o(56853);
                throw c6092b;
            }
            c6093a.mo13480iz(1, this.type);
            if (this.cEh != null) {
                c6093a.mo13475e(2, this.cEh);
            }
            if (this.url != null) {
                c6093a.mo13475e(3, this.url);
            }
            if (this.wFS != null) {
                c6093a.mo13475e(4, this.wFS);
            }
            if (this.wFT != null) {
                c6093a.mo13475e(5, this.wFT);
            }
            if (this.wFU != null) {
                c6093a.mo13475e(6, this.wFU);
            }
            c6093a.mo13480iz(7, this.wFV);
            AppMethodBeat.m2505o(56853);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.type) + 0;
            if (this.cEh != null) {
                bs += C6091a.m9575f(2, this.cEh);
            }
            if (this.url != null) {
                bs += C6091a.m9575f(3, this.url);
            }
            if (this.wFS != null) {
                bs += C6091a.m9575f(4, this.wFS);
            }
            if (this.wFT != null) {
                bs += C6091a.m9575f(5, this.wFT);
            }
            if (this.wFU != null) {
                bs += C6091a.m9575f(6, this.wFU);
            }
            bs += C6091a.m9572bs(7, this.wFV);
            AppMethodBeat.m2505o(56853);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.cEh == null) {
                c6092b = new C6092b("Not all required fields were included: wording");
                AppMethodBeat.m2505o(56853);
                throw c6092b;
            }
            AppMethodBeat.m2505o(56853);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bbc bbc = (bbc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bbc.type = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56853);
                    return 0;
                case 2:
                    bbc.cEh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56853);
                    return 0;
                case 3:
                    bbc.url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56853);
                    return 0;
                case 4:
                    bbc.wFS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56853);
                    return 0;
                case 5:
                    bbc.wFT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56853);
                    return 0;
                case 6:
                    bbc.wFU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56853);
                    return 0;
                case 7:
                    bbc.wFV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56853);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56853);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56853);
            return -1;
        }
    }
}
