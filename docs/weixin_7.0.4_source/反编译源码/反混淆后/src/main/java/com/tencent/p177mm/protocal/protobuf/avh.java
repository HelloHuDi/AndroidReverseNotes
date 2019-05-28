package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.avh */
public final class avh extends btd {
    public avi wzj;
    public LinkedList<avf> wzk = new LinkedList();
    public String wzl;
    public LinkedList<awg> wzm = new LinkedList();

    public avh() {
        AppMethodBeat.m2504i(10199);
        AppMethodBeat.m2505o(10199);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(10200);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(10200);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            if (this.wzj != null) {
                c6093a.mo13479iy(2, this.wzj.computeSize());
                this.wzj.writeFields(c6093a);
            }
            c6093a.mo13474e(3, 8, this.wzk);
            if (this.wzl != null) {
                c6093a.mo13475e(4, this.wzl);
            }
            c6093a.mo13474e(5, 8, this.wzm);
            AppMethodBeat.m2505o(10200);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wzj != null) {
                ix += C6087a.m9557ix(2, this.wzj.computeSize());
            }
            ix += C6087a.m9552c(3, 8, this.wzk);
            if (this.wzl != null) {
                ix += C6091a.m9575f(4, this.wzl);
            }
            int c = ix + C6087a.m9552c(5, 8, this.wzm);
            AppMethodBeat.m2505o(10200);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wzk.clear();
            this.wzm.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(10200);
                throw c6092b;
            }
            AppMethodBeat.m2505o(10200);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            avh avh = (avh) objArr[1];
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
                        avh.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(10200);
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
                        avh.wzj = avi;
                    }
                    AppMethodBeat.m2505o(10200);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        avf avf = new avf();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = avf.populateBuilderWithField(c6086a3, avf, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        avh.wzk.add(avf);
                    }
                    AppMethodBeat.m2505o(10200);
                    return 0;
                case 4:
                    avh.wzl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10200);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        awg awg = new awg();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = awg.populateBuilderWithField(c6086a3, awg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        avh.wzm.add(awg);
                    }
                    AppMethodBeat.m2505o(10200);
                    return 0;
                default:
                    AppMethodBeat.m2505o(10200);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(10200);
            return -1;
        }
    }
}
