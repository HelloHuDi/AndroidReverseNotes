package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cll extends btd {
    public int pcX;
    public int ptD;
    public long ptF;
    public int ptw;
    public int ptx;
    public int pty;
    public bts vEB;
    public bts vEC;
    public String vRA;
    public String vRw;
    public bts xja;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80204);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(80204);
                throw bVar;
            } else if (this.xja == null) {
                bVar = new b("Not all required fields were included: ClientImgId");
                AppMethodBeat.o(80204);
                throw bVar;
            } else if (this.vEB == null) {
                bVar = new b("Not all required fields were included: FromUserName");
                AppMethodBeat.o(80204);
                throw bVar;
            } else if (this.vEC == null) {
                bVar = new b("Not all required fields were included: ToUserName");
                AppMethodBeat.o(80204);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                aVar.iz(2, this.ptD);
                if (this.xja != null) {
                    aVar.iy(3, this.xja.computeSize());
                    this.xja.writeFields(aVar);
                }
                if (this.vEB != null) {
                    aVar.iy(4, this.vEB.computeSize());
                    this.vEB.writeFields(aVar);
                }
                if (this.vEC != null) {
                    aVar.iy(5, this.vEC.computeSize());
                    this.vEC.writeFields(aVar);
                }
                aVar.iz(6, this.ptw);
                aVar.iz(7, this.ptx);
                aVar.iz(8, this.pty);
                aVar.iz(9, this.pcX);
                aVar.ai(10, this.ptF);
                if (this.vRw != null) {
                    aVar.e(11, this.vRw);
                }
                if (this.vRA != null) {
                    aVar.e(12, this.vRA);
                }
                AppMethodBeat.o(80204);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.ptD);
            if (this.xja != null) {
                ix += e.a.a.a.ix(3, this.xja.computeSize());
            }
            if (this.vEB != null) {
                ix += e.a.a.a.ix(4, this.vEB.computeSize());
            }
            if (this.vEC != null) {
                ix += e.a.a.a.ix(5, this.vEC.computeSize());
            }
            ix = ((((ix + e.a.a.b.b.a.bs(6, this.ptw)) + e.a.a.b.b.a.bs(7, this.ptx)) + e.a.a.b.b.a.bs(8, this.pty)) + e.a.a.b.b.a.bs(9, this.pcX)) + e.a.a.b.b.a.o(10, this.ptF);
            if (this.vRw != null) {
                ix += e.a.a.b.b.a.f(11, this.vRw);
            }
            if (this.vRA != null) {
                ix += e.a.a.b.b.a.f(12, this.vRA);
            }
            AppMethodBeat.o(80204);
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
                AppMethodBeat.o(80204);
                throw bVar;
            } else if (this.xja == null) {
                bVar = new b("Not all required fields were included: ClientImgId");
                AppMethodBeat.o(80204);
                throw bVar;
            } else if (this.vEB == null) {
                bVar = new b("Not all required fields were included: FromUserName");
                AppMethodBeat.o(80204);
                throw bVar;
            } else if (this.vEC == null) {
                bVar = new b("Not all required fields were included: ToUserName");
                AppMethodBeat.o(80204);
                throw bVar;
            } else {
                AppMethodBeat.o(80204);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cll cll = (cll) objArr[1];
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
                        BaseResponse baseResponse = new BaseResponse();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cll.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(80204);
                    return 0;
                case 2:
                    cll.ptD = aVar3.BTU.vd();
                    AppMethodBeat.o(80204);
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
                        cll.xja = bts;
                    }
                    AppMethodBeat.o(80204);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cll.vEB = bts;
                    }
                    AppMethodBeat.o(80204);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cll.vEC = bts;
                    }
                    AppMethodBeat.o(80204);
                    return 0;
                case 6:
                    cll.ptw = aVar3.BTU.vd();
                    AppMethodBeat.o(80204);
                    return 0;
                case 7:
                    cll.ptx = aVar3.BTU.vd();
                    AppMethodBeat.o(80204);
                    return 0;
                case 8:
                    cll.pty = aVar3.BTU.vd();
                    AppMethodBeat.o(80204);
                    return 0;
                case 9:
                    cll.pcX = aVar3.BTU.vd();
                    AppMethodBeat.o(80204);
                    return 0;
                case 10:
                    cll.ptF = aVar3.BTU.ve();
                    AppMethodBeat.o(80204);
                    return 0;
                case 11:
                    cll.vRw = aVar3.BTU.readString();
                    AppMethodBeat.o(80204);
                    return 0;
                case 12:
                    cll.vRA = aVar3.BTU.readString();
                    AppMethodBeat.o(80204);
                    return 0;
                default:
                    AppMethodBeat.o(80204);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80204);
            return -1;
        }
    }
}
