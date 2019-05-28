package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bqh */
public final class bqh extends C1331a {
    public bts wSA;
    public int wSB;
    public LinkedList<bvn> wSC = new LinkedList();

    public bqh() {
        AppMethodBeat.m2504i(14738);
        AppMethodBeat.m2505o(14738);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(14739);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wSA == null) {
                c6092b = new C6092b("Not all required fields were included: GroupName");
                AppMethodBeat.m2505o(14739);
                throw c6092b;
            }
            if (this.wSA != null) {
                c6093a.mo13479iy(1, this.wSA.computeSize());
                this.wSA.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.wSB);
            c6093a.mo13474e(3, 8, this.wSC);
            AppMethodBeat.m2505o(14739);
            return 0;
        } else if (i == 1) {
            if (this.wSA != null) {
                ix = C6087a.m9557ix(1, this.wSA.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = (ix + C6091a.m9572bs(2, this.wSB)) + C6087a.m9552c(3, 8, this.wSC);
            AppMethodBeat.m2505o(14739);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wSC.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.wSA == null) {
                c6092b = new C6092b("Not all required fields were included: GroupName");
                AppMethodBeat.m2505o(14739);
                throw c6092b;
            }
            AppMethodBeat.m2505o(14739);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bqh bqh = (bqh) objArr[1];
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
                        bts bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bqh.wSA = bts;
                    }
                    AppMethodBeat.m2505o(14739);
                    return 0;
                case 2:
                    bqh.wSB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14739);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bvn bvn = new bvn();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bvn.populateBuilderWithField(c6086a3, bvn, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bqh.wSC.add(bvn);
                    }
                    AppMethodBeat.m2505o(14739);
                    return 0;
                default:
                    AppMethodBeat.m2505o(14739);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(14739);
            return -1;
        }
    }
}
