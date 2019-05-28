package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.km */
public final class C44137km extends C1331a {
    public boolean vNA;
    public int vNB;
    public boolean vNC;
    public C7264hf vND;
    public boolean vNE;
    public String vNb;
    public int vNt;
    public int vNu;
    public int vNv;
    public int vNw;
    public long vNx;
    public long vNy;
    public int vNz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(11710);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vNb == null) {
                c6092b = new C6092b("Not all required fields were included: brand_user_name");
                AppMethodBeat.m2505o(11710);
                throw c6092b;
            }
            if (this.vNb != null) {
                c6093a.mo13475e(1, this.vNb);
            }
            c6093a.mo13480iz(2, this.vNt);
            c6093a.mo13480iz(3, this.vNu);
            c6093a.mo13480iz(4, this.vNv);
            c6093a.mo13480iz(5, this.vNw);
            c6093a.mo13472ai(6, this.vNx);
            c6093a.mo13472ai(7, this.vNy);
            c6093a.mo13480iz(8, this.vNz);
            c6093a.mo13471aO(9, this.vNA);
            c6093a.mo13480iz(10, this.vNB);
            c6093a.mo13471aO(11, this.vNC);
            if (this.vND != null) {
                c6093a.mo13479iy(12, this.vND.computeSize());
                this.vND.writeFields(c6093a);
            }
            c6093a.mo13471aO(13, this.vNE);
            AppMethodBeat.m2505o(11710);
            return 0;
        } else if (i == 1) {
            if (this.vNb != null) {
                f = C6091a.m9575f(1, this.vNb) + 0;
            } else {
                f = 0;
            }
            f = (((((((((f + C6091a.m9572bs(2, this.vNt)) + C6091a.m9572bs(3, this.vNu)) + C6091a.m9572bs(4, this.vNv)) + C6091a.m9572bs(5, this.vNw)) + C6091a.m9578o(6, this.vNx)) + C6091a.m9578o(7, this.vNy)) + C6091a.m9572bs(8, this.vNz)) + (C6091a.m9576fv(9) + 1)) + C6091a.m9572bs(10, this.vNB)) + (C6091a.m9576fv(11) + 1);
            if (this.vND != null) {
                f += C6087a.m9557ix(12, this.vND.computeSize());
            }
            int fv = f + (C6091a.m9576fv(13) + 1);
            AppMethodBeat.m2505o(11710);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.vNb == null) {
                c6092b = new C6092b("Not all required fields were included: brand_user_name");
                AppMethodBeat.m2505o(11710);
                throw c6092b;
            }
            AppMethodBeat.m2505o(11710);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44137km c44137km = (C44137km) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c44137km.vNb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11710);
                    return 0;
                case 2:
                    c44137km.vNt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11710);
                    return 0;
                case 3:
                    c44137km.vNu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11710);
                    return 0;
                case 4:
                    c44137km.vNv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11710);
                    return 0;
                case 5:
                    c44137km.vNw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11710);
                    return 0;
                case 6:
                    c44137km.vNx = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(11710);
                    return 0;
                case 7:
                    c44137km.vNy = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(11710);
                    return 0;
                case 8:
                    c44137km.vNz = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11710);
                    return 0;
                case 9:
                    c44137km.vNA = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(11710);
                    return 0;
                case 10:
                    c44137km.vNB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11710);
                    return 0;
                case 11:
                    c44137km.vNC = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(11710);
                    return 0;
                case 12:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C7264hf c7264hf = new C7264hf();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c7264hf.populateBuilderWithField(c6086a3, c7264hf, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44137km.vND = c7264hf;
                    }
                    AppMethodBeat.m2505o(11710);
                    return 0;
                case 13:
                    c44137km.vNE = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(11710);
                    return 0;
                default:
                    AppMethodBeat.m2505o(11710);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(11710);
            return -1;
        }
    }
}
