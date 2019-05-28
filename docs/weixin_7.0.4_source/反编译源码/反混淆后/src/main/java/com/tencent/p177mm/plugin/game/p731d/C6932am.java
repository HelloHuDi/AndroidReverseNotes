package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.am */
public final class C6932am extends C1331a {
    public String Title;
    public String mZL;
    public String nbb;
    public LinkedList<C28191ct> nbc = new LinkedList();
    public C43169dr nbd;

    public C6932am() {
        AppMethodBeat.m2504i(111578);
        AppMethodBeat.m2505o(111578);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111579);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.nbb != null) {
                c6093a.mo13475e(1, this.nbb);
            }
            if (this.Title != null) {
                c6093a.mo13475e(2, this.Title);
            }
            c6093a.mo13474e(3, 8, this.nbc);
            if (this.nbd != null) {
                c6093a.mo13479iy(4, this.nbd.computeSize());
                this.nbd.writeFields(c6093a);
            }
            if (this.mZL != null) {
                c6093a.mo13475e(5, this.mZL);
            }
            AppMethodBeat.m2505o(111579);
            return 0;
        } else if (i == 1) {
            if (this.nbb != null) {
                f = C6091a.m9575f(1, this.nbb) + 0;
            } else {
                f = 0;
            }
            if (this.Title != null) {
                f += C6091a.m9575f(2, this.Title);
            }
            f += C6087a.m9552c(3, 8, this.nbc);
            if (this.nbd != null) {
                f += C6087a.m9557ix(4, this.nbd.computeSize());
            }
            if (this.mZL != null) {
                f += C6091a.m9575f(5, this.mZL);
            }
            AppMethodBeat.m2505o(111579);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.nbc.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(111579);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C6932am c6932am = (C6932am) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c6932am.nbb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111579);
                    return 0;
                case 2:
                    c6932am.Title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111579);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C28191ct c28191ct = new C28191ct();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c28191ct.populateBuilderWithField(c6086a3, c28191ct, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c6932am.nbc.add(c28191ct);
                    }
                    AppMethodBeat.m2505o(111579);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C43169dr c43169dr = new C43169dr();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c43169dr.populateBuilderWithField(c6086a3, c43169dr, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c6932am.nbd = c43169dr;
                    }
                    AppMethodBeat.m2505o(111579);
                    return 0;
                case 5:
                    c6932am.mZL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111579);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111579);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111579);
            return -1;
        }
    }
}
