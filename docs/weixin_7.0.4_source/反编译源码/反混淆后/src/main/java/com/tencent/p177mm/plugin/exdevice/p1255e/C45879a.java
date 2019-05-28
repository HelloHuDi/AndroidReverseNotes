package com.tencent.p177mm.plugin.exdevice.p1255e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.exdevice.e.a */
public final class C45879a extends C42986i {
    public String jBF;
    public C1332b luJ;
    public int luK;
    public int luL;
    public int luM;
    public C1332b luN;
    public C1332b luO;
    public String luP;
    public String luQ;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(19418);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.lvj != null) {
                c6093a.mo13479iy(1, this.lvj.computeSize());
                this.lvj.writeFields(c6093a);
            }
            if (this.luJ != null) {
                c6093a.mo13473c(2, this.luJ);
            }
            c6093a.mo13480iz(3, this.luK);
            c6093a.mo13480iz(4, this.luL);
            c6093a.mo13480iz(5, this.luM);
            if (this.luN != null) {
                c6093a.mo13473c(6, this.luN);
            }
            if (this.luO != null) {
                c6093a.mo13473c(7, this.luO);
            }
            if (this.luP != null) {
                c6093a.mo13475e(10, this.luP);
            }
            if (this.luQ != null) {
                c6093a.mo13475e(11, this.luQ);
            }
            if (this.jBF != null) {
                c6093a.mo13475e(12, this.jBF);
            }
            AppMethodBeat.m2505o(19418);
            return 0;
        } else if (i == 1) {
            if (this.lvj != null) {
                ix = C6087a.m9557ix(1, this.lvj.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.luJ != null) {
                ix += C6091a.m9571b(2, this.luJ);
            }
            ix = ((ix + C6091a.m9572bs(3, this.luK)) + C6091a.m9572bs(4, this.luL)) + C6091a.m9572bs(5, this.luM);
            if (this.luN != null) {
                ix += C6091a.m9571b(6, this.luN);
            }
            if (this.luO != null) {
                ix += C6091a.m9571b(7, this.luO);
            }
            if (this.luP != null) {
                ix += C6091a.m9575f(10, this.luP);
            }
            if (this.luQ != null) {
                ix += C6091a.m9575f(11, this.luQ);
            }
            if (this.jBF != null) {
                ix += C6091a.m9575f(12, this.jBF);
            }
            AppMethodBeat.m2505o(19418);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(19418);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C45879a c45879a = (C45879a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C38932d c38932d = new C38932d();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c38932d.populateBuilderWithField(c6086a3, c38932d, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c45879a.lvj = c38932d;
                    }
                    AppMethodBeat.m2505o(19418);
                    return 0;
                case 2:
                    c45879a.luJ = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(19418);
                    return 0;
                case 3:
                    c45879a.luK = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(19418);
                    return 0;
                case 4:
                    c45879a.luL = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(19418);
                    return 0;
                case 5:
                    c45879a.luM = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(19418);
                    return 0;
                case 6:
                    c45879a.luN = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(19418);
                    return 0;
                case 7:
                    c45879a.luO = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(19418);
                    return 0;
                case 10:
                    c45879a.luP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(19418);
                    return 0;
                case 11:
                    c45879a.luQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(19418);
                    return 0;
                case 12:
                    c45879a.jBF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(19418);
                    return 0;
                default:
                    AppMethodBeat.m2505o(19418);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(19418);
            return -1;
        }
    }
}
