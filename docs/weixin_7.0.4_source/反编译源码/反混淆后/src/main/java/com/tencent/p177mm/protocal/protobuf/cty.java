package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cty */
public final class cty extends C1331a {
    public long vIs;
    public String xqA;
    public LinkedList<ctz> xqB = new LinkedList();
    public long xqz;

    public cty() {
        AppMethodBeat.m2504i(28735);
        AppMethodBeat.m2505o(28735);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28736);
        C6092b c6092b;
        int o;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xqA == null) {
                c6092b = new C6092b("Not all required fields were included: TotalMsg");
                AppMethodBeat.m2505o(28736);
                throw c6092b;
            }
            c6093a.mo13472ai(1, this.xqz);
            c6093a.mo13472ai(2, this.vIs);
            if (this.xqA != null) {
                c6093a.mo13475e(3, this.xqA);
            }
            c6093a.mo13474e(4, 8, this.xqB);
            AppMethodBeat.m2505o(28736);
            return 0;
        } else if (i == 1) {
            o = (C6091a.m9578o(1, this.xqz) + 0) + C6091a.m9578o(2, this.vIs);
            if (this.xqA != null) {
                o += C6091a.m9575f(3, this.xqA);
            }
            o += C6087a.m9552c(4, 8, this.xqB);
            AppMethodBeat.m2505o(28736);
            return o;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xqB.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (o = C1331a.getNextFieldNumber(c6086a); o > 0; o = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, o)) {
                    c6086a.ems();
                }
            }
            if (this.xqA == null) {
                c6092b = new C6092b("Not all required fields were included: TotalMsg");
                AppMethodBeat.m2505o(28736);
                throw c6092b;
            }
            AppMethodBeat.m2505o(28736);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cty cty = (cty) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cty.xqz = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(28736);
                    return 0;
                case 2:
                    cty.vIs = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(28736);
                    return 0;
                case 3:
                    cty.xqA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28736);
                    return 0;
                case 4:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ctz ctz = new ctz();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ctz.populateBuilderWithField(c6086a3, ctz, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cty.xqB.add(ctz);
                    }
                    AppMethodBeat.m2505o(28736);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28736);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28736);
            return -1;
        }
    }
}
