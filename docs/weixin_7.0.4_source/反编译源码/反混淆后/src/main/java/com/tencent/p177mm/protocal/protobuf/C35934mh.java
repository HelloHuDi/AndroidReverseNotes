package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.mh */
public final class C35934mh extends C1331a {
    public String Title;
    public int jBV;
    public LinkedList<C15361mn> naO = new LinkedList();
    public int vOq;
    public long vQd;
    public int vQe;
    public LinkedList<String> vQf = new LinkedList();
    public String vQg;

    public C35934mh() {
        AppMethodBeat.m2504i(124294);
        AppMethodBeat.m2505o(124294);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(124295);
        C6092b c6092b;
        int o;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vQg == null) {
                c6092b = new C6092b("Not all required fields were included: SearchID");
                AppMethodBeat.m2505o(124295);
                throw c6092b;
            }
            c6093a.mo13472ai(1, this.vQd);
            c6093a.mo13480iz(2, this.vQe);
            if (this.Title != null) {
                c6093a.mo13475e(3, this.Title);
            }
            c6093a.mo13474e(4, 1, this.vQf);
            c6093a.mo13474e(5, 8, this.naO);
            c6093a.mo13480iz(6, this.jBV);
            if (this.vQg != null) {
                c6093a.mo13475e(7, this.vQg);
            }
            c6093a.mo13480iz(8, this.vOq);
            AppMethodBeat.m2505o(124295);
            return 0;
        } else if (i == 1) {
            o = (C6091a.m9578o(1, this.vQd) + 0) + C6091a.m9572bs(2, this.vQe);
            if (this.Title != null) {
                o += C6091a.m9575f(3, this.Title);
            }
            o = ((o + C6087a.m9552c(4, 1, this.vQf)) + C6087a.m9552c(5, 8, this.naO)) + C6091a.m9572bs(6, this.jBV);
            if (this.vQg != null) {
                o += C6091a.m9575f(7, this.vQg);
            }
            o += C6091a.m9572bs(8, this.vOq);
            AppMethodBeat.m2505o(124295);
            return o;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vQf.clear();
            this.naO.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (o = C1331a.getNextFieldNumber(c6086a); o > 0; o = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, o)) {
                    c6086a.ems();
                }
            }
            if (this.vQg == null) {
                c6092b = new C6092b("Not all required fields were included: SearchID");
                AppMethodBeat.m2505o(124295);
                throw c6092b;
            }
            AppMethodBeat.m2505o(124295);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C35934mh c35934mh = (C35934mh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c35934mh.vQd = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(124295);
                    return 0;
                case 2:
                    c35934mh.vQe = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124295);
                    return 0;
                case 3:
                    c35934mh.Title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124295);
                    return 0;
                case 4:
                    c35934mh.vQf.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(124295);
                    return 0;
                case 5:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C15361mn c15361mn = new C15361mn();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c15361mn.populateBuilderWithField(c6086a3, c15361mn, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35934mh.naO.add(c15361mn);
                    }
                    AppMethodBeat.m2505o(124295);
                    return 0;
                case 6:
                    c35934mh.jBV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124295);
                    return 0;
                case 7:
                    c35934mh.vQg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124295);
                    return 0;
                case 8:
                    c35934mh.vOq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124295);
                    return 0;
                default:
                    AppMethodBeat.m2505o(124295);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(124295);
            return -1;
        }
    }
}
