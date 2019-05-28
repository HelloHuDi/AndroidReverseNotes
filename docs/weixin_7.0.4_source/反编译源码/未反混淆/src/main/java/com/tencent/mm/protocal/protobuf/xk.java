package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class xk extends btd {
    public String fKh;
    public String fKk;
    public String jBB;
    public int ptw;
    public int ptx;
    public int pty;
    public SKBuiltinBuffer_t ptz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(135757);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(135757);
                throw bVar;
            } else if (this.ptz == null) {
                bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(135757);
                throw bVar;
            } else {
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
                if (this.jBB != null) {
                    aVar.e(4, this.jBB);
                }
                aVar.iz(5, this.ptw);
                aVar.iz(6, this.ptx);
                aVar.iz(7, this.pty);
                if (this.ptz != null) {
                    aVar.iy(8, this.ptz.computeSize());
                    this.ptz.writeFields(aVar);
                }
                AppMethodBeat.o(135757);
                return 0;
            }
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
            if (this.jBB != null) {
                ix += e.a.a.b.b.a.f(4, this.jBB);
            }
            ix = ((ix + e.a.a.b.b.a.bs(5, this.ptw)) + e.a.a.b.b.a.bs(6, this.ptx)) + e.a.a.b.b.a.bs(7, this.pty);
            if (this.ptz != null) {
                ix += e.a.a.a.ix(8, this.ptz.computeSize());
            }
            AppMethodBeat.o(135757);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(135757);
                throw bVar;
            } else if (this.ptz == null) {
                bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(135757);
                throw bVar;
            } else {
                AppMethodBeat.o(135757);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            xk xkVar = (xk) objArr[1];
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
                        xkVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(135757);
                    return 0;
                case 2:
                    xkVar.fKh = aVar3.BTU.readString();
                    AppMethodBeat.o(135757);
                    return 0;
                case 3:
                    xkVar.fKk = aVar3.BTU.readString();
                    AppMethodBeat.o(135757);
                    return 0;
                case 4:
                    xkVar.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(135757);
                    return 0;
                case 5:
                    xkVar.ptw = aVar3.BTU.vd();
                    AppMethodBeat.o(135757);
                    return 0;
                case 6:
                    xkVar.ptx = aVar3.BTU.vd();
                    AppMethodBeat.o(135757);
                    return 0;
                case 7:
                    xkVar.pty = aVar3.BTU.vd();
                    AppMethodBeat.o(135757);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        xkVar.ptz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(135757);
                    return 0;
                default:
                    AppMethodBeat.o(135757);
                    return -1;
            }
        } else {
            AppMethodBeat.o(135757);
            return -1;
        }
    }
}
