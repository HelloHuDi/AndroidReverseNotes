package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.cd */
public final class C28189cd extends C1331a {
    public C45998e mZk;
    public String ncR;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111639);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.mZk == null) {
                c6092b = new C6092b("Not all required fields were included: AppItem");
                AppMethodBeat.m2505o(111639);
                throw c6092b;
            } else if (this.ncR == null) {
                c6092b = new C6092b("Not all required fields were included: Rank");
                AppMethodBeat.m2505o(111639);
                throw c6092b;
            } else {
                if (this.mZk != null) {
                    c6093a.mo13479iy(1, this.mZk.computeSize());
                    this.mZk.writeFields(c6093a);
                }
                if (this.ncR != null) {
                    c6093a.mo13475e(2, this.ncR);
                }
                AppMethodBeat.m2505o(111639);
                return 0;
            }
        } else if (i == 1) {
            if (this.mZk != null) {
                ix = C6087a.m9557ix(1, this.mZk.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.ncR != null) {
                ix += C6091a.m9575f(2, this.ncR);
            }
            AppMethodBeat.m2505o(111639);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.mZk == null) {
                c6092b = new C6092b("Not all required fields were included: AppItem");
                AppMethodBeat.m2505o(111639);
                throw c6092b;
            } else if (this.ncR == null) {
                c6092b = new C6092b("Not all required fields were included: Rank");
                AppMethodBeat.m2505o(111639);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(111639);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C28189cd c28189cd = (C28189cd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C45998e c45998e = new C45998e();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c45998e.populateBuilderWithField(c6086a3, c45998e, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c28189cd.mZk = c45998e;
                    }
                    AppMethodBeat.m2505o(111639);
                    return 0;
                case 2:
                    c28189cd.ncR = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111639);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111639);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111639);
            return -1;
        }
    }
}
