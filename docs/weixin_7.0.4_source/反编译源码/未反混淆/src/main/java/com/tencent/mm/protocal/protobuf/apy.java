package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class apy extends bsr {
    public SKBuiltinBuffer_t vLz;
    public bts wcB;
    public bts wtY;
    public bts wtZ;
    public SKBuiltinBuffer_t wua;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73719);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wcB == null) {
                bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(73719);
                throw bVar;
            } else if (this.wtY == null) {
                bVar = new b("Not all required fields were included: Pwd");
                AppMethodBeat.o(73719);
                throw bVar;
            } else {
                if (this.BaseRequest != null) {
                    aVar.iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.wcB != null) {
                    aVar.iy(2, this.wcB.computeSize());
                    this.wcB.writeFields(aVar);
                }
                if (this.wtY != null) {
                    aVar.iy(3, this.wtY.computeSize());
                    this.wtY.writeFields(aVar);
                }
                if (this.wtZ != null) {
                    aVar.iy(4, this.wtZ.computeSize());
                    this.wtZ.writeFields(aVar);
                }
                if (this.vLz != null) {
                    aVar.iy(5, this.vLz.computeSize());
                    this.vLz.writeFields(aVar);
                }
                if (this.wua != null) {
                    aVar.iy(6, this.wua.computeSize());
                    this.wua.writeFields(aVar);
                }
                AppMethodBeat.o(73719);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wcB != null) {
                ix += e.a.a.a.ix(2, this.wcB.computeSize());
            }
            if (this.wtY != null) {
                ix += e.a.a.a.ix(3, this.wtY.computeSize());
            }
            if (this.wtZ != null) {
                ix += e.a.a.a.ix(4, this.wtZ.computeSize());
            }
            if (this.vLz != null) {
                ix += e.a.a.a.ix(5, this.vLz.computeSize());
            }
            if (this.wua != null) {
                ix += e.a.a.a.ix(6, this.wua.computeSize());
            }
            AppMethodBeat.o(73719);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wcB == null) {
                bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(73719);
                throw bVar;
            } else if (this.wtY == null) {
                bVar = new b("Not all required fields were included: Pwd");
                AppMethodBeat.o(73719);
                throw bVar;
            } else {
                AppMethodBeat.o(73719);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            apy apy = (apy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            bts bts;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
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
                        apy.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(73719);
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
                        apy.wcB = bts;
                    }
                    AppMethodBeat.o(73719);
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
                        apy.wtY = bts;
                    }
                    AppMethodBeat.o(73719);
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
                        apy.wtZ = bts;
                    }
                    AppMethodBeat.o(73719);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        apy.vLz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(73719);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        apy.wua = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(73719);
                    return 0;
                default:
                    AppMethodBeat.o(73719);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73719);
            return -1;
        }
    }
}
