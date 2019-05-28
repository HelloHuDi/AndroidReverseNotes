package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.np */
public final class C7275np extends C1331a {
    public String vSs;
    public String vSt;
    public String vSu;
    public int vSv;
    public C30208ny vSw;
    public int vSx;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(89021);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vSs != null) {
                c6093a.mo13475e(1, this.vSs);
            }
            if (this.vSt != null) {
                c6093a.mo13475e(2, this.vSt);
            }
            if (this.vSu != null) {
                c6093a.mo13475e(3, this.vSu);
            }
            c6093a.mo13480iz(4, this.vSv);
            if (this.vSw != null) {
                c6093a.mo13479iy(5, this.vSw.computeSize());
                this.vSw.writeFields(c6093a);
            }
            c6093a.mo13480iz(6, this.vSx);
            AppMethodBeat.m2505o(89021);
            return 0;
        } else if (i == 1) {
            if (this.vSs != null) {
                f = C6091a.m9575f(1, this.vSs) + 0;
            } else {
                f = 0;
            }
            if (this.vSt != null) {
                f += C6091a.m9575f(2, this.vSt);
            }
            if (this.vSu != null) {
                f += C6091a.m9575f(3, this.vSu);
            }
            f += C6091a.m9572bs(4, this.vSv);
            if (this.vSw != null) {
                f += C6087a.m9557ix(5, this.vSw.computeSize());
            }
            int bs = f + C6091a.m9572bs(6, this.vSx);
            AppMethodBeat.m2505o(89021);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(89021);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7275np c7275np = (C7275np) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c7275np.vSs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89021);
                    return 0;
                case 2:
                    c7275np.vSt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89021);
                    return 0;
                case 3:
                    c7275np.vSu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89021);
                    return 0;
                case 4:
                    c7275np.vSv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89021);
                    return 0;
                case 5:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C30208ny c30208ny = new C30208ny();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c30208ny.populateBuilderWithField(c6086a3, c30208ny, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7275np.vSw = c30208ny;
                    }
                    AppMethodBeat.m2505o(89021);
                    return 0;
                case 6:
                    c7275np.vSx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89021);
                    return 0;
                default:
                    AppMethodBeat.m2505o(89021);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(89021);
            return -1;
        }
    }
}
