package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.rg */
public final class C15381rg extends C1331a {
    public C1332b vYw;
    public LinkedList<C1332b> vYx = new LinkedList();

    public C15381rg() {
        AppMethodBeat.m2504i(96213);
        AppMethodBeat.m2505o(96213);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(96214);
        int b;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vYw != null) {
                c6093a.mo13473c(1, this.vYw);
            }
            c6093a.mo13474e(2, 6, this.vYx);
            AppMethodBeat.m2505o(96214);
            return 0;
        } else if (i == 1) {
            if (this.vYw != null) {
                b = C6091a.m9571b(1, this.vYw) + 0;
            } else {
                b = 0;
            }
            int c = b + C6087a.m9552c(2, 6, this.vYx);
            AppMethodBeat.m2505o(96214);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.vYx.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (b = C1331a.getNextFieldNumber(c6086a); b > 0; b = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, b)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(96214);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C15381rg c15381rg = (C15381rg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c15381rg.vYw = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(96214);
                    return 0;
                case 2:
                    c15381rg.vYx.add(c6086a2.BTU.emu());
                    AppMethodBeat.m2505o(96214);
                    return 0;
                default:
                    AppMethodBeat.m2505o(96214);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(96214);
            return -1;
        }
    }
}
