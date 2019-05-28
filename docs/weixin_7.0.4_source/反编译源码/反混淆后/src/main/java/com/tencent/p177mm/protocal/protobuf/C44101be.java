package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.be */
public final class C44101be extends C1331a {
    public int flags = -1;
    public int state = -1;
    public chm vDg;
    public String vDh = "";

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(73644);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vDg != null) {
                c6093a.mo13479iy(1, this.vDg.computeSize());
                this.vDg.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.flags);
            c6093a.mo13480iz(3, this.state);
            if (this.vDh != null) {
                c6093a.mo13475e(4, this.vDh);
            }
            AppMethodBeat.m2505o(73644);
            return 0;
        } else if (i == 1) {
            if (this.vDg != null) {
                ix = C6087a.m9557ix(1, this.vDg.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + C6091a.m9572bs(2, this.flags)) + C6091a.m9572bs(3, this.state);
            if (this.vDh != null) {
                ix += C6091a.m9575f(4, this.vDh);
            }
            AppMethodBeat.m2505o(73644);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(73644);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44101be c44101be = (C44101be) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        chm chm = new chm();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = chm.populateBuilderWithField(c6086a3, chm, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44101be.vDg = chm;
                    }
                    AppMethodBeat.m2505o(73644);
                    return 0;
                case 2:
                    c44101be.flags = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73644);
                    return 0;
                case 3:
                    c44101be.state = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73644);
                    return 0;
                case 4:
                    c44101be.vDh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73644);
                    return 0;
                default:
                    AppMethodBeat.m2505o(73644);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(73644);
            return -1;
        }
    }
}
