package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cao */
public final class cao extends C1331a {
    public String ptv;
    public long vQE;
    public long wZM;
    public can wZN;
    public can wZO;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94564);
        C6092b c6092b;
        int o;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wZN == null) {
                c6092b = new C6092b("Not all required fields were included: CurrentAction");
                AppMethodBeat.m2505o(94564);
                throw c6092b;
            }
            c6093a.mo13472ai(1, this.vQE);
            c6093a.mo13472ai(2, this.wZM);
            if (this.wZN != null) {
                c6093a.mo13479iy(3, this.wZN.computeSize());
                this.wZN.writeFields(c6093a);
            }
            if (this.wZO != null) {
                c6093a.mo13479iy(4, this.wZO.computeSize());
                this.wZO.writeFields(c6093a);
            }
            if (this.ptv != null) {
                c6093a.mo13475e(5, this.ptv);
            }
            AppMethodBeat.m2505o(94564);
            return 0;
        } else if (i == 1) {
            o = (C6091a.m9578o(1, this.vQE) + 0) + C6091a.m9578o(2, this.wZM);
            if (this.wZN != null) {
                o += C6087a.m9557ix(3, this.wZN.computeSize());
            }
            if (this.wZO != null) {
                o += C6087a.m9557ix(4, this.wZO.computeSize());
            }
            if (this.ptv != null) {
                o += C6091a.m9575f(5, this.ptv);
            }
            AppMethodBeat.m2505o(94564);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (o = C1331a.getNextFieldNumber(c6086a); o > 0; o = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, o)) {
                    c6086a.ems();
                }
            }
            if (this.wZN == null) {
                c6092b = new C6092b("Not all required fields were included: CurrentAction");
                AppMethodBeat.m2505o(94564);
                throw c6092b;
            }
            AppMethodBeat.m2505o(94564);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cao cao = (cao) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            can can;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    cao.vQE = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(94564);
                    return 0;
                case 2:
                    cao.wZM = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(94564);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        can = new can();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = can.populateBuilderWithField(c6086a3, can, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cao.wZN = can;
                    }
                    AppMethodBeat.m2505o(94564);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        can = new can();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = can.populateBuilderWithField(c6086a3, can, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cao.wZO = can;
                    }
                    AppMethodBeat.m2505o(94564);
                    return 0;
                case 5:
                    cao.ptv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94564);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94564);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94564);
            return -1;
        }
    }
}
