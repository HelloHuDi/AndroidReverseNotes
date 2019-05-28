package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bhu */
public class bhu extends C1331a {
    public String Name;
    public String guO;
    public String guP;
    public String oRb;
    public double vNH;
    public double vNI;
    public String wKW;
    public String wKX;
    public String wKY;
    public String wKZ;
    public String wcl;
    public String wcm;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(113787);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.Name != null) {
                c6093a.mo13475e(1, this.Name);
            }
            if (this.wKW != null) {
                c6093a.mo13475e(2, this.wKW);
            }
            c6093a.mo13476f(3, this.vNH);
            c6093a.mo13476f(4, this.vNI);
            if (this.wKX != null) {
                c6093a.mo13475e(5, this.wKX);
            }
            if (this.oRb != null) {
                c6093a.mo13475e(6, this.oRb);
            }
            if (this.wKY != null) {
                c6093a.mo13475e(7, this.wKY);
            }
            if (this.guO != null) {
                c6093a.mo13475e(8, this.guO);
            }
            if (this.guP != null) {
                c6093a.mo13475e(9, this.guP);
            }
            if (this.wcl != null) {
                c6093a.mo13475e(10, this.wcl);
            }
            if (this.wcm != null) {
                c6093a.mo13475e(11, this.wcm);
            }
            if (this.wKZ != null) {
                c6093a.mo13475e(12, this.wKZ);
            }
            AppMethodBeat.m2505o(113787);
            return 0;
        } else if (i == 1) {
            if (this.Name != null) {
                f = C6091a.m9575f(1, this.Name) + 0;
            } else {
                f = 0;
            }
            if (this.wKW != null) {
                f += C6091a.m9575f(2, this.wKW);
            }
            f = (f + (C6091a.m9576fv(3) + 8)) + (C6091a.m9576fv(4) + 8);
            if (this.wKX != null) {
                f += C6091a.m9575f(5, this.wKX);
            }
            if (this.oRb != null) {
                f += C6091a.m9575f(6, this.oRb);
            }
            if (this.wKY != null) {
                f += C6091a.m9575f(7, this.wKY);
            }
            if (this.guO != null) {
                f += C6091a.m9575f(8, this.guO);
            }
            if (this.guP != null) {
                f += C6091a.m9575f(9, this.guP);
            }
            if (this.wcl != null) {
                f += C6091a.m9575f(10, this.wcl);
            }
            if (this.wcm != null) {
                f += C6091a.m9575f(11, this.wcm);
            }
            if (this.wKZ != null) {
                f += C6091a.m9575f(12, this.wKZ);
            }
            AppMethodBeat.m2505o(113787);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(113787);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bhu bhu = (bhu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bhu.Name = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(113787);
                    return 0;
                case 2:
                    bhu.wKW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(113787);
                    return 0;
                case 3:
                    bhu.vNH = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(113787);
                    return 0;
                case 4:
                    bhu.vNI = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(113787);
                    return 0;
                case 5:
                    bhu.wKX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(113787);
                    return 0;
                case 6:
                    bhu.oRb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(113787);
                    return 0;
                case 7:
                    bhu.wKY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(113787);
                    return 0;
                case 8:
                    bhu.guO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(113787);
                    return 0;
                case 9:
                    bhu.guP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(113787);
                    return 0;
                case 10:
                    bhu.wcl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(113787);
                    return 0;
                case 11:
                    bhu.wcm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(113787);
                    return 0;
                case 12:
                    bhu.wKZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(113787);
                    return 0;
                default:
                    AppMethodBeat.m2505o(113787);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(113787);
            return -1;
        }
    }
}
