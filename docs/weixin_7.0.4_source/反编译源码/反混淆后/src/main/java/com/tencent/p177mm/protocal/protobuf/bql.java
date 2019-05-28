package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bql */
public final class bql extends C1331a {
    public String fjK;
    public String kLS;
    public int wSJ;
    public float wSN;
    public float wSO;
    public String wSP;
    public LinkedList<String> wSQ = new LinkedList();
    public String wSR;
    public LinkedList<String> wSS = new LinkedList();
    public LinkedList<bqm> wST = new LinkedList();

    public bql() {
        AppMethodBeat.m2504i(108899);
        AppMethodBeat.m2505o(108899);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(108900);
        C6092b c6092b;
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wSP == null) {
                c6092b = new C6092b("Not all required fields were included: music_url");
                AppMethodBeat.m2505o(108900);
                throw c6092b;
            }
            c6093a.mo13480iz(1, this.wSJ);
            c6093a.mo13481r(2, this.wSN);
            c6093a.mo13481r(3, this.wSO);
            if (this.wSP != null) {
                c6093a.mo13475e(4, this.wSP);
            }
            c6093a.mo13474e(5, 1, this.wSQ);
            if (this.wSR != null) {
                c6093a.mo13475e(6, this.wSR);
            }
            c6093a.mo13474e(7, 1, this.wSS);
            c6093a.mo13474e(8, 8, this.wST);
            if (this.kLS != null) {
                c6093a.mo13475e(9, this.kLS);
            }
            if (this.fjK != null) {
                c6093a.mo13475e(10, this.fjK);
            }
            AppMethodBeat.m2505o(108900);
            return 0;
        } else if (i == 1) {
            bs = ((C6091a.m9572bs(1, this.wSJ) + 0) + (C6091a.m9576fv(2) + 4)) + (C6091a.m9576fv(3) + 4);
            if (this.wSP != null) {
                bs += C6091a.m9575f(4, this.wSP);
            }
            bs += C6087a.m9552c(5, 1, this.wSQ);
            if (this.wSR != null) {
                bs += C6091a.m9575f(6, this.wSR);
            }
            bs = (bs + C6087a.m9552c(7, 1, this.wSS)) + C6087a.m9552c(8, 8, this.wST);
            if (this.kLS != null) {
                bs += C6091a.m9575f(9, this.kLS);
            }
            if (this.fjK != null) {
                bs += C6091a.m9575f(10, this.fjK);
            }
            AppMethodBeat.m2505o(108900);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wSQ.clear();
            this.wSS.clear();
            this.wST.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.wSP == null) {
                c6092b = new C6092b("Not all required fields were included: music_url");
                AppMethodBeat.m2505o(108900);
                throw c6092b;
            }
            AppMethodBeat.m2505o(108900);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bql bql = (bql) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bql.wSJ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(108900);
                    return 0;
                case 2:
                    bql.wSN = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(108900);
                    return 0;
                case 3:
                    bql.wSO = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(108900);
                    return 0;
                case 4:
                    bql.wSP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(108900);
                    return 0;
                case 5:
                    bql.wSQ.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(108900);
                    return 0;
                case 6:
                    bql.wSR = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(108900);
                    return 0;
                case 7:
                    bql.wSS.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(108900);
                    return 0;
                case 8:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bqm bqm = new bqm();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bqm.populateBuilderWithField(c6086a3, bqm, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bql.wST.add(bqm);
                    }
                    AppMethodBeat.m2505o(108900);
                    return 0;
                case 9:
                    bql.kLS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(108900);
                    return 0;
                case 10:
                    bql.fjK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(108900);
                    return 0;
                default:
                    AppMethodBeat.m2505o(108900);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(108900);
            return -1;
        }
    }
}
