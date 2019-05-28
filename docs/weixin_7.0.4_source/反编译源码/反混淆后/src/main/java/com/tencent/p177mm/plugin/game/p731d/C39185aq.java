package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.aq */
public final class C39185aq extends C1331a {
    public String mZL;
    public C45998e mZk;
    public String mZo;
    public LinkedList<C45989ar> nbg = new LinkedList();

    public C39185aq() {
        AppMethodBeat.m2504i(111583);
        AppMethodBeat.m2505o(111583);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111584);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.mZk == null) {
                c6092b = new C6092b("Not all required fields were included: AppItem");
                AppMethodBeat.m2505o(111584);
                throw c6092b;
            }
            if (this.mZk != null) {
                c6093a.mo13479iy(1, this.mZk.computeSize());
                this.mZk.writeFields(c6093a);
            }
            if (this.mZo != null) {
                c6093a.mo13475e(2, this.mZo);
            }
            c6093a.mo13474e(3, 8, this.nbg);
            if (this.mZL != null) {
                c6093a.mo13475e(4, this.mZL);
            }
            AppMethodBeat.m2505o(111584);
            return 0;
        } else if (i == 1) {
            if (this.mZk != null) {
                ix = C6087a.m9557ix(1, this.mZk.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.mZo != null) {
                ix += C6091a.m9575f(2, this.mZo);
            }
            ix += C6087a.m9552c(3, 8, this.nbg);
            if (this.mZL != null) {
                ix += C6091a.m9575f(4, this.mZL);
            }
            AppMethodBeat.m2505o(111584);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.nbg.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.mZk == null) {
                c6092b = new C6092b("Not all required fields were included: AppItem");
                AppMethodBeat.m2505o(111584);
                throw c6092b;
            }
            AppMethodBeat.m2505o(111584);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C39185aq c39185aq = (C39185aq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C45998e c45998e = new C45998e();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c45998e.populateBuilderWithField(c6086a3, c45998e, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c39185aq.mZk = c45998e;
                    }
                    AppMethodBeat.m2505o(111584);
                    return 0;
                case 2:
                    c39185aq.mZo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111584);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C45989ar c45989ar = new C45989ar();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c45989ar.populateBuilderWithField(c6086a3, c45989ar, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c39185aq.nbg.add(c45989ar);
                    }
                    AppMethodBeat.m2505o(111584);
                    return 0;
                case 4:
                    c39185aq.mZL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111584);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111584);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111584);
            return -1;
        }
    }
}
