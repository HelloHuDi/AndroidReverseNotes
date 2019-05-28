package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.cuz;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class l extends c {
    private int tXZ;
    private String talker;

    public l(int i, String str) {
        this.tXZ = i;
        this.talker = str;
    }

    public final String getName() {
        return "WearVoipControllerTask";
    }

    /* Access modifiers changed, original: protected|final */
    public final void send() {
        AppMethodBeat.i(26452);
        switch (this.tXZ) {
            case 20010:
                cuz cuz = new cuz();
                cuz.wyw = this.talker;
                cuz.jCH = h.adw(this.talker);
                try {
                    a.cUn();
                    r.b(this.tXZ, cuz.toByteArray(), false);
                    AppMethodBeat.o(26452);
                    return;
                } catch (IOException e) {
                    AppMethodBeat.o(26452);
                    return;
                }
            case 20011:
            case 20012:
                try {
                    a.cUn();
                    r.b(this.tXZ, this.talker.getBytes("utf8"), false);
                    AppMethodBeat.o(26452);
                    return;
                } catch (UnsupportedEncodingException e2) {
                    break;
                }
        }
        AppMethodBeat.o(26452);
    }
}
