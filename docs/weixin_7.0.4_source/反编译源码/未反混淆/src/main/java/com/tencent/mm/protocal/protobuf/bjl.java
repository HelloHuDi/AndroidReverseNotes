package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bjl extends a {
    public String desc;
    public String kbV;
    public String name;
    public String title;
    public int ttd;
    public String tte;
    public String ttg;
    public String tzW;
    public bqo wMS;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48918);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.name != null) {
                aVar.e(1, this.name);
            }
            if (this.title != null) {
                aVar.e(2, this.title);
            }
            if (this.desc != null) {
                aVar.e(3, this.desc);
            }
            if (this.kbV != null) {
                aVar.e(4, this.kbV);
            }
            aVar.iz(5, this.ttd);
            if (this.tte != null) {
                aVar.e(6, this.tte);
            }
            if (this.tzW != null) {
                aVar.e(7, this.tzW);
            }
            if (this.ttg != null) {
                aVar.e(8, this.ttg);
            }
            if (this.wMS != null) {
                aVar.iy(9, this.wMS.computeSize());
                this.wMS.writeFields(aVar);
            }
            AppMethodBeat.o(48918);
            return 0;
        } else if (i == 1) {
            if (this.name != null) {
                f = e.a.a.b.b.a.f(1, this.name) + 0;
            } else {
                f = 0;
            }
            if (this.title != null) {
                f += e.a.a.b.b.a.f(2, this.title);
            }
            if (this.desc != null) {
                f += e.a.a.b.b.a.f(3, this.desc);
            }
            if (this.kbV != null) {
                f += e.a.a.b.b.a.f(4, this.kbV);
            }
            f += e.a.a.b.b.a.bs(5, this.ttd);
            if (this.tte != null) {
                f += e.a.a.b.b.a.f(6, this.tte);
            }
            if (this.tzW != null) {
                f += e.a.a.b.b.a.f(7, this.tzW);
            }
            if (this.ttg != null) {
                f += e.a.a.b.b.a.f(8, this.ttg);
            }
            if (this.wMS != null) {
                f += e.a.a.a.ix(9, this.wMS.computeSize());
            }
            AppMethodBeat.o(48918);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48918);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bjl bjl = (bjl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bjl.name = aVar3.BTU.readString();
                    AppMethodBeat.o(48918);
                    return 0;
                case 2:
                    bjl.title = aVar3.BTU.readString();
                    AppMethodBeat.o(48918);
                    return 0;
                case 3:
                    bjl.desc = aVar3.BTU.readString();
                    AppMethodBeat.o(48918);
                    return 0;
                case 4:
                    bjl.kbV = aVar3.BTU.readString();
                    AppMethodBeat.o(48918);
                    return 0;
                case 5:
                    bjl.ttd = aVar3.BTU.vd();
                    AppMethodBeat.o(48918);
                    return 0;
                case 6:
                    bjl.tte = aVar3.BTU.readString();
                    AppMethodBeat.o(48918);
                    return 0;
                case 7:
                    bjl.tzW = aVar3.BTU.readString();
                    AppMethodBeat.o(48918);
                    return 0;
                case 8:
                    bjl.ttg = aVar3.BTU.readString();
                    AppMethodBeat.o(48918);
                    return 0;
                case 9:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bqo bqo = new bqo();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bqo.populateBuilderWithField(aVar4, bqo, a.getNextFieldNumber(aVar4))) {
                        }
                        bjl.wMS = bqo;
                    }
                    AppMethodBeat.o(48918);
                    return 0;
                default:
                    AppMethodBeat.o(48918);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48918);
            return -1;
        }
    }
}
