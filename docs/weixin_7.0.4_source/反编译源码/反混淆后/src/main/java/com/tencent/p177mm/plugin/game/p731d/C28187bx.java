package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.bx */
public final class C28187bx extends C1331a {
    public C43165cg mZE;
    public String mZj;
    public String mZr;
    public String ncG;
    public String ncH;
    public String ncI;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111631);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.mZr != null) {
                c6093a.mo13475e(1, this.mZr);
            }
            if (this.ncG != null) {
                c6093a.mo13475e(2, this.ncG);
            }
            if (this.ncH != null) {
                c6093a.mo13475e(3, this.ncH);
            }
            if (this.ncI != null) {
                c6093a.mo13475e(4, this.ncI);
            }
            if (this.mZE != null) {
                c6093a.mo13479iy(5, this.mZE.computeSize());
                this.mZE.writeFields(c6093a);
            }
            if (this.mZj != null) {
                c6093a.mo13475e(6, this.mZj);
            }
            AppMethodBeat.m2505o(111631);
            return 0;
        } else if (i == 1) {
            if (this.mZr != null) {
                f = C6091a.m9575f(1, this.mZr) + 0;
            } else {
                f = 0;
            }
            if (this.ncG != null) {
                f += C6091a.m9575f(2, this.ncG);
            }
            if (this.ncH != null) {
                f += C6091a.m9575f(3, this.ncH);
            }
            if (this.ncI != null) {
                f += C6091a.m9575f(4, this.ncI);
            }
            if (this.mZE != null) {
                f += C6087a.m9557ix(5, this.mZE.computeSize());
            }
            if (this.mZj != null) {
                f += C6091a.m9575f(6, this.mZj);
            }
            AppMethodBeat.m2505o(111631);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(111631);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C28187bx c28187bx = (C28187bx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c28187bx.mZr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111631);
                    return 0;
                case 2:
                    c28187bx.ncG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111631);
                    return 0;
                case 3:
                    c28187bx.ncH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111631);
                    return 0;
                case 4:
                    c28187bx.ncI = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111631);
                    return 0;
                case 5:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C43165cg c43165cg = new C43165cg();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c43165cg.populateBuilderWithField(c6086a3, c43165cg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c28187bx.mZE = c43165cg;
                    }
                    AppMethodBeat.m2505o(111631);
                    return 0;
                case 6:
                    c28187bx.mZj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111631);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111631);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111631);
            return -1;
        }
    }
}
