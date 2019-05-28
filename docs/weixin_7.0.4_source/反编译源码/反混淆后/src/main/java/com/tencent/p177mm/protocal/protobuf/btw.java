package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.btw */
public final class btw extends C1331a {
    public LinkedList<aza> wVM = new LinkedList();
    public boolean wVN;
    public boolean wVO;
    public boolean wVP;
    public boolean wVQ;
    public boolean wVR;

    public btw() {
        AppMethodBeat.m2504i(73753);
        AppMethodBeat.m2505o(73753);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(73754);
        int c;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13474e(1, 8, this.wVM);
            c6093a.mo13471aO(2, this.wVN);
            c6093a.mo13471aO(3, this.wVO);
            c6093a.mo13471aO(4, this.wVP);
            c6093a.mo13471aO(5, this.wVQ);
            c6093a.mo13471aO(6, this.wVR);
            AppMethodBeat.m2505o(73754);
            return 0;
        } else if (i == 1) {
            c = (((((C6087a.m9552c(1, 8, this.wVM) + 0) + (C6091a.m9576fv(2) + 1)) + (C6091a.m9576fv(3) + 1)) + (C6091a.m9576fv(4) + 1)) + (C6091a.m9576fv(5) + 1)) + (C6091a.m9576fv(6) + 1);
            AppMethodBeat.m2505o(73754);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wVM.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(73754);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            btw btw = (btw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aza aza = new aza();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = aza.populateBuilderWithField(c6086a3, aza, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        btw.wVM.add(aza);
                    }
                    AppMethodBeat.m2505o(73754);
                    return 0;
                case 2:
                    btw.wVN = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(73754);
                    return 0;
                case 3:
                    btw.wVO = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(73754);
                    return 0;
                case 4:
                    btw.wVP = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(73754);
                    return 0;
                case 5:
                    btw.wVQ = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(73754);
                    return 0;
                case 6:
                    btw.wVR = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(73754);
                    return 0;
                default:
                    AppMethodBeat.m2505o(73754);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(73754);
            return -1;
        }
    }
}
