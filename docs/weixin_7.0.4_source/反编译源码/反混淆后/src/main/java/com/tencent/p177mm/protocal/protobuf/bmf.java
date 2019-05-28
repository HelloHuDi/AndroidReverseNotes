package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bmf */
public final class bmf extends bsr {
    public long wOS;
    public bts wPi;
    public bts wPj;
    public bts wPk;
    public int wPl;
    public int wem;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28589);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wPi == null) {
                c6092b = new C6092b("Not all required fields were included: ClientReport");
                AppMethodBeat.m2505o(28589);
                throw c6092b;
            } else if (this.wPj == null) {
                c6092b = new C6092b("Not all required fields were included: ChannelReport");
                AppMethodBeat.m2505o(28589);
                throw c6092b;
            } else if (this.wPk == null) {
                c6092b = new C6092b("Not all required fields were included: EngineReport");
                AppMethodBeat.m2505o(28589);
                throw c6092b;
            } else {
                if (this.BaseRequest != null) {
                    c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(c6093a);
                }
                if (this.wPi != null) {
                    c6093a.mo13479iy(2, this.wPi.computeSize());
                    this.wPi.writeFields(c6093a);
                }
                if (this.wPj != null) {
                    c6093a.mo13479iy(3, this.wPj.computeSize());
                    this.wPj.writeFields(c6093a);
                }
                if (this.wPk != null) {
                    c6093a.mo13479iy(4, this.wPk.computeSize());
                    this.wPk.writeFields(c6093a);
                }
                c6093a.mo13480iz(5, this.wem);
                c6093a.mo13472ai(6, this.wOS);
                c6093a.mo13480iz(7, this.wPl);
                AppMethodBeat.m2505o(28589);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wPi != null) {
                ix += C6087a.m9557ix(2, this.wPi.computeSize());
            }
            if (this.wPj != null) {
                ix += C6087a.m9557ix(3, this.wPj.computeSize());
            }
            if (this.wPk != null) {
                ix += C6087a.m9557ix(4, this.wPk.computeSize());
            }
            int bs = ((ix + C6091a.m9572bs(5, this.wem)) + C6091a.m9578o(6, this.wOS)) + C6091a.m9572bs(7, this.wPl);
            AppMethodBeat.m2505o(28589);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.wPi == null) {
                c6092b = new C6092b("Not all required fields were included: ClientReport");
                AppMethodBeat.m2505o(28589);
                throw c6092b;
            } else if (this.wPj == null) {
                c6092b = new C6092b("Not all required fields were included: ChannelReport");
                AppMethodBeat.m2505o(28589);
                throw c6092b;
            } else if (this.wPk == null) {
                c6092b = new C6092b("Not all required fields were included: EngineReport");
                AppMethodBeat.m2505o(28589);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(28589);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bmf bmf = (bmf) objArr[1];
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
                        bmf.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(28589);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bmf.wPi = bts;
                    }
                    AppMethodBeat.m2505o(28589);
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
                        bmf.wPj = bts;
                    }
                    AppMethodBeat.m2505o(28589);
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
                        bmf.wPk = bts;
                    }
                    AppMethodBeat.m2505o(28589);
                    return 0;
                case 5:
                    bmf.wem = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28589);
                    return 0;
                case 6:
                    bmf.wOS = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(28589);
                    return 0;
                case 7:
                    bmf.wPl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28589);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28589);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28589);
            return -1;
        }
    }
}
