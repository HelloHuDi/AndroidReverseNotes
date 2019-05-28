package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cve extends btd {
    public int vOq;
    public String vOy;
    public int wCB;
    public bpy xrg;
    public bpw xrh;
    public int xri;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124381);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.wCB);
            aVar.iz(3, this.vOq);
            if (this.vOy != null) {
                aVar.e(4, this.vOy);
            }
            if (this.xrg != null) {
                aVar.iy(5, this.xrg.computeSize());
                this.xrg.writeFields(aVar);
            }
            if (this.xrh != null) {
                aVar.iy(6, this.xrh.computeSize());
                this.xrh.writeFields(aVar);
            }
            aVar.iz(7, this.xri);
            AppMethodBeat.o(124381);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.wCB)) + e.a.a.b.b.a.bs(3, this.vOq);
            if (this.vOy != null) {
                ix += e.a.a.b.b.a.f(4, this.vOy);
            }
            if (this.xrg != null) {
                ix += e.a.a.a.ix(5, this.xrg.computeSize());
            }
            if (this.xrh != null) {
                ix += e.a.a.a.ix(6, this.xrh.computeSize());
            }
            int bs = ix + e.a.a.b.b.a.bs(7, this.xri);
            AppMethodBeat.o(124381);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(124381);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cve cve = (cve) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cve.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(124381);
                    return 0;
                case 2:
                    cve.wCB = aVar3.BTU.vd();
                    AppMethodBeat.o(124381);
                    return 0;
                case 3:
                    cve.vOq = aVar3.BTU.vd();
                    AppMethodBeat.o(124381);
                    return 0;
                case 4:
                    cve.vOy = aVar3.BTU.readString();
                    AppMethodBeat.o(124381);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bpy bpy = new bpy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bpy.populateBuilderWithField(aVar4, bpy, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cve.xrg = bpy;
                    }
                    AppMethodBeat.o(124381);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bpw bpw = new bpw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bpw.populateBuilderWithField(aVar4, bpw, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cve.xrh = bpw;
                    }
                    AppMethodBeat.o(124381);
                    return 0;
                case 7:
                    cve.xri = aVar3.BTU.vd();
                    AppMethodBeat.o(124381);
                    return 0;
                default:
                    AppMethodBeat.o(124381);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124381);
            return -1;
        }
    }
}
