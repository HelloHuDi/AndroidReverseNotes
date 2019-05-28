package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.ae */
public final class C6930ae extends C1331a {
    public String Desc;
    public C45998e mZk;
    public C28181ag naM;
    public C6931af naN;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111568);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.mZk == null) {
                c6092b = new C6092b("Not all required fields were included: AppItem");
                AppMethodBeat.m2505o(111568);
                throw c6092b;
            }
            if (this.mZk != null) {
                c6093a.mo13479iy(1, this.mZk.computeSize());
                this.mZk.writeFields(c6093a);
            }
            if (this.naM != null) {
                c6093a.mo13479iy(2, this.naM.computeSize());
                this.naM.writeFields(c6093a);
            }
            if (this.naN != null) {
                c6093a.mo13479iy(3, this.naN.computeSize());
                this.naN.writeFields(c6093a);
            }
            if (this.Desc != null) {
                c6093a.mo13475e(4, this.Desc);
            }
            AppMethodBeat.m2505o(111568);
            return 0;
        } else if (i == 1) {
            if (this.mZk != null) {
                ix = C6087a.m9557ix(1, this.mZk.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.naM != null) {
                ix += C6087a.m9557ix(2, this.naM.computeSize());
            }
            if (this.naN != null) {
                ix += C6087a.m9557ix(3, this.naN.computeSize());
            }
            if (this.Desc != null) {
                ix += C6091a.m9575f(4, this.Desc);
            }
            AppMethodBeat.m2505o(111568);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.mZk == null) {
                c6092b = new C6092b("Not all required fields were included: AppItem");
                AppMethodBeat.m2505o(111568);
                throw c6092b;
            }
            AppMethodBeat.m2505o(111568);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C6930ae c6930ae = (C6930ae) objArr[1];
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
                        C45998e c45998e = new C45998e();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c45998e.populateBuilderWithField(c6086a3, c45998e, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c6930ae.mZk = c45998e;
                    }
                    AppMethodBeat.m2505o(111568);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C28181ag c28181ag = new C28181ag();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c28181ag.populateBuilderWithField(c6086a3, c28181ag, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c6930ae.naM = c28181ag;
                    }
                    AppMethodBeat.m2505o(111568);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C6931af c6931af = new C6931af();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c6931af.populateBuilderWithField(c6086a3, c6931af, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c6930ae.naN = c6931af;
                    }
                    AppMethodBeat.m2505o(111568);
                    return 0;
                case 4:
                    c6930ae.Desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111568);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111568);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111568);
            return -1;
        }
    }
}
