package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.abv */
public final class abv extends C1331a {
    public String pOz;
    public LinkedList<abw> vPg = new LinkedList();
    public String vWF;
    public String wjd;
    public long wje;
    public long wjf;
    public String wjg;
    public long wjh;

    public abv() {
        AppMethodBeat.m2504i(56790);
        AppMethodBeat.m2505o(56790);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56791);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wjd != null) {
                c6093a.mo13475e(1, this.wjd);
            }
            c6093a.mo13474e(2, 8, this.vPg);
            c6093a.mo13472ai(3, this.wje);
            c6093a.mo13472ai(4, this.wjf);
            if (this.wjg != null) {
                c6093a.mo13475e(5, this.wjg);
            }
            if (this.pOz != null) {
                c6093a.mo13475e(6, this.pOz);
            }
            c6093a.mo13472ai(7, this.wjh);
            if (this.vWF != null) {
                c6093a.mo13475e(8, this.vWF);
            }
            AppMethodBeat.m2505o(56791);
            return 0;
        } else if (i == 1) {
            if (this.wjd != null) {
                f = C6091a.m9575f(1, this.wjd) + 0;
            } else {
                f = 0;
            }
            f = ((f + C6087a.m9552c(2, 8, this.vPg)) + C6091a.m9578o(3, this.wje)) + C6091a.m9578o(4, this.wjf);
            if (this.wjg != null) {
                f += C6091a.m9575f(5, this.wjg);
            }
            if (this.pOz != null) {
                f += C6091a.m9575f(6, this.pOz);
            }
            f += C6091a.m9578o(7, this.wjh);
            if (this.vWF != null) {
                f += C6091a.m9575f(8, this.vWF);
            }
            AppMethodBeat.m2505o(56791);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vPg.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56791);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            abv abv = (abv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    abv.wjd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56791);
                    return 0;
                case 2:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        abw abw = new abw();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = abw.populateBuilderWithField(c6086a3, abw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        abv.vPg.add(abw);
                    }
                    AppMethodBeat.m2505o(56791);
                    return 0;
                case 3:
                    abv.wje = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56791);
                    return 0;
                case 4:
                    abv.wjf = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56791);
                    return 0;
                case 5:
                    abv.wjg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56791);
                    return 0;
                case 6:
                    abv.pOz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56791);
                    return 0;
                case 7:
                    abv.wjh = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56791);
                    return 0;
                case 8:
                    abv.vWF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56791);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56791);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56791);
            return -1;
        }
    }
}
