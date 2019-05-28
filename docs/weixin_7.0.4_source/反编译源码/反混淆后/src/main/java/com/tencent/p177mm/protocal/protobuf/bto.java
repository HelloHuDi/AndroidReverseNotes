package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bto */
public final class bto extends C1331a {
    public btr vCP;
    public String vJS;
    public int wVx;
    public int wVy;
    public cgv wbo;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48959);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.wVx);
            c6093a.mo13480iz(2, this.wVy);
            if (this.vCP != null) {
                c6093a.mo13479iy(3, this.vCP.computeSize());
                this.vCP.writeFields(c6093a);
            }
            if (this.wbo != null) {
                c6093a.mo13479iy(4, this.wbo.computeSize());
                this.wbo.writeFields(c6093a);
            }
            if (this.vJS != null) {
                c6093a.mo13475e(5, this.vJS);
            }
            AppMethodBeat.m2505o(48959);
            return 0;
        } else if (i == 1) {
            bs = (C6091a.m9572bs(1, this.wVx) + 0) + C6091a.m9572bs(2, this.wVy);
            if (this.vCP != null) {
                bs += C6087a.m9557ix(3, this.vCP.computeSize());
            }
            if (this.wbo != null) {
                bs += C6087a.m9557ix(4, this.wbo.computeSize());
            }
            if (this.vJS != null) {
                bs += C6091a.m9575f(5, this.vJS);
            }
            AppMethodBeat.m2505o(48959);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48959);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bto bto = (bto) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    bto.wVx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48959);
                    return 0;
                case 2:
                    bto.wVy = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48959);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btr btr = new btr();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = btr.populateBuilderWithField(c6086a3, btr, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bto.vCP = btr;
                    }
                    AppMethodBeat.m2505o(48959);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv cgv = new cgv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(c6086a3, cgv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bto.wbo = cgv;
                    }
                    AppMethodBeat.m2505o(48959);
                    return 0;
                case 5:
                    bto.vJS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48959);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48959);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48959);
            return -1;
        }
    }
}
