package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cmb */
public final class cmb extends C1331a {
    public int apptype;
    public String csB;
    public String fhH;
    public String kfM;
    public int wGS;
    public LinkedList<cmc> xjN = new LinkedList();
    public String xjO;
    public int xjP;

    public cmb() {
        AppMethodBeat.m2504i(127735);
        AppMethodBeat.m2505o(127735);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(127736);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.csB != null) {
                c6093a.mo13475e(1, this.csB);
            }
            if (this.fhH != null) {
                c6093a.mo13475e(2, this.fhH);
            }
            c6093a.mo13480iz(3, this.apptype);
            c6093a.mo13474e(4, 8, this.xjN);
            c6093a.mo13480iz(5, this.wGS);
            if (this.xjO != null) {
                c6093a.mo13475e(6, this.xjO);
            }
            if (this.kfM != null) {
                c6093a.mo13475e(7, this.kfM);
            }
            c6093a.mo13480iz(8, this.xjP);
            AppMethodBeat.m2505o(127736);
            return 0;
        } else if (i == 1) {
            if (this.csB != null) {
                f = C6091a.m9575f(1, this.csB) + 0;
            } else {
                f = 0;
            }
            if (this.fhH != null) {
                f += C6091a.m9575f(2, this.fhH);
            }
            f = ((f + C6091a.m9572bs(3, this.apptype)) + C6087a.m9552c(4, 8, this.xjN)) + C6091a.m9572bs(5, this.wGS);
            if (this.xjO != null) {
                f += C6091a.m9575f(6, this.xjO);
            }
            if (this.kfM != null) {
                f += C6091a.m9575f(7, this.kfM);
            }
            int bs = f + C6091a.m9572bs(8, this.xjP);
            AppMethodBeat.m2505o(127736);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xjN.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(127736);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cmb cmb = (cmb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cmb.csB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(127736);
                    return 0;
                case 2:
                    cmb.fhH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(127736);
                    return 0;
                case 3:
                    cmb.apptype = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(127736);
                    return 0;
                case 4:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cmc cmc = new cmc();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cmc.populateBuilderWithField(c6086a3, cmc, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cmb.xjN.add(cmc);
                    }
                    AppMethodBeat.m2505o(127736);
                    return 0;
                case 5:
                    cmb.wGS = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(127736);
                    return 0;
                case 6:
                    cmb.xjO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(127736);
                    return 0;
                case 7:
                    cmb.kfM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(127736);
                    return 0;
                case 8:
                    cmb.xjP = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(127736);
                    return 0;
                default:
                    AppMethodBeat.m2505o(127736);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(127736);
            return -1;
        }
    }
}
