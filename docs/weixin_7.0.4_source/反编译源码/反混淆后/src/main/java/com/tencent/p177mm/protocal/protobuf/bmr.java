package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bmr */
public final class bmr extends bsr {
    public long appid;
    public int cuy;
    public int platform;
    public int scene;
    public long vNx;
    public String wMv;
    public int wPC;
    public long wPD;
    public int wPE;
    public long wPF;
    public long wPG;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(11794);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.wPC);
            c6093a.mo13472ai(3, this.wPD);
            c6093a.mo13472ai(4, this.appid);
            c6093a.mo13472ai(5, this.vNx);
            c6093a.mo13480iz(6, this.wPE);
            c6093a.mo13480iz(7, this.scene);
            c6093a.mo13480iz(8, this.cuy);
            c6093a.mo13472ai(9, this.wPF);
            c6093a.mo13472ai(10, this.wPG);
            c6093a.mo13480iz(11, this.platform);
            if (this.wMv != null) {
                c6093a.mo13475e(12, this.wMv);
            }
            AppMethodBeat.m2505o(11794);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (((((((((ix + C6091a.m9572bs(2, this.wPC)) + C6091a.m9578o(3, this.wPD)) + C6091a.m9578o(4, this.appid)) + C6091a.m9578o(5, this.vNx)) + C6091a.m9572bs(6, this.wPE)) + C6091a.m9572bs(7, this.scene)) + C6091a.m9572bs(8, this.cuy)) + C6091a.m9578o(9, this.wPF)) + C6091a.m9578o(10, this.wPG)) + C6091a.m9572bs(11, this.platform);
            if (this.wMv != null) {
                ix += C6091a.m9575f(12, this.wMv);
            }
            AppMethodBeat.m2505o(11794);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(11794);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bmr bmr = (bmr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C7267hl c7267hl = new C7267hl();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bmr.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(11794);
                    return 0;
                case 2:
                    bmr.wPC = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11794);
                    return 0;
                case 3:
                    bmr.wPD = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(11794);
                    return 0;
                case 4:
                    bmr.appid = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(11794);
                    return 0;
                case 5:
                    bmr.vNx = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(11794);
                    return 0;
                case 6:
                    bmr.wPE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11794);
                    return 0;
                case 7:
                    bmr.scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11794);
                    return 0;
                case 8:
                    bmr.cuy = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11794);
                    return 0;
                case 9:
                    bmr.wPF = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(11794);
                    return 0;
                case 10:
                    bmr.wPG = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(11794);
                    return 0;
                case 11:
                    bmr.platform = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11794);
                    return 0;
                case 12:
                    bmr.wMv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11794);
                    return 0;
                default:
                    AppMethodBeat.m2505o(11794);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(11794);
            return -1;
        }
    }
}
