package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;
import org.xwalk.core.XWalkCoreWrapper;

public final class as extends a {
    public LinkedList<bha> ckO = new LinkedList();
    public String vCq;
    public LinkedList<bhb> vCr = new LinkedList();

    public as() {
        AppMethodBeat.i(80004);
        AppMethodBeat.o(80004);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(XWalkCoreWrapper.INVOKE_RUNTIME_ID_SET_RUNTIME_TO_SDK_CHANNEL);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vCq != null) {
                aVar.e(1, this.vCq);
            }
            aVar.e(2, 8, this.vCr);
            aVar.e(3, 8, this.ckO);
            AppMethodBeat.o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_SET_RUNTIME_TO_SDK_CHANNEL);
            return 0;
        } else if (i == 1) {
            if (this.vCq != null) {
                f = e.a.a.b.b.a.f(1, this.vCq) + 0;
            } else {
                f = 0;
            }
            int c = (f + e.a.a.a.c(2, 8, this.vCr)) + e.a.a.a.c(3, 8, this.ckO);
            AppMethodBeat.o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_SET_RUNTIME_TO_SDK_CHANNEL);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vCr.clear();
            this.ckO.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_SET_RUNTIME_TO_SDK_CHANNEL);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            as asVar = (as) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    asVar.vCq = aVar3.BTU.readString();
                    AppMethodBeat.o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_SET_RUNTIME_TO_SDK_CHANNEL);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bhb bhb = new bhb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhb.populateBuilderWithField(aVar4, bhb, a.getNextFieldNumber(aVar4))) {
                        }
                        asVar.vCr.add(bhb);
                    }
                    AppMethodBeat.o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_SET_RUNTIME_TO_SDK_CHANNEL);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bha bha = new bha();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bha.populateBuilderWithField(aVar4, bha, a.getNextFieldNumber(aVar4))) {
                        }
                        asVar.ckO.add(bha);
                    }
                    AppMethodBeat.o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_SET_RUNTIME_TO_SDK_CHANNEL);
                    return 0;
                default:
                    AppMethodBeat.o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_SET_RUNTIME_TO_SDK_CHANNEL);
                    return -1;
            }
        } else {
            AppMethodBeat.o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_SET_RUNTIME_TO_SDK_CHANNEL);
            return -1;
        }
    }
}
