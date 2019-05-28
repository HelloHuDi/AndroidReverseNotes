package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bwr */
public final class bwr extends C1331a {
    public String cvZ;
    public String eyr;
    public int fVJ;
    public int fXd;
    public int fgI;
    public int fgJ;
    public String qQm;
    public String url;
    public LinkedList<chk> wXc = new LinkedList();
    public int wXd;

    public bwr() {
        AppMethodBeat.m2504i(51002);
        AppMethodBeat.m2505o(51002);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(51003);
        C6092b c6092b;
        int c;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.qQm == null) {
                c6092b = new C6092b("Not all required fields were included: clientID");
                AppMethodBeat.m2505o(51003);
                throw c6092b;
            }
            c6093a.mo13474e(1, 8, this.wXc);
            if (this.qQm != null) {
                c6093a.mo13475e(2, this.qQm);
            }
            if (this.cvZ != null) {
                c6093a.mo13475e(3, this.cvZ);
            }
            if (this.eyr != null) {
                c6093a.mo13475e(4, this.eyr);
            }
            if (this.url != null) {
                c6093a.mo13475e(5, this.url);
            }
            c6093a.mo13480iz(6, this.fXd);
            c6093a.mo13480iz(7, this.fVJ);
            c6093a.mo13480iz(8, this.wXd);
            c6093a.mo13480iz(9, this.fgI);
            c6093a.mo13480iz(10, this.fgJ);
            AppMethodBeat.m2505o(51003);
            return 0;
        } else if (i == 1) {
            c = C6087a.m9552c(1, 8, this.wXc) + 0;
            if (this.qQm != null) {
                c += C6091a.m9575f(2, this.qQm);
            }
            if (this.cvZ != null) {
                c += C6091a.m9575f(3, this.cvZ);
            }
            if (this.eyr != null) {
                c += C6091a.m9575f(4, this.eyr);
            }
            if (this.url != null) {
                c += C6091a.m9575f(5, this.url);
            }
            c = ((((c + C6091a.m9572bs(6, this.fXd)) + C6091a.m9572bs(7, this.fVJ)) + C6091a.m9572bs(8, this.wXd)) + C6091a.m9572bs(9, this.fgI)) + C6091a.m9572bs(10, this.fgJ);
            AppMethodBeat.m2505o(51003);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wXc.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            if (this.qQm == null) {
                c6092b = new C6092b("Not all required fields were included: clientID");
                AppMethodBeat.m2505o(51003);
                throw c6092b;
            }
            AppMethodBeat.m2505o(51003);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bwr bwr = (bwr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        chk chk = new chk();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = chk.populateBuilderWithField(c6086a3, chk, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bwr.wXc.add(chk);
                    }
                    AppMethodBeat.m2505o(51003);
                    return 0;
                case 2:
                    bwr.qQm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51003);
                    return 0;
                case 3:
                    bwr.cvZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51003);
                    return 0;
                case 4:
                    bwr.eyr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51003);
                    return 0;
                case 5:
                    bwr.url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51003);
                    return 0;
                case 6:
                    bwr.fXd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51003);
                    return 0;
                case 7:
                    bwr.fVJ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51003);
                    return 0;
                case 8:
                    bwr.wXd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51003);
                    return 0;
                case 9:
                    bwr.fgI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51003);
                    return 0;
                case 10:
                    bwr.fgJ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51003);
                    return 0;
                default:
                    AppMethodBeat.m2505o(51003);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(51003);
            return -1;
        }
    }
}
