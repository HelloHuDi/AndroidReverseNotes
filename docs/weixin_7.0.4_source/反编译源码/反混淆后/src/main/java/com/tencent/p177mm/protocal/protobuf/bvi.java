package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bvi */
public final class bvi extends C1331a {
    public int Scene;
    public String luQ;
    public axy wDI;
    public String wWv;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(124357);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wWv != null) {
                c6093a.mo13475e(1, this.wWv);
            }
            c6093a.mo13480iz(2, this.Scene);
            if (this.luQ != null) {
                c6093a.mo13475e(3, this.luQ);
            }
            if (this.wDI != null) {
                c6093a.mo13479iy(4, this.wDI.computeSize());
                this.wDI.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(124357);
            return 0;
        } else if (i == 1) {
            if (this.wWv != null) {
                f = C6091a.m9575f(1, this.wWv) + 0;
            } else {
                f = 0;
            }
            f += C6091a.m9572bs(2, this.Scene);
            if (this.luQ != null) {
                f += C6091a.m9575f(3, this.luQ);
            }
            if (this.wDI != null) {
                f += C6087a.m9557ix(4, this.wDI.computeSize());
            }
            AppMethodBeat.m2505o(124357);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(124357);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bvi bvi = (bvi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bvi.wWv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124357);
                    return 0;
                case 2:
                    bvi.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124357);
                    return 0;
                case 3:
                    bvi.luQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124357);
                    return 0;
                case 4:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        axy axy = new axy();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = axy.populateBuilderWithField(c6086a3, axy, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bvi.wDI = axy;
                    }
                    AppMethodBeat.m2505o(124357);
                    return 0;
                default:
                    AppMethodBeat.m2505o(124357);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(124357);
            return -1;
        }
    }
}
