package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cho */
public final class cho extends C1331a {
    public int Category;
    public String ncM;
    public int wSb;
    public LinkedList<String> wSd = new LinkedList();
    public long xgq;
    public int xgr;

    public cho() {
        AppMethodBeat.m2504i(55704);
        AppMethodBeat.m2505o(55704);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(55705);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.ncM != null) {
                c6093a.mo13475e(1, this.ncM);
            }
            c6093a.mo13472ai(2, this.xgq);
            c6093a.mo13480iz(3, this.wSb);
            c6093a.mo13480iz(4, this.xgr);
            c6093a.mo13480iz(5, this.Category);
            c6093a.mo13474e(6, 1, this.wSd);
            AppMethodBeat.m2505o(55705);
            return 0;
        } else if (i == 1) {
            if (this.ncM != null) {
                f = C6091a.m9575f(1, this.ncM) + 0;
            } else {
                f = 0;
            }
            int o = ((((f + C6091a.m9578o(2, this.xgq)) + C6091a.m9572bs(3, this.wSb)) + C6091a.m9572bs(4, this.xgr)) + C6091a.m9572bs(5, this.Category)) + C6087a.m9552c(6, 1, this.wSd);
            AppMethodBeat.m2505o(55705);
            return o;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.wSd.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(55705);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cho cho = (cho) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cho.ncM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55705);
                    return 0;
                case 2:
                    cho.xgq = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(55705);
                    return 0;
                case 3:
                    cho.wSb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55705);
                    return 0;
                case 4:
                    cho.xgr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55705);
                    return 0;
                case 5:
                    cho.Category = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55705);
                    return 0;
                case 6:
                    cho.wSd.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(55705);
                    return 0;
                default:
                    AppMethodBeat.m2505o(55705);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(55705);
            return -1;
        }
    }
}
