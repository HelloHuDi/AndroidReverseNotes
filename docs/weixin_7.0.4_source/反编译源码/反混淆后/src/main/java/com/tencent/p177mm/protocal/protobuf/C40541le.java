package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.le */
public final class C40541le extends C1331a {
    public String vOF;
    public int vOG;
    public String vOH;
    public int vOI;
    public LinkedList<C46557jw> vOJ = new LinkedList();

    public C40541le() {
        AppMethodBeat.m2504i(80029);
        AppMethodBeat.m2505o(80029);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80030);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vOF != null) {
                c6093a.mo13475e(1, this.vOF);
            }
            c6093a.mo13480iz(2, this.vOG);
            if (this.vOH != null) {
                c6093a.mo13475e(3, this.vOH);
            }
            c6093a.mo13480iz(4, this.vOI);
            c6093a.mo13474e(5, 8, this.vOJ);
            AppMethodBeat.m2505o(80030);
            return 0;
        } else if (i == 1) {
            if (this.vOF != null) {
                f = C6091a.m9575f(1, this.vOF) + 0;
            } else {
                f = 0;
            }
            f += C6091a.m9572bs(2, this.vOG);
            if (this.vOH != null) {
                f += C6091a.m9575f(3, this.vOH);
            }
            int bs = (f + C6091a.m9572bs(4, this.vOI)) + C6087a.m9552c(5, 8, this.vOJ);
            AppMethodBeat.m2505o(80030);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vOJ.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(80030);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C40541le c40541le = (C40541le) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c40541le.vOF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80030);
                    return 0;
                case 2:
                    c40541le.vOG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80030);
                    return 0;
                case 3:
                    c40541le.vOH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80030);
                    return 0;
                case 4:
                    c40541le.vOI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80030);
                    return 0;
                case 5:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C46557jw c46557jw = new C46557jw();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c46557jw.populateBuilderWithField(c6086a3, c46557jw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40541le.vOJ.add(c46557jw);
                    }
                    AppMethodBeat.m2505o(80030);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80030);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80030);
            return -1;
        }
    }
}
