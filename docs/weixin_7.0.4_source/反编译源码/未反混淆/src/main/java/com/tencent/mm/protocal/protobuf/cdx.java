package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cdx extends bsr {
    public String ptv;
    public String vGA;
    public cdv xdF;
    public cdv xdG;
    public int xdH;
    public int xdI;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56504);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.xdF == null) {
                bVar = new b("Not all required fields were included: CommentDetail");
                AppMethodBeat.o(56504);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.ptv != null) {
                aVar.e(2, this.ptv);
            }
            if (this.xdF != null) {
                aVar.iy(3, this.xdF.computeSize());
                this.xdF.writeFields(aVar);
            }
            if (this.xdG != null) {
                aVar.iy(6, this.xdG.computeSize());
                this.xdG.writeFields(aVar);
            }
            aVar.iz(4, this.xdH);
            aVar.iz(5, this.xdI);
            if (this.vGA != null) {
                aVar.e(7, this.vGA);
            }
            AppMethodBeat.o(56504);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.ptv != null) {
                ix += e.a.a.b.b.a.f(2, this.ptv);
            }
            if (this.xdF != null) {
                ix += e.a.a.a.ix(3, this.xdF.computeSize());
            }
            if (this.xdG != null) {
                ix += e.a.a.a.ix(6, this.xdG.computeSize());
            }
            ix = (ix + e.a.a.b.b.a.bs(4, this.xdH)) + e.a.a.b.b.a.bs(5, this.xdI);
            if (this.vGA != null) {
                ix += e.a.a.b.b.a.f(7, this.vGA);
            }
            AppMethodBeat.o(56504);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.xdF == null) {
                bVar = new b("Not all required fields were included: CommentDetail");
                AppMethodBeat.o(56504);
                throw bVar;
            }
            AppMethodBeat.o(56504);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cdx cdx = (cdx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            cdv cdv;
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
                        cdx.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56504);
                    return 0;
                case 2:
                    cdx.ptv = aVar3.BTU.readString();
                    AppMethodBeat.o(56504);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdv = new cdv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdv.populateBuilderWithField(aVar4, cdv, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cdx.xdF = cdv;
                    }
                    AppMethodBeat.o(56504);
                    return 0;
                case 4:
                    cdx.xdH = aVar3.BTU.vd();
                    AppMethodBeat.o(56504);
                    return 0;
                case 5:
                    cdx.xdI = aVar3.BTU.vd();
                    AppMethodBeat.o(56504);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdv = new cdv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdv.populateBuilderWithField(aVar4, cdv, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cdx.xdG = cdv;
                    }
                    AppMethodBeat.o(56504);
                    return 0;
                case 7:
                    cdx.vGA = aVar3.BTU.readString();
                    AppMethodBeat.o(56504);
                    return 0;
                default:
                    AppMethodBeat.o(56504);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56504);
            return -1;
        }
    }
}
