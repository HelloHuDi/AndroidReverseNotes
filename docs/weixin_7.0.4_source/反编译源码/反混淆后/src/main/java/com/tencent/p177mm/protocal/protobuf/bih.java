package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bih */
public final class bih extends C1331a {
    public String vCb;
    public String wLA;
    public int wLB;
    public LinkedList<C7275np> wLC = new LinkedList();
    public String wLD;
    public String wLE;
    public String wLy;
    public String wLz;

    public bih() {
        AppMethodBeat.m2504i(89114);
        AppMethodBeat.m2505o(89114);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(89115);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vCb != null) {
                c6093a.mo13475e(1, this.vCb);
            }
            if (this.wLy != null) {
                c6093a.mo13475e(2, this.wLy);
            }
            if (this.wLz != null) {
                c6093a.mo13475e(3, this.wLz);
            }
            if (this.wLA != null) {
                c6093a.mo13475e(4, this.wLA);
            }
            c6093a.mo13480iz(5, this.wLB);
            c6093a.mo13474e(6, 8, this.wLC);
            if (this.wLD != null) {
                c6093a.mo13475e(7, this.wLD);
            }
            if (this.wLE != null) {
                c6093a.mo13475e(8, this.wLE);
            }
            AppMethodBeat.m2505o(89115);
            return 0;
        } else if (i == 1) {
            if (this.vCb != null) {
                f = C6091a.m9575f(1, this.vCb) + 0;
            } else {
                f = 0;
            }
            if (this.wLy != null) {
                f += C6091a.m9575f(2, this.wLy);
            }
            if (this.wLz != null) {
                f += C6091a.m9575f(3, this.wLz);
            }
            if (this.wLA != null) {
                f += C6091a.m9575f(4, this.wLA);
            }
            f = (f + C6091a.m9572bs(5, this.wLB)) + C6087a.m9552c(6, 8, this.wLC);
            if (this.wLD != null) {
                f += C6091a.m9575f(7, this.wLD);
            }
            if (this.wLE != null) {
                f += C6091a.m9575f(8, this.wLE);
            }
            AppMethodBeat.m2505o(89115);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wLC.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(89115);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bih bih = (bih) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bih.vCb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89115);
                    return 0;
                case 2:
                    bih.wLy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89115);
                    return 0;
                case 3:
                    bih.wLz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89115);
                    return 0;
                case 4:
                    bih.wLA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89115);
                    return 0;
                case 5:
                    bih.wLB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89115);
                    return 0;
                case 6:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7275np c7275np = new C7275np();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c7275np.populateBuilderWithField(c6086a3, c7275np, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bih.wLC.add(c7275np);
                    }
                    AppMethodBeat.m2505o(89115);
                    return 0;
                case 7:
                    bih.wLD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89115);
                    return 0;
                case 8:
                    bih.wLE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89115);
                    return 0;
                default:
                    AppMethodBeat.m2505o(89115);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(89115);
            return -1;
        }
    }
}
