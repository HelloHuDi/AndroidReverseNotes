package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bnh */
public final class bnh extends btd {
    public String kbV;
    public int kdT;
    public String kdU;
    public String pbn;
    public String pbo;
    public String wQf;
    public String wQg;
    public C40548nc wQh;
    public String wQi;
    public String wQj;
    public cif wQk;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48931);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(48931);
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
            if (this.wQf != null) {
                c6093a.mo13475e(4, this.wQf);
            }
            if (this.kbV != null) {
                c6093a.mo13475e(5, this.kbV);
            }
            if (this.wQg != null) {
                c6093a.mo13475e(6, this.wQg);
            }
            if (this.wQh != null) {
                c6093a.mo13479iy(7, this.wQh.computeSize());
                this.wQh.writeFields(c6093a);
            }
            if (this.wQi != null) {
                c6093a.mo13475e(8, this.wQi);
            }
            if (this.pbo != null) {
                c6093a.mo13475e(9, this.pbo);
            }
            if (this.pbn != null) {
                c6093a.mo13475e(10, this.pbn);
            }
            if (this.wQj != null) {
                c6093a.mo13475e(11, this.wQj);
            }
            if (this.wQk != null) {
                c6093a.mo13479iy(12, this.wQk.computeSize());
                this.wQk.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(48931);
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
            if (this.wQf != null) {
                ix += C6091a.m9575f(4, this.wQf);
            }
            if (this.kbV != null) {
                ix += C6091a.m9575f(5, this.kbV);
            }
            if (this.wQg != null) {
                ix += C6091a.m9575f(6, this.wQg);
            }
            if (this.wQh != null) {
                ix += C6087a.m9557ix(7, this.wQh.computeSize());
            }
            if (this.wQi != null) {
                ix += C6091a.m9575f(8, this.wQi);
            }
            if (this.pbo != null) {
                ix += C6091a.m9575f(9, this.pbo);
            }
            if (this.pbn != null) {
                ix += C6091a.m9575f(10, this.pbn);
            }
            if (this.wQj != null) {
                ix += C6091a.m9575f(11, this.wQj);
            }
            if (this.wQk != null) {
                ix += C6087a.m9557ix(12, this.wQk.computeSize());
            }
            AppMethodBeat.m2505o(48931);
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
                AppMethodBeat.m2505o(48931);
                throw c6092b;
            }
            AppMethodBeat.m2505o(48931);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bnh bnh = (bnh) objArr[1];
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
                        bnh.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(48931);
                    return 0;
                case 2:
                    bnh.kdT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48931);
                    return 0;
                case 3:
                    bnh.kdU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48931);
                    return 0;
                case 4:
                    bnh.wQf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48931);
                    return 0;
                case 5:
                    bnh.kbV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48931);
                    return 0;
                case 6:
                    bnh.wQg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48931);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C40548nc c40548nc = new C40548nc();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c40548nc.populateBuilderWithField(c6086a3, c40548nc, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bnh.wQh = c40548nc;
                    }
                    AppMethodBeat.m2505o(48931);
                    return 0;
                case 8:
                    bnh.wQi = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48931);
                    return 0;
                case 9:
                    bnh.pbo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48931);
                    return 0;
                case 10:
                    bnh.pbn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48931);
                    return 0;
                case 11:
                    bnh.wQj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48931);
                    return 0;
                case 12:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cif cif = new cif();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cif.populateBuilderWithField(c6086a3, cif, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bnh.wQk = cif;
                    }
                    AppMethodBeat.m2505o(48931);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48931);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48931);
            return -1;
        }
    }
}
