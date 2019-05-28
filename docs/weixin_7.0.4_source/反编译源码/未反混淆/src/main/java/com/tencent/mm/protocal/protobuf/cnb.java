package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cnb extends bsr {
    public String ProductID;
    public int pdc;
    public String wOs;
    public String wOt;
    public int wOu;
    public String wOv;
    public int xkA;
    public String xkB;
    public SKBuiltinBuffer_t xky;
    public int xkz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56992);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.xky == null) {
                bVar = new b("Not all required fields were included: Receipt");
                AppMethodBeat.o(56992);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.xky != null) {
                aVar.iy(2, this.xky.computeSize());
                this.xky.writeFields(aVar);
            }
            if (this.ProductID != null) {
                aVar.e(3, this.ProductID);
            }
            aVar.iz(4, this.xkz);
            aVar.iz(5, this.pdc);
            if (this.wOs != null) {
                aVar.e(6, this.wOs);
            }
            if (this.wOt != null) {
                aVar.e(7, this.wOt);
            }
            if (this.wOv != null) {
                aVar.e(8, this.wOv);
            }
            aVar.iz(9, this.xkA);
            if (this.xkB != null) {
                aVar.e(10, this.xkB);
            }
            aVar.iz(11, this.wOu);
            AppMethodBeat.o(56992);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.xky != null) {
                ix += e.a.a.a.ix(2, this.xky.computeSize());
            }
            if (this.ProductID != null) {
                ix += e.a.a.b.b.a.f(3, this.ProductID);
            }
            ix = (ix + e.a.a.b.b.a.bs(4, this.xkz)) + e.a.a.b.b.a.bs(5, this.pdc);
            if (this.wOs != null) {
                ix += e.a.a.b.b.a.f(6, this.wOs);
            }
            if (this.wOt != null) {
                ix += e.a.a.b.b.a.f(7, this.wOt);
            }
            if (this.wOv != null) {
                ix += e.a.a.b.b.a.f(8, this.wOv);
            }
            ix += e.a.a.b.b.a.bs(9, this.xkA);
            if (this.xkB != null) {
                ix += e.a.a.b.b.a.f(10, this.xkB);
            }
            int bs = ix + e.a.a.b.b.a.bs(11, this.wOu);
            AppMethodBeat.o(56992);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.xky == null) {
                bVar = new b("Not all required fields were included: Receipt");
                AppMethodBeat.o(56992);
                throw bVar;
            }
            AppMethodBeat.o(56992);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cnb cnb = (cnb) objArr[1];
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
                        hl hlVar = new hl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cnb.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56992);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cnb.xky = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(56992);
                    return 0;
                case 3:
                    cnb.ProductID = aVar3.BTU.readString();
                    AppMethodBeat.o(56992);
                    return 0;
                case 4:
                    cnb.xkz = aVar3.BTU.vd();
                    AppMethodBeat.o(56992);
                    return 0;
                case 5:
                    cnb.pdc = aVar3.BTU.vd();
                    AppMethodBeat.o(56992);
                    return 0;
                case 6:
                    cnb.wOs = aVar3.BTU.readString();
                    AppMethodBeat.o(56992);
                    return 0;
                case 7:
                    cnb.wOt = aVar3.BTU.readString();
                    AppMethodBeat.o(56992);
                    return 0;
                case 8:
                    cnb.wOv = aVar3.BTU.readString();
                    AppMethodBeat.o(56992);
                    return 0;
                case 9:
                    cnb.xkA = aVar3.BTU.vd();
                    AppMethodBeat.o(56992);
                    return 0;
                case 10:
                    cnb.xkB = aVar3.BTU.readString();
                    AppMethodBeat.o(56992);
                    return 0;
                case 11:
                    cnb.wOu = aVar3.BTU.vd();
                    AppMethodBeat.o(56992);
                    return 0;
                default:
                    AppMethodBeat.o(56992);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56992);
            return -1;
        }
    }
}
