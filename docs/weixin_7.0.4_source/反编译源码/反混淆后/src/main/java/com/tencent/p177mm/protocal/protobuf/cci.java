package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cci */
public final class cci extends C1331a {
    public String cvF;
    public long xbJ = 0;
    public long xbK = 0;
    public long xbL = 0;
    public LinkedList<caz> xbM = new LinkedList();

    public cci() {
        AppMethodBeat.m2504i(73657);
        AppMethodBeat.m2505o(73657);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(73658);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.cvF != null) {
                c6093a.mo13475e(1, this.cvF);
            }
            c6093a.mo13472ai(2, this.xbJ);
            c6093a.mo13472ai(3, this.xbK);
            c6093a.mo13472ai(4, this.xbL);
            c6093a.mo13474e(5, 8, this.xbM);
            AppMethodBeat.m2505o(73658);
            return 0;
        } else if (i == 1) {
            if (this.cvF != null) {
                f = C6091a.m9575f(1, this.cvF) + 0;
            } else {
                f = 0;
            }
            int o = (((f + C6091a.m9578o(2, this.xbJ)) + C6091a.m9578o(3, this.xbK)) + C6091a.m9578o(4, this.xbL)) + C6087a.m9552c(5, 8, this.xbM);
            AppMethodBeat.m2505o(73658);
            return o;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xbM.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(73658);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cci cci = (cci) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cci.cvF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73658);
                    return 0;
                case 2:
                    cci.xbJ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(73658);
                    return 0;
                case 3:
                    cci.xbK = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(73658);
                    return 0;
                case 4:
                    cci.xbL = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(73658);
                    return 0;
                case 5:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        caz caz = new caz();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = caz.populateBuilderWithField(c6086a3, caz, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cci.xbM.add(caz);
                    }
                    AppMethodBeat.m2505o(73658);
                    return 0;
                default:
                    AppMethodBeat.m2505o(73658);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(73658);
            return -1;
        }
    }
}
