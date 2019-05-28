package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.csd */
public final class csd extends C1331a {
    public String vLX;
    public String vLY;
    public SKBuiltinBuffer_t vMb;
    public String xpA;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(58939);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vMb == null) {
                c6092b = new C6092b("Not all required fields were included: KSid");
                AppMethodBeat.m2505o(58939);
                throw c6092b;
            }
            if (this.vLX != null) {
                c6093a.mo13475e(1, this.vLX);
            }
            if (this.vLY != null) {
                c6093a.mo13475e(2, this.vLY);
            }
            if (this.xpA != null) {
                c6093a.mo13475e(3, this.xpA);
            }
            if (this.vMb != null) {
                c6093a.mo13479iy(4, this.vMb.computeSize());
                this.vMb.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(58939);
            return 0;
        } else if (i == 1) {
            if (this.vLX != null) {
                f = C6091a.m9575f(1, this.vLX) + 0;
            } else {
                f = 0;
            }
            if (this.vLY != null) {
                f += C6091a.m9575f(2, this.vLY);
            }
            if (this.xpA != null) {
                f += C6091a.m9575f(3, this.xpA);
            }
            if (this.vMb != null) {
                f += C6087a.m9557ix(4, this.vMb.computeSize());
            }
            AppMethodBeat.m2505o(58939);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.vMb == null) {
                c6092b = new C6092b("Not all required fields were included: KSid");
                AppMethodBeat.m2505o(58939);
                throw c6092b;
            }
            AppMethodBeat.m2505o(58939);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            csd csd = (csd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    csd.vLX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58939);
                    return 0;
                case 2:
                    csd.vLY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58939);
                    return 0;
                case 3:
                    csd.xpA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58939);
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
                        csd.vMb = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(58939);
                    return 0;
                default:
                    AppMethodBeat.m2505o(58939);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(58939);
            return -1;
        }
    }
}
