package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.akx */
public final class akx extends bsr {
    public int ptD;
    public long ptF;
    public int ptw;
    public int ptx;
    public int pty;
    public bts vEB;
    public bts vEC;
    public int wqw;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80075);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vEB == null) {
                c6092b = new C6092b("Not all required fields were included: FromUserName");
                AppMethodBeat.m2505o(80075);
                throw c6092b;
            } else if (this.vEC == null) {
                c6092b = new C6092b("Not all required fields were included: ToUserName");
                AppMethodBeat.m2505o(80075);
                throw c6092b;
            } else {
                if (this.BaseRequest != null) {
                    c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(c6093a);
                }
                c6093a.mo13480iz(2, this.ptD);
                if (this.vEB != null) {
                    c6093a.mo13479iy(3, this.vEB.computeSize());
                    this.vEB.writeFields(c6093a);
                }
                if (this.vEC != null) {
                    c6093a.mo13479iy(4, this.vEC.computeSize());
                    this.vEC.writeFields(c6093a);
                }
                c6093a.mo13480iz(5, this.ptw);
                c6093a.mo13480iz(6, this.ptx);
                c6093a.mo13480iz(7, this.pty);
                c6093a.mo13480iz(8, this.wqw);
                c6093a.mo13472ai(9, this.ptF);
                AppMethodBeat.m2505o(80075);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.ptD);
            if (this.vEB != null) {
                ix += C6087a.m9557ix(3, this.vEB.computeSize());
            }
            if (this.vEC != null) {
                ix += C6087a.m9557ix(4, this.vEC.computeSize());
            }
            int bs = ((((ix + C6091a.m9572bs(5, this.ptw)) + C6091a.m9572bs(6, this.ptx)) + C6091a.m9572bs(7, this.pty)) + C6091a.m9572bs(8, this.wqw)) + C6091a.m9578o(9, this.ptF);
            AppMethodBeat.m2505o(80075);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.vEB == null) {
                c6092b = new C6092b("Not all required fields were included: FromUserName");
                AppMethodBeat.m2505o(80075);
                throw c6092b;
            } else if (this.vEC == null) {
                c6092b = new C6092b("Not all required fields were included: ToUserName");
                AppMethodBeat.m2505o(80075);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(80075);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            akx akx = (akx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            bts bts;
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
                        akx.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(80075);
                    return 0;
                case 2:
                    akx.ptD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80075);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        akx.vEB = bts;
                    }
                    AppMethodBeat.m2505o(80075);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        akx.vEC = bts;
                    }
                    AppMethodBeat.m2505o(80075);
                    return 0;
                case 5:
                    akx.ptw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80075);
                    return 0;
                case 6:
                    akx.ptx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80075);
                    return 0;
                case 7:
                    akx.pty = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80075);
                    return 0;
                case 8:
                    akx.wqw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80075);
                    return 0;
                case 9:
                    akx.ptF = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(80075);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80075);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80075);
            return -1;
        }
    }
}
