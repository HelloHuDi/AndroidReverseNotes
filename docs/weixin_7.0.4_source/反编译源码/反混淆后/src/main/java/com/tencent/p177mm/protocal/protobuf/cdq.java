package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cdq */
public final class cdq extends C1331a {
    public LinkedList<cdz> qQg = new LinkedList();
    public LinkedList<cdz> qQh = new LinkedList();
    public LinkedList<cdz> qQi = new LinkedList();
    public LinkedList<cdz> qQj = new LinkedList();
    public LinkedList<ceq> qQk = new LinkedList();
    public LinkedList<ceq> qQl = new LinkedList();

    public cdq() {
        AppMethodBeat.m2504i(56497);
        AppMethodBeat.m2505o(56497);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56498);
        int c;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13474e(1, 8, this.qQg);
            c6093a.mo13474e(2, 8, this.qQh);
            c6093a.mo13474e(3, 8, this.qQi);
            c6093a.mo13474e(4, 8, this.qQj);
            c6093a.mo13474e(5, 8, this.qQk);
            c6093a.mo13474e(6, 8, this.qQl);
            AppMethodBeat.m2505o(56498);
            return 0;
        } else if (i == 1) {
            c = (((((C6087a.m9552c(1, 8, this.qQg) + 0) + C6087a.m9552c(2, 8, this.qQh)) + C6087a.m9552c(3, 8, this.qQi)) + C6087a.m9552c(4, 8, this.qQj)) + C6087a.m9552c(5, 8, this.qQk)) + C6087a.m9552c(6, 8, this.qQl);
            AppMethodBeat.m2505o(56498);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.qQg.clear();
            this.qQh.clear();
            this.qQi.clear();
            this.qQj.clear();
            this.qQk.clear();
            this.qQl.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56498);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cdq cdq = (cdq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            cdz cdz;
            C6086a c6086a3;
            boolean z;
            ceq ceq;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdz = new cdz();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdz.populateBuilderWithField(c6086a3, cdz, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cdq.qQg.add(cdz);
                    }
                    AppMethodBeat.m2505o(56498);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdz = new cdz();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdz.populateBuilderWithField(c6086a3, cdz, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cdq.qQh.add(cdz);
                    }
                    AppMethodBeat.m2505o(56498);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdz = new cdz();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdz.populateBuilderWithField(c6086a3, cdz, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cdq.qQi.add(cdz);
                    }
                    AppMethodBeat.m2505o(56498);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdz = new cdz();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdz.populateBuilderWithField(c6086a3, cdz, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cdq.qQj.add(cdz);
                    }
                    AppMethodBeat.m2505o(56498);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ceq = new ceq();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ceq.populateBuilderWithField(c6086a3, ceq, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cdq.qQk.add(ceq);
                    }
                    AppMethodBeat.m2505o(56498);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ceq = new ceq();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ceq.populateBuilderWithField(c6086a3, ceq, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cdq.qQl.add(ceq);
                    }
                    AppMethodBeat.m2505o(56498);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56498);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56498);
            return -1;
        }
    }
}
