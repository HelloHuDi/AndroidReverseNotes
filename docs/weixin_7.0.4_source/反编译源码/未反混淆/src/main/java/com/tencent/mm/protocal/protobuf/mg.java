package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class mg extends a {
    public String jCH;
    public String mZj;
    public mi vPY;
    public bvo vQb;
    public mo vQc;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124293);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.jCH == null) {
                bVar = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(124293);
                throw bVar;
            } else if (this.vQb == null) {
                bVar = new b("Not all required fields were included: ContactItem");
                AppMethodBeat.o(124293);
                throw bVar;
            } else {
                if (this.jCH != null) {
                    aVar.e(1, this.jCH);
                }
                if (this.vPY != null) {
                    aVar.iy(2, this.vPY.computeSize());
                    this.vPY.writeFields(aVar);
                }
                if (this.vQb != null) {
                    aVar.iy(3, this.vQb.computeSize());
                    this.vQb.writeFields(aVar);
                }
                if (this.vQc != null) {
                    aVar.iy(4, this.vQc.computeSize());
                    this.vQc.writeFields(aVar);
                }
                if (this.mZj != null) {
                    aVar.e(5, this.mZj);
                }
                AppMethodBeat.o(124293);
                return 0;
            }
        } else if (i == 1) {
            if (this.jCH != null) {
                f = e.a.a.b.b.a.f(1, this.jCH) + 0;
            } else {
                f = 0;
            }
            if (this.vPY != null) {
                f += e.a.a.a.ix(2, this.vPY.computeSize());
            }
            if (this.vQb != null) {
                f += e.a.a.a.ix(3, this.vQb.computeSize());
            }
            if (this.vQc != null) {
                f += e.a.a.a.ix(4, this.vQc.computeSize());
            }
            if (this.mZj != null) {
                f += e.a.a.b.b.a.f(5, this.mZj);
            }
            AppMethodBeat.o(124293);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.jCH == null) {
                bVar = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(124293);
                throw bVar;
            } else if (this.vQb == null) {
                bVar = new b("Not all required fields were included: ContactItem");
                AppMethodBeat.o(124293);
                throw bVar;
            } else {
                AppMethodBeat.o(124293);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            mg mgVar = (mg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    mgVar.jCH = aVar3.BTU.readString();
                    AppMethodBeat.o(124293);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mi miVar = new mi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = miVar.populateBuilderWithField(aVar4, miVar, a.getNextFieldNumber(aVar4))) {
                        }
                        mgVar.vPY = miVar;
                    }
                    AppMethodBeat.o(124293);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bvo bvo = new bvo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bvo.populateBuilderWithField(aVar4, bvo, a.getNextFieldNumber(aVar4))) {
                        }
                        mgVar.vQb = bvo;
                    }
                    AppMethodBeat.o(124293);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mo moVar = new mo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = moVar.populateBuilderWithField(aVar4, moVar, a.getNextFieldNumber(aVar4))) {
                        }
                        mgVar.vQc = moVar;
                    }
                    AppMethodBeat.o(124293);
                    return 0;
                case 5:
                    mgVar.mZj = aVar3.BTU.readString();
                    AppMethodBeat.o(124293);
                    return 0;
                default:
                    AppMethodBeat.o(124293);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124293);
            return -1;
        }
    }
}
