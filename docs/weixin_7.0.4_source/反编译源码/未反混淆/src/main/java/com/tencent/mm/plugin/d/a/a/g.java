package com.tencent.mm.plugin.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class g extends j {
    private byte jFm = (byte) 0;

    /* Access modifiers changed, original: final */
    public final boolean as(byte[] bArr) {
        AppMethodBeat.i(18356);
        if (bo.cb(bArr)) {
            ab.e("MicroMsg.exdevice.IBeaconTLVSectionA", "valueByte is null or nil");
            AppMethodBeat.o(18356);
            return false;
        } else if (2 != this.mLength) {
            ab.d("MicroMsg.exdevice.IBeaconTLVSectionA", "IBEACON_TLV_SECTION_A_LENGTH != mLength(%d)", Integer.valueOf(this.mLength));
            AppMethodBeat.o(18356);
            return false;
        } else {
            this.jFm = bArr[0];
            AppMethodBeat.o(18356);
            return true;
        }
    }
}
