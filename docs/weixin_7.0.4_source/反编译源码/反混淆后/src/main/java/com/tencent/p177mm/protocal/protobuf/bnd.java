package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bnd */
public final class bnd extends C1331a {
    public String cMC;
    public int wPW;
    public boolean wPX;
    public String wPY;
    public int wPZ;
    public int wQa;
    public LinkedList<bnc> wQb = new LinkedList();

    public bnd() {
        AppMethodBeat.m2504i(89124);
        AppMethodBeat.m2505o(89124);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(89125);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.cMC != null) {
                c6093a.mo13475e(1, this.cMC);
            }
            c6093a.mo13480iz(2, this.wPW);
            c6093a.mo13471aO(3, this.wPX);
            if (this.wPY != null) {
                c6093a.mo13475e(4, this.wPY);
            }
            c6093a.mo13480iz(5, this.wPZ);
            c6093a.mo13480iz(6, this.wQa);
            c6093a.mo13474e(7, 8, this.wQb);
            AppMethodBeat.m2505o(89125);
            return 0;
        } else if (i == 1) {
            if (this.cMC != null) {
                f = C6091a.m9575f(1, this.cMC) + 0;
            } else {
                f = 0;
            }
            f = (f + C6091a.m9572bs(2, this.wPW)) + (C6091a.m9576fv(3) + 1);
            if (this.wPY != null) {
                f += C6091a.m9575f(4, this.wPY);
            }
            int bs = ((f + C6091a.m9572bs(5, this.wPZ)) + C6091a.m9572bs(6, this.wQa)) + C6087a.m9552c(7, 8, this.wQb);
            AppMethodBeat.m2505o(89125);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wQb.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(89125);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bnd bnd = (bnd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bnd.cMC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89125);
                    return 0;
                case 2:
                    bnd.wPW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89125);
                    return 0;
                case 3:
                    bnd.wPX = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(89125);
                    return 0;
                case 4:
                    bnd.wPY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89125);
                    return 0;
                case 5:
                    bnd.wPZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89125);
                    return 0;
                case 6:
                    bnd.wQa = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89125);
                    return 0;
                case 7:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bnc bnc = new bnc();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bnc.populateBuilderWithField(c6086a3, bnc, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bnd.wQb.add(bnc);
                    }
                    AppMethodBeat.m2505o(89125);
                    return 0;
                default:
                    AppMethodBeat.m2505o(89125);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(89125);
            return -1;
        }
    }
}
