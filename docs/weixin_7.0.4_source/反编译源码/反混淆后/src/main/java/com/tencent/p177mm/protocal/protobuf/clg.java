package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.clg */
public final class clg extends bsr {
    public int nda;
    public int ptw;
    public int ptx;
    public int pty;
    public SKBuiltinBuffer_t ptz;
    public bts xiT;
    public bts xiU;
    public int xiV;
    public int xiW;
    public int xiX;
    public int xiY;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(116809);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xiT == null) {
                c6092b = new C6092b("Not all required fields were included: ClientMediaId");
                AppMethodBeat.m2505o(116809);
                throw c6092b;
            } else if (this.xiU == null) {
                c6092b = new C6092b("Not all required fields were included: DataMD5");
                AppMethodBeat.m2505o(116809);
                throw c6092b;
            } else if (this.ptz == null) {
                c6092b = new C6092b("Not all required fields were included: Data");
                AppMethodBeat.m2505o(116809);
                throw c6092b;
            } else {
                if (this.BaseRequest != null) {
                    c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(c6093a);
                }
                if (this.xiT != null) {
                    c6093a.mo13479iy(2, this.xiT.computeSize());
                    this.xiT.writeFields(c6093a);
                }
                if (this.xiU != null) {
                    c6093a.mo13479iy(3, this.xiU.computeSize());
                    this.xiU.writeFields(c6093a);
                }
                c6093a.mo13480iz(4, this.ptw);
                c6093a.mo13480iz(5, this.ptx);
                c6093a.mo13480iz(6, this.pty);
                if (this.ptz != null) {
                    c6093a.mo13479iy(7, this.ptz.computeSize());
                    this.ptz.writeFields(c6093a);
                }
                c6093a.mo13480iz(8, this.nda);
                c6093a.mo13480iz(9, this.xiV);
                c6093a.mo13480iz(10, this.xiW);
                c6093a.mo13480iz(11, this.xiX);
                c6093a.mo13480iz(12, this.xiY);
                AppMethodBeat.m2505o(116809);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.xiT != null) {
                ix += C6087a.m9557ix(2, this.xiT.computeSize());
            }
            if (this.xiU != null) {
                ix += C6087a.m9557ix(3, this.xiU.computeSize());
            }
            ix = ((ix + C6091a.m9572bs(4, this.ptw)) + C6091a.m9572bs(5, this.ptx)) + C6091a.m9572bs(6, this.pty);
            if (this.ptz != null) {
                ix += C6087a.m9557ix(7, this.ptz.computeSize());
            }
            int bs = ((((ix + C6091a.m9572bs(8, this.nda)) + C6091a.m9572bs(9, this.xiV)) + C6091a.m9572bs(10, this.xiW)) + C6091a.m9572bs(11, this.xiX)) + C6091a.m9572bs(12, this.xiY);
            AppMethodBeat.m2505o(116809);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.xiT == null) {
                c6092b = new C6092b("Not all required fields were included: ClientMediaId");
                AppMethodBeat.m2505o(116809);
                throw c6092b;
            } else if (this.xiU == null) {
                c6092b = new C6092b("Not all required fields were included: DataMD5");
                AppMethodBeat.m2505o(116809);
                throw c6092b;
            } else if (this.ptz == null) {
                c6092b = new C6092b("Not all required fields were included: Data");
                AppMethodBeat.m2505o(116809);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(116809);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            clg clg = (clg) objArr[1];
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
                        clg.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(116809);
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
                        clg.xiT = bts;
                    }
                    AppMethodBeat.m2505o(116809);
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
                        clg.xiU = bts;
                    }
                    AppMethodBeat.m2505o(116809);
                    return 0;
                case 4:
                    clg.ptw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116809);
                    return 0;
                case 5:
                    clg.ptx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116809);
                    return 0;
                case 6:
                    clg.pty = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116809);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        clg.ptz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(116809);
                    return 0;
                case 8:
                    clg.nda = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116809);
                    return 0;
                case 9:
                    clg.xiV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116809);
                    return 0;
                case 10:
                    clg.xiW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116809);
                    return 0;
                case 11:
                    clg.xiX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116809);
                    return 0;
                case 12:
                    clg.xiY = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116809);
                    return 0;
                default:
                    AppMethodBeat.m2505o(116809);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(116809);
            return -1;
        }
    }
}
