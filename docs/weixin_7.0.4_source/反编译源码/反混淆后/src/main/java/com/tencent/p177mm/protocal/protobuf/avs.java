package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.avs */
public final class avs extends bsr {
    public String csB;
    public String cvO;
    public String signature;
    public String url;
    public String wzd;
    public String wzf;
    public String wzg;
    public C1332b wzh;
    public int wzi;
    public LinkedList<awg> wzm = new LinkedList();

    public avs() {
        AppMethodBeat.m2504i(10209);
        AppMethodBeat.m2505o(10209);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(10210);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.url != null) {
                c6093a.mo13475e(2, this.url);
            }
            if (this.csB != null) {
                c6093a.mo13475e(3, this.csB);
            }
            if (this.wzd != null) {
                c6093a.mo13475e(4, this.wzd);
            }
            if (this.cvO != null) {
                c6093a.mo13475e(5, this.cvO);
            }
            if (this.wzf != null) {
                c6093a.mo13475e(6, this.wzf);
            }
            if (this.signature != null) {
                c6093a.mo13475e(7, this.signature);
            }
            if (this.wzg != null) {
                c6093a.mo13475e(8, this.wzg);
            }
            if (this.wzh != null) {
                c6093a.mo13473c(9, this.wzh);
            }
            c6093a.mo13480iz(10, this.wzi);
            c6093a.mo13474e(11, 8, this.wzm);
            AppMethodBeat.m2505o(10210);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.url != null) {
                ix += C6091a.m9575f(2, this.url);
            }
            if (this.csB != null) {
                ix += C6091a.m9575f(3, this.csB);
            }
            if (this.wzd != null) {
                ix += C6091a.m9575f(4, this.wzd);
            }
            if (this.cvO != null) {
                ix += C6091a.m9575f(5, this.cvO);
            }
            if (this.wzf != null) {
                ix += C6091a.m9575f(6, this.wzf);
            }
            if (this.signature != null) {
                ix += C6091a.m9575f(7, this.signature);
            }
            if (this.wzg != null) {
                ix += C6091a.m9575f(8, this.wzg);
            }
            if (this.wzh != null) {
                ix += C6091a.m9571b(9, this.wzh);
            }
            int bs = (ix + C6091a.m9572bs(10, this.wzi)) + C6087a.m9552c(11, 8, this.wzm);
            AppMethodBeat.m2505o(10210);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wzm.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(10210);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            avs avs = (avs) objArr[1];
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
                        avs.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(10210);
                    return 0;
                case 2:
                    avs.url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10210);
                    return 0;
                case 3:
                    avs.csB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10210);
                    return 0;
                case 4:
                    avs.wzd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10210);
                    return 0;
                case 5:
                    avs.cvO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10210);
                    return 0;
                case 6:
                    avs.wzf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10210);
                    return 0;
                case 7:
                    avs.signature = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10210);
                    return 0;
                case 8:
                    avs.wzg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10210);
                    return 0;
                case 9:
                    avs.wzh = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(10210);
                    return 0;
                case 10:
                    avs.wzi = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(10210);
                    return 0;
                case 11:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        awg awg = new awg();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = awg.populateBuilderWithField(c6086a3, awg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        avs.wzm.add(awg);
                    }
                    AppMethodBeat.m2505o(10210);
                    return 0;
                default:
                    AppMethodBeat.m2505o(10210);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(10210);
            return -1;
        }
    }
}
