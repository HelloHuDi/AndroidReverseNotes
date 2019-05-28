package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.css */
public final class css extends bsr {
    public String cvF;
    public int scene;
    public int tZU;
    public double xpX;
    public double xpY;
    public String xpZ;
    public LinkedList<cml> xqa = new LinkedList();

    public css() {
        AppMethodBeat.m2504i(93806);
        AppMethodBeat.m2505o(93806);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(93807);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13476f(2, this.xpX);
            c6093a.mo13476f(3, this.xpY);
            if (this.xpZ != null) {
                c6093a.mo13475e(4, this.xpZ);
            }
            c6093a.mo13480iz(5, this.tZU);
            if (this.cvF != null) {
                c6093a.mo13475e(6, this.cvF);
            }
            c6093a.mo13480iz(7, this.scene);
            c6093a.mo13474e(8, 8, this.xqa);
            AppMethodBeat.m2505o(93807);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + (C6091a.m9576fv(2) + 8)) + (C6091a.m9576fv(3) + 8);
            if (this.xpZ != null) {
                ix += C6091a.m9575f(4, this.xpZ);
            }
            ix += C6091a.m9572bs(5, this.tZU);
            if (this.cvF != null) {
                ix += C6091a.m9575f(6, this.cvF);
            }
            int bs = (ix + C6091a.m9572bs(7, this.scene)) + C6087a.m9552c(8, 8, this.xqa);
            AppMethodBeat.m2505o(93807);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xqa.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(93807);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            css css = (css) objArr[1];
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
                        C7267hl c7267hl = new C7267hl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        css.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(93807);
                    return 0;
                case 2:
                    css.xpX = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(93807);
                    return 0;
                case 3:
                    css.xpY = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(93807);
                    return 0;
                case 4:
                    css.xpZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(93807);
                    return 0;
                case 5:
                    css.tZU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(93807);
                    return 0;
                case 6:
                    css.cvF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(93807);
                    return 0;
                case 7:
                    css.scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(93807);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cml cml = new cml();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cml.populateBuilderWithField(c6086a3, cml, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        css.xqa.add(cml);
                    }
                    AppMethodBeat.m2505o(93807);
                    return 0;
                default:
                    AppMethodBeat.m2505o(93807);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(93807);
            return -1;
        }
    }
}
