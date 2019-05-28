package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ath */
public final class ath extends btd {
    public int kdT;
    public String kdU;
    public LinkedList<ati> wxk = new LinkedList();
    public bke wxl;
    public btn wxm;
    public boolean wxn;
    public C30188he wxo;

    public ath() {
        AppMethodBeat.m2504i(48868);
        AppMethodBeat.m2505o(48868);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48869);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(48869);
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
            c6093a.mo13474e(4, 8, this.wxk);
            if (this.wxl != null) {
                c6093a.mo13479iy(5, this.wxl.computeSize());
                this.wxl.writeFields(c6093a);
            }
            if (this.wxm != null) {
                c6093a.mo13479iy(6, this.wxm.computeSize());
                this.wxm.writeFields(c6093a);
            }
            c6093a.mo13471aO(7, this.wxn);
            if (this.wxo != null) {
                c6093a.mo13479iy(8, this.wxo.computeSize());
                this.wxo.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(48869);
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
            ix += C6087a.m9552c(4, 8, this.wxk);
            if (this.wxl != null) {
                ix += C6087a.m9557ix(5, this.wxl.computeSize());
            }
            if (this.wxm != null) {
                ix += C6087a.m9557ix(6, this.wxm.computeSize());
            }
            ix += C6091a.m9576fv(7) + 1;
            if (this.wxo != null) {
                ix += C6087a.m9557ix(8, this.wxo.computeSize());
            }
            AppMethodBeat.m2505o(48869);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wxk.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(48869);
                throw c6092b;
            }
            AppMethodBeat.m2505o(48869);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ath ath = (ath) objArr[1];
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
                        ath.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(48869);
                    return 0;
                case 2:
                    ath.kdT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48869);
                    return 0;
                case 3:
                    ath.kdU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48869);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ati ati = new ati();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ati.populateBuilderWithField(c6086a3, ati, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ath.wxk.add(ati);
                    }
                    AppMethodBeat.m2505o(48869);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bke bke = new bke();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bke.populateBuilderWithField(c6086a3, bke, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ath.wxl = bke;
                    }
                    AppMethodBeat.m2505o(48869);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btn btn = new btn();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = btn.populateBuilderWithField(c6086a3, btn, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ath.wxm = btn;
                    }
                    AppMethodBeat.m2505o(48869);
                    return 0;
                case 7:
                    ath.wxn = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(48869);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C30188he c30188he = new C30188he();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c30188he.populateBuilderWithField(c6086a3, c30188he, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ath.wxo = c30188he;
                    }
                    AppMethodBeat.m2505o(48869);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48869);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48869);
            return -1;
        }
    }
}
