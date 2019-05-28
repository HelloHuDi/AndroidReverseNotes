package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cel */
public final class cel extends C1331a {
    public String cvZ;
    public int eRu;
    public String ptv;
    public int wFD;
    public long wFi;
    public int wFm;
    public int xei;
    public cej xej;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56528);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.ptv != null) {
                c6093a.mo13475e(1, this.ptv);
            }
            c6093a.mo13480iz(2, this.eRu);
            c6093a.mo13472ai(3, this.wFi);
            c6093a.mo13480iz(4, this.wFm);
            if (this.cvZ != null) {
                c6093a.mo13475e(5, this.cvZ);
            }
            c6093a.mo13480iz(6, this.wFD);
            c6093a.mo13480iz(7, this.xei);
            if (this.xej != null) {
                c6093a.mo13479iy(8, this.xej.computeSize());
                this.xej.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(56528);
            return 0;
        } else if (i == 1) {
            if (this.ptv != null) {
                f = C6091a.m9575f(1, this.ptv) + 0;
            } else {
                f = 0;
            }
            f = ((f + C6091a.m9572bs(2, this.eRu)) + C6091a.m9578o(3, this.wFi)) + C6091a.m9572bs(4, this.wFm);
            if (this.cvZ != null) {
                f += C6091a.m9575f(5, this.cvZ);
            }
            f = (f + C6091a.m9572bs(6, this.wFD)) + C6091a.m9572bs(7, this.xei);
            if (this.xej != null) {
                f += C6087a.m9557ix(8, this.xej.computeSize());
            }
            AppMethodBeat.m2505o(56528);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56528);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cel cel = (cel) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cel.ptv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56528);
                    return 0;
                case 2:
                    cel.eRu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56528);
                    return 0;
                case 3:
                    cel.wFi = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56528);
                    return 0;
                case 4:
                    cel.wFm = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56528);
                    return 0;
                case 5:
                    cel.cvZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56528);
                    return 0;
                case 6:
                    cel.wFD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56528);
                    return 0;
                case 7:
                    cel.xei = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56528);
                    return 0;
                case 8:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        cej cej = new cej();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cej.populateBuilderWithField(c6086a3, cej, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cel.xej = cej;
                    }
                    AppMethodBeat.m2505o(56528);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56528);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56528);
            return -1;
        }
    }
}
