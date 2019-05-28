package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class chi extends a {
    public String Md5;
    public int Version;
    public int jCt;
    public String vZm;
    public int vZn;
    public int wUX;
    public String wld;
    public LinkedList<chh> xgc = new LinkedList();
    public boolean xgd;
    public LinkedList<chj> xge = new LinkedList();
    public String xgf;

    public chi() {
        AppMethodBeat.i(14756);
        AppMethodBeat.o(14756);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(14757);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.jCt);
            aVar.iz(2, this.Version);
            if (this.vZm != null) {
                aVar.e(3, this.vZm);
            }
            if (this.Md5 != null) {
                aVar.e(4, this.Md5);
            }
            aVar.iz(5, this.vZn);
            aVar.iz(6, this.wUX);
            aVar.e(7, 8, this.xgc);
            aVar.aO(8, this.xgd);
            if (this.wld != null) {
                aVar.e(9, this.wld);
            }
            aVar.e(10, 8, this.xge);
            if (this.xgf != null) {
                aVar.e(11, this.xgf);
            }
            AppMethodBeat.o(14757);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.jCt) + 0) + e.a.a.b.b.a.bs(2, this.Version);
            if (this.vZm != null) {
                bs += e.a.a.b.b.a.f(3, this.vZm);
            }
            if (this.Md5 != null) {
                bs += e.a.a.b.b.a.f(4, this.Md5);
            }
            bs = (((bs + e.a.a.b.b.a.bs(5, this.vZn)) + e.a.a.b.b.a.bs(6, this.wUX)) + e.a.a.a.c(7, 8, this.xgc)) + (e.a.a.b.b.a.fv(8) + 1);
            if (this.wld != null) {
                bs += e.a.a.b.b.a.f(9, this.wld);
            }
            bs += e.a.a.a.c(10, 8, this.xge);
            if (this.xgf != null) {
                bs += e.a.a.b.b.a.f(11, this.xgf);
            }
            AppMethodBeat.o(14757);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xgc.clear();
            this.xge.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(14757);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            chi chi = (chi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    chi.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(14757);
                    return 0;
                case 2:
                    chi.Version = aVar3.BTU.vd();
                    AppMethodBeat.o(14757);
                    return 0;
                case 3:
                    chi.vZm = aVar3.BTU.readString();
                    AppMethodBeat.o(14757);
                    return 0;
                case 4:
                    chi.Md5 = aVar3.BTU.readString();
                    AppMethodBeat.o(14757);
                    return 0;
                case 5:
                    chi.vZn = aVar3.BTU.vd();
                    AppMethodBeat.o(14757);
                    return 0;
                case 6:
                    chi.wUX = aVar3.BTU.vd();
                    AppMethodBeat.o(14757);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        chh chh = new chh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = chh.populateBuilderWithField(aVar4, chh, a.getNextFieldNumber(aVar4))) {
                        }
                        chi.xgc.add(chh);
                    }
                    AppMethodBeat.o(14757);
                    return 0;
                case 8:
                    chi.xgd = aVar3.BTU.ehX();
                    AppMethodBeat.o(14757);
                    return 0;
                case 9:
                    chi.wld = aVar3.BTU.readString();
                    AppMethodBeat.o(14757);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        chj chj = new chj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = chj.populateBuilderWithField(aVar4, chj, a.getNextFieldNumber(aVar4))) {
                        }
                        chi.xge.add(chj);
                    }
                    AppMethodBeat.o(14757);
                    return 0;
                case 11:
                    chi.xgf = aVar3.BTU.readString();
                    AppMethodBeat.o(14757);
                    return 0;
                default:
                    AppMethodBeat.o(14757);
                    return -1;
            }
        } else {
            AppMethodBeat.o(14757);
            return -1;
        }
    }
}
