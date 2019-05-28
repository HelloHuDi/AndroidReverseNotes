package com.tencent.p177mm.plugin.p369d.p370a.p371a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.d.a.a.g */
public final class C45822g extends C38825j {
    private byte jFm = (byte) 0;

    /* Access modifiers changed, original: final */
    /* renamed from: as */
    public final boolean mo61708as(byte[] bArr) {
        AppMethodBeat.m2504i(18356);
        if (C5046bo.m7540cb(bArr)) {
            C4990ab.m7412e("MicroMsg.exdevice.IBeaconTLVSectionA", "valueByte is null or nil");
            AppMethodBeat.m2505o(18356);
            return false;
        } else if (2 != this.mLength) {
            C4990ab.m7411d("MicroMsg.exdevice.IBeaconTLVSectionA", "IBEACON_TLV_SECTION_A_LENGTH != mLength(%d)", Integer.valueOf(this.mLength));
            AppMethodBeat.m2505o(18356);
            return false;
        } else {
            this.jFm = bArr[0];
            AppMethodBeat.m2505o(18356);
            return true;
        }
    }
}
