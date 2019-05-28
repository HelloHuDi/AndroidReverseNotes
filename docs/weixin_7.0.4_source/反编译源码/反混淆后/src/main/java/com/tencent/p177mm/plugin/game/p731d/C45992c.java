package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.c */
public final class C45992c extends C1331a {
    public int jCt;
    public C45998e mZk;
    public C20947b mZn;
    public String mZo;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111544);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.jCt);
            if (this.mZk != null) {
                c6093a.mo13479iy(2, this.mZk.computeSize());
                this.mZk.writeFields(c6093a);
            }
            if (this.mZn != null) {
                c6093a.mo13479iy(3, this.mZn.computeSize());
                this.mZn.writeFields(c6093a);
            }
            if (this.mZo != null) {
                c6093a.mo13475e(4, this.mZo);
            }
            AppMethodBeat.m2505o(111544);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.jCt) + 0;
            if (this.mZk != null) {
                bs += C6087a.m9557ix(2, this.mZk.computeSize());
            }
            if (this.mZn != null) {
                bs += C6087a.m9557ix(3, this.mZn.computeSize());
            }
            if (this.mZo != null) {
                bs += C6091a.m9575f(4, this.mZo);
            }
            AppMethodBeat.m2505o(111544);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(111544);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C45992c c45992c = (C45992c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c45992c.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(111544);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C45998e c45998e = new C45998e();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c45998e.populateBuilderWithField(c6086a3, c45998e, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c45992c.mZk = c45998e;
                    }
                    AppMethodBeat.m2505o(111544);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C20947b c20947b = new C20947b();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c20947b.populateBuilderWithField(c6086a3, c20947b, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c45992c.mZn = c20947b;
                    }
                    AppMethodBeat.m2505o(111544);
                    return 0;
                case 4:
                    c45992c.mZo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111544);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111544);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111544);
            return -1;
        }
    }
}
