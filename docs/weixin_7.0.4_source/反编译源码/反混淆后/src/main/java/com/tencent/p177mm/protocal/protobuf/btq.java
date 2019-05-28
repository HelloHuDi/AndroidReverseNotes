package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.btq */
public final class btq extends C1331a {
    public String vJS;
    public float wVA;
    public long wVB;
    public bif wVz;
    public cgv wbo;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48960);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vJS != null) {
                c6093a.mo13475e(1, this.vJS);
            }
            if (this.wbo != null) {
                c6093a.mo13479iy(2, this.wbo.computeSize());
                this.wbo.writeFields(c6093a);
            }
            if (this.wVz != null) {
                c6093a.mo13479iy(3, this.wVz.computeSize());
                this.wVz.writeFields(c6093a);
            }
            c6093a.mo13481r(4, this.wVA);
            c6093a.mo13472ai(5, this.wVB);
            AppMethodBeat.m2505o(48960);
            return 0;
        } else if (i == 1) {
            if (this.vJS != null) {
                f = C6091a.m9575f(1, this.vJS) + 0;
            } else {
                f = 0;
            }
            if (this.wbo != null) {
                f += C6087a.m9557ix(2, this.wbo.computeSize());
            }
            if (this.wVz != null) {
                f += C6087a.m9557ix(3, this.wVz.computeSize());
            }
            int fv = (f + (C6091a.m9576fv(4) + 4)) + C6091a.m9578o(5, this.wVB);
            AppMethodBeat.m2505o(48960);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48960);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            btq btq = (btq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    btq.vJS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48960);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv cgv = new cgv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(c6086a3, cgv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        btq.wbo = cgv;
                    }
                    AppMethodBeat.m2505o(48960);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bif bif = new bif();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bif.populateBuilderWithField(c6086a3, bif, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        btq.wVz = bif;
                    }
                    AppMethodBeat.m2505o(48960);
                    return 0;
                case 4:
                    btq.wVA = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(48960);
                    return 0;
                case 5:
                    btq.wVB = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(48960);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48960);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48960);
            return -1;
        }
    }
}
