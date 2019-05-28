package com.tencent.p177mm.plugin.card.p352b;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p230g.p231a.C26220qn;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.plugin.card.compat.p1477a.C38733a;
import com.tencent.p177mm.plugin.card.model.C33770m;
import com.tencent.p177mm.plugin.card.model.C38743d;
import com.tencent.p177mm.plugin.card.p931d.C20134g;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5056d;

/* renamed from: com.tencent.mm.plugin.card.b.o */
public final class C33756o extends C4884c<C26220qn> {
    public C33756o() {
        AppMethodBeat.m2504i(87770);
        this.xxI = C26220qn.class.getName().hashCode();
        AppMethodBeat.m2505o(87770);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(87771);
        C26220qn c26220qn = (C26220qn) c4883b;
        if (c26220qn instanceof C26220qn) {
            String str = c26220qn.cMG.cDt;
            long j = c26220qn.cMG.cuQ;
            String str2 = c26220qn.cMG.cDu;
            C38743d Hi = C20134g.m31147Hi(str);
            if (Hi == null) {
                C4990ab.m7412e("ShareCardEventListener", "item == null");
            } else if (TextUtils.isEmpty(str)) {
                C4990ab.m7412e("ShareCardEventListener", "cardAppMsg is empty");
            } else {
                C8910b me = C8910b.m16064me(((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(j).field_content);
                if (me != null) {
                    me.fhB = C20134g.m31150a(Hi);
                    me.cDt = str;
                    me.fhC = Hi.kdg;
                    me.fhD = Hi.cME;
                    me.fhE = Hi.iAd;
                    byte[] bArr = null;
                    Bitmap a = C18764x.m29325a(new C33770m(me.thumburl));
                    if (a != null) {
                        bArr = C5056d.m7636ai(a);
                    }
                    ((C38733a) C1720g.m3528K(C38733a.class)).mo6838b(me, me.appId, Hi.kdg, str2, bArr);
                    AppMethodBeat.m2505o(87771);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(87771);
        return false;
    }
}
