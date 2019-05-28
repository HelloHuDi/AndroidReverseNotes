package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;
import java.util.LinkedList;

public final class fh extends a {
    public fi vHg;
    public fj vHm;
    public b vHn;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28320);
        e.a.a.b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vHm == null) {
                bVar = new e.a.a.b("Not all required fields were included: VoiceAttr");
                AppMethodBeat.o(28320);
                throw bVar;
            } else if (this.vHg == null) {
                bVar = new e.a.a.b("Not all required fields were included: UploadCtx");
                AppMethodBeat.o(28320);
                throw bVar;
            } else if (this.vHn == null) {
                bVar = new e.a.a.b("Not all required fields were included: VoiceData");
                AppMethodBeat.o(28320);
                throw bVar;
            } else {
                if (this.vHm != null) {
                    aVar.iy(1, this.vHm.computeSize());
                    this.vHm.writeFields(aVar);
                }
                if (this.vHg != null) {
                    aVar.iy(2, this.vHg.computeSize());
                    this.vHg.writeFields(aVar);
                }
                if (this.vHn != null) {
                    aVar.c(3, this.vHn);
                }
                AppMethodBeat.o(28320);
                return 0;
            }
        } else if (i == 1) {
            if (this.vHm != null) {
                ix = e.a.a.a.ix(1, this.vHm.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vHg != null) {
                ix += e.a.a.a.ix(2, this.vHg.computeSize());
            }
            if (this.vHn != null) {
                ix += e.a.a.b.b.a.b(3, this.vHn);
            }
            AppMethodBeat.o(28320);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.vHm == null) {
                bVar = new e.a.a.b("Not all required fields were included: VoiceAttr");
                AppMethodBeat.o(28320);
                throw bVar;
            } else if (this.vHg == null) {
                bVar = new e.a.a.b("Not all required fields were included: UploadCtx");
                AppMethodBeat.o(28320);
                throw bVar;
            } else if (this.vHn == null) {
                bVar = new e.a.a.b("Not all required fields were included: VoiceData");
                AppMethodBeat.o(28320);
                throw bVar;
            } else {
                AppMethodBeat.o(28320);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            fh fhVar = (fh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        fj fjVar = new fj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fjVar.populateBuilderWithField(aVar4, fjVar, a.getNextFieldNumber(aVar4))) {
                        }
                        fhVar.vHm = fjVar;
                    }
                    AppMethodBeat.o(28320);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        fi fiVar = new fi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.populateBuilderWithField(aVar4, fiVar, a.getNextFieldNumber(aVar4))) {
                        }
                        fhVar.vHg = fiVar;
                    }
                    AppMethodBeat.o(28320);
                    return 0;
                case 3:
                    fhVar.vHn = aVar3.BTU.emu();
                    AppMethodBeat.o(28320);
                    return 0;
                default:
                    AppMethodBeat.o(28320);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28320);
            return -1;
        }
    }
}
