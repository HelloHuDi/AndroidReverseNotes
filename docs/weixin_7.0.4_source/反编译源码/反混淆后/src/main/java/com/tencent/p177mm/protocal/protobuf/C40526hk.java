package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.hk */
public final class C40526hk extends C1331a {
    public int dataType;
    public SKBuiltinBuffer_t vKa;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(2530);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.dataType);
            if (this.vKa != null) {
                c6093a.mo13479iy(2, this.vKa.computeSize());
                this.vKa.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(2530);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.dataType) + 0;
            if (this.vKa != null) {
                bs += C6087a.m9557ix(2, this.vKa.computeSize());
            }
            AppMethodBeat.m2505o(2530);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(2530);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C40526hk c40526hk = (C40526hk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c40526hk.dataType = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(2530);
                    return 0;
                case 2:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40526hk.vKa = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(2530);
                    return 0;
                default:
                    AppMethodBeat.m2505o(2530);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(2530);
            return -1;
        }
    }
}
