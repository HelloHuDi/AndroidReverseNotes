package com.tencent.p177mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C21279r;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C21280t;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.protocal.protobuf.C40573tb;
import com.tencent.p177mm.protocal.protobuf.C46592vg;

/* renamed from: com.tencent.mm.plugin.messenger.foundation.b */
public final class C46072b implements C21279r {
    /* renamed from: a */
    public final void mo36640a(C40573tb c40573tb, byte[] bArr, boolean z, C21280t c21280t) {
        AppMethodBeat.m2504i(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        switch (c40573tb.wat) {
            case 7:
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoX(C1946aa.m4148a(((C46592vg) new C46592vg().parseFrom(bArr)).wcB));
                break;
        }
        AppMethodBeat.m2505o(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
    }
}
