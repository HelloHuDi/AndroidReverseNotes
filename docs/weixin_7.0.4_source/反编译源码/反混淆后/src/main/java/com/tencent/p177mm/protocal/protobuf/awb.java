package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.awb */
public final class awb extends btd {
    public String guQ;
    public String ncH;
    public String vAN;
    public String vBa;
    public String vDm;
    public LinkedList<buj> wlE = new LinkedList();
    public avi wzH;
    public String wzN;
    public String wzO;
    public String wzP;
    public int wzQ;

    public awb() {
        AppMethodBeat.m2504i(96264);
        AppMethodBeat.m2505o(96264);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(96265);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(96265);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            if (this.wzH != null) {
                c6093a.mo13479iy(2, this.wzH.computeSize());
                this.wzH.writeFields(c6093a);
            }
            if (this.wzO != null) {
                c6093a.mo13475e(3, this.wzO);
            }
            c6093a.mo13474e(4, 8, this.wlE);
            if (this.ncH != null) {
                c6093a.mo13475e(5, this.ncH);
            }
            if (this.vDm != null) {
                c6093a.mo13475e(6, this.vDm);
            }
            if (this.vBa != null) {
                c6093a.mo13475e(7, this.vBa);
            }
            if (this.vAN != null) {
                c6093a.mo13475e(8, this.vAN);
            }
            if (this.wzP != null) {
                c6093a.mo13475e(9, this.wzP);
            }
            c6093a.mo13480iz(10, this.wzQ);
            if (this.wzN != null) {
                c6093a.mo13475e(11, this.wzN);
            }
            if (this.guQ != null) {
                c6093a.mo13475e(12, this.guQ);
            }
            AppMethodBeat.m2505o(96265);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wzH != null) {
                ix += C6087a.m9557ix(2, this.wzH.computeSize());
            }
            if (this.wzO != null) {
                ix += C6091a.m9575f(3, this.wzO);
            }
            ix += C6087a.m9552c(4, 8, this.wlE);
            if (this.ncH != null) {
                ix += C6091a.m9575f(5, this.ncH);
            }
            if (this.vDm != null) {
                ix += C6091a.m9575f(6, this.vDm);
            }
            if (this.vBa != null) {
                ix += C6091a.m9575f(7, this.vBa);
            }
            if (this.vAN != null) {
                ix += C6091a.m9575f(8, this.vAN);
            }
            if (this.wzP != null) {
                ix += C6091a.m9575f(9, this.wzP);
            }
            ix += C6091a.m9572bs(10, this.wzQ);
            if (this.wzN != null) {
                ix += C6091a.m9575f(11, this.wzN);
            }
            if (this.guQ != null) {
                ix += C6091a.m9575f(12, this.guQ);
            }
            AppMethodBeat.m2505o(96265);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wlE.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(96265);
                throw c6092b;
            }
            AppMethodBeat.m2505o(96265);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            awb awb = (awb) objArr[1];
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
                        BaseResponse baseResponse = new BaseResponse();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(c6086a3, baseResponse, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        awb.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(96265);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        avi avi = new avi();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = avi.populateBuilderWithField(c6086a3, avi, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        awb.wzH = avi;
                    }
                    AppMethodBeat.m2505o(96265);
                    return 0;
                case 3:
                    awb.wzO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96265);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        buj buj = new buj();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = buj.populateBuilderWithField(c6086a3, buj, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        awb.wlE.add(buj);
                    }
                    AppMethodBeat.m2505o(96265);
                    return 0;
                case 5:
                    awb.ncH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96265);
                    return 0;
                case 6:
                    awb.vDm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96265);
                    return 0;
                case 7:
                    awb.vBa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96265);
                    return 0;
                case 8:
                    awb.vAN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96265);
                    return 0;
                case 9:
                    awb.wzP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96265);
                    return 0;
                case 10:
                    awb.wzQ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96265);
                    return 0;
                case 11:
                    awb.wzN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96265);
                    return 0;
                case 12:
                    awb.guQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96265);
                    return 0;
                default:
                    AppMethodBeat.m2505o(96265);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(96265);
            return -1;
        }
    }
}
