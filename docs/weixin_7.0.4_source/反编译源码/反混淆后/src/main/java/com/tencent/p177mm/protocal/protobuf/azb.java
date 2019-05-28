package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.azb */
public final class azb extends C1331a {
    public String wCO;
    public boolean wCP;
    public C44124gw wCQ;
    public String wCR;
    public boolean wCS;
    public int wCT;
    public String wCU;
    public int wCV;
    public LinkedList<C40553oq> wmz = new LinkedList();

    public azb() {
        AppMethodBeat.m2504i(56849);
        AppMethodBeat.m2505o(56849);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56850);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wCO != null) {
                c6093a.mo13475e(1, this.wCO);
            }
            c6093a.mo13474e(2, 8, this.wmz);
            c6093a.mo13471aO(3, this.wCP);
            if (this.wCQ != null) {
                c6093a.mo13479iy(4, this.wCQ.computeSize());
                this.wCQ.writeFields(c6093a);
            }
            if (this.wCR != null) {
                c6093a.mo13475e(5, this.wCR);
            }
            c6093a.mo13471aO(6, this.wCS);
            c6093a.mo13480iz(7, this.wCT);
            if (this.wCU != null) {
                c6093a.mo13475e(8, this.wCU);
            }
            c6093a.mo13480iz(9, this.wCV);
            AppMethodBeat.m2505o(56850);
            return 0;
        } else if (i == 1) {
            if (this.wCO != null) {
                f = C6091a.m9575f(1, this.wCO) + 0;
            } else {
                f = 0;
            }
            f = (f + C6087a.m9552c(2, 8, this.wmz)) + (C6091a.m9576fv(3) + 1);
            if (this.wCQ != null) {
                f += C6087a.m9557ix(4, this.wCQ.computeSize());
            }
            if (this.wCR != null) {
                f += C6091a.m9575f(5, this.wCR);
            }
            f = (f + (C6091a.m9576fv(6) + 1)) + C6091a.m9572bs(7, this.wCT);
            if (this.wCU != null) {
                f += C6091a.m9575f(8, this.wCU);
            }
            int bs = f + C6091a.m9572bs(9, this.wCV);
            AppMethodBeat.m2505o(56850);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wmz.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56850);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            azb azb = (azb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    azb.wCO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56850);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C40553oq c40553oq = new C40553oq();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c40553oq.populateBuilderWithField(c6086a3, c40553oq, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        azb.wmz.add(c40553oq);
                    }
                    AppMethodBeat.m2505o(56850);
                    return 0;
                case 3:
                    azb.wCP = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(56850);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C44124gw c44124gw = new C44124gw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c44124gw.populateBuilderWithField(c6086a3, c44124gw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        azb.wCQ = c44124gw;
                    }
                    AppMethodBeat.m2505o(56850);
                    return 0;
                case 5:
                    azb.wCR = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56850);
                    return 0;
                case 6:
                    azb.wCS = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(56850);
                    return 0;
                case 7:
                    azb.wCT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56850);
                    return 0;
                case 8:
                    azb.wCU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56850);
                    return 0;
                case 9:
                    azb.wCV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56850);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56850);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56850);
            return -1;
        }
    }
}
