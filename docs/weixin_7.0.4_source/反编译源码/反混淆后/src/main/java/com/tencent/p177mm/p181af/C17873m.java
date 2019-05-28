package com.tencent.p177mm.p181af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.af.m */
public class C17873m extends C1331a {
    public String cMg;
    public String cMh;
    public String dJv;
    public LinkedList<C32224p> fjr = new LinkedList();
    public int fjs;
    public String name;
    public int type;

    public C17873m() {
        AppMethodBeat.m2504i(105477);
        AppMethodBeat.m2505o(105477);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(105478);
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.type);
            if (this.name != null) {
                c6093a.mo13475e(2, this.name);
            }
            if (this.cMg != null) {
                c6093a.mo13475e(3, this.cMg);
            }
            if (this.cMh != null) {
                c6093a.mo13475e(4, this.cMh);
            }
            if (this.dJv != null) {
                c6093a.mo13475e(5, this.dJv);
            }
            c6093a.mo13474e(6, 8, this.fjr);
            c6093a.mo13480iz(7, this.fjs);
            AppMethodBeat.m2505o(105478);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.type) + 0;
            if (this.name != null) {
                bs += C6091a.m9575f(2, this.name);
            }
            if (this.cMg != null) {
                bs += C6091a.m9575f(3, this.cMg);
            }
            if (this.cMh != null) {
                bs += C6091a.m9575f(4, this.cMh);
            }
            if (this.dJv != null) {
                bs += C6091a.m9575f(5, this.dJv);
            }
            bs = (bs + C6087a.m9552c(6, 8, this.fjr)) + C6091a.m9572bs(7, this.fjs);
            AppMethodBeat.m2505o(105478);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.fjr.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(105478);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C17873m c17873m = (C17873m) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c17873m.type = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(105478);
                    return 0;
                case 2:
                    c17873m.name = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(105478);
                    return 0;
                case 3:
                    c17873m.cMg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(105478);
                    return 0;
                case 4:
                    c17873m.cMh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(105478);
                    return 0;
                case 5:
                    c17873m.dJv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(105478);
                    return 0;
                case 6:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C32224p c32224p = new C32224p();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c32224p.populateBuilderWithField(c6086a3, c32224p, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c17873m.fjr.add(c32224p);
                    }
                    AppMethodBeat.m2505o(105478);
                    return 0;
                case 7:
                    c17873m.fjs = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(105478);
                    return 0;
                default:
                    AppMethodBeat.m2505o(105478);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(105478);
            return -1;
        }
    }
}
