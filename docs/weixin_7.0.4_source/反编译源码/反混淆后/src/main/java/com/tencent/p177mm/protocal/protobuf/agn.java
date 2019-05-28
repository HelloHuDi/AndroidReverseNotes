package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.agn */
public final class agn extends bsr {
    public int cME;
    public String kKO;
    public String kLv;
    public String sign;
    public String vBu;
    public String vBv;
    public int vBw;
    public LinkedList<C35941nx> vBz = new LinkedList();
    public String wni;

    public agn() {
        AppMethodBeat.m2504i(89079);
        AppMethodBeat.m2505o(89079);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(89080);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13474e(2, 8, this.vBz);
            c6093a.mo13480iz(3, this.cME);
            if (this.kLv != null) {
                c6093a.mo13475e(4, this.kLv);
            }
            if (this.kKO != null) {
                c6093a.mo13475e(5, this.kKO);
            }
            if (this.sign != null) {
                c6093a.mo13475e(6, this.sign);
            }
            if (this.vBu != null) {
                c6093a.mo13475e(7, this.vBu);
            }
            if (this.vBv != null) {
                c6093a.mo13475e(8, this.vBv);
            }
            if (this.wni != null) {
                c6093a.mo13475e(9, this.wni);
            }
            c6093a.mo13480iz(10, this.vBw);
            AppMethodBeat.m2505o(89080);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + C6087a.m9552c(2, 8, this.vBz)) + C6091a.m9572bs(3, this.cME);
            if (this.kLv != null) {
                ix += C6091a.m9575f(4, this.kLv);
            }
            if (this.kKO != null) {
                ix += C6091a.m9575f(5, this.kKO);
            }
            if (this.sign != null) {
                ix += C6091a.m9575f(6, this.sign);
            }
            if (this.vBu != null) {
                ix += C6091a.m9575f(7, this.vBu);
            }
            if (this.vBv != null) {
                ix += C6091a.m9575f(8, this.vBv);
            }
            if (this.wni != null) {
                ix += C6091a.m9575f(9, this.wni);
            }
            int bs = ix + C6091a.m9572bs(10, this.vBw);
            AppMethodBeat.m2505o(89080);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vBz.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(89080);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            agn agn = (agn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
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
                        agn.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(89080);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C35941nx c35941nx = new C35941nx();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c35941nx.populateBuilderWithField(c6086a3, c35941nx, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        agn.vBz.add(c35941nx);
                    }
                    AppMethodBeat.m2505o(89080);
                    return 0;
                case 3:
                    agn.cME = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89080);
                    return 0;
                case 4:
                    agn.kLv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89080);
                    return 0;
                case 5:
                    agn.kKO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89080);
                    return 0;
                case 6:
                    agn.sign = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89080);
                    return 0;
                case 7:
                    agn.vBu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89080);
                    return 0;
                case 8:
                    agn.vBv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89080);
                    return 0;
                case 9:
                    agn.wni = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89080);
                    return 0;
                case 10:
                    agn.vBw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89080);
                    return 0;
                default:
                    AppMethodBeat.m2505o(89080);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(89080);
            return -1;
        }
    }
}
