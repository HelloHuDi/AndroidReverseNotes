package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.dq */
public final class C20956dq extends C1331a {
    public String mZL;
    public C43169dr ndN;
    public C45987ab ndO;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111681);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.ndN != null) {
                c6093a.mo13479iy(1, this.ndN.computeSize());
                this.ndN.writeFields(c6093a);
            }
            if (this.ndO != null) {
                c6093a.mo13479iy(2, this.ndO.computeSize());
                this.ndO.writeFields(c6093a);
            }
            if (this.mZL != null) {
                c6093a.mo13475e(3, this.mZL);
            }
            AppMethodBeat.m2505o(111681);
            return 0;
        } else if (i == 1) {
            if (this.ndN != null) {
                ix = C6087a.m9557ix(1, this.ndN.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.ndO != null) {
                ix += C6087a.m9557ix(2, this.ndO.computeSize());
            }
            if (this.mZL != null) {
                ix += C6091a.m9575f(3, this.mZL);
            }
            AppMethodBeat.m2505o(111681);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(111681);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C20956dq c20956dq = (C20956dq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C43169dr c43169dr = new C43169dr();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c43169dr.populateBuilderWithField(c6086a3, c43169dr, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c20956dq.ndN = c43169dr;
                    }
                    AppMethodBeat.m2505o(111681);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C45987ab c45987ab = new C45987ab();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c45987ab.populateBuilderWithField(c6086a3, c45987ab, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c20956dq.ndO = c45987ab;
                    }
                    AppMethodBeat.m2505o(111681);
                    return 0;
                case 3:
                    c20956dq.mZL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111681);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111681);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111681);
            return -1;
        }
    }
}
