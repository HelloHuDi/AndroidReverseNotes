package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ma */
public final class C46563ma extends bsr {
    public String token;
    public chl vPH;
    public String vPI;
    public int vPV;
    public C46532cz vPn;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56731);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vPH == null) {
                c6092b = new C6092b("Not all required fields were included: tock_mess");
                AppMethodBeat.m2505o(56731);
                throw c6092b;
            } else if (this.vPn == null) {
                c6092b = new C6092b("Not all required fields were included: after_placeorder_comm_req");
                AppMethodBeat.m2505o(56731);
                throw c6092b;
            } else if (this.token == null) {
                c6092b = new C6092b("Not all required fields were included: token");
                AppMethodBeat.m2505o(56731);
                throw c6092b;
            } else {
                if (this.BaseRequest != null) {
                    c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(c6093a);
                }
                if (this.vPH != null) {
                    c6093a.mo13479iy(2, this.vPH.computeSize());
                    this.vPH.writeFields(c6093a);
                }
                if (this.vPn != null) {
                    c6093a.mo13479iy(3, this.vPn.computeSize());
                    this.vPn.writeFields(c6093a);
                }
                if (this.vPI != null) {
                    c6093a.mo13475e(4, this.vPI);
                }
                c6093a.mo13480iz(5, this.vPV);
                if (this.token != null) {
                    c6093a.mo13475e(6, this.token);
                }
                AppMethodBeat.m2505o(56731);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vPH != null) {
                ix += C6087a.m9557ix(2, this.vPH.computeSize());
            }
            if (this.vPn != null) {
                ix += C6087a.m9557ix(3, this.vPn.computeSize());
            }
            if (this.vPI != null) {
                ix += C6091a.m9575f(4, this.vPI);
            }
            ix += C6091a.m9572bs(5, this.vPV);
            if (this.token != null) {
                ix += C6091a.m9575f(6, this.token);
            }
            AppMethodBeat.m2505o(56731);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.vPH == null) {
                c6092b = new C6092b("Not all required fields were included: tock_mess");
                AppMethodBeat.m2505o(56731);
                throw c6092b;
            } else if (this.vPn == null) {
                c6092b = new C6092b("Not all required fields were included: after_placeorder_comm_req");
                AppMethodBeat.m2505o(56731);
                throw c6092b;
            } else if (this.token == null) {
                c6092b = new C6092b("Not all required fields were included: token");
                AppMethodBeat.m2505o(56731);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(56731);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C46563ma c46563ma = (C46563ma) objArr[1];
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
                        C7267hl c7267hl = new C7267hl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46563ma.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(56731);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        chl chl = new chl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = chl.populateBuilderWithField(c6086a3, chl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46563ma.vPH = chl;
                    }
                    AppMethodBeat.m2505o(56731);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C46532cz c46532cz = new C46532cz();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c46532cz.populateBuilderWithField(c6086a3, c46532cz, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46563ma.vPn = c46532cz;
                    }
                    AppMethodBeat.m2505o(56731);
                    return 0;
                case 4:
                    c46563ma.vPI = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56731);
                    return 0;
                case 5:
                    c46563ma.vPV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56731);
                    return 0;
                case 6:
                    c46563ma.token = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56731);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56731);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56731);
            return -1;
        }
    }
}
