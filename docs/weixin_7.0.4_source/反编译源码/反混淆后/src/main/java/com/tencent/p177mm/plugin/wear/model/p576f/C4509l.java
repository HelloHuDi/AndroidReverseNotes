package com.tencent.p177mm.plugin.wear.model.p576f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wear.model.C43841a;
import com.tencent.p177mm.plugin.wear.model.C43845h;
import com.tencent.p177mm.plugin.wear.model.p575e.C40185r;
import com.tencent.p177mm.protocal.protobuf.cuz;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/* renamed from: com.tencent.mm.plugin.wear.model.f.l */
public final class C4509l extends C29724c {
    private int tXZ;
    private String talker;

    public C4509l(int i, String str) {
        this.tXZ = i;
        this.talker = str;
    }

    public final String getName() {
        return "WearVoipControllerTask";
    }

    /* Access modifiers changed, original: protected|final */
    public final void send() {
        AppMethodBeat.m2504i(26452);
        switch (this.tXZ) {
            case 20010:
                cuz cuz = new cuz();
                cuz.wyw = this.talker;
                cuz.jCH = C43845h.adw(this.talker);
                try {
                    C43841a.cUn();
                    C40185r.m68920b(this.tXZ, cuz.toByteArray(), false);
                    AppMethodBeat.m2505o(26452);
                    return;
                } catch (IOException e) {
                    AppMethodBeat.m2505o(26452);
                    return;
                }
            case 20011:
            case 20012:
                try {
                    C43841a.cUn();
                    C40185r.m68920b(this.tXZ, this.talker.getBytes("utf8"), false);
                    AppMethodBeat.m2505o(26452);
                    return;
                } catch (UnsupportedEncodingException e2) {
                    break;
                }
        }
        AppMethodBeat.m2505o(26452);
    }
}
