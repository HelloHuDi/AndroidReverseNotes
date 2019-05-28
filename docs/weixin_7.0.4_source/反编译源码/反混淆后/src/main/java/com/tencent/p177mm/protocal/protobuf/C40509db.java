package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.db */
public final class C40509db extends C1331a {
    public String nbs;
    public C35917fq vFj;
    public LinkedList<ary> vFk = new LinkedList();

    public C40509db() {
        AppMethodBeat.m2504i(94504);
        AppMethodBeat.m2505o(94504);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94505);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vFj == null) {
                c6092b = new C6092b("Not all required fields were included: ArtisAuthor");
                AppMethodBeat.m2505o(94505);
                throw c6092b;
            }
            if (this.vFj != null) {
                c6093a.mo13479iy(1, this.vFj.computeSize());
                this.vFj.writeFields(c6093a);
            }
            c6093a.mo13474e(2, 8, this.vFk);
            if (this.nbs != null) {
                c6093a.mo13475e(3, this.nbs);
            }
            AppMethodBeat.m2505o(94505);
            return 0;
        } else if (i == 1) {
            if (this.vFj != null) {
                ix = C6087a.m9557ix(1, this.vFj.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6087a.m9552c(2, 8, this.vFk);
            if (this.nbs != null) {
                ix += C6091a.m9575f(3, this.nbs);
            }
            AppMethodBeat.m2505o(94505);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vFk.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.vFj == null) {
                c6092b = new C6092b("Not all required fields were included: ArtisAuthor");
                AppMethodBeat.m2505o(94505);
                throw c6092b;
            }
            AppMethodBeat.m2505o(94505);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C40509db c40509db = (C40509db) objArr[1];
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
                        C35917fq c35917fq = new C35917fq();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c35917fq.populateBuilderWithField(c6086a3, c35917fq, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40509db.vFj = c35917fq;
                    }
                    AppMethodBeat.m2505o(94505);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ary ary = new ary();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ary.populateBuilderWithField(c6086a3, ary, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40509db.vFk.add(ary);
                    }
                    AppMethodBeat.m2505o(94505);
                    return 0;
                case 3:
                    c40509db.nbs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94505);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94505);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94505);
            return -1;
        }
    }
}
