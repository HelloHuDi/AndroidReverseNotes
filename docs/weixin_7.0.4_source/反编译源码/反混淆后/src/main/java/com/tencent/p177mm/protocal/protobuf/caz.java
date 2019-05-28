package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.caz */
public final class caz extends C1331a {
    public long endTime = -1;
    public String feedId;
    public int height = -1;
    public int iev = -1;
    public int lqq = 0;
    public boolean pCS = false;
    public int qDY = -1;
    public int rBZ = 0;
    public long startTime = -1;
    public int xae = 0;
    public int xaf = -1;
    public LinkedList<aby> xag = new LinkedList();
    public long xah = 0;
    public double xai = 0.0d;
    public double xaj = 0.0d;
    /* renamed from: y */
    public int f17916y = -1;

    public caz() {
        AppMethodBeat.m2504i(73655);
        AppMethodBeat.m2505o(73655);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(73656);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.feedId != null) {
                c6093a.mo13475e(1, this.feedId);
            }
            c6093a.mo13480iz(2, this.f17916y);
            c6093a.mo13480iz(3, this.height);
            c6093a.mo13480iz(4, this.iev);
            c6093a.mo13480iz(5, this.xae);
            c6093a.mo13480iz(6, this.qDY);
            c6093a.mo13480iz(7, this.xaf);
            c6093a.mo13480iz(8, this.lqq);
            c6093a.mo13480iz(9, this.rBZ);
            c6093a.mo13471aO(10, this.pCS);
            c6093a.mo13472ai(11, this.startTime);
            c6093a.mo13472ai(12, this.endTime);
            c6093a.mo13474e(13, 8, this.xag);
            c6093a.mo13472ai(14, this.xah);
            c6093a.mo13476f(15, this.xai);
            c6093a.mo13476f(16, this.xaj);
            AppMethodBeat.m2505o(73656);
            return 0;
        } else if (i == 1) {
            if (this.feedId != null) {
                f = C6091a.m9575f(1, this.feedId) + 0;
            } else {
                f = 0;
            }
            int bs = ((((((((((((((f + C6091a.m9572bs(2, this.f17916y)) + C6091a.m9572bs(3, this.height)) + C6091a.m9572bs(4, this.iev)) + C6091a.m9572bs(5, this.xae)) + C6091a.m9572bs(6, this.qDY)) + C6091a.m9572bs(7, this.xaf)) + C6091a.m9572bs(8, this.lqq)) + C6091a.m9572bs(9, this.rBZ)) + (C6091a.m9576fv(10) + 1)) + C6091a.m9578o(11, this.startTime)) + C6091a.m9578o(12, this.endTime)) + C6087a.m9552c(13, 8, this.xag)) + C6091a.m9578o(14, this.xah)) + (C6091a.m9576fv(15) + 8)) + (C6091a.m9576fv(16) + 8);
            AppMethodBeat.m2505o(73656);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xag.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(73656);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            caz caz = (caz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    caz.feedId = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73656);
                    return 0;
                case 2:
                    caz.f17916y = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73656);
                    return 0;
                case 3:
                    caz.height = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73656);
                    return 0;
                case 4:
                    caz.iev = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73656);
                    return 0;
                case 5:
                    caz.xae = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73656);
                    return 0;
                case 6:
                    caz.qDY = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73656);
                    return 0;
                case 7:
                    caz.xaf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73656);
                    return 0;
                case 8:
                    caz.lqq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73656);
                    return 0;
                case 9:
                    caz.rBZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73656);
                    return 0;
                case 10:
                    caz.pCS = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(73656);
                    return 0;
                case 11:
                    caz.startTime = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(73656);
                    return 0;
                case 12:
                    caz.endTime = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(73656);
                    return 0;
                case 13:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aby aby = new aby();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = aby.populateBuilderWithField(c6086a3, aby, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        caz.xag.add(aby);
                    }
                    AppMethodBeat.m2505o(73656);
                    return 0;
                case 14:
                    caz.xah = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(73656);
                    return 0;
                case 15:
                    caz.xai = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(73656);
                    return 0;
                case 16:
                    caz.xaj = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(73656);
                    return 0;
                default:
                    AppMethodBeat.m2505o(73656);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(73656);
            return -1;
        }
    }
}
