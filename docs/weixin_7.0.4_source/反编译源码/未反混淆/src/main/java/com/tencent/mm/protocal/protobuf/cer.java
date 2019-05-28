package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cer extends a {
    public String jBB;
    public String jCH;
    public int pcX;
    public long vQE;
    public int wGu;
    public int xar;
    public int xek;
    public int xem;
    public SKBuiltinBuffer_t xen;
    public LinkedList<cdv> xeo = new LinkedList();
    public int xep;
    public LinkedList<cdv> xeq = new LinkedList();
    public int xer;
    public int xes;

    public cer() {
        AppMethodBeat.i(56534);
        AppMethodBeat.o(56534);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56535);
        b bVar;
        int o;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xen == null) {
                bVar = new b("Not all required fields were included: ObjDesc");
                AppMethodBeat.o(56535);
                throw bVar;
            }
            aVar.ai(1, this.vQE);
            if (this.jBB != null) {
                aVar.e(2, this.jBB);
            }
            if (this.jCH != null) {
                aVar.e(3, this.jCH);
            }
            aVar.iz(4, this.pcX);
            aVar.iz(5, this.xem);
            if (this.xen != null) {
                aVar.iy(6, this.xen.computeSize());
                this.xen.writeFields(aVar);
            }
            aVar.iz(7, this.xar);
            aVar.e(8, 8, this.xeo);
            aVar.iz(9, this.xep);
            aVar.e(10, 8, this.xeq);
            aVar.iz(11, this.wGu);
            aVar.iz(12, this.xer);
            aVar.iz(13, this.xek);
            aVar.iz(14, this.xes);
            AppMethodBeat.o(56535);
            return 0;
        } else if (i == 1) {
            o = e.a.a.b.b.a.o(1, this.vQE) + 0;
            if (this.jBB != null) {
                o += e.a.a.b.b.a.f(2, this.jBB);
            }
            if (this.jCH != null) {
                o += e.a.a.b.b.a.f(3, this.jCH);
            }
            o = (o + e.a.a.b.b.a.bs(4, this.pcX)) + e.a.a.b.b.a.bs(5, this.xem);
            if (this.xen != null) {
                o += e.a.a.a.ix(6, this.xen.computeSize());
            }
            o = (((((((o + e.a.a.b.b.a.bs(7, this.xar)) + e.a.a.a.c(8, 8, this.xeo)) + e.a.a.b.b.a.bs(9, this.xep)) + e.a.a.a.c(10, 8, this.xeq)) + e.a.a.b.b.a.bs(11, this.wGu)) + e.a.a.b.b.a.bs(12, this.xer)) + e.a.a.b.b.a.bs(13, this.xek)) + e.a.a.b.b.a.bs(14, this.xes);
            AppMethodBeat.o(56535);
            return o;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xeo.clear();
            this.xeq.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            if (this.xen == null) {
                bVar = new b("Not all required fields were included: ObjDesc");
                AppMethodBeat.o(56535);
                throw bVar;
            }
            AppMethodBeat.o(56535);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cer cer = (cer) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            cdv cdv;
            switch (intValue) {
                case 1:
                    cer.vQE = aVar3.BTU.ve();
                    AppMethodBeat.o(56535);
                    return 0;
                case 2:
                    cer.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(56535);
                    return 0;
                case 3:
                    cer.jCH = aVar3.BTU.readString();
                    AppMethodBeat.o(56535);
                    return 0;
                case 4:
                    cer.pcX = aVar3.BTU.vd();
                    AppMethodBeat.o(56535);
                    return 0;
                case 5:
                    cer.xem = aVar3.BTU.vd();
                    AppMethodBeat.o(56535);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        cer.xen = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(56535);
                    return 0;
                case 7:
                    cer.xar = aVar3.BTU.vd();
                    AppMethodBeat.o(56535);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdv = new cdv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdv.populateBuilderWithField(aVar4, cdv, a.getNextFieldNumber(aVar4))) {
                        }
                        cer.xeo.add(cdv);
                    }
                    AppMethodBeat.o(56535);
                    return 0;
                case 9:
                    cer.xep = aVar3.BTU.vd();
                    AppMethodBeat.o(56535);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdv = new cdv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdv.populateBuilderWithField(aVar4, cdv, a.getNextFieldNumber(aVar4))) {
                        }
                        cer.xeq.add(cdv);
                    }
                    AppMethodBeat.o(56535);
                    return 0;
                case 11:
                    cer.wGu = aVar3.BTU.vd();
                    AppMethodBeat.o(56535);
                    return 0;
                case 12:
                    cer.xer = aVar3.BTU.vd();
                    AppMethodBeat.o(56535);
                    return 0;
                case 13:
                    cer.xek = aVar3.BTU.vd();
                    AppMethodBeat.o(56535);
                    return 0;
                case 14:
                    cer.xes = aVar3.BTU.vd();
                    AppMethodBeat.o(56535);
                    return 0;
                default:
                    AppMethodBeat.o(56535);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56535);
            return -1;
        }
    }
}
