package com.tencent.mm.plugin.wear.model.f;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.b;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.cts;
import com.tencent.mm.protocal.protobuf.ctt;
import com.tencent.mm.sdk.platformtools.ah;
import java.io.IOException;

public final class f extends c {
    private String nickname;
    private int type;
    private String username;

    public f(String str, String str2, int i) {
        this.username = str;
        this.nickname = str2;
        this.type = i;
    }

    public final String getName() {
        return "WearFriendCreateTask";
    }

    /* Access modifiers changed, original: protected|final */
    public final void send() {
        AppMethodBeat.i(26444);
        com.tencent.mm.plugin.wear.model.f adr = a.cUn().tXv.adr(this.username);
        ctt ctt = new ctt();
        if (this.type == 1) {
            cts cts = new cts();
            cts.ndE = adr.id;
            cts.jBB = this.username;
            cts.jCH = this.nickname;
            cts.ncM = ah.getContext().getString(R.string.d9s);
            Bitmap a = b.a(this.username, false, -1);
            if (a != null) {
                cts.xqr = new com.tencent.mm.bt.b(h.ad(a));
            }
            ctt.jBw.add(cts);
        }
        try {
            a.cUn();
            r.b(20006, ctt.toByteArray(), true);
            AppMethodBeat.o(26444);
        } catch (IOException e) {
            AppMethodBeat.o(26444);
        }
    }
}
