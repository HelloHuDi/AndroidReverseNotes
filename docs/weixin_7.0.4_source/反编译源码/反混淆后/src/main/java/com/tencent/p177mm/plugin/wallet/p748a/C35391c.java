package com.tencent.p177mm.plugin.wallet.p748a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.wallet.a.c */
public final class C35391c extends C1331a {
    public String pbo;
    public LinkedList<C35392d> tmL = new LinkedList();

    public C35391c() {
        AppMethodBeat.m2504i(56643);
        AppMethodBeat.m2505o(56643);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56644);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.pbo != null) {
                c6093a.mo13475e(1, this.pbo);
            }
            c6093a.mo13474e(2, 8, this.tmL);
            AppMethodBeat.m2505o(56644);
            return 0;
        } else if (i == 1) {
            if (this.pbo != null) {
                f = C6091a.m9575f(1, this.pbo) + 0;
            } else {
                f = 0;
            }
            int c = f + C6087a.m9552c(2, 8, this.tmL);
            AppMethodBeat.m2505o(56644);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.tmL.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56644);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C35391c c35391c = (C35391c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c35391c.pbo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56644);
                    return 0;
                case 2:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C35392d c35392d = new C35392d();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c35392d.populateBuilderWithField(c6086a3, c35392d, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35391c.tmL.add(c35392d);
                    }
                    AppMethodBeat.m2505o(56644);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56644);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56644);
            return -1;
        }
    }
}
