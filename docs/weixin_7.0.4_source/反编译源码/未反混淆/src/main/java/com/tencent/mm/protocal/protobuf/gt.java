package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class gt extends a implements bzw {
    public String ID;
    public int Ret;
    public String vIS;
    public SKBuiltinBuffer_t vIT;
    public String vIU;
    public int vIV;
    public String vIW;
    public String vIX;
    public SKBuiltinBuffer_t vIn;

    public final int getRet() {
        return this.Ret;
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28332);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vIT == null) {
                bVar = new b("Not all required fields were included: QRCodeBuffer");
                AppMethodBeat.o(28332);
                throw bVar;
            } else if (this.vIn == null) {
                bVar = new b("Not all required fields were included: Key");
                AppMethodBeat.o(28332);
                throw bVar;
            } else {
                aVar.iz(1, this.Ret);
                if (this.vIT != null) {
                    aVar.iy(2, this.vIT.computeSize());
                    this.vIT.writeFields(aVar);
                }
                if (this.vIU != null) {
                    aVar.e(3, this.vIU);
                }
                if (this.vIn != null) {
                    aVar.iy(4, this.vIn.computeSize());
                    this.vIn.writeFields(aVar);
                }
                if (this.vIW != null) {
                    aVar.e(5, this.vIW);
                }
                if (this.vIX != null) {
                    aVar.e(6, this.vIX);
                }
                aVar.iz(7, this.vIV);
                if (this.ID != null) {
                    aVar.e(8, this.ID);
                }
                if (this.vIS != null) {
                    aVar.e(9, this.vIS);
                }
                AppMethodBeat.o(28332);
                return 0;
            }
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.Ret) + 0;
            if (this.vIT != null) {
                bs += e.a.a.a.ix(2, this.vIT.computeSize());
            }
            if (this.vIU != null) {
                bs += e.a.a.b.b.a.f(3, this.vIU);
            }
            if (this.vIn != null) {
                bs += e.a.a.a.ix(4, this.vIn.computeSize());
            }
            if (this.vIW != null) {
                bs += e.a.a.b.b.a.f(5, this.vIW);
            }
            if (this.vIX != null) {
                bs += e.a.a.b.b.a.f(6, this.vIX);
            }
            bs += e.a.a.b.b.a.bs(7, this.vIV);
            if (this.ID != null) {
                bs += e.a.a.b.b.a.f(8, this.ID);
            }
            if (this.vIS != null) {
                bs += e.a.a.b.b.a.f(9, this.vIS);
            }
            AppMethodBeat.o(28332);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.vIT == null) {
                bVar = new b("Not all required fields were included: QRCodeBuffer");
                AppMethodBeat.o(28332);
                throw bVar;
            } else if (this.vIn == null) {
                bVar = new b("Not all required fields were included: Key");
                AppMethodBeat.o(28332);
                throw bVar;
            } else {
                AppMethodBeat.o(28332);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            gt gtVar = (gt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    gtVar.Ret = aVar3.BTU.vd();
                    AppMethodBeat.o(28332);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        gtVar.vIT = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(28332);
                    return 0;
                case 3:
                    gtVar.vIU = aVar3.BTU.readString();
                    AppMethodBeat.o(28332);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        gtVar.vIn = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(28332);
                    return 0;
                case 5:
                    gtVar.vIW = aVar3.BTU.readString();
                    AppMethodBeat.o(28332);
                    return 0;
                case 6:
                    gtVar.vIX = aVar3.BTU.readString();
                    AppMethodBeat.o(28332);
                    return 0;
                case 7:
                    gtVar.vIV = aVar3.BTU.vd();
                    AppMethodBeat.o(28332);
                    return 0;
                case 8:
                    gtVar.ID = aVar3.BTU.readString();
                    AppMethodBeat.o(28332);
                    return 0;
                case 9:
                    gtVar.vIS = aVar3.BTU.readString();
                    AppMethodBeat.o(28332);
                    return 0;
                default:
                    AppMethodBeat.o(28332);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28332);
            return -1;
        }
    }
}
