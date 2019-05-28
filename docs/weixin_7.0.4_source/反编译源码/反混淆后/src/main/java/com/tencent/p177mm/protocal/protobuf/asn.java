package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.asn */
public final class asn extends C1331a {
    public C1332b wvY;
    public int wvZ;
    public LinkedList<asp> wwa = new LinkedList();
    public LinkedList<Integer> wwb = new LinkedList();

    public asn() {
        AppMethodBeat.m2504i(5214);
        AppMethodBeat.m2505o(5214);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(5215);
        C6092b c6092b;
        int b;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wvY == null) {
                c6092b = new C6092b("Not all required fields were included: RawBuf");
                AppMethodBeat.m2505o(5215);
                throw c6092b;
            }
            if (this.wvY != null) {
                c6093a.mo13473c(1, this.wvY);
            }
            c6093a.mo13480iz(2, this.wvZ);
            c6093a.mo13474e(3, 8, this.wwa);
            c6093a.mo13474e(4, 2, this.wwb);
            AppMethodBeat.m2505o(5215);
            return 0;
        } else if (i == 1) {
            if (this.wvY != null) {
                b = C6091a.m9571b(1, this.wvY) + 0;
            } else {
                b = 0;
            }
            int bs = ((b + C6091a.m9572bs(2, this.wvZ)) + C6087a.m9552c(3, 8, this.wwa)) + C6087a.m9552c(4, 2, this.wwb);
            AppMethodBeat.m2505o(5215);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wwa.clear();
            this.wwb.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (b = C1331a.getNextFieldNumber(c6086a); b > 0; b = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, b)) {
                    c6086a.ems();
                }
            }
            if (this.wvY == null) {
                c6092b = new C6092b("Not all required fields were included: RawBuf");
                AppMethodBeat.m2505o(5215);
                throw c6092b;
            }
            AppMethodBeat.m2505o(5215);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            asn asn = (asn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    asn.wvY = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(5215);
                    return 0;
                case 2:
                    asn.wvZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5215);
                    return 0;
                case 3:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        asp asp = new asp();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = asp.populateBuilderWithField(c6086a3, asp, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        asn.wwa.add(asp);
                    }
                    AppMethodBeat.m2505o(5215);
                    return 0;
                case 4:
                    asn.wwb.add(Integer.valueOf(c6086a2.BTU.mo13458vd()));
                    AppMethodBeat.m2505o(5215);
                    return 0;
                default:
                    AppMethodBeat.m2505o(5215);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(5215);
            return -1;
        }
    }
}
