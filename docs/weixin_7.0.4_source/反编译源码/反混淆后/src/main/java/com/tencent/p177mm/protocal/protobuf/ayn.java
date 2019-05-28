package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ayn */
public final class ayn extends bsr {
    public int wCn;
    public LinkedList<bts> wCo = new LinkedList();
    public int wCp;
    public LinkedList<bts> wCq = new LinkedList();
    public String wdB;

    public ayn() {
        AppMethodBeat.m2504i(73733);
        AppMethodBeat.m2505o(73733);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(73734);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.wdB != null) {
                c6093a.mo13475e(2, this.wdB);
            }
            c6093a.mo13480iz(3, this.wCn);
            c6093a.mo13474e(4, 8, this.wCo);
            c6093a.mo13480iz(5, this.wCp);
            c6093a.mo13474e(6, 8, this.wCq);
            AppMethodBeat.m2505o(73734);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wdB != null) {
                ix += C6091a.m9575f(2, this.wdB);
            }
            int bs = (((ix + C6091a.m9572bs(3, this.wCn)) + C6087a.m9552c(4, 8, this.wCo)) + C6091a.m9572bs(5, this.wCp)) + C6087a.m9552c(6, 8, this.wCq);
            AppMethodBeat.m2505o(73734);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wCo.clear();
            this.wCq.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(73734);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ayn ayn = (ayn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            bts bts;
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
                        ayn.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(73734);
                    return 0;
                case 2:
                    ayn.wdB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73734);
                    return 0;
                case 3:
                    ayn.wCn = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73734);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ayn.wCo.add(bts);
                    }
                    AppMethodBeat.m2505o(73734);
                    return 0;
                case 5:
                    ayn.wCp = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73734);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ayn.wCq.add(bts);
                    }
                    AppMethodBeat.m2505o(73734);
                    return 0;
                default:
                    AppMethodBeat.m2505o(73734);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(73734);
            return -1;
        }
    }
}
