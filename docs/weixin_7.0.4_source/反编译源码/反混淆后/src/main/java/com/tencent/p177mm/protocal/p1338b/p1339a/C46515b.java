package com.tencent.p177mm.protocal.p1338b.p1339a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.b.a.b */
public final class C46515b extends C1331a {
    public String bzH;
    /* renamed from: id */
    public int f17912id;
    public String title;
    public LinkedList<C23368a> vzI = new LinkedList();

    public C46515b() {
        AppMethodBeat.m2504i(105577);
        AppMethodBeat.m2505o(105577);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(105578);
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.f17912id);
            if (this.title != null) {
                c6093a.mo13475e(2, this.title);
            }
            if (this.bzH != null) {
                c6093a.mo13475e(3, this.bzH);
            }
            c6093a.mo13474e(4, 8, this.vzI);
            AppMethodBeat.m2505o(105578);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.f17912id) + 0;
            if (this.title != null) {
                bs += C6091a.m9575f(2, this.title);
            }
            if (this.bzH != null) {
                bs += C6091a.m9575f(3, this.bzH);
            }
            bs += C6087a.m9552c(4, 8, this.vzI);
            AppMethodBeat.m2505o(105578);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vzI.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(105578);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C46515b c46515b = (C46515b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c46515b.f17912id = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(105578);
                    return 0;
                case 2:
                    c46515b.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(105578);
                    return 0;
                case 3:
                    c46515b.bzH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(105578);
                    return 0;
                case 4:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C23368a c23368a = new C23368a();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c23368a.populateBuilderWithField(c6086a3, c23368a, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46515b.vzI.add(c23368a);
                    }
                    AppMethodBeat.m2505o(105578);
                    return 0;
                default:
                    AppMethodBeat.m2505o(105578);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(105578);
            return -1;
        }
    }
}
