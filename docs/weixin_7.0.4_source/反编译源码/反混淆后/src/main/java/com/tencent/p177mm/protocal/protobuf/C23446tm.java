package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.tm */
public final class C23446tm extends C1331a {
    public String kKZ;
    public String kbW;
    public String kbX;
    public String title;
    public String url;
    public String vTL;
    public String vTM;
    public long vUW;
    public String vUX;
    public String vUY;
    public arp waC;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(89052);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.title != null) {
                c6093a.mo13475e(1, this.title);
            }
            if (this.kbW != null) {
                c6093a.mo13475e(2, this.kbW);
            }
            if (this.kbX != null) {
                c6093a.mo13475e(3, this.kbX);
            }
            if (this.url != null) {
                c6093a.mo13475e(4, this.url);
            }
            c6093a.mo13472ai(5, this.vUW);
            if (this.vUX != null) {
                c6093a.mo13475e(6, this.vUX);
            }
            if (this.vUY != null) {
                c6093a.mo13475e(7, this.vUY);
            }
            if (this.kKZ != null) {
                c6093a.mo13475e(8, this.kKZ);
            }
            if (this.waC != null) {
                c6093a.mo13479iy(9, this.waC.computeSize());
                this.waC.writeFields(c6093a);
            }
            if (this.vTL != null) {
                c6093a.mo13475e(10, this.vTL);
            }
            if (this.vTM != null) {
                c6093a.mo13475e(11, this.vTM);
            }
            AppMethodBeat.m2505o(89052);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = C6091a.m9575f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.kbW != null) {
                f += C6091a.m9575f(2, this.kbW);
            }
            if (this.kbX != null) {
                f += C6091a.m9575f(3, this.kbX);
            }
            if (this.url != null) {
                f += C6091a.m9575f(4, this.url);
            }
            f += C6091a.m9578o(5, this.vUW);
            if (this.vUX != null) {
                f += C6091a.m9575f(6, this.vUX);
            }
            if (this.vUY != null) {
                f += C6091a.m9575f(7, this.vUY);
            }
            if (this.kKZ != null) {
                f += C6091a.m9575f(8, this.kKZ);
            }
            if (this.waC != null) {
                f += C6087a.m9557ix(9, this.waC.computeSize());
            }
            if (this.vTL != null) {
                f += C6091a.m9575f(10, this.vTL);
            }
            if (this.vTM != null) {
                f += C6091a.m9575f(11, this.vTM);
            }
            AppMethodBeat.m2505o(89052);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(89052);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23446tm c23446tm = (C23446tm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c23446tm.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89052);
                    return 0;
                case 2:
                    c23446tm.kbW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89052);
                    return 0;
                case 3:
                    c23446tm.kbX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89052);
                    return 0;
                case 4:
                    c23446tm.url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89052);
                    return 0;
                case 5:
                    c23446tm.vUW = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(89052);
                    return 0;
                case 6:
                    c23446tm.vUX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89052);
                    return 0;
                case 7:
                    c23446tm.vUY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89052);
                    return 0;
                case 8:
                    c23446tm.kKZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89052);
                    return 0;
                case 9:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        arp arp = new arp();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = arp.populateBuilderWithField(c6086a3, arp, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c23446tm.waC = arp;
                    }
                    AppMethodBeat.m2505o(89052);
                    return 0;
                case 10:
                    c23446tm.vTL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89052);
                    return 0;
                case 11:
                    c23446tm.vTM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89052);
                    return 0;
                default:
                    AppMethodBeat.m2505o(89052);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(89052);
            return -1;
        }
    }
}
