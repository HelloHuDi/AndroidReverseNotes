package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.fc */
public final class C44118fc extends C1331a {
    public int OpCode;
    public String fKh;
    public int vHa;
    public int vHb;
    public C30183fh vHc;
    public C44117fb vHd;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28314);
        C6092b c6092b;
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.fKh == null) {
                c6092b = new C6092b("Not all required fields were included: AppId");
                AppMethodBeat.m2505o(28314);
                throw c6092b;
            }
            c6093a.mo13480iz(1, this.OpCode);
            if (this.fKh != null) {
                c6093a.mo13475e(2, this.fKh);
            }
            c6093a.mo13480iz(3, this.vHa);
            c6093a.mo13480iz(4, this.vHb);
            if (this.vHc != null) {
                c6093a.mo13479iy(5, this.vHc.computeSize());
                this.vHc.writeFields(c6093a);
            }
            if (this.vHd != null) {
                c6093a.mo13479iy(6, this.vHd.computeSize());
                this.vHd.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(28314);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.OpCode) + 0;
            if (this.fKh != null) {
                bs += C6091a.m9575f(2, this.fKh);
            }
            bs = (bs + C6091a.m9572bs(3, this.vHa)) + C6091a.m9572bs(4, this.vHb);
            if (this.vHc != null) {
                bs += C6087a.m9557ix(5, this.vHc.computeSize());
            }
            if (this.vHd != null) {
                bs += C6087a.m9557ix(6, this.vHd.computeSize());
            }
            AppMethodBeat.m2505o(28314);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.fKh == null) {
                c6092b = new C6092b("Not all required fields were included: AppId");
                AppMethodBeat.m2505o(28314);
                throw c6092b;
            }
            AppMethodBeat.m2505o(28314);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44118fc c44118fc = (C44118fc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c44118fc.OpCode = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28314);
                    return 0;
                case 2:
                    c44118fc.fKh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28314);
                    return 0;
                case 3:
                    c44118fc.vHa = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28314);
                    return 0;
                case 4:
                    c44118fc.vHb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28314);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C30183fh c30183fh = new C30183fh();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c30183fh.populateBuilderWithField(c6086a3, c30183fh, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44118fc.vHc = c30183fh;
                    }
                    AppMethodBeat.m2505o(28314);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C44117fb c44117fb = new C44117fb();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c44117fb.populateBuilderWithField(c6086a3, c44117fb, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44118fc.vHd = c44117fb;
                    }
                    AppMethodBeat.m2505o(28314);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28314);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28314);
            return -1;
        }
    }
}
