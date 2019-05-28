package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cqg */
public final class cqg extends bsr {
    public long xlQ;
    public cqf xmK;
    public cqf xok;
    public cqf xol;
    public cqf xom;
    public cqf xon;
    public int xoo;
    public LinkedList<bts> xop = new LinkedList();

    public cqg() {
        AppMethodBeat.m2504i(5275);
        AppMethodBeat.m2505o(5275);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(5276);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xmK == null) {
                c6092b = new C6092b("Not all required fields were included: ReportData");
                AppMethodBeat.m2505o(5276);
                throw c6092b;
            }
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.xmK != null) {
                c6093a.mo13479iy(2, this.xmK.computeSize());
                this.xmK.writeFields(c6093a);
            }
            if (this.xok != null) {
                c6093a.mo13479iy(3, this.xok.computeSize());
                this.xok.writeFields(c6093a);
            }
            if (this.xol != null) {
                c6093a.mo13479iy(4, this.xol.computeSize());
                this.xol.writeFields(c6093a);
            }
            if (this.xom != null) {
                c6093a.mo13479iy(5, this.xom.computeSize());
                this.xom.writeFields(c6093a);
            }
            c6093a.mo13472ai(6, this.xlQ);
            if (this.xon != null) {
                c6093a.mo13479iy(7, this.xon.computeSize());
                this.xon.writeFields(c6093a);
            }
            c6093a.mo13480iz(8, this.xoo);
            c6093a.mo13474e(9, 8, this.xop);
            AppMethodBeat.m2505o(5276);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.xmK != null) {
                ix += C6087a.m9557ix(2, this.xmK.computeSize());
            }
            if (this.xok != null) {
                ix += C6087a.m9557ix(3, this.xok.computeSize());
            }
            if (this.xol != null) {
                ix += C6087a.m9557ix(4, this.xol.computeSize());
            }
            if (this.xom != null) {
                ix += C6087a.m9557ix(5, this.xom.computeSize());
            }
            ix += C6091a.m9578o(6, this.xlQ);
            if (this.xon != null) {
                ix += C6087a.m9557ix(7, this.xon.computeSize());
            }
            int bs = (ix + C6091a.m9572bs(8, this.xoo)) + C6087a.m9552c(9, 8, this.xop);
            AppMethodBeat.m2505o(5276);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xop.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.xmK == null) {
                c6092b = new C6092b("Not all required fields were included: ReportData");
                AppMethodBeat.m2505o(5276);
                throw c6092b;
            }
            AppMethodBeat.m2505o(5276);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cqg cqg = (cqg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            cqf cqf;
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
                        cqg.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(5276);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cqf = new cqf();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cqf.populateBuilderWithField(c6086a3, cqf, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cqg.xmK = cqf;
                    }
                    AppMethodBeat.m2505o(5276);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cqf = new cqf();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cqf.populateBuilderWithField(c6086a3, cqf, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cqg.xok = cqf;
                    }
                    AppMethodBeat.m2505o(5276);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cqf = new cqf();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cqf.populateBuilderWithField(c6086a3, cqf, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cqg.xol = cqf;
                    }
                    AppMethodBeat.m2505o(5276);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cqf = new cqf();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cqf.populateBuilderWithField(c6086a3, cqf, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cqg.xom = cqf;
                    }
                    AppMethodBeat.m2505o(5276);
                    return 0;
                case 6:
                    cqg.xlQ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(5276);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cqf = new cqf();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cqf.populateBuilderWithField(c6086a3, cqf, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cqg.xon = cqf;
                    }
                    AppMethodBeat.m2505o(5276);
                    return 0;
                case 8:
                    cqg.xoo = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5276);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cqg.xop.add(bts);
                    }
                    AppMethodBeat.m2505o(5276);
                    return 0;
                default:
                    AppMethodBeat.m2505o(5276);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(5276);
            return -1;
        }
    }
}
