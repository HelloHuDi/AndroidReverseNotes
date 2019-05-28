package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bvv extends a {
    public xu vHF;
    public SKBuiltinBuffer_t vHG;
    public SKBuiltinBuffer_t vHH;
    public int vHV;
    public SKBuiltinBuffer_t vHY;
    public SKBuiltinBuffer_t vHZ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(58930);
        b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vHH == null) {
                bVar = new b("Not all required fields were included: AutoAuthKey");
                AppMethodBeat.o(58930);
                throw bVar;
            } else if (this.vHF == null) {
                bVar = new b("Not all required fields were included: SvrPubECDHKey");
                AppMethodBeat.o(58930);
                throw bVar;
            } else if (this.vHG == null) {
                bVar = new b("Not all required fields were included: SessionKey");
                AppMethodBeat.o(58930);
                throw bVar;
            } else {
                if (this.vHH != null) {
                    aVar.iy(1, this.vHH.computeSize());
                    this.vHH.writeFields(aVar);
                }
                if (this.vHF != null) {
                    aVar.iy(2, this.vHF.computeSize());
                    this.vHF.writeFields(aVar);
                }
                if (this.vHG != null) {
                    aVar.iy(3, this.vHG.computeSize());
                    this.vHG.writeFields(aVar);
                }
                aVar.iz(4, this.vHV);
                if (this.vHY != null) {
                    aVar.iy(5, this.vHY.computeSize());
                    this.vHY.writeFields(aVar);
                }
                if (this.vHZ != null) {
                    aVar.iy(6, this.vHZ.computeSize());
                    this.vHZ.writeFields(aVar);
                }
                AppMethodBeat.o(58930);
                return 0;
            }
        } else if (i == 1) {
            if (this.vHH != null) {
                ix = e.a.a.a.ix(1, this.vHH.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vHF != null) {
                ix += e.a.a.a.ix(2, this.vHF.computeSize());
            }
            if (this.vHG != null) {
                ix += e.a.a.a.ix(3, this.vHG.computeSize());
            }
            ix += e.a.a.b.b.a.bs(4, this.vHV);
            if (this.vHY != null) {
                ix += e.a.a.a.ix(5, this.vHY.computeSize());
            }
            if (this.vHZ != null) {
                ix += e.a.a.a.ix(6, this.vHZ.computeSize());
            }
            AppMethodBeat.o(58930);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.vHH == null) {
                bVar = new b("Not all required fields were included: AutoAuthKey");
                AppMethodBeat.o(58930);
                throw bVar;
            } else if (this.vHF == null) {
                bVar = new b("Not all required fields were included: SvrPubECDHKey");
                AppMethodBeat.o(58930);
                throw bVar;
            } else if (this.vHG == null) {
                bVar = new b("Not all required fields were included: SessionKey");
                AppMethodBeat.o(58930);
                throw bVar;
            } else {
                AppMethodBeat.o(58930);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bvv bvv = (bvv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        bvv.vHH = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(58930);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        xu xuVar = new xu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xuVar.populateBuilderWithField(aVar4, xuVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bvv.vHF = xuVar;
                    }
                    AppMethodBeat.o(58930);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        bvv.vHG = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(58930);
                    return 0;
                case 4:
                    bvv.vHV = aVar3.BTU.vd();
                    AppMethodBeat.o(58930);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        bvv.vHY = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(58930);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        bvv.vHZ = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(58930);
                    return 0;
                default:
                    AppMethodBeat.o(58930);
                    return -1;
            }
        } else {
            AppMethodBeat.o(58930);
            return -1;
        }
    }
}
