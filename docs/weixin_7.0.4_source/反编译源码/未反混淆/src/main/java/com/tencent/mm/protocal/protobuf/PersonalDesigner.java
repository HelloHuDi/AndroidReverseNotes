package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public class PersonalDesigner extends a {
    public int DesignerUin;
    public String HeadUrl;
    public String Name;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62578);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.DesignerUin);
            if (this.Name != null) {
                aVar.e(2, this.Name);
            }
            if (this.HeadUrl != null) {
                aVar.e(3, this.HeadUrl);
            }
            AppMethodBeat.o(62578);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.DesignerUin) + 0;
            if (this.Name != null) {
                bs += e.a.a.b.b.a.f(2, this.Name);
            }
            if (this.HeadUrl != null) {
                bs += e.a.a.b.b.a.f(3, this.HeadUrl);
            }
            AppMethodBeat.o(62578);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(62578);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            PersonalDesigner personalDesigner = (PersonalDesigner) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    personalDesigner.DesignerUin = aVar3.BTU.vd();
                    AppMethodBeat.o(62578);
                    return 0;
                case 2:
                    personalDesigner.Name = aVar3.BTU.readString();
                    AppMethodBeat.o(62578);
                    return 0;
                case 3:
                    personalDesigner.HeadUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(62578);
                    return 0;
                default:
                    AppMethodBeat.o(62578);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62578);
            return -1;
        }
    }
}
