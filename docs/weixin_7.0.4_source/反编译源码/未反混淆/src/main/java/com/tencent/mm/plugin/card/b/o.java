package com.tencent.mm.plugin.card.b;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j;
import com.tencent.mm.g.a.qn;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.card.compat.a.a;
import com.tencent.mm.plugin.card.d.g;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class o extends c<qn> {
    public o() {
        AppMethodBeat.i(87770);
        this.xxI = qn.class.getName().hashCode();
        AppMethodBeat.o(87770);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(87771);
        qn qnVar = (qn) bVar;
        if (qnVar instanceof qn) {
            String str = qnVar.cMG.cDt;
            long j = qnVar.cMG.cuQ;
            String str2 = qnVar.cMG.cDu;
            d Hi = g.Hi(str);
            if (Hi == null) {
                ab.e("ShareCardEventListener", "item == null");
            } else if (TextUtils.isEmpty(str)) {
                ab.e("ShareCardEventListener", "cardAppMsg is empty");
            } else {
                j.b me = j.b.me(((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().jf(j).field_content);
                if (me != null) {
                    me.fhB = g.a(Hi);
                    me.cDt = str;
                    me.fhC = Hi.kdg;
                    me.fhD = Hi.cME;
                    me.fhE = Hi.iAd;
                    byte[] bArr = null;
                    Bitmap a = x.a(new m(me.thumburl));
                    if (a != null) {
                        bArr = com.tencent.mm.sdk.platformtools.d.ai(a);
                    }
                    ((a) com.tencent.mm.kernel.g.K(a.class)).b(me, me.appId, Hi.kdg, str2, bArr);
                    AppMethodBeat.o(87771);
                    return true;
                }
            }
        }
        AppMethodBeat.o(87771);
        return false;
    }
}
