package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bfx */
public final class bfx extends bsr {
    public int cHF;
    public int cME;
    public String pbn;
    public String tuk;
    public String vKZ;
    public String vLa;
    public boolean wJJ;
    public String wJK;
    public String wJL;
    public int wJM;
    public String wJN;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48905);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.vKZ != null) {
                c6093a.mo13475e(2, this.vKZ);
            }
            if (this.vLa != null) {
                c6093a.mo13475e(3, this.vLa);
            }
            if (this.wJK != null) {
                c6093a.mo13475e(4, this.wJK);
            }
            if (this.wJL != null) {
                c6093a.mo13475e(5, this.wJL);
            }
            if (this.tuk != null) {
                c6093a.mo13475e(6, this.tuk);
            }
            if (this.pbn != null) {
                c6093a.mo13475e(7, this.pbn);
            }
            c6093a.mo13480iz(8, this.cHF);
            c6093a.mo13480iz(9, this.wJM);
            c6093a.mo13471aO(10, this.wJJ);
            c6093a.mo13480iz(11, this.cME);
            if (this.wJN != null) {
                c6093a.mo13475e(12, this.wJN);
            }
            AppMethodBeat.m2505o(48905);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vKZ != null) {
                ix += C6091a.m9575f(2, this.vKZ);
            }
            if (this.vLa != null) {
                ix += C6091a.m9575f(3, this.vLa);
            }
            if (this.wJK != null) {
                ix += C6091a.m9575f(4, this.wJK);
            }
            if (this.wJL != null) {
                ix += C6091a.m9575f(5, this.wJL);
            }
            if (this.tuk != null) {
                ix += C6091a.m9575f(6, this.tuk);
            }
            if (this.pbn != null) {
                ix += C6091a.m9575f(7, this.pbn);
            }
            ix = (((ix + C6091a.m9572bs(8, this.cHF)) + C6091a.m9572bs(9, this.wJM)) + (C6091a.m9576fv(10) + 1)) + C6091a.m9572bs(11, this.cME);
            if (this.wJN != null) {
                ix += C6091a.m9575f(12, this.wJN);
            }
            AppMethodBeat.m2505o(48905);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48905);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bfx bfx = (bfx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C7267hl c7267hl = new C7267hl();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bfx.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(48905);
                    return 0;
                case 2:
                    bfx.vKZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48905);
                    return 0;
                case 3:
                    bfx.vLa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48905);
                    return 0;
                case 4:
                    bfx.wJK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48905);
                    return 0;
                case 5:
                    bfx.wJL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48905);
                    return 0;
                case 6:
                    bfx.tuk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48905);
                    return 0;
                case 7:
                    bfx.pbn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48905);
                    return 0;
                case 8:
                    bfx.cHF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48905);
                    return 0;
                case 9:
                    bfx.wJM = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48905);
                    return 0;
                case 10:
                    bfx.wJJ = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(48905);
                    return 0;
                case 11:
                    bfx.cME = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48905);
                    return 0;
                case 12:
                    bfx.wJN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48905);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48905);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48905);
            return -1;
        }
    }
}
