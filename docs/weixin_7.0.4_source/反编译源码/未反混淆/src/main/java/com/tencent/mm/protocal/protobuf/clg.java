package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

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

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(116809);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.xiT == null) {
                bVar = new b("Not all required fields were included: ClientMediaId");
                AppMethodBeat.o(116809);
                throw bVar;
            } else if (this.xiU == null) {
                bVar = new b("Not all required fields were included: DataMD5");
                AppMethodBeat.o(116809);
                throw bVar;
            } else if (this.ptz == null) {
                bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(116809);
                throw bVar;
            } else {
                if (this.BaseRequest != null) {
                    aVar.iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.xiT != null) {
                    aVar.iy(2, this.xiT.computeSize());
                    this.xiT.writeFields(aVar);
                }
                if (this.xiU != null) {
                    aVar.iy(3, this.xiU.computeSize());
                    this.xiU.writeFields(aVar);
                }
                aVar.iz(4, this.ptw);
                aVar.iz(5, this.ptx);
                aVar.iz(6, this.pty);
                if (this.ptz != null) {
                    aVar.iy(7, this.ptz.computeSize());
                    this.ptz.writeFields(aVar);
                }
                aVar.iz(8, this.nda);
                aVar.iz(9, this.xiV);
                aVar.iz(10, this.xiW);
                aVar.iz(11, this.xiX);
                aVar.iz(12, this.xiY);
                AppMethodBeat.o(116809);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.xiT != null) {
                ix += e.a.a.a.ix(2, this.xiT.computeSize());
            }
            if (this.xiU != null) {
                ix += e.a.a.a.ix(3, this.xiU.computeSize());
            }
            ix = ((ix + e.a.a.b.b.a.bs(4, this.ptw)) + e.a.a.b.b.a.bs(5, this.ptx)) + e.a.a.b.b.a.bs(6, this.pty);
            if (this.ptz != null) {
                ix += e.a.a.a.ix(7, this.ptz.computeSize());
            }
            int bs = ((((ix + e.a.a.b.b.a.bs(8, this.nda)) + e.a.a.b.b.a.bs(9, this.xiV)) + e.a.a.b.b.a.bs(10, this.xiW)) + e.a.a.b.b.a.bs(11, this.xiX)) + e.a.a.b.b.a.bs(12, this.xiY);
            AppMethodBeat.o(116809);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.xiT == null) {
                bVar = new b("Not all required fields were included: ClientMediaId");
                AppMethodBeat.o(116809);
                throw bVar;
            } else if (this.xiU == null) {
                bVar = new b("Not all required fields were included: DataMD5");
                AppMethodBeat.o(116809);
                throw bVar;
            } else if (this.ptz == null) {
                bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(116809);
                throw bVar;
            } else {
                AppMethodBeat.o(116809);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            clg clg = (clg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            bts bts;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        clg.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(116809);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        clg.xiT = bts;
                    }
                    AppMethodBeat.o(116809);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        clg.xiU = bts;
                    }
                    AppMethodBeat.o(116809);
                    return 0;
                case 4:
                    clg.ptw = aVar3.BTU.vd();
                    AppMethodBeat.o(116809);
                    return 0;
                case 5:
                    clg.ptx = aVar3.BTU.vd();
                    AppMethodBeat.o(116809);
                    return 0;
                case 6:
                    clg.pty = aVar3.BTU.vd();
                    AppMethodBeat.o(116809);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        clg.ptz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(116809);
                    return 0;
                case 8:
                    clg.nda = aVar3.BTU.vd();
                    AppMethodBeat.o(116809);
                    return 0;
                case 9:
                    clg.xiV = aVar3.BTU.vd();
                    AppMethodBeat.o(116809);
                    return 0;
                case 10:
                    clg.xiW = aVar3.BTU.vd();
                    AppMethodBeat.o(116809);
                    return 0;
                case 11:
                    clg.xiX = aVar3.BTU.vd();
                    AppMethodBeat.o(116809);
                    return 0;
                case 12:
                    clg.xiY = aVar3.BTU.vd();
                    AppMethodBeat.o(116809);
                    return 0;
                default:
                    AppMethodBeat.o(116809);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116809);
            return -1;
        }
    }
}
