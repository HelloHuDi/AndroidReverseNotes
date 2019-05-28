package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.protocal.protobuf.C7267hl;
import com.tencent.p177mm.protocal.protobuf.bsr;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.ax */
public final class C20946ax extends bsr {
    public String guW;
    public String nbs;
    public int nbt;
    public C39195d nbu;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(116999);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.nbs == null) {
                c6092b = new C6092b("Not all required fields were included: Lang");
                AppMethodBeat.m2505o(116999);
                throw c6092b;
            }
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.nbs != null) {
                c6093a.mo13475e(2, this.nbs);
            }
            if (this.guW != null) {
                c6093a.mo13475e(3, this.guW);
            }
            c6093a.mo13480iz(4, this.nbt);
            if (this.nbu != null) {
                c6093a.mo13479iy(5, this.nbu.computeSize());
                this.nbu.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(116999);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.nbs != null) {
                ix += C6091a.m9575f(2, this.nbs);
            }
            if (this.guW != null) {
                ix += C6091a.m9575f(3, this.guW);
            }
            ix += C6091a.m9572bs(4, this.nbt);
            if (this.nbu != null) {
                ix += C6087a.m9557ix(5, this.nbu.computeSize());
            }
            AppMethodBeat.m2505o(116999);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.nbs == null) {
                c6092b = new C6092b("Not all required fields were included: Lang");
                AppMethodBeat.m2505o(116999);
                throw c6092b;
            }
            AppMethodBeat.m2505o(116999);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C20946ax c20946ax = (C20946ax) objArr[1];
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
                        C7267hl c7267hl = new C7267hl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c20946ax.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(116999);
                    return 0;
                case 2:
                    c20946ax.nbs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(116999);
                    return 0;
                case 3:
                    c20946ax.guW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(116999);
                    return 0;
                case 4:
                    c20946ax.nbt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116999);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C39195d c39195d = new C39195d();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c39195d.populateBuilderWithField(c6086a3, c39195d, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c20946ax.nbu = c39195d;
                    }
                    AppMethodBeat.m2505o(116999);
                    return 0;
                default:
                    AppMethodBeat.m2505o(116999);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(116999);
            return -1;
        }
    }
}
