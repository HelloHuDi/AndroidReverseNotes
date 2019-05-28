package com.tencent.p177mm.plugin.sns.p1025h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.protocal.protobuf.bau;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.sns.h.b */
public final class C34937b extends C1331a {
    public bau cNr;
    public int fDG;
    public String qQd;
    public int qQe;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(36823);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.cNr != null) {
                c6093a.mo13479iy(1, this.cNr.computeSize());
                this.cNr.writeFields(c6093a);
            }
            if (this.qQd != null) {
                c6093a.mo13475e(2, this.qQd);
            }
            c6093a.mo13480iz(3, this.fDG);
            c6093a.mo13480iz(4, this.qQe);
            AppMethodBeat.m2505o(36823);
            return 0;
        } else if (i == 1) {
            if (this.cNr != null) {
                ix = C6087a.m9557ix(1, this.cNr.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.qQd != null) {
                ix += C6091a.m9575f(2, this.qQd);
            }
            int bs = (ix + C6091a.m9572bs(3, this.fDG)) + C6091a.m9572bs(4, this.qQe);
            AppMethodBeat.m2505o(36823);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(36823);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C34937b c34937b = (C34937b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bau bau = new bau();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bau.populateBuilderWithField(c6086a3, bau, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c34937b.cNr = bau;
                    }
                    AppMethodBeat.m2505o(36823);
                    return 0;
                case 2:
                    c34937b.qQd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(36823);
                    return 0;
                case 3:
                    c34937b.fDG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(36823);
                    return 0;
                case 4:
                    c34937b.qQe = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(36823);
                    return 0;
                default:
                    AppMethodBeat.m2505o(36823);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(36823);
            return -1;
        }
    }
}
