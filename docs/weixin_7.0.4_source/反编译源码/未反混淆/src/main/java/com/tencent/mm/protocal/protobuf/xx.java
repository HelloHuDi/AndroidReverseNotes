package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class xx extends a {
    public String ActivityID;
    public String AesKey;
    public String EncryptUrl;
    public String ExternMd5;
    public String ExternUrl;
    public String Md5;
    public String ProductID;
    public String ThumbUrl;
    public String Url;
    public String wdC;
    public String wdD;
    public String wdE;
    public String wdF;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62523);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Md5 == null) {
                bVar = new b("Not all required fields were included: Md5");
                AppMethodBeat.o(62523);
                throw bVar;
            }
            if (this.Md5 != null) {
                aVar.e(1, this.Md5);
            }
            if (this.Url != null) {
                aVar.e(2, this.Url);
            }
            if (this.ThumbUrl != null) {
                aVar.e(3, this.ThumbUrl);
            }
            if (this.wdC != null) {
                aVar.e(4, this.wdC);
            }
            if (this.EncryptUrl != null) {
                aVar.e(5, this.EncryptUrl);
            }
            if (this.AesKey != null) {
                aVar.e(6, this.AesKey);
            }
            if (this.ProductID != null) {
                aVar.e(7, this.ProductID);
            }
            if (this.ExternUrl != null) {
                aVar.e(8, this.ExternUrl);
            }
            if (this.ExternMd5 != null) {
                aVar.e(9, this.ExternMd5);
            }
            if (this.ActivityID != null) {
                aVar.e(10, this.ActivityID);
            }
            if (this.wdD != null) {
                aVar.e(11, this.wdD);
            }
            if (this.wdE != null) {
                aVar.e(12, this.wdE);
            }
            if (this.wdF != null) {
                aVar.e(13, this.wdF);
            }
            AppMethodBeat.o(62523);
            return 0;
        } else if (i == 1) {
            if (this.Md5 != null) {
                f = e.a.a.b.b.a.f(1, this.Md5) + 0;
            } else {
                f = 0;
            }
            if (this.Url != null) {
                f += e.a.a.b.b.a.f(2, this.Url);
            }
            if (this.ThumbUrl != null) {
                f += e.a.a.b.b.a.f(3, this.ThumbUrl);
            }
            if (this.wdC != null) {
                f += e.a.a.b.b.a.f(4, this.wdC);
            }
            if (this.EncryptUrl != null) {
                f += e.a.a.b.b.a.f(5, this.EncryptUrl);
            }
            if (this.AesKey != null) {
                f += e.a.a.b.b.a.f(6, this.AesKey);
            }
            if (this.ProductID != null) {
                f += e.a.a.b.b.a.f(7, this.ProductID);
            }
            if (this.ExternUrl != null) {
                f += e.a.a.b.b.a.f(8, this.ExternUrl);
            }
            if (this.ExternMd5 != null) {
                f += e.a.a.b.b.a.f(9, this.ExternMd5);
            }
            if (this.ActivityID != null) {
                f += e.a.a.b.b.a.f(10, this.ActivityID);
            }
            if (this.wdD != null) {
                f += e.a.a.b.b.a.f(11, this.wdD);
            }
            if (this.wdE != null) {
                f += e.a.a.b.b.a.f(12, this.wdE);
            }
            if (this.wdF != null) {
                f += e.a.a.b.b.a.f(13, this.wdF);
            }
            AppMethodBeat.o(62523);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.Md5 == null) {
                bVar = new b("Not all required fields were included: Md5");
                AppMethodBeat.o(62523);
                throw bVar;
            }
            AppMethodBeat.o(62523);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            xx xxVar = (xx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    xxVar.Md5 = aVar3.BTU.readString();
                    AppMethodBeat.o(62523);
                    return 0;
                case 2:
                    xxVar.Url = aVar3.BTU.readString();
                    AppMethodBeat.o(62523);
                    return 0;
                case 3:
                    xxVar.ThumbUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(62523);
                    return 0;
                case 4:
                    xxVar.wdC = aVar3.BTU.readString();
                    AppMethodBeat.o(62523);
                    return 0;
                case 5:
                    xxVar.EncryptUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(62523);
                    return 0;
                case 6:
                    xxVar.AesKey = aVar3.BTU.readString();
                    AppMethodBeat.o(62523);
                    return 0;
                case 7:
                    xxVar.ProductID = aVar3.BTU.readString();
                    AppMethodBeat.o(62523);
                    return 0;
                case 8:
                    xxVar.ExternUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(62523);
                    return 0;
                case 9:
                    xxVar.ExternMd5 = aVar3.BTU.readString();
                    AppMethodBeat.o(62523);
                    return 0;
                case 10:
                    xxVar.ActivityID = aVar3.BTU.readString();
                    AppMethodBeat.o(62523);
                    return 0;
                case 11:
                    xxVar.wdD = aVar3.BTU.readString();
                    AppMethodBeat.o(62523);
                    return 0;
                case 12:
                    xxVar.wdE = aVar3.BTU.readString();
                    AppMethodBeat.o(62523);
                    return 0;
                case 13:
                    xxVar.wdF = aVar3.BTU.readString();
                    AppMethodBeat.o(62523);
                    return 0;
                default:
                    AppMethodBeat.o(62523);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62523);
            return -1;
        }
    }
}
