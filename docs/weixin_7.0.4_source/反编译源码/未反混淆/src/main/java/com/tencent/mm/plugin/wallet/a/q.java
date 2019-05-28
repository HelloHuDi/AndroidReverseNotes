package com.tencent.mm.plugin.wallet.a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class q extends a {
    public String desc;
    public String fjD;
    public String id;
    public String name;
    public int status;
    public String tmN;
    public String tnt;
    public String tnu;
    public String tnv = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    public String tnw = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    public int tnx = 0;
    public int tny;
    public String tnz;
    public int type;
    public String url;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56660);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.id != null) {
                aVar.e(1, this.id);
            }
            if (this.name != null) {
                aVar.e(2, this.name);
            }
            if (this.desc != null) {
                aVar.e(3, this.desc);
            }
            aVar.iz(4, this.status);
            if (this.url != null) {
                aVar.e(5, this.url);
            }
            aVar.iz(6, this.type);
            if (this.tnt != null) {
                aVar.e(7, this.tnt);
            }
            if (this.tnu != null) {
                aVar.e(8, this.tnu);
            }
            if (this.tnv != null) {
                aVar.e(9, this.tnv);
            }
            if (this.tnw != null) {
                aVar.e(10, this.tnw);
            }
            aVar.iz(11, this.tnx);
            if (this.tmN != null) {
                aVar.e(12, this.tmN);
            }
            if (this.fjD != null) {
                aVar.e(13, this.fjD);
            }
            aVar.iz(14, this.tny);
            if (this.tnz != null) {
                aVar.e(15, this.tnz);
            }
            AppMethodBeat.o(56660);
            return 0;
        } else if (i == 1) {
            if (this.id != null) {
                f = e.a.a.b.b.a.f(1, this.id) + 0;
            } else {
                f = 0;
            }
            if (this.name != null) {
                f += e.a.a.b.b.a.f(2, this.name);
            }
            if (this.desc != null) {
                f += e.a.a.b.b.a.f(3, this.desc);
            }
            f += e.a.a.b.b.a.bs(4, this.status);
            if (this.url != null) {
                f += e.a.a.b.b.a.f(5, this.url);
            }
            f += e.a.a.b.b.a.bs(6, this.type);
            if (this.tnt != null) {
                f += e.a.a.b.b.a.f(7, this.tnt);
            }
            if (this.tnu != null) {
                f += e.a.a.b.b.a.f(8, this.tnu);
            }
            if (this.tnv != null) {
                f += e.a.a.b.b.a.f(9, this.tnv);
            }
            if (this.tnw != null) {
                f += e.a.a.b.b.a.f(10, this.tnw);
            }
            f += e.a.a.b.b.a.bs(11, this.tnx);
            if (this.tmN != null) {
                f += e.a.a.b.b.a.f(12, this.tmN);
            }
            if (this.fjD != null) {
                f += e.a.a.b.b.a.f(13, this.fjD);
            }
            f += e.a.a.b.b.a.bs(14, this.tny);
            if (this.tnz != null) {
                f += e.a.a.b.b.a.f(15, this.tnz);
            }
            AppMethodBeat.o(56660);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56660);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            q qVar = (q) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qVar.id = aVar3.BTU.readString();
                    AppMethodBeat.o(56660);
                    return 0;
                case 2:
                    qVar.name = aVar3.BTU.readString();
                    AppMethodBeat.o(56660);
                    return 0;
                case 3:
                    qVar.desc = aVar3.BTU.readString();
                    AppMethodBeat.o(56660);
                    return 0;
                case 4:
                    qVar.status = aVar3.BTU.vd();
                    AppMethodBeat.o(56660);
                    return 0;
                case 5:
                    qVar.url = aVar3.BTU.readString();
                    AppMethodBeat.o(56660);
                    return 0;
                case 6:
                    qVar.type = aVar3.BTU.vd();
                    AppMethodBeat.o(56660);
                    return 0;
                case 7:
                    qVar.tnt = aVar3.BTU.readString();
                    AppMethodBeat.o(56660);
                    return 0;
                case 8:
                    qVar.tnu = aVar3.BTU.readString();
                    AppMethodBeat.o(56660);
                    return 0;
                case 9:
                    qVar.tnv = aVar3.BTU.readString();
                    AppMethodBeat.o(56660);
                    return 0;
                case 10:
                    qVar.tnw = aVar3.BTU.readString();
                    AppMethodBeat.o(56660);
                    return 0;
                case 11:
                    qVar.tnx = aVar3.BTU.vd();
                    AppMethodBeat.o(56660);
                    return 0;
                case 12:
                    qVar.tmN = aVar3.BTU.readString();
                    AppMethodBeat.o(56660);
                    return 0;
                case 13:
                    qVar.fjD = aVar3.BTU.readString();
                    AppMethodBeat.o(56660);
                    return 0;
                case 14:
                    qVar.tny = aVar3.BTU.vd();
                    AppMethodBeat.o(56660);
                    return 0;
                case 15:
                    qVar.tnz = aVar3.BTU.readString();
                    AppMethodBeat.o(56660);
                    return 0;
                default:
                    AppMethodBeat.o(56660);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56660);
            return -1;
        }
    }
}
