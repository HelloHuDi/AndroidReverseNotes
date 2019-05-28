package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.azd */
public final class azd extends C1331a {
    public String guM;
    public int guN;
    public String guO;
    public String guP;
    public String guQ;
    public int guR;
    public String guS;
    public int guT;
    public int guU;
    public String guV;
    public String guW;
    public String guX;
    public String vHl;
    public String vXm;
    public String vXn;
    public ccl wBZ;
    public String wCW;
    public C23469zs wCX;
    public C7285uy wCa;
    public String wlF;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(73739);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vHl != null) {
                c6093a.mo13475e(1, this.vHl);
            }
            if (this.wCW != null) {
                c6093a.mo13475e(2, this.wCW);
            }
            if (this.guM != null) {
                c6093a.mo13475e(3, this.guM);
            }
            c6093a.mo13480iz(4, this.guN);
            if (this.guO != null) {
                c6093a.mo13475e(5, this.guO);
            }
            if (this.guP != null) {
                c6093a.mo13475e(6, this.guP);
            }
            if (this.guQ != null) {
                c6093a.mo13475e(7, this.guQ);
            }
            c6093a.mo13480iz(8, this.guR);
            if (this.guS != null) {
                c6093a.mo13475e(9, this.guS);
            }
            if (this.wCX != null) {
                c6093a.mo13479iy(10, this.wCX.computeSize());
                this.wCX.writeFields(c6093a);
            }
            c6093a.mo13480iz(11, this.guT);
            c6093a.mo13480iz(12, this.guU);
            if (this.guV != null) {
                c6093a.mo13475e(13, this.guV);
            }
            if (this.wBZ != null) {
                c6093a.mo13479iy(14, this.wBZ.computeSize());
                this.wBZ.writeFields(c6093a);
            }
            if (this.guW != null) {
                c6093a.mo13475e(15, this.guW);
            }
            if (this.guX != null) {
                c6093a.mo13475e(16, this.guX);
            }
            if (this.wCa != null) {
                c6093a.mo13479iy(17, this.wCa.computeSize());
                this.wCa.writeFields(c6093a);
            }
            if (this.vXm != null) {
                c6093a.mo13475e(20, this.vXm);
            }
            if (this.vXn != null) {
                c6093a.mo13475e(21, this.vXn);
            }
            if (this.wlF != null) {
                c6093a.mo13475e(22, this.wlF);
            }
            AppMethodBeat.m2505o(73739);
            return 0;
        } else if (i == 1) {
            if (this.vHl != null) {
                f = C6091a.m9575f(1, this.vHl) + 0;
            } else {
                f = 0;
            }
            if (this.wCW != null) {
                f += C6091a.m9575f(2, this.wCW);
            }
            if (this.guM != null) {
                f += C6091a.m9575f(3, this.guM);
            }
            f += C6091a.m9572bs(4, this.guN);
            if (this.guO != null) {
                f += C6091a.m9575f(5, this.guO);
            }
            if (this.guP != null) {
                f += C6091a.m9575f(6, this.guP);
            }
            if (this.guQ != null) {
                f += C6091a.m9575f(7, this.guQ);
            }
            f += C6091a.m9572bs(8, this.guR);
            if (this.guS != null) {
                f += C6091a.m9575f(9, this.guS);
            }
            if (this.wCX != null) {
                f += C6087a.m9557ix(10, this.wCX.computeSize());
            }
            f = (f + C6091a.m9572bs(11, this.guT)) + C6091a.m9572bs(12, this.guU);
            if (this.guV != null) {
                f += C6091a.m9575f(13, this.guV);
            }
            if (this.wBZ != null) {
                f += C6087a.m9557ix(14, this.wBZ.computeSize());
            }
            if (this.guW != null) {
                f += C6091a.m9575f(15, this.guW);
            }
            if (this.guX != null) {
                f += C6091a.m9575f(16, this.guX);
            }
            if (this.wCa != null) {
                f += C6087a.m9557ix(17, this.wCa.computeSize());
            }
            if (this.vXm != null) {
                f += C6091a.m9575f(20, this.vXm);
            }
            if (this.vXn != null) {
                f += C6091a.m9575f(21, this.vXn);
            }
            if (this.wlF != null) {
                f += C6091a.m9575f(22, this.wlF);
            }
            AppMethodBeat.m2505o(73739);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(73739);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            azd azd = (azd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    azd.vHl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73739);
                    return 0;
                case 2:
                    azd.wCW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73739);
                    return 0;
                case 3:
                    azd.guM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73739);
                    return 0;
                case 4:
                    azd.guN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73739);
                    return 0;
                case 5:
                    azd.guO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73739);
                    return 0;
                case 6:
                    azd.guP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73739);
                    return 0;
                case 7:
                    azd.guQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73739);
                    return 0;
                case 8:
                    azd.guR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73739);
                    return 0;
                case 9:
                    azd.guS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73739);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C23469zs c23469zs = new C23469zs();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23469zs.populateBuilderWithField(c6086a3, c23469zs, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        azd.wCX = c23469zs;
                    }
                    AppMethodBeat.m2505o(73739);
                    return 0;
                case 11:
                    azd.guT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73739);
                    return 0;
                case 12:
                    azd.guU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73739);
                    return 0;
                case 13:
                    azd.guV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73739);
                    return 0;
                case 14:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ccl ccl = new ccl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ccl.populateBuilderWithField(c6086a3, ccl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        azd.wBZ = ccl;
                    }
                    AppMethodBeat.m2505o(73739);
                    return 0;
                case 15:
                    azd.guW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73739);
                    return 0;
                case 16:
                    azd.guX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73739);
                    return 0;
                case 17:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7285uy c7285uy = new C7285uy();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7285uy.populateBuilderWithField(c6086a3, c7285uy, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        azd.wCa = c7285uy;
                    }
                    AppMethodBeat.m2505o(73739);
                    return 0;
                case 20:
                    azd.vXm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73739);
                    return 0;
                case 21:
                    azd.vXn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73739);
                    return 0;
                case 22:
                    azd.wlF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73739);
                    return 0;
                default:
                    AppMethodBeat.m2505o(73739);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(73739);
            return -1;
        }
    }
}
