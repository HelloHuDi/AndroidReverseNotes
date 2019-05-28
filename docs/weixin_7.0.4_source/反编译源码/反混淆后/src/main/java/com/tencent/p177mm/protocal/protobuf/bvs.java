package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bvs */
public final class bvs extends btd {
    public C15326cmd wcK;
    public C1332b wtt;
    public LinkedList<cmb> wtu = new LinkedList();
    public int wtv;

    public bvs() {
        AppMethodBeat.m2504i(127730);
        AppMethodBeat.m2505o(127730);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(127731);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(127731);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            if (this.wcK != null) {
                c6093a.mo13479iy(2, this.wcK.computeSize());
                this.wcK.writeFields(c6093a);
            }
            c6093a.mo13474e(3, 8, this.wtu);
            if (this.wtt != null) {
                c6093a.mo13473c(4, this.wtt);
            }
            c6093a.mo13480iz(5, this.wtv);
            AppMethodBeat.m2505o(127731);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wcK != null) {
                ix += C6087a.m9557ix(2, this.wcK.computeSize());
            }
            ix += C6087a.m9552c(3, 8, this.wtu);
            if (this.wtt != null) {
                ix += C6091a.m9571b(4, this.wtt);
            }
            int bs = ix + C6091a.m9572bs(5, this.wtv);
            AppMethodBeat.m2505o(127731);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wtu.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(127731);
                throw c6092b;
            }
            AppMethodBeat.m2505o(127731);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bvs bvs = (bvs) objArr[1];
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
                        bvs.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(127731);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C15326cmd c15326cmd = new C15326cmd();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c15326cmd.populateBuilderWithField(c6086a3, c15326cmd, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bvs.wcK = c15326cmd;
                    }
                    AppMethodBeat.m2505o(127731);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cmb cmb = new cmb();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cmb.populateBuilderWithField(c6086a3, cmb, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bvs.wtu.add(cmb);
                    }
                    AppMethodBeat.m2505o(127731);
                    return 0;
                case 4:
                    bvs.wtt = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(127731);
                    return 0;
                case 5:
                    bvs.wtv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(127731);
                    return 0;
                default:
                    AppMethodBeat.m2505o(127731);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(127731);
            return -1;
        }
    }
}
