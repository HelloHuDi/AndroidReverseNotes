package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ca */
public final class C40506ca extends bsr {
    public int ehB;
    public LinkedList<bay> vEh = new LinkedList();
    public bts vEi;
    public int vEj;
    public String vEk;

    public C40506ca() {
        AppMethodBeat.m2504i(5561);
        AppMethodBeat.m2505o(5561);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(5562);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vEi == null) {
                c6092b = new C6092b("Not all required fields were included: ChatRoomName");
                AppMethodBeat.m2505o(5562);
                throw c6092b;
            }
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.ehB);
            c6093a.mo13474e(3, 8, this.vEh);
            if (this.vEi != null) {
                c6093a.mo13479iy(4, this.vEi.computeSize());
                this.vEi.writeFields(c6093a);
            }
            c6093a.mo13480iz(5, this.vEj);
            if (this.vEk != null) {
                c6093a.mo13475e(6, this.vEk);
            }
            AppMethodBeat.m2505o(5562);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + C6091a.m9572bs(2, this.ehB)) + C6087a.m9552c(3, 8, this.vEh);
            if (this.vEi != null) {
                ix += C6087a.m9557ix(4, this.vEi.computeSize());
            }
            ix += C6091a.m9572bs(5, this.vEj);
            if (this.vEk != null) {
                ix += C6091a.m9575f(6, this.vEk);
            }
            AppMethodBeat.m2505o(5562);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vEh.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.vEi == null) {
                c6092b = new C6092b("Not all required fields were included: ChatRoomName");
                AppMethodBeat.m2505o(5562);
                throw c6092b;
            }
            AppMethodBeat.m2505o(5562);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C40506ca c40506ca = (C40506ca) objArr[1];
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
                        c40506ca.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(5562);
                    return 0;
                case 2:
                    c40506ca.ehB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5562);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bay bay = new bay();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bay.populateBuilderWithField(c6086a3, bay, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40506ca.vEh.add(bay);
                    }
                    AppMethodBeat.m2505o(5562);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40506ca.vEi = bts;
                    }
                    AppMethodBeat.m2505o(5562);
                    return 0;
                case 5:
                    c40506ca.vEj = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5562);
                    return 0;
                case 6:
                    c40506ca.vEk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(5562);
                    return 0;
                default:
                    AppMethodBeat.m2505o(5562);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(5562);
            return -1;
        }
    }
}
