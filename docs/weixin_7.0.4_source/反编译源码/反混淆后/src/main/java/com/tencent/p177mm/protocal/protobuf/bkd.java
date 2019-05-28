package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bkd */
public final class bkd extends C1331a {
    public cgv vCN;
    public cgv vCO;
    public auj wNo;
    public LinkedList<C23420ob> wNp = new LinkedList();
    public bdw wNq;

    public bkd() {
        AppMethodBeat.m2504i(48922);
        AppMethodBeat.m2505o(48922);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48923);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wNo != null) {
                c6093a.mo13479iy(1, this.wNo.computeSize());
                this.wNo.writeFields(c6093a);
            }
            if (this.vCN != null) {
                c6093a.mo13479iy(2, this.vCN.computeSize());
                this.vCN.writeFields(c6093a);
            }
            if (this.vCO != null) {
                c6093a.mo13479iy(3, this.vCO.computeSize());
                this.vCO.writeFields(c6093a);
            }
            c6093a.mo13474e(4, 8, this.wNp);
            if (this.wNq != null) {
                c6093a.mo13479iy(5, this.wNq.computeSize());
                this.wNq.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(48923);
            return 0;
        } else if (i == 1) {
            if (this.wNo != null) {
                ix = C6087a.m9557ix(1, this.wNo.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vCN != null) {
                ix += C6087a.m9557ix(2, this.vCN.computeSize());
            }
            if (this.vCO != null) {
                ix += C6087a.m9557ix(3, this.vCO.computeSize());
            }
            ix += C6087a.m9552c(4, 8, this.wNp);
            if (this.wNq != null) {
                ix += C6087a.m9557ix(5, this.wNq.computeSize());
            }
            AppMethodBeat.m2505o(48923);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wNp.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48923);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bkd bkd = (bkd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            cgv cgv;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        auj auj = new auj();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = auj.populateBuilderWithField(c6086a3, auj, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bkd.wNo = auj;
                    }
                    AppMethodBeat.m2505o(48923);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv = new cgv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(c6086a3, cgv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bkd.vCN = cgv;
                    }
                    AppMethodBeat.m2505o(48923);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv = new cgv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(c6086a3, cgv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bkd.vCO = cgv;
                    }
                    AppMethodBeat.m2505o(48923);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C23420ob c23420ob = new C23420ob();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23420ob.populateBuilderWithField(c6086a3, c23420ob, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bkd.wNp.add(c23420ob);
                    }
                    AppMethodBeat.m2505o(48923);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bdw bdw = new bdw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdw.populateBuilderWithField(c6086a3, bdw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bkd.wNq = bdw;
                    }
                    AppMethodBeat.m2505o(48923);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48923);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48923);
            return -1;
        }
    }
}
