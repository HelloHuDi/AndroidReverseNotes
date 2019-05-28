package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cxa */
public final class cxa extends C1331a {
    public C1332b vMS;
    public LinkedList<cwx> vMT = new LinkedList();
    public String xfb;

    public cxa() {
        AppMethodBeat.m2504i(96338);
        AppMethodBeat.m2505o(96338);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(96339);
        C6092b c6092b;
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xfb == null) {
                c6092b = new C6092b("Not all required fields were included: WxaUserName");
                AppMethodBeat.m2505o(96339);
                throw c6092b;
            }
            if (this.xfb != null) {
                c6093a.mo13475e(1, this.xfb);
            }
            if (this.vMS != null) {
                c6093a.mo13473c(2, this.vMS);
            }
            c6093a.mo13474e(3, 8, this.vMT);
            AppMethodBeat.m2505o(96339);
            return 0;
        } else if (i == 1) {
            if (this.xfb != null) {
                f = C6091a.m9575f(1, this.xfb) + 0;
            } else {
                f = 0;
            }
            if (this.vMS != null) {
                f += C6091a.m9571b(2, this.vMS);
            }
            int c = f + C6087a.m9552c(3, 8, this.vMT);
            AppMethodBeat.m2505o(96339);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vMT.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.xfb == null) {
                c6092b = new C6092b("Not all required fields were included: WxaUserName");
                AppMethodBeat.m2505o(96339);
                throw c6092b;
            }
            AppMethodBeat.m2505o(96339);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cxa cxa = (cxa) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cxa.xfb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96339);
                    return 0;
                case 2:
                    cxa.vMS = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(96339);
                    return 0;
                case 3:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cwx cwx = new cwx();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cwx.populateBuilderWithField(c6086a3, cwx, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cxa.vMT.add(cwx);
                    }
                    AppMethodBeat.m2505o(96339);
                    return 0;
                default:
                    AppMethodBeat.m2505o(96339);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(96339);
            return -1;
        }
    }
}
