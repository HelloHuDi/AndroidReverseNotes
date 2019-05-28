package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bjj */
public final class bjj extends C1331a {
    public String fFZ;
    public String pQe;
    public String pcl;
    public int wMI;
    public String wMJ;
    public int wMK;
    public String wML;
    public int wMM;
    public String wMN;
    public long wMO;
    public LinkedList<bja> wMP = new LinkedList();
    public String wyq;

    public bjj() {
        AppMethodBeat.m2504i(56898);
        AppMethodBeat.m2505o(56898);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56899);
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.wMI);
            if (this.wMJ != null) {
                c6093a.mo13475e(2, this.wMJ);
            }
            if (this.wyq != null) {
                c6093a.mo13475e(3, this.wyq);
            }
            c6093a.mo13480iz(4, this.wMK);
            if (this.pcl != null) {
                c6093a.mo13475e(5, this.pcl);
            }
            if (this.wML != null) {
                c6093a.mo13475e(6, this.wML);
            }
            if (this.pQe != null) {
                c6093a.mo13475e(7, this.pQe);
            }
            c6093a.mo13480iz(8, this.wMM);
            if (this.fFZ != null) {
                c6093a.mo13475e(9, this.fFZ);
            }
            if (this.wMN != null) {
                c6093a.mo13475e(10, this.wMN);
            }
            c6093a.mo13472ai(11, this.wMO);
            c6093a.mo13474e(12, 8, this.wMP);
            AppMethodBeat.m2505o(56899);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.wMI) + 0;
            if (this.wMJ != null) {
                bs += C6091a.m9575f(2, this.wMJ);
            }
            if (this.wyq != null) {
                bs += C6091a.m9575f(3, this.wyq);
            }
            bs += C6091a.m9572bs(4, this.wMK);
            if (this.pcl != null) {
                bs += C6091a.m9575f(5, this.pcl);
            }
            if (this.wML != null) {
                bs += C6091a.m9575f(6, this.wML);
            }
            if (this.pQe != null) {
                bs += C6091a.m9575f(7, this.pQe);
            }
            bs += C6091a.m9572bs(8, this.wMM);
            if (this.fFZ != null) {
                bs += C6091a.m9575f(9, this.fFZ);
            }
            if (this.wMN != null) {
                bs += C6091a.m9575f(10, this.wMN);
            }
            bs = (bs + C6091a.m9578o(11, this.wMO)) + C6087a.m9552c(12, 8, this.wMP);
            AppMethodBeat.m2505o(56899);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wMP.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56899);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bjj bjj = (bjj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bjj.wMI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56899);
                    return 0;
                case 2:
                    bjj.wMJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56899);
                    return 0;
                case 3:
                    bjj.wyq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56899);
                    return 0;
                case 4:
                    bjj.wMK = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56899);
                    return 0;
                case 5:
                    bjj.pcl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56899);
                    return 0;
                case 6:
                    bjj.wML = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56899);
                    return 0;
                case 7:
                    bjj.pQe = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56899);
                    return 0;
                case 8:
                    bjj.wMM = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56899);
                    return 0;
                case 9:
                    bjj.fFZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56899);
                    return 0;
                case 10:
                    bjj.wMN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56899);
                    return 0;
                case 11:
                    bjj.wMO = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56899);
                    return 0;
                case 12:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bja bja = new bja();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bja.populateBuilderWithField(c6086a3, bja, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bjj.wMP.add(bja);
                    }
                    AppMethodBeat.m2505o(56899);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56899);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56899);
            return -1;
        }
    }
}
