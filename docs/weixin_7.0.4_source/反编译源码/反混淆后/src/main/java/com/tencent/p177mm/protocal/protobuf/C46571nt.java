package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.nt */
public final class C46571nt extends C1331a {
    public String vTj;
    public int vTk;
    public String vTl;
    public C30208ny vTm;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(89027);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vTj != null) {
                c6093a.mo13475e(1, this.vTj);
            }
            c6093a.mo13480iz(2, this.vTk);
            if (this.vTl != null) {
                c6093a.mo13475e(3, this.vTl);
            }
            if (this.vTm != null) {
                c6093a.mo13479iy(4, this.vTm.computeSize());
                this.vTm.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(89027);
            return 0;
        } else if (i == 1) {
            if (this.vTj != null) {
                f = C6091a.m9575f(1, this.vTj) + 0;
            } else {
                f = 0;
            }
            f += C6091a.m9572bs(2, this.vTk);
            if (this.vTl != null) {
                f += C6091a.m9575f(3, this.vTl);
            }
            if (this.vTm != null) {
                f += C6087a.m9557ix(4, this.vTm.computeSize());
            }
            AppMethodBeat.m2505o(89027);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(89027);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C46571nt c46571nt = (C46571nt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c46571nt.vTj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89027);
                    return 0;
                case 2:
                    c46571nt.vTk = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89027);
                    return 0;
                case 3:
                    c46571nt.vTl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89027);
                    return 0;
                case 4:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C30208ny c30208ny = new C30208ny();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c30208ny.populateBuilderWithField(c6086a3, c30208ny, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46571nt.vTm = c30208ny;
                    }
                    AppMethodBeat.m2505o(89027);
                    return 0;
                default:
                    AppMethodBeat.m2505o(89027);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(89027);
            return -1;
        }
    }
}
