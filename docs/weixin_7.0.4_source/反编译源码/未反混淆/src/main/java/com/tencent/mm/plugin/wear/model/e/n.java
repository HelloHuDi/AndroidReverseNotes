package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.h;
import java.util.ArrayList;
import java.util.List;

public final class n extends a {
    public final List<Integer> cUA() {
        AppMethodBeat.i(26414);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11033));
        arrayList.add(Integer.valueOf(11030));
        AppMethodBeat.o(26414);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    public final byte[] p(int i, byte[] bArr) {
        AppMethodBeat.i(26415);
        byte[] adx;
        switch (i) {
            case 11030:
                if (new String(bArr).equals("arm_v7")) {
                    adx = h.adx("wechatvoicesilk_v7a");
                    AppMethodBeat.o(26415);
                    return adx;
                }
                adx = h.adx("wechatvoicesilk");
                AppMethodBeat.o(26415);
                return adx;
            case 11033:
                adx = h.adx("stlport_shared");
                AppMethodBeat.o(26415);
                return adx;
            default:
                AppMethodBeat.o(26415);
                return null;
        }
    }
}
