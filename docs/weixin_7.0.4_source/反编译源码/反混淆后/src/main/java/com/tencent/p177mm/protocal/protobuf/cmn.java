package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cmn */
public final class cmn extends C1331a {
    public String Desc;
    /* renamed from: ID */
    public int f4417ID;
    public SKBuiltinBuffer_t xkq;
    public SKBuiltinBuffer_t xkr;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28695);
        C6092b c6092b;
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xkq == null) {
                c6092b = new C6092b("Not all required fields were included: Icon");
                AppMethodBeat.m2505o(28695);
                throw c6092b;
            } else if (this.xkr == null) {
                c6092b = new C6092b("Not all required fields were included: HDIcon");
                AppMethodBeat.m2505o(28695);
                throw c6092b;
            } else {
                c6093a.mo13480iz(1, this.f4417ID);
                if (this.Desc != null) {
                    c6093a.mo13475e(2, this.Desc);
                }
                if (this.xkq != null) {
                    c6093a.mo13479iy(3, this.xkq.computeSize());
                    this.xkq.writeFields(c6093a);
                }
                if (this.xkr != null) {
                    c6093a.mo13479iy(4, this.xkr.computeSize());
                    this.xkr.writeFields(c6093a);
                }
                AppMethodBeat.m2505o(28695);
                return 0;
            }
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.f4417ID) + 0;
            if (this.Desc != null) {
                bs += C6091a.m9575f(2, this.Desc);
            }
            if (this.xkq != null) {
                bs += C6087a.m9557ix(3, this.xkq.computeSize());
            }
            if (this.xkr != null) {
                bs += C6087a.m9557ix(4, this.xkr.computeSize());
            }
            AppMethodBeat.m2505o(28695);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.xkq == null) {
                c6092b = new C6092b("Not all required fields were included: Icon");
                AppMethodBeat.m2505o(28695);
                throw c6092b;
            } else if (this.xkr == null) {
                c6092b = new C6092b("Not all required fields were included: HDIcon");
                AppMethodBeat.m2505o(28695);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(28695);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cmn cmn = (cmn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    cmn.f4417ID = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28695);
                    return 0;
                case 2:
                    cmn.Desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28695);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cmn.xkq = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(28695);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cmn.xkr = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(28695);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28695);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28695);
            return -1;
        }
    }
}
