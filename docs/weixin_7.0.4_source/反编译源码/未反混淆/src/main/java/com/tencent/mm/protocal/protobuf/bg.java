package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;
import org.xwalk.core.XWalkCoreWrapper;

public final class bg extends a {
    public String mZr;
    public String nad;
    public String ncH;
    public String vDk;
    public String vDl;
    public String vDm;
    public String vDn;
    public String vDo;
    public String vDp;
    public cyf vDq;
    public String vDr;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.mZr != null) {
                aVar.e(1, this.mZr);
            }
            if (this.vDk != null) {
                aVar.e(2, this.vDk);
            }
            if (this.vDl != null) {
                aVar.e(3, this.vDl);
            }
            if (this.nad != null) {
                aVar.e(4, this.nad);
            }
            if (this.ncH != null) {
                aVar.e(5, this.ncH);
            }
            if (this.vDm != null) {
                aVar.e(6, this.vDm);
            }
            if (this.vDn != null) {
                aVar.e(7, this.vDn);
            }
            if (this.vDo != null) {
                aVar.e(8, this.vDo);
            }
            if (this.vDp != null) {
                aVar.e(9, this.vDp);
            }
            if (this.vDq != null) {
                aVar.iy(10, this.vDq.computeSize());
                this.vDq.writeFields(aVar);
            }
            if (this.vDr != null) {
                aVar.e(11, this.vDr);
            }
            AppMethodBeat.o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN);
            return 0;
        } else if (i == 1) {
            if (this.mZr != null) {
                f = e.a.a.b.b.a.f(1, this.mZr) + 0;
            } else {
                f = 0;
            }
            if (this.vDk != null) {
                f += e.a.a.b.b.a.f(2, this.vDk);
            }
            if (this.vDl != null) {
                f += e.a.a.b.b.a.f(3, this.vDl);
            }
            if (this.nad != null) {
                f += e.a.a.b.b.a.f(4, this.nad);
            }
            if (this.ncH != null) {
                f += e.a.a.b.b.a.f(5, this.ncH);
            }
            if (this.vDm != null) {
                f += e.a.a.b.b.a.f(6, this.vDm);
            }
            if (this.vDn != null) {
                f += e.a.a.b.b.a.f(7, this.vDn);
            }
            if (this.vDo != null) {
                f += e.a.a.b.b.a.f(8, this.vDo);
            }
            if (this.vDp != null) {
                f += e.a.a.b.b.a.f(9, this.vDp);
            }
            if (this.vDq != null) {
                f += e.a.a.a.ix(10, this.vDq.computeSize());
            }
            if (this.vDr != null) {
                f += e.a.a.b.b.a.f(11, this.vDr);
            }
            AppMethodBeat.o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bg bgVar = (bg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bgVar.mZr = aVar3.BTU.readString();
                    AppMethodBeat.o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN);
                    return 0;
                case 2:
                    bgVar.vDk = aVar3.BTU.readString();
                    AppMethodBeat.o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN);
                    return 0;
                case 3:
                    bgVar.vDl = aVar3.BTU.readString();
                    AppMethodBeat.o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN);
                    return 0;
                case 4:
                    bgVar.nad = aVar3.BTU.readString();
                    AppMethodBeat.o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN);
                    return 0;
                case 5:
                    bgVar.ncH = aVar3.BTU.readString();
                    AppMethodBeat.o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN);
                    return 0;
                case 6:
                    bgVar.vDm = aVar3.BTU.readString();
                    AppMethodBeat.o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN);
                    return 0;
                case 7:
                    bgVar.vDn = aVar3.BTU.readString();
                    AppMethodBeat.o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN);
                    return 0;
                case 8:
                    bgVar.vDo = aVar3.BTU.readString();
                    AppMethodBeat.o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN);
                    return 0;
                case 9:
                    bgVar.vDp = aVar3.BTU.readString();
                    AppMethodBeat.o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN);
                    return 0;
                case 10:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        cyf cyf = new cyf();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cyf.populateBuilderWithField(aVar4, cyf, a.getNextFieldNumber(aVar4))) {
                        }
                        bgVar.vDq = cyf;
                    }
                    AppMethodBeat.o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN);
                    return 0;
                case 11:
                    bgVar.vDr = aVar3.BTU.readString();
                    AppMethodBeat.o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN);
                    return 0;
                default:
                    AppMethodBeat.o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN);
                    return -1;
            }
        } else {
            AppMethodBeat.o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN);
            return -1;
        }
    }
}
