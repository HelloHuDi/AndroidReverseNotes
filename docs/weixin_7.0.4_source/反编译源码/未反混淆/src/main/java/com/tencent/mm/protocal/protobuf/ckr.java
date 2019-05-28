package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ckr extends btd {
    public String fKh;
    public String fKk;
    public String jBB;
    public int pcX;
    public int ptw;
    public int ptx;
    public int pty;
    public String xit;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28688);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28688);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.fKh != null) {
                aVar.e(2, this.fKh);
            }
            if (this.fKk != null) {
                aVar.e(3, this.fKk);
            }
            if (this.xit != null) {
                aVar.e(4, this.xit);
            }
            if (this.jBB != null) {
                aVar.e(5, this.jBB);
            }
            aVar.iz(6, this.ptw);
            aVar.iz(7, this.ptx);
            aVar.iz(8, this.pty);
            aVar.iz(9, this.pcX);
            AppMethodBeat.o(28688);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.fKh != null) {
                ix += e.a.a.b.b.a.f(2, this.fKh);
            }
            if (this.fKk != null) {
                ix += e.a.a.b.b.a.f(3, this.fKk);
            }
            if (this.xit != null) {
                ix += e.a.a.b.b.a.f(4, this.xit);
            }
            if (this.jBB != null) {
                ix += e.a.a.b.b.a.f(5, this.jBB);
            }
            int bs = (((ix + e.a.a.b.b.a.bs(6, this.ptw)) + e.a.a.b.b.a.bs(7, this.ptx)) + e.a.a.b.b.a.bs(8, this.pty)) + e.a.a.b.b.a.bs(9, this.pcX);
            AppMethodBeat.o(28688);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28688);
                throw bVar;
            }
            AppMethodBeat.o(28688);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ckr ckr = (ckr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ckr.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(28688);
                    return 0;
                case 2:
                    ckr.fKh = aVar3.BTU.readString();
                    AppMethodBeat.o(28688);
                    return 0;
                case 3:
                    ckr.fKk = aVar3.BTU.readString();
                    AppMethodBeat.o(28688);
                    return 0;
                case 4:
                    ckr.xit = aVar3.BTU.readString();
                    AppMethodBeat.o(28688);
                    return 0;
                case 5:
                    ckr.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(28688);
                    return 0;
                case 6:
                    ckr.ptw = aVar3.BTU.vd();
                    AppMethodBeat.o(28688);
                    return 0;
                case 7:
                    ckr.ptx = aVar3.BTU.vd();
                    AppMethodBeat.o(28688);
                    return 0;
                case 8:
                    ckr.pty = aVar3.BTU.vd();
                    AppMethodBeat.o(28688);
                    return 0;
                case 9:
                    ckr.pcX = aVar3.BTU.vd();
                    AppMethodBeat.o(28688);
                    return 0;
                default:
                    AppMethodBeat.o(28688);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28688);
            return -1;
        }
    }
}
