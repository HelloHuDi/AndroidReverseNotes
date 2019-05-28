package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cej */
public final class cej extends C1331a {
    public int rTW;
    public int xdZ;
    public long xee;
    public boolean xef;
    public LinkedList<String> xeg = new LinkedList();
    public LinkedList<String> xeh = new LinkedList();

    public cej() {
        AppMethodBeat.m2504i(56525);
        AppMethodBeat.m2505o(56525);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56526);
        int o;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13472ai(1, this.xee);
            c6093a.mo13480iz(2, this.rTW);
            c6093a.mo13480iz(3, this.xdZ);
            c6093a.mo13471aO(4, this.xef);
            c6093a.mo13474e(5, 1, this.xeg);
            c6093a.mo13474e(6, 1, this.xeh);
            AppMethodBeat.m2505o(56526);
            return 0;
        } else if (i == 1) {
            o = (((((C6091a.m9578o(1, this.xee) + 0) + C6091a.m9572bs(2, this.rTW)) + C6091a.m9572bs(3, this.xdZ)) + (C6091a.m9576fv(4) + 1)) + C6087a.m9552c(5, 1, this.xeg)) + C6087a.m9552c(6, 1, this.xeh);
            AppMethodBeat.m2505o(56526);
            return o;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.xeg.clear();
            this.xeh.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (o = C1331a.getNextFieldNumber(c6086a); o > 0; o = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, o)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56526);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cej cej = (cej) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cej.xee = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56526);
                    return 0;
                case 2:
                    cej.rTW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56526);
                    return 0;
                case 3:
                    cej.xdZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56526);
                    return 0;
                case 4:
                    cej.xef = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(56526);
                    return 0;
                case 5:
                    cej.xeg.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(56526);
                    return 0;
                case 6:
                    cej.xeh.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(56526);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56526);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56526);
            return -1;
        }
    }
}
