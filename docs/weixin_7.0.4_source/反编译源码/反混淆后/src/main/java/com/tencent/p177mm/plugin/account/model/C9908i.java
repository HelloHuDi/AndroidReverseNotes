package com.tencent.p177mm.plugin.account.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.account.friend.p272a.C32967v;
import com.tencent.p177mm.plugin.account.model.C26603h.C26604a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.account.model.i */
public class C9908i implements C1202f, C26604a {
    /* renamed from: p */
    public void mo21265p(Bundle bundle) {
        AppMethodBeat.m2504i(124695);
        Object string = bundle.getString("access_token");
        Object string2 = bundle.getString("expires");
        C4990ab.m7416i("MicroMsg.RefreshTokenListener", "onComplete : newToken = " + string + ", expires = " + string2);
        if (string2 != null) {
            C1720g.m3536RP().mo5239Ry().set(65832, string2);
        }
        C1720g.m3536RP().mo5239Ry().set(65830, string);
        C1720g.m3536RP().mo5239Ry().set(65831, Long.valueOf(System.currentTimeMillis()));
        C1720g.m3540Rg().mo14539a(183, (C1202f) this);
        C1720g.m3540Rg().mo14541a(new C32967v(2, string), 0);
        AppMethodBeat.m2505o(124695);
    }

    public void onError(int i, String str) {
        AppMethodBeat.m2504i(124696);
        C4990ab.m7412e("MicroMsg.RefreshTokenListener", "onError : errType = " + i + ", errMsg = " + str);
        AppMethodBeat.m2505o(124696);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(124697);
        if (c1207m.getType() != 183) {
            AppMethodBeat.m2505o(124697);
            return;
        }
        C1720g.m3540Rg().mo14546b(183, (C1202f) this);
        if (i == 0 && i2 == 0) {
            C4990ab.m7416i("MicroMsg.RefreshTokenListener", "update token success");
            AppMethodBeat.m2505o(124697);
            return;
        }
        C4990ab.m7412e("MicroMsg.RefreshTokenListener", "update token fail");
        AppMethodBeat.m2505o(124697);
    }
}
