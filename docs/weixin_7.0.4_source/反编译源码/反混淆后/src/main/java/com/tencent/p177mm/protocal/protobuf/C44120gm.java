package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.gm */
public final class C44120gm extends C1331a {
    public LinkedList<String> vII = new LinkedList();
    public int vIJ;
    public int vIK;

    public C44120gm() {
        AppMethodBeat.m2504i(62511);
        AppMethodBeat.m2505o(62511);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(62512);
        int c;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13474e(1, 1, this.vII);
            c6093a.mo13480iz(2, this.vIJ);
            c6093a.mo13480iz(3, this.vIK);
            AppMethodBeat.m2505o(62512);
            return 0;
        } else if (i == 1) {
            c = ((C6087a.m9552c(1, 1, this.vII) + 0) + C6091a.m9572bs(2, this.vIJ)) + C6091a.m9572bs(3, this.vIK);
            AppMethodBeat.m2505o(62512);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.vII.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(62512);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44120gm c44120gm = (C44120gm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c44120gm.vII.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(62512);
                    return 0;
                case 2:
                    c44120gm.vIJ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62512);
                    return 0;
                case 3:
                    c44120gm.vIK = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62512);
                    return 0;
                default:
                    AppMethodBeat.m2505o(62512);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(62512);
            return -1;
        }
    }
}
