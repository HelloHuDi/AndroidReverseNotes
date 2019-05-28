package com.tencent.p177mm.plugin.p369d.p370a.p371a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42991a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.tencent.mm.plugin.d.a.a.h */
public final class C41263h extends C38825j {
    private static final byte[] jFn = new byte[]{(byte) 76, (byte) 0, (byte) 2, (byte) 21};
    private byte[] jFo = null;
    public byte[] jFp = null;
    public short jFq = (short) -1;
    public short jFr = (short) -1;
    public int jFs = 0;

    /* Access modifiers changed, original: final */
    /* renamed from: as */
    public final boolean mo61708as(byte[] bArr) {
        AppMethodBeat.m2504i(18357);
        if (C5046bo.m7540cb(bArr)) {
            C4990ab.m7412e("MicroMsg.exdevice.IBeaconTLVSectionB", "valueByte is null or nil");
            AppMethodBeat.m2505o(18357);
            return false;
        } else if (26 != this.mLength) {
            C4990ab.m7411d("MicroMsg.exdevice.IBeaconTLVSectionB", "IBEACON_TLV_SECTION_B_LENGTH != mLength(%d) ", Integer.valueOf(this.mLength));
            AppMethodBeat.m2505o(18357);
            return false;
        } else {
            C42991a c42991a = new C42991a(bArr.length);
            c42991a.mo68526R(bArr, bArr.length);
            byte[] bArr2 = new byte[4];
            c42991a.mo68525Q(bArr2, 4);
            if (Arrays.equals(bArr2, jFn)) {
                this.jFo = bArr2;
                this.jFp = new byte[16];
                c42991a.mo68525Q(this.jFp, 16);
                try {
                    this.jFq = c42991a.readShort();
                    this.jFr = c42991a.readShort();
                    bArr2 = new byte[1];
                    c42991a.mo68525Q(bArr2, 1);
                    this.jFs = bArr2[0];
                    AppMethodBeat.m2505o(18357);
                    return true;
                } catch (IOException e) {
                    C4990ab.m7410d("MicroMsg.exdevice.IBeaconTLVSectionB", "Read major/minor from autobuffer failed!!!");
                    C4990ab.printErrStackTrace("MicroMsg.exdevice.IBeaconTLVSectionB", e, "", new Object[0]);
                    AppMethodBeat.m2505o(18357);
                    return false;
                }
            }
            C4990ab.m7410d("MicroMsg.exdevice.IBeaconTLVSectionB", "Cannot find ibeacon cookies!!!");
            AppMethodBeat.m2505o(18357);
            return false;
        }
    }
}
