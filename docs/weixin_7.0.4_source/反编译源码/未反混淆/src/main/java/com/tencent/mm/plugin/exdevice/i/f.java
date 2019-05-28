package com.tencent.mm.plugin.exdevice.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.b.e;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.d;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ab;

public final class f extends ae {
    private e lxA;
    private a lxB;
    private int mErrorCode;

    public f(int i, long j, int i2, int i3, byte[] bArr) {
        AppMethodBeat.i(19734);
        this.lxA = new e(j, i2, i3, bArr);
        this.mErrorCode = i;
        AppMethodBeat.o(19734);
    }

    public final boolean a(m mVar, d dVar) {
        AppMethodBeat.i(19735);
        if (!u.bpx().hX(this.lxA.jJa)) {
            ab.e("MicroMsg.exdevice.MMInitTaskExcuter", "This device send other cmd before do auth, device id = %d", Long.valueOf(this.lxA.jJa));
            this.lxA.a(-2, "", new byte[0], new byte[0], 0, 0);
            this.lxB = new a(this.lxA, dVar);
            ab.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", Boolean.valueOf(this.lxB.b(mVar)));
            AppMethodBeat.o(19735);
            return this.lxB.b(mVar);
        } else if (-5 == this.mErrorCode || -3 == this.mErrorCode || -4 == this.mErrorCode) {
            ab.e("MicroMsg.exdevice.MMInitTaskExcuter", "Error Code = %d, reply errorcode to device and close channel", Integer.valueOf(this.mErrorCode));
            this.lxA.a(-1, "", new byte[0], new byte[0], 0, 0);
            this.lxB = new a(this.lxA, dVar);
            ab.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", Boolean.valueOf(this.lxB.b(mVar)));
            AppMethodBeat.o(19735);
            return this.lxB.b(mVar);
        } else {
            com.tencent.mm.plugin.exdevice.e.f fVar = (com.tencent.mm.plugin.exdevice.e.f) this.lxA.bou();
            if (fVar == null) {
                ab.e("MicroMsg.exdevice.MMInitTaskExcuter", "Init Request parse failed, Tell device before stop this task");
                this.lxA.a(-4, "", new byte[0], new byte[0], 0, 0);
                this.lxB = new a(this.lxA, dVar);
                ab.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", Boolean.valueOf(this.lxB.b(mVar)));
                AppMethodBeat.o(19735);
                return this.lxB.b(mVar);
            }
            byte[] toByteArray;
            byte[] toByteArray2;
            if (fVar.luW != null) {
                toByteArray = fVar.luW.toByteArray();
            } else {
                toByteArray = null;
            }
            if (fVar.luV != null) {
                toByteArray2 = fVar.luV.toByteArray();
            } else {
                toByteArray2 = null;
            }
            ad.bpd();
            int boE = d.boE();
            switch (boE) {
                case 1:
                case 2:
                    break;
                default:
                    ab.e("MicroMsg.exdevice.MMInitTaskExcuter", "initScene = %d, Cannot start init response", Integer.valueOf(boE));
                    break;
            }
            this.lxA.a(0, null, toByteArray2, toByteArray, boE, (int) (b.bqi() / 1000));
            this.lxB = new a(this.lxA, dVar);
            boolean b = this.lxB.b(mVar);
            AppMethodBeat.o(19735);
            return b;
        }
    }
}
