package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cvg */
public final class cvg extends C1331a {
    public int Scene;
    public String luQ;
    public String vKt;
    public long vQd;
    public int wDH;
    public axy wDI;
    public LinkedList<String> xrm = new LinkedList();
    public LinkedList<C23447tn> xrn = new LinkedList();

    public cvg() {
        AppMethodBeat.m2504i(124383);
        AppMethodBeat.m2505o(124383);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(124384);
        int c;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13474e(1, 1, this.xrm);
            c6093a.mo13480iz(2, this.wDH);
            if (this.luQ != null) {
                c6093a.mo13475e(3, this.luQ);
            }
            c6093a.mo13480iz(4, this.Scene);
            c6093a.mo13472ai(5, this.vQd);
            if (this.vKt != null) {
                c6093a.mo13475e(6, this.vKt);
            }
            if (this.wDI != null) {
                c6093a.mo13479iy(7, this.wDI.computeSize());
                this.wDI.writeFields(c6093a);
            }
            c6093a.mo13474e(8, 8, this.xrn);
            AppMethodBeat.m2505o(124384);
            return 0;
        } else if (i == 1) {
            c = (C6087a.m9552c(1, 1, this.xrm) + 0) + C6091a.m9572bs(2, this.wDH);
            if (this.luQ != null) {
                c += C6091a.m9575f(3, this.luQ);
            }
            c = (c + C6091a.m9572bs(4, this.Scene)) + C6091a.m9578o(5, this.vQd);
            if (this.vKt != null) {
                c += C6091a.m9575f(6, this.vKt);
            }
            if (this.wDI != null) {
                c += C6087a.m9557ix(7, this.wDI.computeSize());
            }
            c += C6087a.m9552c(8, 8, this.xrn);
            AppMethodBeat.m2505o(124384);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xrm.clear();
            this.xrn.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(124384);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cvg cvg = (cvg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    cvg.xrm.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(124384);
                    return 0;
                case 2:
                    cvg.wDH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124384);
                    return 0;
                case 3:
                    cvg.luQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124384);
                    return 0;
                case 4:
                    cvg.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124384);
                    return 0;
                case 5:
                    cvg.vQd = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(124384);
                    return 0;
                case 6:
                    cvg.vKt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124384);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        axy axy = new axy();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = axy.populateBuilderWithField(c6086a3, axy, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cvg.wDI = axy;
                    }
                    AppMethodBeat.m2505o(124384);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C23447tn c23447tn = new C23447tn();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23447tn.populateBuilderWithField(c6086a3, c23447tn, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cvg.xrn.add(c23447tn);
                    }
                    AppMethodBeat.m2505o(124384);
                    return 0;
                default:
                    AppMethodBeat.m2505o(124384);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(124384);
            return -1;
        }
    }
}
