package com.tencent.mm.plugin.account.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.v;
import com.tencent.mm.plugin.account.model.h.a;
import com.tencent.mm.sdk.platformtools.ab;

public class i implements f, a {
    public void p(Bundle bundle) {
        AppMethodBeat.i(124695);
        Object string = bundle.getString("access_token");
        Object string2 = bundle.getString("expires");
        ab.i("MicroMsg.RefreshTokenListener", "onComplete : newToken = " + string + ", expires = " + string2);
        if (string2 != null) {
            g.RP().Ry().set(65832, string2);
        }
        g.RP().Ry().set(65830, string);
        g.RP().Ry().set(65831, Long.valueOf(System.currentTimeMillis()));
        g.Rg().a(183, (f) this);
        g.Rg().a(new v(2, string), 0);
        AppMethodBeat.o(124695);
    }

    public void onError(int i, String str) {
        AppMethodBeat.i(124696);
        ab.e("MicroMsg.RefreshTokenListener", "onError : errType = " + i + ", errMsg = " + str);
        AppMethodBeat.o(124696);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(124697);
        if (mVar.getType() != 183) {
            AppMethodBeat.o(124697);
            return;
        }
        g.Rg().b(183, (f) this);
        if (i == 0 && i2 == 0) {
            ab.i("MicroMsg.RefreshTokenListener", "update token success");
            AppMethodBeat.o(124697);
            return;
        }
        ab.e("MicroMsg.RefreshTokenListener", "update token fail");
        AppMethodBeat.o(124697);
    }
}
