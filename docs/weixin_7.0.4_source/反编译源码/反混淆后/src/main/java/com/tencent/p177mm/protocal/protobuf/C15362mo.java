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

/* renamed from: com.tencent.mm.protocal.protobuf.mo */
public final class C15362mo extends C1331a {
    public C1332b vQB;
    public C1332b vQC;
    public LinkedList<bxh> vQD = new LinkedList();

    public C15362mo() {
        AppMethodBeat.m2504i(124301);
        AppMethodBeat.m2505o(124301);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(124302);
        C6092b c6092b;
        int b;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vQB == null) {
                c6092b = new C6092b("Not all required fields were included: Title");
                AppMethodBeat.m2505o(124302);
                throw c6092b;
            } else if (this.vQC == null) {
                c6092b = new C6092b("Not all required fields were included: ServiceUrl");
                AppMethodBeat.m2505o(124302);
                throw c6092b;
            } else {
                if (this.vQB != null) {
                    c6093a.mo13473c(1, this.vQB);
                }
                if (this.vQC != null) {
                    c6093a.mo13473c(2, this.vQC);
                }
                c6093a.mo13474e(3, 8, this.vQD);
                AppMethodBeat.m2505o(124302);
                return 0;
            }
        } else if (i == 1) {
            if (this.vQB != null) {
                b = C6091a.m9571b(1, this.vQB) + 0;
            } else {
                b = 0;
            }
            if (this.vQC != null) {
                b += C6091a.m9571b(2, this.vQC);
            }
            int c = b + C6087a.m9552c(3, 8, this.vQD);
            AppMethodBeat.m2505o(124302);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vQD.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (b = C1331a.getNextFieldNumber(c6086a); b > 0; b = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, b)) {
                    c6086a.ems();
                }
            }
            if (this.vQB == null) {
                c6092b = new C6092b("Not all required fields were included: Title");
                AppMethodBeat.m2505o(124302);
                throw c6092b;
            } else if (this.vQC == null) {
                c6092b = new C6092b("Not all required fields were included: ServiceUrl");
                AppMethodBeat.m2505o(124302);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(124302);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C15362mo c15362mo = (C15362mo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c15362mo.vQB = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(124302);
                    return 0;
                case 2:
                    c15362mo.vQC = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(124302);
                    return 0;
                case 3:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bxh bxh = new bxh();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bxh.populateBuilderWithField(c6086a3, bxh, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15362mo.vQD.add(bxh);
                    }
                    AppMethodBeat.m2505o(124302);
                    return 0;
                default:
                    AppMethodBeat.m2505o(124302);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(124302);
            return -1;
        }
    }
}
