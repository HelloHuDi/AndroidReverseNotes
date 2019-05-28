package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aht */
public final class aht extends bsr {
    public LinkedList<bts> vEg = new LinkedList();
    public int wnW;
    public int wnX;
    public LinkedList<bts> wnY = new LinkedList();
    public int wnZ;
    public LinkedList<bts> woa = new LinkedList();
    public int wob;
    public bts woc;

    public aht() {
        AppMethodBeat.m2504i(28428);
        AppMethodBeat.m2505o(28428);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28429);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.wnW);
            c6093a.mo13474e(3, 8, this.vEg);
            c6093a.mo13480iz(4, this.wnX);
            c6093a.mo13474e(5, 8, this.wnY);
            c6093a.mo13480iz(6, this.wnZ);
            c6093a.mo13474e(7, 8, this.woa);
            c6093a.mo13480iz(8, this.wob);
            if (this.woc != null) {
                c6093a.mo13479iy(9, this.woc.computeSize());
                this.woc.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(28429);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((((((ix + C6091a.m9572bs(2, this.wnW)) + C6087a.m9552c(3, 8, this.vEg)) + C6091a.m9572bs(4, this.wnX)) + C6087a.m9552c(5, 8, this.wnY)) + C6091a.m9572bs(6, this.wnZ)) + C6087a.m9552c(7, 8, this.woa)) + C6091a.m9572bs(8, this.wob);
            if (this.woc != null) {
                ix += C6087a.m9557ix(9, this.woc.computeSize());
            }
            AppMethodBeat.m2505o(28429);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vEg.clear();
            this.wnY.clear();
            this.woa.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28429);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aht aht = (aht) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
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
                        aht.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(28429);
                    return 0;
                case 2:
                    aht.wnW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28429);
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
                        aht.vEg.add(bts);
                    }
                    AppMethodBeat.m2505o(28429);
                    return 0;
                case 4:
                    aht.wnX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28429);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aht.wnY.add(bts);
                    }
                    AppMethodBeat.m2505o(28429);
                    return 0;
                case 6:
                    aht.wnZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28429);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aht.woa.add(bts);
                    }
                    AppMethodBeat.m2505o(28429);
                    return 0;
                case 8:
                    aht.wob = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28429);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aht.woc = bts;
                    }
                    AppMethodBeat.m2505o(28429);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28429);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28429);
            return -1;
        }
    }
}
