package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.agz */
public final class agz extends C1331a {
    public String wno;
    public C30213ph wnu;
    public String wnv;
    public boolean wnw;
    public int wnx;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(89091);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wnu != null) {
                c6093a.mo13479iy(1, this.wnu.computeSize());
                this.wnu.writeFields(c6093a);
            }
            if (this.wno != null) {
                c6093a.mo13475e(2, this.wno);
            }
            if (this.wnv != null) {
                c6093a.mo13475e(3, this.wnv);
            }
            c6093a.mo13471aO(4, this.wnw);
            c6093a.mo13480iz(5, this.wnx);
            AppMethodBeat.m2505o(89091);
            return 0;
        } else if (i == 1) {
            if (this.wnu != null) {
                ix = C6087a.m9557ix(1, this.wnu.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wno != null) {
                ix += C6091a.m9575f(2, this.wno);
            }
            if (this.wnv != null) {
                ix += C6091a.m9575f(3, this.wnv);
            }
            int fv = (ix + (C6091a.m9576fv(4) + 1)) + C6091a.m9572bs(5, this.wnx);
            AppMethodBeat.m2505o(89091);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(89091);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            agz agz = (agz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C30213ph c30213ph = new C30213ph();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c30213ph.populateBuilderWithField(c6086a3, c30213ph, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        agz.wnu = c30213ph;
                    }
                    AppMethodBeat.m2505o(89091);
                    return 0;
                case 2:
                    agz.wno = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89091);
                    return 0;
                case 3:
                    agz.wnv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89091);
                    return 0;
                case 4:
                    agz.wnw = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(89091);
                    return 0;
                case 5:
                    agz.wnx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89091);
                    return 0;
                default:
                    AppMethodBeat.m2505o(89091);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(89091);
            return -1;
        }
    }
}
