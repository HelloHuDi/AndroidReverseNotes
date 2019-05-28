package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.hd */
public final class C23396hd extends C1331a {
    public String nuL;
    public String pLH;
    public int pLI;
    public int pLJ;
    public String pLK;
    public String pLL;
    public String pLM;
    public long pLP;
    public String pbn;
    public LinkedList<C44196yq> vJM = new LinkedList();
    public String vJN;
    public String vJO;

    public C23396hd() {
        AppMethodBeat.m2504i(48776);
        AppMethodBeat.m2505o(48776);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48777);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.pbn != null) {
                c6093a.mo13475e(1, this.pbn);
            }
            if (this.nuL != null) {
                c6093a.mo13475e(2, this.nuL);
            }
            if (this.pLH != null) {
                c6093a.mo13475e(3, this.pLH);
            }
            c6093a.mo13480iz(4, this.pLI);
            c6093a.mo13480iz(5, this.pLJ);
            c6093a.mo13474e(6, 8, this.vJM);
            if (this.pLK != null) {
                c6093a.mo13475e(7, this.pLK);
            }
            if (this.pLL != null) {
                c6093a.mo13475e(8, this.pLL);
            }
            if (this.pLM != null) {
                c6093a.mo13475e(9, this.pLM);
            }
            if (this.vJN != null) {
                c6093a.mo13475e(10, this.vJN);
            }
            if (this.vJO != null) {
                c6093a.mo13475e(11, this.vJO);
            }
            c6093a.mo13472ai(12, this.pLP);
            AppMethodBeat.m2505o(48777);
            return 0;
        } else if (i == 1) {
            if (this.pbn != null) {
                f = C6091a.m9575f(1, this.pbn) + 0;
            } else {
                f = 0;
            }
            if (this.nuL != null) {
                f += C6091a.m9575f(2, this.nuL);
            }
            if (this.pLH != null) {
                f += C6091a.m9575f(3, this.pLH);
            }
            f = ((f + C6091a.m9572bs(4, this.pLI)) + C6091a.m9572bs(5, this.pLJ)) + C6087a.m9552c(6, 8, this.vJM);
            if (this.pLK != null) {
                f += C6091a.m9575f(7, this.pLK);
            }
            if (this.pLL != null) {
                f += C6091a.m9575f(8, this.pLL);
            }
            if (this.pLM != null) {
                f += C6091a.m9575f(9, this.pLM);
            }
            if (this.vJN != null) {
                f += C6091a.m9575f(10, this.vJN);
            }
            if (this.vJO != null) {
                f += C6091a.m9575f(11, this.vJO);
            }
            int o = f + C6091a.m9578o(12, this.pLP);
            AppMethodBeat.m2505o(48777);
            return o;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vJM.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48777);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23396hd c23396hd = (C23396hd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c23396hd.pbn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48777);
                    return 0;
                case 2:
                    c23396hd.nuL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48777);
                    return 0;
                case 3:
                    c23396hd.pLH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48777);
                    return 0;
                case 4:
                    c23396hd.pLI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48777);
                    return 0;
                case 5:
                    c23396hd.pLJ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48777);
                    return 0;
                case 6:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C44196yq c44196yq = new C44196yq();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c44196yq.populateBuilderWithField(c6086a3, c44196yq, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c23396hd.vJM.add(c44196yq);
                    }
                    AppMethodBeat.m2505o(48777);
                    return 0;
                case 7:
                    c23396hd.pLK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48777);
                    return 0;
                case 8:
                    c23396hd.pLL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48777);
                    return 0;
                case 9:
                    c23396hd.pLM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48777);
                    return 0;
                case 10:
                    c23396hd.vJN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48777);
                    return 0;
                case 11:
                    c23396hd.vJO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48777);
                    return 0;
                case 12:
                    c23396hd.pLP = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(48777);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48777);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48777);
            return -1;
        }
    }
}
