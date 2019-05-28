package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.fe */
public final class C30182fe extends C1331a {
    public int vHa;
    public int vHb;
    public int vHi;
    public C23386ff vHj;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28316);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.vHa);
            c6093a.mo13480iz(2, this.vHb);
            c6093a.mo13480iz(3, this.vHi);
            if (this.vHj != null) {
                c6093a.mo13479iy(4, this.vHj.computeSize());
                this.vHj.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(28316);
            return 0;
        } else if (i == 1) {
            bs = ((C6091a.m9572bs(1, this.vHa) + 0) + C6091a.m9572bs(2, this.vHb)) + C6091a.m9572bs(3, this.vHi);
            if (this.vHj != null) {
                bs += C6087a.m9557ix(4, this.vHj.computeSize());
            }
            AppMethodBeat.m2505o(28316);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28316);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C30182fe c30182fe = (C30182fe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c30182fe.vHa = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28316);
                    return 0;
                case 2:
                    c30182fe.vHb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28316);
                    return 0;
                case 3:
                    c30182fe.vHi = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28316);
                    return 0;
                case 4:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C23386ff c23386ff = new C23386ff();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c23386ff.populateBuilderWithField(c6086a3, c23386ff, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30182fe.vHj = c23386ff;
                    }
                    AppMethodBeat.m2505o(28316);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28316);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28316);
            return -1;
        }
    }
}
