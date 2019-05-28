package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.protocal.protobuf.BaseResponse;
import com.tencent.p177mm.protocal.protobuf.btd;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.ay */
public final class C45990ay extends btd {
    public C39197dd nbA;
    public C39202m nbB;
    public C28196dp nbC;
    public C20960s nbD;
    public C28195do nbE;
    public C20959r nbF;
    public boolean nbv;
    public C34265ak nbw;
    public String nbx;
    public C12109ac nby;
    public C39200f nbz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(117000);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(117000);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13471aO(2, this.nbv);
            if (this.nbw != null) {
                c6093a.mo13479iy(3, this.nbw.computeSize());
                this.nbw.writeFields(c6093a);
            }
            if (this.nbx != null) {
                c6093a.mo13475e(4, this.nbx);
            }
            if (this.nby != null) {
                c6093a.mo13479iy(6, this.nby.computeSize());
                this.nby.writeFields(c6093a);
            }
            if (this.nbz != null) {
                c6093a.mo13479iy(7, this.nbz.computeSize());
                this.nbz.writeFields(c6093a);
            }
            if (this.nbA != null) {
                c6093a.mo13479iy(8, this.nbA.computeSize());
                this.nbA.writeFields(c6093a);
            }
            if (this.nbB != null) {
                c6093a.mo13479iy(11, this.nbB.computeSize());
                this.nbB.writeFields(c6093a);
            }
            if (this.nbC != null) {
                c6093a.mo13479iy(12, this.nbC.computeSize());
                this.nbC.writeFields(c6093a);
            }
            if (this.nbD != null) {
                c6093a.mo13479iy(13, this.nbD.computeSize());
                this.nbD.writeFields(c6093a);
            }
            if (this.nbE != null) {
                c6093a.mo13479iy(14, this.nbE.computeSize());
                this.nbE.writeFields(c6093a);
            }
            if (this.nbF != null) {
                c6093a.mo13479iy(15, this.nbF.computeSize());
                this.nbF.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(117000);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9576fv(2) + 1;
            if (this.nbw != null) {
                ix += C6087a.m9557ix(3, this.nbw.computeSize());
            }
            if (this.nbx != null) {
                ix += C6091a.m9575f(4, this.nbx);
            }
            if (this.nby != null) {
                ix += C6087a.m9557ix(6, this.nby.computeSize());
            }
            if (this.nbz != null) {
                ix += C6087a.m9557ix(7, this.nbz.computeSize());
            }
            if (this.nbA != null) {
                ix += C6087a.m9557ix(8, this.nbA.computeSize());
            }
            if (this.nbB != null) {
                ix += C6087a.m9557ix(11, this.nbB.computeSize());
            }
            if (this.nbC != null) {
                ix += C6087a.m9557ix(12, this.nbC.computeSize());
            }
            if (this.nbD != null) {
                ix += C6087a.m9557ix(13, this.nbD.computeSize());
            }
            if (this.nbE != null) {
                ix += C6087a.m9557ix(14, this.nbE.computeSize());
            }
            if (this.nbF != null) {
                ix += C6087a.m9557ix(15, this.nbF.computeSize());
            }
            AppMethodBeat.m2505o(117000);
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
                AppMethodBeat.m2505o(117000);
                throw c6092b;
            }
            AppMethodBeat.m2505o(117000);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C45990ay c45990ay = (C45990ay) objArr[1];
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
                        c45990ay.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(117000);
                    return 0;
                case 2:
                    c45990ay.nbv = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(117000);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C34265ak c34265ak = new C34265ak();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c34265ak.populateBuilderWithField(c6086a3, c34265ak, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c45990ay.nbw = c34265ak;
                    }
                    AppMethodBeat.m2505o(117000);
                    return 0;
                case 4:
                    c45990ay.nbx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(117000);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C12109ac c12109ac = new C12109ac();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c12109ac.populateBuilderWithField(c6086a3, c12109ac, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c45990ay.nby = c12109ac;
                    }
                    AppMethodBeat.m2505o(117000);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C39200f c39200f = new C39200f();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c39200f.populateBuilderWithField(c6086a3, c39200f, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c45990ay.nbz = c39200f;
                    }
                    AppMethodBeat.m2505o(117000);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C39197dd c39197dd = new C39197dd();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c39197dd.populateBuilderWithField(c6086a3, c39197dd, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c45990ay.nbA = c39197dd;
                    }
                    AppMethodBeat.m2505o(117000);
                    return 0;
                case 11:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C39202m c39202m = new C39202m();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c39202m.populateBuilderWithField(c6086a3, c39202m, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c45990ay.nbB = c39202m;
                    }
                    AppMethodBeat.m2505o(117000);
                    return 0;
                case 12:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C28196dp c28196dp = new C28196dp();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c28196dp.populateBuilderWithField(c6086a3, c28196dp, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c45990ay.nbC = c28196dp;
                    }
                    AppMethodBeat.m2505o(117000);
                    return 0;
                case 13:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C20960s c20960s = new C20960s();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c20960s.populateBuilderWithField(c6086a3, c20960s, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c45990ay.nbD = c20960s;
                    }
                    AppMethodBeat.m2505o(117000);
                    return 0;
                case 14:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C28195do c28195do = new C28195do();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c28195do.populateBuilderWithField(c6086a3, c28195do, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c45990ay.nbE = c28195do;
                    }
                    AppMethodBeat.m2505o(117000);
                    return 0;
                case 15:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C20959r c20959r = new C20959r();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c20959r.populateBuilderWithField(c6086a3, c20959r, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c45990ay.nbF = c20959r;
                    }
                    AppMethodBeat.m2505o(117000);
                    return 0;
                default:
                    AppMethodBeat.m2505o(117000);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(117000);
            return -1;
        }
    }
}
