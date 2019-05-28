package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bkv */
public final class bkv extends C1331a {
    public civ wNQ;
    public int wpw;
    public String wpx;
    public String wpy;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28572);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.wpw);
            if (this.wpx != null) {
                c6093a.mo13475e(2, this.wpx);
            }
            if (this.wpy != null) {
                c6093a.mo13475e(3, this.wpy);
            }
            if (this.wNQ != null) {
                c6093a.mo13479iy(4, this.wNQ.computeSize());
                this.wNQ.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(28572);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.wpw) + 0;
            if (this.wpx != null) {
                bs += C6091a.m9575f(2, this.wpx);
            }
            if (this.wpy != null) {
                bs += C6091a.m9575f(3, this.wpy);
            }
            if (this.wNQ != null) {
                bs += C6087a.m9557ix(4, this.wNQ.computeSize());
            }
            AppMethodBeat.m2505o(28572);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28572);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bkv bkv = (bkv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bkv.wpw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28572);
                    return 0;
                case 2:
                    bkv.wpx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28572);
                    return 0;
                case 3:
                    bkv.wpy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28572);
                    return 0;
                case 4:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        civ civ = new civ();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = civ.populateBuilderWithField(c6086a3, civ, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bkv.wNQ = civ;
                    }
                    AppMethodBeat.m2505o(28572);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28572);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28572);
            return -1;
        }
    }
}
