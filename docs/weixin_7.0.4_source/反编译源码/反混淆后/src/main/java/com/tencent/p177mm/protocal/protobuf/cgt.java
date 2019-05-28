package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cgt */
public final class cgt extends C1331a {
    public float size;
    public String text;
    public btr vCP;
    public String vJS;
    public long xfA;
    public String xfB;
    public int xfC;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48969);
        int o;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13472ai(1, this.xfA);
            if (this.xfB != null) {
                c6093a.mo13475e(2, this.xfB);
            }
            if (this.text != null) {
                c6093a.mo13475e(3, this.text);
            }
            c6093a.mo13481r(4, this.size);
            if (this.vCP != null) {
                c6093a.mo13479iy(5, this.vCP.computeSize());
                this.vCP.writeFields(c6093a);
            }
            c6093a.mo13480iz(6, this.xfC);
            if (this.vJS != null) {
                c6093a.mo13475e(7, this.vJS);
            }
            AppMethodBeat.m2505o(48969);
            return 0;
        } else if (i == 1) {
            o = C6091a.m9578o(1, this.xfA) + 0;
            if (this.xfB != null) {
                o += C6091a.m9575f(2, this.xfB);
            }
            if (this.text != null) {
                o += C6091a.m9575f(3, this.text);
            }
            o += C6091a.m9576fv(4) + 4;
            if (this.vCP != null) {
                o += C6087a.m9557ix(5, this.vCP.computeSize());
            }
            o += C6091a.m9572bs(6, this.xfC);
            if (this.vJS != null) {
                o += C6091a.m9575f(7, this.vJS);
            }
            AppMethodBeat.m2505o(48969);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (o = C1331a.getNextFieldNumber(c6086a); o > 0; o = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, o)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48969);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cgt cgt = (cgt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cgt.xfA = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(48969);
                    return 0;
                case 2:
                    cgt.xfB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48969);
                    return 0;
                case 3:
                    cgt.text = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48969);
                    return 0;
                case 4:
                    cgt.size = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(48969);
                    return 0;
                case 5:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        btr btr = new btr();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = btr.populateBuilderWithField(c6086a3, btr, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cgt.vCP = btr;
                    }
                    AppMethodBeat.m2505o(48969);
                    return 0;
                case 6:
                    cgt.xfC = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48969);
                    return 0;
                case 7:
                    cgt.vJS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48969);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48969);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48969);
            return -1;
        }
    }
}
