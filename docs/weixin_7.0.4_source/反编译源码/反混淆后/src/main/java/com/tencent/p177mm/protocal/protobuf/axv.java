package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.axv */
public class axv extends C1331a {
    public int guN;
    public String guO;
    public String guP;
    public String guQ;
    public String guS;
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
    public String wlF;
    public String wsM;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(55526);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
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
            c6093a.mo13480iz(9, this.wBT);
            if (this.wBU != null) {
                c6093a.mo13475e(10, this.wBU);
            }
            if (this.wsM != null) {
                c6093a.mo13475e(11, this.wsM);
            }
            if (this.guS != null) {
                c6093a.mo13475e(12, this.guS);
            }
            if (this.wBV != null) {
                c6093a.mo13475e(13, this.wBV);
            }
            if (this.wBW != null) {
                c6093a.mo13475e(14, this.wBW);
            }
            c6093a.mo13480iz(15, this.wBX);
            c6093a.mo13480iz(19, this.wBY);
            if (this.wBZ != null) {
                c6093a.mo13479iy(20, this.wBZ.computeSize());
                this.wBZ.writeFields(c6093a);
            }
            if (this.guW != null) {
                c6093a.mo13475e(21, this.guW);
            }
            if (this.vXm != null) {
                c6093a.mo13475e(22, this.vXm);
            }
            if (this.vXn != null) {
                c6093a.mo13475e(23, this.vXn);
            }
            if (this.guX != null) {
                c6093a.mo13475e(24, this.guX);
            }
            if (this.wCa != null) {
                c6093a.mo13479iy(25, this.wCa.computeSize());
                this.wCa.writeFields(c6093a);
            }
            if (this.wlF != null) {
                c6093a.mo13475e(26, this.wlF);
            }
            AppMethodBeat.m2505o(55526);
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
            f = ((f + C6091a.m9572bs(7, this.guN)) + C6091a.m9572bs(8, this.vEE)) + C6091a.m9572bs(9, this.wBT);
            if (this.wBU != null) {
                f += C6091a.m9575f(10, this.wBU);
            }
            if (this.wsM != null) {
                f += C6091a.m9575f(11, this.wsM);
            }
            if (this.guS != null) {
                f += C6091a.m9575f(12, this.guS);
            }
            if (this.wBV != null) {
                f += C6091a.m9575f(13, this.wBV);
            }
            if (this.wBW != null) {
                f += C6091a.m9575f(14, this.wBW);
            }
            f = (f + C6091a.m9572bs(15, this.wBX)) + C6091a.m9572bs(19, this.wBY);
            if (this.wBZ != null) {
                f += C6087a.m9557ix(20, this.wBZ.computeSize());
            }
            if (this.guW != null) {
                f += C6091a.m9575f(21, this.guW);
            }
            if (this.vXm != null) {
                f += C6091a.m9575f(22, this.vXm);
            }
            if (this.vXn != null) {
                f += C6091a.m9575f(23, this.vXn);
            }
            if (this.guX != null) {
                f += C6091a.m9575f(24, this.guX);
            }
            if (this.wCa != null) {
                f += C6087a.m9557ix(25, this.wCa.computeSize());
            }
            if (this.wlF != null) {
                f += C6091a.m9575f(26, this.wlF);
            }
            AppMethodBeat.m2505o(55526);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(55526);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            axv axv = (axv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    axv.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55526);
                    return 0;
                case 2:
                    axv.jCH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55526);
                    return 0;
                case 3:
                    axv.guO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55526);
                    return 0;
                case 4:
                    axv.guP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55526);
                    return 0;
                case 5:
                    axv.guQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55526);
                    return 0;
                case 6:
                    axv.wBS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55526);
                    return 0;
                case 7:
                    axv.guN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55526);
                    return 0;
                case 8:
                    axv.vEE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55526);
                    return 0;
                case 9:
                    axv.wBT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55526);
                    return 0;
                case 10:
                    axv.wBU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55526);
                    return 0;
                case 11:
                    axv.wsM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55526);
                    return 0;
                case 12:
                    axv.guS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55526);
                    return 0;
                case 13:
                    axv.wBV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55526);
                    return 0;
                case 14:
                    axv.wBW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55526);
                    return 0;
                case 15:
                    axv.wBX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55526);
                    return 0;
                case 19:
                    axv.wBY = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55526);
                    return 0;
                case 20:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ccl ccl = new ccl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ccl.populateBuilderWithField(c6086a3, ccl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        axv.wBZ = ccl;
                    }
                    AppMethodBeat.m2505o(55526);
                    return 0;
                case 21:
                    axv.guW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55526);
                    return 0;
                case 22:
                    axv.vXm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55526);
                    return 0;
                case 23:
                    axv.vXn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55526);
                    return 0;
                case 24:
                    axv.guX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55526);
                    return 0;
                case 25:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7285uy c7285uy = new C7285uy();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7285uy.populateBuilderWithField(c6086a3, c7285uy, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        axv.wCa = c7285uy;
                    }
                    AppMethodBeat.m2505o(55526);
                    return 0;
                case 26:
                    axv.wlF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55526);
                    return 0;
                default:
                    AppMethodBeat.m2505o(55526);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(55526);
            return -1;
        }
    }
}
