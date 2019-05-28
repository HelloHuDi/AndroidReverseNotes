package com.tencent.mm.plugin.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.j.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class e {
    private final g jEN = new g();
    public final h jEO = new h();

    public e() {
        AppMethodBeat.i(18331);
        AppMethodBeat.o(18331);
    }

    public final boolean ar(byte[] bArr) {
        AppMethodBeat.i(18332);
        if (bo.cb(bArr)) {
            ab.e("MicroMsg.exdevice.IBeaconProtocal", "dataIn is null or nil");
            AppMethodBeat.o(18332);
            return false;
        }
        a aVar = new a(bArr.length);
        aVar.R(bArr, bArr.length);
        boolean a = this.jEN.a(aVar);
        if (a) {
            a = this.jEO.a(aVar);
            if (a) {
                AppMethodBeat.o(18332);
                return a;
            }
            ab.d("MicroMsg.exdevice.IBeaconProtocal", "mSectionB.ParseTLV Failed!!!");
            AppMethodBeat.o(18332);
            return a;
        }
        ab.d("MicroMsg.exdevice.IBeaconProtocal", "mSectionA.ParseTLV Failed!!!");
        AppMethodBeat.o(18332);
        return a;
    }
}
