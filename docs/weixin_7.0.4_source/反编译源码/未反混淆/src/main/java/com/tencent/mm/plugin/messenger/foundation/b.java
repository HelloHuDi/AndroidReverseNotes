package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.protocal.protobuf.vg;

public final class b implements r {
    public final void a(tb tbVar, byte[] bArr, boolean z, t tVar) {
        AppMethodBeat.i(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        switch (tbVar.wat) {
            case 7:
                ((j) g.K(j.class)).XR().aoX(aa.a(((vg) new vg().parseFrom(bArr)).wcB));
                break;
        }
        AppMethodBeat.o(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
    }
}
