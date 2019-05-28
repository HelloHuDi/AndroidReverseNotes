package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.awr */
public final class awr extends C1331a {
    public String cEh;
    public String nZb;
    public String nZc;
    public String title;
    public int ttd;
    public boolean wAV;
    public bqs wAW;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56846);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.ttd);
            c6093a.mo13471aO(2, this.wAV);
            if (this.cEh != null) {
                c6093a.mo13475e(3, this.cEh);
            }
            if (this.nZb != null) {
                c6093a.mo13475e(4, this.nZb);
            }
            if (this.nZc != null) {
                c6093a.mo13475e(5, this.nZc);
            }
            if (this.wAW != null) {
                c6093a.mo13479iy(6, this.wAW.computeSize());
                this.wAW.writeFields(c6093a);
            }
            if (this.title != null) {
                c6093a.mo13475e(7, this.title);
            }
            AppMethodBeat.m2505o(56846);
            return 0;
        } else if (i == 1) {
            bs = (C6091a.m9572bs(1, this.ttd) + 0) + (C6091a.m9576fv(2) + 1);
            if (this.cEh != null) {
                bs += C6091a.m9575f(3, this.cEh);
            }
            if (this.nZb != null) {
                bs += C6091a.m9575f(4, this.nZb);
            }
            if (this.nZc != null) {
                bs += C6091a.m9575f(5, this.nZc);
            }
            if (this.wAW != null) {
                bs += C6087a.m9557ix(6, this.wAW.computeSize());
            }
            if (this.title != null) {
                bs += C6091a.m9575f(7, this.title);
            }
            AppMethodBeat.m2505o(56846);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56846);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            awr awr = (awr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    awr.ttd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56846);
                    return 0;
                case 2:
                    awr.wAV = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(56846);
                    return 0;
                case 3:
                    awr.cEh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56846);
                    return 0;
                case 4:
                    awr.nZb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56846);
                    return 0;
                case 5:
                    awr.nZc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56846);
                    return 0;
                case 6:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bqs bqs = new bqs();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bqs.populateBuilderWithField(c6086a3, bqs, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        awr.wAW = bqs;
                    }
                    AppMethodBeat.m2505o(56846);
                    return 0;
                case 7:
                    awr.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56846);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56846);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56846);
            return -1;
        }
    }
}
