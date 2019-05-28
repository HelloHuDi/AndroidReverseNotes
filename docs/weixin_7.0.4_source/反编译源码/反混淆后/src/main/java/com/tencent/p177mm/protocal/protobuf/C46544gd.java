package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.gd */
public final class C46544gd extends C1331a {
    public String desc;
    public String title;
    public LinkedList<C15343gc> vIf = new LinkedList();

    public C46544gd() {
        AppMethodBeat.m2504i(96200);
        AppMethodBeat.m2505o(96200);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(96201);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.title != null) {
                c6093a.mo13475e(1, this.title);
            }
            if (this.desc != null) {
                c6093a.mo13475e(2, this.desc);
            }
            c6093a.mo13474e(3, 8, this.vIf);
            AppMethodBeat.m2505o(96201);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = C6091a.m9575f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.desc != null) {
                f += C6091a.m9575f(2, this.desc);
            }
            int c = f + C6087a.m9552c(3, 8, this.vIf);
            AppMethodBeat.m2505o(96201);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vIf.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(96201);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C46544gd c46544gd = (C46544gd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c46544gd.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96201);
                    return 0;
                case 2:
                    c46544gd.desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96201);
                    return 0;
                case 3:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C15343gc c15343gc = new C15343gc();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c15343gc.populateBuilderWithField(c6086a3, c15343gc, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46544gd.vIf.add(c15343gc);
                    }
                    AppMethodBeat.m2505o(96201);
                    return 0;
                default:
                    AppMethodBeat.m2505o(96201);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(96201);
            return -1;
        }
    }
}
