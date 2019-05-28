package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class aaw extends a {
    public String appId;
    public String cEV;
    public abf cKb;
    public String csl;
    public String desc;
    public String title;
    public int type;
    public String wif;
    public LinkedList<String> wig = new LinkedList();

    public aaw() {
        AppMethodBeat.i(51396);
        AppMethodBeat.o(51396);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51397);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            if (this.cEV != null) {
                aVar.e(3, this.cEV);
            }
            if (this.wif != null) {
                aVar.e(4, this.wif);
            }
            if (this.appId != null) {
                aVar.e(5, this.appId);
            }
            if (this.csl != null) {
                aVar.e(6, this.csl);
            }
            aVar.e(7, 1, this.wig);
            aVar.iz(8, this.type);
            if (this.cKb != null) {
                aVar.iy(9, this.cKb.computeSize());
                this.cKb.writeFields(aVar);
            }
            AppMethodBeat.o(51397);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = e.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.desc != null) {
                f += e.a.a.b.b.a.f(2, this.desc);
            }
            if (this.cEV != null) {
                f += e.a.a.b.b.a.f(3, this.cEV);
            }
            if (this.wif != null) {
                f += e.a.a.b.b.a.f(4, this.wif);
            }
            if (this.appId != null) {
                f += e.a.a.b.b.a.f(5, this.appId);
            }
            if (this.csl != null) {
                f += e.a.a.b.b.a.f(6, this.csl);
            }
            f = (f + e.a.a.a.c(7, 1, this.wig)) + e.a.a.b.b.a.bs(8, this.type);
            if (this.cKb != null) {
                f += e.a.a.a.ix(9, this.cKb.computeSize());
            }
            AppMethodBeat.o(51397);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wig.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(51397);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aaw aaw = (aaw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aaw.title = aVar3.BTU.readString();
                    AppMethodBeat.o(51397);
                    return 0;
                case 2:
                    aaw.desc = aVar3.BTU.readString();
                    AppMethodBeat.o(51397);
                    return 0;
                case 3:
                    aaw.cEV = aVar3.BTU.readString();
                    AppMethodBeat.o(51397);
                    return 0;
                case 4:
                    aaw.wif = aVar3.BTU.readString();
                    AppMethodBeat.o(51397);
                    return 0;
                case 5:
                    aaw.appId = aVar3.BTU.readString();
                    AppMethodBeat.o(51397);
                    return 0;
                case 6:
                    aaw.csl = aVar3.BTU.readString();
                    AppMethodBeat.o(51397);
                    return 0;
                case 7:
                    aaw.wig.add(aVar3.BTU.readString());
                    AppMethodBeat.o(51397);
                    return 0;
                case 8:
                    aaw.type = aVar3.BTU.vd();
                    AppMethodBeat.o(51397);
                    return 0;
                case 9:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        abf abf = new abf();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = abf.populateBuilderWithField(aVar4, abf, a.getNextFieldNumber(aVar4))) {
                        }
                        aaw.cKb = abf;
                    }
                    AppMethodBeat.o(51397);
                    return 0;
                default:
                    AppMethodBeat.o(51397);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51397);
            return -1;
        }
    }
}
