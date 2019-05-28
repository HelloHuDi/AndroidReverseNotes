package com.tencent.mm.plugin.talkroom.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cgm;
import e.a.a.b;
import java.util.LinkedList;

public final class a extends com.tencent.mm.bt.a {
    public LinkedList<cgm> cGh = new LinkedList();
    public int sceneType;
    public String username;

    public a() {
        AppMethodBeat.i(25750);
        AppMethodBeat.o(25750);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(25751);
        b bVar;
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.username == null) {
                bVar = new b("Not all required fields were included: username");
                AppMethodBeat.o(25751);
                throw bVar;
            }
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            aVar.e(2, 8, this.cGh);
            aVar.iz(3, this.sceneType);
            AppMethodBeat.o(25751);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                f = e.a.a.b.b.a.f(1, this.username) + 0;
            } else {
                f = 0;
            }
            int c = (f + e.a.a.a.c(2, 8, this.cGh)) + e.a.a.b.b.a.bs(3, this.sceneType);
            AppMethodBeat.o(25751);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.cGh.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); f > 0; f = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.username == null) {
                bVar = new b("Not all required fields were included: username");
                AppMethodBeat.o(25751);
                throw bVar;
            }
            AppMethodBeat.o(25751);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aVar4.username = aVar3.BTU.readString();
                    AppMethodBeat.o(25751);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgm cgm = new cgm();
                        e.a.a.a.a aVar5 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cgm.populateBuilderWithField(aVar5, cgm, com.tencent.mm.bt.a.getNextFieldNumber(aVar5))) {
                        }
                        aVar4.cGh.add(cgm);
                    }
                    AppMethodBeat.o(25751);
                    return 0;
                case 3:
                    aVar4.sceneType = aVar3.BTU.vd();
                    AppMethodBeat.o(25751);
                    return 0;
                default:
                    AppMethodBeat.o(25751);
                    return -1;
            }
        } else {
            AppMethodBeat.o(25751);
            return -1;
        }
    }
}
