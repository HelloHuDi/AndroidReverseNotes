package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cph */
public final class cph extends C1331a {
    public int luF;
    public int pXC;
    public SKBuiltinBuffer_t vJd;
    public int wat;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(5239);
        C6092b c6092b;
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vJd == null) {
                c6092b = new C6092b("Not all required fields were included: Buffer");
                AppMethodBeat.m2505o(5239);
                throw c6092b;
            }
            c6093a.mo13480iz(1, this.wat);
            c6093a.mo13480iz(2, this.luF);
            c6093a.mo13480iz(3, this.pXC);
            if (this.vJd != null) {
                c6093a.mo13479iy(4, this.vJd.computeSize());
                this.vJd.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(5239);
            return 0;
        } else if (i == 1) {
            bs = ((C6091a.m9572bs(1, this.wat) + 0) + C6091a.m9572bs(2, this.luF)) + C6091a.m9572bs(3, this.pXC);
            if (this.vJd != null) {
                bs += C6087a.m9557ix(4, this.vJd.computeSize());
            }
            AppMethodBeat.m2505o(5239);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.vJd == null) {
                c6092b = new C6092b("Not all required fields were included: Buffer");
                AppMethodBeat.m2505o(5239);
                throw c6092b;
            }
            AppMethodBeat.m2505o(5239);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cph cph = (cph) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cph.wat = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5239);
                    return 0;
                case 2:
                    cph.luF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5239);
                    return 0;
                case 3:
                    cph.pXC = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5239);
                    return 0;
                case 4:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cph.vJd = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(5239);
                    return 0;
                default:
                    AppMethodBeat.m2505o(5239);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(5239);
            return -1;
        }
    }
}
