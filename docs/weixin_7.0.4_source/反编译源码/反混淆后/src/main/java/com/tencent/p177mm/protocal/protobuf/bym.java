package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.view.C31128d;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bym */
public final class bym extends C1331a {
    public int guN;
    public String guO;
    public String guP;
    public String guQ;
    public String guW;
    public String guX;
    public String jBB;
    public String jCH;
    public int vEE;
    public String vXm;
    public String vXn;
    public String wBS;
    public int wBT;
    public String wBU;
    public String wBV;
    public String wBW;
    public int wBX;
    public int wBY;
    public ccl wBZ;
    public C7285uy wCa;
    public int wXI;
    public SKBuiltinBuffer_t wXJ;
    public int wXK;
    public String wlF;
    public String wsM;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28642);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wXJ == null) {
                c6092b = new C6092b("Not all required fields were included: ImgBuffer");
                AppMethodBeat.m2505o(28642);
                throw c6092b;
            }
            if (this.jBB != null) {
                c6093a.mo13475e(1, this.jBB);
            }
            if (this.jCH != null) {
                c6093a.mo13475e(2, this.jCH);
            }
            if (this.guO != null) {
                c6093a.mo13475e(3, this.guO);
            }
            if (this.guP != null) {
                c6093a.mo13475e(4, this.guP);
            }
            if (this.guQ != null) {
                c6093a.mo13475e(5, this.guQ);
            }
            if (this.wBS != null) {
                c6093a.mo13475e(6, this.wBS);
            }
            c6093a.mo13480iz(7, this.guN);
            c6093a.mo13480iz(8, this.vEE);
            c6093a.mo13480iz(9, this.wXI);
            if (this.wXJ != null) {
                c6093a.mo13479iy(10, this.wXJ.computeSize());
                this.wXJ.writeFields(c6093a);
            }
            c6093a.mo13480iz(11, this.wXK);
            if (this.wBV != null) {
                c6093a.mo13475e(12, this.wBV);
            }
            if (this.wBW != null) {
                c6093a.mo13475e(13, this.wBW);
            }
            c6093a.mo13480iz(14, this.wBX);
            c6093a.mo13480iz(15, this.wBT);
            if (this.wBU != null) {
                c6093a.mo13475e(16, this.wBU);
            }
            if (this.wsM != null) {
                c6093a.mo13475e(17, this.wsM);
            }
            c6093a.mo13480iz(21, this.wBY);
            if (this.wBZ != null) {
                c6093a.mo13479iy(22, this.wBZ.computeSize());
                this.wBZ.writeFields(c6093a);
            }
            if (this.guW != null) {
                c6093a.mo13475e(23, this.guW);
            }
            if (this.vXm != null) {
                c6093a.mo13475e(24, this.vXm);
            }
            if (this.vXn != null) {
                c6093a.mo13475e(25, this.vXn);
            }
            if (this.guX != null) {
                c6093a.mo13475e(26, this.guX);
            }
            if (this.wCa != null) {
                c6093a.mo13479iy(27, this.wCa.computeSize());
                this.wCa.writeFields(c6093a);
            }
            if (this.wlF != null) {
                c6093a.mo13475e(28, this.wlF);
            }
            AppMethodBeat.m2505o(28642);
            return 0;
        } else if (i == 1) {
            if (this.jBB != null) {
                f = C6091a.m9575f(1, this.jBB) + 0;
            } else {
                f = 0;
            }
            if (this.jCH != null) {
                f += C6091a.m9575f(2, this.jCH);
            }
            if (this.guO != null) {
                f += C6091a.m9575f(3, this.guO);
            }
            if (this.guP != null) {
                f += C6091a.m9575f(4, this.guP);
            }
            if (this.guQ != null) {
                f += C6091a.m9575f(5, this.guQ);
            }
            if (this.wBS != null) {
                f += C6091a.m9575f(6, this.wBS);
            }
            f = ((f + C6091a.m9572bs(7, this.guN)) + C6091a.m9572bs(8, this.vEE)) + C6091a.m9572bs(9, this.wXI);
            if (this.wXJ != null) {
                f += C6087a.m9557ix(10, this.wXJ.computeSize());
            }
            f += C6091a.m9572bs(11, this.wXK);
            if (this.wBV != null) {
                f += C6091a.m9575f(12, this.wBV);
            }
            if (this.wBW != null) {
                f += C6091a.m9575f(13, this.wBW);
            }
            f = (f + C6091a.m9572bs(14, this.wBX)) + C6091a.m9572bs(15, this.wBT);
            if (this.wBU != null) {
                f += C6091a.m9575f(16, this.wBU);
            }
            if (this.wsM != null) {
                f += C6091a.m9575f(17, this.wsM);
            }
            f += C6091a.m9572bs(21, this.wBY);
            if (this.wBZ != null) {
                f += C6087a.m9557ix(22, this.wBZ.computeSize());
            }
            if (this.guW != null) {
                f += C6091a.m9575f(23, this.guW);
            }
            if (this.vXm != null) {
                f += C6091a.m9575f(24, this.vXm);
            }
            if (this.vXn != null) {
                f += C6091a.m9575f(25, this.vXn);
            }
            if (this.guX != null) {
                f += C6091a.m9575f(26, this.guX);
            }
            if (this.wCa != null) {
                f += C6087a.m9557ix(27, this.wCa.computeSize());
            }
            if (this.wlF != null) {
                f += C6091a.m9575f(28, this.wlF);
            }
            AppMethodBeat.m2505o(28642);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.wXJ == null) {
                c6092b = new C6092b("Not all required fields were included: ImgBuffer");
                AppMethodBeat.m2505o(28642);
                throw c6092b;
            }
            AppMethodBeat.m2505o(28642);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bym bym = (bym) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    bym.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28642);
                    return 0;
                case 2:
                    bym.jCH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28642);
                    return 0;
                case 3:
                    bym.guO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28642);
                    return 0;
                case 4:
                    bym.guP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28642);
                    return 0;
                case 5:
                    bym.guQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28642);
                    return 0;
                case 6:
                    bym.wBS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28642);
                    return 0;
                case 7:
                    bym.guN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28642);
                    return 0;
                case 8:
                    bym.vEE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28642);
                    return 0;
                case 9:
                    bym.wXI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28642);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bym.wXJ = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(28642);
                    return 0;
                case 11:
                    bym.wXK = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28642);
                    return 0;
                case 12:
                    bym.wBV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28642);
                    return 0;
                case 13:
                    bym.wBW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28642);
                    return 0;
                case 14:
                    bym.wBX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28642);
                    return 0;
                case 15:
                    bym.wBT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28642);
                    return 0;
                case 16:
                    bym.wBU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28642);
                    return 0;
                case 17:
                    bym.wsM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28642);
                    return 0;
                case 21:
                    bym.wBY = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28642);
                    return 0;
                case 22:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ccl ccl = new ccl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ccl.populateBuilderWithField(c6086a3, ccl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bym.wBZ = ccl;
                    }
                    AppMethodBeat.m2505o(28642);
                    return 0;
                case 23:
                    bym.guW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28642);
                    return 0;
                case 24:
                    bym.vXm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28642);
                    return 0;
                case 25:
                    bym.vXn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28642);
                    return 0;
                case 26:
                    bym.guX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28642);
                    return 0;
                case 27:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7285uy c7285uy = new C7285uy();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7285uy.populateBuilderWithField(c6086a3, c7285uy, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bym.wCa = c7285uy;
                    }
                    AppMethodBeat.m2505o(28642);
                    return 0;
                case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    bym.wlF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28642);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28642);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28642);
            return -1;
        }
    }
}
