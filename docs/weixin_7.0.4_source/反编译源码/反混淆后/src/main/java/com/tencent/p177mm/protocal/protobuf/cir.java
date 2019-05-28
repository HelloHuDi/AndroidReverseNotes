package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cir */
public final class cir extends C1331a {
    public int Scene;
    public SKBuiltinBuffer_t wlw;
    public int xhA;
    public String xhB;
    public String xhC;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28674);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.xhA);
            if (this.xhB != null) {
                c6093a.mo13475e(2, this.xhB);
            }
            if (this.xhC != null) {
                c6093a.mo13475e(3, this.xhC);
            }
            c6093a.mo13480iz(4, this.Scene);
            if (this.wlw != null) {
                c6093a.mo13479iy(5, this.wlw.computeSize());
                this.wlw.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(28674);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.xhA) + 0;
            if (this.xhB != null) {
                bs += C6091a.m9575f(2, this.xhB);
            }
            if (this.xhC != null) {
                bs += C6091a.m9575f(3, this.xhC);
            }
            bs += C6091a.m9572bs(4, this.Scene);
            if (this.wlw != null) {
                bs += C6087a.m9557ix(5, this.wlw.computeSize());
            }
            AppMethodBeat.m2505o(28674);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28674);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cir cir = (cir) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cir.xhA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28674);
                    return 0;
                case 2:
                    cir.xhB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28674);
                    return 0;
                case 3:
                    cir.xhC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28674);
                    return 0;
                case 4:
                    cir.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28674);
                    return 0;
                case 5:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cir.wlw = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(28674);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28674);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28674);
            return -1;
        }
    }
}
