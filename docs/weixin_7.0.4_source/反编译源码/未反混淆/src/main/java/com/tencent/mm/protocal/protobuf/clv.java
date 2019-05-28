package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class clv extends bsr {
    public int Scene;
    public String ndF;
    public String ndG;
    public SKBuiltinBuffer_t ptz;
    public clu vZA;
    public String vZx;
    public coa vZy;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28690);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vZy == null) {
                bVar = new b("Not all required fields were included: VoiceAttr");
                AppMethodBeat.o(28690);
                throw bVar;
            } else if (this.vZA == null) {
                bVar = new b("Not all required fields were included: UploadCtx");
                AppMethodBeat.o(28690);
                throw bVar;
            } else if (this.ptz == null) {
                bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(28690);
                throw bVar;
            } else {
                if (this.BaseRequest != null) {
                    aVar.iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.vZx != null) {
                    aVar.e(2, this.vZx);
                }
                if (this.vZy != null) {
                    aVar.iy(3, this.vZy.computeSize());
                    this.vZy.writeFields(aVar);
                }
                if (this.vZA != null) {
                    aVar.iy(4, this.vZA.computeSize());
                    this.vZA.writeFields(aVar);
                }
                if (this.ptz != null) {
                    aVar.iy(5, this.ptz.computeSize());
                    this.ptz.writeFields(aVar);
                }
                aVar.iz(6, this.Scene);
                if (this.ndG != null) {
                    aVar.e(7, this.ndG);
                }
                if (this.ndF != null) {
                    aVar.e(8, this.ndF);
                }
                AppMethodBeat.o(28690);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vZx != null) {
                ix += e.a.a.b.b.a.f(2, this.vZx);
            }
            if (this.vZy != null) {
                ix += e.a.a.a.ix(3, this.vZy.computeSize());
            }
            if (this.vZA != null) {
                ix += e.a.a.a.ix(4, this.vZA.computeSize());
            }
            if (this.ptz != null) {
                ix += e.a.a.a.ix(5, this.ptz.computeSize());
            }
            ix += e.a.a.b.b.a.bs(6, this.Scene);
            if (this.ndG != null) {
                ix += e.a.a.b.b.a.f(7, this.ndG);
            }
            if (this.ndF != null) {
                ix += e.a.a.b.b.a.f(8, this.ndF);
            }
            AppMethodBeat.o(28690);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.vZy == null) {
                bVar = new b("Not all required fields were included: VoiceAttr");
                AppMethodBeat.o(28690);
                throw bVar;
            } else if (this.vZA == null) {
                bVar = new b("Not all required fields were included: UploadCtx");
                AppMethodBeat.o(28690);
                throw bVar;
            } else if (this.ptz == null) {
                bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(28690);
                throw bVar;
            } else {
                AppMethodBeat.o(28690);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            clv clv = (clv) objArr[1];
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
                        clv.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28690);
                    return 0;
                case 2:
                    clv.vZx = aVar3.BTU.readString();
                    AppMethodBeat.o(28690);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        coa coa = new coa();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = coa.populateBuilderWithField(aVar4, coa, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        clv.vZy = coa;
                    }
                    AppMethodBeat.o(28690);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        clu clu = new clu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = clu.populateBuilderWithField(aVar4, clu, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        clv.vZA = clu;
                    }
                    AppMethodBeat.o(28690);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        clv.ptz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(28690);
                    return 0;
                case 6:
                    clv.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(28690);
                    return 0;
                case 7:
                    clv.ndG = aVar3.BTU.readString();
                    AppMethodBeat.o(28690);
                    return 0;
                case 8:
                    clv.ndF = aVar3.BTU.readString();
                    AppMethodBeat.o(28690);
                    return 0;
                default:
                    AppMethodBeat.o(28690);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28690);
            return -1;
        }
    }
}
