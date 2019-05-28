package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.fs */
public final class C35918fs extends C1331a {
    public String ProductID;
    public String vBa;
    public EmotionPrice vHC;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(62509);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.ProductID == null) {
                c6092b = new C6092b("Not all required fields were included: ProductID");
                AppMethodBeat.m2505o(62509);
                throw c6092b;
            } else if (this.vHC == null) {
                c6092b = new C6092b("Not all required fields were included: Price");
                AppMethodBeat.m2505o(62509);
                throw c6092b;
            } else {
                if (this.ProductID != null) {
                    c6093a.mo13475e(1, this.ProductID);
                }
                if (this.vHC != null) {
                    c6093a.mo13479iy(2, this.vHC.computeSize());
                    this.vHC.writeFields(c6093a);
                }
                if (this.vBa != null) {
                    c6093a.mo13475e(3, this.vBa);
                }
                AppMethodBeat.m2505o(62509);
                return 0;
            }
        } else if (i == 1) {
            if (this.ProductID != null) {
                f = C6091a.m9575f(1, this.ProductID) + 0;
            } else {
                f = 0;
            }
            if (this.vHC != null) {
                f += C6087a.m9557ix(2, this.vHC.computeSize());
            }
            if (this.vBa != null) {
                f += C6091a.m9575f(3, this.vBa);
            }
            AppMethodBeat.m2505o(62509);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.ProductID == null) {
                c6092b = new C6092b("Not all required fields were included: ProductID");
                AppMethodBeat.m2505o(62509);
                throw c6092b;
            } else if (this.vHC == null) {
                c6092b = new C6092b("Not all required fields were included: Price");
                AppMethodBeat.m2505o(62509);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(62509);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C35918fs c35918fs = (C35918fs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c35918fs.ProductID = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62509);
                    return 0;
                case 2:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        EmotionPrice emotionPrice = new EmotionPrice();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = emotionPrice.populateBuilderWithField(c6086a3, emotionPrice, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35918fs.vHC = emotionPrice;
                    }
                    AppMethodBeat.m2505o(62509);
                    return 0;
                case 3:
                    c35918fs.vBa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62509);
                    return 0;
                default:
                    AppMethodBeat.m2505o(62509);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(62509);
            return -1;
        }
    }
}
