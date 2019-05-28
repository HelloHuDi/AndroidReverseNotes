package com.tencent.mm.plugin.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.j.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.util.Arrays;

public final class h extends j {
    private static final byte[] jFn = new byte[]{(byte) 76, (byte) 0, (byte) 2, (byte) 21};
    private byte[] jFo = null;
    public byte[] jFp = null;
    public short jFq = (short) -1;
    public short jFr = (short) -1;
    public int jFs = 0;

    /* Access modifiers changed, original: final */
    public final boolean as(byte[] bArr) {
        AppMethodBeat.i(18357);
        if (bo.cb(bArr)) {
            ab.e("MicroMsg.exdevice.IBeaconTLVSectionB", "valueByte is null or nil");
            AppMethodBeat.o(18357);
            return false;
        } else if (26 != this.mLength) {
            ab.d("MicroMsg.exdevice.IBeaconTLVSectionB", "IBEACON_TLV_SECTION_B_LENGTH != mLength(%d) ", Integer.valueOf(this.mLength));
            AppMethodBeat.o(18357);
            return false;
        } else {
            a aVar = new a(bArr.length);
            aVar.R(bArr, bArr.length);
            byte[] bArr2 = new byte[4];
            aVar.Q(bArr2, 4);
            if (Arrays.equals(bArr2, jFn)) {
                this.jFo = bArr2;
                this.jFp = new byte[16];
                aVar.Q(this.jFp, 16);
                try {
                    this.jFq = aVar.readShort();
                    this.jFr = aVar.readShort();
                    bArr2 = new byte[1];
                    aVar.Q(bArr2, 1);
                    this.jFs = bArr2[0];
                    AppMethodBeat.o(18357);
                    return true;
                } catch (IOException e) {
                    ab.d("MicroMsg.exdevice.IBeaconTLVSectionB", "Read major/minor from autobuffer failed!!!");
                    ab.printErrStackTrace("MicroMsg.exdevice.IBeaconTLVSectionB", e, "", new Object[0]);
                    AppMethodBeat.o(18357);
                    return false;
                }
            }
            ab.d("MicroMsg.exdevice.IBeaconTLVSectionB", "Cannot find ibeacon cookies!!!");
            AppMethodBeat.o(18357);
            return false;
        }
    }
}
