package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.atb */
public final class atb extends C1331a {
    public int cuu;
    public String materialId;
    public String wwP;
    public atc wwQ;
    public String wwR;
    public int wwS;
    public int wwT;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56843);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wwP != null) {
                c6093a.mo13475e(1, this.wwP);
            }
            c6093a.mo13480iz(2, this.cuu);
            if (this.materialId != null) {
                c6093a.mo13475e(3, this.materialId);
            }
            if (this.wwQ != null) {
                c6093a.mo13479iy(4, this.wwQ.computeSize());
                this.wwQ.writeFields(c6093a);
            }
            if (this.wwR != null) {
                c6093a.mo13475e(5, this.wwR);
            }
            c6093a.mo13480iz(6, this.wwS);
            c6093a.mo13480iz(7, this.wwT);
            AppMethodBeat.m2505o(56843);
            return 0;
        } else if (i == 1) {
            if (this.wwP != null) {
                f = C6091a.m9575f(1, this.wwP) + 0;
            } else {
                f = 0;
            }
            f += C6091a.m9572bs(2, this.cuu);
            if (this.materialId != null) {
                f += C6091a.m9575f(3, this.materialId);
            }
            if (this.wwQ != null) {
                f += C6087a.m9557ix(4, this.wwQ.computeSize());
            }
            if (this.wwR != null) {
                f += C6091a.m9575f(5, this.wwR);
            }
            int bs = (f + C6091a.m9572bs(6, this.wwS)) + C6091a.m9572bs(7, this.wwT);
            AppMethodBeat.m2505o(56843);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56843);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            atb atb = (atb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    atb.wwP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56843);
                    return 0;
                case 2:
                    atb.cuu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56843);
                    return 0;
                case 3:
                    atb.materialId = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56843);
                    return 0;
                case 4:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        atc atc = new atc();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = atc.populateBuilderWithField(c6086a3, atc, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        atb.wwQ = atc;
                    }
                    AppMethodBeat.m2505o(56843);
                    return 0;
                case 5:
                    atb.wwR = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56843);
                    return 0;
                case 6:
                    atb.wwS = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56843);
                    return 0;
                case 7:
                    atb.wwT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56843);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56843);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56843);
            return -1;
        }
    }
}
