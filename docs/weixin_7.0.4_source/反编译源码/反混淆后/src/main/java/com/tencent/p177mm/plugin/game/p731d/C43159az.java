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

/* renamed from: com.tencent.mm.plugin.game.d.az */
public final class C43159az extends bsr {
    public String guW;
    public String mZr;
    public boolean nbG;
    public boolean nbH;
    public boolean nbI;
    public String nbs;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111594);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.nbs == null) {
                c6092b = new C6092b("Not all required fields were included: Lang");
                AppMethodBeat.m2505o(111594);
                throw c6092b;
            } else if (this.mZr == null) {
                c6092b = new C6092b("Not all required fields were included: AppID");
                AppMethodBeat.m2505o(111594);
                throw c6092b;
            } else {
                if (this.BaseRequest != null) {
                    c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(c6093a);
                }
                if (this.nbs != null) {
                    c6093a.mo13475e(2, this.nbs);
                }
                if (this.mZr != null) {
                    c6093a.mo13475e(3, this.mZr);
                }
                c6093a.mo13471aO(4, this.nbG);
                if (this.guW != null) {
                    c6093a.mo13475e(5, this.guW);
                }
                c6093a.mo13471aO(6, this.nbH);
                c6093a.mo13471aO(7, this.nbI);
                AppMethodBeat.m2505o(111594);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.nbs != null) {
                ix += C6091a.m9575f(2, this.nbs);
            }
            if (this.mZr != null) {
                ix += C6091a.m9575f(3, this.mZr);
            }
            ix += C6091a.m9576fv(4) + 1;
            if (this.guW != null) {
                ix += C6091a.m9575f(5, this.guW);
            }
            int fv = (ix + (C6091a.m9576fv(6) + 1)) + (C6091a.m9576fv(7) + 1);
            AppMethodBeat.m2505o(111594);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.nbs == null) {
                c6092b = new C6092b("Not all required fields were included: Lang");
                AppMethodBeat.m2505o(111594);
                throw c6092b;
            } else if (this.mZr == null) {
                c6092b = new C6092b("Not all required fields were included: AppID");
                AppMethodBeat.m2505o(111594);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(111594);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C43159az c43159az = (C43159az) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C7267hl c7267hl = new C7267hl();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c43159az.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(111594);
                    return 0;
                case 2:
                    c43159az.nbs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111594);
                    return 0;
                case 3:
                    c43159az.mZr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111594);
                    return 0;
                case 4:
                    c43159az.nbG = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(111594);
                    return 0;
                case 5:
                    c43159az.guW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111594);
                    return 0;
                case 6:
                    c43159az.nbH = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(111594);
                    return 0;
                case 7:
                    c43159az.nbI = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(111594);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111594);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111594);
            return -1;
        }
    }
}
