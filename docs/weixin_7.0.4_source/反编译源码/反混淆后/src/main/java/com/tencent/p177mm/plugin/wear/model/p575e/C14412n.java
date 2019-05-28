package com.tencent.p177mm.plugin.wear.model.p575e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wear.model.C43845h;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wear.model.e.n */
public final class C14412n extends C46394a {
    public final List<Integer> cUA() {
        AppMethodBeat.m2504i(26414);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11033));
        arrayList.add(Integer.valueOf(11030));
        AppMethodBeat.m2505o(26414);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: p */
    public final byte[] mo9572p(int i, byte[] bArr) {
        AppMethodBeat.m2504i(26415);
        byte[] adx;
        switch (i) {
            case 11030:
                if (new String(bArr).equals("arm_v7")) {
                    adx = C43845h.adx("wechatvoicesilk_v7a");
                    AppMethodBeat.m2505o(26415);
                    return adx;
                }
                adx = C43845h.adx("wechatvoicesilk");
                AppMethodBeat.m2505o(26415);
                return adx;
            case 11033:
                adx = C43845h.adx("stlport_shared");
                AppMethodBeat.m2505o(26415);
                return adx;
            default:
                AppMethodBeat.m2505o(26415);
                return null;
        }
    }
}
