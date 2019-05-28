package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.dp */
public final class C28196dp extends C1331a {
    public boolean ndK;
    public LinkedList<C12118cu> ndL = new LinkedList();
    public LinkedList<C12118cu> ndM = new LinkedList();

    public C28196dp() {
        AppMethodBeat.m2504i(117005);
        AppMethodBeat.m2505o(117005);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(117006);
        int fv;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13471aO(1, this.ndK);
            c6093a.mo13474e(3, 8, this.ndL);
            c6093a.mo13474e(4, 8, this.ndM);
            AppMethodBeat.m2505o(117006);
            return 0;
        } else if (i == 1) {
            fv = (((C6091a.m9576fv(1) + 1) + 0) + C6087a.m9552c(3, 8, this.ndL)) + C6087a.m9552c(4, 8, this.ndM);
            AppMethodBeat.m2505o(117006);
            return fv;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.ndL.clear();
            this.ndM.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (fv = C1331a.getNextFieldNumber(c6086a); fv > 0; fv = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, fv)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(117006);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C28196dp c28196dp = (C28196dp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C12118cu c12118cu;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c28196dp.ndK = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(117006);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c12118cu = new C12118cu();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c12118cu.populateBuilderWithField(c6086a3, c12118cu, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c28196dp.ndL.add(c12118cu);
                    }
                    AppMethodBeat.m2505o(117006);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c12118cu = new C12118cu();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c12118cu.populateBuilderWithField(c6086a3, c12118cu, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c28196dp.ndM.add(c12118cu);
                    }
                    AppMethodBeat.m2505o(117006);
                    return 0;
                default:
                    AppMethodBeat.m2505o(117006);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(117006);
            return -1;
        }
    }
}
