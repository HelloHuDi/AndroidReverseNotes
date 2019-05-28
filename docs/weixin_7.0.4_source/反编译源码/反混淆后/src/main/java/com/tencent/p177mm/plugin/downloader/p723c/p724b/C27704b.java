package com.tencent.p177mm.plugin.downloader.p723c.p724b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.downloader.c.b.b */
public final class C27704b extends C1331a {
    public String egm;
    public String kKO;
    public long kKP;
    public String kKQ;
    public int kKR;
    public int kKS;
    public String kKT;
    public C33905n kKU;
    public String kKV;
    public String kKW;
    public boolean kKX;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(35526);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.egm != null) {
                c6093a.mo13475e(1, this.egm);
            }
            if (this.kKO != null) {
                c6093a.mo13475e(2, this.kKO);
            }
            c6093a.mo13472ai(3, this.kKP);
            if (this.kKQ != null) {
                c6093a.mo13475e(4, this.kKQ);
            }
            c6093a.mo13480iz(6, this.kKR);
            c6093a.mo13480iz(7, this.kKS);
            if (this.kKT != null) {
                c6093a.mo13475e(8, this.kKT);
            }
            if (this.kKU != null) {
                c6093a.mo13479iy(9, this.kKU.computeSize());
                this.kKU.writeFields(c6093a);
            }
            if (this.kKV != null) {
                c6093a.mo13475e(10, this.kKV);
            }
            if (this.kKW != null) {
                c6093a.mo13475e(11, this.kKW);
            }
            c6093a.mo13471aO(12, this.kKX);
            AppMethodBeat.m2505o(35526);
            return 0;
        } else if (i == 1) {
            if (this.egm != null) {
                f = C6091a.m9575f(1, this.egm) + 0;
            } else {
                f = 0;
            }
            if (this.kKO != null) {
                f += C6091a.m9575f(2, this.kKO);
            }
            f += C6091a.m9578o(3, this.kKP);
            if (this.kKQ != null) {
                f += C6091a.m9575f(4, this.kKQ);
            }
            f = (f + C6091a.m9572bs(6, this.kKR)) + C6091a.m9572bs(7, this.kKS);
            if (this.kKT != null) {
                f += C6091a.m9575f(8, this.kKT);
            }
            if (this.kKU != null) {
                f += C6087a.m9557ix(9, this.kKU.computeSize());
            }
            if (this.kKV != null) {
                f += C6091a.m9575f(10, this.kKV);
            }
            if (this.kKW != null) {
                f += C6091a.m9575f(11, this.kKW);
            }
            int fv = f + (C6091a.m9576fv(12) + 1);
            AppMethodBeat.m2505o(35526);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(35526);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C27704b c27704b = (C27704b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c27704b.egm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(35526);
                    return 0;
                case 2:
                    c27704b.kKO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(35526);
                    return 0;
                case 3:
                    c27704b.kKP = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(35526);
                    return 0;
                case 4:
                    c27704b.kKQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(35526);
                    return 0;
                case 6:
                    c27704b.kKR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(35526);
                    return 0;
                case 7:
                    c27704b.kKS = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(35526);
                    return 0;
                case 8:
                    c27704b.kKT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(35526);
                    return 0;
                case 9:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C33905n c33905n = new C33905n();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c33905n.populateBuilderWithField(c6086a3, c33905n, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c27704b.kKU = c33905n;
                    }
                    AppMethodBeat.m2505o(35526);
                    return 0;
                case 10:
                    c27704b.kKV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(35526);
                    return 0;
                case 11:
                    c27704b.kKW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(35526);
                    return 0;
                case 12:
                    c27704b.kKX = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(35526);
                    return 0;
                default:
                    AppMethodBeat.m2505o(35526);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(35526);
            return -1;
        }
    }
}
