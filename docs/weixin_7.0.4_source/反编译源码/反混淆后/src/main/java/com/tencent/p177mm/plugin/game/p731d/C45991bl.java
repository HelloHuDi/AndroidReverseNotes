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

/* renamed from: com.tencent.mm.plugin.game.d.bl */
public final class C45991bl extends bsr {
    public String guW;
    public LinkedList<String> nbX = new LinkedList();
    public String nbs;
    public int ncn;
    public int nco;
    public int ncp;
    public boolean ncq;

    public C45991bl() {
        AppMethodBeat.m2504i(111612);
        AppMethodBeat.m2505o(111612);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111613);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.nbs == null) {
                c6092b = new C6092b("Not all required fields were included: Lang");
                AppMethodBeat.m2505o(111613);
                throw c6092b;
            }
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.ncn);
            c6093a.mo13480iz(3, this.nco);
            if (this.nbs != null) {
                c6093a.mo13475e(4, this.nbs);
            }
            c6093a.mo13474e(5, 1, this.nbX);
            if (this.guW != null) {
                c6093a.mo13475e(6, this.guW);
            }
            c6093a.mo13480iz(7, this.ncp);
            c6093a.mo13471aO(8, this.ncq);
            AppMethodBeat.m2505o(111613);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + C6091a.m9572bs(2, this.ncn)) + C6091a.m9572bs(3, this.nco);
            if (this.nbs != null) {
                ix += C6091a.m9575f(4, this.nbs);
            }
            ix += C6087a.m9552c(5, 1, this.nbX);
            if (this.guW != null) {
                ix += C6091a.m9575f(6, this.guW);
            }
            int bs = (ix + C6091a.m9572bs(7, this.ncp)) + (C6091a.m9576fv(8) + 1);
            AppMethodBeat.m2505o(111613);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.nbX.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.nbs == null) {
                c6092b = new C6092b("Not all required fields were included: Lang");
                AppMethodBeat.m2505o(111613);
                throw c6092b;
            }
            AppMethodBeat.m2505o(111613);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C45991bl c45991bl = (C45991bl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7267hl c7267hl = new C7267hl();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c45991bl.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(111613);
                    return 0;
                case 2:
                    c45991bl.ncn = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(111613);
                    return 0;
                case 3:
                    c45991bl.nco = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(111613);
                    return 0;
                case 4:
                    c45991bl.nbs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111613);
                    return 0;
                case 5:
                    c45991bl.nbX.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(111613);
                    return 0;
                case 6:
                    c45991bl.guW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111613);
                    return 0;
                case 7:
                    c45991bl.ncp = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(111613);
                    return 0;
                case 8:
                    c45991bl.ncq = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(111613);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111613);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111613);
            return -1;
        }
    }
}
