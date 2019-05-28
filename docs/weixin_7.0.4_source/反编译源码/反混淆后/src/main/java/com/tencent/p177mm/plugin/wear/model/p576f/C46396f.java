package com.tencent.p177mm.plugin.wear.model.p576f;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.wear.model.C22742f;
import com.tencent.p177mm.plugin.wear.model.C43841a;
import com.tencent.p177mm.plugin.wear.model.C43845h;
import com.tencent.p177mm.plugin.wear.model.p575e.C40185r;
import com.tencent.p177mm.protocal.protobuf.cts;
import com.tencent.p177mm.protocal.protobuf.ctt;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.wear.model.f.f */
public final class C46396f extends C29724c {
    private String nickname;
    private int type;
    private String username;

    public C46396f(String str, String str2, int i) {
        this.username = str;
        this.nickname = str2;
        this.type = i;
    }

    public final String getName() {
        return "WearFriendCreateTask";
    }

    /* Access modifiers changed, original: protected|final */
    public final void send() {
        AppMethodBeat.m2504i(26444);
        C22742f adr = C43841a.cUn().tXv.adr(this.username);
        ctt ctt = new ctt();
        if (this.type == 1) {
            cts cts = new cts();
            cts.ndE = adr.f4403id;
            cts.jBB = this.username;
            cts.jCH = this.nickname;
            cts.ncM = C4996ah.getContext().getString(C25738R.string.d9s);
            Bitmap a = C41730b.m73490a(this.username, false, -1);
            if (a != null) {
                cts.xqr = new C1332b(C43845h.m78627ad(a));
            }
            ctt.jBw.add(cts);
        }
        try {
            C43841a.cUn();
            C40185r.m68920b(20006, ctt.toByteArray(), true);
            AppMethodBeat.m2505o(26444);
        } catch (IOException e) {
            AppMethodBeat.m2505o(26444);
        }
    }
}
