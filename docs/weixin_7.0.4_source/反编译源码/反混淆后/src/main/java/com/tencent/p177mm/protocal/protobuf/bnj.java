package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bnj */
public final class bnj extends btd {
    public String cIY;
    public int iAd;
    public int kdT;
    public String kdU;
    public String kdf;
    public String vAh;
    public long wch;
    public chl woi;
    public btn wxm;
    public long wxq;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48933);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(48933);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.kdT);
            if (this.kdU != null) {
                c6093a.mo13475e(3, this.kdU);
            }
            if (this.vAh != null) {
                c6093a.mo13475e(4, this.vAh);
            }
            c6093a.mo13472ai(5, this.wxq);
            c6093a.mo13472ai(6, this.wch);
            if (this.wxm != null) {
                c6093a.mo13479iy(7, this.wxm.computeSize());
                this.wxm.writeFields(c6093a);
            }
            if (this.woi != null) {
                c6093a.mo13479iy(8, this.woi.computeSize());
                this.woi.writeFields(c6093a);
            }
            if (this.kdf != null) {
                c6093a.mo13475e(9, this.kdf);
            }
            c6093a.mo13480iz(10, this.iAd);
            if (this.cIY != null) {
                c6093a.mo13475e(11, this.cIY);
            }
            AppMethodBeat.m2505o(48933);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.kdT);
            if (this.kdU != null) {
                ix += C6091a.m9575f(3, this.kdU);
            }
            if (this.vAh != null) {
                ix += C6091a.m9575f(4, this.vAh);
            }
            ix = (ix + C6091a.m9578o(5, this.wxq)) + C6091a.m9578o(6, this.wch);
            if (this.wxm != null) {
                ix += C6087a.m9557ix(7, this.wxm.computeSize());
            }
            if (this.woi != null) {
                ix += C6087a.m9557ix(8, this.woi.computeSize());
            }
            if (this.kdf != null) {
                ix += C6091a.m9575f(9, this.kdf);
            }
            ix += C6091a.m9572bs(10, this.iAd);
            if (this.cIY != null) {
                ix += C6091a.m9575f(11, this.cIY);
            }
            AppMethodBeat.m2505o(48933);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(48933);
                throw c6092b;
            }
            AppMethodBeat.m2505o(48933);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bnj bnj = (bnj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
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
                        bnj.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(48933);
                    return 0;
                case 2:
                    bnj.kdT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48933);
                    return 0;
                case 3:
                    bnj.kdU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48933);
                    return 0;
                case 4:
                    bnj.vAh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48933);
                    return 0;
                case 5:
                    bnj.wxq = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(48933);
                    return 0;
                case 6:
                    bnj.wch = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(48933);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btn btn = new btn();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = btn.populateBuilderWithField(c6086a3, btn, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bnj.wxm = btn;
                    }
                    AppMethodBeat.m2505o(48933);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        chl chl = new chl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = chl.populateBuilderWithField(c6086a3, chl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bnj.woi = chl;
                    }
                    AppMethodBeat.m2505o(48933);
                    return 0;
                case 9:
                    bnj.kdf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48933);
                    return 0;
                case 10:
                    bnj.iAd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48933);
                    return 0;
                case 11:
                    bnj.cIY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48933);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48933);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48933);
            return -1;
        }
    }
}
