package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.asj */
public final class asj extends C1331a {
    public String cIY;
    public int iAd;
    public String kdf;
    public String kfM;
    public asi wpr;
    public boolean wvW;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48864);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.kdf != null) {
                c6093a.mo13475e(1, this.kdf);
            }
            if (this.kfM != null) {
                c6093a.mo13475e(2, this.kfM);
            }
            if (this.cIY != null) {
                c6093a.mo13475e(3, this.cIY);
            }
            c6093a.mo13471aO(4, this.wvW);
            c6093a.mo13480iz(5, this.iAd);
            if (this.wpr != null) {
                c6093a.mo13479iy(6, this.wpr.computeSize());
                this.wpr.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(48864);
            return 0;
        } else if (i == 1) {
            if (this.kdf != null) {
                f = C6091a.m9575f(1, this.kdf) + 0;
            } else {
                f = 0;
            }
            if (this.kfM != null) {
                f += C6091a.m9575f(2, this.kfM);
            }
            if (this.cIY != null) {
                f += C6091a.m9575f(3, this.cIY);
            }
            f = (f + (C6091a.m9576fv(4) + 1)) + C6091a.m9572bs(5, this.iAd);
            if (this.wpr != null) {
                f += C6087a.m9557ix(6, this.wpr.computeSize());
            }
            AppMethodBeat.m2505o(48864);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48864);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            asj asj = (asj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    asj.kdf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48864);
                    return 0;
                case 2:
                    asj.kfM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48864);
                    return 0;
                case 3:
                    asj.cIY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48864);
                    return 0;
                case 4:
                    asj.wvW = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(48864);
                    return 0;
                case 5:
                    asj.iAd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48864);
                    return 0;
                case 6:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        asi asi = new asi();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = asi.populateBuilderWithField(c6086a3, asi, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        asj.wpr = asi;
                    }
                    AppMethodBeat.m2505o(48864);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48864);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48864);
            return -1;
        }
    }
}
