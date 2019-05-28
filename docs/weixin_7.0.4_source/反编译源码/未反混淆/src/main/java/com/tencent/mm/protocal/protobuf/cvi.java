package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cvi extends a {
    public String lvA;
    public String lvz;
    public String phw;
    public String qVw;
    public String source;
    public String thumbUrl;
    public String uaa;
    public String uab;
    public String uac;
    public String uad;
    public long uae;
    public String uaf;
    public String uag;
    public String uah;
    public String uai;
    public String uaj;
    public String uak;
    public String ual;
    public long uam;
    public String uan;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(55714);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.uaa != null) {
                aVar.e(1, this.uaa);
            }
            if (this.uab != null) {
                aVar.e(2, this.uab);
            }
            if (this.uac != null) {
                aVar.e(3, this.uac);
            }
            if (this.uad != null) {
                aVar.e(4, this.uad);
            }
            aVar.ai(5, this.uae);
            if (this.uai != null) {
                aVar.e(6, this.uai);
            }
            if (this.lvz != null) {
                aVar.e(7, this.lvz);
            }
            if (this.lvA != null) {
                aVar.e(8, this.lvA);
            }
            if (this.qVw != null) {
                aVar.e(9, this.qVw);
            }
            if (this.uaf != null) {
                aVar.e(10, this.uaf);
            }
            if (this.uag != null) {
                aVar.e(11, this.uag);
            }
            if (this.uah != null) {
                aVar.e(12, this.uah);
            }
            if (this.source != null) {
                aVar.e(13, this.source);
            }
            if (this.phw != null) {
                aVar.e(14, this.phw);
            }
            if (this.uaj != null) {
                aVar.e(15, this.uaj);
            }
            if (this.uak != null) {
                aVar.e(16, this.uak);
            }
            if (this.ual != null) {
                aVar.e(17, this.ual);
            }
            aVar.ai(18, this.uam);
            if (this.thumbUrl != null) {
                aVar.e(19, this.thumbUrl);
            }
            if (this.uan != null) {
                aVar.e(20, this.uan);
            }
            AppMethodBeat.o(55714);
            return 0;
        } else if (i == 1) {
            if (this.uaa != null) {
                f = e.a.a.b.b.a.f(1, this.uaa) + 0;
            } else {
                f = 0;
            }
            if (this.uab != null) {
                f += e.a.a.b.b.a.f(2, this.uab);
            }
            if (this.uac != null) {
                f += e.a.a.b.b.a.f(3, this.uac);
            }
            if (this.uad != null) {
                f += e.a.a.b.b.a.f(4, this.uad);
            }
            f += e.a.a.b.b.a.o(5, this.uae);
            if (this.uai != null) {
                f += e.a.a.b.b.a.f(6, this.uai);
            }
            if (this.lvz != null) {
                f += e.a.a.b.b.a.f(7, this.lvz);
            }
            if (this.lvA != null) {
                f += e.a.a.b.b.a.f(8, this.lvA);
            }
            if (this.qVw != null) {
                f += e.a.a.b.b.a.f(9, this.qVw);
            }
            if (this.uaf != null) {
                f += e.a.a.b.b.a.f(10, this.uaf);
            }
            if (this.uag != null) {
                f += e.a.a.b.b.a.f(11, this.uag);
            }
            if (this.uah != null) {
                f += e.a.a.b.b.a.f(12, this.uah);
            }
            if (this.source != null) {
                f += e.a.a.b.b.a.f(13, this.source);
            }
            if (this.phw != null) {
                f += e.a.a.b.b.a.f(14, this.phw);
            }
            if (this.uaj != null) {
                f += e.a.a.b.b.a.f(15, this.uaj);
            }
            if (this.uak != null) {
                f += e.a.a.b.b.a.f(16, this.uak);
            }
            if (this.ual != null) {
                f += e.a.a.b.b.a.f(17, this.ual);
            }
            f += e.a.a.b.b.a.o(18, this.uam);
            if (this.thumbUrl != null) {
                f += e.a.a.b.b.a.f(19, this.thumbUrl);
            }
            if (this.uan != null) {
                f += e.a.a.b.b.a.f(20, this.uan);
            }
            AppMethodBeat.o(55714);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(55714);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cvi cvi = (cvi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cvi.uaa = aVar3.BTU.readString();
                    AppMethodBeat.o(55714);
                    return 0;
                case 2:
                    cvi.uab = aVar3.BTU.readString();
                    AppMethodBeat.o(55714);
                    return 0;
                case 3:
                    cvi.uac = aVar3.BTU.readString();
                    AppMethodBeat.o(55714);
                    return 0;
                case 4:
                    cvi.uad = aVar3.BTU.readString();
                    AppMethodBeat.o(55714);
                    return 0;
                case 5:
                    cvi.uae = aVar3.BTU.ve();
                    AppMethodBeat.o(55714);
                    return 0;
                case 6:
                    cvi.uai = aVar3.BTU.readString();
                    AppMethodBeat.o(55714);
                    return 0;
                case 7:
                    cvi.lvz = aVar3.BTU.readString();
                    AppMethodBeat.o(55714);
                    return 0;
                case 8:
                    cvi.lvA = aVar3.BTU.readString();
                    AppMethodBeat.o(55714);
                    return 0;
                case 9:
                    cvi.qVw = aVar3.BTU.readString();
                    AppMethodBeat.o(55714);
                    return 0;
                case 10:
                    cvi.uaf = aVar3.BTU.readString();
                    AppMethodBeat.o(55714);
                    return 0;
                case 11:
                    cvi.uag = aVar3.BTU.readString();
                    AppMethodBeat.o(55714);
                    return 0;
                case 12:
                    cvi.uah = aVar3.BTU.readString();
                    AppMethodBeat.o(55714);
                    return 0;
                case 13:
                    cvi.source = aVar3.BTU.readString();
                    AppMethodBeat.o(55714);
                    return 0;
                case 14:
                    cvi.phw = aVar3.BTU.readString();
                    AppMethodBeat.o(55714);
                    return 0;
                case 15:
                    cvi.uaj = aVar3.BTU.readString();
                    AppMethodBeat.o(55714);
                    return 0;
                case 16:
                    cvi.uak = aVar3.BTU.readString();
                    AppMethodBeat.o(55714);
                    return 0;
                case 17:
                    cvi.ual = aVar3.BTU.readString();
                    AppMethodBeat.o(55714);
                    return 0;
                case 18:
                    cvi.uam = aVar3.BTU.ve();
                    AppMethodBeat.o(55714);
                    return 0;
                case 19:
                    cvi.thumbUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(55714);
                    return 0;
                case 20:
                    cvi.uan = aVar3.BTU.readString();
                    AppMethodBeat.o(55714);
                    return 0;
                default:
                    AppMethodBeat.o(55714);
                    return -1;
            }
        } else {
            AppMethodBeat.o(55714);
            return -1;
        }
    }
}
