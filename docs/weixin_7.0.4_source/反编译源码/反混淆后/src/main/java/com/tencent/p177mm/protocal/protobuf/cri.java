package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cri */
public final class cri extends C1331a {
    public cre xoZ;
    public cqu xpa;
    public String xpb;
    public String xpc;
    public String xpd;
    public int xpe;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(102420);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xoZ != null) {
                c6093a.mo13479iy(1, this.xoZ.computeSize());
                this.xoZ.writeFields(c6093a);
            }
            if (this.xpa != null) {
                c6093a.mo13479iy(2, this.xpa.computeSize());
                this.xpa.writeFields(c6093a);
            }
            if (this.xpb != null) {
                c6093a.mo13475e(3, this.xpb);
            }
            if (this.xpc != null) {
                c6093a.mo13475e(4, this.xpc);
            }
            if (this.xpd != null) {
                c6093a.mo13475e(5, this.xpd);
            }
            c6093a.mo13480iz(6, this.xpe);
            AppMethodBeat.m2505o(102420);
            return 0;
        } else if (i == 1) {
            if (this.xoZ != null) {
                ix = C6087a.m9557ix(1, this.xoZ.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.xpa != null) {
                ix += C6087a.m9557ix(2, this.xpa.computeSize());
            }
            if (this.xpb != null) {
                ix += C6091a.m9575f(3, this.xpb);
            }
            if (this.xpc != null) {
                ix += C6091a.m9575f(4, this.xpc);
            }
            if (this.xpd != null) {
                ix += C6091a.m9575f(5, this.xpd);
            }
            int bs = ix + C6091a.m9572bs(6, this.xpe);
            AppMethodBeat.m2505o(102420);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(102420);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cri cri = (cri) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cre cre = new cre();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cre.populateBuilderWithField(c6086a3, cre, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cri.xoZ = cre;
                    }
                    AppMethodBeat.m2505o(102420);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cqu cqu = new cqu();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cqu.populateBuilderWithField(c6086a3, cqu, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cri.xpa = cqu;
                    }
                    AppMethodBeat.m2505o(102420);
                    return 0;
                case 3:
                    cri.xpb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(102420);
                    return 0;
                case 4:
                    cri.xpc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(102420);
                    return 0;
                case 5:
                    cri.xpd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(102420);
                    return 0;
                case 6:
                    cri.xpe = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(102420);
                    return 0;
                default:
                    AppMethodBeat.m2505o(102420);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(102420);
            return -1;
        }
    }
}
