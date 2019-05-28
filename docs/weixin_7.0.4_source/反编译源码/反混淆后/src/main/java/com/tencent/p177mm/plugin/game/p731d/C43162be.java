package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.protocal.protobuf.BaseResponse;
import com.tencent.p177mm.protocal.protobuf.btd;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.be */
public final class C43162be extends btd {
    public C6930ae ncb;
    public C39184ah ncc;
    public C34263ai ncd;
    public C12115by nce;
    public C12121di ncf;
    public C6932am ncg;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111602);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(111602);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            if (this.ncb != null) {
                c6093a.mo13479iy(3, this.ncb.computeSize());
                this.ncb.writeFields(c6093a);
            }
            if (this.ncc != null) {
                c6093a.mo13479iy(4, this.ncc.computeSize());
                this.ncc.writeFields(c6093a);
            }
            if (this.ncd != null) {
                c6093a.mo13479iy(5, this.ncd.computeSize());
                this.ncd.writeFields(c6093a);
            }
            if (this.nce != null) {
                c6093a.mo13479iy(6, this.nce.computeSize());
                this.nce.writeFields(c6093a);
            }
            if (this.ncf != null) {
                c6093a.mo13479iy(8, this.ncf.computeSize());
                this.ncf.writeFields(c6093a);
            }
            if (this.ncg != null) {
                c6093a.mo13479iy(9, this.ncg.computeSize());
                this.ncg.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(111602);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.ncb != null) {
                ix += C6087a.m9557ix(3, this.ncb.computeSize());
            }
            if (this.ncc != null) {
                ix += C6087a.m9557ix(4, this.ncc.computeSize());
            }
            if (this.ncd != null) {
                ix += C6087a.m9557ix(5, this.ncd.computeSize());
            }
            if (this.nce != null) {
                ix += C6087a.m9557ix(6, this.nce.computeSize());
            }
            if (this.ncf != null) {
                ix += C6087a.m9557ix(8, this.ncf.computeSize());
            }
            if (this.ncg != null) {
                ix += C6087a.m9557ix(9, this.ncg.computeSize());
            }
            AppMethodBeat.m2505o(111602);
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
                AppMethodBeat.m2505o(111602);
                throw c6092b;
            }
            AppMethodBeat.m2505o(111602);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C43162be c43162be = (C43162be) objArr[1];
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
                        c43162be.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(111602);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C6930ae c6930ae = new C6930ae();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c6930ae.populateBuilderWithField(c6086a3, c6930ae, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c43162be.ncb = c6930ae;
                    }
                    AppMethodBeat.m2505o(111602);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C39184ah c39184ah = new C39184ah();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c39184ah.populateBuilderWithField(c6086a3, c39184ah, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c43162be.ncc = c39184ah;
                    }
                    AppMethodBeat.m2505o(111602);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C34263ai c34263ai = new C34263ai();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c34263ai.populateBuilderWithField(c6086a3, c34263ai, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c43162be.ncd = c34263ai;
                    }
                    AppMethodBeat.m2505o(111602);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C12115by c12115by = new C12115by();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c12115by.populateBuilderWithField(c6086a3, c12115by, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c43162be.nce = c12115by;
                    }
                    AppMethodBeat.m2505o(111602);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C12121di c12121di = new C12121di();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c12121di.populateBuilderWithField(c6086a3, c12121di, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c43162be.ncf = c12121di;
                    }
                    AppMethodBeat.m2505o(111602);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C6932am c6932am = new C6932am();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c6932am.populateBuilderWithField(c6086a3, c6932am, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c43162be.ncg = c6932am;
                    }
                    AppMethodBeat.m2505o(111602);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111602);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111602);
            return -1;
        }
    }
}
