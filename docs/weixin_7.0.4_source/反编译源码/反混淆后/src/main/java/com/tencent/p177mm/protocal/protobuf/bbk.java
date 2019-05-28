package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bbk */
public final class bbk extends C1331a {
    public boolean wFY;
    public String wFZ;
    public LinkedList<Integer> wGa = new LinkedList();

    public bbk() {
        AppMethodBeat.m2504i(56856);
        AppMethodBeat.m2505o(56856);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56857);
        int fv;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13471aO(1, this.wFY);
            if (this.wFZ != null) {
                c6093a.mo13475e(2, this.wFZ);
            }
            c6093a.mo13474e(3, 2, this.wGa);
            AppMethodBeat.m2505o(56857);
            return 0;
        } else if (i == 1) {
            fv = (C6091a.m9576fv(1) + 1) + 0;
            if (this.wFZ != null) {
                fv += C6091a.m9575f(2, this.wFZ);
            }
            fv += C6087a.m9552c(3, 2, this.wGa);
            AppMethodBeat.m2505o(56857);
            return fv;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.wGa.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (fv = C1331a.getNextFieldNumber(c6086a); fv > 0; fv = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, fv)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56857);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bbk bbk = (bbk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bbk.wFY = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(56857);
                    return 0;
                case 2:
                    bbk.wFZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56857);
                    return 0;
                case 3:
                    bbk.wGa.add(Integer.valueOf(c6086a2.BTU.mo13458vd()));
                    AppMethodBeat.m2505o(56857);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56857);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56857);
            return -1;
        }
    }
}
