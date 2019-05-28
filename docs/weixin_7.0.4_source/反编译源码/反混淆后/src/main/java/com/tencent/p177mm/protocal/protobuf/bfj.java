package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bfj */
public final class bfj extends C1331a {
    public C1332b vKc;
    public int wJh;
    public String wJi;
    public SKBuiltinBuffer_t wJj;
    public int wJk;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28562);
        C6092b c6092b;
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wJj == null) {
                c6092b = new C6092b("Not all required fields were included: ClientKey");
                AppMethodBeat.m2505o(28562);
                throw c6092b;
            }
            c6093a.mo13480iz(1, this.wJh);
            if (this.vKc != null) {
                c6093a.mo13473c(2, this.vKc);
            }
            if (this.wJi != null) {
                c6093a.mo13475e(3, this.wJi);
            }
            if (this.wJj != null) {
                c6093a.mo13479iy(4, this.wJj.computeSize());
                this.wJj.writeFields(c6093a);
            }
            c6093a.mo13480iz(5, this.wJk);
            AppMethodBeat.m2505o(28562);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.wJh) + 0;
            if (this.vKc != null) {
                bs += C6091a.m9571b(2, this.vKc);
            }
            if (this.wJi != null) {
                bs += C6091a.m9575f(3, this.wJi);
            }
            if (this.wJj != null) {
                bs += C6087a.m9557ix(4, this.wJj.computeSize());
            }
            bs += C6091a.m9572bs(5, this.wJk);
            AppMethodBeat.m2505o(28562);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.wJj == null) {
                c6092b = new C6092b("Not all required fields were included: ClientKey");
                AppMethodBeat.m2505o(28562);
                throw c6092b;
            }
            AppMethodBeat.m2505o(28562);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bfj bfj = (bfj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bfj.wJh = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28562);
                    return 0;
                case 2:
                    bfj.vKc = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(28562);
                    return 0;
                case 3:
                    bfj.wJi = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28562);
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
                        bfj.wJj = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(28562);
                    return 0;
                case 5:
                    bfj.wJk = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28562);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28562);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28562);
            return -1;
        }
    }
}
