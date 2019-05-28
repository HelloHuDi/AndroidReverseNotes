package com.tencent.p177mm.plugin.downloader.p723c.p941a.p942a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.downloader.c.a.a.e */
public final class C20308e extends C1331a {
    public LinkedList<C27702g> kKu = new LinkedList();
    public long kKv;

    public C20308e() {
        AppMethodBeat.m2504i(35512);
        AppMethodBeat.m2505o(35512);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(35513);
        int c;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13474e(1, 8, this.kKu);
            c6093a.mo13472ai(2, this.kKv);
            AppMethodBeat.m2505o(35513);
            return 0;
        } else if (i == 1) {
            c = (C6087a.m9552c(1, 8, this.kKu) + 0) + C6091a.m9578o(2, this.kKv);
            AppMethodBeat.m2505o(35513);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.kKu.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(35513);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C20308e c20308e = (C20308e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C27702g c27702g = new C27702g();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c27702g.populateBuilderWithField(c6086a3, c27702g, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c20308e.kKu.add(c27702g);
                    }
                    AppMethodBeat.m2505o(35513);
                    return 0;
                case 2:
                    c20308e.kKv = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(35513);
                    return 0;
                default:
                    AppMethodBeat.m2505o(35513);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(35513);
            return -1;
        }
    }
}
